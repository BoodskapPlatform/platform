package io.boodskap.iot.spi.storage.jpa.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.dao.EventDAO;
import io.boodskap.iot.model.IEvent;
import io.boodskap.iot.model.jpa.Event;
import io.boodskap.iot.model.jpa.EventId;
import io.boodskap.iot.spi.storage.jpa.UOW;
import io.boodskap.iot.spi.storage.jpa.dao.util.CommonDAO;
import io.boodskap.iot.spi.storage.jpa.dao.util.EntityIteratorImpl;

public class EventDAOImpl implements EventDAO<Event> {
	
	private static final EventDAO<Event> dao = new EventDAOImpl();
	
	protected EventDAOImpl() {
	}
	
	public static final EventDAO<Event> get() {
		return dao;
	}

	@Override
	public Event create(String domainKey, String eventId) {
		return new Event(new EventId(domainKey, eventId));
	}

	@Override
	public Class<? extends Event> clazz() {
		return Event.class;
	}

	@Override
	public void createOrUpdate(Event e) throws StorageException {
		
		try {
			
			final IEvent oe = get(e.getDomainKey(), e.getEventId());
			IEvent ne;
			
			if(null == oe) {
				ne = new Event(new EventId(e.getDomainKey(), e.getEventId()));
			}else {
				ne = oe;
			}
			
			UOW.begin();
			
			ne.setContent(e.getContent());
			ne.setContentTemplate(e.getContentTemplate());
			ne.setName(e.getName());
			ne.setSubject(e.getSubject());
			ne.setSubjectTemplate(e.getSubjectTemplate());
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
	public EntityIterator<Event> load() throws StorageException {
		return new EntityIteratorImpl<>(Event.class, "id.eventId");
	}

	@Override
	public EntityIterator<Event> load(String domainKey) throws StorageException {
		return new EntityIteratorImpl<>(Event.class, domainKey, "id.eventId");
	}

	@Override
	public long count() throws StorageException {
		return new CommonDAO<>(Event.class).count();
	}

	@Override
	public long count(String domainKey) throws StorageException {
		return new CommonDAO<>(Event.class).count(domainKey);
	}

	@Override
	public void delete(String domainKey) throws StorageException {
		new CommonDAO<>(Event.class).delete(domainKey);
	}

	@Override
	public void delete(String domainKey, String eventId) throws StorageException {
		new CommonDAO<>(Event.class).delete(domainKey, "eventId", eventId);
	}

	@Override
	public Event get(String domainKey, String eventId) throws StorageException {
		return new CommonDAO<>(Event.class).find(new EventId(domainKey, eventId));
	}

	@Override
	public Collection<String> listIds(String domainKey) throws StorageException {
		try {
			String jql = String.format("SELECT NEW java.lang.String(v.id.eventId) FROM %s v WHERE v.id.domainKey=:dkey", Event.class.getSimpleName());
			Map<String, Serializable> params = new HashMap<>();
			params.put("dkey", domainKey);
			return new CommonDAO<>(String.class).list(jql, params);
		}catch(Exception ex) {
			throw new StorageException(ex);
		}
	}

	@Override
	public Collection<Event> list(String domainKey, int page, int pageSize) throws StorageException {
		return new CommonDAO<>(Event.class).list(domainKey, page, pageSize, "id.eventId");
	}

	@Override
	public Collection<Event> listNext(String domainKey, String eventId, int page, int pageSize) throws StorageException {
		return list(domainKey, page, pageSize);
	}

	@Override
	public Collection<Event> search(String domainKey, String query, int pageSize) throws StorageException {
		return new CommonDAO<>(Event.class).search(query, domainKey, pageSize);
	}

	@Override
	public void delete() throws StorageException {
		new CommonDAO<>(Event.class).delete();
	}

}
