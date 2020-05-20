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
package io.boodskap.iot.dao;

import java.util.Collection;

import io.boodskap.iot.BoodskapSystem;
import io.boodskap.iot.NotificationChannel;
import io.boodskap.iot.StorageException;
import io.boodskap.iot.model.IEventRegistration;

public interface EventRegistrationDAO<T extends IEventRegistration> extends DAO<T> {
	
	public static <T extends IEventRegistration> EventRegistrationDAO<T> get() {
		return BoodskapSystem.storage().getEventRegistrationDAO();
	}

	public T create(String domainKey, String eventId, NotificationChannel channel, String toAddress) throws StorageException;

	public T get(String domainKey, String eventId, NotificationChannel channel, String toAddress) throws StorageException;

	public EntityIterator<String> iterateReceipeints(String domainKey, String eventId, NotificationChannel channel) throws StorageException;

	public void delete(String domainKey, String eventId) throws StorageException;

	public void delete(String domainKey, String eventId, NotificationChannel channel) throws StorageException;

	public void delete(String domainKey, String eventId, NotificationChannel channel, String toAddress) throws StorageException;

	public long count(String domainKey, String eventId) throws StorageException;

	public long count(String domainKey, String eventId, NotificationChannel channel) throws StorageException;

	public Collection<String> listReceipeints(String domainKey, String eventId, NotificationChannel channel, int page, int pageSize) throws StorageException;

	public Collection<String> listReceipeintsNext(String domainKey, String eventId, NotificationChannel channel, String toAddress, int page, int pageSize) throws StorageException;

	public Collection<T> list(String domainKey, String eventId, NotificationChannel channel, int page, int pageSize) throws StorageException;

	public Collection<T> listNext(String domainKey, String eventId, NotificationChannel channel, String toAddress, int page, int pageSize) throws StorageException;

	public Collection<T> search(String domainKey, String eventId, String query, int pageSize) throws StorageException;

	public Collection<T> search(String domainKey, String eventId, NotificationChannel channel, String query, int pageSize) throws StorageException;

}
