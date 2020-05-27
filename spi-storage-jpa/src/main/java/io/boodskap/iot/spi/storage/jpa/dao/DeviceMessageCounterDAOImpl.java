package io.boodskap.iot.spi.storage.jpa.dao;

import java.util.Collection;
import java.util.Date;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.DeviceMessageCounterDAO;
import io.boodskap.iot.model.jpa.DeviceMessageCounter;
import io.boodskap.iot.model.jpa.DeviceMessageCounterId;
import io.boodskap.iot.spi.storage.jpa.UOW;
import io.boodskap.iot.spi.storage.jpa.dao.util.CommonDAO;

public class DeviceMessageCounterDAOImpl implements DeviceMessageCounterDAO<DeviceMessageCounter> {
	
	private static final DeviceMessageCounterDAO<DeviceMessageCounter> instance = new DeviceMessageCounterDAOImpl();
	
	private DeviceMessageCounterDAOImpl() {
	}
	
	public static final DeviceMessageCounterDAO<DeviceMessageCounter> get(){
		return instance;
	}

	@Override
	public Class<? extends DeviceMessageCounter> clazz() {
		return DeviceMessageCounter.class;
	}

	@Override
	public DeviceMessageCounter create(String domainKey, String deviceId, String messageType, Date day) throws StorageException {
		return new DeviceMessageCounter(new DeviceMessageCounterId(domainKey, deviceId, messageType, day));
	}

	@Override
	public void createOrUpdate(DeviceMessageCounter e) throws StorageException {
		
		try {
			
			final DeviceMessageCounter oe = new CommonDAO<DeviceMessageCounter>(DeviceMessageCounter.class).find(new DeviceMessageCounterId(e.getDomainKey(), e.getDeviceId(), e.getMessageType(), e.getDay()));
			DeviceMessageCounter ne;
			
			if(null == oe) {
				ne = new DeviceMessageCounter(new DeviceMessageCounterId(e.getDomainKey(), e.getDeviceId(), e.getMessageType(), e.getDay()));
				ne.setDay(new Date());
			}else {
				ne = oe;
			}
			
			UOW.begin();

			ne.setCount(e.getCount());
			
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
	public long count() {
		return new CommonDAO<DeviceMessageCounter>(DeviceMessageCounter.class).count();
	}

	@Override
	public long count(String domainKey) {
		return new CommonDAO<DeviceMessageCounter>(DeviceMessageCounter.class).count(domainKey);
	}

	@Override
	public long count(String domainKey, String deviceId) {
		return new CommonDAO<DeviceMessageCounter>(DeviceMessageCounter.class).count(domainKey, "deviceId", deviceId);
	}

	@Override
	public long count(String domainKey, String deviceId, String messageType) {
		return new CommonDAO<DeviceMessageCounter>(DeviceMessageCounter.class).count(domainKey, "deviceId", deviceId, "messageType", messageType);
	}

	@Override
	public long count(Date from, Date to) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long count(String domainKey, Date from, Date to) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long count(String domainKey, String deviceId, Date from, Date to) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long count(String domainKey, String deviceId, String messageType, Date from, Date to) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long countByQuery(String query) throws StorageException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long countByQuery(String domainKey, String query) throws StorageException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Collection<DeviceMessageCounter> search(String query, int pageSize) throws StorageException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<DeviceMessageCounter> search(String domainKey, String query, int pageSize) throws StorageException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<DeviceMessageCounter> list(String domainKey, int page, int pageSize) throws StorageException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<DeviceMessageCounter> listNext(String domainKey, String deviceId, String messageType, Date day, int page, int pageSize) throws StorageException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DeviceMessageCounter get(String domainKey, String deviceId, String messageType, Date day)
			throws StorageException {
		// TODO Auto-generated method stub
		return null;
	}

}
