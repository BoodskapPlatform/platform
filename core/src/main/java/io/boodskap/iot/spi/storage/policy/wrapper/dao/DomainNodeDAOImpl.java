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
import io.boodskap.iot.dao.DomainNodeDAO;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.model.IDomainNode;

public class DomainNodeDAOImpl implements DomainNodeDAO<IDomainNode> {

	private final DomainNodeDAO<IDomainNode> impl;

	public DomainNodeDAOImpl(final DomainNodeDAO<IDomainNode> impl) {
		this.impl = impl;
	}

	public IDomainNode create(String domainKey, String nodeId) throws StorageException {
		return impl.create(domainKey, nodeId);
	}

	public Class<? extends IDomainNode> clazz() {
		return impl.clazz();
	}

	public void createOrUpdate(IDomainNode e) throws StorageException {
		impl.createOrUpdate(e);
	}

	public EntityIterator<IDomainNode> load() throws StorageException {
		return impl.load();
	}

	public EntityIterator<IDomainNode> load(String domainKey) throws StorageException {
		return impl.load(domainKey);
	}

	public long count() throws StorageException {
		return impl.count();
	}

	public long count(String domainKey) throws StorageException {
		return impl.count(domainKey);
	}

	public boolean hasDomain(String domainKey) throws StorageException {
		return impl.hasDomain(domainKey);
	}

	public void delete(String domainKey) throws StorageException {
		impl.delete(domainKey);
	}

	public IDomainNode get(String domainKey, String nodeId) throws StorageException {
		return impl.get(domainKey, nodeId);
	}

	public void delete(String domainKey, String nodeId) throws StorageException {
		impl.delete(domainKey, nodeId);
	}

	public EntityIterator<IDomainNode> loadByNodeId(String nodeId) throws StorageException {
		return impl.loadByNodeId(nodeId);
	}

	public Collection<IDomainNode> list(String nodeId, int page, int pageSize) throws StorageException {
		return impl.list(nodeId, page, pageSize);
	}

	public Collection<IDomainNode> listNext(String nodeId, String domainKey, int page, int pageSize) throws StorageException {
		return impl.listNext(nodeId, domainKey, page, pageSize);
	}

	public void delete() throws StorageException {
		impl.delete();
	}

}
