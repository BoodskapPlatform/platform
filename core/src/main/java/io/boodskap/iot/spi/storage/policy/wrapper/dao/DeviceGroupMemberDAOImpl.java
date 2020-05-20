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
import io.boodskap.iot.dao.DeviceGroupMemberDAO;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.model.IDeviceGroupMember;

public class DeviceGroupMemberDAOImpl implements DeviceGroupMemberDAO<IDeviceGroupMember> {

	private final DeviceGroupMemberDAO<IDeviceGroupMember> impl;

	public DeviceGroupMemberDAOImpl(final DeviceGroupMemberDAO<IDeviceGroupMember> impl) {
		this.impl = impl;
	}

	public Class<? extends IDeviceGroupMember> clazz() {
		return impl.clazz();
	}

	public void createOrUpdate(IDeviceGroupMember e) throws StorageException {
		impl.createOrUpdate(e);
	}

	public EntityIterator<IDeviceGroupMember> load() throws StorageException {
		return impl.load();
	}

	public EntityIterator<IDeviceGroupMember> load(String domainKey) throws StorageException {
		return impl.load(domainKey);
	}

	public long count() throws StorageException {
		return impl.count();
	}

	public long count(String domainKey) throws StorageException {
		return impl.count(domainKey);
	}

	public IDeviceGroupMember get(String domainKey, String ownerDeviceId, String groupId, String memberId)
			throws StorageException {
		return impl.get(domainKey, ownerDeviceId, groupId, memberId);
	}

	public void delete(String domainKey) throws StorageException {
		impl.delete(domainKey);
	}

	public void delete(String domainKey, String ownerDeviceId, String groupId) throws StorageException {
		impl.delete(domainKey, ownerDeviceId, groupId);
	}

	public void delete(String domainKey, String ownerDeviceId) throws StorageException {
		impl.delete(domainKey, ownerDeviceId);
	}

	public void delete(String domainKey, String ownerDeviceId, String groupId, String deviceId)
			throws StorageException {
		impl.delete(domainKey, ownerDeviceId, groupId, deviceId);
	}

	public long count(String domainKey, String ownerDeviceId, String groupId) throws StorageException {
		return impl.count(domainKey, ownerDeviceId, groupId);
	}

	public EntityIterator<String> iterateMembers(String domainKey, String ownerDeviceId, String groupId)
			throws StorageException {
		return impl.iterateMembers(domainKey, ownerDeviceId, groupId);
	}

	public Collection<IDeviceGroupMember> list(String domainKey, String ownerDeviceId, String groupId, int page,
			int pageSize) throws StorageException {
		return impl.list(domainKey, ownerDeviceId, groupId, page, pageSize);
	}

	public Collection<IDeviceGroupMember> listNext(String domainKey, String ownerDeviceId, String groupId,
			String deviceId, int page, int pageSize) throws StorageException {
		return impl.listNext(domainKey, ownerDeviceId, groupId, deviceId, page, pageSize);
	}

	public Collection<IDeviceGroupMember> search(String domainKey, String ownerDeviceId, String groupId, String query,
			int pageSize) throws StorageException {
		return impl.search(domainKey, ownerDeviceId, groupId, query, pageSize);
	}

	public IDeviceGroupMember create(String domainKey, String ownerDeviceId, String groupId, String memberId) {
		return impl.create(domainKey, ownerDeviceId, groupId, memberId);
	}

	public void delete() throws StorageException {
		impl.delete();
	}

}
