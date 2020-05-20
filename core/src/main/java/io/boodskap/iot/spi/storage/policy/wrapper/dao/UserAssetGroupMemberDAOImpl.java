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
import io.boodskap.iot.dao.UserAssetGroupMemberDAO;
import io.boodskap.iot.model.IUserAssetGroupMember;

public class UserAssetGroupMemberDAOImpl implements UserAssetGroupMemberDAO<IUserAssetGroupMember> {

	private final UserAssetGroupMemberDAO<IUserAssetGroupMember> impl;

	public UserAssetGroupMemberDAOImpl(final UserAssetGroupMemberDAO<IUserAssetGroupMember> impl) {
		this.impl = impl;
	}

	public IUserAssetGroupMember create(String domainKey, String ownerUserId, String groupId, String memberAssetId) throws StorageException {
		return impl.create(domainKey, ownerUserId, groupId, memberAssetId);
	}

	public Class<? extends IUserAssetGroupMember> clazz() {
		return impl.clazz();
	}

	public void createOrUpdate(IUserAssetGroupMember e) throws StorageException {
		impl.createOrUpdate(e);
	}

	public EntityIterator<IUserAssetGroupMember> load() throws StorageException {
		return impl.load();
	}

	public EntityIterator<IUserAssetGroupMember> load(String domainKey) throws StorageException {
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

	public IUserAssetGroupMember get(String domainKey, String ownerUserId, String groupId, String memberAssetId) throws StorageException {
		return impl.get(domainKey, ownerUserId, groupId, memberAssetId);
	}

	public void delete(String domainKey, String ownerUserId, String groupId) throws StorageException {
		impl.delete(domainKey, ownerUserId, groupId);
	}

	public void delete(String domainKey, String ownerUserId) throws StorageException {
		impl.delete(domainKey, ownerUserId);
	}

	public void delete(String domainKey, String ownerUserId, String groupId, String memberAssetId) throws StorageException {
		impl.delete(domainKey, ownerUserId, groupId, memberAssetId);
	}

	public long count(String domainKey, String ownerUserId, String groupId) throws StorageException {
		return impl.count(domainKey, ownerUserId, groupId);
	}

	public EntityIterator<String> iterateMembers(String domainKey, String ownerUserId, String groupId) throws StorageException {
		return impl.iterateMembers(domainKey, ownerUserId, groupId);
	}

	public Collection<IUserAssetGroupMember> list(String domainKey, String ownerUserId, String groupId, int page, int pageSize) throws StorageException {
		return impl.list(domainKey, ownerUserId, groupId, page, pageSize);
	}

	public Collection<IUserAssetGroupMember> listNext(String domainKey, String ownerUserId, String groupId, String memberAssetId, int page, int pageSize) throws StorageException {
		return impl.listNext(domainKey, ownerUserId, groupId, memberAssetId, page, pageSize);
	}

	public Collection<IUserAssetGroupMember> search(String domainKey, String ownerUserId, String groupId, String query, int pageSize) throws StorageException {
		return impl.search(domainKey, ownerUserId, groupId, query, pageSize);
	}

	public void delete() throws StorageException {
		impl.delete();
	}

}
