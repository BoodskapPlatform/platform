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

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.dao.GlobalDataDAO;
import io.boodskap.iot.model.IGlobalData;

public class GlobalDataDAOImpl implements GlobalDataDAO<IGlobalData> {

	private final GlobalDataDAO<IGlobalData> impl;

	public GlobalDataDAOImpl(final GlobalDataDAO<IGlobalData> impl) {
		this.impl = impl;
	}

	public IGlobalData create(String id, String domainKey) throws StorageException {
		return impl.create(id, domainKey);
	}

	public Class<? extends IGlobalData> clazz() {
		return impl.clazz();
	}

	public void createOrUpdate(IGlobalData e) throws StorageException {
		impl.createOrUpdate(e);
	}

	public EntityIterator<IGlobalData> load() throws StorageException {
		return impl.load();
	}

	public EntityIterator<IGlobalData> load(String domainKey) throws StorageException {
		return impl.load(domainKey);
	}

	public long count() throws StorageException {
		return impl.count();
	}

	public IGlobalData get(String id) throws StorageException {
		return impl.get(id);
	}

	public long count(String domainKey) throws StorageException {
		return impl.count(domainKey);
	}

	public IGlobalData get(String id, String domainKey) throws StorageException {
		return impl.get(id, domainKey);
	}

	public void delete(String domainKey) throws StorageException {
		impl.delete(domainKey);
	}

	public void delete(String id, String domainKey) throws StorageException {
		impl.delete(id, domainKey);
	}

	public void delete() throws StorageException {
		impl.delete();
	}

}
