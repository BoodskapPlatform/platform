package io.boodskap.iot.spi.storage.jpa.dao;

import java.util.Collection;
import java.util.Date;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.DeviceFriendDAO;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.model.IDeviceFriend;
import io.boodskap.iot.model.jpa.DeviceFriend;
import io.boodskap.iot.model.jpa.DeviceFriendId;
import io.boodskap.iot.spi.storage.jpa.UOW;
import io.boodskap.iot.spi.storage.jpa.dao.util.CommonDAO;
import io.boodskap.iot.spi.storage.jpa.dao.util.EntityIteratorImpl;

public class DeviceFriendDAOImpl implements DeviceFriendDAO<DeviceFriend> {
	
	private static final DeviceFriendDAO<DeviceFriend> dao = new DeviceFriendDAOImpl();
	
	protected DeviceFriendDAOImpl() {
	}
	
	public static final DeviceFriendDAO<DeviceFriend> get() {
		return dao;
	}

	@Override
	public DeviceFriend create(String domainKey, String deviceId, String friendId) {
		return new DeviceFriend(new DeviceFriendId(domainKey, deviceId, friendId));
	}

	@Override
	public Class<? extends DeviceFriend> clazz() {
		return DeviceFriend.class;
	}

	@Override
	public void createOrUpdate(DeviceFriend e) throws StorageException {
		
		try {
			
			final IDeviceFriend oe = get(e.getDomainKey(), e.getDeviceId(), e.getFriendId());
			IDeviceFriend ne;
			
			if(null == oe) {
				ne = new DeviceFriend(new DeviceFriendId(e.getDomainKey(), e.getDeviceId(), e.getFriendId()));
				ne.setCreatedStamp(new Date());
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
	public EntityIterator<DeviceFriend> load() throws StorageException {
		return new EntityIteratorImpl<>(DeviceFriend.class, "id.deviceId");
	}

	@Override
	public EntityIterator<DeviceFriend> load(String domainKey) throws StorageException {
		return new EntityIteratorImpl<>(DeviceFriend.class, domainKey, "id.deviceId");
	}

	@Override
	public EntityIterator<DeviceFriend> load(String domainKey, String deviceId) throws StorageException {
		return new EntityIteratorImpl<>(DeviceFriend.class, domainKey, "deviceId", deviceId, "id.friendId");
	}

	@Override
	public long count() throws StorageException {
		return new CommonDAO<>(DeviceFriend.class).count();
	}

	@Override
	public long count(String domainKey) throws StorageException {
		return new CommonDAO<>(DeviceFriend.class).count(domainKey);
	}

	@Override
	public long count(String domainKey, String deviceId) throws StorageException {
		return new CommonDAO<>(DeviceFriend.class).count(domainKey, "deviceId", deviceId);
	}

	@Override
	public DeviceFriend get(String domainKey, String deviceId, String friendId) throws StorageException {
		return new CommonDAO<>(DeviceFriend.class).find(new DeviceFriendId(domainKey, deviceId, friendId));
	}

	@Override
	public void delete(String domainKey) throws StorageException {
		new CommonDAO<>(DeviceFriend.class).delete(domainKey);
	}

	@Override
	public void delete(String domainKey, String deviceId) throws StorageException {
		new CommonDAO<>(DeviceFriend.class).delete(domainKey, "deviceId", deviceId);
	}

	@Override
	public void delete(String domainKey, String deviceId, String friendId) throws StorageException {
		new CommonDAO<>(DeviceFriend.class).delete(domainKey, "deviceId", deviceId, "friendId", friendId);
	}

	@Override
	public Collection<DeviceFriend> list(String domainKey, String deviceId, int page, int pageSize) throws StorageException {
		return new CommonDAO<>(DeviceFriend.class).list(domainKey, "deviceId", deviceId, page, pageSize, "id.friendId");
	}

	@Override
	public Collection<DeviceFriend> listNext(String domainKey, String deviceId, String friendId, int page, int pageSize) throws StorageException {
		return list(domainKey, deviceId, page, pageSize);
	}

	@Override
	public Collection<DeviceFriend> search(String domainKey, String deviceId, String query, int pageSize) throws StorageException {
		return new CommonDAO<>(DeviceFriend.class).search(query, domainKey, "deviceId", deviceId, pageSize);
	}

	@Override
	public void delete() throws StorageException {
		new CommonDAO<>(DeviceFriend.class).delete();
	}

}
