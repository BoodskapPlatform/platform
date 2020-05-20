package io.boodskap.iot.spi.storage.jpa.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.dao.UserRoleDAO;
import io.boodskap.iot.model.IUserRole;
import io.boodskap.iot.model.jpa.UserRole;
import io.boodskap.iot.model.jpa.UserRoleId;
import io.boodskap.iot.spi.storage.jpa.UOW;
import io.boodskap.iot.spi.storage.jpa.dao.util.CommonDAO;
import io.boodskap.iot.spi.storage.jpa.dao.util.EntityIteratorImpl;

public class UserRoleDAOImpl implements UserRoleDAO<UserRole> {
	
	private static final UserRoleDAO<UserRole> dao = new UserRoleDAOImpl();

	protected UserRoleDAOImpl() {
	}
	
	public static final UserRoleDAO<UserRole> get() {
		return dao;
	}

	@Override
	public UserRole create(String domainKey, String userId, String name) {
		return new UserRole(new UserRoleId(domainKey, userId, name));
	}

	@Override
	public Class<? extends UserRole> clazz() {
		return UserRole.class;
	}

	@Override
	public void createOrUpdate(UserRole e) throws StorageException {
		
		try {
			
			final IUserRole oe = get(e.getDomainKey(), e.getUserId(), e.getName());
			IUserRole ne;
			
			if(null == oe) {
				ne = new UserRole(new UserRoleId(e.getDomainKey(), e.getUserId(), e.getName()));
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
	public EntityIterator<UserRole> load() throws StorageException {
		return new EntityIteratorImpl<>(UserRole.class, "id.name");
	}

	@Override
	public EntityIterator<UserRole> load(String domainKey) throws StorageException {
		return new EntityIteratorImpl<>(UserRole.class, domainKey, "id.name");
	}

	@Override
	public long count() throws StorageException {
		return new CommonDAO<>(UserRole.class).count();
	}

	@Override
	public long count(String domainKey) throws StorageException {
		return new CommonDAO<>(UserRole.class).count(domainKey);
	}

	@Override
	public long count(String domainKey, String userId) throws StorageException {
		return new CommonDAO<>(UserRole.class).count(domainKey, "userId", userId);
	}

	@Override
	public void delete(String domainKey) throws StorageException {
		new CommonDAO<>(UserRole.class).delete(domainKey);
	}

	@Override
	public void delete(String domainKey, String userId) throws StorageException {
		new CommonDAO<>(UserRole.class).delete(domainKey, "userId", userId);
	}

	@Override
	public void delete(String domainKey, String userId, String name) throws StorageException {
		new CommonDAO<>(UserRole.class).delete(domainKey, "userId", userId, "name", name);
	}

	@Override
	public UserRole get(String domainKey, String orgId, String name) throws StorageException {
		return new CommonDAO<>(UserRole.class).find(new UserRoleId(domainKey, orgId, name));
	}

	@Override
	public Collection<UserRole> list(String domainKey, String userId) throws StorageException {
		Map<String, Serializable> params = new HashMap<>();
		params.put("dkey", domainKey);
		params.put("uid", userId);
		return new CommonDAO<>(UserRole.class).list("SELECT v FROM UserRole v WHERE v.id.domainKey=:dkey AND v.id.userId=:uid", params);
	}

	@Override
	public Collection<UserRole> search(String domainKey, String orgId, String query, int pageSize) throws StorageException {
		return new CommonDAO<>(UserRole.class).search(query, domainKey, "orgId", orgId, pageSize);			
	}

	@Override
	public void delete() throws StorageException {
		new CommonDAO<>(UserRole.class).delete();
	}

}
