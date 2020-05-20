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
import io.boodskap.iot.dao.UserGroupMemberDAO;
import io.boodskap.iot.model.IUserGroupMember;

public class UserGroupMemberDAOImpl implements UserGroupMemberDAO<IUserGroupMember> {

	private final UserGroupMemberDAO<IUserGroupMember> impl;

	public UserGroupMemberDAOImpl(final UserGroupMemberDAO<IUserGroupMember> impl) {
		this.impl = impl;
	}

	public IUserGroupMember create(String domainKey, String ownerUserId, String groupId, String memberUserId) throws StorageException {
		return impl.create(domainKey, ownerUserId, groupId, memberUserId);
	}

	public Class<? extends IUserGroupMember> clazz() {
		return impl.clazz();
	}

	public void createOrUpdate(IUserGroupMember e) throws StorageException {
		impl.createOrUpdate(e);
	}

	public EntityIterator<IUserGroupMember> load() throws StorageException {
		return impl.load();
	}

	public EntityIterator<IUserGroupMember> load(String domainKey) throws StorageException {
		return impl.load(domainKey);
	}

	public long count() throws StorageException {
		return impl.count();
	}

	public long count(String domainKey) throws StorageException {
		return impl.count(domainKey);
	}

	public long count(String domainKey, String userId, String groupId) throws StorageException {
		return impl.count(domainKey, userId, groupId);
	}

	public void delete(String domainKey) throws StorageException {
		impl.delete(domainKey);
	}

	public IUserGroupMember get(String domainKey, String ownerUserId, String groupId, String memberUserId)throws StorageException {
		return impl.get(domainKey, ownerUserId, groupId, memberUserId);
	}

	public void delete(String domainKey, String ownerUserId) throws StorageException {
		impl.delete(domainKey, ownerUserId);
	}

	public void delete(String domainKey, String ownerUserId, String groupId) throws StorageException {
		impl.delete(domainKey, ownerUserId, groupId);
	}

	public void delete(String domainKey, String ownerUserId, String groupId, String memberUserId) throws StorageException {
		impl.delete(domainKey, ownerUserId, groupId, memberUserId);
	}

	public EntityIterator<String> iterateMembers(String domainKey, String ownerUserId, String groupId) throws StorageException {
		return impl.iterateMembers(domainKey, ownerUserId, groupId);
	}

	public Collection<IUserGroupMember> list(String domainKey, String ownerUserId, String groupId, int page, int pageSize) throws StorageException {
		return impl.list(domainKey, ownerUserId, groupId, page, pageSize);
	}

	public Collection<IUserGroupMember> listNext(String domainKey, String ownerUserId, String groupId, String memberUserId, int page, int pageSize) throws StorageException {
		return impl.listNext(domainKey, ownerUserId, groupId, memberUserId, page, pageSize);
	}

	public Collection<IUserGroupMember> search(String domainKey, String ownerUserId, String groupId, String query, int pageSize) throws StorageException {
		return impl.search(domainKey, ownerUserId, groupId, query, pageSize);
	}

	public void delete() throws StorageException {
		impl.delete();
	}

}
