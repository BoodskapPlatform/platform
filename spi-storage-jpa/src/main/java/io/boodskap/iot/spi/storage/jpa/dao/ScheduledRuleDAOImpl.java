package io.boodskap.iot.spi.storage.jpa.dao;

import java.util.Collection;
import java.util.Date;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.dao.ScheduledRuleDAO;
import io.boodskap.iot.model.IScheduledRule;
import io.boodskap.iot.model.jpa.ScheduledRule;
import io.boodskap.iot.model.jpa.ScheduledRuleId;
import io.boodskap.iot.spi.storage.jpa.UOW;
import io.boodskap.iot.spi.storage.jpa.dao.util.CommonDAO;
import io.boodskap.iot.spi.storage.jpa.dao.util.EntityIteratorImpl;
import io.boodskap.iot.spi.storage.jpa.dao.util.StringFieldEntityList;

public class ScheduledRuleDAOImpl implements ScheduledRuleDAO<ScheduledRule> {
	
	private static final ScheduledRuleDAO<ScheduledRule> dao = new ScheduledRuleDAOImpl();
	
	protected ScheduledRuleDAOImpl() {
	}
	
	public static final ScheduledRuleDAO<ScheduledRule> get() {
		return dao;
	}

	@Override
	public ScheduledRule create(String domainKey, String ruleId) {
		return new ScheduledRule(new ScheduledRuleId(domainKey, ruleId));
	}

	@Override
	public Class<? extends ScheduledRule> clazz() {
		return ScheduledRule.class;
	}

	@Override
	public void createOrUpdate(ScheduledRule e) throws StorageException {
		
		try {
			
			final IScheduledRule oe = get(e.getDomainKey(), e.getRuleId());
			IScheduledRule ne;
			
			if(null == oe) {
				ne = new ScheduledRule(new ScheduledRuleId(e.getDomainKey(), e.getRuleId()));
				ne.setCreatedStamp(new Date());
			}else {
				ne = oe;
			}
			
			UOW.begin();
			
			ne.setCode(e.getCode());
			ne.setCompilable(e.isCompilable());
			ne.setDescription(e.getDescription());
			ne.setLanguage(e.getLanguage());
			ne.setPattern(e.getPattern());
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
	public EntityIterator<ScheduledRule> load() throws StorageException {
		return new EntityIteratorImpl<>(ScheduledRule.class, "id.ruleId");
	}

	@Override
	public EntityIterator<ScheduledRule> load(String domainKey) throws StorageException {
		return new EntityIteratorImpl<>(ScheduledRule.class, domainKey, "id.ruleId");
	}

	@Override
	public long count() throws StorageException {
		return new CommonDAO<>(ScheduledRule.class).count();
	}

	@Override
	public long count(String domainKey) throws StorageException {
		return new CommonDAO<>(ScheduledRule.class).count(domainKey);
	}

	@Override
	public ScheduledRule get(String domainKey, String id) throws StorageException {
		return new CommonDAO<>(ScheduledRule.class).find(new ScheduledRuleId(domainKey, id));
	}

	@Override
	public void delete(String domainKey) throws StorageException {
		new CommonDAO<>(ScheduledRule.class).delete(domainKey);
	}

	@Override
	public void delete(String domainKey, String id) throws StorageException {
		new CommonDAO<>(ScheduledRule.class).delete(domainKey, "id.ruleId", id);
	}

	@Override
	public Collection<ScheduledRule> list(boolean load, String domainKey, int page, int pageSize) throws StorageException {
		Collection<ScheduledRule> list= new CommonDAO<>(ScheduledRule.class).list(domainKey, page, pageSize, "id.ruleId");
		if(!load) {
			list.forEach(r->{r.setCode(null);});
		}
		return list;
	}

	@Override
	public Collection<ScheduledRule> listNext(boolean load, String domainKey, String id, int page, int pageSize) throws StorageException {
		return list(load, domainKey, page, pageSize);
	}

	@Override
	public Collection<String> listIds(String domainKey, int page, int pageSize) throws StorageException {
		return new StringFieldEntityList(ScheduledRule.class, "id.ruleId", "domainKey", domainKey, "createdStamp").list(page, pageSize);
	}

	@Override
	public Collection<String> listIdsNext(String domainKey, String id, int page, int pageSize) throws StorageException {
		return listIds(domainKey, page, pageSize);
	}

	@Override
	public Collection<ScheduledRule> search(boolean load, String domainKey, String query, int pageSize) throws StorageException {
		Collection<ScheduledRule> list = new CommonDAO<>(ScheduledRule.class).search(query, domainKey, pageSize);
		if(!load) {
			list.forEach(r->{r.setCode(null);});
		}
		return list;
	}

	@Override
	public void delete() throws StorageException {
		new CommonDAO<>(ScheduledRule.class).delete();
	}

}
