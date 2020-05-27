package io.boodskap.iot.spi.storage.jpa.dao;

import java.util.Collection;
import java.util.Date;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.DeviceCommandDAO;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.model.IDeviceCommand;
import io.boodskap.iot.model.jpa.DeviceCommand;
import io.boodskap.iot.model.jpa.DeviceCommandId;
import io.boodskap.iot.spi.storage.jpa.UOW;
import io.boodskap.iot.spi.storage.jpa.dao.util.CommonDAO;
import io.boodskap.iot.spi.storage.jpa.dao.util.EntityIteratorImpl;

public class DeviceCommandDAOImpl implements DeviceCommandDAO<DeviceCommand> {
	
	private static final DeviceCommandDAO<DeviceCommand> dao = new DeviceCommandDAOImpl();
	
	protected DeviceCommandDAOImpl() {
	}
	
	public static final DeviceCommandDAO<DeviceCommand> get() {
		return dao;
	}

	@Override
	public DeviceCommand create(String domainKey, String deviceId, long uid) {
		return new DeviceCommand(new DeviceCommandId(domainKey, deviceId, uid));
	}

	@Override
	public Class<? extends DeviceCommand> clazz() {
		return DeviceCommand.class;
	}

	@Override
	public void createOrUpdate(DeviceCommand e) throws StorageException {
		try {
			
			final IDeviceCommand oe = get(e.getDomainKey(), e.getDeviceId(), e.getUid());
			IDeviceCommand ne;
			
			if(null == oe) {
				ne = new DeviceCommand(new DeviceCommandId(e.getDomainKey(), e.getDeviceId(), e.getUid()));
			}else {
				ne = oe;
			}
			
			UOW.begin();
			
			ne.setCommandId(e.getCommandId());
			ne.setCommandType(e.getCommandType());
			ne.setData(e.getData());
			ne.setGroups(e.getGroups());
			ne.setIncludeMe(e.isIncludeMe());
			ne.setJsonData(e.getJsonData());
			ne.setModels(e.getModels());
			ne.setTarget(e.getTarget());
			ne.setVersions(e.getVersions());
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
	public EntityIterator<DeviceCommand> load() throws StorageException {
		return new EntityIteratorImpl<>(DeviceCommand.class, "createdStamp");
	}

	@Override
	public EntityIterator<DeviceCommand> load(String domainKey) throws StorageException {
		return new EntityIteratorImpl<>(DeviceCommand.class, domainKey, "createdStamp");
	}

	@Override
	public DeviceCommand get(String domainKey, String deviceId, long id) throws StorageException {
		return new CommonDAO<>(DeviceCommand.class).find(new DeviceCommandId(domainKey, deviceId, id));
	}

	@Override
	public long count() throws StorageException {
		return new CommonDAO<>(DeviceCommand.class).count();
	}

	@Override
	public long count(String domainKey) throws StorageException {
		return new CommonDAO<>(DeviceCommand.class).count(domainKey);
	}

	@Override
	public long count(String domainKey, String deviceId) throws StorageException {
		return new CommonDAO<>(DeviceCommand.class).count(domainKey, "deviceId", deviceId);
	}

	@Override
	public void delete(String domainKey) throws StorageException {
		new CommonDAO<>(DeviceCommand.class).delete(domainKey);
	}

	@Override
	public Collection<DeviceCommand> list(String domainKey, String deviceId, int page, int pageSize) throws StorageException {
		return new CommonDAO<>(DeviceCommand.class).list(domainKey, "deviceId", deviceId, page, pageSize, "id.deviceId");
	}

	@Override
	public Collection<DeviceCommand> listNext(String domainKey, String deviceId, long id, int page, int pageSize) throws StorageException {
		return list(domainKey, deviceId, page, pageSize);
	}

	@Override
	public void delete() throws StorageException {
		new CommonDAO<>(DeviceCommand.class).delete();
	}

}
