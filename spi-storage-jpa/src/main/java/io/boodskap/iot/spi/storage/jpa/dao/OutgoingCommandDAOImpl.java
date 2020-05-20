package io.boodskap.iot.spi.storage.jpa.dao;

import java.util.Collection;
import java.util.Date;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.dao.OutgoingCommandDAO;
import io.boodskap.iot.model.IOutgoingCommand;
import io.boodskap.iot.model.jpa.OutgoingCommand;
import io.boodskap.iot.model.jpa.OutgoingCommandId;
import io.boodskap.iot.spi.storage.jpa.UOW;
import io.boodskap.iot.spi.storage.jpa.dao.util.CommonDAO;
import io.boodskap.iot.spi.storage.jpa.dao.util.EntityIteratorImpl;

public class OutgoingCommandDAOImpl implements OutgoingCommandDAO<OutgoingCommand> {
	
	private static final OutgoingCommandDAO<OutgoingCommand> dao = new OutgoingCommandDAOImpl();
	
	protected OutgoingCommandDAOImpl() {
	}
	
	public static final OutgoingCommandDAO<OutgoingCommand> get() {
		return dao;
	}

	@Override
	public OutgoingCommand create(String domainKey, String requestId, String deviceId, long corrId) {
		return new OutgoingCommand(new OutgoingCommandId(domainKey, requestId, deviceId, corrId));
	}

	@Override
	public Class<? extends OutgoingCommand> clazz() {
		return OutgoingCommand.class;
	}

	@Override
	public void createOrUpdate(OutgoingCommand e) throws StorageException {
		
		try {
			
			final IOutgoingCommand oe = get(e.getDomainKey(), e.getRequestId(), e.getDeviceId(), e.getCorrId());
			IOutgoingCommand ne;
			
			if(null == oe) {
				ne = new OutgoingCommand(new OutgoingCommandId(e.getDomainKey(), e.getRequestId(), e.getDeviceId(), e.getCorrId()));
				ne.setCreatedStamp(new Date());
			}else {
				ne = oe;
			}
			
			UOW.begin();
			
			ne.setAckedStamp(e.getAckedStamp());
			ne.setChannel(e.getChannel());
			ne.setData(e.getData());
			ne.setDescription(e.getDescription());
			ne.setLoraBaseStationId(e.getLoraBaseStationId());
			ne.setLoraModemId(e.getLoraModemId());
			ne.setLoraReceiverId(e.getLoraReceiverId());
			ne.setLoraTarget(e.getLoraTarget());
			ne.setLoraTransceiverId(e.getLoraTransceiverId());
			ne.setLoraTransmitterId(e.getLoraTransmitterId());
			ne.setNackCode(e.getNackCode());
			ne.setNodeId(e.getNodeId());
			ne.setNodeUid(e.getNodeUid());
			ne.setQueuedStamp(e.getQueuedStamp());
			ne.setReportedIp(e.getReportedIp());
			ne.setReportedPort(e.getReportedPort());
			ne.setSentStamp(e.getSentStamp());
			ne.setType(e.getType());
			
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
	public EntityIterator<OutgoingCommand> load() throws StorageException {
		return new EntityIteratorImpl<>(OutgoingCommand.class, "id.deviceId");
	}

	@Override
	public EntityIterator<OutgoingCommand> load(String domainKey) throws StorageException {
		return new EntityIteratorImpl<>(OutgoingCommand.class, domainKey, "id.deviceId");
	}

	@Override
	public long count() throws StorageException {
		return new CommonDAO<>(OutgoingCommand.class).count();
	}

	@Override
	public long count(String domainKey) throws StorageException {
		return new CommonDAO<>(OutgoingCommand.class).count(domainKey);
	}

	@Override
	public long countByRequest(String domainKey, String requestId) throws StorageException {
		return new CommonDAO<>(OutgoingCommand.class).count(domainKey, "requestId", requestId);
	}

	@Override
	public long countByDevice(String domainKey, String deviceId) throws StorageException {
		return new CommonDAO<>(OutgoingCommand.class).count(domainKey, "deviceId", deviceId);
	}

	@Override
	public OutgoingCommand get(String domainKey, String requestId, String deviceId, long corrId) throws StorageException {
		return new CommonDAO<>(OutgoingCommand.class).find(new OutgoingCommandId(domainKey, requestId, deviceId, corrId));
	}

	@Override
	public void delete(String domainKey) throws StorageException {
		new CommonDAO<>(OutgoingCommand.class).delete(domainKey);
	}

	@Override
	public void delete(String domainKey, String requestId) throws StorageException {
		new CommonDAO<>(OutgoingCommand.class).delete(domainKey, "requestId", requestId);
	}

	@Override
	public void delete(String domainKey, String requestId, String deviceId) throws StorageException {
		new CommonDAO<>(OutgoingCommand.class).delete(domainKey, "requestId", requestId, "deviceId", deviceId);
	}

	@Override
	public void delete(String domainKey, String requestId, String deviceId, long corrId) throws StorageException {
		new CommonDAO<>(OutgoingCommand.class).delete(domainKey, "requestId", requestId, "deviceId", deviceId, "corrId", corrId);
	}

	@Override
	public Collection<OutgoingCommand> list(String domainKey, String deviceId, int page, int pageSize) throws StorageException {
		return new CommonDAO<>(OutgoingCommand.class).list(domainKey, "deviceId", deviceId, page, pageSize, "id.corrId");
	}

	@Override
	public Collection<OutgoingCommand> listNext(String domainKey, String deviceId, long corrId, int page, int pageSize) throws StorageException {
		return list(domainKey, deviceId, page, pageSize);
	}

	@Override
	public Collection<OutgoingCommand> listByRequest(String domainKey, String requestId, int page, int pageSize) throws StorageException {
		return new CommonDAO<>(OutgoingCommand.class).list(domainKey, "requestId", requestId, page, pageSize, "id.deviceId");
	}

	@Override
	public Collection<OutgoingCommand> listByReqestNext(String domainKey, String requestId, String deviceId, long corrId, int page, int pageSize) throws StorageException {
		return listByRequest(domainKey, requestId, page, pageSize);
	}

	@Override
	public void delete() throws StorageException {
		new CommonDAO<>(OutgoingCommand.class).delete();
	}

}
