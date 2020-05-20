package io.boodskap.iot.spi.storage.jpa.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.dao.TemplateDAO;
import io.boodskap.iot.model.ITemplate;
import io.boodskap.iot.model.jpa.Template;
import io.boodskap.iot.model.jpa.TemplateId;
import io.boodskap.iot.spi.storage.jpa.UOW;
import io.boodskap.iot.spi.storage.jpa.dao.util.CommonDAO;
import io.boodskap.iot.spi.storage.jpa.dao.util.EntityIteratorImpl;

public class TemplateDAOImpl implements TemplateDAO<Template> {
	
	private static final TemplateDAO<Template> dao = new TemplateDAOImpl();
	
	protected TemplateDAOImpl() {
	}
	
	public static final TemplateDAO<Template> get() {
		return dao;
	}

	@Override
	public Template create(String domainKey, String name) {
		return new Template(new TemplateId(domainKey, name));
	}

	@Override
	public Class<? extends Template> clazz() {
		return Template.class;
	}

	@Override
	public void createOrUpdate(Template e) throws StorageException {
		
		try {
			
			final ITemplate oe = get(e.getDomainKey(), e.getName());
			ITemplate ne;
			
			if(null == oe) {
				ne = new Template(new TemplateId(e.getDomainKey(), e.getName()));
				ne.setCreatedStamp(new Date());
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

	@Override
	public EntityIterator<Template> load() throws StorageException {
		return new EntityIteratorImpl<>(Template.class, "id.name");
	}

	@Override
	public EntityIterator<Template> load(String domainKey) throws StorageException {
		return new EntityIteratorImpl<>(Template.class, domainKey, "id.name");
	}

	@Override
	public long count() throws StorageException {
		return new CommonDAO<>(Template.class).count();
	}

	@Override
	public long count(String domainKey) throws StorageException {
		return new CommonDAO<>(Template.class).count(domainKey);
	}

	@Override
	public Template get(String domainKey, String name) throws StorageException {
		return new CommonDAO<>(Template.class).find(new TemplateId(domainKey, name));
	}

	@Override
	public void delete(String domainKey) throws StorageException {
		new CommonDAO<>(Template.class).delete(domainKey);
	}

	@Override
	public void delete(String domainKey, String name) throws StorageException {
		new CommonDAO<>(Template.class).delete(domainKey, "name", name);
	}

	@Override
	public Collection<Template> list(boolean load, String domainKey, int page, int pageSize) throws StorageException {
		
		if(load) {
			return new CommonDAO<>(Template.class).list(domainKey, page, pageSize, "id.name");
		}
		
		String jql = "SELECT NEW io.boodskap.iot.model.jpa.Template(v.id.domainKey, v.id.name, v.language, v.createdStamp, v.updatedStamp) FROM Template v ORDER BY v.id.name WHERE v.id.domainKey=:dkey";
		
		Map<String, Serializable> params = new HashMap<>();
		params.put("dkey", domainKey);
		
		return new CommonDAO<>(Template.class).list(jql, params, page, pageSize);
	}

	@Override
	public Collection<Template> listNext(boolean load, String domainKey, String name, int page, int pageSize) throws StorageException {
		return list(load, domainKey, page, pageSize);
	}

	@Override
	public Collection<Template> search(boolean load, String domainKey, String query, int pageSize) throws StorageException {
		
		if(load) {
			return new CommonDAO<>(Template.class).searchData(query, domainKey, pageSize);
		}

		String jql = "SELECT NEW io.boodskap.iot.model.jpa.Template(v.id.domainKey, v.id.name, v.language, v.createdStamp, v.updatedStamp) FROM Template v WHERE v.id.domainKey=:dkey";

		Map<String, Serializable> params = new HashMap<>();
		params.put("dkey", domainKey);
		
		return new CommonDAO<>(Template.class).search(jql, params, query, pageSize);	
	}

	@Override
	public void delete() throws StorageException {
		new CommonDAO<>(Template.class).delete();
	}

}
