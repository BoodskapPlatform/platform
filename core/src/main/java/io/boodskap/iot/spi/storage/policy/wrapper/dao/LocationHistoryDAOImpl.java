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
import io.boodskap.iot.dao.LocationHistoryDAO;
import io.boodskap.iot.model.ILocationHistory;

public class LocationHistoryDAOImpl implements LocationHistoryDAO<ILocationHistory> {

	private final LocationHistoryDAO<ILocationHistory> impl;

	public LocationHistoryDAOImpl(final LocationHistoryDAO<ILocationHistory> impl) {
		this.impl = impl;
	}

	public ILocationHistory create(String domainKey, EntityType entityType, String entityId, String historyId)throws StorageException {
		return impl.create(domainKey, entityType, entityId, historyId);
	}

	public Class<? extends ILocationHistory> clazz() {
		return impl.clazz();
	}

	public void createOrUpdate(ILocationHistory e) throws StorageException {
		impl.createOrUpdate(e);
	}

	public EntityIterator<ILocationHistory> load() throws StorageException {
		return impl.load();
	}

	public EntityIterator<ILocationHistory> load(String domainKey) throws StorageException {
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

	public ILocationHistory get(String domainKey, EntityType entityType, String entityId, String historyId) throws StorageException {
		return impl.get(domainKey, entityType, entityId, historyId);
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

	public void delete(String domainKey, EntityType entityType, String entityId, String historyId) throws StorageException {
		impl.delete(domainKey, entityType, entityId, historyId);
	}

	public Collection<ILocationHistory> list(String domainKey, int page, int pageSize) throws StorageException {
		return impl.list(domainKey, page, pageSize);
	}

	public Collection<ILocationHistory> listNext(String domainKey, String historyId, int page, int pageSize) throws StorageException {
		return impl.listNext(domainKey, historyId, page, pageSize);
	}

	public Collection<ILocationHistory> list(String domainKey, EntityType entityType, int page, int pageSize) throws StorageException {
		return impl.list(domainKey, entityType, page, pageSize);
	}

	public Collection<ILocationHistory> listNext(String domainKey, EntityType entityType, String historyId, int page, int pageSize) throws StorageException {
		return impl.listNext(domainKey, entityType, historyId, page, pageSize);
	}

	public Collection<ILocationHistory> search(String domainKey, String query, int pageSize) throws StorageException {
		return impl.search(domainKey, query, pageSize);
	}

	public Collection<ILocationHistory> search(String domainKey, EntityType entityType, String query, int pageSize) throws StorageException {
		return impl.search(domainKey, entityType, query, pageSize);
	}

	public void delete() throws StorageException {
		impl.delete();
	}

}
