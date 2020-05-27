package io.boodskap.iot.spi.storage.jpa.dao;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.dao.GlobalDataDAO;
import io.boodskap.iot.model.IGlobalData;
import io.boodskap.iot.model.jpa.GlobalData;
import io.boodskap.iot.model.jpa.GlobalDataId;
import io.boodskap.iot.spi.storage.jpa.UOW;
import io.boodskap.iot.spi.storage.jpa.dao.util.CommonDAO;
import io.boodskap.iot.spi.storage.jpa.dao.util.EntityIteratorImpl;

public class GlobalDataDAOImpl implements GlobalDataDAO<GlobalData> {
	
	private static final GlobalDataDAO<GlobalData> dao = new GlobalDataDAOImpl();
	
	protected GlobalDataDAOImpl() {
	}
	
	public static final GlobalDataDAO<GlobalData> get() {
		return dao;
	}

	@Override
	public GlobalData create(String dataId, String domainKey) {
		return new GlobalData(new GlobalDataId(dataId, domainKey));
	}

	@Override
	public Class<? extends GlobalData> clazz() {
		return GlobalData.class;
	}

	@Override
	public void createOrUpdate(GlobalData e) throws StorageException {
		
		try {
			
			final IGlobalData oe = get(e.getDataId());
			IGlobalData ne;
			
			if(null == oe) {
				ne = new GlobalData(new GlobalDataId(e.getDataId(), e.getDomainKey()));
			}else {
				ne = oe;
			}
			
			UOW.begin();
			
			ne.setData(e.getData());
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
	public EntityIterator<GlobalData> load() throws StorageException {
		return new EntityIteratorImpl<>(GlobalData.class, "id.dataId");
	}

	@Override
	public EntityIterator<GlobalData> load(String domainKey) throws StorageException {
		return new EntityIteratorImpl<>(GlobalData.class, domainKey, "id.dataId");
	}

	@Override
	public long count() throws StorageException {
		return new CommonDAO<>(GlobalData.class).count();
	}

	@Override
	public long count(String domainKey) throws StorageException {
		return new CommonDAO<>(GlobalData.class).count(domainKey);
	}

	@Override
	public void delete(String domainKey) throws StorageException {
		new CommonDAO<>(GlobalData.class).delete(domainKey);
	}

	@Override
	public void delete(String dataId, String domainKey) throws StorageException {
		new CommonDAO<>(GlobalData.class).delete(domainKey, "dataId", dataId);
	}

	@Override
	public GlobalData get(String dataId) throws StorageException {
		String query = "v.id.dataId=:did";
		Map<String, Serializable> params = new HashMap<>();
		params.put("did", dataId);
		return new CommonDAO<>(GlobalData.class).getUnique(query, params);
	}

	@Override
	public GlobalData get(String dataId, String domainKey) throws StorageException {
		return new CommonDAO<>(GlobalData.class).find(new GlobalDataId(dataId, domainKey));
	}

	@Override
	public void delete() throws StorageException {
		new CommonDAO<>(GlobalData.class).delete();
	}

}
