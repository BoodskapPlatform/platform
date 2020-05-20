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
import java.util.Date;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.dao.OfflineSnapDAO;
import io.boodskap.iot.model.IOfflineSnap;

public class OfflineSnapDAOImpl implements OfflineSnapDAO<IOfflineSnap> {

	private final OfflineSnapDAO<IOfflineSnap> impl;

	public OfflineSnapDAOImpl(final OfflineSnapDAO<IOfflineSnap> impl) {
		this.impl = impl;
	}

	public IOfflineSnap create(String domainKey, String deviceId, String camera, Date stamp) throws StorageException {
		return impl.create(domainKey, deviceId, camera, stamp);
	}

	public Class<? extends IOfflineSnap> clazz() {
		return impl.clazz();
	}

	public void createOrUpdate(IOfflineSnap e) throws StorageException {
		impl.createOrUpdate(e);
	}

	public EntityIterator<IOfflineSnap> load() throws StorageException {
		return impl.load();
	}

	public EntityIterator<IOfflineSnap> load(String domainKey) throws StorageException {
		return impl.load(domainKey);
	}

	public long count() throws StorageException {
		return impl.count();
	}

	public long count(String domainKey) throws StorageException {
		return impl.count(domainKey);
	}

	public IOfflineSnap get(String domainKey, String deviceId, String camera, Date stamp) throws StorageException {
		return impl.get(domainKey, deviceId, camera, stamp);
	}

	public void delete(String domainKey) throws StorageException {
		impl.delete(domainKey);
	}

	public void delete(String domainKey, String deviceId) throws StorageException {
		impl.delete(domainKey, deviceId);
	}

	public void delete(String domainKey, String deviceId, String camera) throws StorageException {
		impl.delete(domainKey, deviceId, camera);
	}

	public void delete(String domainKey, String deviceId, String camera, Date stamp) throws StorageException {
		impl.delete(domainKey, deviceId, camera, stamp);
	}

	public long count(String domainKey, String deviceId) throws StorageException {
		return impl.count(domainKey, deviceId);
	}

	public long count(String domainKey, String deviceId, String camera) throws StorageException {
		return impl.count(domainKey, deviceId, camera);
	}

	public Collection<IOfflineSnap> list(String domainKey, String deviceId, String camera, int page, int pageSize) throws StorageException {
		return impl.list(domainKey, deviceId, camera, page, pageSize);
	}

	public Collection<IOfflineSnap> listNext(String domainKey, String deviceId, String camera, Date stamp, int page, int pageSize) throws StorageException {
		return impl.listNext(domainKey, deviceId, camera, stamp, page, pageSize);
	}

	public void delete() throws StorageException {
		impl.delete();
	}

}
