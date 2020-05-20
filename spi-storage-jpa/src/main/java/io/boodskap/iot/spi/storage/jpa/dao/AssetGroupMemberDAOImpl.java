package io.boodskap.iot.spi.storage.jpa.dao;

import java.util.Collection;
import java.util.Date;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.AssetGroupMemberDAO;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.model.IAssetGroupMember;
import io.boodskap.iot.model.jpa.AssetGroupMember;
import io.boodskap.iot.model.jpa.AssetGroupMemberId;
import io.boodskap.iot.spi.storage.jpa.UOW;
import io.boodskap.iot.spi.storage.jpa.dao.util.CommonDAO;
import io.boodskap.iot.spi.storage.jpa.dao.util.EntityIteratorImpl;
import io.boodskap.iot.spi.storage.jpa.dao.util.StringFieldEntityIterator;

public class AssetGroupMemberDAOImpl implements AssetGroupMemberDAO<AssetGroupMember> {
	
	private static final AssetGroupMemberDAO<AssetGroupMember> dao = new AssetGroupMemberDAOImpl();
	
	protected AssetGroupMemberDAOImpl() {
	}
	
	public static final AssetGroupMemberDAO<AssetGroupMember> get() {
		return dao;
	}

	@Override
	public AssetGroupMember create(String domainKey, String ownerAssetId, String groupId, String memberId) {
		return new AssetGroupMember(new AssetGroupMemberId(domainKey, ownerAssetId, groupId, memberId));
	}

	@Override
	public Class<? extends AssetGroupMember> clazz() {
		return AssetGroupMember.class;
	}

	@Override
	public void createOrUpdate(AssetGroupMember e) throws StorageException {
		
		try {
			
			final IAssetGroupMember oe = get(e.getDomainKey(), e.getOwnerAssetId(), e.getGroupId(), e.getMemberId());
			IAssetGroupMember ne;
			
			if(null == oe) {
				ne = new AssetGroupMember(new AssetGroupMemberId(e.getDomainKey(), e.getOwnerAssetId(), e.getGroupId(), e.getMemberId()));
				ne.setRegisteredStamp(new Date());
			}else {
				ne = oe;
			}
			
			UOW.begin();
			
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
	public EntityIterator<AssetGroupMember> load() throws StorageException {
		return new EntityIteratorImpl<>(AssetGroupMember.class, "id.ownerAssetId");
	}

	@Override
	public EntityIterator<AssetGroupMember> load(String domainKey) throws StorageException {
		return new EntityIteratorImpl<>(AssetGroupMember.class, domainKey, "id.ownerAssetId");
	}

	@Override
	public long count() throws StorageException {
		return new CommonDAO<>(AssetGroupMember.class).count();
	}

	@Override
	public long count(String domainKey) throws StorageException {
		return new CommonDAO<>(AssetGroupMember.class).count(domainKey);
	}

	@Override
	public long count(String domainKey, String ownerAssetId, String groupId) throws StorageException {
		return new CommonDAO<>(AssetGroupMember.class).count(domainKey, "ownerAssetId", ownerAssetId, "groupId", groupId);
	}

	@Override
	public AssetGroupMember get(String domainKey, String ownerAssetId, String groupId, String memberId) throws StorageException {
		return new CommonDAO<>(AssetGroupMember.class).find(new AssetGroupMemberId(domainKey, ownerAssetId, groupId, memberId));
	}

	@Override
	public EntityIterator<String> iterateMembers(String domainKey, String ownerAssetId, String groupId) throws StorageException {
		return new StringFieldEntityIterator(AssetGroupMember.class, "id.memberId", "ownerAssetId", ownerAssetId, "groupId", groupId, "id.memberId");
	}

	@Override
	public void delete(String domainKey) throws StorageException {
		new CommonDAO<>(AssetGroupMember.class).delete(domainKey);
	}

	@Override
	public void delete(String domainKey, String ownerAssetId) throws StorageException {
		new CommonDAO<>(AssetGroupMember.class).delete(domainKey, "ownerAssetId", ownerAssetId);
	}

	@Override
	public void delete(String domainKey, String ownerAssetId, String groupId) throws StorageException {
		new CommonDAO<>(AssetGroupMember.class).delete(domainKey, "ownerAssetId", ownerAssetId, "groupId", groupId);
	}

	@Override
	public void delete(String domainKey, String ownerAssetId, String groupId, String assetId) throws StorageException {
		new CommonDAO<>(AssetGroupMember.class).delete(domainKey, "ownerAssetId", ownerAssetId, "groupId", groupId, "assetId", assetId);
	}

	@Override
	public Collection<AssetGroupMember> list(String domainKey, String ownerAssetId, String groupId, int page, int pageSize)throws StorageException {
		return new CommonDAO<>(AssetGroupMember.class).list(domainKey, "ownerAssetId", ownerAssetId, page, pageSize, "id.groupId");
	}

	@Override
	public Collection<AssetGroupMember> listNext(String domainKey, String ownerAssetId, String groupId, String assetId, int page, int pageSize) throws StorageException {
		return new CommonDAO<>(AssetGroupMember.class).list(domainKey, "ownerAssetId", ownerAssetId, "groupId", groupId, page, pageSize, "id.memberId");
	}

	@Override
	public Collection<AssetGroupMember> search(String domainKey, String query, int pageSize) throws StorageException {
		return new CommonDAO<>(AssetGroupMember.class).search(query, domainKey, pageSize);
	}

	@Override
	public void delete() throws StorageException {
		new CommonDAO<>(AssetGroupMember.class).delete();
	}

}
