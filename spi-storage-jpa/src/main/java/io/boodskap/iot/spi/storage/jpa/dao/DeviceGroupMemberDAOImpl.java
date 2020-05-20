package io.boodskap.iot.spi.storage.jpa.dao;

import java.util.Collection;
import java.util.Date;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.DeviceGroupMemberDAO;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.model.jpa.DeviceGroupMember;
import io.boodskap.iot.model.jpa.DeviceGroupMemberId;
import io.boodskap.iot.spi.storage.jpa.UOW;
import io.boodskap.iot.spi.storage.jpa.dao.util.CommonDAO;
import io.boodskap.iot.spi.storage.jpa.dao.util.EntityIteratorImpl;
import io.boodskap.iot.spi.storage.jpa.dao.util.StringFieldEntityIterator;

public class DeviceGroupMemberDAOImpl implements DeviceGroupMemberDAO<DeviceGroupMember> {
	
	private static final DeviceGroupMemberDAO<DeviceGroupMember> dao = new DeviceGroupMemberDAOImpl();
	
	protected DeviceGroupMemberDAOImpl() {
	}
	
	public static final DeviceGroupMemberDAO<DeviceGroupMember> get() {
		return dao;
	}

	@Override
	public DeviceGroupMember create(String domainKey, String ownerDeviceId, String groupId, String memberId) {
		return new DeviceGroupMember(new DeviceGroupMemberId(domainKey, ownerDeviceId, groupId, memberId));
	}

	@Override
	public Class<? extends DeviceGroupMember> clazz() {
		return DeviceGroupMember.class;
	}

	@Override
	public void createOrUpdate(DeviceGroupMember e) throws StorageException {
		
		try {
			
			final DeviceGroupMember oe = get(e.getDomainKey(), e.getOwnerDeviceId(), e.getGroupId(), e.getMemberId());
			DeviceGroupMember ne;
			
			if(null == oe) {
				ne = new DeviceGroupMember(new DeviceGroupMemberId(e.getDomainKey(), e.getOwnerDeviceId(), e.getGroupId(), e.getMemberId()));
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
	public DeviceGroupMember get(String domainKey, String ownerDeviceId, String groupId, String deviceId) throws StorageException {
		return new CommonDAO<>(DeviceGroupMember.class).find(new DeviceGroupMemberId(domainKey, ownerDeviceId, groupId, deviceId));
	}

	@Override
	public EntityIterator<DeviceGroupMember> load() throws StorageException {
		return new EntityIteratorImpl<>(DeviceGroupMember.class, "id.ownerDeviceId");
	}

	@Override
	public EntityIterator<DeviceGroupMember> load(String domainKey) throws StorageException {
		return new EntityIteratorImpl<>(DeviceGroupMember.class, domainKey, "id.ownerDeviceId");
	}

	@Override
	public EntityIterator<String> iterateMembers(String domainKey, String ownerDeviceId, String groupId) throws StorageException {
		return new StringFieldEntityIterator(DeviceGroupMember.class, "id.memberId", "ownerDeviceId", ownerDeviceId, "groupId", groupId, "id.memberId");
	}

	@Override
	public long count() throws StorageException {
		return new CommonDAO<>(DeviceGroupMember.class).count();
	}

	@Override
	public long count(String domainKey) throws StorageException {
		return new CommonDAO<>(DeviceGroupMember.class).count(domainKey);
	}

	@Override
	public long count(String domainKey, String ownerDeviceId, String groupId) throws StorageException {
		return new CommonDAO<>(DeviceGroupMember.class).count(domainKey, "ownerDeviceId", ownerDeviceId, "groupId", groupId);
	}

	@Override
	public void delete(String domainKey) throws StorageException {
		new CommonDAO<>(DeviceGroupMember.class).delete(domainKey);
	}

	@Override
	public void delete(String domainKey, String ownerDeviceId) throws StorageException {
		new CommonDAO<>(DeviceGroupMember.class).delete(domainKey, "ownerDeviceId", ownerDeviceId);
	}

	@Override
	public void delete(String domainKey, String ownerDeviceId, String groupId) throws StorageException {
		new CommonDAO<>(DeviceGroupMember.class).delete(domainKey, "ownerDeviceId", ownerDeviceId, "groupId", groupId);
	}

	@Override
	public void delete(String domainKey, String ownerDeviceId, String groupId, String deviceId) throws StorageException {
		new CommonDAO<>(DeviceGroupMember.class).delete(domainKey, "ownerDeviceId", ownerDeviceId, "groupId", groupId, "deviceId", deviceId);
	}

	@Override
	public Collection<DeviceGroupMember> list(String domainKey, String ownerDeviceId, String groupId, int page, int pageSize) throws StorageException {
		return new CommonDAO<>(DeviceGroupMember.class).list(domainKey, "ownerDeviceId", ownerDeviceId, "groupId", groupId, page, pageSize, "id.memberId");
	}

	@Override
	public Collection<DeviceGroupMember> listNext(String domainKey, String ownerDeviceId, String groupId, String deviceId, int page, int pageSize) throws StorageException {
		return list(domainKey, ownerDeviceId, groupId, page, pageSize);
	}

	@Override
	public Collection<DeviceGroupMember> search(String domainKey, String ownerDeviceId, String groupId, String query, int pageSize) throws StorageException {
		return new CommonDAO<>(DeviceGroupMember.class).search(query, domainKey, "ownerDeviceId", ownerDeviceId, "groupId", groupId, pageSize);
	}

	@Override
	public void delete() throws StorageException {
		new CommonDAO<>(DeviceGroupMember.class).delete();
	}

}
