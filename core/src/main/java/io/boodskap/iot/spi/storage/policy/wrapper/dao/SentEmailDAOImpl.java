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
import io.boodskap.iot.dao.SentEmailDAO;
import io.boodskap.iot.model.IProgress;
import io.boodskap.iot.model.IResponse;
import io.boodskap.iot.model.ISentEmail;

public class SentEmailDAOImpl implements SentEmailDAO<ISentEmail> {

	private final SentEmailDAO<ISentEmail> impl;

	public SentEmailDAOImpl(final SentEmailDAO<ISentEmail> impl) {
		this.impl = impl;
	}

	public ISentEmail create(String domainKey, String notificationId) throws StorageException {
		return impl.create(domainKey, notificationId);
	}

	public Class<? extends ISentEmail> clazz() {
		return impl.clazz();
	}

	public void createOrUpdate(ISentEmail e) throws StorageException {
		impl.createOrUpdate(e);
	}

	public EntityIterator<ISentEmail> load() throws StorageException {
		return impl.load();
	}

	public EntityIterator<ISentEmail> load(String domainKey) throws StorageException {
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

	public ISentEmail get(String id) throws StorageException {
		return impl.get(id);
	}

	public ISentEmail get(String domainKey, String id) throws StorageException {
		return impl.get(domainKey, id);
	}

	public void delete(String domainKey, String id) throws StorageException {
		impl.delete(domainKey, id);
	}

	public Collection<ISentEmail> list(String domainKey, int page, int pageSize) throws StorageException {
		return impl.list(domainKey, page, pageSize);
	}

	public Collection<ISentEmail> listNext(String domainKey, String id, int page, int pageSize) throws StorageException {
		return impl.listNext(domainKey, id, page, pageSize);
	}

	public IProgress createProgress() {
		return impl.createProgress();
	}

	public IResponse createResponse() {
		return impl.createResponse();
	}

	public void delete() throws StorageException {
		impl.delete();
	}

}
