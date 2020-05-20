package io.boodskap.iot.spi.storage.jpa.dao;

import java.util.Collection;
import java.util.Date;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.dao.UserGroupDAO;
import io.boodskap.iot.model.IUserGroup;
import io.boodskap.iot.model.jpa.UserGroup;
import io.boodskap.iot.model.jpa.UserGroupId;
import io.boodskap.iot.spi.storage.jpa.UOW;
import io.boodskap.iot.spi.storage.jpa.dao.util.CommonDAO;
import io.boodskap.iot.spi.storage.jpa.dao.util.EntityIteratorImpl;

public class UserGroupDAOImpl implements UserGroupDAO<UserGroup> {
	
	private static final UserGroupDAO<UserGroup> dao = new UserGroupDAOImpl();
	
	protected UserGroupDAOImpl() {
	}
	
	public static final UserGroupDAO<UserGroup> get() {
		return dao;
	}

	@Override
	public UserGroup create(String domainKey, String ownerUserId, String groupId) {
		return new UserGroup(new UserGroupId(domainKey, ownerUserId, groupId));
	}

	@Override
	public Class<? extends UserGroup> clazz() {
		return UserGroup.class;
	}

	@Override
	public void createOrUpdate(UserGroup e) throws StorageException {
		
		try {
			
			final IUserGroup oe = get(e.getDomainKey(), e.getOwnerUserId(), e.getGroupId());
			IUserGroup ne;
			
			if(null == oe) {
				ne = new UserGroup(new UserGroupId(e.getDomainKey(), e.getOwnerUserId(), e.getGroupId()));
				ne.setCreatedStamp(new Date());
			}else {
				ne = oe;
			}
			
			UOW.begin();
			
			ne.setDescription(e.getDescription());
			ne.setGroupEmail(e.getGroupEmail());
			ne.setGroupPhone(e.getGroupPhone());
			ne.setIndividualBroadcast(e.isIndividualBroadcast());
			ne.setName(e.getName());
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
	public EntityIterator<UserGroup> load() throws StorageException {
		return new EntityIteratorImpl<>(UserGroup.class, "id.ownerUserId");
	}

	@Override
	public EntityIterator<UserGroup> load(String domainKey) throws StorageException {
		return new EntityIteratorImpl<>(UserGroup.class, domainKey, "id.ownerUserId");
	}

	@Override
	public long count() throws StorageException {
		return new CommonDAO<>(UserGroup.class).count();
	}

	@Override
	public long count(String domainKey) throws StorageException {
		return new CommonDAO<>(UserGroup.class).count(domainKey);
	}

	@Override
	public long count(String domainKey, String ownerUserId) throws StorageException {
		return new CommonDAO<>(UserGroup.class).count(domainKey, "ownerUserId", ownerUserId);
	}

	@Override
	public UserGroup get(String domainKey, String ownerUserId, String groupId) throws StorageException {
		return new CommonDAO<>(UserGroup.class).find(new UserGroupId(domainKey, ownerUserId, groupId));
	}

	@Override
	public void delete(String domainKey) throws StorageException {
		new CommonDAO<>(UserGroup.class).delete(domainKey);
	}

	@Override
	public void delete(String domainKey, String ownerUserId) throws StorageException {
		new CommonDAO<>(UserGroup.class).delete(domainKey, "ownerUserId", ownerUserId);
	}

	@Override
	public void delete(String domainKey, String ownerUserId, String groupId) throws StorageException {
		new CommonDAO<>(UserGroup.class).delete(domainKey, "ownerUserId", ownerUserId, "groupId", groupId);
	}

	@Override
	public Collection<UserGroup> list(String domainKey, String ownerUserId, int page, int pageSize) throws StorageException {
		return new CommonDAO<>(UserGroup.class).list(domainKey, "ownerUserId", ownerUserId, page, pageSize, "id.groupId");
	}

	@Override
	public Collection<UserGroup> listNext(String domainKey, String ownerUserId, String groupId, int page, int pageSize)throws StorageException {
		return list(domainKey, ownerUserId, page, pageSize);
	}

	@Override
	public Collection<UserGroup> search(String domainKey, String ownerUserId, String query, int pageSize) throws StorageException {
		return new CommonDAO<>(UserGroup.class).search(query, domainKey, "ownerUserId", ownerUserId, pageSize);
	}

	@Override
	public void delete() throws StorageException {
		new CommonDAO<>(UserGroup.class).delete();
	}

}
