package io.boodskap.iot.spi.storage.jpa.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.dao.SentSmsDAO;
import io.boodskap.iot.model.ISentSms;
import io.boodskap.iot.model.jpa.SentNotificationId;
import io.boodskap.iot.model.jpa.SentSms;
import io.boodskap.iot.spi.storage.jpa.UOW;
import io.boodskap.iot.spi.storage.jpa.dao.util.CommonDAO;
import io.boodskap.iot.spi.storage.jpa.dao.util.EntityIteratorImpl;

public class SentSmsDAOImpl implements SentSmsDAO<SentSms> {
	
	private static final SentSmsDAO<SentSms> dao = new SentSmsDAOImpl();
	
	protected SentSmsDAOImpl() {
	}
	
	public static final SentSmsDAO<SentSms> get() {
		return dao;
	}

	@Override
	public SentSms create(String domainKey, String notificationId) {
		return new SentSms(new SentNotificationId(domainKey, notificationId));
	}

	@Override
	public Class<? extends SentSms> clazz() {
		return SentSms.class;
	}

	@Override
	public void createOrUpdate(SentSms e) throws StorageException {
		
		try {
			
			final ISentSms oe = get(e.getDomainKey(), e.getNotificationId());
			ISentSms ne;
			
			if(null == oe) {
				ne = new SentSms(new SentNotificationId(e.getDomainKey(), e.getNotificationId()));
			}else {
				ne = oe;
			}
			
			UOW.begin();
			
			ne.setContent(e.getContent());
			ne.setProgress(e.getProgress());
			ne.setQueuedAt(e.getQueuedAt());
			ne.setReceipent(e.getReceipent());
			ne.setResponse(e.getResponse());
			ne.setSentAt(e.getSentAt());
			ne.setStatus(e.getStatus());
			ne.setSubject(e.getSubject());
			ne.setSendor(e.getSendor());
			ne.setSid(e.getSid());
			
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
	public EntityIterator<SentSms> load() throws StorageException {
		return new EntityIteratorImpl<>(SentSms.class, "id.notificationId");
	}

	@Override
	public EntityIterator<SentSms> load(String domainKey) throws StorageException {
		return new EntityIteratorImpl<>(SentSms.class, domainKey, "id.notificationId");
	}

	@Override
	public long count() throws StorageException {
		return new CommonDAO<>(SentSms.class).count();
	}

	@Override
	public long count(String domainKey) throws StorageException {
		return new CommonDAO<>(SentSms.class).count(domainKey);
	}

	@Override
	public SentSms get(String id) throws StorageException {
		String query = "v.id=:sid";
		Map<String, Serializable> params = new HashMap<>();
		params.put("sid", id);
		return new CommonDAO<>(SentSms.class).get(query, params);
	}

	@Override
	public SentSms getBySid(String sid) throws StorageException {
		String query = "v.sid=:esid";
		Map<String, Serializable> params = new HashMap<>();
		params.put("esid", sid);
		return new CommonDAO<>(SentSms.class).get(query, params);
	}

	@Override
	public SentSms get(String domainKey, String id) throws StorageException {
		return new CommonDAO<>(SentSms.class).find(new SentNotificationId(domainKey, id));
	}

	@Override
	public void delete(String domainKey) throws StorageException {
		new CommonDAO<>(SentSms.class).delete(domainKey);
	}

	@Override
	public void delete(String domainKey, String id) throws StorageException {
		new CommonDAO<>(SentSms.class).delete(domainKey, "notificationId", id);
	}

	@Override
	public Collection<SentSms> list(String domainKey, int page, int pageSize) throws StorageException {
		return new CommonDAO<>(SentSms.class).list(domainKey, page, pageSize, "id.notificationId");
	}

	@Override
	public Collection<SentSms> listNext(String domainKey, String id, int page, int pageSize) throws StorageException {
		return list(domainKey, page, pageSize);
	}

	@Override
	public void delete() throws StorageException {
		new CommonDAO<>(SentSms.class).delete();
	}

}
