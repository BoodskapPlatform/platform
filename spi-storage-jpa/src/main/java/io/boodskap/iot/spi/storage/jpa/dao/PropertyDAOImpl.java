package io.boodskap.iot.spi.storage.jpa.dao;

import java.util.Collection;
import java.util.Date;

import io.boodskap.iot.PropertyTarget;
import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.dao.PropertyDAO;
import io.boodskap.iot.model.IProperty;
import io.boodskap.iot.model.jpa.Property;
import io.boodskap.iot.model.jpa.PropertyId;
import io.boodskap.iot.spi.storage.jpa.UOW;
import io.boodskap.iot.spi.storage.jpa.dao.util.CommonDAO;
import io.boodskap.iot.spi.storage.jpa.dao.util.EntityIteratorImpl;

public class PropertyDAOImpl implements PropertyDAO<Property> {
	
	private static final PropertyDAO<Property> dao = new PropertyDAOImpl();
	
	protected PropertyDAOImpl() {
	}
	
	public static final PropertyDAO<Property> get() {
		return dao;
	}

	@Override
	public Property create(String domainKey, PropertyTarget target, String targetId, String name) {
		return new Property(new PropertyId(domainKey, target, targetId, name));
	}

	@Override
	public Class<? extends Property> clazz() {
		return Property.class;
	}

	@Override
	public void createOrUpdate(Property e) throws StorageException {
		
		try {
			
			final IProperty oe = get(e.getDomainKey(), e.getTarget(), e.getTargetId(), e.getName());
			IProperty ne;
			
			if(null == oe) {
				ne = new Property(new PropertyId(e.getDomainKey(), e.getTarget(), e.getTargetId(), e.getName()));
				ne.setCreatedStamp(new Date());
			}else {
				ne = oe;
			}
			
			UOW.begin();
			
			ne.setDescription(e.getDescription());
			ne.setFormat(e.getFormat());
			ne.setValue(e.getValue());
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
	public EntityIterator<Property> load() throws StorageException {
		return new EntityIteratorImpl<>(Property.class, "id.name");
	}

	@Override
	public EntityIterator<Property> load(String domainKey) throws StorageException {
		return new EntityIteratorImpl<>(Property.class, domainKey, "id.name");
	}

	@Override
	public long count() throws StorageException {
		return new CommonDAO<>(Property.class).count();
	}

	@Override
	public long count(String domainKey) throws StorageException {
		return new CommonDAO<>(Property.class).count(domainKey);
	}

	@Override
	public long count(String domainKey, PropertyTarget target) throws StorageException {
		return new CommonDAO<>(Property.class).count(domainKey, "target", target);
	}

	@Override
	public long count(String domainKey, PropertyTarget target, String targetId) throws StorageException {
		return new CommonDAO<>(Property.class).count(domainKey, "target", target, "targetId", targetId);
	}

	@Override
	public void delete(String domainKey) throws StorageException {
		new CommonDAO<>(Property.class).delete(domainKey);
	}

	@Override
	public void delete(String domainKey, PropertyTarget target, String targetId) throws StorageException {
		new CommonDAO<>(Property.class).delete(domainKey, "target", target, "targetId", targetId);
	}

	@Override
	public void delete(String domainKey, PropertyTarget target, String targetId, String name) throws StorageException {
		new CommonDAO<>(Property.class).delete(domainKey, "target", target, "targetId", targetId, "name", name);
	}

	@Override
	public Property get(String domainKey, PropertyTarget target, String targetId, String name)throws StorageException {
		return new CommonDAO<>(Property.class).find(new PropertyId(domainKey, target, targetId, name));
	}

	@Override
	public Collection<Property> list(String domainKey, PropertyTarget target, String targetId, int page, int pageSize)throws StorageException {
		return new CommonDAO<>(Property.class).list(domainKey, "target", target, "targetId", targetId, page, pageSize, "id.name");
	}

	@Override
	public Collection<Property> listNext(String domainKey, PropertyTarget target, String targetId, String name, int page, int pageSize) throws StorageException {
		return list(domainKey, target, targetId, page, pageSize);
	}

	@Override
	public Collection<Property> search(String domainKey, PropertyTarget target, String targetId, String query, int pageSize) throws StorageException {
		return new CommonDAO<>(Property.class).search(query, domainKey, "target", target, "targetId", targetId, pageSize);
	}

	@Override
	public void delete() throws StorageException {
		new CommonDAO<>(Property.class).delete();
	}

}
