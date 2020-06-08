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
import io.boodskap.iot.dao.UserDAO;
import io.boodskap.iot.model.IUser;

public class UserDAOImpl implements UserDAO<IUser> {

	private final UserDAO<IUser> impl;

	public UserDAOImpl(final UserDAO<IUser> impl) {
		this.impl = impl;
	}

	public IUser create(String domainKey, String userId) throws StorageException {
		return impl.create(domainKey, userId);
	}

	public Class<? extends IUser> clazz() {
		return impl.clazz();
	}

	public void createOrUpdate(IUser e) throws StorageException {
		impl.createOrUpdate(e);
	}

	public EntityIterator<IUser> load() throws StorageException {
		return impl.load();
	}

	public EntityIterator<IUser> load(String domainKey) throws StorageException {
		return impl.load(domainKey);
	}

	public long count() throws StorageException {
		return impl.count();
	}

	public IUser get(String userId) throws StorageException {
		return impl.get(userId);
	}

	public long count(String domainKey) throws StorageException {
		return impl.count(domainKey);
	}

	public IUser get(String domainKey, String userId) throws StorageException {
		return impl.get(domainKey, userId);
	}

	public void delete(String domainKey) throws StorageException {
		impl.delete(domainKey);
	}

	public void delete(String domainKey, String userId) throws StorageException {
		impl.delete(domainKey, userId);
	}

	public Collection<IUser> list(String domainKey, int page, int pageSize) throws StorageException {
		return impl.list(domainKey, page, pageSize);
	}

	public Collection<IUser> listNext(String domainKey, String userId, int page, int pageSize) throws StorageException {
		return impl.listNext(domainKey, userId, page, pageSize);
	}

	public Collection<IUser> search(String domainKey, String query, int pageSize) throws StorageException {
		return impl.search(domainKey, query, pageSize);
	}

	public void delete() throws StorageException {
		impl.delete();
	}

	@Override
	public long countUsers(String userId) throws StorageException {
		return impl.countUsers(userId);
	}

}
