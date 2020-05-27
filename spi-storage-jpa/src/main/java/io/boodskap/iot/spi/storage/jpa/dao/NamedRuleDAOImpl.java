package io.boodskap.iot.spi.storage.jpa.dao;

import java.util.Collection;
import java.util.Date;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.dao.NamedRuleDAO;
import io.boodskap.iot.model.INamedRule;
import io.boodskap.iot.model.jpa.MessageRule;
import io.boodskap.iot.model.jpa.NamedRule;
import io.boodskap.iot.model.jpa.NamedRuleId;
import io.boodskap.iot.spi.storage.jpa.UOW;
import io.boodskap.iot.spi.storage.jpa.dao.util.CommonDAO;
import io.boodskap.iot.spi.storage.jpa.dao.util.EntityIteratorImpl;
import io.boodskap.iot.spi.storage.jpa.dao.util.StringFieldEntityList;

public class NamedRuleDAOImpl implements NamedRuleDAO<NamedRule> {
	
	private static final NamedRuleDAO<NamedRule> dao = new NamedRuleDAOImpl();
	
	protected NamedRuleDAOImpl() {
	}
	
	public static final NamedRuleDAO<NamedRule> get() {
		return dao;
	}

	@Override
	public NamedRule create(String domainKey, String name) {
		return new NamedRule(new NamedRuleId(domainKey, name));
	}

	@Override
	public Class<? extends NamedRule> clazz() {
		return NamedRule.class;
	}

	@Override
	public void createOrUpdate(NamedRule e) throws StorageException {
		
		try {
			
			final INamedRule oe = get(e.getDomainKey(), e.getName());
			INamedRule ne;
			
			if(null == oe) {
				ne = new NamedRule(new NamedRuleId(e.getDomainKey(), e.getName()));
			}else {
				ne = oe;
			}
			
			UOW.begin();
			
			ne.setCode(e.getCode());
			ne.setCompilable(e.isCompilable());
			ne.setDescription(e.getDescription());
			ne.setLanguage(e.getLanguage());
			ne.setPlugins(e.getPlugins());
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
	public EntityIterator<NamedRule> load() throws StorageException {
		return new EntityIteratorImpl<>(NamedRule.class, "name");
	}

	@Override
	public EntityIterator<NamedRule> load(String domainKey) throws StorageException {
		return new EntityIteratorImpl<>(NamedRule.class, domainKey, "name");
	}

	@Override
	public long count() throws StorageException {
		return new CommonDAO<>(NamedRule.class).count();
	}

	@Override
	public long count(String domainKey) throws StorageException {
		return new CommonDAO<>(NamedRule.class).count(domainKey);
	}

	@Override
	public void delete(String domainKey) throws StorageException {
		new CommonDAO<>(NamedRule.class).delete(domainKey);
	}

	@Override
	public void delete(String domainKey, String name) throws StorageException {
		new CommonDAO<>(NamedRule.class).delete(domainKey, "name", name);
	}

	@Override
	public NamedRule get(String domainKey, String name) throws StorageException {
		return new CommonDAO<>(NamedRule.class).find(new NamedRuleId(domainKey, name));
	}

	@Override
	public boolean has(String domainKey, String name) throws StorageException {
		return get(domainKey, name) != null;
	}

	@Override
	public Collection<NamedRule> list(boolean load, String domainKey, int page, int pageSize) throws StorageException {
		Collection<NamedRule> list = new CommonDAO<>(NamedRule.class).list(domainKey, page, pageSize, "id.name");
		if(!load) {
			list.forEach(r->{r.setCode(null);});
		}
		return list;
	}

	@Override
	public Collection<NamedRule> listNext(boolean load, String domainKey, String name, int page, int pageSize) throws StorageException {
		return list(load, domainKey, page, pageSize);
	}

	@Override
	public Collection<NamedRule> search(boolean load, String domainKey, String query, int pageSize) throws StorageException {
		Collection<NamedRule> list = new CommonDAO<>(NamedRule.class).search(query, domainKey, pageSize);
		if(!load) {
			list.forEach(r->{r.setCode(null);});
		}
		return list;
	}

	@Override
	public Collection<String> listNames(String domainKey, int page, int pageSize) throws StorageException {
		return new StringFieldEntityList(MessageRule.class, "id.name", "domainKey", domainKey, "id.name").list(page, pageSize);
	}

	@Override
	public Collection<String> listNamesNext(String domainKey, String name, int page, int pageSize) throws StorageException {
		return listNames(domainKey, page, pageSize);
	}

	@Override
	public void delete() throws StorageException {
		new CommonDAO<>(NamedRule.class).delete();
	}

}
