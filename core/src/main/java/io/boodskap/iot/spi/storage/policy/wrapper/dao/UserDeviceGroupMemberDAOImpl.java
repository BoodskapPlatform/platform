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
import io.boodskap.iot.dao.UserDeviceGroupMemberDAO;
import io.boodskap.iot.model.IUserDeviceGroupMember;

public class UserDeviceGroupMemberDAOImpl implements UserDeviceGroupMemberDAO<IUserDeviceGroupMember> {

	private final UserDeviceGroupMemberDAO<IUserDeviceGroupMember> impl;

	public UserDeviceGroupMemberDAOImpl(final UserDeviceGroupMemberDAO<IUserDeviceGroupMember> impl) {
		this.impl = impl;
	}

	public IUserDeviceGroupMember create(String domainKey, String ownerUserId, String groupId, String memberDeviceId) throws StorageException {
		return impl.create(domainKey, ownerUserId, groupId, memberDeviceId);
	}

	public Class<? extends IUserDeviceGroupMember> clazz() {
		return impl.clazz();
	}

	public void createOrUpdate(IUserDeviceGroupMember e) throws StorageException {
		impl.createOrUpdate(e);
	}

	public EntityIterator<IUserDeviceGroupMember> load() throws StorageException {
		return impl.load();
	}

	public EntityIterator<IUserDeviceGroupMember> load(String domainKey) throws StorageException {
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

	public long count(String domainKey, String ownerUserId, String groupId) throws StorageException {
		return impl.count(domainKey, ownerUserId, groupId);
	}

	public IUserDeviceGroupMember get(String domainKey, String ownerUserId, String groupId, String memberDeviceId) throws StorageException {
		return impl.get(domainKey, ownerUserId, groupId, memberDeviceId);
	}

	public void delete(String domainKey, String ownerUserId) throws StorageException {
		impl.delete(domainKey, ownerUserId);
	}

	public void delete(String domainKey, String ownerUserId, String groupId) throws StorageException {
		impl.delete(domainKey, ownerUserId, groupId);
	}

	public void delete(String domainKey, String ownerUserId, String groupId, String memberDeviceId) throws StorageException {
		impl.delete(domainKey, ownerUserId, groupId, memberDeviceId);
	}

	public EntityIterator<String> iterateMembers(String domainKey, String ownerUserId, String groupId) throws StorageException {
		return impl.iterateMembers(domainKey, ownerUserId, groupId);
	}

	public Collection<IUserDeviceGroupMember> list(String domainKey, String ownerUserId, String groupId, int page, int pageSize) throws StorageException {
		return impl.list(domainKey, ownerUserId, groupId, page, pageSize);
	}

	public Collection<IUserDeviceGroupMember> listNext(String domainKey, String ownerUserId, String groupId, String memberDeviceId, int page, int pageSize) throws StorageException {
		return impl.listNext(domainKey, ownerUserId, groupId, memberDeviceId, page, pageSize);
	}

	public Collection<IUserDeviceGroupMember> search(String domainKey, String ownerUserId, String groupId, String query, int pageSize) throws StorageException {
		return impl.search(domainKey, ownerUserId, groupId, query, pageSize);
	}

	public void delete() throws StorageException {
		impl.delete();
	}

}
