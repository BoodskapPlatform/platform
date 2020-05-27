package io.boodskap.iot.spi.storage.jpa.dao;

import java.util.Collection;
import java.util.Date;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.dao.UserDeviceGroupDAO;
import io.boodskap.iot.model.IUserDeviceGroup;
import io.boodskap.iot.model.jpa.UserDeviceGroup;
import io.boodskap.iot.model.jpa.UserDeviceGroupId;
import io.boodskap.iot.spi.storage.jpa.UOW;
import io.boodskap.iot.spi.storage.jpa.dao.util.CommonDAO;
import io.boodskap.iot.spi.storage.jpa.dao.util.EntityIteratorImpl;

public class UserDeviceGroupDAOImpl implements UserDeviceGroupDAO<UserDeviceGroup> {
	
	private static final UserDeviceGroupDAO<UserDeviceGroup> dao = new UserDeviceGroupDAOImpl();
	
	protected UserDeviceGroupDAOImpl() {
	}
	
	public static final UserDeviceGroupDAO<UserDeviceGroup> get() {
		return dao;
	}

	@Override
	public UserDeviceGroup create(String domainKey, String ownerUserId, String groupId) {
		return new UserDeviceGroup(new UserDeviceGroupId(domainKey, ownerUserId, groupId));
	}

	@Override
	public Class<? extends UserDeviceGroup> clazz() {
		return UserDeviceGroup.class;
	}

	@Override
	public void createOrUpdate(UserDeviceGroup e) throws StorageException {
		
		try {
			
			final IUserDeviceGroup oe = get(e.getDomainKey(), e.getOwnerUserId(), e.getGroupId());
			IUserDeviceGroup ne;
			
			if(null == oe) {
				ne = new UserDeviceGroup(new UserDeviceGroupId(e.getDomainKey(), e.getOwnerUserId(), e.getGroupId()));
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
	public EntityIterator<UserDeviceGroup> load() throws StorageException {
		return new EntityIteratorImpl<>(UserDeviceGroup.class, "id.ownerUserId");
	}

	@Override
	public EntityIterator<UserDeviceGroup> load(String domainKey) throws StorageException {
		return new EntityIteratorImpl<>(UserDeviceGroup.class, domainKey, "id.ownerUserId");
	}

	@Override
	public long count() throws StorageException {
		return new CommonDAO<>(UserDeviceGroup.class).count();
	}

	@Override
	public long count(String domainKey) throws StorageException {
		return new CommonDAO<>(UserDeviceGroup.class).count(domainKey);
	}

	@Override
	public long count(String domainKey, String ownerUserId) throws StorageException {
		return new CommonDAO<>(UserDeviceGroup.class).count(domainKey, "ownerUserId", ownerUserId);
	}

	@Override
	public UserDeviceGroup get(String domainKey, String ownerUserId, String groupId) throws StorageException {
		return new CommonDAO<>(UserDeviceGroup.class).find(new UserDeviceGroupId(domainKey, ownerUserId, groupId));
	}

	@Override
	public void delete(String domainKey) throws StorageException {
		new CommonDAO<>(UserDeviceGroup.class).delete(domainKey);
	}

	@Override
	public void delete(String domainKey, String ownerUserId) throws StorageException {
		new CommonDAO<>(UserDeviceGroup.class).delete(domainKey, "ownerUserId", ownerUserId);
	}

	@Override
	public void delete(String domainKey, String ownerUserId, String groupId) throws StorageException {
		new CommonDAO<>(UserDeviceGroup.class).delete(domainKey, "ownerUserId", ownerUserId, "groupId", groupId);
	}

	@Override
	public Collection<UserDeviceGroup> list(String domainKey, String ownerUserId, int page, int pageSize) throws StorageException {
		return new CommonDAO<>(UserDeviceGroup.class).list(domainKey, "ownerUserId", ownerUserId, page, pageSize, "id.groupId");
	}

	@Override
	public Collection<UserDeviceGroup> listNext(String domainKey, String ownerUserId, String groupId, int page, int pageSize)throws StorageException {
		return list(domainKey, ownerUserId, page, pageSize);
	}

	@Override
	public Collection<UserDeviceGroup> search(String domainKey, String ownerUserId, String query, int pageSize) throws StorageException {
		return new CommonDAO<>(UserDeviceGroup.class).search(query, domainKey, "ownerUserId", ownerUserId, pageSize);
	}

	@Override
	public void delete() throws StorageException {
		new CommonDAO<>(UserDeviceGroup.class).delete();
	}

}
