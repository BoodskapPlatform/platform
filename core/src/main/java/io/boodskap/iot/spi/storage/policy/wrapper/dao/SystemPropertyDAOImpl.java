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
import io.boodskap.iot.dao.SystemPropertyDAO;
import io.boodskap.iot.model.ISystemProperty;

public class SystemPropertyDAOImpl implements SystemPropertyDAO<ISystemProperty> {

	private final SystemPropertyDAO<ISystemProperty> impl;

	public SystemPropertyDAOImpl(final SystemPropertyDAO<ISystemProperty> impl) {
		this.impl = impl;
	}

	public ISystemProperty create(String name) {
		return impl.create(name);
	}

	public Class<? extends ISystemProperty> clazz() {
		return impl.clazz();
	}

	public void createOrUpdate(ISystemProperty e) throws StorageException {
		impl.createOrUpdate(e);
	}

	public EntityIterator<ISystemProperty> load() throws StorageException {
		return impl.load();
	}

	public long count() throws StorageException {
		return impl.count();
	}

	public void delete() throws StorageException {
		impl.delete();
	}

	public void delete(String name) throws StorageException {
		impl.delete(name);
	}

	public ISystemProperty get(String name) throws StorageException {
		return impl.get(name);
	}

	public Collection<ISystemProperty> list(int page, int pageSize) throws StorageException {
		return impl.list(page, pageSize);
	}

	public Collection<ISystemProperty> listNext(String name, int page, int pageSize) throws StorageException {
		return impl.listNext(name, page, pageSize);
	}

	public Collection<ISystemProperty> search(String query, int pageSize) throws StorageException {
		return impl.search(query, pageSize);
	}

}
