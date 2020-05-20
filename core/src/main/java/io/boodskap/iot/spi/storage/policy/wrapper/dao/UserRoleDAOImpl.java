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
import io.boodskap.iot.dao.UserRoleDAO;
import io.boodskap.iot.model.IUserRole;

public class UserRoleDAOImpl implements UserRoleDAO<IUserRole> {
	
	private final UserRoleDAO<IUserRole> impl;

	public UserRoleDAOImpl(UserRoleDAO<IUserRole> impl) {
		this.impl = impl;
	}

	public IUserRole create(String domainKey, String userId, String name) throws StorageException {
		return impl.create(domainKey, userId, name);
	}

	public Class<? extends IUserRole> clazz() {
		return impl.clazz();
	}

	public void createOrUpdate(IUserRole e) throws StorageException {
		impl.createOrUpdate(e);
	}

	public EntityIterator<IUserRole> load() throws StorageException {
		return impl.load();
	}

	public EntityIterator<IUserRole> load(String domainKey) throws StorageException {
		return impl.load(domainKey);
	}

	public long count() throws StorageException {
		return impl.count();
	}

	public long count(String domainKey) throws StorageException {
		return impl.count(domainKey);
	}

	public IUserRole get(String domainKey, String userId, String name) throws StorageException {
		return impl.get(domainKey, userId, name);
	}

	public void delete(String domainKey) throws StorageException {
		impl.delete(domainKey);
	}

	public long count(String domainKey, String userId) throws StorageException {
		return impl.count(domainKey, userId);
	}

	public void delete(String domainKey, String userId) throws StorageException {
		impl.delete(domainKey, userId);
	}

	public void delete(String domainKey, String userId, String name) throws StorageException {
		impl.delete(domainKey, userId, name);
	}

	public Collection<IUserRole> list(String domainKey, String userId) throws StorageException {
		return impl.list(domainKey, userId);
	}

	public Collection<IUserRole> search(String domainKey, String userId, String query, int pageSize) throws StorageException {
		return impl.search(domainKey, userId, query, pageSize);
	}

	public void delete() throws StorageException {
		impl.delete();
	}

}
