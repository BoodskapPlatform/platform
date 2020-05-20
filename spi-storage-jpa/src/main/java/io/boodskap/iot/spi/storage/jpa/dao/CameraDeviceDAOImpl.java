package io.boodskap.iot.spi.storage.jpa.dao;

import java.util.Collection;
import java.util.Date;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.CameraDeviceDAO;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.model.ICameraDevice;
import io.boodskap.iot.model.jpa.CameraDevice;
import io.boodskap.iot.model.jpa.CameraDeviceId;
import io.boodskap.iot.spi.storage.jpa.UOW;
import io.boodskap.iot.spi.storage.jpa.dao.util.CommonDAO;
import io.boodskap.iot.spi.storage.jpa.dao.util.EntityIteratorImpl;
import io.boodskap.iot.spi.storage.jpa.dao.util.StringFieldEntityList;

public class CameraDeviceDAOImpl implements CameraDeviceDAO<CameraDevice> {
	
	private static final CameraDeviceDAO<CameraDevice> dao = new CameraDeviceDAOImpl();

	protected CameraDeviceDAOImpl() {
	}
	
	public static final CameraDeviceDAO<CameraDevice> get() {
		return dao;
	}

	@Override
	public CameraDevice create(String domainKey, String deviceId, String camera) {
		return new CameraDevice(new CameraDeviceId(domainKey, deviceId, camera));
	}

	@Override
	public Class<? extends CameraDevice> clazz() {
		return CameraDevice.class;
	}

	@Override
	public void createOrUpdate(CameraDevice e) throws StorageException {
		
		try {
			
			final ICameraDevice oe = get(e.getDomainKey(), e.getDeviceId(), e.getCamera());
			ICameraDevice ne;
			
			if(null == oe) {
				ne = new CameraDevice(new CameraDeviceId(e.getDomainKey(), e.getDeviceId(), e.getCamera()));
				ne.setCreatedStamp(new Date());
			}else {
				ne = oe;
			}
			
			UOW.begin();
			
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
	public EntityIterator<CameraDevice> load() throws StorageException {
		return new EntityIteratorImpl<>(CameraDevice.class, "id.deviceId");
	}

	@Override
	public EntityIterator<CameraDevice> load(String domainKey) throws StorageException {
		return new EntityIteratorImpl<>(CameraDevice.class, domainKey, "id.deviceId");
	}

	@Override
	public long count() throws StorageException {
		return new CommonDAO<>(CameraDevice.class).count();
	}

	@Override
	public long count(String domainKey) throws StorageException {
		return new CommonDAO<>(CameraDevice.class).count(domainKey);
	}

	@Override
	public void delete(String domainKey) throws StorageException {
		new CommonDAO<>(CameraDevice.class).delete(domainKey);
	}

	@Override
	public void delete(String domainKey, String deviceId, String camera) throws StorageException {
		new CommonDAO<>(CameraDevice.class).delete(domainKey, "deviceId", deviceId, "camera", camera);
	}

	@Override
	public CameraDevice get(String domainKey, String deviceId, String camera) throws StorageException {
		return new CommonDAO<>(CameraDevice.class).find(new CameraDeviceId(domainKey, deviceId, camera));
	}

	@Override
	public Collection<String> listCameras(String domainKey, String deviceId) {
		return new StringFieldEntityList(CameraDevice.class, "id.camera", "domainKey", domainKey, "deviceId", deviceId, "id.camera").list();
	}

	@Override
	public Collection<CameraDevice> list(String domainKey, int page, int pageSize) throws StorageException {
		return new CommonDAO<>(CameraDevice.class).list(domainKey, page, pageSize, "id.deviceId");
	}

	@Override
	public Collection<CameraDevice> listNext(String domainKey, String deviceId, int page, int pageSize) throws StorageException {
		return list(domainKey, page, pageSize);
	}

	@Override
	public Collection<CameraDevice> search(String domainKey, String query, int pageSize) throws StorageException {
		return new CommonDAO<>(CameraDevice.class).search(query, domainKey, pageSize);
	}

	@Override
	public void delete() throws StorageException {
		new CommonDAO<>(CameraDevice.class).delete();
	}

}
