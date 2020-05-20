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

import io.boodskap.iot.BoodskapSystem;
import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.dao.RawMessageDAO;
import io.boodskap.iot.model.IRawMessage;

public class RawMessageDAOImpl implements RawMessageDAO<IRawMessage> {

	private final RawMessageDAO<IRawMessage> impl;

	public RawMessageDAOImpl(final RawMessageDAO<IRawMessage> impl) {
		this.impl = impl;
	}

	public IRawMessage create(String domainKey, String rawId) throws StorageException {
		return impl.create(domainKey, rawId);
	}

	public Class<? extends IRawMessage> clazz() {
		return impl.clazz();
	}

	public void createOrUpdate(IRawMessage e) throws StorageException {
		
		if(!BoodskapSystem.isLicensed()) throw new StorageException("license error");
		
		impl.createOrUpdate(e);
	}

	public EntityIterator<IRawMessage> load() throws StorageException {
		return impl.load();
	}

	public EntityIterator<IRawMessage> load(String domainKey) throws StorageException {
		return impl.load(domainKey);
	}

	public long count() throws StorageException {
		return impl.count();
	}

	public long count(String domainKey) throws StorageException {
		return impl.count(domainKey);
	}

	public IRawMessage get(String domainKey, String id) throws StorageException {
		return impl.get(domainKey, id);
	}

	public void delete(String domainKey) throws StorageException {
		impl.delete(domainKey);
	}

	public long count(String domainKey, String deviceId) throws StorageException {
		return impl.count(domainKey, deviceId);
	}

	public long count(String domainKey, String deviceId, String specId) throws StorageException {
		return impl.count(domainKey, deviceId, specId);
	}

	public void delete(String domainKey, String id) throws StorageException {
		impl.delete(domainKey, id);
	}

	public Collection<IRawMessage> list(String domainKey, String deviceId, int page, int pageSize) throws StorageException {
		return impl.list(domainKey, deviceId, page, pageSize);
	}

	public Collection<IRawMessage> listNext(String domainKey, String deviceId, String id, int page, int pageSize) throws StorageException {
		return impl.listNext(domainKey, deviceId, id, page, pageSize);
	}

	public Collection<IRawMessage> list(String domainKey, String deviceId, String messageId, int page, int pageSize) throws StorageException {
		return impl.list(domainKey, deviceId, messageId, page, pageSize);
	}

	public Collection<IRawMessage> listNext(String domainKey, String deviceId, String messageId, String id, int page, int pageSize) throws StorageException {
		return impl.listNext(domainKey, deviceId, messageId, id, page, pageSize);
	}

	public void delete() throws StorageException {
		impl.delete();
	}

}
