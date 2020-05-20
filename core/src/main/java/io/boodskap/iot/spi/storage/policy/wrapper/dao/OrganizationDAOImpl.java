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
import io.boodskap.iot.dao.OrganizationDAO;
import io.boodskap.iot.model.IOrganization;

public class OrganizationDAOImpl implements OrganizationDAO<IOrganization> {

	private final OrganizationDAO<IOrganization> impl;

	public OrganizationDAOImpl(final OrganizationDAO<IOrganization> impl) {
		this.impl = impl;
	}

	public IOrganization create(String domainKey, String orgId) throws StorageException {
		return impl.create(domainKey, orgId);
	}

	public Class<? extends IOrganization> clazz() {
		return impl.clazz();
	}

	public void createOrUpdate(IOrganization e) throws StorageException {
		impl.createOrUpdate(e);
	}

	public EntityIterator<IOrganization> load() throws StorageException {
		return impl.load();
	}

	public EntityIterator<IOrganization> load(String domainKey) throws StorageException {
		return impl.load(domainKey);
	}

	public long count() throws StorageException {
		return impl.count();
	}

	public long count(String domainKey) throws StorageException {
		return impl.count(domainKey);
	}

	public void delete(String domainKey) throws StorageException {
		impl.delete(domainKey);
	}

	public IOrganization get(String domainKey, String orgId) throws StorageException {
		return impl.get(domainKey, orgId);
	}

	public void delete(String domainKey, String orgId) throws StorageException {
		impl.delete(domainKey, orgId);
	}

	public Collection<IOrganization> list(String domainKey, int page, int pageSize) throws StorageException {
		return impl.list(domainKey, page, pageSize);
	}

	public Collection<IOrganization> listNext(String domainKey, String orgId, int page, int pageSize) throws StorageException {
		return impl.listNext(domainKey, orgId, page, pageSize);
	}

	public Collection<IOrganization> search(String domainKey, String query, int pageSize) throws StorageException {
		return impl.search(domainKey, query, pageSize);
	}

	public void delete() throws StorageException {
		impl.delete();
	}

}
