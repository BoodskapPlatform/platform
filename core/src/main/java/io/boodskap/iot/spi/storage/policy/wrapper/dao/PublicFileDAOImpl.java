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
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.dao.PublicFileDAO;
import io.boodskap.iot.model.IFileContent;
import io.boodskap.iot.model.IPublicFile;

public class PublicFileDAOImpl implements PublicFileDAO<IPublicFile> {

	private final PublicFileDAO<IPublicFile> impl;

	public PublicFileDAOImpl(final PublicFileDAO<IPublicFile> impl) {
		this.impl = impl;
	}

	public IPublicFile create(String fileId) throws StorageException {
		return impl.create(fileId);
	}

	public Class<? extends IPublicFile> clazz() {
		return impl.clazz();
	}

	public void createOrUpdate(IPublicFile e) throws StorageException {
		impl.createOrUpdate(e);
	}

	public EntityIterator<IPublicFile> load() throws StorageException {
		return impl.load();
	}

	public EntityIterator<IPublicFile> load(String domainKey) throws StorageException {
		return impl.load(domainKey);
	}

	public long count() throws StorageException {
		return impl.count();
	}

	public long count(String domainKey) throws StorageException {
		return impl.count(domainKey);
	}

	public IPublicFile get(String fileId) throws StorageException {
		return impl.get(fileId);
	}

	public IFileContent getContent(String fileId) throws StorageException {
		return impl.getContent(fileId);
	}

	public boolean has(String fileId) throws StorageException {
		return impl.has(fileId);
	}

	public void delete(String fileId) throws StorageException {
		impl.delete(fileId);
	}

	public void update(String fileId, byte[] data, String mediaType) throws StorageException {
		impl.update(fileId, data, mediaType);
	}

	public Collection<IPublicFile> list(boolean load, int page, int pageSize) throws StorageException {
		return impl.list(load, page, pageSize);
	}

	public Collection<IPublicFile> listNext(boolean load, String fileId, int page, int pageSize) throws StorageException {
		return impl.listNext(load, fileId, page, pageSize);
	}

	public Collection<IPublicFile> search(boolean load, String query, int pageSize) throws StorageException {
		return impl.search(load, query, pageSize);
	}

	public void delete() throws StorageException {
		impl.delete();
	}

	@Override
	public void update(String fileId, String tags, String description) throws StorageException {
		impl.update(fileId, tags, description);
	}

}
