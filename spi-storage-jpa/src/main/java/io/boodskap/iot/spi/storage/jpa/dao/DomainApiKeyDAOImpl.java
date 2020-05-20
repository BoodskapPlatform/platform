package io.boodskap.iot.spi.storage.jpa.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.DomainApiKeyDAO;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.model.IDomainApiKey;
import io.boodskap.iot.model.jpa.DomainApiKey;
import io.boodskap.iot.model.jpa.DomainApiKeyId;
import io.boodskap.iot.spi.storage.jpa.UOW;
import io.boodskap.iot.spi.storage.jpa.dao.util.CommonDAO;
import io.boodskap.iot.spi.storage.jpa.dao.util.EntityIteratorImpl;

public class DomainApiKeyDAOImpl implements DomainApiKeyDAO<DomainApiKey> {
	
	private static final DomainApiKeyDAO<DomainApiKey> dao = new DomainApiKeyDAOImpl();
	
	protected DomainApiKeyDAOImpl() {
	}
	
	public static final DomainApiKeyDAO<DomainApiKey> get() {
		return dao;
	}

	@Override
	public DomainApiKey create(String domainKey, String apiKey) {
		return new DomainApiKey(new DomainApiKeyId(domainKey, apiKey));
	}

	@Override
	public Class<? extends DomainApiKey> clazz() {
		return DomainApiKey.class;
	}

	@Override
	public void createOrUpdate(DomainApiKey e) throws StorageException {
		
		try {
			
			final IDomainApiKey oe = get(e.getDomainKey(), e.getApiKey());
			IDomainApiKey ne;
			
			if(null == oe) {
				ne = new DomainApiKey(new DomainApiKeyId(e.getDomainKey(), e.getApiKey()));
			}else {
				ne = oe;
			}
			
			UOW.begin();
			
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
	public EntityIterator<DomainApiKey> load() throws StorageException {
		return new EntityIteratorImpl<>(DomainApiKey.class, "id.apiKey");
	}

	@Override
	public EntityIterator<DomainApiKey> load(String domainKey) throws StorageException {
		return new EntityIteratorImpl<>(DomainApiKey.class, domainKey, "id.apiKey");
	}

	@Override
	public long count() throws StorageException {
		return new CommonDAO<>(DomainApiKey.class).count();
	}

	@Override
	public long count(String domainKey) throws StorageException {
		return new CommonDAO<>(DomainApiKey.class).count(domainKey);
	}

	@Override
	public void delete(String domainKey) throws StorageException {
		new CommonDAO<>(DomainApiKey.class).delete(domainKey);
	}

	@Override
	public DomainApiKey get(String domainKey, String apiKey) throws StorageException {
		return new CommonDAO<>(DomainApiKey.class).find(new DomainApiKeyId(domainKey, apiKey));
	}

	@Override
	public DomainApiKey get(String domainKey) throws StorageException {
		String query = "v.id.domainKey=:dkey";
		Map<String, Serializable> params = new HashMap<>();
		params.put("dkey", domainKey);
		return new CommonDAO<>(DomainApiKey.class).get(query, params);
	}

	@Override
	public Collection<DomainApiKey> list(String domainKey, int page, int pageSize) throws StorageException {
		return new CommonDAO<>(DomainApiKey.class).list(domainKey, page, pageSize, "id.apiKey");
	}

	@Override
	public Collection<DomainApiKey> listNext(String domainKey, String apiKey, int page, int pageSize) throws StorageException {
		return list(domainKey, page, pageSize);
	}

	@Override
	public void delete() throws StorageException {
		new CommonDAO<>(DomainApiKey.class).delete();
	}

}
