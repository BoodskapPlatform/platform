package io.boodskap.iot.spi.storage.jpa.dao;

import java.util.Collection;
import java.util.Date;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.AssetGroupDAO;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.model.IAssetGroup;
import io.boodskap.iot.model.jpa.AssetGroup;
import io.boodskap.iot.model.jpa.AssetGroupId;
import io.boodskap.iot.spi.storage.jpa.UOW;
import io.boodskap.iot.spi.storage.jpa.dao.util.CommonDAO;
import io.boodskap.iot.spi.storage.jpa.dao.util.EntityIteratorImpl;

public class AssetGroupDAOImpl implements AssetGroupDAO<AssetGroup> {
	
	private static final AssetGroupDAO<AssetGroup> dao = new AssetGroupDAOImpl();
	
	protected AssetGroupDAOImpl() {
	}
	
	public static final AssetGroupDAO<AssetGroup> get() {
		return dao;
	}

	@Override
	public AssetGroup create(String domainKey, String ownerAssetId, String groupId) {
		return new AssetGroup(new AssetGroupId(domainKey, ownerAssetId, groupId));
	}

	@Override
	public Class<? extends AssetGroup> clazz() {
		return AssetGroup.class;
	}

	@Override
	public void createOrUpdate(AssetGroup e) throws StorageException {
		
		try {
			
			final IAssetGroup oe = get(e.getDomainKey(), e.getOwnerAssetId(), e.getGroupId());
			IAssetGroup ne;
			
			if(null == oe) {
				ne = new AssetGroup(new AssetGroupId(e.getDomainKey(), e.getOwnerAssetId(), e.getGroupId()));
			}else {
				ne = oe;
			}
			
			UOW.begin();
			
			ne.setDescription(e.getDescription());
			ne.setGroupEmail(e.getGroupEmail());
			ne.setGroupPhone(e.getGroupPhone());
			ne.setIndividualBroadcast(e.isIndividualBroadcast());
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
	public EntityIterator<AssetGroup> load() throws StorageException {
		return new EntityIteratorImpl<>(AssetGroup.class, "id.ownerAssetId");
	}

	@Override
	public EntityIterator<AssetGroup> load(String domainKey) throws StorageException {
		return new EntityIteratorImpl<>(AssetGroup.class, domainKey, "id.ownerAssetId");
	}

	@Override
	public long count() throws StorageException {
		return new CommonDAO<>(AssetGroup.class).count();
	}

	@Override
	public long count(String domainKey) throws StorageException {
		return new CommonDAO<>(AssetGroup.class).count(domainKey);
	}

	@Override
	public long count(String domainKey, String ownerAssetId) throws StorageException {
		return new CommonDAO<>(AssetGroup.class).count(domainKey, "ownerAssetId", ownerAssetId);
	}

	@Override
	public AssetGroup get(String domainKey, String ownerAssetId, String groupId) throws StorageException {
		return new CommonDAO<>(AssetGroup.class).find(new AssetGroupId(domainKey, ownerAssetId, groupId));
	}

	@Override
	public void delete(String domainKey) throws StorageException {
		new CommonDAO<>(AssetGroup.class).delete(domainKey);
	}

	@Override
	public void delete(String domainKey, String ownerAssetId) throws StorageException {
		new CommonDAO<>(AssetGroup.class).delete(domainKey, "ownerAssetId", ownerAssetId);
	}

	@Override
	public void delete(String domainKey, String ownerAssetId, String groupId) throws StorageException {
		new CommonDAO<>(AssetGroup.class).delete(domainKey, "ownerAssetId", ownerAssetId, "groupId", groupId);
	}

	@Override
	public Collection<AssetGroup> list(String domainKey, String ownerAssetId, int page, int pageSize) throws StorageException {
		return new CommonDAO<>(AssetGroup.class).list(domainKey, "ownerAssetId", ownerAssetId, page, pageSize, "id.groupId");
	}

	@Override
	public Collection<AssetGroup> listNext(String domainKey, String ownerAssetId, String groupId, int page, int pageSize)throws StorageException {
		return list(domainKey, ownerAssetId, page, pageSize);
	}

	@Override
	public Collection<AssetGroup> search(String domainKey, String query, int pageSize) throws StorageException {
		return new CommonDAO<>(AssetGroup.class).search(query, domainKey, pageSize);
	}

	@Override
	public void delete() throws StorageException {
		new CommonDAO<>(AssetGroup.class).delete();
	}

}
