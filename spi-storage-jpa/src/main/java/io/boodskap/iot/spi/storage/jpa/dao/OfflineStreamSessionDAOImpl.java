package io.boodskap.iot.spi.storage.jpa.dao;

import java.util.Collection;
import java.util.Date;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.dao.OfflineStreamSessionDAO;
import io.boodskap.iot.model.IOfflineStreamSession;
import io.boodskap.iot.model.jpa.OfflineStreamSession;
import io.boodskap.iot.model.jpa.OfflineStreamSessionId;
import io.boodskap.iot.spi.storage.jpa.UOW;
import io.boodskap.iot.spi.storage.jpa.dao.util.CommonDAO;
import io.boodskap.iot.spi.storage.jpa.dao.util.EntityIteratorImpl;
import io.boodskap.iot.spi.storage.jpa.dao.util.StringFieldEntityList;

public class OfflineStreamSessionDAOImpl implements OfflineStreamSessionDAO<OfflineStreamSession> {
	
	private static final OfflineStreamSessionDAO<OfflineStreamSession> dao = new OfflineStreamSessionDAOImpl();

	protected OfflineStreamSessionDAOImpl() {
	}
	
	public static final OfflineStreamSessionDAO<OfflineStreamSession> get() {
		return dao;
	}

	@Override
	public OfflineStreamSession create(String domainKey, String deviceId, String camera, String session) {
		return new OfflineStreamSession(new OfflineStreamSessionId(domainKey, deviceId, camera, session));
	}

	@Override
	public Class<? extends OfflineStreamSession> clazz() {
		return OfflineStreamSession.class;
	}

	@Override
	public void createOrUpdate(OfflineStreamSession e) throws StorageException {
		
		try {
			
			final IOfflineStreamSession oe = get(e.getDomainKey(), e.getDeviceId(), e.getCamera(), e.getSession());
			IOfflineStreamSession ne;
			
			if(null == oe) {
				ne = new OfflineStreamSession(new OfflineStreamSessionId(e.getDomainKey(), e.getDeviceId(), e.getCamera(), e.getSession()));
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
	public EntityIterator<OfflineStreamSession> load() throws StorageException {
		return new EntityIteratorImpl<>(OfflineStreamSession.class, "id.deviceId");
	}

	@Override
	public EntityIterator<OfflineStreamSession> load(String domainKey) throws StorageException {
		return new EntityIteratorImpl<>(OfflineStreamSession.class, domainKey, "id.deviceId");
	}

	@Override
	public long count() throws StorageException {
		return new CommonDAO<>(OfflineStreamSession.class).count();
	}

	@Override
	public long count(String domainKey) throws StorageException {
		return new CommonDAO<>(OfflineStreamSession.class).count(domainKey);
	}

	@Override
	public long count(String domainKey, String deviceId) throws StorageException {
		return new CommonDAO<>(OfflineStreamSession.class).count(domainKey, "deviceId", deviceId);
	}

	@Override
	public long count(String domainKey, String deviceId, String camera) throws StorageException {
		return new CommonDAO<>(OfflineStreamSession.class).count(domainKey, "deviceId", deviceId, "camera", camera);
	}

	@Override
	public OfflineStreamSession get(String domainKey, String deviceId, String camera, String session)throws StorageException {
		return new CommonDAO<>(OfflineStreamSession.class).find(new OfflineStreamSessionId(domainKey, deviceId, camera, session));
	}

	@Override
	public void delete(String domainKey) throws StorageException {
		new CommonDAO<>(OfflineStreamSession.class).delete(domainKey);
	}

	@Override
	public void delete(String domainKey, String deviceId) throws StorageException {
		new CommonDAO<>(OfflineStreamSession.class).delete(domainKey, "deviceId", deviceId);
	}

	@Override
	public void delete(String domainKey, String deviceId, String camera) throws StorageException {
		new CommonDAO<>(OfflineStreamSession.class).delete(domainKey, "deviceId", deviceId, "camera", camera);
	}

	@Override
	public void delete(String domainKey, String deviceId, String camera, String session) throws StorageException {
		new CommonDAO<>(OfflineStreamSession.class).delete(domainKey, "deviceId", deviceId, "camera", camera, "session", session);
	}

	@Override
	public Collection<String> listSessions(String domainKey, String deviceId, String camera, int page, int pageSize) {
		return new StringFieldEntityList(OfflineStreamSession.class, "id.session", "deviceId", deviceId, "camera", camera, "id.session").list(page, pageSize);
	}

	@Override
	public Collection<String> listSessionsNext(String domainKey, String deviceId, String camera, String session, int page, int pageSize) {
		return listSessions(domainKey, deviceId, camera, page, pageSize);
	}

	@Override
	public Collection<OfflineStreamSession> list(String domainKey, String deviceId, String camera, int page, int pageSize) throws StorageException {
		return new CommonDAO<>(OfflineStreamSession.class).list(domainKey, "deviceId", deviceId, "camera", camera, page, pageSize, "id.session");
	}

	@Override
	public Collection<OfflineStreamSession> listNext(String domainKey, String deviceId, String camera, String session, int frame, int page, int pageSize) throws StorageException {
		return list(domainKey, deviceId, camera, page, pageSize);
	}

	@Override
	public void delete() throws StorageException {
		new CommonDAO<>(OfflineStreamSession.class).delete();
	}

}
