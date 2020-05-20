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
import io.boodskap.iot.dao.CameraDeviceDAO;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.model.ICameraDevice;

public class CameraDeviceDAOImpl implements CameraDeviceDAO<ICameraDevice> {

	private final CameraDeviceDAO<ICameraDevice> impl;

	public CameraDeviceDAOImpl(final CameraDeviceDAO<ICameraDevice> impl) {
		this.impl = impl;
	}

	public ICameraDevice create(String domainKey, String deviceId, String camera) {
		return impl.create(domainKey, deviceId, camera);
	}

	public Class<? extends ICameraDevice> clazz() {
		return impl.clazz();
	}

	public void createOrUpdate(ICameraDevice e) throws StorageException {
		impl.createOrUpdate(e);
	}

	public EntityIterator<ICameraDevice> load() throws StorageException {
		return impl.load();
	}

	public EntityIterator<ICameraDevice> load(String domainKey) throws StorageException {
		return impl.load(domainKey);
	}

	public long count() throws StorageException {
		return impl.count();
	}

	public long count(String domainKey) throws StorageException {
		return impl.count(domainKey);
	}

	public ICameraDevice get(String domainKey, String deviceId, String camera) throws StorageException {
		return impl.get(domainKey, deviceId, camera);
	}

	public void delete(String domainKey) throws StorageException {
		impl.delete(domainKey);
	}

	public void delete(String domainKey, String deviceId, String camera) throws StorageException {
		impl.delete(domainKey, deviceId, camera);
	}

	public Collection<String> listCameras(String domainKey, String deviceId) {
		return impl.listCameras(domainKey, deviceId);
	}

	public Collection<ICameraDevice> list(String domainKey, int page, int pageSize) throws StorageException {
		return impl.list(domainKey, page, pageSize);
	}

	public Collection<ICameraDevice> listNext(String domainKey, String deviceId, int page, int pageSize) throws StorageException {
		return impl.listNext(domainKey, deviceId, page, pageSize);
	}

	public Collection<ICameraDevice> search(String domainKey, String query, int pageSize) throws StorageException {
		return impl.search(domainKey, query, pageSize);
	}

	public void delete() throws StorageException {
		impl.delete();
	}

}
