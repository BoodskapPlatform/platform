package io.boodskap.iot.spi.storage.jpa.dao;

import java.util.Collection;
import java.util.Date;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.DomainJsonEntityDAO;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.model.IDomainJsonEntity;
import io.boodskap.iot.model.jpa.DomainJsonEntity;
import io.boodskap.iot.model.jpa.DomainJsonEntityId;
import io.boodskap.iot.spi.storage.jpa.UOW;
import io.boodskap.iot.spi.storage.jpa.dao.util.CommonDAO;
import io.boodskap.iot.spi.storage.jpa.dao.util.EntityIteratorImpl;

public class DomainJsonEntityDAOImpl implements DomainJsonEntityDAO<DomainJsonEntity> {
	
	private static final DomainJsonEntityDAO<DomainJsonEntity> dao = new DomainJsonEntityDAOImpl();
	
	protected DomainJsonEntityDAOImpl() {
	}
	
	public static final DomainJsonEntityDAO<DomainJsonEntity> get() {
		return dao;
	}

	@Override
	public DomainJsonEntity create(String domainKey, String entityType, String entityId) {
		return new DomainJsonEntity(new DomainJsonEntityId(domainKey, entityType, entityId));
	}

	@Override
	public Class<? extends DomainJsonEntity> clazz() {
		return DomainJsonEntity.class;
	}

	@Override
	public void createOrUpdate(DomainJsonEntity e) throws StorageException {
		
		try {
			
			final IDomainJsonEntity oe = get(e.getDomainKey(), e.getEntityType(), e.getEntityId());
			IDomainJsonEntity ne;
			
			if(null == oe) {
				ne = new DomainJsonEntity(new DomainJsonEntityId(e.getDomainKey(), e.getEntityType(), e.getEntityId()));
				ne.setRegisteredStamp(new Date());
			}else {
				ne = oe;
			}
			
			UOW.begin();
			
			ne.setDescription(e.getDescription());
			ne.setEntityId(e.getEntityId());
			ne.setName(e.getName());
			ne.setUpdatedStamp(e.getUpdatedStamp());
			ne.setAttributes(e.getAttributes());
			ne.setEntityType(e.getEntityType());
			ne.setCreatedBy(e.getCreatedBy());
			ne.setUpdatedBy(e.getUpdatedBy());
			ne.setJson(e.getJson());
			
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
	public EntityIterator<DomainJsonEntity> load() throws StorageException {
		return new EntityIteratorImpl<>(DomainJsonEntity.class, "id.entityId");
	}

	@Override
	public EntityIterator<DomainJsonEntity> load(String domainKey) throws StorageException {
		return new EntityIteratorImpl<>(DomainJsonEntity.class, domainKey, "id.entityId");
	}

	@Override
	public long count() throws StorageException {
		return new CommonDAO<>(DomainJsonEntity.class).count();
	}

	@Override
	public long count(String domainKey) throws StorageException {
		return new CommonDAO<>(DomainJsonEntity.class).count(domainKey);
	}

	@Override
	public void delete(String domainKey) throws StorageException {
		new CommonDAO<>(DomainJsonEntity.class).delete(domainKey);
	}

	@Override
	public void delete(String domainKey, String entityType, String entityId) throws StorageException {
		new CommonDAO<>(DomainJsonEntity.class).delete(domainKey, "entityType", entityType, "entityId", entityId);
	}

	@Override
	public DomainJsonEntity get(String domainKey, String entityType, String entityId) throws StorageException {
		return new CommonDAO<>(DomainJsonEntity.class).find(new DomainJsonEntityId(domainKey, entityType, entityId));
	}

	@Override
	public Collection<DomainJsonEntity> list(String domainKey, int page, int pageSize) throws StorageException {
		return new CommonDAO<>(DomainJsonEntity.class).list(domainKey, page, pageSize, "id.entityId");
	}

	@Override
	public Collection<DomainJsonEntity> list(String domainKey, String entityType, int page, int pageSize) throws StorageException {
		return new CommonDAO<>(DomainJsonEntity.class).list(domainKey, page, pageSize, "id.entityType");
	}

	@Override
	public Collection<DomainJsonEntity> listNext(String domainKey, String entityType, String entityId, int page, int pageSize) throws StorageException {
		return list(domainKey, page, pageSize);
	}

	@Override
	public Collection<DomainJsonEntity> search(String domainKey, String query, int pageSize) throws StorageException {
		return new CommonDAO<>(DomainJsonEntity.class).search(query, domainKey, pageSize);
	}

	@Override
	public Collection<DomainJsonEntity> search(String domainKey, String entityType, String query, int pageSize) throws StorageException {
		return new CommonDAO<>(DomainJsonEntity.class).search(query, domainKey, "id.entityType", entityType, pageSize);
	}

	@Override
	public void delete() throws StorageException {
		new CommonDAO<>(DomainJsonEntity.class).delete();
	}

}
