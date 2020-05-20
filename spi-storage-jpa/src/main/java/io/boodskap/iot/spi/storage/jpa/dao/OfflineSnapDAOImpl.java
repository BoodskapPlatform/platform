package io.boodskap.iot.spi.storage.jpa.dao;

import java.util.Collection;
import java.util.Date;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.dao.OfflineSnapDAO;
import io.boodskap.iot.model.IOfflineSnap;
import io.boodskap.iot.model.jpa.OfflineSnap;
import io.boodskap.iot.model.jpa.OfflineSnapId;
import io.boodskap.iot.spi.storage.jpa.UOW;
import io.boodskap.iot.spi.storage.jpa.dao.util.CommonDAO;
import io.boodskap.iot.spi.storage.jpa.dao.util.EntityIteratorImpl;

public class OfflineSnapDAOImpl implements OfflineSnapDAO<OfflineSnap> {
	
	private static final OfflineSnapDAO<OfflineSnap> dao = new OfflineSnapDAOImpl();
	
	protected OfflineSnapDAOImpl() {
	}
	
	public static final OfflineSnapDAO<OfflineSnap> get() {
		return dao;
	}

	@Override
	public OfflineSnap create(String domainKey, String deviceId, String camera, Date stamp) {
		return new OfflineSnap(new OfflineSnapId(domainKey, deviceId, camera, stamp));
	}

	@Override
	public Class<? extends OfflineSnap> clazz() {
		return OfflineSnap.class;
	}

	@Override
	public void createOrUpdate(OfflineSnap e) throws StorageException {
		
		try {
			
			final IOfflineSnap oe = get(e.getDomainKey(), e.getDeviceId(), e.getCamera(), e.getStamp());
			IOfflineSnap ne;
			
			if(null == oe) {
				ne = new OfflineSnap(new OfflineSnapId(e.getDomainKey(), e.getDeviceId(), e.getCamera(), e.getStamp()));
			}else {
				ne = oe;
			}
			
			UOW.begin();
			
			ne.setData(e.getData());
			ne.setMime(e.getMime());
			
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
	public EntityIterator<OfflineSnap> load() throws StorageException {
		return new EntityIteratorImpl<>(OfflineSnap.class, "id.deviceId");
	}

	@Override
	public EntityIterator<OfflineSnap> load(String domainKey) throws StorageException {
		return new EntityIteratorImpl<>(OfflineSnap.class, domainKey, "id.deviceId");
	}

	@Override
	public long count() throws StorageException {
		return new CommonDAO<>(OfflineSnap.class).count();
	}

	@Override
	public long count(String domainKey) throws StorageException {
		return new CommonDAO<>(OfflineSnap.class).count(domainKey);
	}
	
	@Override
	public long count(String domainKey, String deviceId) throws StorageException {
		return new CommonDAO<>(OfflineSnap.class).count(domainKey, "deviceId", deviceId);
	}

	@Override
	public long count(String domainKey, String deviceId, String camera) throws StorageException {
		return new CommonDAO<>(OfflineSnap.class).count(domainKey, "deviceId", deviceId, "camera", camera);
	}

	@Override
	public OfflineSnap get(String domainKey, String deviceId, String camera, Date stamp) throws StorageException{
		return new CommonDAO<>(OfflineSnap.class).find(new OfflineSnapId(domainKey, deviceId, camera, stamp));
	}

	@Override
	public void delete(String domainKey) throws StorageException {
		new CommonDAO<>(OfflineSnap.class).delete(domainKey);
	}

	@Override
	public void delete(String domainKey, String deviceId) throws StorageException {
		new CommonDAO<>(OfflineSnap.class).delete(domainKey, "deviceId", deviceId);
	}

	@Override
	public void delete(String domainKey, String deviceId, String camera) throws StorageException {
		new CommonDAO<>(OfflineSnap.class).delete(domainKey, "deviceId", deviceId, "camera", camera);
	}

	@Override
	public void delete(String domainKey, String deviceId, String camera, Date stamp) throws StorageException {
		new CommonDAO<>(OfflineSnap.class).delete(domainKey, "deviceId", deviceId, "camera", camera, "stamp", stamp);
	}

	@Override
	public Collection<OfflineSnap> list(String domainKey, String deviceId, String camera, int page, int pageSize) throws StorageException {
		return new CommonDAO<>(OfflineSnap.class).list(domainKey, "deviceId", deviceId, "camera", camera, page, pageSize, "id.stamp");
	}

	@Override
	public Collection<OfflineSnap> listNext(String domainKey, String deviceId, String camera, Date stamp, int page, int pageSize) throws StorageException {
		return list(domainKey, deviceId, camera, page, pageSize);
	}

	@Override
	public void delete() throws StorageException {
		new CommonDAO<>(OfflineSnap.class).delete();
	}

}
