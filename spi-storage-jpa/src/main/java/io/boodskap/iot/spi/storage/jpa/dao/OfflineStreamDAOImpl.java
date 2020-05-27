package io.boodskap.iot.spi.storage.jpa.dao;

import java.util.Collection;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.dao.OfflineStreamDAO;
import io.boodskap.iot.model.IOfflineStream;
import io.boodskap.iot.model.jpa.OfflineStream;
import io.boodskap.iot.model.jpa.OfflineStreamId;
import io.boodskap.iot.spi.storage.jpa.UOW;
import io.boodskap.iot.spi.storage.jpa.dao.util.CommonDAO;
import io.boodskap.iot.spi.storage.jpa.dao.util.EntityIteratorImpl;

public class OfflineStreamDAOImpl implements OfflineStreamDAO<OfflineStream> {
	
	private static final OfflineStreamDAO<OfflineStream> dao = new OfflineStreamDAOImpl();
	
	protected OfflineStreamDAOImpl() {
	}
	
	public static final OfflineStreamDAO<OfflineStream> get() {
		return dao;
	}

	@Override
	public OfflineStream create(String domainKey, String deviceId, String camera, String session, int frame) {
		return new OfflineStream(new OfflineStreamId(domainKey, deviceId, camera, session, frame));
	}

	@Override
	public Class<? extends OfflineStream> clazz() {
		return OfflineStream.class;
	}

	@Override
	public void createOrUpdate(OfflineStream e) throws StorageException {
		
		try {
			
			final IOfflineStream oe = get(e.getDomainKey(), e.getDeviceId(), e.getCamera(), e.getSession(), e.getFrame());
			IOfflineStream ne;
			
			if(null == oe) {
				ne = new OfflineStream(new OfflineStreamId(e.getDomainKey(), e.getDeviceId(), e.getCamera(), e.getSession(), e.getFrame()));
			}else {
				ne = oe;
			}
			
			UOW.begin();
			
			ne.setFrame(e.getFrame());
			ne.setMime(e.getMime());
			ne.setData(e.getData());
			
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
	public EntityIterator<OfflineStream> load() throws StorageException {
		return new EntityIteratorImpl<>(OfflineStream.class, "id.deviceId");
	}

	@Override
	public EntityIterator<OfflineStream> load(String domainKey) throws StorageException {
		return new EntityIteratorImpl<>(OfflineStream.class, domainKey, "id.deviceId");
	}

	@Override
	public long count() throws StorageException {
		return new CommonDAO<>(OfflineStream.class).count();
	}

	@Override
	public long count(String domainKey) throws StorageException {
		return new CommonDAO<>(OfflineStream.class).count(domainKey);
	}

	@Override
	public long count(String domainKey, String deviceId) throws StorageException {
		return new CommonDAO<>(OfflineStream.class).count(domainKey, "deviceId", deviceId);
	}

	@Override
	public long count(String domainKey, String deviceId, String camera) throws StorageException {
		return new CommonDAO<>(OfflineStream.class).count(domainKey, "deviceId", deviceId, "camera", camera);
	}

	@Override
	public long count(String domainKey, String deviceId, String camera, String session) throws StorageException {
		return new CommonDAO<>(OfflineStream.class).count(domainKey, "deviceId", deviceId, "camera", camera, "session", session);
	}

	@Override
	public OfflineStream get(String domainKey, String deviceId, String camera, String session, int frame) throws StorageException {
		return new CommonDAO<>(OfflineStream.class).find(new OfflineStreamId(domainKey, deviceId, camera, session, frame));
	}

	@Override
	public void delete(String domainKey) throws StorageException {
		new CommonDAO<>(OfflineStream.class).delete(domainKey);
	}

	@Override
	public void delete(String domainKey, String deviceId) throws StorageException {
		new CommonDAO<>(OfflineStream.class).delete(domainKey, "deviceId", deviceId);
	}

	@Override
	public void delete(String domainKey, String deviceId, String camera) throws StorageException {
		new CommonDAO<>(OfflineStream.class).delete(domainKey, "deviceId", deviceId, "camera", camera);
	}

	@Override
	public void delete(String domainKey, String deviceId, String camera, String session) throws StorageException {
		new CommonDAO<>(OfflineStream.class).delete(domainKey, "deviceId", deviceId, "camera", camera, "session", session);
	}

	@Override
	public void delete(String domainKey, String deviceId, String camera, String session, int frame) throws StorageException {
		new CommonDAO<>(OfflineStream.class).delete(domainKey, "deviceId", deviceId, "camera", camera, "session", session, "frame", frame);
	}

	@Override
	public Collection<OfflineStream> list(String domainKey, String deviceId, String camera, String session, int page, int pageSize) throws StorageException {
		return new CommonDAO<>(OfflineStream.class).list(domainKey, "deviceId", deviceId, "camera", camera, "session", session, page, pageSize, "id.frame");
	}

	@Override
	public Collection<OfflineStream> listNext(String domainKey, String deviceId, String camera, String session, int frame, int page, int pageSize) throws StorageException {
		return list(domainKey, deviceId, camera, session, page, pageSize);
	}

	@Override
	public void delete() throws StorageException {
		new CommonDAO<>(OfflineStream.class).delete();
	}

}
