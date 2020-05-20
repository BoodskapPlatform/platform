package io.boodskap.iot.spi.storage.jpa.dao;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Query;

import io.boodskap.iot.OTABatchState;
import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.dao.OTAModelBatchDAO;
import io.boodskap.iot.model.IOTAModelBatch;
import io.boodskap.iot.model.jpa.OTAModelBatch;
import io.boodskap.iot.model.jpa.OTAModelBatchId;
import io.boodskap.iot.spi.storage.jpa.UOW;
import io.boodskap.iot.spi.storage.jpa.dao.util.CommonDAO;
import io.boodskap.iot.spi.storage.jpa.dao.util.DBUtil;
import io.boodskap.iot.spi.storage.jpa.dao.util.EntityIteratorImpl;

public class OTAModelBatchDAOImpl implements OTAModelBatchDAO<OTAModelBatch> {

	private static final OTAModelBatchDAO<OTAModelBatch> dao = new OTAModelBatchDAOImpl();
	
	protected OTAModelBatchDAOImpl() {
	}
	
	public static final OTAModelBatchDAO<OTAModelBatch> get() {
		return dao;
	}

	@Override
	public OTAModelBatch create(String domainKey, String batchId, String fromModel) {
		return new OTAModelBatch(new OTAModelBatchId(domainKey, batchId, fromModel));
	}

	@Override
	public Class<? extends OTAModelBatch> clazz() {
		return OTAModelBatch.class;
	}

	@Override
	public void createOrUpdate(OTAModelBatch e) throws StorageException {
		
		try {
			
			final IOTAModelBatch oe = get(e.getDomainKey(), e.getBatchId(), e.getFromModel());
			IOTAModelBatch ne;
			
			if(null == oe) {
				ne = new OTAModelBatch(new OTAModelBatchId(e.getDomainKey(), e.getBatchId(), e.getFromModel()));
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
	public EntityIterator<OTAModelBatch> load() throws StorageException {
		return new EntityIteratorImpl<>(OTAModelBatch.class, "id.batchId");
	}

	@Override
	public EntityIterator<OTAModelBatch> load(String domainKey) throws StorageException {
		return new EntityIteratorImpl<>(OTAModelBatch.class, domainKey, "id.batchId");
	}

	@Override
	public long count() throws StorageException {
		return new CommonDAO<>(OTAModelBatch.class).count();
	}

	@Override
	public long count(String domainKey, OTABatchState[] states) throws StorageException {
		try {
			Query query = UOW.createNativeQuery("select count(v) from OTAModelBatch v where v.state in :states");
			query.setParameter("states", Arrays.asList(states));
			return DBUtil.toCount(query.getSingleResult());
		}catch(Exception ex) {
			throw new StorageException(ex);
		}
	}

	@Override
	public OTAModelBatch get(String domainKey, String batchId, String fromModel) throws StorageException {
		return new CommonDAO<>(OTAModelBatch.class).find(new OTAModelBatchId(domainKey, batchId, fromModel));
	}

	@Override
	public void delete(String domainKey) throws StorageException {
		new CommonDAO<>(OTAModelBatch.class).delete(domainKey);
	}

	@Override
	public void delete(String domainKey, String batchId) throws StorageException {
		new CommonDAO<>(OTAModelBatch.class).delete(domainKey, "batchId", batchId);
	}

	@Override
	public Collection<OTAModelBatch> list(String domainKey, OTABatchState[] states, int page, int pageSize) throws StorageException {
		try {
			
			Query query = UOW.createNativeQuery("select v from OTAModelBatch v where v.id.domainKey=:dkey and v.state in :states order by v.id.batchId", OTAModelBatch.class);
			
			query.setParameter("dkey", domainKey);
			query.setParameter("states", Arrays.asList(states));
			query.setFirstResult(page);
			query.setMaxResults(pageSize);
			@SuppressWarnings("unchecked")
			Collection<OTAModelBatch> list = query.getResultList();
			return list;
			
		}catch(Exception ex) {
			throw new StorageException(ex);
		}
	}

	@Override
	public Collection<OTAModelBatch> listNext(String domainKey, OTABatchState[] states, String batchId, int page, int pageSize) throws StorageException {
		return list(domainKey, states, page, pageSize);
	}

	@Override
	public Collection<OTAModelBatch> search(String domainKey, OTABatchState[] states, String query, int pageSize) throws StorageException {
		try {
			
			String jql = String.format("select v from OTAModelBatch v where v.id.domainKey=:dkey and v.state in :states and %s",  DBUtil.searchToQuery(query));
			Query tquery = UOW.createNativeQuery(jql, OTAModelBatch.class);
			tquery.setParameter("dkey", domainKey);
			tquery.setParameter("states", Arrays.asList(states));
			
			tquery.setFirstResult(0);
			tquery.setMaxResults(pageSize);
			@SuppressWarnings("unchecked")
			Collection<OTAModelBatch> list = tquery.getResultList();
			return list;
			
		}catch(Exception ex) {
			throw new StorageException(ex);
		}
	}

	@Override
	public void delete() throws StorageException {
		new CommonDAO<>(OTAModelBatch.class).delete();
	}

}
