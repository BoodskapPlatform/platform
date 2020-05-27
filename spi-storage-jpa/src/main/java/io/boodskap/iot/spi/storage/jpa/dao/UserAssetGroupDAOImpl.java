package io.boodskap.iot.spi.storage.jpa.dao;

import java.util.Collection;
import java.util.Date;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.dao.UserAssetGroupDAO;
import io.boodskap.iot.model.IUserAssetGroup;
import io.boodskap.iot.model.jpa.UserAssetGroup;
import io.boodskap.iot.model.jpa.UserAssetGroupId;
import io.boodskap.iot.spi.storage.jpa.UOW;
import io.boodskap.iot.spi.storage.jpa.dao.util.CommonDAO;
import io.boodskap.iot.spi.storage.jpa.dao.util.EntityIteratorImpl;

public class UserAssetGroupDAOImpl implements UserAssetGroupDAO<UserAssetGroup> {
	
	private static final UserAssetGroupDAO<UserAssetGroup> dao = new UserAssetGroupDAOImpl();
	
	protected UserAssetGroupDAOImpl() {
	}
	
	public static final UserAssetGroupDAO<UserAssetGroup> get() {
		return dao;
	}

	@Override
	public UserAssetGroup create(String domainKey, String ownerUserId, String groupId) {
		return new UserAssetGroup(new UserAssetGroupId(domainKey, ownerUserId, groupId));
	}

	@Override
	public Class<? extends UserAssetGroup> clazz() {
		return UserAssetGroup.class;
	}

	@Override
	public void createOrUpdate(UserAssetGroup e) throws StorageException {
		
		try {
			
			final IUserAssetGroup oe = get(e.getDomainKey(), e.getOwnerUserId(), e.getGroupId());
			IUserAssetGroup ne;
			
			if(null == oe) {
				ne = new UserAssetGroup(new UserAssetGroupId(e.getDomainKey(), e.getOwnerUserId(), e.getGroupId()));
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
	public EntityIterator<UserAssetGroup> load() throws StorageException {
		return new EntityIteratorImpl<>(UserAssetGroup.class, "id.ownerUserId");
	}

	@Override
	public EntityIterator<UserAssetGroup> load(String domainKey) throws StorageException {
		return new EntityIteratorImpl<>(UserAssetGroup.class, domainKey, "id.ownerUserId");
	}

	@Override
	public long count() throws StorageException {
		return new CommonDAO<>(UserAssetGroup.class).count();
	}

	@Override
	public long count(String domainKey) throws StorageException {
		return new CommonDAO<>(UserAssetGroup.class).count(domainKey);
	}

	@Override
	public long count(String domainKey, String ownerUserId) throws StorageException {
		return new CommonDAO<>(UserAssetGroup.class).count(domainKey, "ownerUserId", ownerUserId);
	}

	@Override
	public UserAssetGroup get(String domainKey, String ownerUserId, String groupId) throws StorageException {
		return new CommonDAO<>(UserAssetGroup.class).find(new UserAssetGroupId(domainKey, ownerUserId, groupId));
	}

	@Override
	public void delete(String domainKey) throws StorageException {
		new CommonDAO<>(UserAssetGroup.class).delete(domainKey);
	}

	@Override
	public void delete(String domainKey, String ownerUserId) throws StorageException {
		new CommonDAO<>(UserAssetGroup.class).delete(domainKey, "ownerUserId", ownerUserId);
	}

	@Override
	public void delete(String domainKey, String ownerUserId, String groupId) throws StorageException {
		new CommonDAO<>(UserAssetGroup.class).delete(domainKey, "ownerUserId", ownerUserId, "groupId", groupId);
	}

	@Override
	public Collection<UserAssetGroup> list(String domainKey, String ownerUserId, int page, int pageSize) throws StorageException {
		return new CommonDAO<>(UserAssetGroup.class).list(domainKey, "ownerUserId", ownerUserId, page, pageSize, "id.groupId");
	}

	@Override
	public Collection<UserAssetGroup> listNext(String domainKey, String ownerUserId, String groupId, int page, int pageSize)throws StorageException {
		return list(domainKey, ownerUserId, page, pageSize);
	}

	@Override
	public Collection<UserAssetGroup> search(String domainKey, String ownerUserId, String query, int pageSize) throws StorageException {
		return new CommonDAO<>(UserAssetGroup.class).search(query, domainKey, "ownerUserId", ownerUserId, pageSize);
	}

	@Override
	public void delete() throws StorageException {
		new CommonDAO<>(UserAssetGroup.class).delete();
	}

}
