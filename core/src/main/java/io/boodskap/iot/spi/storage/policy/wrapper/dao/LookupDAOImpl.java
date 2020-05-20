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

import io.boodskap.iot.DataType;
import io.boodskap.iot.PropertyTarget;
import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.dao.LookupDAO;
import io.boodskap.iot.model.ILookup;

public class LookupDAOImpl implements LookupDAO<ILookup> {

	private final LookupDAO<ILookup> impl;

	public LookupDAOImpl(final LookupDAO<ILookup> impl) {
		this.impl = impl;
	}

	public ILookup create(String domainKey, PropertyTarget target, String targetId, String name) throws StorageException {
		return impl.create(domainKey, target, targetId, name);
	}

	public Class<? extends ILookup> clazz() {
		return impl.clazz();
	}

	public void createOrUpdate(ILookup e) throws StorageException {
		impl.createOrUpdate(e);
	}

	public EntityIterator<ILookup> load() throws StorageException {
		return impl.load();
	}

	public EntityIterator<ILookup> load(String domainKey) throws StorageException {
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

	public ILookup get(String domainKey, PropertyTarget target, String targetId, String name) throws StorageException {
		return impl.get(domainKey, target, targetId, name);
	}

	public long count(String domainKey, PropertyTarget target) throws StorageException {
		return impl.count(domainKey, target);
	}

	public void set(String domainKey, PropertyTarget target, String targetId, DataType type, String name, String value) throws StorageException {
		impl.set(domainKey, target, targetId, type, name, value);
	}

	public void delete(String domainKey, PropertyTarget target) throws StorageException {
		impl.delete(domainKey, target);
	}

	public void delete(String domainKey, PropertyTarget target, String targetId) throws StorageException {
		impl.delete(domainKey, target, targetId);
	}

	public void delete(String domainKey, PropertyTarget target, String targetId, String name) throws StorageException {
		impl.delete(domainKey, target, targetId, name);
	}

	public Collection<ILookup> list(String domainKey, PropertyTarget target, int page, int pageSize) throws StorageException {
		return impl.list(domainKey, target, page, pageSize);
	}

	public Collection<ILookup> listNext(String domainKey, PropertyTarget target, String name, int page, int pageSize) throws StorageException {
		return impl.listNext(domainKey, target, name, page, pageSize);
	}

	public Collection<ILookup> search(String domainKey, PropertyTarget target, String query, int pageSize) throws StorageException {
		return impl.search(domainKey, target, query, pageSize);
	}

	public void delete() throws StorageException {
		impl.delete();
	}

}
