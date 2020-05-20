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
import io.boodskap.iot.dao.UserAssetGroupDAO;
import io.boodskap.iot.model.IUserAssetGroup;

public class UserAssetGroupDAOImpl implements UserAssetGroupDAO<IUserAssetGroup> {

	private final UserAssetGroupDAO<IUserAssetGroup> impl;

	public UserAssetGroupDAOImpl(final UserAssetGroupDAO<IUserAssetGroup> impl) {
		this.impl = impl;
	}

	public IUserAssetGroup create(String domainKey, String ownerUserId, String groupId) throws StorageException {
		return impl.create(domainKey, ownerUserId, groupId);
	}

	public Class<? extends IUserAssetGroup> clazz() {
		return impl.clazz();
	}

	public void createOrUpdate(IUserAssetGroup e) throws StorageException {
		impl.createOrUpdate(e);
	}

	public EntityIterator<IUserAssetGroup> load() throws StorageException {
		return impl.load();
	}

	public EntityIterator<IUserAssetGroup> load(String domainKey) throws StorageException {
		return impl.load(domainKey);
	}

	public long count() throws StorageException {
		return impl.count();
	}

	public long count(String domainKey) throws StorageException {
		return impl.count(domainKey);
	}

	public IUserAssetGroup get(String domainKey, String ownerUserId, String groupId) throws StorageException {
		return impl.get(domainKey, ownerUserId, groupId);
	}

	public void delete(String domainKey) throws StorageException {
		impl.delete(domainKey);
	}

	public void delete(String domainKey, String ownerUserId, String groupId) throws StorageException {
		impl.delete(domainKey, ownerUserId, groupId);
	}

	public void delete(String domainKey, String ownerUserId) throws StorageException {
		impl.delete(domainKey, ownerUserId);
	}

	public long count(String domainKey, String ownerUserId) throws StorageException {
		return impl.count(domainKey, ownerUserId);
	}

	public Collection<IUserAssetGroup> list(String domainKey, String ownerUserId, int page, int pageSize) throws StorageException {
		return impl.list(domainKey, ownerUserId, page, pageSize);
	}

	public Collection<IUserAssetGroup> listNext(String domainKey, String ownerUserId, String groupId, int page, int pageSize) throws StorageException {
		return impl.listNext(domainKey, ownerUserId, groupId, page, pageSize);
	}

	public Collection<IUserAssetGroup> search(String domainKey, String ownerUserId, String query, int pageSize) throws StorageException {
		return impl.search(domainKey, ownerUserId, query, pageSize);
	}

	public void delete() throws StorageException {
		impl.delete();
	}

}
