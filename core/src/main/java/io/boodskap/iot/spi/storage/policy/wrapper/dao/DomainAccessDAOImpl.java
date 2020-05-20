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

import io.boodskap.iot.Access;
import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.DomainAccessDAO;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.model.IDomainAccess;

public class DomainAccessDAOImpl implements DomainAccessDAO<IDomainAccess> {

	private final DomainAccessDAO<IDomainAccess> impl;

	public DomainAccessDAOImpl(final DomainAccessDAO<IDomainAccess> impl) {
		this.impl = impl;
	}

	public Class<? extends IDomainAccess> clazz() {
		return impl.clazz();
	}

	public void createOrUpdate(IDomainAccess e) throws StorageException {
		impl.createOrUpdate(e);
	}

	public EntityIterator<IDomainAccess> load() throws StorageException {
		return impl.load();
	}

	public EntityIterator<IDomainAccess> load(String domainKey) throws StorageException {
		return impl.load(domainKey);
	}

	public long count() throws StorageException {
		return impl.count();
	}

	public long count(String domainKey) throws StorageException {
		return impl.count(domainKey);
	}

	public IDomainAccess create(String domainKey, Access access) throws StorageException {
		return impl.create(domainKey, access);
	}

	public void delete(String domainKey) throws StorageException {
		impl.delete(domainKey);
	}

	public boolean has(String domainKey, Access access) throws StorageException {
		return impl.has(domainKey, access);
	}

	public IDomainAccess get(String domainKey, Access access) throws StorageException {
		return impl.get(domainKey, access);
	}

	public void delete(String domainKey, Access access) throws StorageException {
		impl.delete(domainKey, access);
	}

	public Collection<IDomainAccess> list(String domainKey, int page, int pageSize) throws StorageException {
		return impl.list(domainKey, page, pageSize);
	}

	public Collection<IDomainAccess> listNext(String domainKey, Access access, int page, int pageSize)
			throws StorageException {
		return impl.listNext(domainKey, access, page, pageSize);
	}

	public void delete() throws StorageException {
		impl.delete();
	}

}
