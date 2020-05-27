package io.boodskap.iot.spi.storage.jpa.dao;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Query;

import io.boodskap.iot.OTAState;
import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.dao.OTADeviceBatchMemberDAO;
import io.boodskap.iot.model.IOTADeviceBatchMember;
import io.boodskap.iot.model.jpa.OTABatch;
import io.boodskap.iot.model.jpa.OTADeviceBatchMember;
import io.boodskap.iot.model.jpa.OTADeviceBatchMemberId;
import io.boodskap.iot.spi.storage.jpa.UOW;
import io.boodskap.iot.spi.storage.jpa.dao.util.CommonDAO;
import io.boodskap.iot.spi.storage.jpa.dao.util.DBUtil;
import io.boodskap.iot.spi.storage.jpa.dao.util.EntityIteratorImpl;

public class OTADeviceBatchMemberDAOImpl implements OTADeviceBatchMemberDAO<OTADeviceBatchMember> {

	private static final OTADeviceBatchMemberDAO<OTADeviceBatchMember> dao = new OTADeviceBatchMemberDAOImpl();
	
	protected OTADeviceBatchMemberDAOImpl() {
	}
	
	public static final OTADeviceBatchMemberDAO<OTADeviceBatchMember> get() {
		return dao;
	}

	@Override
	public OTADeviceBatchMember create(String domainKey, String id, String deviceId) {
		return new OTADeviceBatchMember(new OTADeviceBatchMemberId(domainKey, id, deviceId));
	}

	@Override
	public Class<? extends OTADeviceBatchMember> clazz() {
		return OTADeviceBatchMember.class;
	}

	@Override
	public void createOrUpdate(OTADeviceBatchMember e) throws StorageException {
		
		try {
			
			final IOTADeviceBatchMember oe = get(e.getDomainKey(), e.getBatchId(), e.getDeviceId());
			IOTADeviceBatchMember ne;
			
			if(null == oe) {
				ne = new OTADeviceBatchMember(new OTADeviceBatchMemberId(e.getDomainKey(), e.getBatchId(), e.getDeviceId()));
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
	public EntityIterator<OTADeviceBatchMember> load() throws StorageException {
		return new EntityIteratorImpl<>(OTADeviceBatchMember.class, "id.batchId");
	}

	@Override
	public EntityIterator<OTADeviceBatchMember> load(String domainKey) throws StorageException {
		return new EntityIteratorImpl<>(OTADeviceBatchMember.class, domainKey, "id.batchId");
	}

	@Override
	public long count() throws StorageException {
		return new CommonDAO<>(OTADeviceBatchMember.class).count();
	}

	@Override
	public long count(String domainKey) throws StorageException {
		return new CommonDAO<>(OTADeviceBatchMember.class).count(domainKey);
	}

	@Override
	public long count(String domainKey, String batchId, OTAState[] states) throws StorageException {
		try {
			Query query = UOW.createNativeQuery("select count(v) from OTADeviceBatchMember v where v.id.batchId=:fval and v.state in :states");
			query.setParameter("fval", batchId);
			query.setParameter("states", Arrays.asList(states));
			return DBUtil.toCount(query.getSingleResult());
		}catch(Exception ex) {
			throw new StorageException(ex);
		}
	}

	@Override
	public void delete(String domainKey) throws StorageException {
		new CommonDAO<>(OTADeviceBatchMember.class).delete(domainKey);
	}

	@Override
	public void delete(String domainKey, String batchId) throws StorageException {
		new CommonDAO<>(OTADeviceBatchMember.class).delete(domainKey, "batchId", batchId);
	}

	@Override
	public void delete(String domainKey, String batchId, String deviceId) throws StorageException {
		new CommonDAO<>(OTADeviceBatchMember.class).delete(domainKey, "batchId", batchId, "deviceId", deviceId);
	}

	@Override
	public OTADeviceBatchMember get(String domainKey, String batchId, String deviceId) throws StorageException {
		return new CommonDAO<>(OTADeviceBatchMember.class).find(new OTADeviceBatchMemberId(domainKey, batchId, deviceId));
	}

	@Override
	public Collection<OTADeviceBatchMember> list(String domainKey, String batchId, OTAState[] states, int page, int pageSize) throws StorageException{
		try {
			
			Query query = UOW.createNativeQuery("select v from OTADeviceBatchMember v where v.id.domainKey=:dkey and v.state in :states order by v.id.batchId", OTADeviceBatchMember.class);
			
			query.setParameter("dkey", domainKey);
			query.setParameter("states", states);
			query.setFirstResult(page);
			query.setMaxResults(pageSize);
			@SuppressWarnings("unchecked")
			Collection<OTADeviceBatchMember> list = query.getResultList();
			return list;
			
		}catch(Exception ex) {
			throw new StorageException(ex);
		}
	}

	@Override
	public Collection<OTADeviceBatchMember> listNext(String domainKey, String batchId, OTAState[] states, String deviceId, int page,int pageSize) throws StorageException {
		return list(domainKey, batchId, states, page, pageSize);
	}

	@Override
	public Collection<OTADeviceBatchMember> search(String domainKey, String batchId, OTAState[] states, String query, int pageSize) throws StorageException {
		try {
			
			String jql = String.format("select v from OTADeviceBatchMember v where v.id.domainKey=:dkey and v.state in :states and %s",  DBUtil.searchToQuery(query));
			Query tquery = UOW.createNativeQuery(jql, OTABatch.class);
			tquery.setParameter("dkey", domainKey);
			tquery.setParameter("states", states);
			
			tquery.setFirstResult(0);
			tquery.setMaxResults(pageSize);
			@SuppressWarnings("unchecked")
			Collection<OTADeviceBatchMember> list = tquery.getResultList();
			return list;
			
		}catch(Exception ex) {
			throw new StorageException(ex);
		}
	}

	@Override
	public void delete() throws StorageException {
		new CommonDAO<>(OTADeviceBatchMember.class).delete();
	}

}
