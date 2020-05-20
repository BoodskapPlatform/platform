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
import io.boodskap.iot.dao.OrganizationRoleDAO;
import io.boodskap.iot.model.IOrganizationRole;

public class OrganizationRoleDAOImpl implements OrganizationRoleDAO<IOrganizationRole> {
	
	private final OrganizationRoleDAO<IOrganizationRole> impl;

	public OrganizationRoleDAOImpl(OrganizationRoleDAO<IOrganizationRole> impl) {
		this.impl = impl;
	}

	public IOrganizationRole create(String domainKey, String orgId, String name) throws StorageException {
		return impl.create(domainKey, orgId, name);
	}

	public Class<? extends IOrganizationRole> clazz() {
		return impl.clazz();
	}

	public void createOrUpdate(IOrganizationRole e) throws StorageException {
		impl.createOrUpdate(e);
	}

	public EntityIterator<IOrganizationRole> load() throws StorageException {
		return impl.load();
	}

	public EntityIterator<IOrganizationRole> load(String domainKey) throws StorageException {
		return impl.load(domainKey);
	}

	public long count() throws StorageException {
		return impl.count();
	}

	public long count(String domainKey) throws StorageException {
		return impl.count(domainKey);
	}

	public IOrganizationRole get(String domainKey, String orgId, String name) throws StorageException {
		return impl.get(domainKey, orgId, name);
	}

	public void delete(String domainKey) throws StorageException {
		impl.delete(domainKey);
	}

	public long count(String domainKey, String orgId) throws StorageException {
		return impl.count(domainKey, orgId);
	}

	public void delete(String domainKey, String orgId) throws StorageException {
		impl.delete(domainKey, orgId);
	}

	public void delete(String domainKey, String orgId, String name) throws StorageException {
		impl.delete(domainKey, orgId, name);
	}

	public Collection<IOrganizationRole> list(String domainKey, String orgId) throws StorageException {
		return impl.list(domainKey, orgId);
	}

	public Collection<IOrganizationRole> search(String domainKey, String orgId, String query, int pageSize) throws StorageException {
		return impl.search(domainKey, orgId, query, pageSize);
	}

	public void delete() throws StorageException {
		impl.delete();
	}

}
