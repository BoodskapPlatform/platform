package io.boodskap.iot.spi.storage.jpa.dao;

import java.util.Collection;
import java.util.Date;

import io.boodskap.iot.EntityType;
import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.dao.LocationHistoryDAO;
import io.boodskap.iot.model.ILocationHistory;
import io.boodskap.iot.model.jpa.LocationHistory;
import io.boodskap.iot.model.jpa.LocationHistoryId;
import io.boodskap.iot.spi.storage.jpa.UOW;
import io.boodskap.iot.spi.storage.jpa.dao.util.CommonDAO;
import io.boodskap.iot.spi.storage.jpa.dao.util.EntityIteratorImpl;

public class LocationHistoryDAOImpl implements LocationHistoryDAO<LocationHistory> {
	
	private static final LocationHistoryDAO<LocationHistory> dao = new LocationHistoryDAOImpl();
	
	protected LocationHistoryDAOImpl() {
	}
	
	public static final LocationHistoryDAO<LocationHistory> get() {
		return dao;
	}

	@Override
	public LocationHistory create(String domainKey, EntityType entityType, String entityId, String historyId) {
		return new LocationHistory(new LocationHistoryId(domainKey, entityType, entityId, historyId));
	}

	@Override
	public Class<? extends LocationHistory> clazz() {
		return LocationHistory.class;
	}

	@Override
	public void createOrUpdate(LocationHistory e) throws StorageException {
		
		try {
			
			final ILocationHistory oe = get(e.getDomainKey(), e.getEntityType(), e.getEntityId(), e.getHistoryId());
			ILocationHistory ne;
			
			if(null == oe) {
				ne = new LocationHistory(new LocationHistoryId(e.getDomainKey(), e.getEntityType(), e.getEntityId(), e.getHistoryId()));
			}else {
				ne = oe;
			}
			
			UOW.begin();
			
			ne.setLatitude(e.getLatitude());
			ne.setLatitude(e.getLongitude());
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
	public EntityIterator<LocationHistory> load() throws StorageException {
		return new EntityIteratorImpl<>(LocationHistory.class, "id.historyId");
	}

	@Override
	public EntityIterator<LocationHistory> load(String domainKey) throws StorageException {
		return new EntityIteratorImpl<>(LocationHistory.class, domainKey, "id.historyId");
	}

	@Override
	public long count() throws StorageException {
		return new CommonDAO<>(LocationHistory.class).count();
	}

	@Override
	public long count(String domainKey) throws StorageException {
		return new CommonDAO<>(LocationHistory.class).count(domainKey);
	}

	@Override
	public long count(String domainKey, EntityType entityType) throws StorageException {
		return new CommonDAO<>(LocationHistory.class).count(domainKey, "entityType", entityType);
	}

	@Override
	public LocationHistory get(String domainKey, EntityType entityType, String entityId, String historyId) throws StorageException {
		return new CommonDAO<>(LocationHistory.class).find(new LocationHistoryId(domainKey, entityType, entityId, historyId));
	}

	@Override
	public void delete(String domainKey) throws StorageException {
		new CommonDAO<>(LocationHistory.class).delete(domainKey);
	}

	@Override
	public void delete(String domainKey, EntityType entityType) throws StorageException {
		new CommonDAO<>(LocationHistory.class).delete(domainKey, "entityType", entityType);
	}

	@Override
	public void delete(String domainKey, EntityType entityType, String entityId) throws StorageException {
		new CommonDAO<>(LocationHistory.class).delete(domainKey, "entityType", entityType, "entityId", "entityId");
	}

	@Override
	public void delete(String domainKey, EntityType entityType, String entityId, String historyId) throws StorageException {
		new CommonDAO<>(LocationHistory.class).delete(domainKey, "entityType", entityType, "entityId", "entityId", "historyId", historyId);
	}

	@Override
	public Collection<LocationHistory> list(String domainKey, int page, int pageSize) throws StorageException {
		return new CommonDAO<>(LocationHistory.class).list(domainKey, page, pageSize, "id.historyId");
	}

	@Override
	public Collection<LocationHistory> listNext(String domainKey, String historyId, int page, int pageSize) throws StorageException {
		return list(domainKey, page, pageSize);
	}

	@Override
	public Collection<LocationHistory> list(String domainKey, EntityType entityType, int page, int pageSize) throws StorageException {
		return new CommonDAO<>(LocationHistory.class).list(domainKey, "entityType", entityType, page, pageSize, "id.historyId");
	}

	@Override
	public Collection<LocationHistory> listNext(String domainKey, EntityType entityType, String historyId, int page, int pageSize) throws StorageException {
		return list(domainKey, entityType, page, pageSize);
	}

	@Override
	public Collection<LocationHistory> search(String domainKey, String query, int pageSize) throws StorageException {
		return new CommonDAO<>(LocationHistory.class).search(query, domainKey, pageSize);
	}

	@Override
	public Collection<LocationHistory> search(String domainKey, EntityType entityType, String query, int pageSize) throws StorageException {
		return new CommonDAO<>(LocationHistory.class).search(query, domainKey, "entityType", entityType, pageSize);
	}

	@Override
	public void delete() throws StorageException {
		new CommonDAO<>(LocationHistory.class).delete();
	}

}
