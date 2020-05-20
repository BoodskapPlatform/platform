package io.boodskap.iot.spi.storage.jpa.dao;

import java.util.Collection;
import java.util.Date;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.dao.SystemPropertyDAO;
import io.boodskap.iot.model.ISystemProperty;
import io.boodskap.iot.model.jpa.SystemProperty;
import io.boodskap.iot.spi.storage.jpa.UOW;
import io.boodskap.iot.spi.storage.jpa.dao.util.CommonDAO;
import io.boodskap.iot.spi.storage.jpa.dao.util.EntityIteratorImpl;

public class SystemPropertyDAOImpl implements SystemPropertyDAO<SystemProperty> {
	
	private static final SystemPropertyDAO<SystemProperty> dao = new SystemPropertyDAOImpl();
	
	protected SystemPropertyDAOImpl() {
	}
	
	public static final SystemPropertyDAO<SystemProperty> get() {
		return dao;
	}

	@Override
	public SystemProperty create(String name) {
		return new SystemProperty(name);
	}

	@Override
	public Class<SystemProperty> clazz() {
		return SystemProperty.class;
	}

	@Override
	public void createOrUpdate(SystemProperty e) throws StorageException {
		
		try {
			
			final ISystemProperty oe = get(e.getName());
			ISystemProperty ne;
			
			if(null == oe) {
				ne = new SystemProperty(e.getName());
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
	public EntityIterator<SystemProperty> load() throws StorageException {
		return new EntityIteratorImpl<>(SystemProperty.class, "id.name");
	}

	@Override
	public long count() throws StorageException {
		return new CommonDAO<>(SystemProperty.class).count();
	}

	@Override
	public void delete() throws StorageException {
		new CommonDAO<>(SystemProperty.class).delete();
	}

	@Override
	public void delete(String name) throws StorageException {
		new CommonDAO<>(SystemProperty.class).delete("name", name);
	}

	@Override
	public SystemProperty get(String name)throws StorageException {
		return new CommonDAO<>(SystemProperty.class).find(name);
	}

	@Override
	public Collection<SystemProperty> list(int page, int pageSize)throws StorageException {
		return new CommonDAO<>(SystemProperty.class).list(page, pageSize, "name");
	}

	@Override
	public Collection<SystemProperty> listNext(String name, int page, int pageSize) throws StorageException {
		return list(page, pageSize);
	}

	@Override
	public Collection<SystemProperty> search(String query, int pageSize) throws StorageException {
		return new CommonDAO<>(SystemProperty.class).search(query, pageSize);
	}

}
