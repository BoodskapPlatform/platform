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
import io.boodskap.iot.dao.AssetFileDAO;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.model.IAssetFile;
import io.boodskap.iot.model.IFileContent;

public class AssetFileDAOImpl implements AssetFileDAO<IAssetFile> {

	private final AssetFileDAO<IAssetFile> impl;

	public AssetFileDAOImpl(final AssetFileDAO<IAssetFile> impl) {
		this.impl = impl;
	}

	public IAssetFile create(String domainKey, String assetId, String fileId) {
		return impl.create(domainKey, assetId, fileId);
	}

	public Class<? extends IAssetFile> clazz() {
		return impl.clazz();
	}

	public void createOrUpdate(IAssetFile e) throws StorageException {
		impl.createOrUpdate(e);
	}

	public EntityIterator<IAssetFile> load() throws StorageException {
		return impl.load();
	}

	public EntityIterator<IAssetFile> load(String domainKey) throws StorageException {
		return impl.load(domainKey);
	}

	public long count() throws StorageException {
		return impl.count();
	}

	public long count(String domainKey) throws StorageException {
		return impl.count(domainKey);
	}

	public IAssetFile get(String domainKey, String assetId, String fileId) throws StorageException {
		return impl.get(domainKey, assetId, fileId);
	}

	public void delete(String domainKey) throws StorageException {
		impl.delete(domainKey);
	}

	public IFileContent getContent(String domainKey, String assetId, String fileId) throws StorageException {
		return impl.getContent(domainKey, assetId, fileId);
	}

	public boolean has(String domainKey, String assetId, String fileId) throws StorageException {
		return impl.has(domainKey, assetId, fileId);
	}

	public void delete(String domainKey, String assetId, String fileId) throws StorageException {
		impl.delete(domainKey, assetId, fileId);
	}

	public void update(String domainKey, String assetId, String fileId, String tags, String description) throws StorageException {
		impl.update(domainKey, assetId, fileId, tags, description);
	}

	public void update(String domainKey, String assetId, String fileId, byte[] data, String mediaType) throws StorageException {
		impl.update(domainKey, assetId, fileId, data, mediaType);
	}

	public Collection<IAssetFile> list(boolean load, String domainKey, String assetId, int page, int pageSize) throws StorageException {
		return impl.list(load, domainKey, assetId, page, pageSize);
	}

	public Collection<IAssetFile> listNext(boolean load, String domainKey, String assetId, String fileId, int page, int pageSize) throws StorageException {
		return impl.listNext(load, domainKey, assetId, fileId, page, pageSize);
	}

	public Collection<IAssetFile> search(boolean load, String domainKey, String assetId, String query, int pageSize) throws StorageException {
		return impl.search(load, domainKey, assetId, query, pageSize);
	}

	public void delete() throws StorageException {
		impl.delete();
	}

}
