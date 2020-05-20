package io.boodskap.iot.spi.storage.jpa.dao;

import java.util.Collection;
import java.util.Date;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.dao.OrganizationDAO;
import io.boodskap.iot.model.IOrganization;
import io.boodskap.iot.model.jpa.Organization;
import io.boodskap.iot.model.jpa.OrganizationId;
import io.boodskap.iot.spi.storage.jpa.UOW;
import io.boodskap.iot.spi.storage.jpa.dao.util.CommonDAO;
import io.boodskap.iot.spi.storage.jpa.dao.util.EntityIteratorImpl;

public class OrganizationDAOImpl implements OrganizationDAO<Organization> {
	
	private static final OrganizationDAO<Organization> dao = new OrganizationDAOImpl();

	protected OrganizationDAOImpl() {
	}
	
	public static final OrganizationDAO<Organization> get() {
		return dao;
	}

	@Override
	public Organization create(String domainKey, String orgId) {
		return new Organization(new OrganizationId(domainKey, orgId));
	}

	@Override
	public Class<? extends Organization> clazz() {
		return Organization.class;
	}

	@Override
	public void createOrUpdate(Organization e) throws StorageException {
		
		try {
			
			final IOrganization oe = get(e.getDomainKey(), e.getOrgId());
			IOrganization ne;
			
			if(null == oe) {
				ne = new Organization(new OrganizationId(e.getDomainKey(), e.getOrgId()));
				ne.setRegisteredStamp(new Date());
			}else {
				ne = oe;
			}
			
			UOW.begin();
			
			ne.setAddress(e.getAddress());
			ne.setCity(e.getCity());
			ne.setCountry(e.getCountry());
			ne.setDescription(e.getDescription());
			ne.setEmail(e.getEmail());
			ne.setLocale(e.getLocale());
			ne.setName(e.getName());
			ne.setPrimaryPhone(e.getPrimaryPhone());
			ne.setState(e.getState());
			ne.setTimeZone(e.getTimeZone());
			ne.setZipcode(e.getZipcode());
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
	public EntityIterator<Organization> load() throws StorageException {
		return new EntityIteratorImpl<>(Organization.class, "id.orgId");
	}

	@Override
	public EntityIterator<Organization> load(String domainKey) throws StorageException {
		return new EntityIteratorImpl<>(Organization.class, domainKey, "id.orgId");
	}

	@Override
	public long count() throws StorageException {
		return new CommonDAO<>(Organization.class).count();
	}

	@Override
	public long count(String domainKey) throws StorageException {
		return new CommonDAO<>(Organization.class).count(domainKey);
	}

	@Override
	public void delete(String domainKey) throws StorageException {
		new CommonDAO<>(Organization.class).delete(domainKey);
	}

	@Override
	public void delete(String domainKey, String orgId) throws StorageException {
		new CommonDAO<>(Organization.class).delete(domainKey, "orgId", orgId);
	}

	@Override
	public Organization get(String domainKey, String orgId) throws StorageException {
		return new CommonDAO<>(Organization.class).find(new OrganizationId(domainKey, orgId));
	}

	@Override
	public Collection<Organization> list(String domainKey, int page, int pageSize) throws StorageException {
		return new CommonDAO<>(Organization.class).list(domainKey, page, pageSize, "id.orgId");
	}

	@Override
	public Collection<Organization> listNext(String domainKey, String orgId, int page, int pageSize) throws StorageException {
		return list(domainKey, page, pageSize);
	}

	@Override
	public Collection<Organization> search(String domainKey, String query, int pageSize) throws StorageException {
		return new CommonDAO<>(Organization.class).search(query, domainKey, pageSize);
	}

	@Override
	public void delete() throws StorageException {
		new CommonDAO<>(Organization.class).delete();
	}

}
