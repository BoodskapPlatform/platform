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
import io.boodskap.iot.dao.DeviceDAO;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.model.IDevice;

public class DeviceDAOImpl implements DeviceDAO<IDevice> {

	private final DeviceDAO<IDevice> impl;

	public DeviceDAOImpl(final DeviceDAO<IDevice> impl) {
		this.impl = impl;
	}

	public IDevice create(String domainKey, String deviceId) {
		return impl.create(domainKey, deviceId);
	}

	public Class<? extends IDevice> clazz() {
		return impl.clazz();
	}

	public void createOrUpdate(IDevice e) throws StorageException {
		impl.createOrUpdate(e);
	}

	public EntityIterator<IDevice> load() throws StorageException {
		return impl.load();
	}

	public EntityIterator<IDevice> load(String domainKey) throws StorageException {
		return impl.load(domainKey);
	}

	public long count() throws StorageException {
		return impl.count();
	}

	public IDevice get(String domainKey, String deviceId) throws StorageException {
		return impl.get(domainKey, deviceId);
	}

	public long count(String domainKey) throws StorageException {
		return impl.count(domainKey);
	}

	public void delete(String domainKey, String deviceId) throws StorageException {
		impl.delete(domainKey, deviceId);
	}

	public void delete(String domainKey) throws StorageException {
		impl.delete(domainKey);
	}

	public String getLinkedAssetId(String domainKey, String deviceId) throws StorageException {
		return impl.getLinkedAssetId(domainKey, deviceId);
	}

	public Collection<IDevice> list(String domainKey, int page, int pageSize) throws StorageException {
		return impl.list(domainKey, page, pageSize);
	}

	public Collection<IDevice> listNext(String domainKey, String deviceId, int page, int pageSize) throws StorageException {
		return impl.listNext(domainKey, deviceId, page, pageSize);
	}

	public Collection<IDevice> search(String domainKey, String query, int pageSize) throws StorageException {
		return impl.search(domainKey, query, pageSize);
	}

	public void delete() throws StorageException {
		impl.delete();
	}

}
