package io.boodskap.iot.spi.storage.jpa.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.dao.RawMessageDAO;
import io.boodskap.iot.model.IRawMessage;
import io.boodskap.iot.model.jpa.RawMessage;
import io.boodskap.iot.model.jpa.RawMessageId;
import io.boodskap.iot.spi.storage.jpa.UOW;
import io.boodskap.iot.spi.storage.jpa.dao.util.CommonDAO;
import io.boodskap.iot.spi.storage.jpa.dao.util.EntityIteratorImpl;

public class RawMessageDAOImpl implements RawMessageDAO<RawMessage> {
	
	private static final RawMessageDAO<RawMessage> dao = new RawMessageDAOImpl();
	
	protected RawMessageDAOImpl() {
	}
	
	public static final RawMessageDAO<RawMessage> get() {
		return dao;
	}

	@Override
	public RawMessage create(String domainKey, String rawId) {
		return new RawMessage(new RawMessageId(domainKey, rawId));
	}

	@Override
	public Class<? extends RawMessage> clazz() {
		return RawMessage.class;
	}

	@Override
	public void createOrUpdate(RawMessage e) throws StorageException {
		
		try {
			
			final IRawMessage oe = get(e.getDomainKey(), e.getRawId());
			IRawMessage ne;
			
			if(null == oe) {
				ne = new RawMessage(new RawMessageId(e.getDomainKey(), e.getRawId()));
			}else {
				ne = oe;
			}
			
			UOW.begin();
			
			ne.setReceivedStamp(e.getReceivedStamp());
			ne.setChannel(e.getChannel());
			ne.setData(e.getData());
			ne.setDeviceId(e.getDeviceId());
			ne.setDeviceModel(e.getDeviceModel());
			ne.setFirmwareVersion(e.getFirmwareVersion());
			ne.setHeader(e.getHeader());
			ne.setIpAddress(e.getIpAddress());
			ne.setSpecId(e.getSpecId());
			ne.setNodeId(e.getNodeId());
			ne.setNodeUid(e.getNodeUid());
			ne.setPort(e.getPort());
			
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
	public EntityIterator<RawMessage> load() throws StorageException {
		return new EntityIteratorImpl<>(RawMessage.class, "id.rawId");
	}

	@Override
	public EntityIterator<RawMessage> load(String domainKey) throws StorageException {
		return new EntityIteratorImpl<>(RawMessage.class, domainKey, "id.rawId");
	}

	@Override
	public long count() throws StorageException {
		return new CommonDAO<>(RawMessage.class).count();
	}

	@Override
	public long count(String domainKey) throws StorageException {
		return new CommonDAO<>(RawMessage.class).count(domainKey);
	}

	@Override
	public long count(String domainKey, String deviceId) throws StorageException {
		return new CommonDAO<>(RawMessage.class).countByQuery(String.format("v.id.domainKey='%s' and v.deviceId='%s'", domainKey, deviceId));
	}

	@Override
	public long count(String domainKey, String deviceId, String specId) throws StorageException {
		return new CommonDAO<>(RawMessage.class).countByQuery(String.format("v.id.domainKey='%s' and v.deviceId='%s' and v.specId='%s'", domainKey, deviceId, specId));
	}

	@Override
	public RawMessage get(String domainKey, String id) throws StorageException {
		return new CommonDAO<>(RawMessage.class).find(new RawMessageId(domainKey, id));
	}

	@Override
	public void delete(String domainKey) throws StorageException {
		new CommonDAO<>(RawMessage.class).delete(domainKey);
	}

	@Override
	public void delete(String domainKey, String id) throws StorageException {
		new CommonDAO<>(RawMessage.class).delete(domainKey, "id.rawId", id);
	}

	@Override
	public Collection<RawMessage> list(String domainKey, String deviceId, int page, int pageSize) throws StorageException {
		Map<String, Serializable> params = new HashMap<>();
		params.put("dkey", domainKey);
		params.put("did", deviceId);
		return new CommonDAO<>(RawMessage.class).list("select v from RawMessage v where v.id.domainKey=:dkey and v.deviceId=:did order by v.id.rawId", params, page, pageSize);
	}

	@Override
	public Collection<RawMessage> listNext(String domainKey, String deviceId, String id, int page, int pageSize) throws StorageException {
		return list(domainKey, deviceId, page, pageSize);
	}

	@Override
	public Collection<RawMessage> list(String domainKey, String deviceId, String specId, int page, int pageSize) throws StorageException {
		Map<String, Serializable> params = new HashMap<>();
		params.put("dkey", domainKey);
		params.put("did", deviceId);
		params.put("sid", specId);
		return new CommonDAO<>(RawMessage.class).list("select v from RawMessage v where v.id.domainKey=:dkey and v.deviceId=:did and v.specId=:sid order by v.id.rawId", params, page, pageSize);
	}

	@Override
	public Collection<RawMessage> listNext(String domainKey, String deviceId, String specId, String id, int page, int pageSize) throws StorageException {
		return list(domainKey, deviceId, specId, page, pageSize);
	}

	@Override
	public void delete() throws StorageException {
		new CommonDAO<>(RawMessage.class).delete();
	}

}
