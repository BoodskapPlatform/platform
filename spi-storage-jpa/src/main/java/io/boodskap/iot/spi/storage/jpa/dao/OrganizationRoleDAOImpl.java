package io.boodskap.iot.spi.storage.jpa.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.dao.OrganizationRoleDAO;
import io.boodskap.iot.model.IOrganizationRole;
import io.boodskap.iot.model.jpa.OrganizationRole;
import io.boodskap.iot.model.jpa.OrganizationRoleId;
import io.boodskap.iot.spi.storage.jpa.UOW;
import io.boodskap.iot.spi.storage.jpa.dao.util.CommonDAO;
import io.boodskap.iot.spi.storage.jpa.dao.util.EntityIteratorImpl;

public class OrganizationRoleDAOImpl implements OrganizationRoleDAO<OrganizationRole> {
	
	private static final OrganizationRoleDAO<OrganizationRole> dao = new OrganizationRoleDAOImpl();

	protected OrganizationRoleDAOImpl() {
	}
	
	public static final OrganizationRoleDAO<OrganizationRole> get() {
		return dao;
	}

	@Override
	public OrganizationRole create(String domainKey, String orgId, String name) {
		return new OrganizationRole(new OrganizationRoleId(domainKey, orgId, name));
	}

	@Override
	public Class<? extends OrganizationRole> clazz() {
		return OrganizationRole.class;
	}

	@Override
	public void createOrUpdate(OrganizationRole e) throws StorageException {
		
		try {
			
			final IOrganizationRole oe = get(e.getDomainKey(), e.getOrgId(), e.getName());
			IOrganizationRole ne;
			
			if(null == oe) {
				ne = new OrganizationRole(new OrganizationRoleId(e.getDomainKey(), e.getOrgId(), e.getName()));
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
	public EntityIterator<OrganizationRole> load() throws StorageException {
		return new EntityIteratorImpl<>(OrganizationRole.class, "id.name");
	}

	@Override
	public EntityIterator<OrganizationRole> load(String domainKey) throws StorageException {
		return new EntityIteratorImpl<>(OrganizationRole.class, domainKey, "id.name");
	}

	@Override
	public long count() throws StorageException {
		return new CommonDAO<>(OrganizationRole.class).count();
	}

	@Override
	public long count(String domainKey) throws StorageException {
		return new CommonDAO<>(OrganizationRole.class).count(domainKey);
	}

	@Override
	public long count(String domainKey, String orgId) throws StorageException {
		return new CommonDAO<>(OrganizationRole.class).count(domainKey, "orgId", orgId);
	}

	@Override
	public void delete(String domainKey) throws StorageException {
		new CommonDAO<>(OrganizationRole.class).delete(domainKey);
	}

	@Override
	public void delete(String domainKey, String orgId) throws StorageException {
		new CommonDAO<>(OrganizationRole.class).delete(domainKey, "orgId", orgId);
	}

	@Override
	public void delete(String domainKey, String orgId, String name) throws StorageException {
		new CommonDAO<>(OrganizationRole.class).delete(domainKey, "orgId", orgId, "name", name);
	}

	@Override
	public OrganizationRole get(String domainKey, String orgId, String name) throws StorageException {
		return new CommonDAO<>(OrganizationRole.class).find(new OrganizationRoleId(domainKey, orgId, name));
	}

	@Override
	public Collection<OrganizationRole> list(String domainKey, String orgId) throws StorageException {
		Map<String, Serializable> params = new HashMap<>();
		params.put("dkey", domainKey);
		params.put("oid", orgId);
		return new CommonDAO<>(OrganizationRole.class).list("SELECT v FROM OrganizationRole v WHERE v.id.domainKey=:dkey AND v.id.orgId=:oid", params);
	}

	@Override
	public Collection<OrganizationRole> search(String domainKey, String orgId, String query, int pageSize) throws StorageException {
		return new CommonDAO<>(OrganizationRole.class).search(query, domainKey, "orgId", orgId, pageSize);			
	}

	@Override
	public void delete() throws StorageException {
		new CommonDAO<>(OrganizationRole.class).delete();
	}

}
