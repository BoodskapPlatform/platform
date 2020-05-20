package io.boodskap.iot.spi.storage.jpa.dao;

import java.util.Collection;
import java.util.Date;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.DeviceGroupDAO;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.model.IDeviceGroup;
import io.boodskap.iot.model.jpa.DeviceGroup;
import io.boodskap.iot.model.jpa.DeviceGroupId;
import io.boodskap.iot.spi.storage.jpa.UOW;
import io.boodskap.iot.spi.storage.jpa.dao.util.CommonDAO;
import io.boodskap.iot.spi.storage.jpa.dao.util.EntityIteratorImpl;

public class DeviceGroupDAOImpl implements DeviceGroupDAO<DeviceGroup> {
	
	private static final DeviceGroupDAO<DeviceGroup> dao = new DeviceGroupDAOImpl();
	
	protected DeviceGroupDAOImpl() {
	}
	
	public static final DeviceGroupDAO<DeviceGroup> get() {
		return dao;
	}

	@Override
	public DeviceGroup create(String domainKey, String ownerDeviceId, String groupId) {
		return new DeviceGroup(new DeviceGroupId(domainKey, ownerDeviceId, groupId));
	}

	@Override
	public Class<? extends DeviceGroup> clazz() {
		return DeviceGroup.class;
	}

	@Override
	public void createOrUpdate(DeviceGroup e) throws StorageException {
		
		try {
			
			final IDeviceGroup oe = get(e.getDomainKey(), e.getOwnerDeviceId(), e.getGroupId());
			IDeviceGroup ne;
			
			if(null == oe) {
				ne = new DeviceGroup(new DeviceGroupId(e.getDomainKey(), e.getOwnerDeviceId(), e.getGroupId()));
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
	public EntityIterator<DeviceGroup> load() throws StorageException {
		return new EntityIteratorImpl<>(DeviceGroup.class, "id.ownerDeviceId");
	}

	@Override
	public EntityIterator<DeviceGroup> load(String domainKey) throws StorageException {
		return new EntityIteratorImpl<>(DeviceGroup.class, domainKey, "id.ownerDeviceId");
	}

	@Override
	public DeviceGroup get(String domainKey, String ownerDeviceId, String groupId) throws StorageException {
		return new CommonDAO<>(DeviceGroup.class).find(new DeviceGroupId(domainKey, ownerDeviceId, groupId));
	}

	@Override
	public long count() throws StorageException {
		return new CommonDAO<>(DeviceGroup.class).count();
	}

	@Override
	public long count(String domainKey) throws StorageException {
		return new CommonDAO<>(DeviceGroup.class).count(domainKey);
	}

	@Override
	public long count(String domainKey, String ownerDeviceId) throws StorageException {
		return new CommonDAO<>(DeviceGroup.class).count(domainKey, "ownerDeviceId", ownerDeviceId);
	}

	@Override
	public void delete(String domainKey) throws StorageException {
		new CommonDAO<>(DeviceGroup.class).delete(domainKey);
	}

	@Override
	public void delete(String domainKey, String ownerDeviceId) throws StorageException {
		new CommonDAO<>(DeviceGroup.class).delete(domainKey, "ownerDeviceId", ownerDeviceId);
	}

	@Override
	public void delete(String domainKey, String ownerDeviceId, String groupId) throws StorageException {
		new CommonDAO<>(DeviceGroup.class).delete(domainKey, "ownerDeviceId", ownerDeviceId, "groupId", groupId);
	}

	@Override
	public Collection<DeviceGroup> list(String domainKey, String ownerDeviceId, int page, int pageSize) throws StorageException {
		return new CommonDAO<>(DeviceGroup.class).list(domainKey, page, pageSize, "id.groupId");
	}

	@Override
	public Collection<DeviceGroup> listNext(String domainKey, String ownerDeviceId, String groupId, int page, int pageSize) throws StorageException {
		return list(domainKey, ownerDeviceId, page, pageSize);
	}

	@Override
	public Collection<DeviceGroup> search(String domainKey, String query, int pageSize) throws StorageException {
		return new CommonDAO<>(DeviceGroup.class).search(query, domainKey, pageSize);
	}

	@Override
	public void delete() throws StorageException {
		new CommonDAO<>(DeviceGroup.class).delete();
	}

}
