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
import io.boodskap.iot.dao.DomainAssetGroupMemberDAO;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.model.IDomainAssetGroupMember;

public class DomainAssetGroupMemberDAOImpl implements DomainAssetGroupMemberDAO<IDomainAssetGroupMember> {

	private final DomainAssetGroupMemberDAO<IDomainAssetGroupMember> impl;

	public DomainAssetGroupMemberDAOImpl(final DomainAssetGroupMemberDAO<IDomainAssetGroupMember> impl) {
		this.impl = impl;
	}

	public Class<? extends IDomainAssetGroupMember> clazz() {
		return impl.clazz();
	}

	public void createOrUpdate(IDomainAssetGroupMember e) throws StorageException {
		impl.createOrUpdate(e);
	}

	public EntityIterator<IDomainAssetGroupMember> load() throws StorageException {
		return impl.load();
	}

	public EntityIterator<IDomainAssetGroupMember> load(String domainKey) throws StorageException {
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

	public IDomainAssetGroupMember create(String domainKey, String groupId, String assetId) {
		return impl.create(domainKey, groupId, assetId);
	}

	public IDomainAssetGroupMember get(String domainKey, String groupId, String assetId) {
		return impl.get(domainKey, groupId, assetId);
	}

	public void delete(String domainKey, String groupId) throws StorageException {
		impl.delete(domainKey, groupId);
	}

	public void delete(String domainKey, String groupId, String assetId) throws StorageException {
		impl.delete(domainKey, groupId, assetId);
	}

	public long count(String domainKey, String groupId) throws StorageException {
		return impl.count(domainKey, groupId);
	}

	public EntityIterator<? extends String> iterateMembers(String domainKey, String groupId) throws StorageException {
		return impl.iterateMembers(domainKey, groupId);
	}

	public Collection<IDomainAssetGroupMember> list(String domainKey, String groupId, int page, int pageSize)
			throws StorageException {
		return impl.list(domainKey, groupId, page, pageSize);
	}

	public Collection<IDomainAssetGroupMember> listNext(String domainKey, String groupId, String assetId, int page,
			int pageSize) throws StorageException {
		return impl.listNext(domainKey, groupId, assetId, page, pageSize);
	}

	public Collection<IDomainAssetGroupMember> search(String domainKey, String groupId, String query, int pageSize)
			throws StorageException {
		return impl.search(domainKey, groupId, query, pageSize);
	}

	public void delete() throws StorageException {
		impl.delete();
	}

}
