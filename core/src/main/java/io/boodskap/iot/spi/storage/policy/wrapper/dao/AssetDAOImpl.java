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
import io.boodskap.iot.dao.AssetDAO;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.model.IAsset;

public class AssetDAOImpl implements AssetDAO<IAsset> {
	
	private final AssetDAO<IAsset> impl;

	public AssetDAOImpl(final AssetDAO<IAsset> impl) {
		this.impl = impl;
	}

	public IAsset create(String domainKey, String assetId) {
		return impl.create(domainKey, assetId);
	}

	public Class<? extends IAsset> clazz() {
		return impl.clazz();
	}

	public void createOrUpdate(IAsset e) throws StorageException {
		impl.createOrUpdate(e);
	}

	public EntityIterator<IAsset> load() throws StorageException {
		return impl.load();
	}

	public EntityIterator<IAsset> load(String domainKey) throws StorageException {
		return impl.load(domainKey);
	}

	public IAsset get(String domainKey, String id) throws StorageException {
		return impl.get(domainKey, id);
	}

	public long count() throws StorageException {
		return impl.count();
	}

	public long count(String domainKey) throws StorageException {
		return impl.count(domainKey);
	}

	public void delete(String domainKey, String assetId) throws StorageException {
		impl.delete(domainKey, assetId);
	}

	public void delete(String domainKey) throws StorageException {
		impl.delete(domainKey);
	}

	public Collection<IAsset> list(String domainKey, int page, int pageSize) throws StorageException {
		return impl.list(domainKey, page, pageSize);
	}

	public Collection<IAsset> listNext(String domainKey, String assetId, int page, int pageSize)throws StorageException {
		return impl.listNext(domainKey, assetId, page, pageSize);
	}

	public Collection<IAsset> search(String domainKey, String query, int pageSize) throws StorageException {
		return impl.search(domainKey, query, pageSize);
	}

	public void delete() throws StorageException {
		impl.delete();
	}

}
