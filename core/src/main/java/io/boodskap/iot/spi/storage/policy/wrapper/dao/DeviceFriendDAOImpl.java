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
import io.boodskap.iot.dao.DeviceFriendDAO;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.model.IDeviceFriend;

public class DeviceFriendDAOImpl implements DeviceFriendDAO<IDeviceFriend> {

	private final DeviceFriendDAO<IDeviceFriend> impl;

	public DeviceFriendDAOImpl(final DeviceFriendDAO<IDeviceFriend> impl) {
		this.impl = impl;
	}

	public Class<? extends IDeviceFriend> clazz() {
		return impl.clazz();
	}

	public void createOrUpdate(IDeviceFriend e) throws StorageException {
		impl.createOrUpdate(e);
	}

	public EntityIterator<IDeviceFriend> load() throws StorageException {
		return impl.load();
	}

	public EntityIterator<IDeviceFriend> load(String domainKey) throws StorageException {
		return impl.load(domainKey);
	}

	public long count() throws StorageException {
		return impl.count();
	}

	public long count(String domainKey) throws StorageException {
		return impl.count(domainKey);
	}

	public IDeviceFriend get(String domainKey, String deviceId, String friendId) throws StorageException {
		return impl.get(domainKey, deviceId, friendId);
	}

	public void delete(String domainKey) throws StorageException {
		impl.delete(domainKey);
	}

	public void delete(String domainKey, String deviceId, String friendId) throws StorageException {
		impl.delete(domainKey, deviceId, friendId);
	}

	public void delete(String domainKey, String deviceId) throws StorageException {
		impl.delete(domainKey, deviceId);
	}

	public long count(String domainKey, String deviceId) throws StorageException {
		return impl.count(domainKey, deviceId);
	}

	public EntityIterator<IDeviceFriend> load(String domainKey, String deviceId) throws StorageException {
		return impl.load(domainKey, deviceId);
	}

	public Collection<IDeviceFriend> list(String domainKey, String deviceId, int page, int pageSize) throws StorageException {
		return impl.list(domainKey, deviceId, page, pageSize);
	}

	public Collection<IDeviceFriend> listNext(String domainKey, String deviceId, String friendId, int page, int pageSize) throws StorageException {
		return impl.listNext(domainKey, deviceId, friendId, page, pageSize);
	}

	public Collection<IDeviceFriend> search(String domainKey, String deviceId, String query, int pageSize) throws StorageException {
		return impl.search(domainKey, deviceId, query, pageSize);
	}

	public IDeviceFriend create(String domainKey, String deviceId, String friendId) {
		return impl.create(domainKey, deviceId, friendId);
	}

	public void delete() throws StorageException {
		impl.delete();
	}

}
