package io.boodskap.iot.spi.storage.jpa.dao;

import java.util.Date;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.DomainRuleDAO;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.model.IDomainRule;
import io.boodskap.iot.model.jpa.DomainRule;
import io.boodskap.iot.spi.storage.jpa.UOW;
import io.boodskap.iot.spi.storage.jpa.dao.util.CommonDAO;
import io.boodskap.iot.spi.storage.jpa.dao.util.EntityIteratorImpl;

public class DomainRuleDAOImpl implements DomainRuleDAO<DomainRule> {
	
	private static final DomainRuleDAO<DomainRule> dao = new DomainRuleDAOImpl();
	
	protected DomainRuleDAOImpl() {
	}
	
	public static final DomainRuleDAO<DomainRule> get() {
		return dao;
	}

	@Override
	public DomainRule create(String domainKey) {
		return new DomainRule(domainKey);
	}

	@Override
	public Class<? extends DomainRule> clazz() {
		return DomainRule.class;
	}

	@Override
	public void createOrUpdate(DomainRule e) throws StorageException {
		
		try {
			
			final IDomainRule oe = get(e.getDomainKey());
			IDomainRule ne;
			
			if(null == oe) {
				ne = new DomainRule(e.getDomainKey());
				ne.setCreatedStamp(new Date());
			}else {
				ne = oe;
			}
			
			UOW.begin();
			
			ne.setCode(e.getCode());
			ne.setCompilable(e.isCompilable());
			ne.setCreatedStamp(e.getCreatedStamp());
			ne.setDescription(e.getDescription());
			ne.setLanguage(e.getLanguage());
			ne.setPlugins(e.getPlugins());
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
	public EntityIterator<DomainRule> load() throws StorageException {
		return new EntityIteratorImpl<>(DomainRule.class, "id.domainKey");
	}

	@Override
	public EntityIterator<DomainRule> load(String domainKey) throws StorageException {
		return new EntityIteratorImpl<>(DomainRule.class, domainKey, "id.domainKey");
	}

	@Override
	public long count() throws StorageException {
		return new CommonDAO<>(DomainRule.class).count();
	}

	@Override
	public long count(String domainKey) throws StorageException {
		return new CommonDAO<>(DomainRule.class).count(domainKey);
	}

	@Override
	public void delete(String domainKey) throws StorageException {
		new CommonDAO<>(DomainRule.class).delete(domainKey);
	}

	@Override
	public DomainRule get(String domainKey) throws StorageException {
		return new CommonDAO<>(DomainRule.class).find(domainKey);
	}

	@Override
	public void delete() throws StorageException {
		new CommonDAO<>(DomainRule.class).delete();
	}

}
