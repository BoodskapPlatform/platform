package io.boodskap.iot.spi.storage.jpa.dao;

import java.util.Collection;
import java.util.Date;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.AssetDeviceDAO;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.model.IAssetDevice;
import io.boodskap.iot.model.jpa.AssetDevice;
import io.boodskap.iot.model.jpa.AssetDeviceId;
import io.boodskap.iot.spi.storage.jpa.UOW;
import io.boodskap.iot.spi.storage.jpa.dao.util.CommonDAO;
import io.boodskap.iot.spi.storage.jpa.dao.util.EntityIteratorImpl;

public class AssetDeviceDAOImpl implements AssetDeviceDAO<AssetDevice> {
	
	private static final AssetDeviceDAO<AssetDevice> instance = new AssetDeviceDAOImpl();

	protected AssetDeviceDAOImpl() {
	}
	
	public static final AssetDeviceDAO<AssetDevice> get() {
		return instance;
	}

	@Override
	public AssetDevice create(String domainKey, String assetId, String deviceId) {
		return new AssetDevice(new AssetDeviceId(domainKey, assetId, deviceId));
	}

	@Override
	public Class<? extends AssetDevice> clazz() {
		return AssetDevice.class;
	}

	@Override
	public void createOrUpdate(AssetDevice e) throws StorageException {
		
		try {
			
			final IAssetDevice oe = get(e.getDomainKey(), e.getAssetId(), e.getDeviceId());
			IAssetDevice ne;
			
			if(null == oe) {
				ne = new AssetDevice(new AssetDeviceId(e.getDomainKey(), e.getAssetId(), e.getDeviceId()));
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
	public AssetDevice get(String domainKey, String assetId, String deviceId) throws StorageException {
		return new CommonDAO<>(AssetDevice.class).find(new AssetDeviceId(domainKey, assetId, deviceId));
	}

	@Override
	public EntityIterator<AssetDevice> load() throws StorageException {
		try {
			return new EntityIteratorImpl<AssetDevice>(AssetDevice.class, "name");
		}catch(Exception ex) {
			throw new StorageException(ex);
		}
	}

	@Override
	public EntityIterator<AssetDevice> load(String domainKey) throws StorageException {
		try {
			return new EntityIteratorImpl<AssetDevice>(AssetDevice.class, domainKey, "name");
		}catch(Exception ex) {
			throw new StorageException(ex);
		}
	}

	@Override
	public long count() throws StorageException {
		return new CommonDAO<>(AssetDevice.class).count();
	}

	@Override
	public long count(String domainKey) throws StorageException {
		return new CommonDAO<>(AssetDevice.class).count(domainKey);
	}

	@Override
	public long count(String domainKey, String assetId) throws StorageException {
		return new CommonDAO<>(AssetDevice.class).count(domainKey, "assetId", assetId);
	}

	@Override
	public void delete(String domainKey) throws StorageException {
		new CommonDAO<>(AssetDevice.class).delete(domainKey);
	}

	@Override
	public void delete(String domainKey, String assetId) throws StorageException {
		new CommonDAO<>(AssetDevice.class).delete(domainKey, "assetId", assetId);
	}

	@Override
	public void delete(String domainKey, String assetId, String deviceId) throws StorageException {
		new CommonDAO<>(AssetDevice.class).delete(domainKey, "assetId", assetId, "deviceId", deviceId);
	}

	@Override
	public Collection<AssetDevice> list(String domainKey, String assetId, int page, int pageSize) throws StorageException {
		return new CommonDAO<>(AssetDevice.class).list(domainKey, "assetId", assetId, page, pageSize, "name");
	}

	@Override
	public Collection<AssetDevice> listNext(String domainKey, String assetId, String deviceId, int page, int pageSize)throws StorageException {
		return list(domainKey, assetId, page, pageSize);
	}

	@Override
	public Collection<AssetDevice> search(String domainKey, String assetId, String query, int pageSize)throws StorageException {
		return new CommonDAO<AssetDevice>(AssetDevice.class).search(query, domainKey, pageSize);
	}

	@Override
	public void delete() throws StorageException {
		new CommonDAO<>(AssetDevice.class).delete();
	}

}
