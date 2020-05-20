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
import io.boodskap.iot.dao.DomainFileDAO;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.model.IDomainFile;
import io.boodskap.iot.model.IFileContent;

public class DomainFileDAOImpl implements DomainFileDAO<IDomainFile> {

	private final DomainFileDAO<IDomainFile> impl;

	public DomainFileDAOImpl(final DomainFileDAO<IDomainFile> impl) {
		this.impl = impl;
	}

	public Class<? extends IDomainFile> clazz() {
		return impl.clazz();
	}

	public void createOrUpdate(IDomainFile e) throws StorageException {
		impl.createOrUpdate(e);
	}

	public EntityIterator<IDomainFile> load() throws StorageException {
		return impl.load();
	}

	public EntityIterator<IDomainFile> load(String domainKey) throws StorageException {
		return impl.load(domainKey);
	}

	public long count() throws StorageException {
		return impl.count();
	}

	public long count(String domainKey) throws StorageException {
		return impl.count(domainKey);
	}

	public IDomainFile create(String domainKey, String fileId) throws StorageException {
		return impl.create(domainKey, fileId);
	}

	public void delete(String domainKey) throws StorageException {
		impl.delete(domainKey);
	}

	public IDomainFile get(String domainKey, String fileId) throws StorageException {
		return impl.get(domainKey, fileId);
	}

	public IFileContent getContent(String domainKey, String fileId) throws StorageException {
		return impl.getContent(domainKey, fileId);
	}

	public boolean has(String domainKey, String fileId) throws StorageException {
		return impl.has(domainKey, fileId);
	}

	public void delete(String domainKey, String fileId) throws StorageException {
		impl.delete(domainKey, fileId);
	}

	public void update(String domainKey, String fileId, String tags, String description) throws StorageException {
		impl.update(domainKey, fileId, tags, description);
	}

	public void update(String domainKey, String fileId, byte[] data, String mediaType) throws StorageException {
		impl.update(domainKey, fileId, data, mediaType);
	}

	public Collection<IDomainFile> list(boolean load, String domainKey, int page, int pageSize)
			throws StorageException {
		return impl.list(load, domainKey, page, pageSize);
	}

	public Collection<IDomainFile> listNext(boolean load, String domainKey, String fileId, int page, int pageSize)
			throws StorageException {
		return impl.listNext(load, domainKey, fileId, page, pageSize);
	}

	public Collection<IDomainFile> search(boolean load, String domainKey, String query, int pageSize)
			throws StorageException {
		return impl.search(load, domainKey, query, pageSize);
	}

	public void delete() throws StorageException {
		impl.delete();
	}

}
