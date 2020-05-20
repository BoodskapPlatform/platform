package io.boodskap.iot.spi.storage.jpa.dao;

import java.util.Collection;
import java.util.Date;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.DomainAssetGroupMemberDAO;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.model.IDomainAssetGroupMember;
import io.boodskap.iot.model.jpa.DomainAssetGroupMember;
import io.boodskap.iot.model.jpa.DomainAssetGroupMemberId;
import io.boodskap.iot.spi.storage.jpa.UOW;
import io.boodskap.iot.spi.storage.jpa.dao.util.CommonDAO;
import io.boodskap.iot.spi.storage.jpa.dao.util.EntityIteratorImpl;
import io.boodskap.iot.spi.storage.jpa.dao.util.StringFieldEntityIterator;

public class DomainAssetGroupMemberDAOImpl implements DomainAssetGroupMemberDAO<DomainAssetGroupMember> {
	
	private static final DomainAssetGroupMemberDAO<DomainAssetGroupMember> dao = new DomainAssetGroupMemberDAOImpl();
	
	protected DomainAssetGroupMemberDAOImpl() {
	}
	
	public static final DomainAssetGroupMemberDAO<DomainAssetGroupMember> get() {
		return dao;
	}

	@Override
	public DomainAssetGroupMember create(String domainKey, String groupId, String memberId) {
		return new DomainAssetGroupMember(new DomainAssetGroupMemberId(domainKey, groupId, memberId));
	}

	@Override
	public Class<? extends DomainAssetGroupMember> clazz() {
		return DomainAssetGroupMember.class;
	}

	@Override
	public void createOrUpdate(DomainAssetGroupMember e) throws StorageException {
		
		try {
			
			final IDomainAssetGroupMember oe = get(e.getDomainKey(), e.getGroupId(), e.getMemberId());
			IDomainAssetGroupMember ne;
			
			if(null == oe) {
				ne = new DomainAssetGroupMember(new DomainAssetGroupMemberId(e.getDomainKey(), e.getGroupId(), e.getMemberId()));
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
	public DomainAssetGroupMember get(String domainKey, String groupId, String assetId) {
		return new CommonDAO<>(DomainAssetGroupMember.class).find(new DomainAssetGroupMemberId(domainKey, groupId, assetId));
	}

	@Override
	public EntityIterator<String> iterateMembers(String domainKey, String groupId) throws StorageException {
		return new StringFieldEntityIterator(DomainAssetGroupMember.class, "id.memberId", "domainKey", domainKey, "groupId", groupId, "id.memberId");
	}

	@Override
	public EntityIterator<DomainAssetGroupMember> load() throws StorageException {
		return new EntityIteratorImpl<>(DomainAssetGroupMember.class, "id.groupId");
	}

	@Override
	public EntityIterator<DomainAssetGroupMember> load(String domainKey) throws StorageException {
		return new EntityIteratorImpl<>(DomainAssetGroupMember.class, domainKey, "id.groupId");
	}

	@Override
	public long count() throws StorageException {
		return new CommonDAO<>(DomainAssetGroupMember.class).count();
	}

	@Override
	public long count(String domainKey) throws StorageException {
		return new CommonDAO<>(DomainAssetGroupMember.class).count(domainKey);
	}

	@Override
	public long count(String domainKey, String groupId) throws StorageException {
		return new CommonDAO<>(DomainAssetGroupMember.class).count(domainKey, "groupId", groupId);
	}

	@Override
	public void delete(String domainKey) throws StorageException {
		new CommonDAO<>(DomainAssetGroupMember.class).delete(domainKey);
	}

	@Override
	public void delete(String domainKey, String groupId) throws StorageException {
		new CommonDAO<>(DomainAssetGroupMember.class).delete(domainKey, "groupId", groupId);
	}

	@Override
	public void delete(String domainKey, String groupId, String assetId) throws StorageException {
		new CommonDAO<>(DomainAssetGroupMember.class).delete(domainKey, "groupId", groupId, "assetId", assetId);
	}

	@Override
	public Collection<DomainAssetGroupMember> list(String domainKey, String groupId, int page, int pageSize)throws StorageException {
		return new CommonDAO<>(DomainAssetGroupMember.class).list(domainKey, "groupId", groupId, page, pageSize, "id.memberId");
	}

	@Override
	public Collection<DomainAssetGroupMember> listNext(String domainKey, String groupId, String assetId, int page,int pageSize) throws StorageException {
		return list(domainKey, groupId, page, pageSize);
	}

	@Override
	public Collection<DomainAssetGroupMember> search(String domainKey, String groupId, String query, int pageSize) throws StorageException {
		return new CommonDAO<>(DomainAssetGroupMember.class).search(query, domainKey, "groupId", groupId, pageSize);
	}

	@Override
	public void delete() throws StorageException {
		new CommonDAO<>(DomainAssetGroupMember.class).delete();
	}

}
