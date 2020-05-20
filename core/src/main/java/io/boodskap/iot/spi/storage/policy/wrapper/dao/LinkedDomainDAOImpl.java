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
import io.boodskap.iot.dao.LinkedDomainDAO;
import io.boodskap.iot.model.ILinkedDomain;

public class LinkedDomainDAOImpl implements LinkedDomainDAO<ILinkedDomain> {

	private final LinkedDomainDAO<ILinkedDomain> impl;

	public LinkedDomainDAOImpl(final LinkedDomainDAO<ILinkedDomain> impl) {
		this.impl = impl;
	}

	public ILinkedDomain create(String domainKey, String linkedDomainKey, String linkedApiKey) throws StorageException {
		return impl.create(domainKey, linkedDomainKey, linkedApiKey);
	}

	public Class<? extends ILinkedDomain> clazz() {
		return impl.clazz();
	}

	public void createOrUpdate(ILinkedDomain e) throws StorageException {
		impl.createOrUpdate(e);
	}

	public EntityIterator<ILinkedDomain> load() throws StorageException {
		return impl.load();
	}

	public EntityIterator<ILinkedDomain> load(String domainKey) throws StorageException {
		return impl.load(domainKey);
	}

	public long count() throws StorageException {
		return impl.count();
	}

	public long count(String domainKey) throws StorageException {
		return impl.count(domainKey);
	}

	public ILinkedDomain get(String domainKey, String linkedDomainKey, String linkedApiKey) throws StorageException {
		return impl.get(domainKey, linkedDomainKey, linkedApiKey);
	}

	public void delete(String domainKey) throws StorageException {
		impl.delete(domainKey);
	}

	public long count(String domainKey, String linkedDomainKey) throws StorageException {
		return impl.count(domainKey, linkedDomainKey);
	}

	public long countLinked(String linkedDomainKey) throws StorageException {
		return impl.countLinked(linkedDomainKey);
	}

	public void setState(String domainKey, String linkedDomainKey, boolean state) throws StorageException {
		impl.setState(domainKey, linkedDomainKey, state);
	}

	public void setState(String domainKey, String linkedDomainKey, String linkedApiKey, boolean state) throws StorageException {
		impl.setState(domainKey, linkedDomainKey, linkedApiKey, state);
	}

	public void delete(String domainKey, String linkedDomainKey) throws StorageException {
		impl.delete(domainKey, linkedDomainKey);
	}

	public void delete(String domainKey, String linkedDomainKey, String linkedApiKey) throws StorageException {
		impl.delete(domainKey, linkedDomainKey, linkedApiKey);
	}

	public Collection<ILinkedDomain> list(String linkedDomainKey, int page, int pageSize) throws StorageException {
		return impl.list(linkedDomainKey, page, pageSize);
	}

	public Collection<ILinkedDomain> listNext(String linkedDomainKey, String domainKey, int page, int pageSize) throws StorageException {
		return impl.listNext(linkedDomainKey, domainKey, page, pageSize);
	}

	public Collection<ILinkedDomain> listLinked(String domainKey, int page, int pageSize) throws StorageException {
		return impl.listLinked(domainKey, page, pageSize);
	}

	public Collection<ILinkedDomain> listLinkedNext(String domainKey, String linkedDomainKey, int page, int pageSize) throws StorageException {
		return impl.listLinkedNext(domainKey, linkedDomainKey, page, pageSize);
	}

	public void delete() throws StorageException {
		impl.delete();
	}

}
