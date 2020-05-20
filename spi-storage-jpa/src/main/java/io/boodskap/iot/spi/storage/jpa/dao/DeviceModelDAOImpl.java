package io.boodskap.iot.spi.storage.jpa.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.DeviceModelDAO;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.model.IDeviceModel;
import io.boodskap.iot.model.jpa.DeviceModel;
import io.boodskap.iot.model.jpa.DeviceModelId;
import io.boodskap.iot.spi.storage.jpa.UOW;
import io.boodskap.iot.spi.storage.jpa.dao.util.CommonDAO;
import io.boodskap.iot.spi.storage.jpa.dao.util.EntityIteratorImpl;

public class DeviceModelDAOImpl implements DeviceModelDAO<DeviceModel> {
	
	private static final DeviceModelDAO<DeviceModel> dao = new DeviceModelDAOImpl();
	
	protected DeviceModelDAOImpl() {
	}
	
	public static final DeviceModelDAO<DeviceModel> get() {
		return dao;
	}

	@Override
	public DeviceModel create(String domainKey, String modelId, String version) {
		return new DeviceModel(new DeviceModelId(domainKey, modelId, version));
	}

	@Override
	public Class<? extends DeviceModel> clazz() {
		return DeviceModel.class;
	}

	@Override
	public void createOrUpdate(DeviceModel e) throws StorageException {
		
		try {
			
			final IDeviceModel oe = get(e.getDomainKey(), e.getModelId(), e.getVersion());
			IDeviceModel ne;
			
			if(null == oe) {
				ne = new DeviceModel(new DeviceModelId(e.getDomainKey(), e.getModelId(), e.getVersion()));
				ne.setRegisteredStamp(new Date());
			}else {
				ne = oe;
			}
			
			UOW.begin();
			
			ne.setDescription(e.getDescription());
			
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
	public DeviceModel get(String domainKey, String modelId) throws StorageException {
		String query = "v.id.domainKey=:dkey and v.id.modelId=:mid order by v.id.version desc";
		Map<String, Serializable> params = new HashMap<>();
		params.put("dkey", domainKey);
		params.put("mid", modelId);
		return new CommonDAO<>(DeviceModel.class).get(query, params);
	}

	@Override
	public DeviceModel get(String domainKey, String modelId, String version) throws StorageException {
		return new CommonDAO<>(DeviceModel.class).find(new DeviceModelId(domainKey, modelId, version));
	}

	@Override
	public EntityIterator<DeviceModel> load() throws StorageException {
		return new EntityIteratorImpl<>(DeviceModel.class, "id.modelId");
	}

	@Override
	public EntityIterator<DeviceModel> load(String domainKey) throws StorageException {
		return new EntityIteratorImpl<>(DeviceModel.class, domainKey, "id.modelId");
	}

	@Override
	public long count() throws StorageException {
		return new CommonDAO<>(DeviceModel.class).count();
	}

	@Override
	public long count(String domainKey) throws StorageException {
		return new CommonDAO<>(DeviceModel.class).count(domainKey);
	}

	@Override
	public long count(String domainKey, String modelId) throws StorageException {
		return new CommonDAO<>(DeviceModel.class).count(domainKey, "modelId", modelId);
	}

	@Override
	public void delete(String domainKey) throws StorageException {
		new CommonDAO<>(DeviceModel.class).delete(domainKey);
	}

	@Override
	public void delete(String domainKey, String modelId) throws StorageException {
		new CommonDAO<>(DeviceModel.class).delete(domainKey, "modelId", modelId);
	}

	@Override
	public void delete(String domainKey, String modelId, String version) throws StorageException {
		new CommonDAO<>(DeviceModel.class).delete(domainKey, "modelId", modelId, "version", version);
	}

	@Override
	public Collection<DeviceModel> list(String domainKey, int page, int pageSize) throws StorageException {
		return new CommonDAO<>(DeviceModel.class).list(domainKey, page, pageSize, "id.modelId");
	}

	@Override
	public Collection<DeviceModel> listNext(String domainKey, String modelId, int page, int pageSize) throws StorageException {
		return list(domainKey, page, pageSize);
	}

	@Override
	public Collection<DeviceModel> list(String domainKey, String modelId, int page, int pageSize) throws StorageException {
		return new CommonDAO<>(DeviceModel.class).list(domainKey, "modelId", modelId, page, pageSize, "id.version");
	}

	@Override
	public Collection<DeviceModel> listNext(String domainKey, String modelId, String version, int page, int pageSize) throws StorageException {
		return list(domainKey, modelId, page, pageSize);
	}

	@Override
	public Collection<DeviceModel> search(String domainKey, String modelId, String query, int pageSize)throws StorageException {
		return new CommonDAO<>(DeviceModel.class).search(query, domainKey, "modelId", modelId, pageSize);
	}

	@Override
	public void delete() throws StorageException {
		new CommonDAO<>(DeviceModel.class).delete();
	}

}
