package io.boodskap.iot.spi.storage.jpa.dao;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Query;

import io.boodskap.iot.OTABatchState;
import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.dao.OTABatchDAO;
import io.boodskap.iot.model.IOTABatch;
import io.boodskap.iot.model.jpa.OTABatch;
import io.boodskap.iot.model.jpa.OTABatchId;
import io.boodskap.iot.spi.storage.jpa.UOW;
import io.boodskap.iot.spi.storage.jpa.dao.util.CommonDAO;
import io.boodskap.iot.spi.storage.jpa.dao.util.DBUtil;
import io.boodskap.iot.spi.storage.jpa.dao.util.EntityIteratorImpl;

public class OTABatchDAOImpl implements OTABatchDAO<OTABatch> {
	
	private static final OTABatchDAO<OTABatch> dao = new OTABatchDAOImpl();
	
	protected OTABatchDAOImpl() {
	}
	
	public static final OTABatchDAO<OTABatch> get() {
		return dao;
	}

	@Override
	public OTABatch create(String domainKey, String batchId) {
		return new OTABatch(new OTABatchId(domainKey, batchId));
	}

	@Override
	public Class<? extends OTABatch> clazz() {
		return OTABatch.class;
	}

	@Override
	public void createOrUpdate(OTABatch e) throws StorageException {
		
		try {
			
			final IOTABatch oe = get(e.getDomainKey(), e.getBatchId());
			IOTABatch ne;
			
			if(null == oe) {
				ne = new OTABatch(new OTABatchId(e.getDomainKey(), e.getBatchId()));
				ne.setCreatedAt(new Date());
			}else {
				ne = oe;
			}
			
			UOW.begin();
			
			ne.setDescription(e.getDescription());
			ne.setExpireAt(e.getExpireAt());
			ne.setFinishedAt(e.getFinishedAt());
			ne.setFirmwareModel(e.getFirmwareModel());
			ne.setFirmwareVersion(e.getFirmwareVersion());
			ne.setName(e.getName());
			ne.setState(e.getState());
			ne.setUpdatedAt(new Date());
			
			if(null == oe) {
				UOW.persist(ne);
			}
			
			UOW.commit();
			
		}catch(Exception ex) {
			UOW.rollback();
			throw new StorageException(ex);
		}
	}

	@Override
	public EntityIterator<OTABatch> load() throws StorageException {
		return new EntityIteratorImpl<>(OTABatch.class, "id.batchId");
	}

	@Override
	public EntityIterator<OTABatch> load(String domainKey) throws StorageException {
		return new EntityIteratorImpl<>(OTABatch.class, domainKey, "id.batchId");
	}

	@Override
	public long count() throws StorageException {
		return new CommonDAO<>(OTABatch.class).count();
	}

	@Override
	public long count(String domainKey, OTABatchState[] states) throws StorageException {
		try {
			Query query = UOW.createNativeQuery(String.format("select count(v) from %s v where v.state in :states ", OTABatch.class.getSimpleName()));
			query.setParameter("states", Arrays.asList(states));
			return DBUtil.toCount(query.getSingleResult());
		}catch(Exception ex) {
			throw new StorageException(ex);
		}
	}

	@Override
	public OTABatch get(String domainKey, String batchId) throws StorageException {
		return new CommonDAO<>(OTABatch.class).find(new OTABatchId(domainKey, batchId));
	}

	@Override
	public void delete(String domainKey) throws StorageException {
		new CommonDAO<>(OTABatch.class).delete(domainKey);
	}

	@Override
	public void delete(String domainKey, String batchId) throws StorageException {
		new CommonDAO<>(OTABatch.class).delete(domainKey, "batchId", batchId);
	}

	@Override
	public Collection<OTABatch> list(String domainKey, OTABatchState[] states, int page, int pageSize) throws StorageException {
		try {
			
			Query query = UOW.createNativeQuery("select v from OTABatch v where v.id.domainKey=:dkey and v.state in :states order by v.id.batchId", OTABatch.class);
			
			query.setParameter("dkey", domainKey);
			query.setParameter("states", Arrays.asList(states));
			query.setFirstResult(page);
			query.setMaxResults(pageSize);
			@SuppressWarnings("unchecked")
			Collection<OTABatch> list = query.getResultList();
			return list;
			
		}catch(Exception ex) {
			throw new StorageException(ex);
		}
	}

	@Override
	public Collection<OTABatch> listNext(String domainKey, OTABatchState[] states, String batchId, int page, int pageSize) throws StorageException {
		return list(domainKey, states, page, pageSize);
	}

	@Override
	public Collection<OTABatch> search(String domainKey, OTABatchState[] states, String query, int pageSize) throws StorageException {
		try {
			
			String jql = String.format("select v from OTABatch v where v.id.domainKey=:dkey and v.state in :states and %s",  DBUtil.searchToQuery(query));
			Query tquery = UOW.createNativeQuery(jql, OTABatch.class);
			tquery.setParameter("dkey", domainKey);
			tquery.setParameter("states", states);
			
			tquery.setFirstResult(0);
			tquery.setMaxResults(pageSize);
			@SuppressWarnings("unchecked")
			Collection<OTABatch> list = tquery.getResultList();
			return list;
			
		}catch(Exception ex) {
			throw new StorageException(ex);
		}
	}

	@Override
	public void delete() throws StorageException {
		new CommonDAO<>(OTABatch.class).delete();
	}

}
