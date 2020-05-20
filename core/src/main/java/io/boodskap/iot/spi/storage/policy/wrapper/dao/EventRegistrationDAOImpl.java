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

import io.boodskap.iot.NotificationChannel;
import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.dao.EventRegistrationDAO;
import io.boodskap.iot.model.IEventRegistration;

public class EventRegistrationDAOImpl implements EventRegistrationDAO<IEventRegistration> {

	private final EventRegistrationDAO<IEventRegistration> impl;

	public EventRegistrationDAOImpl(final EventRegistrationDAO<IEventRegistration> impl) {
		this.impl = impl;
	}

	public IEventRegistration create(String domainKey, String eventId, NotificationChannel channel, String toAddress) throws StorageException {
		return impl.create(domainKey, eventId, channel, toAddress);
	}

	public Class<? extends IEventRegistration> clazz() {
		return impl.clazz();
	}

	public void createOrUpdate(IEventRegistration e) throws StorageException {
		impl.createOrUpdate(e);
	}

	public EntityIterator<IEventRegistration> load() throws StorageException {
		return impl.load();
	}

	public EntityIterator<IEventRegistration> load(String domainKey) throws StorageException {
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

	public IEventRegistration get(String domainKey, String eventId, NotificationChannel channel, String toAddress) throws StorageException {
		return impl.get(domainKey, eventId, channel, toAddress);
	}

	public EntityIterator<String> iterateReceipeints(String domainKey, String eventId, NotificationChannel channel) throws StorageException {
		return impl.iterateReceipeints(domainKey, eventId, channel);
	}

	public void delete(String domainKey, String eventId) throws StorageException {
		impl.delete(domainKey, eventId);
	}

	public void delete(String domainKey, String eventId, NotificationChannel channel) throws StorageException {
		impl.delete(domainKey, eventId, channel);
	}

	public void delete(String domainKey, String eventId, NotificationChannel channel, String toAddress) throws StorageException {
		impl.delete(domainKey, eventId, channel, toAddress);
	}

	public long count(String domainKey, String eventId) throws StorageException {
		return impl.count(domainKey, eventId);
	}

	public long count(String domainKey, String eventId, NotificationChannel channel) throws StorageException {
		return impl.count(domainKey, eventId, channel);
	}

	public Collection<String> listReceipeints(String domainKey, String eventId, NotificationChannel channel, int page, int pageSize) throws StorageException {
		return impl.listReceipeints(domainKey, eventId, channel, page, pageSize);
	}

	public Collection<String> listReceipeintsNext(String domainKey, String eventId, NotificationChannel channel, String toAddress, int page, int pageSize) throws StorageException {
		return impl.listReceipeintsNext(domainKey, eventId, channel, toAddress, page, pageSize);
	}

	public Collection<IEventRegistration> list(String domainKey, String eventId, NotificationChannel channel, int page, int pageSize) throws StorageException {
		return impl.list(domainKey, eventId, channel, page, pageSize);
	}

	public Collection<IEventRegistration> listNext(String domainKey, String eventId, NotificationChannel channel, String toAddress, int page, int pageSize) throws StorageException {
		return impl.listNext(domainKey, eventId, channel, toAddress, page, pageSize);
	}

	public Collection<IEventRegistration> search(String domainKey, String eventId, String query, int pageSize) throws StorageException {
		return impl.search(domainKey, eventId, query, pageSize);
	}

	public Collection<IEventRegistration> search(String domainKey, String eventId, NotificationChannel channel, String query, int pageSize) throws StorageException {
		return impl.search(domainKey, eventId, channel, query, pageSize);
	}

	public void delete() throws StorageException {
		impl.delete();
	}

}
