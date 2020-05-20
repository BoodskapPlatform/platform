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
import io.boodskap.iot.dao.DomainDeviceGroupMemberDAO;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.model.IDomainDeviceGroupMember;

public class DomainDeviceGroupMemberDAOImpl implements DomainDeviceGroupMemberDAO<IDomainDeviceGroupMember> {

	private final DomainDeviceGroupMemberDAO<IDomainDeviceGroupMember> impl;

	public DomainDeviceGroupMemberDAOImpl(final DomainDeviceGroupMemberDAO<IDomainDeviceGroupMember> impl) {
		this.impl = impl;
	}

	public Class<? extends IDomainDeviceGroupMember> clazz() {
		return impl.clazz();
	}

	public void createOrUpdate(IDomainDeviceGroupMember e) throws StorageException {
		impl.createOrUpdate(e);
	}

	public EntityIterator<IDomainDeviceGroupMember> load() throws StorageException {
		return impl.load();
	}

	public EntityIterator<IDomainDeviceGroupMember> load(String domainKey) throws StorageException {
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

	public IDomainDeviceGroupMember create(String domainKey, String groupId, String deviceId) throws StorageException {
		return impl.create(domainKey, groupId, deviceId);
	}

	public IDomainDeviceGroupMember get(String domainKey, String groupId, String deviceId) throws StorageException {
		return impl.get(domainKey, groupId, deviceId);
	}

	public void delete(String domainKey, String groupId) throws StorageException {
		impl.delete(domainKey, groupId);
	}

	public void delete(String domainKey, String groupId, String deviceId) throws StorageException {
		impl.delete(domainKey, groupId, deviceId);
	}

	public long count(String domainKey, String groupId) throws StorageException {
		return impl.count(domainKey, groupId);
	}

	public EntityIterator<String> iterateMembers(String domainKey, String groupId) throws StorageException {
		return impl.iterateMembers(domainKey, groupId);
	}

	public Collection<IDomainDeviceGroupMember> list(String domainKey, String groupId, int page, int pageSize)
			throws StorageException {
		return impl.list(domainKey, groupId, page, pageSize);
	}

	public Collection<IDomainDeviceGroupMember> listNext(String domainKey, String groupId, String deviceId, int page,
			int pageSize) throws StorageException {
		return impl.listNext(domainKey, groupId, deviceId, page, pageSize);
	}

	public Collection<IDomainDeviceGroupMember> search(String domainKey, String groupId, String query, int pageSize)
			throws StorageException {
		return impl.search(domainKey, groupId, query, pageSize);
	}

	public void delete() throws StorageException {
		impl.delete();
	}

}
