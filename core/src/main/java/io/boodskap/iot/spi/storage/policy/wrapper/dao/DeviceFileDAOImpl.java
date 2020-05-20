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
import io.boodskap.iot.dao.DeviceFileDAO;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.model.IDeviceFile;
import io.boodskap.iot.model.IFileContent;

public class DeviceFileDAOImpl implements DeviceFileDAO<IDeviceFile> {

	private final DeviceFileDAO<IDeviceFile> impl;

	public DeviceFileDAOImpl(final DeviceFileDAO<IDeviceFile> impl) {
		this.impl = impl;
	}

	public IDeviceFile create(String domainKey, String deviceId, String fileId) {
		return impl.create(domainKey, deviceId, fileId);
	}

	public Class<? extends IDeviceFile> clazz() {
		return impl.clazz();
	}

	public void createOrUpdate(IDeviceFile e) throws StorageException {
		impl.createOrUpdate(e);
	}

	public EntityIterator<IDeviceFile> load() throws StorageException {
		return impl.load();
	}

	public EntityIterator<IDeviceFile> load(String domainKey) throws StorageException {
		return impl.load(domainKey);
	}

	public long count() throws StorageException {
		return impl.count();
	}

	public IDeviceFile get(String domainKey, String deviceId, String fileId) throws StorageException {
		return impl.get(domainKey, deviceId, fileId);
	}

	public long count(String domainKey) throws StorageException {
		return impl.count(domainKey);
	}

	public void delete(String domainKey) throws StorageException {
		impl.delete(domainKey);
	}

	public IFileContent getContent(String domainKey, String deviceId, String fileId) throws StorageException {
		return impl.getContent(domainKey, deviceId, fileId);
	}

	public boolean has(String domainKey, String deviceId, String fileId) throws StorageException {
		return impl.has(domainKey, deviceId, fileId);
	}

	public void delete(String domainKey, String deviceId, String fileId) throws StorageException {
		impl.delete(domainKey, deviceId, fileId);
	}

	public void update(String domainKey, String deviceId, String fileId, String tags, String description)
			throws StorageException {
		impl.update(domainKey, deviceId, fileId, tags, description);
	}

	public void update(String domainKey, String deviceId, String fileId, byte[] data, String mediaType)
			throws StorageException {
		impl.update(domainKey, deviceId, fileId, data, mediaType);
	}

	public Collection<IDeviceFile> list(boolean load, String domainKey, String deviceId, int page, int pageSize) throws StorageException {
		return impl.list(load, domainKey, deviceId, page, pageSize);
	}

	public Collection<IDeviceFile> listNext(boolean load, String domainKey, String deviceId, String fileId, int page, int pageSize) throws StorageException {
		return impl.listNext(load, domainKey, deviceId, fileId, page, pageSize);
	}

	public Collection<IDeviceFile> search(boolean load, String domainKey, String deviceId, String query, int pageSize) throws StorageException {
		return impl.search(load, domainKey, deviceId, query, pageSize);
	}

	public void delete() throws StorageException {
		impl.delete();
	}

}
