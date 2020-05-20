package io.boodskap.iot.spi.storage.jpa.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.dao.SentFCMDAO;
import io.boodskap.iot.model.ISentFCM;
import io.boodskap.iot.model.jpa.SentFCM;
import io.boodskap.iot.model.jpa.SentNotificationId;
import io.boodskap.iot.spi.storage.jpa.UOW;
import io.boodskap.iot.spi.storage.jpa.dao.util.CommonDAO;
import io.boodskap.iot.spi.storage.jpa.dao.util.EntityIteratorImpl;

public class SentFCMDAOImpl implements SentFCMDAO<SentFCM> {
	
	private static final SentFCMDAO<SentFCM> dao = new SentFCMDAOImpl();
	
	protected SentFCMDAOImpl() {
	}
	
	public static final SentFCMDAO<SentFCM> get() {
		return dao;
	}

	@Override
	public SentFCM create(String domainKey, String notificationId) {
		return new SentFCM(new SentNotificationId(domainKey, notificationId));
	}

	@Override
	public Class<? extends SentFCM> clazz() {
		return SentFCM.class;
	}

	@Override
	public void createOrUpdate(SentFCM e) throws StorageException {
		
		try {
			
			final ISentFCM oe = get(e.getDomainKey(), e.getNotificationId());
			ISentFCM ne;
			
			if(null == oe) {
				ne = new SentFCM(new SentNotificationId(e.getDomainKey(), e.getNotificationId()));
			}else {
				ne = oe;
			}
			
			UOW.begin();
			
			ne.setContent(e.getContent());
			ne.setDeviceId(e.getDeviceId());
			ne.setFcmToken(e.getFcmToken());
			ne.setNotification(e.isNotification());
			ne.setProgress(e.getProgress());
			ne.setQueuedAt(e.getQueuedAt());
			ne.setReceipent(e.getReceipent());
			ne.setResponse(e.getResponse());
			ne.setSentAt(e.getSentAt());
			ne.setStatus(e.getStatus());
			ne.setSubject(e.getSubject());
			
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
	public EntityIterator<SentFCM> load() throws StorageException {
		return new EntityIteratorImpl<>(SentFCM.class, "id.notificationId");
	}

	@Override
	public EntityIterator<SentFCM> load(String domainKey) throws StorageException {
		return new EntityIteratorImpl<>(SentFCM.class, domainKey, "id.notificationId");
	}

	@Override
	public long count() throws StorageException {
		return new CommonDAO<>(SentFCM.class).count();
	}

	@Override
	public long count(String domainKey) throws StorageException {
		return new CommonDAO<>(SentFCM.class).count(domainKey);
	}

	@Override
	public SentFCM get(String id) throws StorageException {
		String query = "v.id=:fid";
		Map<String, Serializable> params = new HashMap<>();
		params.put("fid", id);
		return new CommonDAO<>(SentFCM.class).get(query, params);
	}

	@Override
	public SentFCM get(String domainKey, String id) throws StorageException {
		return new CommonDAO<>(SentFCM.class).find(new SentNotificationId(domainKey, id));
	}

	@Override
	public void delete(String domainKey) throws StorageException {
		new CommonDAO<>(SentFCM.class).delete(domainKey);
	}

	@Override
	public void delete(String domainKey, String id) throws StorageException {
		new CommonDAO<>(SentFCM.class).delete(domainKey, "notificationId", id);
	}

	@Override
	public Collection<SentFCM> list(String domainKey, int page, int pageSize) throws StorageException {
		return new CommonDAO<>(SentFCM.class).list(domainKey, page, pageSize, "id.notificationId");
	}

	@Override
	public Collection<SentFCM> listNext(String domainKey, String id, int page, int pageSize) throws StorageException {
		return list(domainKey, page, pageSize);
	}

	@Override
	public void delete() throws StorageException {
		new CommonDAO<>(SentFCM.class).delete();
	}

}
