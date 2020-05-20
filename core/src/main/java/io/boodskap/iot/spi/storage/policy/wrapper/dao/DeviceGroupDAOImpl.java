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
import io.boodskap.iot.dao.DeviceGroupDAO;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.model.IDeviceGroup;

public class DeviceGroupDAOImpl implements DeviceGroupDAO<IDeviceGroup> {

	private final DeviceGroupDAO<IDeviceGroup> impl;

	public DeviceGroupDAOImpl(final DeviceGroupDAO<IDeviceGroup> impl) {
		this.impl = impl;
	}

	public IDeviceGroup create(String domainKey, String ownerDeviceId, String groupId) {
		return impl.create(domainKey, ownerDeviceId, groupId);
	}

	public Class<? extends IDeviceGroup> clazz() {
		return impl.clazz();
	}

	public void createOrUpdate(IDeviceGroup e) throws StorageException {
		impl.createOrUpdate(e);
	}

	public EntityIterator<IDeviceGroup> load() throws StorageException {
		return impl.load();
	}

	public EntityIterator<IDeviceGroup> load(String domainKey) throws StorageException {
		return impl.load(domainKey);
	}

	public long count() throws StorageException {
		return impl.count();
	}

	public long count(String domainKey) throws StorageException {
		return impl.count(domainKey);
	}

	public IDeviceGroup get(String domainKey, String ownerDeviceId, String groupId) throws StorageException {
		return impl.get(domainKey, ownerDeviceId, groupId);
	}

	public void delete(String domainKey) throws StorageException {
		impl.delete(domainKey);
	}

	public void delete(String domainKey, String ownerDeviceId, String groupId) throws StorageException {
		impl.delete(domainKey, ownerDeviceId, groupId);
	}

	public void delete(String domainKey, String ownerDeviceId) throws StorageException {
		impl.delete(domainKey, ownerDeviceId);
	}

	public long count(String domainKey, String ownerDeviceId) throws StorageException {
		return impl.count(domainKey, ownerDeviceId);
	}

	public Collection<IDeviceGroup> list(String domainKey, String ownerDeviceId, int page, int pageSize) throws StorageException {
		return impl.list(domainKey, ownerDeviceId, page, pageSize);
	}

	public Collection<IDeviceGroup> listNext(String domainKey, String ownerDeviceId, String groupId, int page, int pageSize) throws StorageException {
		return impl.listNext(domainKey, ownerDeviceId, groupId, page, pageSize);
	}

	public Collection<IDeviceGroup> search(String domainKey, String query, int pageSize) throws StorageException {
		return impl.search(domainKey, query, pageSize);
	}

	public void delete() throws StorageException {
		impl.delete();
	}

}
