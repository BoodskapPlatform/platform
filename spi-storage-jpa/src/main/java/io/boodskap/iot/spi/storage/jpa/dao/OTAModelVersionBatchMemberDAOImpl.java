package io.boodskap.iot.spi.storage.jpa.dao;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Query;

import io.boodskap.iot.OTAState;
import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.dao.OTAModelVersionBatchMemberDAO;
import io.boodskap.iot.model.IOTAModelVersionBatchMember;
import io.boodskap.iot.model.jpa.OTABatch;
import io.boodskap.iot.model.jpa.OTAModelVersionBatchMember;
import io.boodskap.iot.model.jpa.OTAModelVersionBatchMemberId;
import io.boodskap.iot.spi.storage.jpa.UOW;
import io.boodskap.iot.spi.storage.jpa.dao.util.CommonDAO;
import io.boodskap.iot.spi.storage.jpa.dao.util.DBUtil;
import io.boodskap.iot.spi.storage.jpa.dao.util.EntityIteratorImpl;

public class OTAModelVersionBatchMemberDAOImpl implements OTAModelVersionBatchMemberDAO<OTAModelVersionBatchMember> {

	private static final OTAModelVersionBatchMemberDAO<OTAModelVersionBatchMember> dao = new OTAModelVersionBatchMemberDAOImpl();
	
	protected OTAModelVersionBatchMemberDAOImpl() {
	}
	
	public static final OTAModelVersionBatchMemberDAO<OTAModelVersionBatchMember> get() {
		return dao;
	}

	@Override
	public OTAModelVersionBatchMember create(String domainKey, String batchId, String fromModel, String fromVersion, String deviceId) {
		return new OTAModelVersionBatchMember(new OTAModelVersionBatchMemberId(domainKey, batchId, fromModel, fromVersion, deviceId));
	}

	@Override
	public Class<? extends OTAModelVersionBatchMember> clazz() {
		return OTAModelVersionBatchMember.class;
	}

	@Override
	public void createOrUpdate(OTAModelVersionBatchMember e) throws StorageException {
		
		try {
			
			final IOTAModelVersionBatchMember oe = get(e.getDomainKey(), e.getBatchId(), e.getFromModel(), e.getFromVersion(), e.getDeviceId());
			IOTAModelVersionBatchMember ne;
			
			if(null == oe) {
				ne = new OTAModelVersionBatchMember(new OTAModelVersionBatchMemberId(e.getDomainKey(), e.getBatchId(), e.getFromModel(), e.getFromVersion(), e.getDeviceId()));
				ne.setCreatedStamp(new Date());
			}else {
				ne = oe;
			}
			
			UOW.begin();
			
			ne.setBeginStamp(e.getBeginStamp());
			ne.setEndStamp(e.getEndStamp());
			ne.setFailureCount(e.getFailureCount());
			ne.setState(e.getState());
			ne.setUpdatedStamp(new Date());
			
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
	public EntityIterator<OTAModelVersionBatchMember> load() throws StorageException {
		return new EntityIteratorImpl<>(OTAModelVersionBatchMember.class, "id.batchId");
	}

	@Override
	public EntityIterator<OTAModelVersionBatchMember> load(String domainKey) throws StorageException {
		return new EntityIteratorImpl<>(OTAModelVersionBatchMember.class, domainKey, "id.batchId");
	}

	@Override
	public long count() throws StorageException {
		return new CommonDAO<>(OTAModelVersionBatchMember.class).count();
	}

	@Override
	public long count(String domainKey, OTAState[] states) throws StorageException{
		try {
			Query query = UOW.createNativeQuery("select count(v) from OTAModelVersionBatchMember v where v.state in :states");
			query.setParameter("states", Arrays.asList(states));
			return DBUtil.toCount(query.getSingleResult());
		}catch(Exception ex) {
			throw new StorageException(ex);
		}
	}

	@Override
	public long count(String domainKey, String batchId, OTAState[] states) throws StorageException {
		try {
			Query query = UOW.createNativeQuery("select count(v) from OTAModelVersionBatchMember v where v.id.batchId=:fval and v.state in :states");
			query.setParameter("fval", batchId);
			query.setParameter("states", Arrays.asList(states));
			return DBUtil.toCount(query.getSingleResult());
		}catch(Exception ex) {
			throw new StorageException(ex);
		}
	}

	@Override
	public void delete(String domainKey) throws StorageException {
		new CommonDAO<>(OTAModelVersionBatchMember.class).delete(domainKey);
	}

	@Override
	public void delete(String domainKey, String batchId) throws StorageException {
		new CommonDAO<>(OTAModelVersionBatchMember.class).delete(domainKey, "batchId", batchId);
	}

	@Override
	public void delete(String domainKey, String batchId, String deviceId) throws StorageException {
		new CommonDAO<>(OTAModelVersionBatchMember.class).delete(domainKey, "batchId", batchId, "deviceId", deviceId);
	}

	@Override
	public OTAModelVersionBatchMember get(String domainKey, String batchId, String fromModel, String fromVersion, String deviceId) throws StorageException {
		return new CommonDAO<>(OTAModelVersionBatchMember.class).find(new OTAModelVersionBatchMemberId(domainKey, batchId, fromModel, fromVersion, deviceId));
	}

	@Override
	public Collection<OTAModelVersionBatchMember> list(String domainKey, String batchId, OTAState[] states, int page, int pageSize) throws StorageException {
		try {
			
			Query query = UOW.createNativeQuery("select v from OTAModelVersionBatchMember v where v.id.domainKey=:dkey and v.state in :states order by v.id.batchId", OTAModelVersionBatchMember.class);
			
			query.setParameter("dkey", domainKey);
			query.setParameter("states", Arrays.asList(states));
			query.setFirstResult(page);
			query.setMaxResults(pageSize);
			@SuppressWarnings("unchecked")
			Collection<OTAModelVersionBatchMember> list = query.getResultList();
			return list;
			
		}catch(Exception ex) {
			throw new StorageException(ex);
		}
	}

	@Override
	public Collection<OTAModelVersionBatchMember> listNext(String domainKey, String batchId, OTAState[] states, String deviceId, int page,int pageSize) throws StorageException {
		return list(domainKey, batchId, states, page, pageSize);
	}

	@Override
	public Collection<OTAModelVersionBatchMember> search(String domainKey, String batchId, OTAState[] states, String query, int pageSize) throws StorageException {
		try {
			
			String jql = String.format("select v from OTAModelVersionBatchMember v where v.id.domainKey=:dkey and v.state in :states and %s",  DBUtil.searchToQuery(query));
			Query tquery = UOW.createNativeQuery(jql, OTABatch.class);
			tquery.setParameter("dkey", domainKey);
			tquery.setParameter("states", Arrays.asList(states));
			
			tquery.setFirstResult(0);
			tquery.setMaxResults(pageSize);
			@SuppressWarnings("unchecked")
			Collection<OTAModelVersionBatchMember> list = tquery.getResultList();
			return list;
			
		}catch(Exception ex) {
			throw new StorageException(ex);
		}
	}

	@Override
	public void delete() throws StorageException {
		new CommonDAO<>(OTAModelVersionBatchMember.class).delete();
	}

}
