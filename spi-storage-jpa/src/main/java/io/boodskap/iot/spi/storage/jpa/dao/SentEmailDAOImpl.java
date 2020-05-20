package io.boodskap.iot.spi.storage.jpa.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.dao.SentEmailDAO;
import io.boodskap.iot.model.IProgress;
import io.boodskap.iot.model.IResponse;
import io.boodskap.iot.model.ISentEmail;
import io.boodskap.iot.model.jpa.Progress;
import io.boodskap.iot.model.jpa.Response;
import io.boodskap.iot.model.jpa.SentEmail;
import io.boodskap.iot.model.jpa.SentNotificationId;
import io.boodskap.iot.spi.storage.jpa.UOW;
import io.boodskap.iot.spi.storage.jpa.dao.util.CommonDAO;
import io.boodskap.iot.spi.storage.jpa.dao.util.EntityIteratorImpl;

public class SentEmailDAOImpl implements SentEmailDAO<SentEmail> {
	
	private static final SentEmailDAO<SentEmail> dao = new SentEmailDAOImpl();
	
	protected SentEmailDAOImpl() {
	}
	
	public static final SentEmailDAO<SentEmail> get() {
		return dao;
	}

	@Override
	public SentEmail create(String domainKey, String notificationId) {
		return new SentEmail(new SentNotificationId(domainKey, notificationId));
	}

	@Override
	public IProgress createProgress() {
		return new Progress();
	}

	@Override
	public IResponse createResponse() {
		return new Response();
	}

	@Override
	public Class<? extends SentEmail> clazz() {
		return SentEmail.class;
	}

	@Override
	public void createOrUpdate(SentEmail e) throws StorageException {
		
		try {
			
			final ISentEmail oe = get(e.getDomainKey(), e.getNotificationId());
			ISentEmail ne;
			
			if(null == oe) {
				ne = new SentEmail(new SentNotificationId(e.getDomainKey(), e.getNotificationId()));
			}else {
				ne = oe;
			}
			
			UOW.begin();
			
			ne.setContent(e.getContent());
			ne.setDsResolrver(e.getDsResolrver());
			ne.setHtmlContent(e.getHtmlContent());
			ne.setProgress(e.getProgress());
			ne.setQueuedAt(e.getQueuedAt());
			ne.setReceipent(e.getReceipent());
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
	public EntityIterator<SentEmail> load() throws StorageException {
		return new EntityIteratorImpl<>(SentEmail.class, "id.notificationId");
	}

	@Override
	public EntityIterator<SentEmail> load(String domainKey) throws StorageException {
		return new EntityIteratorImpl<>(SentEmail.class, domainKey, "id.notificationId");
	}

	@Override
	public long count() throws StorageException {
		return new CommonDAO<>(SentEmail.class).count();
	}

	@Override
	public long count(String domainKey) throws StorageException {
		return new CommonDAO<>(SentEmail.class).count(domainKey);
	}

	@Override
	public SentEmail get(String id) throws StorageException {
		String query = "v.id=:eid";
		Map<String, Serializable> params = new HashMap<>();
		params.put("eid", id);
		return new CommonDAO<>(SentEmail.class).get(query, params);
	}

	@Override
	public SentEmail get(String domainKey, String id) throws StorageException {
		return new CommonDAO<>(SentEmail.class).find(new SentNotificationId(domainKey, id));
	}

	@Override
	public void delete(String domainKey) throws StorageException {
		new CommonDAO<>(SentEmail.class).delete(domainKey);
	}

	@Override
	public void delete(String domainKey, String id) throws StorageException {
		new CommonDAO<>(SentEmail.class).delete(domainKey, "notificationId", id);
	}

	@Override
	public Collection<SentEmail> list(String domainKey, int page, int pageSize) throws StorageException {
		return new CommonDAO<>(SentEmail.class).list(domainKey, page, pageSize, "id.notificationId");
	}

	@Override
	public Collection<SentEmail> listNext(String domainKey, String id, int page, int pageSize) throws StorageException {
		return list(domainKey, page, pageSize);
	}

	@Override
	public void delete() throws StorageException {
		new CommonDAO<>(SentEmail.class).delete();
	}

}
