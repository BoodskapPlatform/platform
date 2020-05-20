package io.boodskap.iot.spi.storage.jpa.dao;

import java.util.Collection;
import java.util.Date;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.DomainUserGroupDAO;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.model.IDomainUserGroup;
import io.boodskap.iot.model.jpa.DomainUserGroup;
import io.boodskap.iot.model.jpa.DomainUserGroupId;
import io.boodskap.iot.spi.storage.jpa.UOW;
import io.boodskap.iot.spi.storage.jpa.dao.util.CommonDAO;
import io.boodskap.iot.spi.storage.jpa.dao.util.EntityIteratorImpl;

public class DomainUserGroupDAOImpl implements DomainUserGroupDAO<DomainUserGroup> {
	
	private static final DomainUserGroupDAO<DomainUserGroup> dao = new DomainUserGroupDAOImpl();
	
	protected DomainUserGroupDAOImpl() {
	}
	
	public static DomainUserGroupDAO<DomainUserGroup> get() {
		return dao;
	}

	@Override
	public DomainUserGroup create(String domainKey, String groupId) {
		return new DomainUserGroup(new DomainUserGroupId(domainKey, groupId));
	}

	@Override
	public Class<? extends DomainUserGroup> clazz() {
		return DomainUserGroup.class;
	}

	@Override
	public void createOrUpdate(DomainUserGroup e) throws StorageException {
		
		try {
			
			final IDomainUserGroup oe = get(e.getDomainKey(), e.getGroupId());
			IDomainUserGroup ne;
			
			if(null == oe) {
				ne = new DomainUserGroup(new DomainUserGroupId(e.getDomainKey(), e.getGroupId()));
				ne.setCreatedStamp(new Date());
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
	public EntityIterator<DomainUserGroup> load() throws StorageException {
		return new EntityIteratorImpl<>(DomainUserGroup.class, "id.groupId");
	}

	@Override
	public EntityIterator<DomainUserGroup> load(String domainKey) throws StorageException {
		return new EntityIteratorImpl<>(DomainUserGroup.class, domainKey, "id.groupId");
	}

	@Override
	public long count() throws StorageException {
		return new CommonDAO<>(DomainUserGroup.class).count();
	}

	@Override
	public long count(String domainKey) throws StorageException {
		return new CommonDAO<>(DomainUserGroup.class).count(domainKey);
	}

	@Override
	public void delete(String domainKey) throws StorageException {
		new CommonDAO<>(DomainUserGroup.class).delete(domainKey);
	}

	@Override
	public void delete(String domainKey, String groupId) throws StorageException {
		new CommonDAO<>(DomainUserGroup.class).delete(domainKey, "groupId", groupId);
	}

	@Override
	public DomainUserGroup get(String domainKey, String groupId) throws StorageException {
		return new CommonDAO<>(DomainUserGroup.class).find(new DomainUserGroupId(domainKey, groupId));
	}

	@Override
	public Collection<DomainUserGroup> list(String domainKey, int page, int pageSize) throws StorageException {
		return new CommonDAO<>(DomainUserGroup.class).list(domainKey, page, pageSize, "id.groupId");
	}

	@Override
	public Collection<DomainUserGroup> listNext(String domainKey, String groupId, int page, int pageSize) throws StorageException {
		return list(domainKey, page, pageSize);
	}

	@Override
	public Collection<DomainUserGroup> search(String domainKey, String query, int pageSize) throws StorageException {
		return new CommonDAO<>(DomainUserGroup.class).search(query, domainKey, pageSize);
	}

	@Override
	public void delete() throws StorageException {
		new CommonDAO<>(DomainUserGroup.class).delete();
	}

}
