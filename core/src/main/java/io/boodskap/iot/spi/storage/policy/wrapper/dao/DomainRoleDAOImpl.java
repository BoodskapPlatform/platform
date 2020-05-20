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
import io.boodskap.iot.dao.DomainRoleDAO;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.model.IDomainRole;

public class DomainRoleDAOImpl implements DomainRoleDAO<IDomainRole>{
	
	private final DomainRoleDAO<IDomainRole> impl;

	public DomainRoleDAOImpl(final DomainRoleDAO<IDomainRole> impl) {
		this.impl = impl;
	}

	public IDomainRole create(String domainKey, String name) throws StorageException {
		return impl.create(domainKey, name);
	}

	public Class<? extends IDomainRole> clazz() {
		return impl.clazz();
	}

	public void createOrUpdate(IDomainRole e) throws StorageException {
		impl.createOrUpdate(e);
	}

	public EntityIterator<IDomainRole> load() throws StorageException {
		return impl.load();
	}

	public EntityIterator<IDomainRole> load(String domainKey) throws StorageException {
		return impl.load(domainKey);
	}

	public long count() throws StorageException {
		return impl.count();
	}

	public long count(String domainKey) throws StorageException {
		return impl.count(domainKey);
	}

	public IDomainRole get(String domainKey, String name) throws StorageException {
		return impl.get(domainKey, name);
	}

	public void delete(String domainKey) throws StorageException {
		impl.delete(domainKey);
	}

	public void delete(String domainKey, String name) throws StorageException {
		impl.delete(domainKey, name);
	}

	public Collection<IDomainRole> list(String domainKey) throws StorageException {
		return impl.list(domainKey);
	}

	public Collection<IDomainRole> search(String domainKey, String query, int pageSize) throws StorageException {
		return impl.search(domainKey, query, pageSize);
	}

	public void delete() throws StorageException {
		impl.delete();
	}

}
