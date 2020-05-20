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
import io.boodskap.iot.dao.UserFileDAO;
import io.boodskap.iot.model.IFileContent;
import io.boodskap.iot.model.IUserFile;

public class UserFileDAOImpl implements UserFileDAO<IUserFile> {

	private final UserFileDAO<IUserFile> impl;

	public UserFileDAOImpl(final UserFileDAO<IUserFile> impl) {
		this.impl = impl;
	}

	public IUserFile create(String domainKey, String userId, String fileId) throws StorageException {
		return impl.create(domainKey, userId, fileId);
	}

	public Class<? extends IUserFile> clazz() {
		return impl.clazz();
	}

	public void createOrUpdate(IUserFile e) throws StorageException {
		impl.createOrUpdate(e);
	}

	public EntityIterator<IUserFile> load() throws StorageException {
		return impl.load();
	}

	public EntityIterator<IUserFile> load(String domainKey) throws StorageException {
		return impl.load(domainKey);
	}

	public long count() throws StorageException {
		return impl.count();
	}

	public long count(String domainKey) throws StorageException {
		return impl.count(domainKey);
	}

	public IUserFile get(String domainKey, String userId, String fileId) throws StorageException {
		return impl.get(domainKey, userId, fileId);
	}

	public void delete(String domainKey) throws StorageException {
		impl.delete(domainKey);
	}

	public IFileContent getContent(String domainKey, String userId, String fileId) throws StorageException {
		return impl.getContent(domainKey, userId, fileId);
	}

	public boolean has(String domainKey, String userId, String fileId) throws StorageException {
		return impl.has(domainKey, userId, fileId);
	}

	public void delete(String domainKey, String userId, String fileId) throws StorageException {
		impl.delete(domainKey, userId, fileId);
	}

	public void update(String domainKey, String userId, String fileId, String tags, String description) throws StorageException {
		impl.update(domainKey, userId, fileId, tags, description);
	}

	public void update(String domainKey, String userId, String fileId, byte[] data, String mediaType) throws StorageException {
		impl.update(domainKey, userId, fileId, data, mediaType);
	}

	public Collection<IUserFile> list(boolean load, String domainKey, String userId, int page, int pageSize) throws StorageException {
		return impl.list(load, domainKey, userId, page, pageSize);
	}

	public Collection<IUserFile> listNext(boolean load, String domainKey, String userId, String fileId, int page, int pageSize) throws StorageException {
		return impl.listNext(load, domainKey, userId, fileId, page, pageSize);
	}

	public Collection<IUserFile> search(boolean load, String domainKey, String userId, String query, int pageSize) throws StorageException {
		return impl.search(load, domainKey, userId, query, pageSize);
	}

	public void delete() throws StorageException {
		impl.delete();
	}

}
