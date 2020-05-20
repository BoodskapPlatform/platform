package io.boodskap.iot.spi.storage.jpa.dao;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.dao.NodeScheduledRuleDAO;
import io.boodskap.iot.model.INodeScheduledRule;
import io.boodskap.iot.model.jpa.NodeScheduledRule;
import io.boodskap.iot.model.jpa.NodeScheduledRuleId;
import io.boodskap.iot.spi.storage.jpa.UOW;
import io.boodskap.iot.spi.storage.jpa.dao.util.CommonDAO;
import io.boodskap.iot.spi.storage.jpa.dao.util.EntityIteratorImpl;
import io.boodskap.iot.spi.storage.jpa.dao.util.StringFieldEntityIterator;

public class NodeScheduledRuleDAOImpl implements NodeScheduledRuleDAO<NodeScheduledRule> {
	
	private static final NodeScheduledRuleDAO<NodeScheduledRule> dao = new NodeScheduledRuleDAOImpl();
	
	protected NodeScheduledRuleDAOImpl() {
	}
	
	public static final NodeScheduledRuleDAO<NodeScheduledRule> get() {
		return dao;
	}

	@Override
	public NodeScheduledRule create(String domainKey, String ruleId, String nodeId) {
		return new NodeScheduledRule(new NodeScheduledRuleId(domainKey, ruleId, nodeId));
	}

	@Override
	public Class<? extends NodeScheduledRule> clazz() {
		return NodeScheduledRule.class;
	}

	@Override
	public void createOrUpdate(NodeScheduledRule e) throws StorageException {
		
		try {
			
			final INodeScheduledRule oe = get(e.getDomainKey(), e.getRuleId());
			INodeScheduledRule ne;
			
			if(null == oe) {
				ne = new NodeScheduledRule(new NodeScheduledRuleId(e.getDomainKey(), e.getRuleId(), e.getNodeId()));
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
	public EntityIterator<NodeScheduledRule> load() throws StorageException {
		return new EntityIteratorImpl<>(NodeScheduledRule.class, "id.ruleId");
	}

	@Override
	public EntityIterator<NodeScheduledRule> load(String domainKey) throws StorageException {
		return new EntityIteratorImpl<>(NodeScheduledRule.class, domainKey, "id.ruleId");
	}

	@Override
	public long count() throws StorageException {
		return new CommonDAO<>(NodeScheduledRule.class).count();
	}

	@Override
	public long count(String domainKey) throws StorageException {
		return new CommonDAO<>(NodeScheduledRule.class).count(domainKey);
	}

	@Override
	public long countByNodeId(String nodeId) throws StorageException {
		return new CommonDAO<>(NodeScheduledRule.class).count("id.nodeId", nodeId);
	}

	@Override
	public void delete(String domainKey) throws StorageException {
		new CommonDAO<>(NodeScheduledRule.class).delete(domainKey);
	}

	@Override
	public void delete(String domainKey, String ruleId) throws StorageException {
		new CommonDAO<>(NodeScheduledRule.class).delete(domainKey, "ruleId", ruleId);
	}

	@Override
	public void delete(String domainKey, String ruleId, String nodeId) throws StorageException {
		new CommonDAO<>(NodeScheduledRule.class).delete(domainKey, "ruleId", ruleId, "nodeId", nodeId);
	}

	@Override
	public EntityIterator<String> ruleIdsByNode(String nodeId) throws StorageException {
		return new StringFieldEntityIterator(NodeScheduledRule.class, "id.ruleId", "nodeId", nodeId, "id.ruleId");
	}

	@Override
	public NodeScheduledRule get(String domainKey, String ruleId) throws StorageException {
		String query = "v.domainKey=':dkey and v.ruleId=:rid";
		Map<String, Serializable> params = new HashMap<>();
		params.put("dkey", domainKey);
		params.put("rid", ruleId);
		return new CommonDAO<>(NodeScheduledRule.class).getUnique(query, params);
	}

	@Override
	public NodeScheduledRule get(String domainKey, String ruleId, String nodeId) throws StorageException {
		return new CommonDAO<>(NodeScheduledRule.class).find(new NodeScheduledRuleId(domainKey, ruleId, nodeId));
	}

	@Override
	public void delete() throws StorageException {
		new CommonDAO<>(NodeScheduledRule.class).delete();
	}

}
