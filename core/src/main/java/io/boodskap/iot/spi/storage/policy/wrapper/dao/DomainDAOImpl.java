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
import io.boodskap.iot.dao.DomainDAO;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.model.IDomain;

public class DomainDAOImpl implements DomainDAO<IDomain> {

	private final DomainDAO<IDomain> impl;

	public DomainDAOImpl(final DomainDAO<IDomain> impl) {
		this.impl = impl;
	}

	public Class<? extends IDomain> clazz() {
		return impl.clazz();
	}

	public void createOrUpdate(IDomain e) throws StorageException {
		impl.createOrUpdate(e);
	}

	public EntityIterator<IDomain> load() throws StorageException {
		return impl.load();
	}

	public EntityIterator<IDomain> load(String domainKey) throws StorageException {
		return impl.load(domainKey);
	}

	public long count() throws StorageException {
		return impl.count();
	}

	public IDomain create(String domainKey) throws StorageException {
		return impl.create(domainKey);
	}

	public long count(String domainKey) throws StorageException {
		return impl.count(domainKey);
	}

	public IDomain get(String domainKey) throws StorageException {
		return impl.get(domainKey);
	}

	public void delete(String domainKey) throws StorageException {
		impl.delete(domainKey);
	}

	public void delete() throws StorageException {
		impl.delete();
	}

	public Collection<IDomain> list(int page, int pageSize) throws StorageException {
		return impl.list(page, pageSize);
	}

	public Collection<IDomain> listNext(String domainKey, int page, int pageSize) throws StorageException {
		return impl.listNext(domainKey, page, pageSize);
	}

	public Collection<IDomain> search(String query, int pageSize) throws StorageException {
		return impl.search(query, pageSize);
	}

}
