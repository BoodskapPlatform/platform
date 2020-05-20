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
import io.boodskap.iot.dao.SentFCMDAO;
import io.boodskap.iot.model.ISentFCM;

public class SentFCMDAOImpl implements SentFCMDAO<ISentFCM> {

	private final SentFCMDAO<ISentFCM> impl;

	public SentFCMDAOImpl(final SentFCMDAO<ISentFCM> impl) {
		this.impl = impl;
	}

	public ISentFCM create(String domainKey, String notificationId) throws StorageException {
		return impl.create(domainKey, notificationId);
	}

	public Class<? extends ISentFCM> clazz() {
		return impl.clazz();
	}

	public void createOrUpdate(ISentFCM e) throws StorageException {
		impl.createOrUpdate(e);
	}

	public EntityIterator<ISentFCM> load() throws StorageException {
		return impl.load();
	}

	public EntityIterator<ISentFCM> load(String domainKey) throws StorageException {
		return impl.load(domainKey);
	}

	public ISentFCM get(String id) throws StorageException {
		return impl.get(id);
	}

	public long count() throws StorageException {
		return impl.count();
	}

	public ISentFCM get(String domainKey, String id) throws StorageException {
		return impl.get(domainKey, id);
	}

	public long count(String domainKey) throws StorageException {
		return impl.count(domainKey);
	}

	public void delete(String domainKey) throws StorageException {
		impl.delete(domainKey);
	}

	public void delete(String domainKey, String id) throws StorageException {
		impl.delete(domainKey, id);
	}

	public Collection<ISentFCM> list(String domainKey, int page, int pageSize) throws StorageException {
		return impl.list(domainKey, page, pageSize);
	}

	public Collection<ISentFCM> listNext(String domainKey, String id, int page, int pageSize) throws StorageException {
		return impl.listNext(domainKey, id, page, pageSize);
	}

	public void delete() throws StorageException {
		impl.delete();
	}

}
