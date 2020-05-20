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
import io.boodskap.iot.dao.DomainAssetGroupDAO;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.model.IDomainAssetGroup;

public class DomainAssetGroupDAOImpl implements DomainAssetGroupDAO<IDomainAssetGroup> {

	private final DomainAssetGroupDAO<IDomainAssetGroup> impl;

	public DomainAssetGroupDAOImpl(final DomainAssetGroupDAO<IDomainAssetGroup> impl) {
		this.impl = impl;
	}

	public Class<? extends IDomainAssetGroup> clazz() {
		return impl.clazz();
	}

	public void createOrUpdate(IDomainAssetGroup e) throws StorageException {
		impl.createOrUpdate(e);
	}

	public EntityIterator<IDomainAssetGroup> load() throws StorageException {
		return impl.load();
	}

	public EntityIterator<IDomainAssetGroup> load(String domainKey) throws StorageException {
		return impl.load(domainKey);
	}

	public long count() throws StorageException {
		return impl.count();
	}

	public long count(String domainKey) throws StorageException {
		return impl.count(domainKey);
	}

	public IDomainAssetGroup create(String domainKey, String groupId) throws StorageException {
		return impl.create(domainKey, groupId);
	}

	public void delete(String domainKey) throws StorageException {
		impl.delete(domainKey);
	}

	public IDomainAssetGroup get(String domainKey, String groupId) throws StorageException {
		return impl.get(domainKey, groupId);
	}

	public void delete(String domainKey, String groupId) throws StorageException {
		impl.delete(domainKey, groupId);
	}

	public Collection<IDomainAssetGroup> list(String domainKey, int page, int pageSize) throws StorageException {
		return impl.list(domainKey, page, pageSize);
	}

	public Collection<IDomainAssetGroup> listNext(String domainKey, String groupId, int page, int pageSize)
			throws StorageException {
		return impl.listNext(domainKey, groupId, page, pageSize);
	}

	public Collection<IDomainAssetGroup> search(String domainKey, String query, int pageSize) throws StorageException {
		return impl.search(domainKey, query, pageSize);
	}

	public void delete() throws StorageException {
		impl.delete();
	}

}
