package io.boodskap.iot.spi.storage.jpa.dao;

import java.util.Collection;
import java.util.Date;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.DomainEntityDAO;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.model.IDomainEntity;
import io.boodskap.iot.model.jpa.DomainEntity;
import io.boodskap.iot.model.jpa.DomainEntityId;
import io.boodskap.iot.spi.storage.jpa.UOW;
import io.boodskap.iot.spi.storage.jpa.dao.util.CommonDAO;
import io.boodskap.iot.spi.storage.jpa.dao.util.EntityIteratorImpl;

public class DomainEntityDAOImpl implements DomainEntityDAO<DomainEntity> {
	
	private static final DomainEntityDAO<DomainEntity> dao = new DomainEntityDAOImpl();
	
	protected DomainEntityDAOImpl() {
	}
	
	public static final DomainEntityDAO<DomainEntity> get() {
		return dao;
	}

	@Override
	public DomainEntity create(String domainKey, String entityId) {
		return new DomainEntity(new DomainEntityId(domainKey, entityId));
	}

	@Override
	public Class<? extends DomainEntity> clazz() {
		return DomainEntity.class;
	}

	@Override
	public void createOrUpdate(DomainEntity e) throws StorageException {
		
		try {
			
			final IDomainEntity oe = get(e.getDomainKey(), e.getEntityId());
			IDomainEntity ne;
			
			if(null == oe) {
				ne = new DomainEntity(new DomainEntityId(e.getDomainKey(), e.getEntityId()));
				ne.setRegisteredStamp(new Date());
			}else {
				ne = oe;
			}
			
			UOW.begin();
			
			ne.setAddress(e.getAddress());
			ne.setCity(e.getCity());
			ne.setCountry(e.getCountry());
			ne.setDescription(e.getDescription());
			ne.setEmail(e.getEmail());
			ne.setEntityId(e.getEntityId());
			ne.setLocale(e.getLocale());
			ne.setName(e.getName());
			ne.setPrimaryPhone(e.getPrimaryPhone());
			ne.setState(e.getState());
			ne.setTimeZone(e.getTimeZone());
			ne.setZipcode(e.getZipcode());
			ne.setUpdatedStamp(e.getUpdatedStamp());
			
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
	public EntityIterator<DomainEntity> load() throws StorageException {
		return new EntityIteratorImpl<>(DomainEntity.class, "id.entityId");
	}

	@Override
	public EntityIterator<DomainEntity> load(String domainKey) throws StorageException {
		return new EntityIteratorImpl<>(DomainEntity.class, domainKey, "id.entityId");
	}

	@Override
	public long count() throws StorageException {
		return new CommonDAO<>(DomainEntity.class).count();
	}

	@Override
	public long count(String domainKey) throws StorageException {
		return new CommonDAO<>(DomainEntity.class).count(domainKey);
	}

	@Override
	public void delete(String domainKey) throws StorageException {
		new CommonDAO<>(DomainEntity.class).delete(domainKey);
	}

	@Override
	public void delete(String domainKey, String entityId) throws StorageException {
		new CommonDAO<>(DomainEntity.class).delete(domainKey, "entityId", entityId);
	}

	@Override
	public DomainEntity get(String domainKey, String entityId) throws StorageException {
		return new CommonDAO<>(DomainEntity.class).find(new DomainEntityId(domainKey, entityId));
	}

	@Override
	public Collection<DomainEntity> list(String domainKey, int page, int pageSize) throws StorageException {
		return new CommonDAO<>(DomainEntity.class).list(domainKey, page, pageSize, "id.entityId");
	}

	@Override
	public Collection<DomainEntity> listNext(String domainKey, String entityId, int page, int pageSize) throws StorageException {
		return list(domainKey, page, pageSize);
	}

	@Override
	public Collection<DomainEntity> search(String domainKey, String query, int pageSize) throws StorageException {
		return new CommonDAO<>(DomainEntity.class).search(query, domainKey, pageSize);
	}

	@Override
	public void delete() throws StorageException {
		new CommonDAO<>(DomainEntity.class).delete();
	}

}
