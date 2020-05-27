package io.boodskap.iot.spi.storage.jpa.dao;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.dao.SystemTemplateDAO;
import io.boodskap.iot.model.ISystemTemplate;
import io.boodskap.iot.model.jpa.SystemTemplate;
import io.boodskap.iot.spi.storage.jpa.UOW;
import io.boodskap.iot.spi.storage.jpa.dao.util.CommonDAO;
import io.boodskap.iot.spi.storage.jpa.dao.util.EntityIteratorImpl;

public class SystemTemplateDAOImpl implements SystemTemplateDAO<SystemTemplate> {
	
	private static final SystemTemplateDAO<SystemTemplate> dao = new SystemTemplateDAOImpl();
	
	protected SystemTemplateDAOImpl() {
	}
	
	public static final SystemTemplateDAO<SystemTemplate> get() {
		return dao;
	}

	@Override
	public SystemTemplate create(String name) {
		return new SystemTemplate(name);
	}

	@Override
	public void createOrUpdate(SystemTemplate e) throws StorageException {
		
		try {
			
			final ISystemTemplate oe = get(e.getName());
			ISystemTemplate ne;
			
			if(null == oe) {
				ne = new SystemTemplate(e.getName());
			}else {
				ne = oe;
			}
			
			UOW.begin();
			
			ne.setCode(e.getCode());
			ne.setLanguage(e.getLanguage());
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
	
	public SystemTemplate get(String name) throws StorageException{
		return new CommonDAO<>(SystemTemplate.class).find(name);
	}

	@Override
	public long count() throws StorageException {
		return new CommonDAO<>(SystemTemplate.class).count();
	}

	@Override
	public void delete() throws StorageException {
		new CommonDAO<>(SystemTemplate.class).delete();
	}

	@Override
	public void delete(String name) throws StorageException {
		new CommonDAO<>(SystemTemplate.class).deleteByQuery(String.format("v.name='%s'", name));
	}

	@Override
	public EntityIterator<SystemTemplate> load() throws StorageException {
		return new EntityIteratorImpl<>(SystemTemplate.class, "name");
	}

	@Override
	public Collection<SystemTemplate> list(boolean load, int page, int pageSize) throws StorageException {
		
		if(load) {
			return new CommonDAO<>(SystemTemplate.class).list("from SystemTemplate v order by v.name", new HashMap<>(), page, pageSize);
		}
		
		String jql = "SELECT NEW io.boodskap.iot.model.jpa.SystemTemplate(v.name, v.language, v.createdStamp, v.updatedStamp) FROM SystemTemplate v ORDER BY v.name";
		
		return new CommonDAO<>(SystemTemplate.class).list(jql, new HashMap<>(), page, pageSize);

	}

	@Override
	public Collection<SystemTemplate> listNext(boolean load, String name, int page, int pageSize) throws StorageException {
		return list(load, page, pageSize);
	}

	@Override
	public Collection<SystemTemplate> search(boolean load, String query, int pageSize) throws StorageException {
		
		if(load) {
			return new CommonDAO<>(SystemTemplate.class).search(query, pageSize);
		}

		String jql = "SELECT NEW io.boodskap.iot.model.jpa.SystemTemplate(v.name, v.language, v.createdStamp, v.updatedStamp) FROM SystemTemplate v";

		return new CommonDAO<>(SystemTemplate.class).search(jql, new HashMap<>(), query, pageSize);	
	}

}
