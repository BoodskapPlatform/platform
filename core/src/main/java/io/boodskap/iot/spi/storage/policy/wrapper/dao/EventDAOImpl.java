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
import io.boodskap.iot.dao.EventDAO;
import io.boodskap.iot.model.IEvent;

public class EventDAOImpl implements EventDAO<IEvent> {

	private final EventDAO<IEvent> impl;

	public EventDAOImpl(final EventDAO<IEvent> impl) {
		this.impl = impl;
	}

	public IEvent create(String domainKey, String eventId) throws StorageException {
		return impl.create(domainKey, eventId);
	}

	public Class<? extends IEvent> clazz() {
		return impl.clazz();
	}

	public void createOrUpdate(IEvent e) throws StorageException {
		impl.createOrUpdate(e);
	}

	public EntityIterator<IEvent> load() throws StorageException {
		return impl.load();
	}

	public EntityIterator<IEvent> load(String domainKey) throws StorageException {
		return impl.load(domainKey);
	}

	public long count() throws StorageException {
		return impl.count();
	}

	public IEvent get(String domainKey, String eventId) throws StorageException {
		return impl.get(domainKey, eventId);
	}

	public long count(String domainKey) throws StorageException {
		return impl.count(domainKey);
	}

	public Collection<String> listIds(String domainKey) throws StorageException {
		return impl.listIds(domainKey);
	}

	public void delete(String domainKey) throws StorageException {
		impl.delete(domainKey);
	}

	public void delete(String domainKey, String eventId) throws StorageException {
		impl.delete(domainKey, eventId);
	}

	public Collection<IEvent> list(String domainKey, int page, int pageSize) throws StorageException {
		return impl.list(domainKey, page, pageSize);
	}

	public Collection<IEvent> listNext(String domainKey, String eventId, int page, int pageSize) throws StorageException {
		return impl.listNext(domainKey, eventId, page, pageSize);
	}

	public Collection<IEvent> search(String domainKey, String query, int pageSize) throws StorageException {
		return impl.search(domainKey, query, pageSize);
	}

	public void delete() throws StorageException {
		impl.delete();
	}

}
