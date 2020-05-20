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
import io.boodskap.iot.dao.OutgoingSmsDAO;
import io.boodskap.iot.model.IOutgoingSms;

public class OutgoingSmsDAOImpl implements OutgoingSmsDAO<IOutgoingSms> {

	private final OutgoingSmsDAO<IOutgoingSms> impl;

	public OutgoingSmsDAOImpl(final OutgoingSmsDAO<IOutgoingSms> impl) {
		this.impl = impl;
	}

	public IOutgoingSms create(String domainKey, String notificationId) throws StorageException {
		return impl.create(domainKey, notificationId);
	}

	public Class<? extends IOutgoingSms> clazz() {
		return impl.clazz();
	}

	public void createOrUpdate(IOutgoingSms e) throws StorageException {
		impl.createOrUpdate(e);
	}

	public EntityIterator<IOutgoingSms> load() throws StorageException {
		return impl.load();
	}

	public EntityIterator<IOutgoingSms> load(String domainKey) throws StorageException {
		return impl.load(domainKey);
	}

	public long count() throws StorageException {
		return impl.count();
	}

	public long count(String domainKey) throws StorageException {
		return impl.count(domainKey);
	}

	public EntityIterator<String> loadIds() throws StorageException {
		return impl.loadIds();
	}

	public void delete(String domainKey) throws StorageException {
		impl.delete(domainKey);
	}

	public IOutgoingSms get(String id) throws StorageException {
		return impl.get(id);
	}

	public IOutgoingSms get(String domainKey, String id) throws StorageException {
		return impl.get(domainKey, id);
	}

	public void delete(String domainKey, String id) throws StorageException {
		impl.delete(domainKey, id);
	}

	public Collection<IOutgoingSms> list(String domainKey, int page, int pageSize) throws StorageException {
		return impl.list(domainKey, page, pageSize);
	}

	public Collection<IOutgoingSms> listNext(String domainKey, String id, int page, int pageSize) throws StorageException {
		return impl.listNext(domainKey, id, page, pageSize);
	}

	public void delete() throws StorageException {
		impl.delete();
	}

}
