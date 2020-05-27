package io.boodskap.iot.spi.storage.jpa.dao;

import java.util.Collection;
import java.util.Date;
import java.util.UUID;

import io.boodskap.iot.EntityType;
import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.dao.LocationDAO;
import io.boodskap.iot.dao.LocationHistoryDAO;
import io.boodskap.iot.model.ILocation;
import io.boodskap.iot.model.ILocationHistory;
import io.boodskap.iot.model.jpa.Location;
import io.boodskap.iot.model.jpa.LocationId;
import io.boodskap.iot.spi.storage.jpa.UOW;
import io.boodskap.iot.spi.storage.jpa.dao.util.CommonDAO;
import io.boodskap.iot.spi.storage.jpa.dao.util.EntityIteratorImpl;

public class LocationDAOImpl implements LocationDAO<Location> {
	
	private static final LocationDAO<Location> dao = new LocationDAOImpl();
	
	protected LocationDAOImpl() {
	}
	
	public static final LocationDAO<Location> get() {
		return dao;
	}

	@Override
	public Location create(String domainKey, EntityType entityType, String entityId) {
		return new Location(new LocationId(domainKey, entityType, entityId));
	}

	@Override
	public Class<? extends Location> clazz() {
		return Location.class;
	}

	@Override
	public void createOrUpdate(Location e) throws StorageException {
		
		try {

			final ILocation oe = get(e.getDomainKey(), e.getEntityType(), e.getEntityId());
			ILocation ne;
			
			if(null == oe) {
				ne = new Location(new LocationId(e.getDomainKey(), e.getEntityType(), e.getEntityId()));
			}else {
				ne = oe;
			}
			
			UOW.begin();
			
			ne.setLatitude(e.getLatitude());
			ne.setLongitude(e.getLongitude());
			ne.setUpdatedStamp(new Date());
			
			if(null == oe) {
				UOW.persist(ne);
			}
			
			UOW.commit();
			
			ILocationHistory neh = ILocationHistory.create(e.getDomainKey(), e.getEntityType(), e.getEntityId(), UUID.randomUUID().toString());
			neh.setLatitude(e.getLatitude());
			neh.setLongitude(e.getLongitude());
			
			LocationHistoryDAO.get().createOrUpdate(neh);
			
		}catch(Exception ex) {
			UOW.rollback();
			throw new StorageException(ex);
		}
	}

	@Override
	public EntityIterator<Location> load() throws StorageException {
		return new EntityIteratorImpl<>(Location.class, "id.entityId");
	}

	@Override
	public EntityIterator<Location> load(String domainKey) throws StorageException {
		return new EntityIteratorImpl<>(Location.class, domainKey, "id.entityId");
	}

	@Override
	public long count() throws StorageException {
		return new CommonDAO<>(Location.class).count();
	}

	@Override
	public long count(String domainKey) throws StorageException {
		return new CommonDAO<>(Location.class).count(domainKey);
	}

	public long count(String domainKey, EntityType entityType) throws StorageException {
		return new CommonDAO<>(Location.class).count(domainKey, "entityType", entityType);
	}

	@Override
	public void delete(String domainKey) throws StorageException {
		new CommonDAO<>(Location.class).delete(domainKey);
	}

	@Override
	public void delete(String domainKey, EntityType entityType) throws StorageException {
		new CommonDAO<>(Location.class).delete(domainKey, "entityType", entityType);
	}

	@Override
	public void delete(String domainKey, EntityType entityType, String entityId) throws StorageException {
		new CommonDAO<>(Location.class).delete(domainKey, "entityType", entityType, "entityId", entityId);
	}

	@Override
	public Location get(String domainKey, EntityType entityType, String entityId) throws StorageException {
		return new CommonDAO<>(Location.class).find(new LocationId(domainKey, entityType, entityId));
	}

	@Override
	public Collection<Location> list(String domainKey, int page, int pageSize) throws StorageException {
		return new CommonDAO<>(Location.class).list(domainKey, page, pageSize, "id.entityId");
	}

	@Override
	public Collection<Location> listNext(String domainKey, String entityId, int page, int pageSize) throws StorageException {
		return list(domainKey, page, pageSize);
	}

	@Override
	public Collection<Location> list(String domainKey, EntityType entityType, int page, int pageSize) throws StorageException {
		return new CommonDAO<>(Location.class).list(domainKey, "entityType", entityType, page, pageSize, "id.entityId");
	}

	@Override
	public Collection<Location> listNext(String domainKey, EntityType entityType, String entityId, int page, int pageSize) throws StorageException {
		return list(domainKey, page, pageSize);
	}

	@Override
	public Collection<Location> search(String domainKey, String query, int pageSize) throws StorageException {
		return new CommonDAO<>(Location.class).search(query, domainKey, pageSize);
	}

	@Override
	public Collection<Location> search(String domainKey, EntityType entityType, String query, int pageSize) throws StorageException {
		return new CommonDAO<>(Location.class).search(query, domainKey, "entityType", entityType, pageSize);
	}

	@Override
	public void delete() throws StorageException {
		new CommonDAO<>(Location.class).delete();
	}

}
