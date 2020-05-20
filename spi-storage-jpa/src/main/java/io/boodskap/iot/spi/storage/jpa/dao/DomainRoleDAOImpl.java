package io.boodskap.iot.spi.storage.jpa.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.DomainRoleDAO;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.model.IDomainRole;
import io.boodskap.iot.model.jpa.DomainRole;
import io.boodskap.iot.model.jpa.DomainRoleId;
import io.boodskap.iot.spi.storage.jpa.UOW;
import io.boodskap.iot.spi.storage.jpa.dao.util.CommonDAO;
import io.boodskap.iot.spi.storage.jpa.dao.util.EntityIteratorImpl;

public class DomainRoleDAOImpl implements DomainRoleDAO<DomainRole> {
	
	private static final DomainRoleDAO<DomainRole> dao = new DomainRoleDAOImpl();

	protected DomainRoleDAOImpl() {
	}
	
	public static final DomainRoleDAO<DomainRole> get() {
		return dao;
	}

	@Override
	public DomainRole create(String domainKey, String name) {
		return new DomainRole(new DomainRoleId(domainKey, name));
	}

	@Override
	public Class<? extends DomainRole> clazz() {
		return DomainRole.class;
	}

	@Override
	public void createOrUpdate(DomainRole e) throws StorageException {
		
		try {
			
			final IDomainRole oe = get(e.getDomainKey(), e.getName());
			IDomainRole ne;
			
			if(null == oe) {
				ne = new DomainRole(new DomainRoleId(e.getDomainKey(), e.getName()));
			}else {
				ne = oe;
			}
			
			UOW.begin();
			
			ne.setDescription(e.getDescription());
			
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
	public EntityIterator<DomainRole> load() throws StorageException {
		return new EntityIteratorImpl<>(DomainRole.class, "id.name");
	}

	@Override
	public EntityIterator<DomainRole> load(String domainKey) throws StorageException {
		return new EntityIteratorImpl<>(DomainRole.class, domainKey, "id.name");
	}

	@Override
	public long count() throws StorageException {
		return new CommonDAO<>(DomainRole.class).count();
	}

	@Override
	public long count(String domainKey) throws StorageException {
		return new CommonDAO<>(DomainRole.class).count(domainKey);
	}

	@Override
	public void delete(String domainKey) throws StorageException {
		new CommonDAO<>(DomainRole.class).delete(domainKey);
	}

	@Override
	public void delete(String domainKey, String name) throws StorageException {
		new CommonDAO<>(DomainRole.class).delete(domainKey, "name", name);
	}

	@Override
	public DomainRole get(String domainKey, String name) throws StorageException {
		return new CommonDAO<>(DomainRole.class).find(new DomainRoleId(domainKey, name));
	}

	@Override
	public Collection<DomainRole> list(String domainKey) throws StorageException {
		Map<String, Serializable> params = new HashMap<>();
		params.put("dkey", domainKey);
		return new CommonDAO<>(DomainRole.class).list("SELECT v FROM DomainRole v WHERE v.id.domainKey=:dkey", params);
	}

	@Override
	public Collection<DomainRole> search(String domainKey, String query, int pageSize) throws StorageException {
		return new CommonDAO<>(DomainRole.class).search(query, domainKey, pageSize);			
	}

	@Override
	public void delete() throws StorageException {
		new CommonDAO<>(DomainRole.class).delete();
	}

}
