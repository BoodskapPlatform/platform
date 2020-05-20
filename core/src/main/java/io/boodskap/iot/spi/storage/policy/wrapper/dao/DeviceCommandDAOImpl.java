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
import io.boodskap.iot.dao.DeviceCommandDAO;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.model.IDeviceCommand;

public class DeviceCommandDAOImpl implements DeviceCommandDAO<IDeviceCommand> {

	private final DeviceCommandDAO<IDeviceCommand> impl;

	public DeviceCommandDAOImpl(final DeviceCommandDAO<IDeviceCommand> impl) {
		this.impl = impl;
	}

	public IDeviceCommand create(String domainKey, String deviceId, long uid) {
		return impl.create(domainKey, deviceId, uid);
	}

	public Class<? extends IDeviceCommand> clazz() {
		return impl.clazz();
	}

	public void createOrUpdate(IDeviceCommand e) throws StorageException {
		impl.createOrUpdate(e);
	}

	public EntityIterator<IDeviceCommand> load() throws StorageException {
		return impl.load();
	}

	public EntityIterator<IDeviceCommand> load(String domainKey) throws StorageException {
		return impl.load(domainKey);
	}

	public long count() throws StorageException {
		return impl.count();
	}

	public long count(String domainKey) throws StorageException {
		return impl.count(domainKey);
	}

	public IDeviceCommand get(String domainKey, String deviceId, long id) throws StorageException {
		return impl.get(domainKey, deviceId, id);
	}

	public void delete(String domainKey) throws StorageException {
		impl.delete(domainKey);
	}

	public long count(String domainKey, String deviceId) throws StorageException {
		return impl.count(domainKey, deviceId);
	}

	public Collection<IDeviceCommand> list(String domainKey, String deviceId, int page, int pageSize) throws StorageException {
		return impl.list(domainKey, deviceId, page, pageSize);
	}

	public Collection<IDeviceCommand> listNext(String domainKey, String deviceId, long id, int page, int pageSize) throws StorageException {
		return impl.listNext(domainKey, deviceId, id, page, pageSize);
	}

	public void delete() throws StorageException {
		impl.delete();
	}

}
