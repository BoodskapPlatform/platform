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

import io.boodskap.iot.PropertyTarget;
import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.dao.PropertyDAO;
import io.boodskap.iot.model.IProperty;

public class PropertyDAOImpl implements PropertyDAO<IProperty> {

	private final PropertyDAO<IProperty> impl;

	public PropertyDAOImpl(final PropertyDAO<IProperty> impl) {
		this.impl = impl;
	}

	public IProperty create(String domainKey, PropertyTarget target, String targetId, String name) throws StorageException {
		return impl.create(domainKey, target, targetId, name);
	}

	public Class<? extends IProperty> clazz() {
		return impl.clazz();
	}

	public void createOrUpdate(IProperty e) throws StorageException {
		impl.createOrUpdate(e);
	}

	public EntityIterator<IProperty> load() throws StorageException {
		return impl.load();
	}

	public EntityIterator<IProperty> load(String domainKey) throws StorageException {
		return impl.load(domainKey);
	}

	public long count() throws StorageException {
		return impl.count();
	}

	public long count(String domainKey) throws StorageException {
		return impl.count(domainKey);
	}

	public void delete(String domainKey, PropertyTarget target, String targetId) throws StorageException {
		impl.delete(domainKey, target, targetId);
	}

	public void delete(String domainKey) throws StorageException {
		impl.delete(domainKey);
	}

	public void delete(String domainKey, PropertyTarget target, String targetId, String name) throws StorageException {
		impl.delete(domainKey, target, targetId, name);
	}

	public IProperty get(String domainKey, PropertyTarget target, String targetId, String name) throws StorageException {
		return impl.get(domainKey, target, targetId, name);
	}

	public long count(String domainKey, PropertyTarget target) throws StorageException {
		return impl.count(domainKey, target);
	}

	public long count(String domainKey, PropertyTarget target, String targetId) throws StorageException {
		return impl.count(domainKey, target, targetId);
	}

	public Collection<IProperty> list(String domainKey, PropertyTarget target, String targetId, int page, int pageSize) throws StorageException {
		return impl.list(domainKey, target, targetId, page, pageSize);
	}

	public Collection<IProperty> listNext(String domainKey, PropertyTarget target, String targetId, String name, int page, int pageSize) throws StorageException {
		return impl.listNext(domainKey, target, targetId, name, page, pageSize);
	}

	public Collection<IProperty> search(String domainKey, PropertyTarget target, String targetId, String query, int pageSize) throws StorageException {
		return impl.search(domainKey, target, targetId, query, pageSize);
	}

	public void delete() throws StorageException {
		impl.delete();
	}

}
