package io.boodskap.iot.spi.storage.jpa.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.BinaryRuleDAO;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.model.IBinaryRule;
import io.boodskap.iot.model.jpa.BinaryRule;
import io.boodskap.iot.model.jpa.BinaryRuleId;
import io.boodskap.iot.spi.storage.jpa.UOW;
import io.boodskap.iot.spi.storage.jpa.dao.util.CommonDAO;
import io.boodskap.iot.spi.storage.jpa.dao.util.EntityIteratorImpl;

public class BinaryRuleDAOImpl implements BinaryRuleDAO<BinaryRule> {
	
	private static final BinaryRuleDAO<BinaryRule> instance = new BinaryRuleDAOImpl();

	protected BinaryRuleDAOImpl() {
	}
	
	public static final BinaryRuleDAO<BinaryRule> get() {
		return instance;
	}

	@Override
	public BinaryRule create(String domainKey, String type) {
		return new BinaryRule(new BinaryRuleId(domainKey, type));
	}

	@Override
	public Class<? extends BinaryRule> clazz() {
		return BinaryRule.class;
	}

	@Override
	public void createOrUpdate(BinaryRule e) throws StorageException {
		
		try {
			
			final IBinaryRule oe = get(e.getDomainKey(), e.getType());
			IBinaryRule ne;
			
			if(null == oe) {
				ne = new BinaryRule(new BinaryRuleId(e.getDomainKey(), e.getType()));
			}else {
				ne = oe;
			}
			
			UOW.begin();

			ne.setCode(e.getCode());
			ne.setCompilable(e.isCompilable());
			ne.setLanguage(e.getLanguage());
			ne.setDescription(e.getDescription());

			ne.getPlugins().clear();
			ne.getPlugins().addAll(e.getPlugins());
			
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
	public BinaryRule get(String domainKey, String type) throws StorageException {
		return new CommonDAO<>(BinaryRule.class).find(new BinaryRuleId(domainKey, type));
	}

	@Override
	public EntityIterator<BinaryRule> load() throws StorageException {
		try {
			return new EntityIteratorImpl<>(BinaryRule.class, "id.type");
		}catch(Exception ex) {
			throw new StorageException(ex);
		}
	}

	@Override
	public EntityIterator<BinaryRule> load(String domainKey) throws StorageException {
		try {
			return new EntityIteratorImpl<>(BinaryRule.class, domainKey, "id.type");
		}catch(Exception ex) {
			throw new StorageException(ex);
		}
	}

	@Override
	public long count() throws StorageException {
		return new CommonDAO<>(BinaryRule.class).count();
	}

	@Override
	public long count(String domainKey) throws StorageException {
		return new CommonDAO<>(BinaryRule.class).count(domainKey);
	}

	@Override
	public void delete(String domainKey) throws StorageException {
		new CommonDAO<>(BinaryRule.class).delete(domainKey);
	}

	@Override
	public void delete(String domainKey, String type) throws StorageException {
		new CommonDAO<>(BinaryRule.class).delete(domainKey, "type", type);
	}

	@Override
	public Collection<BinaryRule> list(boolean load, String domainKey, int page, int pageSize) throws StorageException {
		Collection<BinaryRule> list = new CommonDAO<BinaryRule>(BinaryRule.class).list(domainKey, page, pageSize, "id.type");
		if(!load) {
			list.forEach(r->{r.setCode(null);});
		}
		return list;
	}

	@Override
	public Collection<BinaryRule> listNext(boolean load, String domainKey, String type, int page, int pageSize) throws StorageException {
		return list(load, domainKey, page, pageSize);
	}

	@Override
	public Collection<BinaryRule> search(boolean load, String domainKey, String query, int pageSize) throws StorageException {
		Collection<BinaryRule> list = new CommonDAO<BinaryRule>(BinaryRule.class).search(query, domainKey, pageSize);
		if(!load) {
			list.forEach(r->{r.setCode(null);});
		}
		return list;
	}

	@Override
	public Collection<String> listTypes(String domainKey, int page, int pageSize) throws StorageException {
		Map<String, Serializable> params = new HashMap<>();
		params.put("dkey", domainKey);
		return new CommonDAO<>(String.class).list("SELECT v.id.type FROM DomainRole v WHERE v.id.domainKey=:dkey", params);
	}

	@Override
	public Collection<String> listTypesNext(String domainKey, String type, int page, int pageSize) throws StorageException {
		return listTypes(domainKey, page, pageSize);
	}

	@Override
	public void delete() throws StorageException {
		new CommonDAO<>(BinaryRule.class).delete();
	}

}
