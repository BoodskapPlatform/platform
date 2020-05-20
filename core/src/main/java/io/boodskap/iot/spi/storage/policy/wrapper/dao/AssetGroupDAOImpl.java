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
import io.boodskap.iot.dao.AssetGroupDAO;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.model.IAssetGroup;

public class AssetGroupDAOImpl implements AssetGroupDAO<IAssetGroup> {

	private final AssetGroupDAO<IAssetGroup> impl;

	public AssetGroupDAOImpl(final AssetGroupDAO<IAssetGroup> impl) {
		this.impl = impl;
	}

	public IAssetGroup create(String domainKey, String ownerAssetId, String groupId) {
		return impl.create(domainKey, ownerAssetId, groupId);
	}

	public Class<? extends IAssetGroup> clazz() {
		return impl.clazz();
	}

	public void createOrUpdate(IAssetGroup e) throws StorageException {
		impl.createOrUpdate(e);
	}

	public EntityIterator<IAssetGroup> load() throws StorageException {
		return impl.load();
	}

	public EntityIterator<IAssetGroup> load(String domainKey) throws StorageException {
		return impl.load(domainKey);
	}

	public long count() throws StorageException {
		return impl.count();
	}

	public long count(String domainKey) throws StorageException {
		return impl.count(domainKey);
	}

	public IAssetGroup get(String domainKey, String ownerAssetId, String groupId) throws StorageException {
		return impl.get(domainKey, ownerAssetId, groupId);
	}

	public void delete(String domainKey) throws StorageException {
		impl.delete(domainKey);
	}

	public void delete(String domainKey, String ownerAssetId, String groupId) throws StorageException {
		impl.delete(domainKey, ownerAssetId, groupId);
	}

	public void delete(String domainKey, String ownerAssetId) throws StorageException {
		impl.delete(domainKey, ownerAssetId);
	}

	public long count(String domainKey, String ownerAssetId) throws StorageException {
		return impl.count(domainKey, ownerAssetId);
	}

	public Collection<IAssetGroup> list(String domainKey, String ownerAssetId, int page, int pageSize) throws StorageException {
		return impl.list(domainKey, ownerAssetId, page, pageSize);
	}

	public Collection<IAssetGroup> listNext(String domainKey, String ownerAssetId, String groupId, int page, int pageSize) throws StorageException {
		return impl.listNext(domainKey, ownerAssetId, groupId, page, pageSize);
	}

	public Collection<IAssetGroup> search(String domainKey, String query, int pageSize) throws StorageException {
		return impl.search(domainKey, query, pageSize);
	}

	public void delete() throws StorageException {
		impl.delete();
	}

}
