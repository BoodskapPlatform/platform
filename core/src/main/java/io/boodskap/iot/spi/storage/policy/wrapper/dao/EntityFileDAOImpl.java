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
import io.boodskap.iot.dao.EntityFileDAO;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.model.IEntityFile;
import io.boodskap.iot.model.IFileContent;

public class EntityFileDAOImpl implements EntityFileDAO<IEntityFile> {

	private final EntityFileDAO<IEntityFile> impl;

	public EntityFileDAOImpl(final EntityFileDAO<IEntityFile> impl) {
		this.impl = impl;
	}

	public IEntityFile create(String domainKey, String entityType, String entityId, String fileId) throws StorageException {
		return impl.create(domainKey, entityType, entityId, fileId);
	}

	public Class<? extends IEntityFile> clazz() {
		return impl.clazz();
	}

	public void createOrUpdate(IEntityFile e) throws StorageException {
		impl.createOrUpdate(e);
	}

	public EntityIterator<IEntityFile> load() throws StorageException {
		return impl.load();
	}

	public EntityIterator<IEntityFile> load(String domainKey) throws StorageException {
		return impl.load(domainKey);
	}

	public long count() throws StorageException {
		return impl.count();
	}

	public long count(String domainKey) throws StorageException {
		return impl.count(domainKey);
	}

	public IEntityFile get(String domainKey, String entityType, String entityId, String id) throws StorageException {
		return impl.get(domainKey, entityType, entityId, id);
	}

	public void delete(String domainKey) throws StorageException {
		impl.delete(domainKey);
	}

	public IFileContent getContent(String domainKey, String entityType, String entityId, String fileId) throws StorageException {
		return impl.getContent(domainKey, entityType, entityId, fileId);
	}

	public boolean has(String domainKey, String entityType, String entityId, String id) throws StorageException {
		return impl.has(domainKey, entityType, entityId, id);
	}

	public void delete(String domainKey, String entityType, String entityId, String id) throws StorageException {
		impl.delete(domainKey, entityType, entityId, id);
	}

	public void update(String domainKey, String entityType, String entityId, String id, String tags, String description) throws StorageException {
		impl.update(domainKey, entityType, entityId, id, tags, description);
	}

	public void update(String domainKey, String entityType, String entityId, String id, byte[] data, String mediaType) throws StorageException {
		impl.update(domainKey, entityType, entityId, id, data, mediaType);
	}

	public Collection<IEntityFile> list(boolean load, String domainKey, int page, int pageSize) throws StorageException {
		return impl.list(load, domainKey, page, pageSize);
	}

	public Collection<IEntityFile> list(boolean load, String domainKey, String entityType, int page, int pageSize) throws StorageException {
		return impl.list(load, domainKey, entityType, page, pageSize);
	}

	public Collection<IEntityFile> list(boolean load, String domainKey, String entityType, String entityId, int page, int pageSize) throws StorageException {
		return impl.list(load, domainKey, entityType, entityId, page, pageSize);
	}

	public Collection<IEntityFile> listNext(boolean load, String domainKey, String entityType, String entityId, String id, int page, int pageSize) throws StorageException {
		return impl.listNext(load, domainKey, entityType, entityId, id, page, pageSize);
	}

	public Collection<IEntityFile> search(boolean load, String domainKey, String query, int pageSize) throws StorageException {
		return impl.search(load, domainKey, query, pageSize);
	}

	public Collection<IEntityFile> search(boolean load, String domainKey, String entityType, String query, int pageSize) throws StorageException {
		return impl.search(load, domainKey, entityType, query, pageSize);
	}

	public Collection<IEntityFile> search(boolean load, String domainKey, String entityType, String entityId, String query, int pageSize) throws StorageException {
		return impl.search(load, domainKey, entityType, query, pageSize);
	}

	public void delete() throws StorageException {
		impl.delete();
	}

}
