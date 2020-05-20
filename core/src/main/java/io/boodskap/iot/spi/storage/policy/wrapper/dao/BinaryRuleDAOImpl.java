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
import io.boodskap.iot.dao.BinaryRuleDAO;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.model.IBinaryRule;

public class BinaryRuleDAOImpl implements BinaryRuleDAO<IBinaryRule> {

	private final BinaryRuleDAO<IBinaryRule> impl;

	public BinaryRuleDAOImpl(final BinaryRuleDAO<IBinaryRule> impl) {
		this.impl = impl;
	}

	public IBinaryRule create(String domainKey, String type) {
		return impl.create(domainKey, type);
	}

	public Class<? extends IBinaryRule> clazz() {
		return impl.clazz();
	}

	public void createOrUpdate(IBinaryRule e) throws StorageException {
		impl.createOrUpdate(e);
	}

	public EntityIterator<IBinaryRule> load() throws StorageException {
		return impl.load();
	}

	public EntityIterator<IBinaryRule> load(String domainKey) throws StorageException {
		return impl.load(domainKey);
	}

	public long count() throws StorageException {
		return impl.count();
	}

	public long count(String domainKey) throws StorageException {
		return impl.count(domainKey);
	}

	public IBinaryRule get(String domainKey, String type) throws StorageException {
		return impl.get(domainKey, type);
	}

	public void delete(String domainKey) throws StorageException {
		impl.delete(domainKey);
	}

	public void delete(String domainKey, String type) throws StorageException {
		impl.delete(domainKey, type);
	}

	public Collection<IBinaryRule> list(boolean load, String domainKey, int page, int pageSize)
			throws StorageException {
		return impl.list(load, domainKey, page, pageSize);
	}

	public Collection<IBinaryRule> listNext(boolean load, String domainKey, String type, int page, int pageSize)
			throws StorageException {
		return impl.listNext(load, domainKey, type, page, pageSize);
	}

	public Collection<String> listTypes(String domainKey, int page, int pageSize) throws StorageException {
		return impl.listTypes(domainKey, page, pageSize);
	}

	public Collection<String> listTypesNext(String domainKey, String type, int page, int pageSize)
			throws StorageException {
		return impl.listTypesNext(domainKey, type, page, pageSize);
	}

	public Collection<IBinaryRule> search(boolean load, String domainKey, String query, int pageSize)
			throws StorageException {
		return impl.search(load, domainKey, query, pageSize);
	}

	public void delete() throws StorageException {
		impl.delete();
	}

}
