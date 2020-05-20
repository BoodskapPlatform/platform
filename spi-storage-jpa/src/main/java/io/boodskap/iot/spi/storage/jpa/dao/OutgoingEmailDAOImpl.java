package io.boodskap.iot.spi.storage.jpa.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.dao.OutgoingEmailDAO;
import io.boodskap.iot.model.IOutgoingEmail;
import io.boodskap.iot.model.jpa.OutgoingEmail;
import io.boodskap.iot.model.jpa.OutgoingEmailId;
import io.boodskap.iot.spi.storage.jpa.UOW;
import io.boodskap.iot.spi.storage.jpa.dao.util.CommonDAO;
import io.boodskap.iot.spi.storage.jpa.dao.util.EntityIteratorImpl;
import io.boodskap.iot.spi.storage.jpa.dao.util.StringFieldEntityIterator;

public class OutgoingEmailDAOImpl implements OutgoingEmailDAO<OutgoingEmail> {
	
	private static final OutgoingEmailDAO<OutgoingEmail> dao = new OutgoingEmailDAOImpl();
	
	protected OutgoingEmailDAOImpl() {
	}
	
	public static final OutgoingEmailDAO<OutgoingEmail> get() {
		return dao;
	}

	@Override
	public OutgoingEmail create(String domainKey, String notificationId) {
		return new OutgoingEmail(new OutgoingEmailId(domainKey, notificationId));
	}

	@Override
	public Class<? extends OutgoingEmail> clazz() {
		return OutgoingEmail.class;
	}

	@Override
	public void createOrUpdate(OutgoingEmail e) throws StorageException {
		
		try {
			
			final IOutgoingEmail oe = get(e.getDomainKey(), e.getNotificationId());
			IOutgoingEmail ne;
			
			if(null == oe) {
				ne = new OutgoingEmail(new OutgoingEmailId(e.getDomainKey(), e.getNotificationId()));
				ne.setQueuedAt(new Date());
			}else {
				ne = oe;
			}
			
			UOW.begin();
			
			ne.setContent(e.getContent());
			ne.setDsResolrver(e.getDsResolrver());
			ne.setHtmlContent(e.getHtmlContent());
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
	public EntityIterator<OutgoingEmail> load() throws StorageException {
		return new EntityIteratorImpl<>(OutgoingEmail.class, "id.notificationId");
	}

	@Override
	public EntityIterator<OutgoingEmail> load(String domainKey) throws StorageException {
		return new EntityIteratorImpl<>(OutgoingEmail.class, domainKey, "id.notificationId");
	}

	@Override
	public long count() throws StorageException {
		return new CommonDAO<>(OutgoingEmail.class).count();
	}

	@Override
	public long count(String domainKey) throws StorageException {
		return new CommonDAO<>(OutgoingEmail.class).count(domainKey);
	}

	@Override
	public OutgoingEmail get(String id) throws StorageException {
		String query = "id.notificationId=:nid";
		Map<String, Serializable> params = new HashMap<>();
		params.put("nid", id);
		return new CommonDAO<>(OutgoingEmail.class).getUnique(query, params);
	}

	@Override
	public OutgoingEmail get(String domainKey, String id) throws StorageException {
		return new CommonDAO<>(OutgoingEmail.class).find(new OutgoingEmailId(domainKey, id));
	}

	@Override
	public void delete(String domainKey) throws StorageException {
		new CommonDAO<>(OutgoingEmail.class).delete(domainKey);
	}

	@Override
	public void delete(String domainKey, String id) throws StorageException {
		new CommonDAO<>(OutgoingEmail.class).delete(domainKey, "notificationId", id);
	}

	@Override
	public EntityIterator<String> loadIds() throws StorageException {
		return new StringFieldEntityIterator(OutgoingEmail.class, "id.notificationId", "queuedAt");
	}

	@Override
	public Collection<OutgoingEmail> list(String domainKey, int page, int pageSize) throws StorageException {
		return new CommonDAO<>(OutgoingEmail.class).list(domainKey, page, pageSize, "queuedAt");
	}

	@Override
	public Collection<OutgoingEmail> listNext(String domainKey, String id, int page, int pageSize) throws StorageException {
		return list(domainKey, page, pageSize);
	}

	@Override
	public void delete() throws StorageException {
		new CommonDAO<>(OutgoingEmail.class).delete();
	}

}
