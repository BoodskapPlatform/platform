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
import io.boodskap.iot.dao.AssetDeviceDAO;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.model.IAssetDevice;

public class AssetDeviceDAOImpl implements AssetDeviceDAO<IAssetDevice> {
	
	private final AssetDeviceDAO<IAssetDevice> impl;

	public AssetDeviceDAOImpl(final AssetDeviceDAO<IAssetDevice> impl) {
		this.impl = impl;
	}

	public IAssetDevice create(String domainKey, String assetId, String deviceId) {
		return impl.create(domainKey, assetId, deviceId);
	}

	public Class<? extends IAssetDevice> clazz() {
		return impl.clazz();
	}

	public void createOrUpdate(IAssetDevice e) throws StorageException {
		impl.createOrUpdate(e);
	}

	public EntityIterator<IAssetDevice> load() throws StorageException {
		return impl.load();
	}

	public EntityIterator<IAssetDevice> load(String domainKey) throws StorageException {
		return impl.load(domainKey);
	}

	public long count() throws StorageException {
		return impl.count();
	}

	public long count(String domainKey) throws StorageException {
		return impl.count(domainKey);
	}

	public IAssetDevice get(String domainKey, String assetId, String deviceId) throws StorageException {
		return impl.get(domainKey, assetId, deviceId);
	}

	public void delete(String domainKey, String assetId, String deviceId) throws StorageException {
		impl.delete(domainKey, assetId, deviceId);
	}

	public void delete(String domainKey, String assetId) throws StorageException {
		impl.delete(domainKey, assetId);
	}

	public void delete(String domainKey) throws StorageException {
		impl.delete(domainKey);
	}

	public long count(String domainKey, String assetId) throws StorageException {
		return impl.count(domainKey, assetId);
	}

	public Collection<IAssetDevice> list(String domainKey, String assetId, int page, int pageSize) throws StorageException {
		return impl.list(domainKey, assetId, page, pageSize);
	}

	public Collection<IAssetDevice> listNext(String domainKey, String assetId, String deviceId, int page, int pageSize) throws StorageException {
		return impl.listNext(domainKey, assetId, deviceId, page, pageSize);
	}

	public Collection<IAssetDevice> search(String domainKey, String assetId, String query, int pageSize) throws StorageException {
		return impl.search(domainKey, assetId, query, pageSize);
	}

	public void delete() throws StorageException {
		impl.delete();
	}

}
