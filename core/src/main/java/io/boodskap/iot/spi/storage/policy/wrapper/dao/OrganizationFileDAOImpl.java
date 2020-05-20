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
import io.boodskap.iot.dao.OrganizationFileDAO;
import io.boodskap.iot.model.IFileContent;
import io.boodskap.iot.model.IOrganizationFile;

public class OrganizationFileDAOImpl implements OrganizationFileDAO<IOrganizationFile> {

	private final OrganizationFileDAO<IOrganizationFile> impl;

	public OrganizationFileDAOImpl(final OrganizationFileDAO<IOrganizationFile> impl) {
		this.impl = impl;
	}

	public IOrganizationFile create(String domainKey, String orgId, String fileId) throws StorageException {
		return impl.create(domainKey, orgId, fileId);
	}

	public Class<? extends IOrganizationFile> clazz() {
		return impl.clazz();
	}

	public void createOrUpdate(IOrganizationFile e) throws StorageException {
		impl.createOrUpdate(e);
	}

	public EntityIterator<IOrganizationFile> load() throws StorageException {
		return impl.load();
	}

	public EntityIterator<IOrganizationFile> load(String domainKey) throws StorageException {
		return impl.load(domainKey);
	}

	public long count() throws StorageException {
		return impl.count();
	}

	public long count(String domainKey) throws StorageException {
		return impl.count(domainKey);
	}

	public IOrganizationFile get(String domainKey, String orgId, String fileId) throws StorageException {
		return impl.get(domainKey, orgId, fileId);
	}

	public void delete(String domainKey) throws StorageException {
		impl.delete(domainKey);
	}

	public IFileContent getContent(String domainKey, String orgId, String fileId) throws StorageException {
		return impl.getContent(domainKey, orgId, fileId);
	}

	public boolean has(String domainKey, String orgId, String fileId) throws StorageException {
		return impl.has(domainKey, orgId, fileId);
	}

	public void delete(String domainKey, String orgId, String fileId) throws StorageException {
		impl.delete(domainKey, orgId, fileId);
	}

	public void update(String domainKey, String orgId, String fileId, String tags, String description) throws StorageException {
		impl.update(domainKey, orgId, fileId, tags, description);
	}

	public void update(String domainKey, String orgId, String fileId, byte[] data, String mediaType) throws StorageException {
		impl.update(domainKey, orgId, fileId, data, mediaType);
	}

	public Collection<IOrganizationFile> list(boolean load, String domainKey, String orgId, int page, int pageSize) throws StorageException {
		return impl.list(load, domainKey, orgId, page, pageSize);
	}

	public Collection<IOrganizationFile> listNext(boolean load, String domainKey, String orgId, String fileId, int page, int pageSize) throws StorageException {
		return impl.listNext(load, domainKey, orgId, fileId, page, pageSize);
	}

	public Collection<IOrganizationFile> search(boolean load, String domainKey, String orgId, String query, int pageSize) throws StorageException {
		return impl.search(load, domainKey, orgId, query, pageSize);
	}

	public void delete() throws StorageException {
		impl.delete();
	}

}
