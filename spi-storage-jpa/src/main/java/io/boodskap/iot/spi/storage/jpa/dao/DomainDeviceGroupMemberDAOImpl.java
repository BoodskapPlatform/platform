package io.boodskap.iot.spi.storage.jpa.dao;

import java.util.Collection;
import java.util.Date;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.DomainDeviceGroupMemberDAO;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.model.IDomainDeviceGroupMember;
import io.boodskap.iot.model.jpa.DomainDeviceGroupMember;
import io.boodskap.iot.model.jpa.DomainDeviceGroupMemberId;
import io.boodskap.iot.spi.storage.jpa.UOW;
import io.boodskap.iot.spi.storage.jpa.dao.util.CommonDAO;
import io.boodskap.iot.spi.storage.jpa.dao.util.EntityIteratorImpl;
import io.boodskap.iot.spi.storage.jpa.dao.util.StringFieldEntityIterator;

public class DomainDeviceGroupMemberDAOImpl implements DomainDeviceGroupMemberDAO<DomainDeviceGroupMember> {
	
	private static final DomainDeviceGroupMemberDAO<DomainDeviceGroupMember> dao = new DomainDeviceGroupMemberDAOImpl();
	
	protected DomainDeviceGroupMemberDAOImpl() {
	}
	
	public static final DomainDeviceGroupMemberDAO<DomainDeviceGroupMember> get() {
		return dao;
	}

	@Override
	public DomainDeviceGroupMember create(String domainKey, String groupId, String memberId) {
		return new DomainDeviceGroupMember(new DomainDeviceGroupMemberId(domainKey, groupId, memberId));
	}

	@Override
	public Class<? extends DomainDeviceGroupMember> clazz() {
		return DomainDeviceGroupMember.class;
	}

	@Override
	public void createOrUpdate(DomainDeviceGroupMember e) throws StorageException {
		
		try {
			
			final IDomainDeviceGroupMember oe = get(e.getDomainKey(), e.getGroupId(), e.getMemberId());
			IDomainDeviceGroupMember ne;
			
			if(null == oe) {
				ne = new DomainDeviceGroupMember();
				ne.setRegisteredStamp(new Date());
			}else {
				ne = oe;
			}
			
			UOW.begin();
			
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
	public EntityIterator<DomainDeviceGroupMember> load() throws StorageException {
		return new EntityIteratorImpl<>(DomainDeviceGroupMember.class, "id.groupId");
	}

	@Override
	public EntityIterator<DomainDeviceGroupMember> load(String domainKey) throws StorageException {
		return new EntityIteratorImpl<>(DomainDeviceGroupMember.class, domainKey, "id.groupId");
	}

	@Override
	public EntityIterator<String> iterateMembers(String domainKey, String groupId) throws StorageException {
		return new StringFieldEntityIterator(DomainDeviceGroupMember.class, "id.memberId", "domainKey", domainKey, "groupId", groupId, "id.memberId");
	}

	@Override
	public long count() throws StorageException {
		return new CommonDAO<>(DomainDeviceGroupMember.class).count();
	}

	@Override
	public long count(String domainKey) throws StorageException {
		return new CommonDAO<>(DomainDeviceGroupMember.class).count(domainKey);
	}

	@Override
	public long count(String domainKey, String groupId) throws StorageException {
		return new CommonDAO<>(DomainDeviceGroupMember.class).count(domainKey, "groupId", groupId);
	}

	@Override
	public void delete(String domainKey) throws StorageException {
		new CommonDAO<>(DomainDeviceGroupMember.class).delete(domainKey);
	}

	@Override
	public void delete(String domainKey, String groupId) throws StorageException {
		new CommonDAO<>(DomainDeviceGroupMember.class).delete(domainKey, "groupId", groupId);
	}

	@Override
	public void delete(String domainKey, String groupId, String deviceId) throws StorageException {
		new CommonDAO<>(DomainDeviceGroupMember.class).delete(domainKey, "groupId", groupId, "memberId", deviceId);
	}

	@Override
	public DomainDeviceGroupMember get(String domainKey, String groupId, String deviceId) throws StorageException {
		return new CommonDAO<>(DomainDeviceGroupMember.class).find(new DomainDeviceGroupMemberId(domainKey, groupId, deviceId));
	}

	@Override
	public Collection<DomainDeviceGroupMember> list(String domainKey, String groupId, int page, int pageSize) throws StorageException {
		return new CommonDAO<>(DomainDeviceGroupMember.class).list(domainKey, "groupId", groupId, page, pageSize, "id.memberId");
	}

	@Override
	public Collection<DomainDeviceGroupMember> listNext(String domainKey, String groupId, String deviceId, int page, int pageSize) throws StorageException {
		return list(domainKey, groupId, page, pageSize);
	}

	@Override
	public Collection<DomainDeviceGroupMember> search(String domainKey, String groupId, String query, int pageSize) throws StorageException {
		return new CommonDAO<>(DomainDeviceGroupMember.class).search(query, domainKey, "groupId", groupId, pageSize);
	}

	@Override
	public void delete() throws StorageException {
		new CommonDAO<>(DomainDeviceGroupMember.class).delete();
	}

}
