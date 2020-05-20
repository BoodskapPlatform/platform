package io.boodskap.iot.spi.storage.jpa.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.dao.OutgoingSmsDAO;
import io.boodskap.iot.model.IOutgoingSms;
import io.boodskap.iot.model.jpa.OutgoingSms;
import io.boodskap.iot.model.jpa.OutgoingSmsId;
import io.boodskap.iot.spi.storage.jpa.UOW;
import io.boodskap.iot.spi.storage.jpa.dao.util.CommonDAO;
import io.boodskap.iot.spi.storage.jpa.dao.util.EntityIteratorImpl;
import io.boodskap.iot.spi.storage.jpa.dao.util.StringFieldEntityIterator;

public class OutgoingSmsDAOImpl implements OutgoingSmsDAO<OutgoingSms> {
	
	private static final OutgoingSmsDAO<OutgoingSms> dao = new OutgoingSmsDAOImpl();
	
	protected OutgoingSmsDAOImpl() {
	}
	
	public static final OutgoingSmsDAO<OutgoingSms> get() {
		return dao;
	}

	@Override
	public OutgoingSms create(String domainKey, String notificationId) {
		return new OutgoingSms(new OutgoingSmsId(domainKey, notificationId));
	}

	@Override
	public Class<? extends OutgoingSms> clazz() {
		return OutgoingSms.class;
	}

	@Override
	public void createOrUpdate(OutgoingSms e) throws StorageException {
		
		try {
			
			final IOutgoingSms oe = get(e.getDomainKey(), e.getNotificationId());
			IOutgoingSms ne;
			
			if(null == oe) {
				ne = new OutgoingSms(new OutgoingSmsId(e.getDomainKey(), e.getNotificationId()));
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
	public EntityIterator<OutgoingSms> load() throws StorageException {
		return new EntityIteratorImpl<>(OutgoingSms.class, "id.notificationId");
	}

	@Override
	public EntityIterator<OutgoingSms> load(String domainKey) throws StorageException {
		return new EntityIteratorImpl<>(OutgoingSms.class, "id.notificationId");
	}

	@Override
	public long count() throws StorageException {
		return new CommonDAO<>(OutgoingSms.class).count();
	}

	@Override
	public long count(String domainKey) throws StorageException {
		return new CommonDAO<>(OutgoingSms.class).count(domainKey);
	}

	@Override
	public OutgoingSms get(String id) throws StorageException {
		String query = "id.notificationId=:nid";
		Map<String, Serializable> params = new HashMap<>();
		params.put("nid", id);
		return new CommonDAO<>(OutgoingSms.class).getUnique(query, params);
	}

	@Override
	public OutgoingSms get(String domainKey, String id) throws StorageException {
		return new CommonDAO<>(OutgoingSms.class).find(new OutgoingSmsId(domainKey, id));
	}

	@Override
	public void delete(String domainKey) throws StorageException {
		new CommonDAO<>(OutgoingSms.class).delete(domainKey);
	}

	@Override
	public void delete(String domainKey, String id) throws StorageException {
		new CommonDAO<>(OutgoingSms.class).delete(domainKey, "notificationId", id);
	}

	@Override
	public EntityIterator<String> loadIds() throws StorageException {
		return new StringFieldEntityIterator(OutgoingSms.class, "id.notificationId", "queuedAt");
	}

	@Override
	public Collection<OutgoingSms> list(String domainKey, int page, int pageSize) throws StorageException {
		return new CommonDAO<>(OutgoingSms.class).list(domainKey, page, pageSize, "queuedAt");
	}

	@Override
	public Collection<OutgoingSms> listNext(String domainKey, String id, int page, int pageSize) throws StorageException {
		return list(domainKey, page, pageSize);
	}

	@Override
	public void delete() throws StorageException {
		new CommonDAO<>(OutgoingSms.class).delete();
	}

}
