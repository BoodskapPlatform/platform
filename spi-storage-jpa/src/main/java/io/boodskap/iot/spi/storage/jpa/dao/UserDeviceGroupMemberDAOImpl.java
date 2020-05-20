package io.boodskap.iot.spi.storage.jpa.dao;

import java.util.Collection;
import java.util.Date;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.dao.UserDeviceGroupMemberDAO;
import io.boodskap.iot.model.IUserDeviceGroupMember;
import io.boodskap.iot.model.jpa.UserDeviceGroupMember;
import io.boodskap.iot.model.jpa.UserDeviceGroupMemberId;
import io.boodskap.iot.spi.storage.jpa.UOW;
import io.boodskap.iot.spi.storage.jpa.dao.util.CommonDAO;
import io.boodskap.iot.spi.storage.jpa.dao.util.EntityIteratorImpl;
import io.boodskap.iot.spi.storage.jpa.dao.util.StringFieldEntityIterator;

public class UserDeviceGroupMemberDAOImpl implements UserDeviceGroupMemberDAO<UserDeviceGroupMember> {
	
	private static final UserDeviceGroupMemberDAO<UserDeviceGroupMember> dao = new UserDeviceGroupMemberDAOImpl();
	
	protected UserDeviceGroupMemberDAOImpl() {
	}
	
	public static final UserDeviceGroupMemberDAO<UserDeviceGroupMember> get() {
		return dao;
	}

	@Override
	public UserDeviceGroupMember create(String domainKey, String ownerUserId, String groupId, String memberId) {
		return new UserDeviceGroupMember(new UserDeviceGroupMemberId(domainKey, ownerUserId, groupId, memberId));
	}

	@Override
	public Class<? extends UserDeviceGroupMember> clazz() {
		return UserDeviceGroupMember.class;
	}

	@Override
	public void createOrUpdate(UserDeviceGroupMember e) throws StorageException {
		
		try {
			
			final IUserDeviceGroupMember oe = get(e.getDomainKey(), e.getOwnerUserId(), e.getGroupId(), e.getMemberId());
			IUserDeviceGroupMember ne;
			
			if(null == oe) {
				ne = new UserDeviceGroupMember(new UserDeviceGroupMemberId(e.getDomainKey(), e.getOwnerUserId(), e.getGroupId(), e.getMemberId()));
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
	public EntityIterator<UserDeviceGroupMember> load() throws StorageException {
		return new EntityIteratorImpl<>(UserDeviceGroupMember.class, "id.ownerUserId");
	}

	@Override
	public EntityIterator<UserDeviceGroupMember> load(String domainKey) throws StorageException {
		return new EntityIteratorImpl<>(UserDeviceGroupMember.class, domainKey, "id.ownerUserId");
	}

	@Override
	public long count() throws StorageException {
		return new CommonDAO<>(UserDeviceGroupMember.class).count();
	}

	@Override
	public long count(String domainKey) throws StorageException {
		return new CommonDAO<>(UserDeviceGroupMember.class).count(domainKey);
	}

	@Override
	public long count(String domainKey, String ownerUserId, String groupId) throws StorageException {
		return new CommonDAO<>(UserDeviceGroupMember.class).count(domainKey, "groupId", groupId);
	}

	@Override
	public UserDeviceGroupMember get(String domainKey, String ownerUserId, String groupId, String memberDeviceId) throws StorageException {
		return new CommonDAO<>(UserDeviceGroupMember.class).find(new UserDeviceGroupMemberId(domainKey, ownerUserId, groupId, memberDeviceId));
	}

	@Override
	public void delete(String domainKey) throws StorageException {
		new CommonDAO<>(UserDeviceGroupMember.class).delete(domainKey);
	}

	@Override
	public void delete(String domainKey, String ownerUserId) throws StorageException {
		new CommonDAO<>(UserDeviceGroupMember.class).delete(domainKey, "ownerUserId", ownerUserId);
	}

	@Override
	public void delete(String domainKey, String ownerUserId, String groupId) throws StorageException {
		new CommonDAO<>(UserDeviceGroupMember.class).delete(domainKey, "ownerUserId", ownerUserId, "groupId", groupId);
	}

	@Override
	public void delete(String domainKey, String ownerUserId, String groupId, String memberDeviceId) throws StorageException {
		new CommonDAO<>(UserDeviceGroupMember.class).delete(domainKey, "ownerUserId", ownerUserId, "groupId", groupId, "memberId", memberDeviceId);
	}

	@Override
	public EntityIterator<String> iterateMembers(String domainKey, String ownerUserId, String groupId) throws StorageException {
		return new StringFieldEntityIterator(UserDeviceGroupMember.class, "id.memberId", "ownerUserId", ownerUserId, "groupId", groupId, "id.memberId");
	}

	@Override
	public Collection<UserDeviceGroupMember> list(String domainKey, String ownerUserId, String groupId, int page, int pageSize) throws StorageException {
		return new CommonDAO<>(UserDeviceGroupMember.class).list(domainKey, "ownerUserId", ownerUserId, page, pageSize, "id.memberId");
	}

	@Override
	public Collection<UserDeviceGroupMember> listNext(String domainKey, String ownerUserId, String groupId, String memberDeviceId, int page, int pageSize) throws StorageException {
		return list(domainKey, ownerUserId, groupId, page, pageSize);
	}

	@Override
	public Collection<UserDeviceGroupMember> search(String domainKey, String ownerUserId, String groupId, String query, int pageSize) throws StorageException {
		return new CommonDAO<>(UserDeviceGroupMember.class).search(query, domainKey, "ownerUserId", ownerUserId, pageSize);
	}

	@Override
	public void delete() throws StorageException {
		new CommonDAO<>(UserDeviceGroupMember.class).delete();
	}

}
