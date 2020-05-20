package io.boodskap.iot.spi.storage.jpa.dao;

import java.util.Collection;
import java.util.Date;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.dao.FCMDeviceDAO;
import io.boodskap.iot.model.IFCMDevice;
import io.boodskap.iot.model.jpa.FCMDevice;
import io.boodskap.iot.model.jpa.FCMDeviceId;
import io.boodskap.iot.spi.storage.jpa.UOW;
import io.boodskap.iot.spi.storage.jpa.dao.util.CommonDAO;
import io.boodskap.iot.spi.storage.jpa.dao.util.EntityIteratorImpl;

public class FCMDeviceDAOImpl implements FCMDeviceDAO<FCMDevice> {
	
	private static final FCMDeviceDAO<FCMDevice> dao = new FCMDeviceDAOImpl();
	
	protected FCMDeviceDAOImpl() {
	}
	
	public static final FCMDeviceDAO<FCMDevice> get() {
		return dao;
	}

	@Override
	public FCMDevice create(String domainKey, String deviceId) {
		return new FCMDevice(new FCMDeviceId(domainKey, deviceId));
	}

	@Override
	public Class<? extends FCMDevice> clazz() {
		return FCMDevice.class;
	}

	@Override
	public void createOrUpdate(FCMDevice e) throws StorageException {
		try {
			
			final IFCMDevice oe = get(e.getDomainKey(), e.getDeviceId());
			IFCMDevice ne;
			
			if(null == oe) {
				ne = new FCMDevice(new FCMDeviceId(e.getDomainKey(), e.getDeviceId()));
				ne.setCreatedStamp(new Date());
			}else {
				ne = oe;
			}
			
			UOW.begin();
			
			ne.setFcmToken(e.getFcmToken());
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
	public EntityIterator<FCMDevice> load() throws StorageException {
		return new EntityIteratorImpl<>(FCMDevice.class, "id.deviceId");
	}

	@Override
	public EntityIterator<FCMDevice> load(String domainKey) throws StorageException {
		return new EntityIteratorImpl<>(FCMDevice.class, domainKey, "id.deviceId");
	}

	@Override
	public long count() throws StorageException {
		return new CommonDAO<>(FCMDevice.class).count();
	}

	@Override
	public long count(String domainKey) throws StorageException {
		return new CommonDAO<>(FCMDevice.class).count(domainKey);
	}

	@Override
	public FCMDevice get(String domainKey, String deviceId) throws StorageException {
		return new CommonDAO<>(FCMDevice.class).find(new FCMDeviceId(domainKey, deviceId));
	}

	@Override
	public void delete(String domainKey) throws StorageException {
		new CommonDAO<>(FCMDevice.class).delete(domainKey);
	}

	@Override
	public void delete(String domainKey, String deviceId) throws StorageException {
		new CommonDAO<>(FCMDevice.class).delete(domainKey, "deviceId", deviceId);
	}

	@Override
	public Collection<FCMDevice> list(String domainKey, int page, int pageSize) throws StorageException {
		return new CommonDAO<>(FCMDevice.class).list(domainKey, page, pageSize, "id.deviceId");
	}

	@Override
	public Collection<FCMDevice> listNext(String domainKey, String deviceId, int page, int pageSize) throws StorageException {
		return list(domainKey, page, pageSize);
	}

	@Override
	public Collection<FCMDevice> search(String domainKey, String query, int pageSize) throws StorageException {
		return new CommonDAO<>(FCMDevice.class).search(query, domainKey, pageSize);
	}

	@Override
	public void delete() throws StorageException {
		new CommonDAO<>(FCMDevice.class).delete();
	}

}
