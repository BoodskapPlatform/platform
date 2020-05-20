package io.boodskap.iot.spi.storage.jpa.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.dao.OutgoingVoiceDAO;
import io.boodskap.iot.model.IOutgoingVoice;
import io.boodskap.iot.model.jpa.OutgoingVoice;
import io.boodskap.iot.model.jpa.OutgoingVoiceId;
import io.boodskap.iot.spi.storage.jpa.UOW;
import io.boodskap.iot.spi.storage.jpa.dao.util.CommonDAO;
import io.boodskap.iot.spi.storage.jpa.dao.util.EntityIteratorImpl;
import io.boodskap.iot.spi.storage.jpa.dao.util.StringFieldEntityIterator;

public class OutgoingVoiceDAOImpl implements OutgoingVoiceDAO<OutgoingVoice> {
	
	private static final OutgoingVoiceDAO<OutgoingVoice> dao = new OutgoingVoiceDAOImpl();
	
	protected OutgoingVoiceDAOImpl() {
	}
	
	public static final OutgoingVoiceDAO<OutgoingVoice> get() {
		return dao;
	}

	@Override
	public OutgoingVoice create(String domainKey, String notificationId) {
		return new OutgoingVoice(new OutgoingVoiceId(domainKey, notificationId));
	}

	@Override
	public Class<? extends OutgoingVoice> clazz() {
		return OutgoingVoice.class;
	}

	@Override
	public void createOrUpdate(OutgoingVoice e) throws StorageException {
		
		try {
			
			final IOutgoingVoice oe = get(e.getDomainKey(), e.getNotificationId());
			IOutgoingVoice ne;
			
			if(null == oe) {
				ne = new OutgoingVoice(new OutgoingVoiceId(e.getDomainKey(), e.getNotificationId()));
				ne.setQueuedAt(new Date());
			}else {
				ne = oe;
			}
			
			UOW.begin();
			
			ne.setContent(e.getContent());
			ne.setReceipents(e.getReceipents());
			ne.setResponse(e.getResponse());
			ne.setSendor(e.getSendor());
			ne.setSentAt(e.getSentAt());
			ne.setStatus(e.getStatus());
			
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
	public EntityIterator<OutgoingVoice> load() throws StorageException {
		return new EntityIteratorImpl<>(OutgoingVoice.class, "id.notificationId");
	}

	@Override
	public EntityIterator<OutgoingVoice> load(String domainKey) throws StorageException {
		return new EntityIteratorImpl<>(OutgoingVoice.class, "id.notificationId");
	}

	@Override
	public long count() throws StorageException {
		return new CommonDAO<>(OutgoingVoice.class).count();
	}

	@Override
	public long count(String domainKey) throws StorageException {
		return new CommonDAO<>(OutgoingVoice.class).count(domainKey);
	}

	@Override
	public OutgoingVoice get(String id) throws StorageException {
		String query = "id.notificationId=:nid";
		Map<String, Serializable> params = new HashMap<>();
		params.put("nid", id);
		return new CommonDAO<>(OutgoingVoice.class).getUnique(query, params);
	}

	@Override
	public OutgoingVoice get(String domainKey, String id) throws StorageException {
		return new CommonDAO<>(OutgoingVoice.class).find(new OutgoingVoiceId(domainKey, id));
	}

	@Override
	public void delete(String domainKey) throws StorageException {
		new CommonDAO<>(OutgoingVoice.class).delete(domainKey);
	}

	@Override
	public void delete(String domainKey, String id) throws StorageException {
		new CommonDAO<>(OutgoingVoice.class).delete(domainKey, "notificationId", id);
	}

	@Override
	public EntityIterator<String> loadIds() throws StorageException {
		return new StringFieldEntityIterator(OutgoingVoice.class, "id.notificationId", "queuedAt");
	}

	@Override
	public Collection<OutgoingVoice> list(String domainKey, int page, int pageSize) throws StorageException {
		return new CommonDAO<>(OutgoingVoice.class).list(domainKey, page, pageSize, "queuedAt");
	}

	@Override
	public Collection<OutgoingVoice> listNext(String domainKey, String id, int page, int pageSize) throws StorageException {
		return list(domainKey, page, pageSize);
	}

	@Override
	public void delete() throws StorageException {
		new CommonDAO<>(OutgoingVoice.class).delete();
	}

}
