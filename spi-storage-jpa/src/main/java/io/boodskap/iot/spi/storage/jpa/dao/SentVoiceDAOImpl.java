package io.boodskap.iot.spi.storage.jpa.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.dao.SentVoiceDAO;
import io.boodskap.iot.model.ISentVoice;
import io.boodskap.iot.model.jpa.SentNotificationId;
import io.boodskap.iot.model.jpa.SentVoice;
import io.boodskap.iot.spi.storage.jpa.UOW;
import io.boodskap.iot.spi.storage.jpa.dao.util.CommonDAO;
import io.boodskap.iot.spi.storage.jpa.dao.util.EntityIteratorImpl;

public class SentVoiceDAOImpl implements SentVoiceDAO<SentVoice> {
	
	private static final SentVoiceDAO<SentVoice> dao = new SentVoiceDAOImpl();
	
	protected SentVoiceDAOImpl() {
	}
	
	public static final SentVoiceDAO<SentVoice> get() {
		return dao;
	}

	@Override
	public SentVoice create(String domainKey, String notificationId) {
		return new SentVoice(new SentNotificationId(domainKey, notificationId));
	}

	@Override
	public Class<? extends SentVoice> clazz() {
		return SentVoice.class;
	}

	@Override
	public void createOrUpdate(SentVoice e) throws StorageException {
		
		try {
			
			final ISentVoice oe = get(e.getDomainKey(), e.getNotificationId());
			ISentVoice ne;
			
			if(null == oe) {
				ne = new SentVoice(new SentNotificationId(e.getDomainKey(), e.getNotificationId()));
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
	public EntityIterator<SentVoice> load() throws StorageException {
		return new EntityIteratorImpl<>(SentVoice.class, "id.notificationId");
	}

	@Override
	public EntityIterator<SentVoice> load(String domainKey) throws StorageException {
		return new EntityIteratorImpl<>(SentVoice.class, domainKey, "id.notificationId");
	}

	@Override
	public long count() throws StorageException {
		return new CommonDAO<>(SentVoice.class).count();
	}

	@Override
	public long count(String domainKey) throws StorageException {
		return new CommonDAO<>(SentVoice.class).count(domainKey);
	}

	@Override
	public SentVoice get(String id) throws StorageException {
		String query = "v.id=:vid";
		Map<String, Serializable> params = new HashMap<>();
		params.put("vid", id);
		return new CommonDAO<>(SentVoice.class).get(query, params);
	}

	@Override
	public SentVoice getBySid(String sid) throws StorageException {
		String query = "v.sid=:vsid";
		Map<String, Serializable> params = new HashMap<>();
		params.put("vsid", sid);
		return new CommonDAO<>(SentVoice.class).get(query, params);
	}

	@Override
	public SentVoice get(String domainKey, String id) throws StorageException {
		return new CommonDAO<>(SentVoice.class).find(new SentNotificationId(domainKey, id));
	}

	@Override
	public void delete(String domainKey) throws StorageException {
		new CommonDAO<>(SentVoice.class).delete(domainKey);
	}

	@Override
	public void delete(String domainKey, String id) throws StorageException {
		new CommonDAO<>(SentVoice.class).delete(domainKey, "notificationId", id);
	}

	@Override
	public Collection<SentVoice> list(String domainKey, int page, int pageSize) throws StorageException {
		return new CommonDAO<>(SentVoice.class).list(domainKey, page, pageSize, "id.notificationId");
	}

	@Override
	public Collection<SentVoice> listNext(String domainKey, String id, int page, int pageSize) throws StorageException {
		return list(domainKey, page, pageSize);
	}

	@Override
	public void delete() throws StorageException {
		new CommonDAO<>(SentVoice.class).delete();
	}

}
