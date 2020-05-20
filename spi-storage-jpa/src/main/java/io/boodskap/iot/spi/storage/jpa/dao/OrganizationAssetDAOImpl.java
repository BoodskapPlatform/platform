package io.boodskap.iot.spi.storage.jpa.dao;

import java.util.Collection;
import java.util.Date;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.dao.OrganizationAssetDAO;
import io.boodskap.iot.model.IOrganizationAsset;
import io.boodskap.iot.model.jpa.OrganizationAsset;
import io.boodskap.iot.model.jpa.OrganizationAssetId;
import io.boodskap.iot.spi.storage.jpa.UOW;
import io.boodskap.iot.spi.storage.jpa.dao.util.CommonDAO;
import io.boodskap.iot.spi.storage.jpa.dao.util.EntityIteratorImpl;

public class OrganizationAssetDAOImpl implements OrganizationAssetDAO<OrganizationAsset> {
	
	private static final OrganizationAssetDAO<OrganizationAsset> dao = new OrganizationAssetDAOImpl();
	
	protected OrganizationAssetDAOImpl() {
	}
	
	public static final OrganizationAssetDAO<OrganizationAsset> get() {
		return dao;
	}

	@Override
	public OrganizationAsset create(String domainKey, String orgId, String assetId) {
		return new OrganizationAsset(new OrganizationAssetId(domainKey, orgId, assetId));
	}

	@Override
	public Class<? extends OrganizationAsset> clazz() {
		return OrganizationAsset.class;
	}

	@Override
	public void createOrUpdate(OrganizationAsset e) throws StorageException {
		
		try {
			
			final IOrganizationAsset oe = get(e.getDomainKey(), e.getOrgId(), e.getAssetId());
			IOrganizationAsset ne;
			
			if(null == oe) {
				ne = new OrganizationAsset(new OrganizationAssetId(e.getDomainKey(), e.getOrgId(), e.getAssetId()));
				ne.setRegisteredStamp(new Date());
			}else {
				ne = oe;
			}
			
			UOW.begin();
			
			ne.setDescription(e.getDescription());
			ne.setName(e.getName());
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
	public EntityIterator<OrganizationAsset> load() throws StorageException {
		return new EntityIteratorImpl<>(OrganizationAsset.class, "id.orgId");
	}

	@Override
	public EntityIterator<OrganizationAsset> load(String domainKey) throws StorageException {
		return new EntityIteratorImpl<>(OrganizationAsset.class, domainKey, "id.orgId");
	}

	@Override
	public long count() throws StorageException {
		return new CommonDAO<>(OrganizationAsset.class).count();
	}

	@Override
	public long count(String domainKey) throws StorageException {
		return new CommonDAO<>(OrganizationAsset.class).count(domainKey);
	}

	@Override
	public long count(String domainKey, String orgId) throws StorageException {
		return new CommonDAO<>(OrganizationAsset.class).count(domainKey, "orgId", orgId);
	}

	@Override
	public OrganizationAsset get(String domainKey, String orgId, String assetId) throws StorageException {
		return new CommonDAO<>(OrganizationAsset.class).find(new OrganizationAssetId(domainKey, orgId, assetId));
	}

	@Override
	public void delete(String domainKey) throws StorageException {
		new CommonDAO<>(OrganizationAsset.class).delete(domainKey);
	}

	@Override
	public void delete(String domainKey, String orgId) throws StorageException {
		new CommonDAO<>(OrganizationAsset.class).delete(domainKey, "orgId", orgId);
	}

	@Override
	public void delete(String domainKey, String orgId, String assetId) throws StorageException {
		new CommonDAO<>(OrganizationAsset.class).delete(domainKey, "orgId", orgId, "assetId", assetId);
	}

	@Override
	public Collection<OrganizationAsset> list(String domainKey, String orgId, int page, int pageSize)throws StorageException {
		return new CommonDAO<>(OrganizationAsset.class).list(domainKey, "orgId", orgId, page, pageSize, "id.assetId");
	}

	@Override
	public Collection<OrganizationAsset> listNext(String domainKey, String orgId, String assetId, int page, int pageSize) throws StorageException {
		return list(domainKey, orgId, page, pageSize);
	}

	@Override
	public Collection<OrganizationAsset> search(String domainKey, String orgId, String query, int pageSize) throws StorageException {
		return new CommonDAO<>(OrganizationAsset.class).search(query, domainKey, "orgId", orgId, pageSize);
	}

	@Override
	public void delete() throws StorageException {
		new CommonDAO<>(OrganizationAsset.class).delete();
	}

}
