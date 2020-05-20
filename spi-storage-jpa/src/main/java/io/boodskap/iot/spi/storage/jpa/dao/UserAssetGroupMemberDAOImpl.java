package io.boodskap.iot.spi.storage.jpa.dao;

import java.util.Collection;
import java.util.Date;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.dao.UserAssetGroupMemberDAO;
import io.boodskap.iot.model.IUserAssetGroupMember;
import io.boodskap.iot.model.jpa.UserAssetGroupMember;
import io.boodskap.iot.model.jpa.UserAssetGroupMemberId;
import io.boodskap.iot.spi.storage.jpa.UOW;
import io.boodskap.iot.spi.storage.jpa.dao.util.CommonDAO;
import io.boodskap.iot.spi.storage.jpa.dao.util.EntityIteratorImpl;
import io.boodskap.iot.spi.storage.jpa.dao.util.StringFieldEntityIterator;

public class UserAssetGroupMemberDAOImpl implements UserAssetGroupMemberDAO<UserAssetGroupMember> {
	
	private static final UserAssetGroupMemberDAO<UserAssetGroupMember> dao = new UserAssetGroupMemberDAOImpl();
	
	protected UserAssetGroupMemberDAOImpl() {
	}
	
	public static final UserAssetGroupMemberDAO<UserAssetGroupMember> get() {
		return dao;
	}

	@Override
	public UserAssetGroupMember create(String domainKey, String ownerUserId, String groupId, String memberId) {
		return new UserAssetGroupMember(new UserAssetGroupMemberId(domainKey, ownerUserId, groupId, memberId));
	}

	@Override
	public Class<? extends UserAssetGroupMember> clazz() {
		return UserAssetGroupMember.class;
	}

	@Override
	public void createOrUpdate(UserAssetGroupMember e) throws StorageException {
		
		try {
			
			final IUserAssetGroupMember oe = get(e.getDomainKey(), e.getOwnerUserId(), e.getGroupId(), e.getMemberId());
			IUserAssetGroupMember ne;
			
			if(null == oe) {
				ne = new UserAssetGroupMember(new UserAssetGroupMemberId(e.getDomainKey(), e.getOwnerUserId(), e.getGroupId(), e.getMemberId()));
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
	public EntityIterator<UserAssetGroupMember> load() throws StorageException {
		return new EntityIteratorImpl<>(UserAssetGroupMember.class, "id.ownerUserId");
	}

	@Override
	public EntityIterator<UserAssetGroupMember> load(String domainKey) throws StorageException {
		return new EntityIteratorImpl<>(UserAssetGroupMember.class, domainKey, "id.ownerUserId");
	}

	@Override
	public long count() throws StorageException {
		return new CommonDAO<>(UserAssetGroupMember.class).count();
	}

	@Override
	public long count(String domainKey) throws StorageException {
		return new CommonDAO<>(UserAssetGroupMember.class).count(domainKey);
	}

	@Override
	public long count(String domainKey, String ownerUserId, String groupId) throws StorageException {
		return new CommonDAO<>(UserAssetGroupMember.class).count(domainKey, "groupId", groupId);
	}

	@Override
	public UserAssetGroupMember get(String domainKey, String ownerUserId, String groupId, String memberAssetId) throws StorageException {
		return new CommonDAO<>(UserAssetGroupMember.class).find(new UserAssetGroupMemberId(domainKey, ownerUserId, groupId, memberAssetId));
	}

	@Override
	public void delete(String domainKey) throws StorageException {
		new CommonDAO<>(UserAssetGroupMember.class).delete(domainKey);
	}

	@Override
	public void delete(String domainKey, String ownerUserId) throws StorageException {
		new CommonDAO<>(UserAssetGroupMember.class).delete(domainKey, "ownerUserId", ownerUserId);
	}

	@Override
	public void delete(String domainKey, String ownerUserId, String groupId) throws StorageException {
		new CommonDAO<>(UserAssetGroupMember.class).delete(domainKey, "ownerUserId", ownerUserId, "groupId", groupId);
	}

	@Override
	public void delete(String domainKey, String ownerUserId, String groupId, String memberAssetId) throws StorageException {
		new CommonDAO<>(UserAssetGroupMember.class).delete(domainKey, "ownerUserId", ownerUserId, "groupId", groupId, "memberId", memberAssetId);
	}

	@Override
	public EntityIterator<String> iterateMembers(String domainKey, String ownerUserId, String groupId) throws StorageException {
		return new StringFieldEntityIterator(UserAssetGroupMember.class, "id.memberId", "ownerUserId", ownerUserId, "groupId", groupId, "id.memberId");
	}

	@Override
	public Collection<UserAssetGroupMember> list(String domainKey, String ownerUserId, String groupId, int page, int pageSize) throws StorageException {
		return new CommonDAO<>(UserAssetGroupMember.class).list(domainKey, "ownerUserId", ownerUserId, page, pageSize, "id.memberId");
	}

	@Override
	public Collection<UserAssetGroupMember> listNext(String domainKey, String ownerUserId, String groupId, String memberAssetId, int page, int pageSize) throws StorageException {
		return list(domainKey, ownerUserId, groupId, page, pageSize);
	}

	@Override
	public Collection<UserAssetGroupMember> search(String domainKey, String ownerUserId, String groupId, String query, int pageSize) throws StorageException {
		return new CommonDAO<>(UserAssetGroupMember.class).search(query, domainKey, "ownerUserId", ownerUserId, pageSize);
	}

	@Override
	public void delete() throws StorageException {
		new CommonDAO<>(UserAssetGroupMember.class).delete();
	}

}
