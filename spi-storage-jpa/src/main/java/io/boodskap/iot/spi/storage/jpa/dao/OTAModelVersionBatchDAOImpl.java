package io.boodskap.iot.spi.storage.jpa.dao;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Query;

import io.boodskap.iot.OTABatchState;
import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.dao.OTAModelVersionBatchDAO;
import io.boodskap.iot.model.IOTAModelVersionBatch;
import io.boodskap.iot.model.jpa.OTAModelVersionBatch;
import io.boodskap.iot.model.jpa.OTAModelVersionBatchId;
import io.boodskap.iot.spi.storage.jpa.UOW;
import io.boodskap.iot.spi.storage.jpa.dao.util.CommonDAO;
import io.boodskap.iot.spi.storage.jpa.dao.util.DBUtil;
import io.boodskap.iot.spi.storage.jpa.dao.util.EntityIteratorImpl;

public class OTAModelVersionBatchDAOImpl implements OTAModelVersionBatchDAO<OTAModelVersionBatch> {

	private static final OTAModelVersionBatchDAO<OTAModelVersionBatch> dao = new OTAModelVersionBatchDAOImpl();
	
	protected OTAModelVersionBatchDAOImpl() {
	}
	
	public static final OTAModelVersionBatchDAO<OTAModelVersionBatch> get() {
		return dao;
	}

	@Override
	public OTAModelVersionBatch create(String domainKey, String batchId, String fromModel, String fromVersion) {
		return new OTAModelVersionBatch(new OTAModelVersionBatchId(domainKey, batchId, fromModel, fromVersion));
	}

	@Override
	public Class<? extends OTAModelVersionBatch> clazz() {
		return OTAModelVersionBatch.class;
	}

	@Override
	public void createOrUpdate(OTAModelVersionBatch e) throws StorageException {
		
		try {
			
			final IOTAModelVersionBatch oe = get(e.getDomainKey(), e.getBatchId(), e.getFromModel(), e.getFromVersion());
			IOTAModelVersionBatch ne;
			
			if(null == oe) {
				ne = new OTAModelVersionBatch(new OTAModelVersionBatchId(e.getDomainKey(), e.getBatchId(), e.getFromModel(), e.getFromVersion()));
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
	public EntityIterator<OTAModelVersionBatch> load() throws StorageException {
		return new EntityIteratorImpl<>(OTAModelVersionBatch.class, "id.batchId");
	}

	@Override
	public EntityIterator<OTAModelVersionBatch> load(String domainKey) throws StorageException {
		return new EntityIteratorImpl<>(OTAModelVersionBatch.class, domainKey, "id.batchId");
	}

	@Override
	public long count() throws StorageException {
		return new CommonDAO<>(OTAModelVersionBatch.class).count();
	}

	@Override
	public long count(String domainKey, OTABatchState[] states) throws StorageException {
		try {
			Query query = UOW.createNativeQuery("select count(v) from OTAModelVersionBatch v where v.state in :states");
			query.setParameter("states", Arrays.asList(states));
			return DBUtil.toCount(query.getSingleResult());
		}catch(Exception ex) {
			throw new StorageException(ex);
		}
	}

	@Override
	public OTAModelVersionBatch get(String domainKey, String batchId, String fromModel, String fromVersion) throws StorageException {
		return new CommonDAO<>(OTAModelVersionBatch.class).find(new OTAModelVersionBatchId(domainKey, batchId, fromModel, fromVersion));
	}

	@Override
	public void delete(String domainKey) throws StorageException {
		new CommonDAO<>(OTAModelVersionBatch.class).delete(domainKey);
	}

	@Override
	public void delete(String domainKey, String batchId) throws StorageException {
		new CommonDAO<>(OTAModelVersionBatch.class).delete(domainKey, "batchId", batchId);
	}

	@Override
	public Collection<OTAModelVersionBatch> list(String domainKey, OTABatchState[] states, int page, int pageSize) throws StorageException {
		try {
			
			Query query = UOW.createNativeQuery("select v from OTAModelVersionBatch v where v.id.domainKey=:dkey and v.state in :states order by v.id.batchId", OTAModelVersionBatch.class);
			
			query.setParameter("dkey", domainKey);
			query.setParameter("states", Arrays.asList(states));
			query.setFirstResult(page);
			query.setMaxResults(pageSize);
			@SuppressWarnings("unchecked")
			Collection<OTAModelVersionBatch> list = query.getResultList();
			return list;
			
		}catch(Exception ex) {
			throw new StorageException(ex);
		}
	}

	@Override
	public Collection<OTAModelVersionBatch> listNext(String domainKey, OTABatchState[] states, String batchId, int page, int pageSize) throws StorageException {
		return list(domainKey, states, page, pageSize);
	}

	@Override
	public Collection<OTAModelVersionBatch> search(String domainKey, OTABatchState[] states, String query, int pageSize) throws StorageException {
		try {
			
			String jql = String.format("select v from OTAModelVersionBatch v where v.id.domainKey=:dkey and v.state in :states and %s",  DBUtil.searchToQuery(query));
			Query tquery = UOW.createNativeQuery(jql, OTAModelVersionBatch.class);
			tquery.setParameter("dkey", domainKey);
			tquery.setParameter("states", Arrays.asList(states));
			
			tquery.setFirstResult(0);
			tquery.setMaxResults(pageSize);
			@SuppressWarnings("unchecked")
			Collection<OTAModelVersionBatch> list = tquery.getResultList();
			return list;
			
		}catch(Exception ex) {
			throw new StorageException(ex);
		}
	}

	@Override
	public void delete() throws StorageException {
		new CommonDAO<>(OTAModelVersionBatch.class).delete();
	}

}
