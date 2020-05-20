package io.boodskap.iot.spi.storage.jpa.dao;

import java.util.Collection;
import java.util.Date;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.DomainAssetGroupDAO;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.model.IDomainAssetGroup;
import io.boodskap.iot.model.jpa.DomainAssetGroup;
import io.boodskap.iot.model.jpa.DomainAssetGroupId;
import io.boodskap.iot.spi.storage.jpa.UOW;
import io.boodskap.iot.spi.storage.jpa.dao.util.CommonDAO;
import io.boodskap.iot.spi.storage.jpa.dao.util.EntityIteratorImpl;

public class DomainAssetGroupDAOImpl implements DomainAssetGroupDAO<DomainAssetGroup> {
	
	private static final DomainAssetGroupDAO<DomainAssetGroup> dao = new DomainAssetGroupDAOImpl();
	
	protected DomainAssetGroupDAOImpl() {
	}
	
	public static final DomainAssetGroupDAO<DomainAssetGroup> get() {
		return dao;
	}

	@Override
	public DomainAssetGroup create(String domainKey, String groupId) {
		return new DomainAssetGroup(new DomainAssetGroupId(domainKey, groupId));
	}

	@Override
	public Class<? extends DomainAssetGroup> clazz() {
		return DomainAssetGroup.class;
	}

	@Override
	public void createOrUpdate(DomainAssetGroup e) throws StorageException {
		
		try {
			
			final IDomainAssetGroup oe = get(e.getDomainKey(), e.getGroupId());
			IDomainAssetGroup ne;
			
			if(null == oe) {
				ne = new DomainAssetGroup(new DomainAssetGroupId(e.getDomainKey(), e.getGroupId()));
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
	public EntityIterator<DomainAssetGroup> load() throws StorageException {
		return new EntityIteratorImpl<>(DomainAssetGroup.class, "id.groupId");
	}

	@Override
	public EntityIterator<DomainAssetGroup> load(String domainKey) throws StorageException {
		return new EntityIteratorImpl<>(DomainAssetGroup.class, domainKey, "id.groupId");
	}

	@Override
	public long count() throws StorageException {
		return new CommonDAO<>(DomainAssetGroup.class).count();
	}

	@Override
	public long count(String domainKey) throws StorageException {
		return new CommonDAO<>(DomainAssetGroup.class).count(domainKey);
	}

	@Override
	public void delete(String domainKey) throws StorageException {
		new CommonDAO<>(DomainAssetGroup.class).delete(domainKey);
	}

	@Override
	public void delete(String domainKey, String groupId) throws StorageException {
		new CommonDAO<>(DomainAssetGroup.class).delete(domainKey, "groupId", groupId);
	}

	@Override
	public DomainAssetGroup get(String domainKey, String groupId) throws StorageException {
		return new CommonDAO<>(DomainAssetGroup.class).find(new DomainAssetGroupId(domainKey, groupId));
	}

	@Override
	public Collection<DomainAssetGroup> list(String domainKey, int page, int pageSize) throws StorageException {
		return new CommonDAO<>(DomainAssetGroup.class).list(domainKey, page, pageSize, "id.groupId");
	}

	@Override
	public Collection<DomainAssetGroup> listNext(String domainKey, String groupId, int page, int pageSize) throws StorageException {
		return list(domainKey, page, pageSize);
	}

	@Override
	public Collection<DomainAssetGroup> search(String domainKey, String query, int pageSize) throws StorageException {
		return new CommonDAO<>(DomainAssetGroup.class).search(query, domainKey, pageSize);
	}

	@Override
	public void delete() throws StorageException {
		new CommonDAO<>(DomainAssetGroup.class).delete();
	}

}
