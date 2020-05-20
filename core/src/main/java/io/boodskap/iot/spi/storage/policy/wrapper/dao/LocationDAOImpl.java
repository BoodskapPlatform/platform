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

import io.boodskap.iot.EntityType;
import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.dao.LocationDAO;
import io.boodskap.iot.model.ILocation;

public class LocationDAOImpl implements LocationDAO<ILocation> {

	private final LocationDAO<ILocation> impl;

	public LocationDAOImpl(final LocationDAO<ILocation> impl) {
		this.impl = impl;
	}

	public ILocation create(String domainKey, EntityType entityType, String entityId) throws StorageException {
		return impl.create(domainKey, entityType, entityId);
	}

	public Class<? extends ILocation> clazz() {
		return impl.clazz();
	}

	public void createOrUpdate(ILocation e) throws StorageException {
		impl.createOrUpdate(e);
	}

	public EntityIterator<ILocation> load() throws StorageException {
		return impl.load();
	}

	public EntityIterator<ILocation> load(String domainKey) throws StorageException {
		return impl.load(domainKey);
	}

	public long count() throws StorageException {
		return impl.count();
	}

	public long count(String domainKey) throws StorageException {
		return impl.count(domainKey);
	}

	public ILocation get(String domainKey, EntityType entityType, String entityId) throws StorageException {
		return impl.get(domainKey, entityType, entityId);
	}

	public void delete(String domainKey) throws StorageException {
		impl.delete(domainKey);
	}

	public long count(String domainKey, EntityType entityType) throws StorageException {
		return impl.count(domainKey, entityType);
	}

	public void delete(String domainKey, EntityType entityType) throws StorageException {
		impl.delete(domainKey, entityType);
	}

	public void delete(String domainKey, EntityType entityType, String entityId) throws StorageException {
		impl.delete(domainKey, entityType, entityId);
	}

	public Collection<ILocation> list(String domainKey, int page, int pageSize) throws StorageException {
		return impl.list(domainKey, page, pageSize);
	}

	public Collection<ILocation> listNext(String domainKey, String entityId, int page, int pageSize) throws StorageException {
		return impl.listNext(domainKey, entityId, page, pageSize);
	}

	public Collection<ILocation> list(String domainKey, EntityType entityType, int page, int pageSize) throws StorageException {
		return impl.list(domainKey, entityType, page, pageSize);
	}

	public Collection<ILocation> listNext(String domainKey, EntityType entityType, String entityId, int page, int pageSize) throws StorageException {
		return impl.listNext(domainKey, entityType, entityId, page, pageSize);
	}

	public Collection<ILocation> search(String domainKey, String query, int pageSize) throws StorageException {
		return impl.search(domainKey, query, pageSize);
	}

	public Collection<ILocation> search(String domainKey, EntityType entityType, String query, int pageSize) throws StorageException {
		return impl.search(domainKey, entityType, query, pageSize);
	}

	public void delete() throws StorageException {
		impl.delete();
	}

}
