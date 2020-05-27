package io.boodskap.iot.spi.storage.jpa.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.dao.FirmwareDAO;
import io.boodskap.iot.model.IFirmware;
import io.boodskap.iot.model.jpa.Firmware;
import io.boodskap.iot.model.jpa.FirmwareId;
import io.boodskap.iot.spi.storage.jpa.UOW;
import io.boodskap.iot.spi.storage.jpa.dao.util.CommonDAO;
import io.boodskap.iot.spi.storage.jpa.dao.util.EntityIteratorImpl;

public class FirmwareDAOImpl implements FirmwareDAO<Firmware> {
	
	private static final FirmwareDAO<Firmware> dao = new FirmwareDAOImpl();
	
	protected FirmwareDAOImpl() {
	}
	
	public static final FirmwareDAO<Firmware> get() {
		return dao;
	}

	@Override
	public Firmware create(String domainKey, String deviceModel, String version) {
		return new Firmware(new FirmwareId(domainKey, deviceModel, version));
	}

	@Override
	public Class<? extends Firmware> clazz() {
		return Firmware.class;
	}

	@Override
	public void createOrUpdate(Firmware e) throws StorageException {
		
		try {
			
			final IFirmware oe = get(false, e.getDomainKey(), e.getDeviceModel(), e.getVersion());
			IFirmware ne;
			
			if(null == oe) {
				ne = new Firmware(new FirmwareId(e.getDomainKey(), e.getDeviceModel(), e.getVersion()));
			}else {
				ne = oe;
			}
			
			UOW.begin();
			
			if(null != e.getData()) ne.setData(e.getData());
			
			ne.setMediaType(e.getMediaType());
			ne.setDescription(e.getDescription());
			ne.setDeviceModel(e.getDeviceModel());
			ne.setFileName(e.getFileName());
			ne.setVersion(e.getVersion());
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
	public EntityIterator<Firmware> load() throws StorageException {
		return new EntityIteratorImpl<>(Firmware.class, "id.deviceModel");
	}

	@Override
	public EntityIterator<Firmware> load(String domainKey) throws StorageException {
		return new EntityIteratorImpl<>(Firmware.class, domainKey, "id.deviceModel");
	}

	@Override
	public long count() throws StorageException {
		return new CommonDAO<>(Firmware.class).count();
	}

	@Override
	public long count(String domainKey) throws StorageException {
		return new CommonDAO<>(Firmware.class).count(domainKey);
	}

	@Override
	public long count(String domainKey, String deviceModel) throws StorageException {
		return new CommonDAO<>(Firmware.class).count(domainKey, "deviceModel", deviceModel);
	}

	@Override
	public void delete(String domainKey) throws StorageException {
		new CommonDAO<>(Firmware.class).delete(domainKey);
	}

	@Override
	public void delete(String domainKey, String deviceModel) throws StorageException {
		new CommonDAO<>(Firmware.class).delete(domainKey, "deviceModel", deviceModel);
	}

	@Override
	public void delete(String domainKey, String deviceModel, String version) throws StorageException {
		new CommonDAO<>(Firmware.class).delete(domainKey, "deviceModel", deviceModel, "version", version);
	}

	@Override
	public Firmware get(boolean load, String domainKey, String deviceModel, String version) throws StorageException {
		
		if(load) {
			return new CommonDAO<>(Firmware.class).find(new FirmwareId(domainKey, deviceModel, version));
		}
		
		String jql = "SELECT NEW io.boodskap.iot.model.jpa.Firmware(v.id.deviceModel, v.id.version, v.description, v.fileName, v.contentType, v.createdStamp, v.updatedStamp) FROM Firmware v WHERE v.id.domainKey=:dkey and v.id.deviceModel=:dmdl and v.id.version=:ver";
		
		Map<String, Serializable> params = new HashMap<>();
		params.put("dkey", domainKey);
		params.put("dmdl", deviceModel);
		params.put("ver", version);

		return new CommonDAO<>(Firmware.class).select(jql, params);	
	}

	@Override
	public Collection<Firmware> list(boolean load, String domainKey, String deviceModel, int page, int pageSize) throws StorageException {
		
		if(load) {
			return new CommonDAO<>(Firmware.class).list(domainKey, "deviceModel", deviceModel, page, pageSize, "id.version");
		}
		
		String jql = "SELECT NEW io.boodskap.iot.model.jpa.Firmware(v.id.deviceModel, v.id.version, v.description, v.fileName, v.contentType, v.createdStamp, v.updatedStamp) FROM Firmware v WHERE v.id.domainKey=:dkey and v.id.deviceModel=:dmdl order by v.id.version";
		
		Map<String, Serializable> params = new HashMap<>();
		params.put("dkey", domainKey);
		params.put("dmdl", deviceModel);

		return new CommonDAO<>(Firmware.class).list(jql, params, page, pageSize);

	}

	@Override
	public Collection<Firmware> listNext(boolean loadContent, String domainKey, String deviceModel, String version, int page, int pageSize) throws StorageException {
		return list(loadContent, domainKey, deviceModel, page, pageSize);
	}

	@Override
	public Collection<Firmware> search(boolean load, String domainKey, String query, int pageSize) throws StorageException {
		
		if(load) {
			return new CommonDAO<>(Firmware.class).search(query, domainKey, pageSize);
		}

		String jql = "SELECT NEW io.boodskap.iot.model.jpa.Firmware(v.id.deviceModel, v.id.version, v.description, v.fileName, v.contentType, v.createdStamp, v.updatedStamp) FROM Firmware v WHERE v.id.domainKey=:dkey";
		
		Map<String, Serializable> params = new HashMap<>();
		params.put("dkey", domainKey);

		return new CommonDAO<>(Firmware.class).search(jql, params, query, pageSize);	
	
	}

	@Override
	public Collection<Firmware> search(boolean load, String domainKey, String deviceModel, String query, int pageSize) throws StorageException {
		
		if(load) {
			return new CommonDAO<>(Firmware.class).search(query, domainKey, "deviceModel", deviceModel, pageSize);
		}

		String jql = "SELECT NEW io.boodskap.iot.model.jpa.Firmware(v.id.deviceModel, v.id.version, v.description, v.fileName, v.contentType, v.createdStamp, v.updatedStamp) FROM Firmware v WHERE v.id.domainKey=:dkey and v.id.deviceModel=:dmdl";
		
		Map<String, Serializable> params = new HashMap<>();
		params.put("dkey", domainKey);
		params.put("dmdl", deviceModel);

		return new CommonDAO<>(Firmware.class).search(jql, params, query, pageSize);	
	
	}

	@Override
	public void delete() throws StorageException {
		new CommonDAO<>(Firmware.class).delete();
	}

}
