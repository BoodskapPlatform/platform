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
import io.boodskap.iot.dao.UserDomainDAO;
import io.boodskap.iot.model.IUserDomain;

public class UserDomainDAOImpl implements UserDomainDAO<IUserDomain>{
	
	private final UserDomainDAO<IUserDomain> impl;

	public UserDomainDAOImpl(UserDomainDAO<IUserDomain> impl) {
		this.impl = impl;
	}

	public IUserDomain create(String userId, String domainKey) throws StorageException {
		return impl.create(userId, domainKey);
	}

	public Class<? extends IUserDomain> clazz() {
		return impl.clazz();
	}

	public void createOrUpdate(IUserDomain e) throws StorageException {
		impl.createOrUpdate(e);
	}

	public EntityIterator<IUserDomain> load() throws StorageException {
		return impl.load();
	}

	public EntityIterator<IUserDomain> load(String domainKey) throws StorageException {
		return impl.load(domainKey);
	}

	public long count() throws StorageException {
		return impl.count();
	}

	public long count(String domainKey) throws StorageException {
		return impl.count(domainKey);
	}

	public IUserDomain get(String userId, String domainKey) throws StorageException {
		return impl.get(userId, domainKey);
	}

	public void delete(String domainKey) throws StorageException {
		impl.delete(domainKey);
	}

	public long countDomains(String userId) throws StorageException {
		return impl.countDomains(userId);
	}

	public void deleteDomains(String userId) throws StorageException {
		impl.deleteDomains(userId);
	}

	public void delete(String userId, String domainKey) throws StorageException {
		impl.delete(userId, domainKey);
	}

	public Collection<IUserDomain> list(String userId) throws StorageException {
		return impl.list(userId);
	}

	public void delete() throws StorageException {
		impl.delete();
	}

}
