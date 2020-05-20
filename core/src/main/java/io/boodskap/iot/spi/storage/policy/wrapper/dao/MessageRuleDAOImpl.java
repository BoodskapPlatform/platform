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
import io.boodskap.iot.dao.MessageRuleDAO;
import io.boodskap.iot.model.IMessageRule;

public class MessageRuleDAOImpl implements MessageRuleDAO<IMessageRule> {

	private final MessageRuleDAO<IMessageRule> impl;

	public MessageRuleDAOImpl(final MessageRuleDAO<IMessageRule> impl) {
		this.impl = impl;
	}

	public IMessageRule create(String domainKey, String specId) throws StorageException {
		return impl.create(domainKey, specId);
	}

	public Class<? extends IMessageRule> clazz() {
		return impl.clazz();
	}

	public void createOrUpdate(IMessageRule e) throws StorageException {
		impl.createOrUpdate(e);
	}

	public EntityIterator<IMessageRule> load() throws StorageException {
		return impl.load();
	}

	public EntityIterator<IMessageRule> load(String domainKey) throws StorageException {
		return impl.load(domainKey);
	}

	public long count() throws StorageException {
		return impl.count();
	}

	public long count(String domainKey) throws StorageException {
		return impl.count(domainKey);
	}

	public IMessageRule get(String domainKey, String specId) throws StorageException {
		return impl.get(domainKey, specId);
	}

	public void delete(String domainKey) throws StorageException {
		impl.delete(domainKey);
	}

	public boolean has(String domainKey, String specId) throws StorageException {
		return impl.has(domainKey, specId);
	}

	public void delete(String domainKey, String specId) throws StorageException {
		impl.delete(domainKey, specId);
	}

	public Collection<String> listSpecs(String domainKey, int page, int pageSize) throws StorageException {
		return impl.listSpecs(domainKey, page, pageSize);
	}

	public Collection<String> listSpecsNext(String domainKey, String specId, int page, int pageSize)
			throws StorageException {
		return impl.listSpecsNext(domainKey, specId, page, pageSize);
	}

	public Collection<IMessageRule> list(boolean load, String domainKey, int page, int pageSize)
			throws StorageException {
		return impl.list(load, domainKey, page, pageSize);
	}

	public Collection<IMessageRule> listNext(boolean load, String domainKey, String specId, int page, int pageSize)
			throws StorageException {
		return impl.listNext(load, domainKey, specId, page, pageSize);
	}

	public Collection<IMessageRule> search(boolean load, String domainKey, String query, int pageSize)
			throws StorageException {
		return impl.search(load, domainKey, query, pageSize);
	}

	public void delete() throws StorageException {
		impl.delete();
	}

}
