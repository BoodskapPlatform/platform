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
import io.boodskap.iot.dao.DomainEntityDAO;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.model.IDomainEntity;

public class DomainEntityDAOImpl implements DomainEntityDAO<IDomainEntity> {

	private final DomainEntityDAO<IDomainEntity> impl;

	public DomainEntityDAOImpl(final DomainEntityDAO<IDomainEntity> impl) {
		this.impl = impl;
	}

	public Class<? extends IDomainEntity> clazz() {
		return impl.clazz();
	}

	public void createOrUpdate(IDomainEntity e) throws StorageException {
		impl.createOrUpdate(e);
	}

	public EntityIterator<IDomainEntity> load() throws StorageException {
		return impl.load();
	}

	public EntityIterator<IDomainEntity> load(String domainKey) throws StorageException {
		return impl.load(domainKey);
	}

	public long count() throws StorageException {
		return impl.count();
	}

	public long count(String domainKey) throws StorageException {
		return impl.count(domainKey);
	}

	public IDomainEntity create(String domainKey, String entityType, String entityId) throws StorageException {
		return impl.create(domainKey, entityType, entityId);
	}

	public void delete(String domainKey) throws StorageException {
		impl.delete(domainKey);
	}

	public IDomainEntity get(String domainKey, String entityType, String entityId) throws StorageException {
		return impl.get(domainKey, entityType, entityId);
	}

	public void delete(String domainKey, String entityType, String entityId) throws StorageException {
		impl.delete(domainKey, entityType, entityId);
	}

	public Collection<IDomainEntity> list(String domainKey, int page, int pageSize) throws StorageException {
		return impl.list(domainKey, page, pageSize);
	}

	public Collection<IDomainEntity> list(String domainKey, String entityType, int page, int pageSize) throws StorageException {
		return impl.list(domainKey, entityType, page, pageSize);
	}

	public Collection<IDomainEntity> listNext(String domainKey, String entityType, String entityId, int page, int pageSize) throws StorageException {
		return impl.listNext(domainKey, entityType, entityId, page, pageSize);
	}

	public Collection<IDomainEntity> search(String domainKey, String query, int pageSize) throws StorageException {
		return impl.search(domainKey, query, pageSize);
	}

	public Collection<IDomainEntity> search(String domainKey, String entityType, String query, int pageSize) throws StorageException {
		return impl.search(domainKey, entityType, query, pageSize);
	}

	public void delete() throws StorageException {
		impl.delete();
	}

}
