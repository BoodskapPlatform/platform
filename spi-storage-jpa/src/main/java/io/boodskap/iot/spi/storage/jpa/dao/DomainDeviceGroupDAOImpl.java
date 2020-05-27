package io.boodskap.iot.spi.storage.jpa.dao;

import java.util.Collection;
import java.util.Date;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.DomainDeviceGroupDAO;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.model.IDomainDeviceGroup;
import io.boodskap.iot.model.jpa.DomainDeviceGroup;
import io.boodskap.iot.model.jpa.DomainDeviceGroupId;
import io.boodskap.iot.spi.storage.jpa.UOW;
import io.boodskap.iot.spi.storage.jpa.dao.util.CommonDAO;
import io.boodskap.iot.spi.storage.jpa.dao.util.EntityIteratorImpl;

public class DomainDeviceGroupDAOImpl implements DomainDeviceGroupDAO<DomainDeviceGroup> {
	
	private static final DomainDeviceGroupDAO<DomainDeviceGroup> dao = new DomainDeviceGroupDAOImpl();
	
	protected DomainDeviceGroupDAOImpl() {
	}
	
	public static final DomainDeviceGroupDAO<DomainDeviceGroup> get() {
		return dao;
	}

	@Override
	public DomainDeviceGroup create(String domainKey, String groupId) {
		return new DomainDeviceGroup(new DomainDeviceGroupId(domainKey, groupId));
	}

	@Override
	public Class<? extends DomainDeviceGroup> clazz() {
		return DomainDeviceGroup.class;
	}

	@Override
	public void createOrUpdate(DomainDeviceGroup e) throws StorageException {
		
		try {
			
			final IDomainDeviceGroup oe = get(e.getDomainKey(), e.getGroupId());
			IDomainDeviceGroup ne;
			
			if(null == oe) {
				ne = new DomainDeviceGroup(new DomainDeviceGroupId(e.getDomainKey(), e.getGroupId()));
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
	public EntityIterator<DomainDeviceGroup> load() throws StorageException {
		return new EntityIteratorImpl<>(DomainDeviceGroup.class, "id.groupId");
	}

	@Override
	public EntityIterator<DomainDeviceGroup> load(String domainKey) throws StorageException {
		return new EntityIteratorImpl<>(DomainDeviceGroup.class, domainKey, "id.groupId");
	}

	@Override
	public long count() throws StorageException {
		return new CommonDAO<>(DomainDeviceGroup.class).count();
	}

	@Override
	public long count(String domainKey) throws StorageException {
		return new CommonDAO<>(DomainDeviceGroup.class).count(domainKey);
	}

	@Override
	public void delete(String domainKey) throws StorageException {
		new CommonDAO<>(DomainDeviceGroup.class).delete(domainKey);
	}

	@Override
	public void delete(String domainKey, String groupId) throws StorageException {
		new CommonDAO<>(DomainDeviceGroup.class).delete(domainKey, "groupId", groupId);
	}

	@Override
	public DomainDeviceGroup get(String domainKey, String groupId) throws StorageException {
		return new CommonDAO<>(DomainDeviceGroup.class).find(new DomainDeviceGroupId(domainKey, groupId));
	}

	@Override
	public Collection<DomainDeviceGroup> list(String domainKey, int page, int pageSize) throws StorageException {
		return new CommonDAO<>(DomainDeviceGroup.class).list(domainKey, page, pageSize, "id.groupId");
	}

	@Override
	public Collection<DomainDeviceGroup> listNext(String domainKey, String groupId, int page, int pageSize)throws StorageException {
		return list(domainKey, page, pageSize);
	}

	@Override
	public Collection<DomainDeviceGroup> search(String domainKey, String query, int pageSize) throws StorageException {
		return new CommonDAO<>(DomainDeviceGroup.class).search(query, domainKey, pageSize);
	}

	@Override
	public void delete() throws StorageException {
		new CommonDAO<>(DomainDeviceGroup.class).delete();
	}

}
