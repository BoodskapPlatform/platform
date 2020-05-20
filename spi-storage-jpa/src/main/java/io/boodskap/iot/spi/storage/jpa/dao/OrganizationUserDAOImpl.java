package io.boodskap.iot.spi.storage.jpa.dao;

import java.util.Collection;
import java.util.Date;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.dao.OrganizationUserDAO;
import io.boodskap.iot.model.IOrganizationUser;
import io.boodskap.iot.model.jpa.OrganizationUser;
import io.boodskap.iot.model.jpa.OrganizationUserId;
import io.boodskap.iot.spi.storage.jpa.UOW;
import io.boodskap.iot.spi.storage.jpa.dao.util.CommonDAO;
import io.boodskap.iot.spi.storage.jpa.dao.util.EntityIteratorImpl;

public class OrganizationUserDAOImpl implements OrganizationUserDAO<OrganizationUser> {
	
	private static final OrganizationUserDAO<OrganizationUser> dao = new OrganizationUserDAOImpl();

	protected OrganizationUserDAOImpl() {
	}
	
	public static final OrganizationUserDAO<OrganizationUser> get() {
		return dao;
	}

	@Override
	public OrganizationUser create(String domainKey, String orgId, String userId) {
		return new OrganizationUser(new OrganizationUserId(domainKey, orgId, userId));
	}

	@Override
	public Class<? extends OrganizationUser> clazz() {
		return OrganizationUser.class;
	}

	@Override
	public void createOrUpdate(OrganizationUser e) throws StorageException {
		
		try {
			
			final IOrganizationUser oe = get(e.getDomainKey(), e.getOrgId(), e.getUserId());
			IOrganizationUser ne;
			
			if(null == oe) {
				ne = new OrganizationUser(new OrganizationUserId(e.getDomainKey(), e.getOrgId(), e.getUserId()));
				ne.setCreatedStamp(new Date());
			}else {
				ne = oe;
			}
			
			UOW.begin();
			
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
	public EntityIterator<OrganizationUser> load() throws StorageException {
		return new EntityIteratorImpl<>(OrganizationUser.class, "id.orgId, id.userId");
	}

	@Override
	public EntityIterator<OrganizationUser> load(String domainKey) throws StorageException {
		return new EntityIteratorImpl<>(OrganizationUser.class, domainKey, "id.orgId, id.userId");
	}

	@Override
	public long count() throws StorageException {
		return new CommonDAO<>(OrganizationUser.class).count();
	}

	@Override
	public long count(String domainKey) throws StorageException {
		return new CommonDAO<>(OrganizationUser.class).count(domainKey);
	}

	@Override
	public void delete(String domainKey) throws StorageException {
		new CommonDAO<>(OrganizationUser.class).delete(domainKey);
	}

	@Override
	public void delete(String domainKey, String orgId) throws StorageException {
		new CommonDAO<>(OrganizationUser.class).delete(domainKey, "orgId", orgId);
	}

	@Override
	public void delete(String domainKey, String orgId, String userId) throws StorageException {
		new CommonDAO<>(OrganizationUser.class).delete(domainKey, "orgId", orgId, "userId", userId);
	}

	@Override
	public OrganizationUser get(String domainKey, String orgId, String userId) throws StorageException {
		return new CommonDAO<>(OrganizationUser.class).find(new OrganizationUserId(domainKey, orgId, userId));
	}

	@Override
	public Collection<OrganizationUser> list(String domainKey, String orgId, int page, int pageSize) throws StorageException {
		return new CommonDAO<>(OrganizationUser.class).list(domainKey, "orgId", orgId, page, pageSize, "id.userId");
	}

	@Override
	public Collection<OrganizationUser> listNext(String domainKey, String orgId, String userId, int page, int pageSize) throws StorageException {
		return list(domainKey, orgId, page, pageSize);
	}

	@Override
	public Collection<OrganizationUser> search(String domainKey, String orgId, String query, int pageSize) throws StorageException {
		return new CommonDAO<>(OrganizationUser.class).search(query, domainKey, "orgId", orgId, pageSize);
	}

	@Override
	public void delete() throws StorageException {
		new CommonDAO<>(OrganizationUser.class).delete();
	}

}
