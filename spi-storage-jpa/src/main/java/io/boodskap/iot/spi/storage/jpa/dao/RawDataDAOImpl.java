package io.boodskap.iot.spi.storage.jpa.dao;

import java.util.Date;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.dao.RawDataDAO;
import io.boodskap.iot.model.IRawData;
import io.boodskap.iot.model.jpa.RawData;
import io.boodskap.iot.spi.storage.jpa.UOW;
import io.boodskap.iot.spi.storage.jpa.dao.util.CommonDAO;
import io.boodskap.iot.spi.storage.jpa.dao.util.EntityIteratorImpl;

public class RawDataDAOImpl implements RawDataDAO<RawData> {
	
	private static final RawDataDAO<RawData> dao = new RawDataDAOImpl();
	
	protected RawDataDAOImpl() {
	}
	
	public static final RawDataDAO<RawData> get() {
		return dao;
	}

	@Override
	public RawData create(String id) {
		return new RawData(id);
	}

	@Override
	public Class<? extends RawData> clazz() {
		return RawData.class;
	}

	@Override
	public void createOrUpdate(RawData e) throws StorageException {
		
		try {
			
			final IRawData oe = get(e.getId());
			IRawData ne;
			
			if(null == oe) {
				ne = new RawData(e.getId());
				ne.setReceivedStamp(new Date());
			}else {
				ne = oe;
			}
			
			UOW.begin();
			
			ne.setChannel(e.getChannel());
			ne.setContentType(e.getContentType());
			ne.setData(e.getData());
			ne.setDeviceId(e.getDeviceId());
			ne.setDeviceModel(e.getDeviceModel());
			ne.setDomainKey(e.getDomainKey());
			ne.setFirmwareVersion(e.getFirmwareVersion());
			ne.setIpAddress(e.getIpAddress());
			ne.setMqttTopic(e.getMqttTopic());
			ne.setNodeId(e.getNodeId());
			ne.setNodeUid(e.getNodeUid());
			ne.setPort(e.getPort());
			ne.setProperties(e.getProperties());
			ne.setRawDataType(e.getRawDataType());
			ne.setSize(null!= e.getData() ? e.getData().length : 0);
			ne.setState(e.getState());
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
	public void update(RawData e) throws StorageException {
		
		try {
			
			final IRawData ne = get(e.getId());
			
			UOW.begin();
			
			ne.setChannel(e.getChannel());
			ne.setContentType(e.getContentType());
			ne.setDeviceId(e.getDeviceId());
			ne.setDeviceModel(e.getDeviceModel());
			ne.setDomainKey(e.getDomainKey());
			ne.setFirmwareVersion(e.getFirmwareVersion());
			ne.setIpAddress(e.getIpAddress());
			ne.setMqttTopic(e.getMqttTopic());
			ne.setNodeId(e.getNodeId());
			ne.setNodeUid(e.getNodeUid());
			ne.setPort(e.getPort());
			ne.setProperties(e.getProperties());
			ne.setRawDataType(e.getRawDataType());
			ne.setState(e.getState());
			ne.setUpdatedStamp(new Date());
			
			UOW.commit();
			
		}catch(Exception ex) {
			UOW.rollback();
			throw new StorageException(ex);
		}
	}

	@Override
	public void updateState(RawData e) throws StorageException {
		
		try {
			
			final IRawData ne = get(e.getId());
			
			UOW.begin();
			
			ne.setState(e.getState());
			ne.setUpdatedStamp(new Date());
			
			UOW.commit();
			
		}catch(Exception ex) {
			UOW.rollback();
			throw new StorageException(ex);
		}
	}

	@Override
	public EntityIterator<RawData> load() throws StorageException {
		return new EntityIteratorImpl<>(RawData.class, "id.rawId");
	}

	@Override
	public EntityIterator<RawData> load(String domainKey) throws StorageException {
		return new EntityIteratorImpl<>("domainKey", domainKey, "receivedStamp", RawData.class);
	}

	@Override
	public long count() throws StorageException {
		return new CommonDAO<>(RawData.class).count();
	}

	@Override
	public long count(String domainKey) throws StorageException {
		return new CommonDAO<>(RawData.class).count("domainKey", domainKey);
	}

	@Override
	public RawData get(String id) throws StorageException {
		return new CommonDAO<>(RawData.class).find(id);
	}

	@Override
	public void delete(String id) throws StorageException {
		new CommonDAO<>(RawData.class).delete("id.rawId", id);
	}

	@Override
	public void delete() throws StorageException {
		new CommonDAO<>(RawData.class).delete();
	}

}
