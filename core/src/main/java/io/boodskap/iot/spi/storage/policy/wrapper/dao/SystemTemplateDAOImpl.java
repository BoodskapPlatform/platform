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
import io.boodskap.iot.dao.SystemTemplateDAO;
import io.boodskap.iot.model.ISystemTemplate;

public class SystemTemplateDAOImpl implements SystemTemplateDAO<ISystemTemplate> {

	private final SystemTemplateDAO<ISystemTemplate> impl;

	public SystemTemplateDAOImpl(final SystemTemplateDAO<ISystemTemplate> impl) {
		this.impl = impl;
	}

	public ISystemTemplate create(String name) {
		return impl.create(name);
	}

	public void createOrUpdate(ISystemTemplate e) throws StorageException {
		impl.createOrUpdate(e);
	}

	public ISystemTemplate get(String name) throws StorageException {
		return impl.get(name);
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

	public EntityIterator<ISystemTemplate> load() throws StorageException {
		return impl.load();
	}

	public Collection<ISystemTemplate> list(boolean load, int page, int pageSize) throws StorageException {
		return impl.list(load, page, pageSize);
	}

	public Collection<ISystemTemplate> listNext(boolean load, String name, int page, int pageSize) throws StorageException {
		return impl.listNext(load, name, page, pageSize);
	}

	public Collection<ISystemTemplate> search(boolean load, String query, int pageSize) throws StorageException {
		return impl.search(load, query, pageSize);
	}

}
