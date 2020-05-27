package io.boodskap.iot.spi.storage.jpa.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import io.boodskap.iot.NotificationChannel;
import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.dao.EventRegistrationDAO;
import io.boodskap.iot.model.IEventRegistration;
import io.boodskap.iot.model.jpa.EventRegistration;
import io.boodskap.iot.model.jpa.EventRegistrationId;
import io.boodskap.iot.spi.storage.jpa.UOW;
import io.boodskap.iot.spi.storage.jpa.dao.util.CommonDAO;
import io.boodskap.iot.spi.storage.jpa.dao.util.EntityIteratorImpl;
import io.boodskap.iot.spi.storage.jpa.dao.util.StringFieldEntityIterator;

public class EventRegistrationDAOImpl implements EventRegistrationDAO<EventRegistration> {
	
	private static final EventRegistrationDAO<EventRegistration> dao = new EventRegistrationDAOImpl();
	
	protected EventRegistrationDAOImpl() {
	}
	
	public static final EventRegistrationDAO<EventRegistration> get() {
		return dao;
	}

	@Override
	public EventRegistration create(String domainKey, String eventId, NotificationChannel channel, String toAddress) {
		return new EventRegistration(new EventRegistrationId(domainKey, eventId, channel, toAddress));
	}

	@Override
	public Class<? extends EventRegistration> clazz() {
		return EventRegistration.class;
	}

	@Override
	public void createOrUpdate(EventRegistration e) throws StorageException {
		
		try {
			
			final IEventRegistration oe = get(e.getDomainKey(), e.getEventId(), e.getChannel(), e.getToAddress());
			IEventRegistration ne;
			
			if(null == oe) {
				ne = new EventRegistration(new EventRegistrationId(e.getDomainKey(), e.getEventId(), e.getChannel(), e.getToAddress()));
			}else {
				ne = oe;
			}
			
			UOW.begin();
			
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
	public EntityIterator<EventRegistration> load() throws StorageException {
		return new EntityIteratorImpl<>(EventRegistration.class, "id.eventId");
	}

	@Override
	public EntityIterator<EventRegistration> load(String domainKey) throws StorageException {
		return new EntityIteratorImpl<>(EventRegistration.class, domainKey, "id.eventId");
	}

	@Override
	public long count() throws StorageException {
		return new CommonDAO<>(EventRegistration.class).count();
	}

	@Override
	public long count(String domainKey) throws StorageException {
		return new CommonDAO<>(EventRegistration.class).count(domainKey);
	}

	@Override
	public long count(String domainKey, String eventId) throws StorageException {
		return new CommonDAO<>(EventRegistration.class).count(domainKey, "eventId", eventId);
	}

	@Override
	public long count(String domainKey, String eventId, NotificationChannel channel) throws StorageException {
		return new CommonDAO<>(EventRegistration.class).count(domainKey, "eventId", eventId, "channel", channel);
	}

	@Override
	public void delete(String domainKey) throws StorageException {
		new CommonDAO<>(EventRegistration.class).delete(domainKey);
	}

	@Override
	public void delete(String domainKey, String eventId) throws StorageException {
		new CommonDAO<>(EventRegistration.class).delete(domainKey, "eventId", eventId);
	}

	@Override
	public void delete(String domainKey, String eventId, NotificationChannel channel) throws StorageException {
		new CommonDAO<>(EventRegistration.class).delete(domainKey, "eventId", eventId, "channel", channel);
	}

	@Override
	public void delete(String domainKey, String eventId, NotificationChannel channel, String toAddress) throws StorageException {
		new CommonDAO<>(EventRegistration.class).delete(domainKey, "eventId", eventId, "channel", channel, "toAddress", toAddress);
	}

	@Override
	public EventRegistration get(String domainKey, String eventId, NotificationChannel channel, String toAddress) throws StorageException {
		return new CommonDAO<>(EventRegistration.class).find(new EventRegistrationId(domainKey, eventId, channel, toAddress));
	}

	@Override
	public EntityIterator<String> iterateReceipeints(String domainKey, String eventId, NotificationChannel channel) throws StorageException {
		return new StringFieldEntityIterator(EventRegistration.class, "id.toAddress", "domainKey",  domainKey, "eventId", eventId, "channel", channel, "id.toAddress");
	}

	@Override
	public Collection<String> listReceipeints(String domainKey, String eventId, NotificationChannel channel, int page, int pageSize) throws StorageException {
		try {
			String jql = String.format("SELECT NEW java.lang.String(v.id.eventId) FROM %s v WHERE v.id.domainKey=:dkey and v.id.eventId=:eid and v.id.channel=:chn order by v.id.toAddress", EventRegistration.class.getSimpleName());
			Map<String, Serializable> params = new HashMap<>();
			params.put("dkey", domainKey);
			params.put("eid", eventId);
			params.put("chn", channel);
			return new CommonDAO<>(String.class).list(jql, params, page, pageSize);
		}catch(Exception ex) {
			throw new StorageException(ex);
		}
	}

	@Override
	public Collection<String> listReceipeintsNext(String domainKey, String eventId, NotificationChannel channel, String toAddress, int page, int pageSize) throws StorageException {
		return listReceipeints(domainKey, eventId, channel, page, pageSize);
	}

	@Override
	public Collection<EventRegistration> list(String domainKey, String eventId, NotificationChannel channel, int page, int pageSize) throws StorageException {
		return new CommonDAO<>(EventRegistration.class).list(domainKey, "eventId", eventId, "channel", channel, page, pageSize, "id.toAddress");
	}

	@Override
	public Collection<EventRegistration> listNext(String domainKey, String eventId, NotificationChannel channel, String toAddress, int page, int pageSize) throws StorageException {
		return list(domainKey, eventId, channel, page, pageSize);
	}

	@Override
	public Collection<EventRegistration> search(String domainKey, String eventId, String query, int pageSize) throws StorageException {
		return new CommonDAO<>(EventRegistration.class).search(query, domainKey, "eventId", eventId, pageSize);
	}

	@Override
	public Collection<EventRegistration> search(String domainKey, String eventId, NotificationChannel channel, String query, int pageSize) throws StorageException {
		return new CommonDAO<>(EventRegistration.class).search(query, domainKey, "eventId", eventId, "channel", channel, pageSize);
	}

	@Override
	public void delete() throws StorageException {
		new CommonDAO<>(EventRegistration.class).delete();
	}

}
