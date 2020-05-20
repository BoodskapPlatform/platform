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
import io.boodskap.iot.dao.DeviceModelDAO;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.model.IDeviceModel;

public class DeviceModelDAOImpl implements DeviceModelDAO<IDeviceModel> {

	private final DeviceModelDAO<IDeviceModel> impl;

	public DeviceModelDAOImpl(final DeviceModelDAO<IDeviceModel> impl) {
		this.impl = impl;
	}

	public Class<? extends IDeviceModel> clazz() {
		return impl.clazz();
	}

	public void createOrUpdate(IDeviceModel e) throws StorageException {
		impl.createOrUpdate(e);
	}

	public EntityIterator<IDeviceModel> load() throws StorageException {
		return impl.load();
	}

	public EntityIterator<IDeviceModel> load(String domainKey) throws StorageException {
		return impl.load(domainKey);
	}

	public long count() throws StorageException {
		return impl.count();
	}

	public long count(String domainKey) throws StorageException {
		return impl.count(domainKey);
	}

	public IDeviceModel get(String domainKey, String modelId) throws StorageException {
		return impl.get(domainKey, modelId);
	}

	public void delete(String domainKey) throws StorageException {
		impl.delete(domainKey);
	}

	public IDeviceModel get(String domainKey, String modelId, String version) throws StorageException {
		return impl.get(domainKey, modelId, version);
	}

	public void delete(String domainKey, String modelId, String version) throws StorageException {
		impl.delete(domainKey, modelId, version);
	}

	public void delete(String domainKey, String modelId) throws StorageException {
		impl.delete(domainKey, modelId);
	}

	public long count(String domainKey, String modelId) throws StorageException {
		return impl.count(domainKey, modelId);
	}

	public Collection<IDeviceModel> list(String domainKey, int page, int pageSize) throws StorageException {
		return impl.list(domainKey, page, pageSize);
	}

	public Collection<IDeviceModel> listNext(String domainKey, String modelId, int page, int pageSize)
			throws StorageException {
		return impl.listNext(domainKey, modelId, page, pageSize);
	}

	public Collection<IDeviceModel> list(String domainKey, String modelId, int page, int pageSize)
			throws StorageException {
		return impl.list(domainKey, modelId, page, pageSize);
	}

	public Collection<IDeviceModel> listNext(String domainKey, String modelId, String version, int page, int pageSize)
			throws StorageException {
		return impl.listNext(domainKey, modelId, version, page, pageSize);
	}

	public Collection<IDeviceModel> search(String domainKey, String modelId, String query, int pageSize)
			throws StorageException {
		return impl.search(domainKey, modelId, query, pageSize);
	}

	public IDeviceModel create(String domainKey, String modelId, String version) {
		return impl.create(domainKey, modelId, version);
	}

	public void delete() throws StorageException {
		impl.delete();
	}

}
