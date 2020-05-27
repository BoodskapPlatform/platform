package io.boodskap.iot.spi.storage.jpa.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.DeviceFileDAO;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.model.IDeviceFile;
import io.boodskap.iot.model.IFileContent;
import io.boodskap.iot.model.jpa.DeviceFile;
import io.boodskap.iot.model.jpa.DeviceFileId;
import io.boodskap.iot.model.jpa.FileContent;
import io.boodskap.iot.spi.storage.jpa.UOW;
import io.boodskap.iot.spi.storage.jpa.dao.util.CommonDAO;
import io.boodskap.iot.spi.storage.jpa.dao.util.EntityIteratorImpl;

public class DeviceFileDAOImpl implements DeviceFileDAO<DeviceFile> {
	
	private static final DeviceFileDAO<DeviceFile> dao = new DeviceFileDAOImpl();
	
	protected DeviceFileDAOImpl() {
	}
	
	public static final DeviceFileDAO<DeviceFile> get() {
		return dao;
	}

	@Override
	public DeviceFile create(String domainKey, String deviceId, String fileId) {
		return new DeviceFile(new DeviceFileId(domainKey, deviceId, fileId));
	}

	@Override
	public Class<? extends DeviceFile> clazz() {
		return DeviceFile.class;
	}

	@Override
	public void createOrUpdate(DeviceFile e) throws StorageException {
		
		try {
			
			final IDeviceFile oe = get(e.getDomainKey(), e.getDeviceId(), e.getFileId());
			IDeviceFile ne;
			
			if(null == oe) {
				ne = new DeviceFile(new DeviceFileId(e.getDomainKey(), e.getDeviceId(), e.getFileId()));
			}else {
				ne = oe;
			}
			
			UOW.begin();
			
			ne.setData(e.getData());
			ne.setDescription(e.getDescription());
			ne.setMediaType(e.getMediaType());
			ne.setTags(e.getTags());
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
	public void update(String domainKey, String deviceId, String fileId, String tags, String description) throws StorageException {
		try {
			
			IDeviceFile oe = get(domainKey, deviceId, fileId);
			
			if(null == oe) {
				throw new StorageException("Device [%s.%s.%s] not found", domainKey, deviceId, fileId);
			}
			
			UOW.begin();
			
			oe.setTags(tags);
			oe.setDescription(description);
			oe.setUpdatedStamp(new Date());
			
			UOW.commit();
			
		}catch(Exception ex) {
			UOW.rollback();
			throw new StorageException(ex);
		}
	}

	@Override
	public void update(String domainKey, String deviceId, String fileId, byte[] data, String mediaType)throws StorageException {
		try {
			
			IDeviceFile oe = get(domainKey, deviceId, fileId);
			
			if(null == oe) {
				throw new StorageException("Device [%s.%s.%s] not found", domainKey, deviceId, fileId);
			}
			
			UOW.begin();
			
			oe.setMediaType(mediaType);
			oe.setData(data);
			oe.setUpdatedStamp(new Date());
			
			UOW.commit();
			
		}catch(Exception ex) {
			UOW.rollback();
			throw new StorageException(ex);
		}
	}

	@Override
	public IFileContent getContent(String domainKey, String deviceId, String fileId) throws StorageException{
		try {
			String jql = String.format("SELECT NEW io.boodskap.iot.model.jpa.FileContent(v.data, v.mediaType) FROM %s v WHERE v.id.domainKey=:dkey AND v.id.deviceId=:did AND v.id.fileId=:fid", DeviceFile.class.getSimpleName());
			Map<String, Serializable> params = new HashMap<>();
			params.put("dkey", domainKey);
			params.put("did", deviceId);
			params.put("fid", fileId);
			return new CommonDAO<>(FileContent.class).select(jql, params);
		}catch(Exception ex) {
			throw new StorageException(ex);
		}
	}

	@Override
	public EntityIterator<DeviceFile> load() throws StorageException {
		return new EntityIteratorImpl<>(DeviceFile.class, "id.deviceId");
	}

	@Override
	public EntityIterator<DeviceFile> load(String domainKey) throws StorageException {
		return new EntityIteratorImpl<>(DeviceFile.class, domainKey, "id.deviceId");
	}

	@Override
	public long count() throws StorageException {
		return new CommonDAO<>(DeviceFile.class).count();
	}

	@Override
	public long count(String domainKey) throws StorageException {
		return new CommonDAO<>(DeviceFile.class).count(domainKey);
	}

	@Override
	public DeviceFile get(String domainKey, String deviceId, String fileId) throws StorageException {
		return new CommonDAO<>(DeviceFile.class).find(new DeviceFileId(domainKey, deviceId, fileId));
	}

	@Override
	public boolean has(String domainKey, String deviceId, String fileId) throws StorageException {
		return get(domainKey, deviceId, fileId) != null;
	}

	@Override
	public void delete(String domainKey) throws StorageException {
		new CommonDAO<>(DeviceFile.class).delete(domainKey);
	}

	@Override
	public void delete(String domainKey, String deviceId, String fileId) throws StorageException {
		new CommonDAO<>(DeviceFile.class).delete(domainKey, "deviceId", deviceId, "fileId", fileId);
	}

	@Override
	public Collection<DeviceFile> list(boolean load, String domainKey, String deviceId, int page, int pageSize) throws StorageException {
		
		if(load) {
			return new CommonDAO<>(DeviceFile.class).list(domainKey, "deviceId", deviceId, page, pageSize, "id.fileId");
		}
	
		String jql = "SELECT NEW io.boodskap.iot.model.jpa.DeviceFile(v.id.fileId, v.description, v.mediaType, v.tags, v.createdStamp, v.updatedStamp) FROM DeviceFile v WHERE v.id.domainKey=:dkey AND v.id.deviceId=:did";
		
		Map<String, Serializable> params = new HashMap<>();
		params.put("dkey", domainKey);
		params.put("did", deviceId);

		return new CommonDAO<>(DeviceFile.class).list(jql, params, page, pageSize);
	}

	@Override
	public Collection<DeviceFile> listNext(boolean load, String domainKey, String deviceId, String fileId, int page, int pageSize) throws StorageException {
		return list(load, domainKey, deviceId, page, pageSize);
	}

	@Override
	public Collection<DeviceFile> search(boolean load, String domainKey, String deviceId, String query, int pageSize) throws StorageException {
		
		if(load) {
			return new CommonDAO<>(DeviceFile.class).search(query, domainKey, "deviceId", deviceId, pageSize);
		}
		
		String jql = "SELECT NEW io.boodskap.iot.model.jpa.DeviceFile(v.id.fileId, v.description, v.mediaType, v.tags, v.createdStamp, v.updatedStamp) FROM DeviceFile v WHERE v.id.domainKey=:dkey AND v.id.deviceId=:did";
		
		Map<String, Serializable> params = new HashMap<>();
		params.put("dkey", domainKey);
		params.put("did", deviceId);

		return new CommonDAO<>(DeviceFile.class).search(jql, params, query, pageSize);	
	
	}

	@Override
	public void delete() throws StorageException {
		new CommonDAO<>(DeviceFile.class).delete();
	}

}
