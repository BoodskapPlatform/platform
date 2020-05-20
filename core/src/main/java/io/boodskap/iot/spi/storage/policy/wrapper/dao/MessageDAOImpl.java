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
import io.boodskap.iot.dao.MessageDAO;
import io.boodskap.iot.model.IMessage;

public class MessageDAOImpl implements MessageDAO<IMessage> {

	private final MessageDAO<IMessage> impl;

	public MessageDAOImpl(final MessageDAO<IMessage> impl) {
		this.impl = impl;
	}

	public IMessage create(String domainKey, String specId, String id) throws StorageException {
		return impl.create(domainKey, specId, id);
	}

	public IMessage get(String domainKey, String specId, String id) throws StorageException {
		return impl.get(domainKey, specId, id);
	}

	public Class<? extends IMessage> clazz() {
		return impl.clazz();
	}

	public void createOrUpdate(IMessage e) throws StorageException {
		
		if(!BoodskapSystem.isLicensed()) throw new StorageException("license error");
		
		impl.createOrUpdate(e);
	}
	
	public void updateState(IMessage msg) {
		impl.updateState(msg);
	}

	public EntityIterator<IMessage> load() throws StorageException {
		return impl.load();
	}

	public EntityIterator<IMessage> load(String domainKey) throws StorageException {
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

	public void delete(String domainKey, String specId, String id) throws StorageException {
		impl.delete(domainKey, specId, id);
	}

	public void delete(String domainKey, String specId) throws StorageException {
		impl.delete(domainKey, specId);
	}

	public long count(String domainKey, String specId) throws StorageException {
		return impl.count(domainKey, specId);
	}

	public Collection<IMessage> list(String domainKey, String specId, int page, int pageSize) throws StorageException {
		return impl.list(domainKey, specId, page, pageSize);
	}

	public Collection<IMessage> listNext(String domainKey, String specId, String id, int page, int pageSize) throws StorageException {
		return impl.listNext(domainKey, specId, id, page, pageSize);
	}

	public Collection<IMessage> search(String domainKey, String specId, String query, int pageSize) throws StorageException {
		return impl.search(domainKey, specId, query, pageSize);
	}

	public void delete() throws StorageException {
		impl.delete();
	}

}
