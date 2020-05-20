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
import io.boodskap.iot.dao.OrganizationUserRoleDAO;
import io.boodskap.iot.model.IOrganizationUserRole;

public class OrganizationUserRoleDAOImpl implements OrganizationUserRoleDAO<IOrganizationUserRole>{
	
	private final OrganizationUserRoleDAO<IOrganizationUserRole> impl;

	public OrganizationUserRoleDAOImpl(OrganizationUserRoleDAO<IOrganizationUserRole> impl) {
		this.impl = impl;
	}

	public IOrganizationUserRole create(String domainKey, String orgId, String userId, String name) throws StorageException {
		return impl.create(domainKey, orgId, userId, name);
	}

	public Class<? extends IOrganizationUserRole> clazz() {
		return impl.clazz();
	}

	public void createOrUpdate(IOrganizationUserRole e) throws StorageException {
		impl.createOrUpdate(e);
	}

	public EntityIterator<IOrganizationUserRole> load() throws StorageException {
		return impl.load();
	}

	public EntityIterator<IOrganizationUserRole> load(String domainKey) throws StorageException {
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

	public IOrganizationUserRole get(String domainKey, String orgid, String userId, String name) throws StorageException {
		return impl.get(domainKey, orgid, userId, name);
	}

	public long count(String domainKey, String orgId, String userId) throws StorageException {
		return impl.count(domainKey, orgId, userId);
	}

	public void delete(String domainKey, String orgId, String userId) throws StorageException {
		impl.delete(domainKey, orgId, userId);
	}

	public void delete(String domainKey, String orgId, String userId, String name) throws StorageException {
		impl.delete(domainKey, orgId, userId, name);
	}

	public Collection<IOrganizationUserRole> list(String domainKey, String orgid, String userId) throws StorageException {
		return impl.list(domainKey, orgid, userId);
	}

	public Collection<IOrganizationUserRole> search(String domainKey, String orgid, String userId, String query, int pageSize) throws StorageException {
		return impl.search(domainKey, orgid, userId, query, pageSize);
	}

	public void delete() throws StorageException {
		impl.delete();
	}

}
