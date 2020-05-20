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
import io.boodskap.iot.dao.DomainApiKeyDAO;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.model.IDomainApiKey;

public class DomainApiKeyDAOImpl implements DomainApiKeyDAO<IDomainApiKey> {

	private final DomainApiKeyDAO<IDomainApiKey> impl;

	public DomainApiKeyDAOImpl(final DomainApiKeyDAO<IDomainApiKey> impl) {
		this.impl = impl;
	}

	public Class<? extends IDomainApiKey> clazz() {
		return impl.clazz();
	}

	public void createOrUpdate(IDomainApiKey e) throws StorageException {
		impl.createOrUpdate(e);
	}

	public EntityIterator<IDomainApiKey> load() throws StorageException {
		return impl.load();
	}

	public EntityIterator<IDomainApiKey> load(String domainKey) throws StorageException {
		return impl.load(domainKey);
	}

	public long count() throws StorageException {
		return impl.count();
	}

	public IDomainApiKey create(String domainKey, String apiKey) throws StorageException {
		return impl.create(domainKey, apiKey);
	}

	public long count(String domainKey) throws StorageException {
		return impl.count(domainKey);
	}

	public void delete(String domainKey) throws StorageException {
		impl.delete(domainKey);
	}

	public IDomainApiKey get(String domainKey, String apiKey) throws StorageException {
		return impl.get(domainKey, apiKey);
	}

	public IDomainApiKey get(String domainKey) throws StorageException {
		return impl.get(domainKey);
	}

	public Collection<IDomainApiKey> list(String domainKey, int page, int pageSize) throws StorageException {
		return impl.list(domainKey, page, pageSize);
	}

	public Collection<IDomainApiKey> listNext(String domainKey, String apiKey, int page, int pageSize)
			throws StorageException {
		return impl.listNext(domainKey, apiKey, page, pageSize);
	}

	public void delete() throws StorageException {
		impl.delete();
	}

}
