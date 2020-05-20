package io.boodskap.iot.spi.storage.jpa.dao;

import java.util.Collection;
import java.util.Date;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.AssetDAO;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.model.IAsset;
import io.boodskap.iot.model.jpa.Asset;
import io.boodskap.iot.model.jpa.AssetId;
import io.boodskap.iot.spi.storage.jpa.UOW;
import io.boodskap.iot.spi.storage.jpa.dao.util.CommonDAO;
import io.boodskap.iot.spi.storage.jpa.dao.util.EntityIteratorImpl;

public class AssetDAOImpl implements AssetDAO<Asset> {
	
	private static final AssetDAO<Asset> instance = new AssetDAOImpl();

	protected AssetDAOImpl() {
	}
	
	public static final AssetDAO<Asset> get() {
		return instance;
	}

	@Override
	public Asset create(String domainKey, String assetId) {
		return new Asset(new AssetId(domainKey, assetId));
	}

	@Override
	public Class<? extends Asset> clazz() {
		return Asset.class;
	}

	@Override
	public void createOrUpdate(Asset e) throws StorageException {
		
		try {
			
			final IAsset oe = get(e.getDomainKey(), e.getAssetId());
			IAsset ne;
			
			if(null == oe) {
				ne = new Asset(e.getDomainKey(), e.getAssetId());
				ne.setRegisteredStamp(new Date());
			}else {
				ne = oe;
			}
			
			UOW.begin();
			
			ne.setUpdatedStamp(new Date());
			ne.setName(e.getName());
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
	public Asset get(String domainKey, String assetId) throws StorageException {
		return new CommonDAO<>(Asset.class).find(new AssetId(domainKey, assetId));
	}

	@Override
	public EntityIterator<Asset> load() throws StorageException {
		try {
			return new EntityIteratorImpl<>(Asset.class, "name");
		}catch(Exception ex) {
			throw new StorageException(ex);
		}
	}

	@Override
	public EntityIterator<Asset> load(String domainKey) throws StorageException {
		try {
			return new EntityIteratorImpl<>(Asset.class, domainKey, "name");
		}catch(Exception ex) {
			throw new StorageException(ex);
		}
	}

	@Override
	public long count() throws StorageException {
		return new CommonDAO<>(Asset.class).count();
	}

	@Override
	public long count(String domainKey) throws StorageException {
		return new CommonDAO<>(Asset.class).count(domainKey);
	}

	@Override
	public void delete(String domainKey) throws StorageException {
		new CommonDAO<>(Asset.class).delete(domainKey);
	}

	@Override
	public void delete(String domainKey, String assetId) throws StorageException {
		new CommonDAO<>(Asset.class).delete(domainKey, "assetId", assetId);
	}

	@Override
	public Collection<Asset> list(String domainKey, int page, int pageSize) throws StorageException {
		return new CommonDAO<Asset>(Asset.class).list(domainKey, page, pageSize, "name");
	}

	@Override
	public Collection<Asset> listNext(String domainKey, String assetId, int page, int pageSize) throws StorageException {
		return list(domainKey, page, pageSize);
	}

	@Override
	public Collection<Asset> search(String domainKey, String query, int pageSize) throws StorageException {
		return new CommonDAO<Asset>(Asset.class).search(query, domainKey, pageSize);
	}

	@Override
	public void delete() throws StorageException {
		new CommonDAO<>(Asset.class).delete();
	}

}
