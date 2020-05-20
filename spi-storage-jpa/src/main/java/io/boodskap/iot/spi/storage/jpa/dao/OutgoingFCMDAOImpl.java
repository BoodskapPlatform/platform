package io.boodskap.iot.spi.storage.jpa.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.dao.OutgoingFCMDAO;
import io.boodskap.iot.model.IOutgoingFCM;
import io.boodskap.iot.model.jpa.OutgoingFCM;
import io.boodskap.iot.model.jpa.OutgoingFCMId;
import io.boodskap.iot.spi.storage.jpa.UOW;
import io.boodskap.iot.spi.storage.jpa.dao.util.CommonDAO;
import io.boodskap.iot.spi.storage.jpa.dao.util.EntityIteratorImpl;
import io.boodskap.iot.spi.storage.jpa.dao.util.StringFieldEntityIterator;

public class OutgoingFCMDAOImpl implements OutgoingFCMDAO<OutgoingFCM> {
	
	private static final OutgoingFCMDAO<OutgoingFCM> dao = new OutgoingFCMDAOImpl();
	
	protected OutgoingFCMDAOImpl() {
	}
	
	public static final OutgoingFCMDAO<OutgoingFCM> get() {
		return dao;
	}

	@Override
	public OutgoingFCM create(String domainKey, String notificationId) {
		return new OutgoingFCM(new OutgoingFCMId(domainKey, notificationId));
	}

	@Override
	public Class<? extends OutgoingFCM> clazz() {
		return OutgoingFCM.class;
	}

	@Override
	public void createOrUpdate(OutgoingFCM e) throws StorageException {
		
		try {
			
			final IOutgoingFCM oe = get(e.getDomainKey(), e.getNotificationId());
			IOutgoingFCM ne;
			
			if(null == oe) {
				ne = new OutgoingFCM(new OutgoingFCMId(e.getDomainKey(), e.getNotificationId()));
				ne.setQueuedAt(new Date());
			}else {
				ne = oe;
			}
			
			UOW.begin();
			
			ne.setContent(e.getContent());
			ne.setDeviceId(e.getDeviceId());
			ne.setFcmToken(e.getFcmToken());
			ne.setNotification(e.isNotification());
			ne.setReceipents(e.getReceipents());
			ne.setResponse(e.getResponse());
			ne.setSendor(e.getSendor());
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
	public EntityIterator<OutgoingFCM> load() throws StorageException {
		return new EntityIteratorImpl<>(OutgoingFCM.class, "id.notificationId");
	}

	@Override
	public EntityIterator<OutgoingFCM> load(String domainKey) throws StorageException {
		return new EntityIteratorImpl<>(OutgoingFCM.class, "id.notificationId");
	}

	@Override
	public long count() throws StorageException {
		return new CommonDAO<>(OutgoingFCM.class).count();
	}

	@Override
	public long count(String domainKey) throws StorageException {
		return new CommonDAO<>(OutgoingFCM.class).count(domainKey);
	}

	@Override
	public OutgoingFCM get(String id) throws StorageException {
		String query = "id.notificationId=:nid";
		Map<String, Serializable> params = new HashMap<>();
		params.put("nid", id);
		return new CommonDAO<>(OutgoingFCM.class).getUnique(query, params);
	}

	@Override
	public OutgoingFCM get(String domainKey, String id) throws StorageException {
		return new CommonDAO<>(OutgoingFCM.class).find(new OutgoingFCMId(domainKey, id));
	}

	@Override
	public void delete(String domainKey) throws StorageException {
		new CommonDAO<>(OutgoingFCM.class).delete(domainKey);
	}

	@Override
	public void delete(String domainKey, String id) throws StorageException {
		new CommonDAO<>(OutgoingFCM.class).delete(domainKey, "notificationId", id);
	}

	@Override
	public EntityIterator<String> loadIds() throws StorageException {
		return new StringFieldEntityIterator(OutgoingFCM.class, "id.notificationId", "queuedAt");
	}

	@Override
	public Collection<OutgoingFCM> list(String domainKey, int page, int pageSize) throws StorageException {
		return new CommonDAO<>(OutgoingFCM.class).list(domainKey, page, pageSize, "queuedAt");
	}

	@Override
	public Collection<OutgoingFCM> listNext(String domainKey, String id, int page, int pageSize) throws StorageException {
		return list(domainKey, page, pageSize);
	}

	@Override
	public void delete() throws StorageException {
		new CommonDAO<>(OutgoingFCM.class).delete();
	}

}
