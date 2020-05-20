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
import io.boodskap.iot.dao.UserDeviceGroupDAO;
import io.boodskap.iot.model.IUserDeviceGroup;

public class UserDeviceGroupDAOImpl implements UserDeviceGroupDAO <IUserDeviceGroup> {

	private final UserDeviceGroupDAO<IUserDeviceGroup> impl;

	public UserDeviceGroupDAOImpl(final UserDeviceGroupDAO<IUserDeviceGroup> impl) {
		this.impl = impl;
	}

	public IUserDeviceGroup create(String domainKey, String ownerUserId, String groupId) throws StorageException {
		return impl.create(domainKey, ownerUserId, groupId);
	}

	public Class<? extends IUserDeviceGroup> clazz() {
		return impl.clazz();
	}

	public void createOrUpdate(IUserDeviceGroup e) throws StorageException {
		impl.createOrUpdate(e);
	}

	public EntityIterator<IUserDeviceGroup> load() throws StorageException {
		return impl.load();
	}

	public EntityIterator<IUserDeviceGroup> load(String domainKey) throws StorageException {
		return impl.load(domainKey);
	}

	public long count() throws StorageException {
		return impl.count();
	}

	public long count(String domainKey) throws StorageException {
		return impl.count(domainKey);
	}

	public IUserDeviceGroup get(String domainKey, String userId, String groupId) throws StorageException {
		return impl.get(domainKey, userId, groupId);
	}

	public void delete(String domainKey) throws StorageException {
		impl.delete(domainKey);
	}

	public void delete(String domainKey, String userId, String groupId) throws StorageException {
		impl.delete(domainKey, userId, groupId);
	}

	public void delete(String domainKey, String userId) throws StorageException {
		impl.delete(domainKey, userId);
	}

	public long count(String domainKey, String userId) throws StorageException {
		return impl.count(domainKey, userId);
	}

	public Collection<IUserDeviceGroup> list(String domainKey, String userId, int page, int pageSize) throws StorageException {
		return impl.list(domainKey, userId, page, pageSize);
	}

	public Collection<IUserDeviceGroup> listNext(String domainKey, String userId, String groupId, int page, int pageSize) throws StorageException {
		return impl.listNext(domainKey, userId, groupId, page, pageSize);
	}

	public Collection<IUserDeviceGroup> search(String domainKey, String userId, String query, int pageSize) throws StorageException {
		return impl.search(domainKey, userId, query, pageSize);
	}

	public void delete() throws StorageException {
		impl.delete();
	}

}
