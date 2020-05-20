/*******************************************************************************
 * Copyright (C) 2019 Boodskap Inc
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/
package io.boodskap.iot.spi.storage.policy.wrapper.dao;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.dao.NodeScheduledRuleDAO;
import io.boodskap.iot.model.INodeScheduledRule;

public class NodeScheduledRuleDAOImpl implements NodeScheduledRuleDAO<INodeScheduledRule> {

	private final NodeScheduledRuleDAO<INodeScheduledRule> impl;

	public NodeScheduledRuleDAOImpl(final NodeScheduledRuleDAO<INodeScheduledRule> impl) {
		this.impl = impl;
	}

	public INodeScheduledRule create(String domainKey, String ruleId, String nodeId) throws StorageException {
		return impl.create(domainKey, ruleId, nodeId);
	}

	public Class<? extends INodeScheduledRule> clazz() {
		return impl.clazz();
	}

	public void createOrUpdate(INodeScheduledRule e) throws StorageException {
		impl.createOrUpdate(e);
	}

	public EntityIterator<INodeScheduledRule> load() throws StorageException {
		return impl.load();
	}

	public EntityIterator<INodeScheduledRule> load(String domainKey) throws StorageException {
		return impl.load(domainKey);
	}

	public long count() throws StorageException {
		return impl.count();
	}

	public long count(String domainKey) throws StorageException {
		return impl.count(domainKey);
	}

	public EntityIterator<String> ruleIdsByNode(String nodeId) throws StorageException {
		return impl.ruleIdsByNode(nodeId);
	}

	public void delete(String domainKey) throws StorageException {
		impl.delete(domainKey);
	}

	public long countByNodeId(String nodeId) throws StorageException {
		return impl.countByNodeId(nodeId);
	}

	public INodeScheduledRule get(String domainKey, String ruleId) throws StorageException {
		return impl.get(domainKey, ruleId);
	}

	public INodeScheduledRule get(String domainKey, String ruleId, String nodeId) throws StorageException {
		return impl.get(domainKey, ruleId, nodeId);
	}

	public void delete(String domainKey, String ruleId) throws StorageException {
		impl.delete(domainKey, ruleId);
	}

	public void delete(String domainKey, String ruleId, String nodeId) throws StorageException {
		impl.delete(domainKey, ruleId, nodeId);
	}

	public void delete() throws StorageException {
		impl.delete();
	}

}
