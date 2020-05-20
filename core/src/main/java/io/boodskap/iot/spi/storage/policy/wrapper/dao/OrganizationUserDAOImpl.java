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
import io.boodskap.iot.dao.OrganizationUserDAO;
import io.boodskap.iot.model.IOrganizationUser;

public class OrganizationUserDAOImpl implements OrganizationUserDAO<IOrganizationUser> {
	
	private final OrganizationUserDAO<IOrganizationUser> impl;

	public OrganizationUserDAOImpl(OrganizationUserDAO<IOrganizationUser> impl) {
		this.impl = impl;
	}

	public IOrganizationUser create(String domainKey, String orgId, String userId) throws StorageException {
		return impl.create(domainKey, orgId, userId);
	}

	public Class<? extends IOrganizationUser> clazz() {
		return impl.clazz();
	}

	public void createOrUpdate(IOrganizationUser e) throws StorageException {
		impl.createOrUpdate(e);
	}

	public EntityIterator<IOrganizationUser> load() throws StorageException {
		return impl.load();
	}

	public EntityIterator<IOrganizationUser> load(String domainKey) throws StorageException {
		return impl.load(domainKey);
	}

	public long count() throws StorageException {
		return impl.count();
	}

	public long count(String domainKey) throws StorageException {
		return impl.count(domainKey);
	}

	public IOrganizationUser get(String domainKey, String orgId, String userId) throws StorageException {
		return impl.get(domainKey, orgId, userId);
	}

	public void delete(String domainKey) throws StorageException {
		impl.delete(domainKey);
	}

	public void delete(String domainKey, String orgId) throws StorageException {
		impl.delete(domainKey, orgId);
	}

	public void delete(String domainKey, String orgId, String userId) throws StorageException {
		impl.delete(domainKey, orgId, userId);
	}

	public Collection<IOrganizationUser> list(String domainKey, String orgId, int page, int pageSize) throws StorageException {
		return impl.list(domainKey, orgId, page, pageSize);
	}

	public Collection<IOrganizationUser> listNext(String domainKey, String orgId, String userId, int page, int pageSize) throws StorageException {
		return impl.listNext(domainKey, orgId, userId, page, pageSize);
	}

	public Collection<IOrganizationUser> search(String domainKey, String orgId, String query, int pageSize) throws StorageException {
		return impl.search(domainKey, orgId, query, pageSize);
	}

	public void delete() throws StorageException {
		impl.delete();
	}

}
