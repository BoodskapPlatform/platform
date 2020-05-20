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

import java.util.Collection;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.dao.ScheduledRuleDAO;
import io.boodskap.iot.model.IScheduledRule;

public class ScheduledRuleDAOImpl implements ScheduledRuleDAO<IScheduledRule> {

	private final ScheduledRuleDAO<IScheduledRule> impl;

	public ScheduledRuleDAOImpl(final ScheduledRuleDAO<IScheduledRule> impl) {
		this.impl = impl;
	}

	public IScheduledRule create(String domainKey, String ruleId) throws StorageException {
		return impl.create(domainKey, ruleId);
	}

	public Class<? extends IScheduledRule> clazz() {
		return impl.clazz();
	}

	public void createOrUpdate(IScheduledRule e) throws StorageException {
		impl.createOrUpdate(e);
	}

	public EntityIterator<IScheduledRule> load() throws StorageException {
		return impl.load();
	}

	public EntityIterator<IScheduledRule> load(String domainKey) throws StorageException {
		return impl.load(domainKey);
	}

	public long count() throws StorageException {
		return impl.count();
	}

	public long count(String domainKey) throws StorageException {
		return impl.count(domainKey);
	}

	public IScheduledRule get(String domainKey, String id) throws StorageException {
		return impl.get(domainKey, id);
	}

	public void delete(String domainKey) throws StorageException {
		impl.delete(domainKey);
	}

	public void delete(String domainKey, String id) throws StorageException {
		impl.delete(domainKey, id);
	}

	public Collection<String> listIds(String domainKey, int page, int pageSize) throws StorageException {
		return impl.listIds(domainKey, page, pageSize);
	}

	public Collection<String> listIdsNext(String domainKey, String id, int page, int pageSize) throws StorageException {
		return impl.listIdsNext(domainKey, id, page, pageSize);
	}

	public Collection<IScheduledRule> list(boolean load, String domainKey, int page, int pageSize)
			throws StorageException {
		return impl.list(load, domainKey, page, pageSize);
	}

	public Collection<IScheduledRule> listNext(boolean load, String domainKey, String ruleId, int page, int pageSize)
			throws StorageException {
		return impl.listNext(load, domainKey, ruleId, page, pageSize);
	}

	public Collection<IScheduledRule> search(boolean load, String domainKey, String query, int pageSize)
			throws StorageException {
		return impl.search(load, domainKey, query, pageSize);
	}

	public void delete() throws StorageException {
		impl.delete();
	}

}
