package io.boodskap.iot.spi.storage.jpa.dao;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Query;

import io.boodskap.iot.OTAState;
import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.dao.OTAModelBatchMemberDAO;
import io.boodskap.iot.model.IOTAModelBatchMember;
import io.boodskap.iot.model.jpa.OTABatch;
import io.boodskap.iot.model.jpa.OTAModelBatchMember;
import io.boodskap.iot.model.jpa.OTAModelBatchMemberId;
import io.boodskap.iot.spi.storage.jpa.UOW;
import io.boodskap.iot.spi.storage.jpa.dao.util.CommonDAO;
import io.boodskap.iot.spi.storage.jpa.dao.util.DBUtil;
import io.boodskap.iot.spi.storage.jpa.dao.util.EntityIteratorImpl;

public class OTAModelBatchMemberDAOImpl implements OTAModelBatchMemberDAO<OTAModelBatchMember> {

	private static final OTAModelBatchMemberDAO<OTAModelBatchMember> dao = new OTAModelBatchMemberDAOImpl();
	
	protected OTAModelBatchMemberDAOImpl() {
	}
	
	public static final OTAModelBatchMemberDAO<OTAModelBatchMember> get() {
		return dao;
	}

	@Override
	public OTAModelBatchMember create(String domainKey, String batchId, String fromModel, String deviceId) {
		return new OTAModelBatchMember(new OTAModelBatchMemberId(domainKey, batchId, fromModel, deviceId));
	}

	@Override
	public Class<? extends OTAModelBatchMember> clazz() {
		return OTAModelBatchMember.class;
	}

	@Override
	public void createOrUpdate(OTAModelBatchMember e) throws StorageException {
		
		try {
			
			final IOTAModelBatchMember oe = get(e.getDomainKey(), e.getBatchId(), e.getFromModel(), e.getDeviceId());
			IOTAModelBatchMember ne;
			
			if(null == oe) {
				ne = new OTAModelBatchMember(new OTAModelBatchMemberId(e.getDomainKey(), e.getBatchId(), e.getFromModel(), e.getDeviceId()));
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
	public EntityIterator<OTAModelBatchMember> load() throws StorageException {
		return new EntityIteratorImpl<>(OTAModelBatchMember.class, "id.batchId");
	}

	@Override
	public EntityIterator<OTAModelBatchMember> load(String domainKey) throws StorageException {
		return new EntityIteratorImpl<>(OTAModelBatchMember.class, domainKey, "id.batchId");
	}

	@Override
	public long count() throws StorageException {
		return new CommonDAO<>(OTAModelBatchMember.class).count();
	}

	@Override
	public long count(String domainKey) throws StorageException {
		return new CommonDAO<>(OTAModelBatchMember.class).count(domainKey);
	}

	@Override
	public long count(String domainKey, String batchId, OTAState[] states) throws StorageException {
		try {
			Query query = UOW.createNativeQuery("select count(v) from OTAModelBatchMember v where v.id.batchId=:fval and v.state in :states");
			query.setParameter("fval", batchId);
			query.setParameter("states", Arrays.asList(states));
			return DBUtil.toCount(query.getSingleResult());
		}catch(Exception ex) {
			throw new StorageException(ex);
		}
	}

	@Override
	public void delete(String domainKey) throws StorageException {
		new CommonDAO<>(OTAModelBatchMember.class).delete(domainKey);
	}

	@Override
	public void delete(String domainKey, String batchId) throws StorageException {
		new CommonDAO<>(OTAModelBatchMember.class).delete(domainKey, "batchId", batchId);
	}

	@Override
	public void delete(String domainKey, String batchId, String deviceId) throws StorageException {
		new CommonDAO<>(OTAModelBatchMember.class).delete(domainKey, "batchId", batchId, "deviceId", deviceId);
	}

	@Override
	public OTAModelBatchMember get(String domainKey, String batchId, String fromModel, String deviceId) throws StorageException {
		return new CommonDAO<>(OTAModelBatchMember.class).find(new OTAModelBatchMemberId(domainKey, batchId, fromModel, deviceId));
	}

	@Override
	public Collection<OTAModelBatchMember> list(String domainKey, String batchId, OTAState[] states, int page, int pageSize) throws StorageException {
		try {
			
			Query query = UOW.createNativeQuery("select v from OTAModelBatchMember v where v.id.domainKey=:dkey and v.state in :states order by v.id.batchId", OTAModelBatchMember.class);
			
			query.setParameter("dkey", domainKey);
			query.setParameter("states", Arrays.asList(states));
			query.setFirstResult(page);
			query.setMaxResults(pageSize);
			@SuppressWarnings("unchecked")
			Collection<OTAModelBatchMember> list = query.getResultList();
			return list;
			
		}catch(Exception ex) {
			throw new StorageException(ex);
		}
	}

	@Override
	public Collection<OTAModelBatchMember> listNext(String domainKey, String batchId, OTAState[] states, String deviceId, int page,int pageSize) throws StorageException {
		return list(domainKey, batchId, states, page, pageSize);
	}

	@Override
	public Collection<OTAModelBatchMember> search(String domainKey, String batchId, OTAState[] states, String query, int pageSize) throws StorageException {
		try {
			
			String jql = String.format("select v from OTAModelBatchMember v where v.id.domainKey=:dkey and v.state in :states and %s",  DBUtil.searchToQuery(query));
			Query tquery = UOW.createNativeQuery(jql, OTABatch.class);
			tquery.setParameter("dkey", domainKey);
			tquery.setParameter("states", Arrays.asList(states));
			
			tquery.setFirstResult(0);
			tquery.setMaxResults(pageSize);
			@SuppressWarnings("unchecked")
			Collection<OTAModelBatchMember> list = tquery.getResultList();
			return list;
			
		}catch(Exception ex) {
			throw new StorageException(ex);
		}
	}

	@Override
	public void delete() throws StorageException {
		new CommonDAO<>(OTAModelBatchMember.class).delete();
	}

}
