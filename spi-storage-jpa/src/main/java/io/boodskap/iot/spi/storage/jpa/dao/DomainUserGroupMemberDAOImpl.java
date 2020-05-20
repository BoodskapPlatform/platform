package io.boodskap.iot.spi.storage.jpa.dao;

import java.util.Collection;
import java.util.Date;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.DomainUserGroupMemberDAO;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.model.IDomainUserGroupMember;
import io.boodskap.iot.model.jpa.DomainUserGroupMember;
import io.boodskap.iot.model.jpa.DomainUserGroupMemberId;
import io.boodskap.iot.spi.storage.jpa.UOW;
import io.boodskap.iot.spi.storage.jpa.dao.util.CommonDAO;
import io.boodskap.iot.spi.storage.jpa.dao.util.EntityIteratorImpl;
import io.boodskap.iot.spi.storage.jpa.dao.util.StringFieldEntityIterator;

public class DomainUserGroupMemberDAOImpl implements DomainUserGroupMemberDAO<DomainUserGroupMember> {
	
	private static final DomainUserGroupMemberDAO<DomainUserGroupMember> dao = new DomainUserGroupMemberDAOImpl();
	
	protected DomainUserGroupMemberDAOImpl() {
	}
	
	public static final DomainUserGroupMemberDAO<DomainUserGroupMember> get() {
		return dao;
	}

	@Override
	public DomainUserGroupMember create(String domainKey, String groupId, String memberId) {
		return new DomainUserGroupMember(new DomainUserGroupMemberId(domainKey, groupId, memberId));
	}

	@Override
	public Class<? extends DomainUserGroupMember> clazz() {
		return DomainUserGroupMember.class;
	}

	@Override
	public void createOrUpdate(DomainUserGroupMember e) throws StorageException {
		
		try {
			
			final IDomainUserGroupMember oe = get(e.getDomainKey(), e.getGroupId(), e.getMemberId());
			IDomainUserGroupMember ne;
			
			if(null == oe) {
				ne = new DomainUserGroupMember(new DomainUserGroupMemberId(e.getDomainKey(), e.getGroupId(), e.getMemberId()));
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
	public DomainUserGroupMember get(String domainKey, String groupId, String userId) throws StorageException{
		return new CommonDAO<>(DomainUserGroupMember.class).find(new DomainUserGroupMemberId(domainKey, groupId, userId));
	}

	@Override
	public EntityIterator<DomainUserGroupMember> load() throws StorageException {
		return new EntityIteratorImpl<>(DomainUserGroupMember.class, "id.groupId");
	}

	@Override
	public EntityIterator<DomainUserGroupMember> load(String domainKey) throws StorageException {
		return new EntityIteratorImpl<>(DomainUserGroupMember.class, domainKey, "id.groupId");
	}

	@Override
	public long count() throws StorageException {
		return new CommonDAO<>(DomainUserGroupMember.class).count();
	}

	@Override
	public long count(String domainKey) throws StorageException {
		return new CommonDAO<>(DomainUserGroupMember.class).count(domainKey);
	}

	@Override
	public long count(String domainKey, String groupId) throws StorageException {
		return new CommonDAO<>(DomainUserGroupMember.class).count(domainKey, "groupId", groupId);
	}

	@Override
	public void delete(String domainKey) throws StorageException {
		new CommonDAO<>(DomainUserGroupMember.class).delete(domainKey);
	}

	@Override
	public void delete(String domainKey, String groupId) throws StorageException {
		new CommonDAO<>(DomainUserGroupMember.class).delete(domainKey, "groupId", groupId);
	}

	@Override
	public void delete(String domainKey, String groupId, String userId) throws StorageException {
		new CommonDAO<>(DomainUserGroupMember.class).delete(domainKey, "groupId", groupId, "userId", userId);
	}

	@Override
	public EntityIterator<String> iterateMembers(String domainKey, String groupId) throws StorageException {
		return new StringFieldEntityIterator(DomainUserGroupMember.class, "id.memberId", "domainKey", domainKey, "groupId", groupId, "id.memberId");
	}

	@Override
	public Collection<DomainUserGroupMember> list(String domainKey, String groupId, int page, int pageSize) throws StorageException {
		return new CommonDAO<>(DomainUserGroupMember.class).list(domainKey, page, pageSize, "id.groupId");
	}

	@Override
	public Collection<DomainUserGroupMember> listNext(String domainKey, String groupId, String userId, int page, int pageSize) throws StorageException {
		return list(domainKey, groupId, page, pageSize);
	}

	@Override
	public Collection<DomainUserGroupMember> search(String domainKey, String groupId, String query, int pageSize) throws StorageException {
		return new CommonDAO<>(DomainUserGroupMember.class).search(query, domainKey, "groupId", groupId, pageSize);
	}

	@Override
	public void delete() throws StorageException {
		new CommonDAO<>(DomainUserGroupMember.class).delete();
	}

}
