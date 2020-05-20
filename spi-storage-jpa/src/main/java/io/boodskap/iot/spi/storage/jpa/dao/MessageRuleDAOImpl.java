package io.boodskap.iot.spi.storage.jpa.dao;

import java.util.Collection;
import java.util.Date;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.dao.MessageRuleDAO;
import io.boodskap.iot.model.IMessageRule;
import io.boodskap.iot.model.jpa.MessageRule;
import io.boodskap.iot.model.jpa.MessageRuleId;
import io.boodskap.iot.spi.storage.jpa.UOW;
import io.boodskap.iot.spi.storage.jpa.dao.util.CommonDAO;
import io.boodskap.iot.spi.storage.jpa.dao.util.EntityIteratorImpl;
import io.boodskap.iot.spi.storage.jpa.dao.util.StringFieldEntityList;

public class MessageRuleDAOImpl implements MessageRuleDAO<MessageRule> {
	
	private static final MessageRuleDAO<MessageRule> dao = new MessageRuleDAOImpl();
	
	protected MessageRuleDAOImpl() {
	}
	
	public static final MessageRuleDAO<MessageRule> get() {
		return dao;
	}

	@Override
	public MessageRule create(String domainKey, String specId) {
		return new MessageRule(new MessageRuleId(domainKey, specId));
	}

	@Override
	public Class<? extends MessageRule> clazz() {
		return MessageRule.class;
	}

	@Override
	public void createOrUpdate(MessageRule e) throws StorageException {
		
		try {
			
			final IMessageRule oe = get(e.getDomainKey(), e.getSpecId());
			IMessageRule ne;
			
			if(null == oe) {
				ne = new MessageRule(new MessageRuleId(e.getDomainKey(), e.getSpecId()));
				ne.setCreatedStamp(new  Date());
			}else{
				ne = oe;
			}
			
			UOW.begin();
			
			ne.setCode(e.getCode());
			ne.setCompilable(e.isCompilable());
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
	public EntityIterator<MessageRule> load() throws StorageException {
		return new EntityIteratorImpl<>(MessageRule.class, "id.specId");
	}

	@Override
	public EntityIterator<MessageRule> load(String domainKey) throws StorageException {
		return new EntityIteratorImpl<>(MessageRule.class, domainKey, "id.specId");
	}

	@Override
	public long count() throws StorageException {
		return new CommonDAO<>(MessageRule.class).count();
	}

	@Override
	public long count(String domainKey) throws StorageException {
		return new CommonDAO<>(MessageRule.class).count(domainKey);
	}

	@Override
	public void delete(String domainKey) throws StorageException {
		new CommonDAO<>(MessageRule.class).delete(domainKey);
	}

	@Override
	public void delete(String domainKey, String specId) throws StorageException {
		new CommonDAO<>(MessageRule.class).delete(domainKey, "specId", specId);
	}

	@Override
	public MessageRule get(String domainKey, String specId) throws StorageException {
		return new CommonDAO<>(MessageRule.class).find(new MessageRuleId(domainKey, specId));
	}

	@Override
	public boolean has(String domainKey, String specId) throws StorageException {
		return get(domainKey, specId) != null;
	}

	@Override
	public Collection<MessageRule> list(boolean load, String domainKey, int page, int pageSize) throws StorageException {
		Collection<MessageRule> list = new CommonDAO<>(MessageRule.class).list(domainKey, page, pageSize, "id.specId");
		if(!load) {
			list.forEach(r -> {r.setCode(null);});
		}
		return list;
	}

	@Override
	public Collection<MessageRule> listNext(boolean load, String domainKey, String specId, int page, int pageSize) throws StorageException {
		return list(load, domainKey, page, pageSize);
	}

	@Override
	public Collection<MessageRule> search(boolean load, String domainKey, String query, int pageSize) throws StorageException {
		Collection<MessageRule> list = new CommonDAO<>(MessageRule.class).search(query, domainKey, pageSize);
		if(!load) {
			list.forEach(r->{r.setCode(null);});
		}
		return list;
	}

	@Override
	public Collection<String> listSpecs(String domainKey, int page, int pageSize) throws StorageException {
		return new StringFieldEntityList(MessageRule.class, "id.specId", "domainKey", domainKey, "id.specId").list(page, pageSize);
	}

	@Override
	public Collection<String> listSpecsNext(String domainKey, String specId, int page, int pageSize) throws StorageException {
		return listSpecs(domainKey, page, pageSize);
	}

	@Override
	public void delete() throws StorageException {
		new CommonDAO<>(MessageRule.class).delete();
	}

}
