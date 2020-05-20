package io.boodskap.iot.spi.storage.jpa.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.dao.OrganizationUserRoleDAO;
import io.boodskap.iot.model.IOrganizationUserRole;
import io.boodskap.iot.model.jpa.OrganizationUserRole;
import io.boodskap.iot.model.jpa.OrganizationUserRoleId;
import io.boodskap.iot.spi.storage.jpa.UOW;
import io.boodskap.iot.spi.storage.jpa.dao.util.CommonDAO;
import io.boodskap.iot.spi.storage.jpa.dao.util.EntityIteratorImpl;

public class OrganizationUserRoleDAOImpl implements OrganizationUserRoleDAO<OrganizationUserRole> {
	
	private static final OrganizationUserRoleDAO<OrganizationUserRole> dao = new OrganizationUserRoleDAOImpl();

	protected OrganizationUserRoleDAOImpl() {
	}
	
	public static final OrganizationUserRoleDAO<OrganizationUserRole> get() {
		return dao;
	}

	@Override
	public OrganizationUserRole create(String domainKey, String orgId, String userId, String name) {
		return new OrganizationUserRole(new OrganizationUserRoleId(domainKey, orgId, userId, name));
	}

	@Override
	public Class<? extends OrganizationUserRole> clazz() {
		return OrganizationUserRole.class;
	}

	@Override
	public void createOrUpdate(OrganizationUserRole e) throws StorageException {
		
		try {
			
			final IOrganizationUserRole oe = get(e.getDomainKey(), e.getOrgId(), e.getUserId(), e.getName());
			IOrganizationUserRole ne;
			
			if(null == oe) {
				ne = new OrganizationUserRole(new OrganizationUserRoleId(e.getDomainKey(), e.getOrgId(), e.getUserId(), e.getName()));
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
	public EntityIterator<OrganizationUserRole> load() throws StorageException {
		return new EntityIteratorImpl<>(OrganizationUserRole.class, "id.name");
	}

	@Override
	public EntityIterator<OrganizationUserRole> load(String domainKey) throws StorageException {
		return new EntityIteratorImpl<>(OrganizationUserRole.class, domainKey, "id.name");
	}

	@Override
	public long count() throws StorageException {
		return new CommonDAO<>(OrganizationUserRole.class).count();
	}

	@Override
	public long count(String domainKey) throws StorageException {
		return new CommonDAO<>(OrganizationUserRole.class).count(domainKey);
	}

	@Override
	public long count(String domainKey, String orgId, String userId) throws StorageException {
		return new CommonDAO<>(OrganizationUserRole.class).count(domainKey, "orgId", orgId, "userId", userId);
	}

	@Override
	public void delete(String domainKey) throws StorageException {
		new CommonDAO<>(OrganizationUserRole.class).delete(domainKey);
	}

	@Override
	public void delete(String domainKey, String orgId, String userId) throws StorageException {
		new CommonDAO<>(OrganizationUserRole.class).delete(domainKey, "orgId", orgId, "userId", userId);
	}

	@Override
	public void delete(String domainKey, String orgId, String userId, String name) throws StorageException {
		new CommonDAO<>(OrganizationUserRole.class).delete(domainKey, "orgId", orgId, "userId", userId, "name", name);
	}

	@Override
	public OrganizationUserRole get(String domainKey, String orgId, String userId, String name) throws StorageException {
		return new CommonDAO<>(OrganizationUserRole.class).find(new OrganizationUserRoleId(domainKey, orgId, userId, name));
	}

	@Override
	public Collection<OrganizationUserRole> list(String domainKey, String orgId, String userId) throws StorageException {
		Map<String, Serializable> params = new HashMap<>();
		params.put("dkey", domainKey);
		params.put("oid", orgId);
		params.put("uid", userId);
		return new CommonDAO<>(OrganizationUserRole.class).list("SELECT v FROM OrganizationUserRole v WHERE v.id.domainKey=:dkey AND v.id.orgId=:oid AND v.id.userId=:uid", params);
	}

	@Override
	public Collection<OrganizationUserRole> search(String domainKey, String orgId, String userId, String query, int pageSize) throws StorageException {
		return new CommonDAO<>(OrganizationUserRole.class).search(query, domainKey, "orgId", orgId, "userId", userId, pageSize);			
	}

	@Override
	public void delete() throws StorageException {
		new CommonDAO<>(OrganizationUserRole.class).delete();
	}

}
