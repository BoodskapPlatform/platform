package io.boodskap.iot.spi.storage.jpa.dao;

import java.util.Arrays;
import java.util.Collection;

import javax.persistence.Query;

import io.boodskap.iot.OTABatchState;
import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.dao.OTADeviceBatchDAO;
import io.boodskap.iot.model.IOTADeviceBatch;
import io.boodskap.iot.model.jpa.OTADeviceBatch;
import io.boodskap.iot.model.jpa.OTADeviceBatchId;
import io.boodskap.iot.spi.storage.jpa.UOW;
import io.boodskap.iot.spi.storage.jpa.dao.util.CommonDAO;
import io.boodskap.iot.spi.storage.jpa.dao.util.DBUtil;
import io.boodskap.iot.spi.storage.jpa.dao.util.EntityIteratorImpl;

public class OTADeviceBatchDAOImpl implements OTADeviceBatchDAO<OTADeviceBatch> {
	
	private static final OTADeviceBatchDAO<OTADeviceBatch> dao = new OTADeviceBatchDAOImpl();
	
	protected OTADeviceBatchDAOImpl() {
	}
	
	public static final OTADeviceBatchDAO<OTADeviceBatch> get() {
		return dao;
	}

	@Override
	public OTADeviceBatch create(String domainKey, String batchId) {
		return new OTADeviceBatch(new OTADeviceBatchId(domainKey, batchId));
	}

	@Override
	public Class<? extends OTADeviceBatch> clazz() {
		return OTADeviceBatch.class;
	}

	@Override
	public void createOrUpdate(OTADeviceBatch e) throws StorageException {
		
		try {
			
			final IOTADeviceBatch oe = get(e.getDomainKey(), e.getBatchId());
			IOTADeviceBatch ne;
			
			if(null == oe) {
				ne = new OTADeviceBatch(new OTADeviceBatchId(e.getDomainKey(), e.getBatchId()));
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
	public EntityIterator<OTADeviceBatch> load() throws StorageException {
		return new EntityIteratorImpl<>(OTADeviceBatch.class, "id.batchId");
	}

	@Override
	public EntityIterator<OTADeviceBatch> load(String domainKey) throws StorageException {
		return new EntityIteratorImpl<>(OTADeviceBatch.class, domainKey, "id.batchId");
	}

	@Override
	public long count() throws StorageException {
		return new CommonDAO<>(OTADeviceBatch.class).count();
	}

	@Override
	public long count(String domainKey, OTABatchState[] states) throws StorageException {
		try {
			Query query = UOW.createNativeQuery("select count(v) from OTADeviceBatch v where v.state in :states");
			query.setParameter("states", Arrays.asList(states));
			return DBUtil.toCount(query.getSingleResult());
		}catch(Exception ex) {
			throw new StorageException(ex);
		}
	}

	@Override
	public OTADeviceBatch get(String domainKey, String batchId) throws StorageException {
		return new CommonDAO<>(OTADeviceBatch.class).find(new OTADeviceBatchId(domainKey, batchId));
	}

	@Override
	public void delete(String domainKey) throws StorageException {
		new CommonDAO<>(OTADeviceBatch.class).delete(domainKey);
	}

	@Override
	public void delete(String domainKey, String batchId) throws StorageException {
		new CommonDAO<>(OTADeviceBatch.class).delete(domainKey, "batchId", batchId);
	}

	@Override
	public Collection<OTADeviceBatch> list(String domainKey, OTABatchState[] states, int page, int pageSize) throws StorageException {
		try {
			
			Query query = UOW.createNativeQuery("select v from OTADeviceBatch v where v.id.domainKey=:dkey and v.state in :states order by v.id.batchId", OTADeviceBatch.class);
			
			query.setParameter("dkey", domainKey);
			query.setParameter("states", Arrays.asList(states));
			query.setFirstResult(page);
			query.setMaxResults(pageSize);
			@SuppressWarnings("unchecked")
			Collection<OTADeviceBatch> list = query.getResultList();
			return list;
			
		}catch(Exception ex) {
			throw new StorageException(ex);
		}
	}

	@Override
	public Collection<OTADeviceBatch> listNext(String domainKey, OTABatchState[] states, String batchId, int page, int pageSize) throws StorageException {
		return list(domainKey, states, page, pageSize);
	}

	@Override
	public Collection<OTADeviceBatch> search(String domainKey, OTABatchState[] states, String query, int pageSize) throws StorageException {
		try {
			
			String jql = String.format("select v from OTADeviceBatch v where v.id.domainKey=:dkey and v.state in :states and %s",  DBUtil.searchToQuery(query));
			Query tquery = UOW.createNativeQuery(jql, OTADeviceBatch.class);
			tquery.setParameter("dkey", domainKey);
			tquery.setParameter("states", Arrays.asList(states));
			
			tquery.setFirstResult(0);
			tquery.setMaxResults(pageSize);
			@SuppressWarnings("unchecked")
			Collection<OTADeviceBatch> list = tquery.getResultList();
			return list;
			
		}catch(Exception ex) {
			throw new StorageException(ex);
		}
	}

	@Override
	public void delete() throws StorageException {
		new CommonDAO<>(OTADeviceBatch.class).delete();
	}

}
