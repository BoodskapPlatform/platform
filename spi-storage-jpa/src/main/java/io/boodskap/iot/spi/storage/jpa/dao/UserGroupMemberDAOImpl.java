package io.boodskap.iot.spi.storage.jpa.dao;

import java.util.Collection;
import java.util.Date;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.dao.UserGroupMemberDAO;
import io.boodskap.iot.model.IUserGroupMember;
import io.boodskap.iot.model.jpa.UserGroupMember;
import io.boodskap.iot.model.jpa.UserGroupMemberId;
import io.boodskap.iot.spi.storage.jpa.UOW;
import io.boodskap.iot.spi.storage.jpa.dao.util.CommonDAO;
import io.boodskap.iot.spi.storage.jpa.dao.util.EntityIteratorImpl;
import io.boodskap.iot.spi.storage.jpa.dao.util.StringFieldEntityIterator;

public class UserGroupMemberDAOImpl implements UserGroupMemberDAO<UserGroupMember> {
	
	private static final UserGroupMemberDAO<UserGroupMember> dao = new UserGroupMemberDAOImpl();
	
	protected UserGroupMemberDAOImpl() {
	}
	
	public static final UserGroupMemberDAO<UserGroupMember> get() {
		return dao;
	}

	@Override
	public UserGroupMember create(String domainKey, String ownerUserId, String groupId, String memberId) {
		return new UserGroupMember(new UserGroupMemberId(domainKey, ownerUserId, groupId, memberId));
	}

	@Override
	public Class<? extends UserGroupMember> clazz() {
		return UserGroupMember.class;
	}

	@Override
	public void createOrUpdate(UserGroupMember e) throws StorageException {
		
		try {
			
			final IUserGroupMember oe = get(e.getDomainKey(), e.getOwnerUserId(), e.getGroupId(), e.getMemberId());
			IUserGroupMember ne;
			
			if(null == oe) {
				ne = new UserGroupMember(new UserGroupMemberId(e.getDomainKey(), e.getOwnerUserId(), e.getGroupId(), e.getMemberId()));
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
	public EntityIterator<UserGroupMember> load() throws StorageException {
		return new EntityIteratorImpl<>(UserGroupMember.class, "id.ownerUserId");
	}

	@Override
	public EntityIterator<UserGroupMember> load(String domainKey) throws StorageException {
		return new EntityIteratorImpl<>(UserGroupMember.class, domainKey, "id.ownerUserId");
	}

	@Override
	public long count() throws StorageException {
		return new CommonDAO<>(UserGroupMember.class).count();
	}

	@Override
	public long count(String domainKey) throws StorageException {
		return new CommonDAO<>(UserGroupMember.class).count(domainKey);
	}

	@Override
	public long count(String domainKey, String ownerUserId, String groupId) throws StorageException {
		return new CommonDAO<>(UserGroupMember.class).count(domainKey, "groupId", groupId);
	}

	@Override
	public UserGroupMember get(String domainKey, String ownerUserId, String groupId, String memberUserId) throws StorageException {
		return new CommonDAO<>(UserGroupMember.class).find(new UserGroupMemberId(domainKey, ownerUserId, groupId, memberUserId));
	}

	@Override
	public void delete(String domainKey) throws StorageException {
		new CommonDAO<>(UserGroupMember.class).delete(domainKey);
	}

	@Override
	public void delete(String domainKey, String ownerUserId) throws StorageException {
		new CommonDAO<>(UserGroupMember.class).delete(domainKey, "ownerUserId", ownerUserId);
	}

	@Override
	public void delete(String domainKey, String ownerUserId, String groupId) throws StorageException {
		new CommonDAO<>(UserGroupMember.class).delete(domainKey, "ownerUserId", ownerUserId, "groupId", groupId);
	}

	@Override
	public void delete(String domainKey, String ownerUserId, String groupId, String memberUserId) throws StorageException {
		new CommonDAO<>(UserGroupMember.class).delete(domainKey, "ownerUserId", ownerUserId, "groupId", groupId, "memberId", memberUserId);
	}

	@Override
	public EntityIterator<String> iterateMembers(String domainKey, String ownerUserId, String groupId) throws StorageException {
		return new StringFieldEntityIterator(UserGroupMember.class, "id.memberId", "ownerUserId", ownerUserId, "groupId", groupId, "id.memberId");
	}

	@Override
	public Collection<UserGroupMember> list(String domainKey, String ownerUserId, String groupId, int page, int pageSize) throws StorageException {
		return new CommonDAO<>(UserGroupMember.class).list(domainKey, "ownerUserId", ownerUserId, page, pageSize, "id.memberId");
	}

	@Override
	public Collection<UserGroupMember> listNext(String domainKey, String ownerUserId, String groupId, String memberUserId, int page, int pageSize) throws StorageException {
		return list(domainKey, ownerUserId, groupId, page, pageSize);
	}

	@Override
	public Collection<UserGroupMember> search(String domainKey, String ownerUserId, String groupId, String query, int pageSize) throws StorageException {
		return new CommonDAO<>(UserGroupMember.class).search(query, domainKey, "ownerUserId", ownerUserId, pageSize);
	}

	@Override
	public void delete() throws StorageException {
		new CommonDAO<>(UserGroupMember.class).delete();
	}

}
