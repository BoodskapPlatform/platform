package io.boodskap.iot.spi.storage.jpa.dao;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.DeviceCounterDAO;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.model.jpa.DeviceCounter;
import io.boodskap.iot.model.jpa.DeviceCounterId;
import io.boodskap.iot.spi.storage.jpa.UOW;
import io.boodskap.iot.spi.storage.jpa.dao.util.CommonDAO;

public class DeviceCounterDAOImpl implements DeviceCounterDAO<DeviceCounter> {
	
	private static final DeviceCounterDAO<DeviceCounter> dao = new DeviceCounterDAOImpl();
	
	protected DeviceCounterDAOImpl() {
	}
	
	public static final DeviceCounterDAO<DeviceCounter> get() {
		return dao;
	}

	@Override
	public long getNextCorrelationId(String domainKey, String deviceId) throws StorageException {
		
		try {
			
			final DeviceCounter oe = new CommonDAO<>(DeviceCounter.class).find(new DeviceCounterId(domainKey, deviceId));
			DeviceCounter ne;
			
			if(null == oe) {
				ne = new DeviceCounter(new DeviceCounterId(domainKey, deviceId));
			}else {
				ne = oe;
			}
			
			UOW.begin();
			
			ne.increment();
			
			if(null == oe) {
				UOW.persist(ne);
			}
			
			UOW.commit();
			
			return ne.getCorrId();
			
		}catch(Exception ex) {
			UOW.rollback();
			throw new StorageException(ex);
		}
	}

	@Override
	public Class<? extends DeviceCounter> clazz() {
		return DeviceCounter.class;
	}

	@Override
	public void createOrUpdate(DeviceCounter e) throws StorageException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public EntityIterator<DeviceCounter> load() throws StorageException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EntityIterator<DeviceCounter> load(String domainKey) throws StorageException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() throws StorageException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long count(String domainKey) throws StorageException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(String domainKey) throws StorageException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public DeviceCounter create(String domainKey, String deviceId) throws StorageException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DeviceCounter get(String domainKey, String deviceId) throws StorageException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void incrementUdp(String domainKey, String deviceId) throws StorageException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void incrementLoRa(String domainKey, String deviceId) throws StorageException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void incrementMqtt(String domainKey, String deviceId) throws StorageException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void incrementHttp(String domainKey, String deviceId) throws StorageException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void incrementFcm(String domainKey, String deviceId) throws StorageException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void incrementCoAP(String domainKey, String deviceId) throws StorageException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void incrementTcp(String domainKey, String deviceId) throws StorageException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void incrementCommands(String domainKey, String deviceId) throws StorageException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public long countUdp() throws StorageException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long countLoRa() throws StorageException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long countMqtt() throws StorageException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long countHttp() throws StorageException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long countFcm() throws StorageException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long countCoAP() throws StorageException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long countTcp() throws StorageException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long countCommands() throws StorageException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long countUdp(String domainKey) throws StorageException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long countLoRa(String domainKey) throws StorageException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long countMqtt(String domainKey) throws StorageException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long countHttp(String domainKey) throws StorageException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long countFcm(String domainKey) throws StorageException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long countCoAP(String domainKey) throws StorageException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long countTcp(String domainKey) throws StorageException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long countCommands(String domainKey) throws StorageException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long countUdp(String domainKey, String deviceId) throws StorageException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long countLoRa(String domainKey, String deviceId) throws StorageException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long countMqtt(String domainKey, String deviceId) throws StorageException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long countHttp(String domainKey, String deviceId) throws StorageException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long countFcm(String domainKey, String deviceId) throws StorageException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long countCoAP(String domainKey, String deviceId) throws StorageException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long countTcp(String domainKey, String deviceId) throws StorageException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long countCommands(String domainKey, String deviceId) throws StorageException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete() throws StorageException {
		new CommonDAO<>(DeviceCounter.class).delete();
	}

}
