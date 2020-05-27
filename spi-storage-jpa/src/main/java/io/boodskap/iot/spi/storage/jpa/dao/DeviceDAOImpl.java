package io.boodskap.iot.spi.storage.jpa.dao;

import java.util.Collection;
import java.util.Date;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.DeviceDAO;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.model.IDevice;
import io.boodskap.iot.model.jpa.Device;
import io.boodskap.iot.model.jpa.DeviceId;
import io.boodskap.iot.spi.storage.jpa.UOW;
import io.boodskap.iot.spi.storage.jpa.dao.util.CommonDAO;
import io.boodskap.iot.spi.storage.jpa.dao.util.EntityIteratorImpl;

public class DeviceDAOImpl implements DeviceDAO<Device> {
	
	private static final DeviceDAO<Device> dao = new DeviceDAOImpl();
	
	protected DeviceDAOImpl() {
	}
	
	public static final DeviceDAO<Device> get() {
		return dao;
	}

	@Override
	public Device create(String domainKey, String deviceId) {
		return new Device(new DeviceId(domainKey, deviceId));
	}

	@Override
	public Class<? extends Device> clazz() {
		return Device.class;
	}

	@Override
	public void createOrUpdate(Device e) throws StorageException {
		
		try {
			
			final IDevice oe = get(e.getDomainKey(), e.getDeviceId());
			IDevice ne;
			
			if(null == oe) {
				ne = new Device(new DeviceId(e.getDomainKey(), e.getDeviceId()));
				ne.setRegisteredStamp(new Date());
			}else {
				ne = oe;
			}
			
			UOW.begin();
			
			ne.setAssetId(e.getAssetId());
			ne.setChannel(e.getChannel());
			ne.setDescription(e.getDescription());
			ne.setModelId(e.getModelId());
			ne.setName(e.getName());
			ne.setNodeId(e.getNodeId());
			ne.setNodeUid(e.getNodeUid());
			ne.setPassword(e.getPassword());
			ne.setReportedIp(e.getReportedIp());
			ne.setReportedPort(e.getReportedPort());
			ne.setVersion(e.getVersion());
			
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
	public EntityIterator<Device> load() throws StorageException {
		return new EntityIteratorImpl<>(Device.class, "id.deviceId");
	}

	@Override
	public EntityIterator<Device> load(String domainKey) throws StorageException {
		return new EntityIteratorImpl<>(Device.class, domainKey, "id.deviceId");
	}

	@Override
	public Device get(String domainKey, String deviceId) throws StorageException {
		return new CommonDAO<>(Device.class).find(new DeviceId(domainKey, deviceId));
	}

	@Override
	public long count() throws StorageException {
		return new CommonDAO<>(Device.class).count();
	}

	@Override
	public long count(String domainKey) throws StorageException {
		return new CommonDAO<>(Device.class).count(domainKey);
	}

	@Override
	public void delete(String domainKey) throws StorageException {
		new CommonDAO<>(Device.class).delete(domainKey);
	}

	@Override
	public void delete(String domainKey, String deviceId) throws StorageException {
		new CommonDAO<>(Device.class).delete(domainKey, "deviceId", deviceId);
	}

	@Override
	public String getLinkedAssetId(String domainKey, String deviceId) throws StorageException {
		final IDevice oe = get(domainKey, deviceId);
		return null != oe ? oe.getAssetId() : null;
	}

	@Override
	public Collection<Device> list(String domainKey, int page, int pageSize) throws StorageException {
		return new CommonDAO<>(Device.class).list(domainKey, page, pageSize, "id.deviceId");
	}

	@Override
	public Collection<Device> listNext(String domainKey, String deviceId, int page, int pageSize) throws StorageException {
		return list(domainKey, page, pageSize);
	}

	@Override
	public Collection<Device> search(String domainKey, String query, int pageSize) throws StorageException {
		return new CommonDAO<>(Device.class).search(query, domainKey, pageSize);
	}

	@Override
	public void delete() throws StorageException {
		new CommonDAO<>(Device.class).delete();
	}

}
