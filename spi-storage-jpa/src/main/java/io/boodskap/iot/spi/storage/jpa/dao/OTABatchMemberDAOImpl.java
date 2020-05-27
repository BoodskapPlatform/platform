package io.boodskap.iot.spi.storage.jpa.dao;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Query;

import io.boodskap.iot.OTAState;
import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.dao.OTABatchMemberDAO;
import io.boodskap.iot.model.IOTABatchMember;
import io.boodskap.iot.model.jpa.OTABatch;
import io.boodskap.iot.model.jpa.OTABatchMember;
import io.boodskap.iot.model.jpa.OTABatchMemberId;
import io.boodskap.iot.spi.storage.jpa.UOW;
import io.boodskap.iot.spi.storage.jpa.dao.util.CommonDAO;
import io.boodskap.iot.spi.storage.jpa.dao.util.DBUtil;
import io.boodskap.iot.spi.storage.jpa.dao.util.EntityIteratorImpl;

public class OTABatchMemberDAOImpl implements OTABatchMemberDAO<OTABatchMember> {
	
	private static final OTABatchMemberDAO<OTABatchMember> dao = new OTABatchMemberDAOImpl();
	
	protected OTABatchMemberDAOImpl() {
	}
	
	public static final OTABatchMemberDAO<OTABatchMember> get() {
		return dao;
	}

	@Override
	public OTABatchMember create(String domainKey, String batchId, String deviceId) {
		return new OTABatchMember(new OTABatchMemberId(domainKey, batchId, deviceId));
	}

	@Override
	public Class<? extends OTABatchMember> clazz() {
		return OTABatchMember.class;
	}

	@Override
	public void createOrUpdate(OTABatchMember e) throws StorageException {
		
		try {
			
			final IOTABatchMember oe = get(e.getDomainKey(), e.getBatchId(), e.getDeviceId());
			IOTABatchMember ne;
			
			if(null == oe) {
				ne = new OTABatchMember(new OTABatchMemberId(e.getDomainKey(), e.getBatchId(), e.getDeviceId()));
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
	public EntityIterator<OTABatchMember> load() throws StorageException {
		return new EntityIteratorImpl<>(OTABatchMember.class, "id.batchId");
	}

	@Override
	public EntityIterator<OTABatchMember> load(String domainKey) throws StorageException {
		return new EntityIteratorImpl<>(OTABatchMember.class, domainKey, "id.batchId");
	}

	@Override
	public long count() throws StorageException {
		return new CommonDAO<>(OTABatchMember.class).count();
	}

	@Override
	public long count(String domainKey) throws StorageException {
		return new CommonDAO<>(OTABatchMember.class).count(domainKey);
	}

	@Override
	public long count(String domainKey, String batchId, OTAState[] states) throws StorageException {
		try {
			Query query = UOW.createNativeQuery("select count(v) from OTABatchMember v where v.id.batchId=:fval and v.state in :states");
			query.setParameter("fval", batchId);
			query.setParameter("states", Arrays.asList(states));
			return DBUtil.toCount(query.getSingleResult());
		}catch(Exception ex) {
			throw new StorageException(ex);
		}
	}

	@Override
	public void delete(String domainKey) throws StorageException {
		new CommonDAO<>(OTABatchMember.class).delete(domainKey);
	}

	@Override
	public void delete(String domainKey, String batchId) throws StorageException {
		new CommonDAO<>(OTABatchMember.class).delete(domainKey, "batchId", batchId);
	}

	@Override
	public void delete(String domainKey, String batchId, String deviceId) throws StorageException {
		new CommonDAO<>(OTABatchMember.class).delete(domainKey, "batchId", batchId, "deviceId", deviceId);
	}

	@Override
	public OTABatchMember get(String domainKey, String batchId, String deviceId) throws StorageException {
		return new CommonDAO<>(OTABatchMember.class).find(new OTABatchMemberId(domainKey, batchId, deviceId));
	}

	@Override
	public Collection<OTABatchMember> list(String domainKey, String batchId, OTAState[] states, int page, int pageSize) throws StorageException {
		try {
			
			Query query = UOW.createNativeQuery("select v from OTABatchMember v where v.id.domainKey=:dkey and v.state in :states order by v.id.batchId", OTABatchMember.class);
			
			query.setParameter("dkey", domainKey);
			query.setParameter("states", Arrays.asList(states));
			query.setFirstResult(page);
			query.setMaxResults(pageSize);
			@SuppressWarnings("unchecked")
			Collection<OTABatchMember> list = query.getResultList();
			return list;
			
		}catch(Exception ex) {
			throw new StorageException(ex);
		}
	}

	@Override
	public Collection<OTABatchMember> listNext(String domainKey, String batchId, OTAState[] states, String deviceId, int page,int pageSize) throws StorageException {
		return list(domainKey, batchId, states, page, pageSize);
	}

	@Override
	public Collection<OTABatchMember> search(String domainKey, String batchId, OTAState[] states, String query, int pageSize) throws StorageException {
		try {
			
			String jql = String.format("select v from OTABatchMember v where v.id.domainKey=:dkey and v.state in :states and %s",  DBUtil.searchToQuery(query));
			Query tquery = UOW.createNativeQuery(jql, OTABatch.class);
			tquery.setParameter("dkey", domainKey);
			tquery.setParameter("states", states);
			
			tquery.setFirstResult(0);
			tquery.setMaxResults(pageSize);
			@SuppressWarnings("unchecked")
			Collection<OTABatchMember> list = tquery.getResultList();
			return list;
			
		}catch(Exception ex) {
			throw new StorageException(ex);
		}
	}

	@Override
	public void delete() throws StorageException {
		new CommonDAO<>(OTABatchMember.class).delete();
	}

}
