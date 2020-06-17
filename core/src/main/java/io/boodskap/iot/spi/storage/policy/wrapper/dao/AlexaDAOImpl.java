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
import io.boodskap.iot.dao.AlexaDAO;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.model.IAlexa;
import io.boodskap.iot.spi.storage.policy.PolicyManager;

public class AlexaDAOImpl implements AlexaDAO<IAlexa>{
	
	private final AlexaDAO<IAlexa> impl;

	public AlexaDAOImpl(final AlexaDAO<IAlexa> impl) {
		this.impl = impl;
	}

	@Override
	public IAlexa create(String domainKey, String alexaId) {
		PolicyManager.checkWriteAccess(domainKey);
		return impl.create(domainKey, alexaId);
	}

	@Override
	public Class<? extends IAlexa> clazz() {
		return impl.clazz();
	}

	@Override
	public void createOrUpdate(IAlexa e) throws StorageException {
		PolicyManager.checkWriteAccess(e.getDomainKey());
		impl.createOrUpdate(e);
	}

	@Override
	public EntityIterator<IAlexa> load() throws StorageException {
		PolicyManager.checkAdminAccess();
		return impl.load();
	}

	@Override
	public EntityIterator<IAlexa> load(String domainKey) throws StorageException {
		PolicyManager.checkReadAccess(domainKey);
		return impl.load(domainKey);
	}

	@Override
	public long count() throws StorageException {
		PolicyManager.checkAdminAccess();
		return impl.count();
	}

	@Override
	public IAlexa get(String domainKey, String alexaId) throws StorageException {
		PolicyManager.checkReadAccess(domainKey);
		return impl.get(domainKey, alexaId);
	}

	@Override
	public long count(String domainKey) throws StorageException {
		PolicyManager.checkReadAccess(domainKey);
		return impl.count(domainKey);
	}

	@Override
	public void delete(String domainKey, String alexaId) throws StorageException {
		PolicyManager.checkDeleteAccess(domainKey);
		impl.delete(domainKey, alexaId);
	}

	@Override
	public void delete(String domainKey) throws StorageException {
		PolicyManager.checkDeleteAccess(domainKey);
		impl.delete(domainKey);
	}

	@Override
	public Collection<IAlexa> list(String domainKey, int page, int pageSize) throws StorageException {
		PolicyManager.checkReadAccess(domainKey);
		return impl.list(domainKey, page, pageSize);
	}

	@Override
	public Collection<IAlexa> listNext(String domainKey, String alexaId, int page, int pageSize) throws StorageException {
		PolicyManager.checkReadAccess(domainKey);
		return impl.listNext(domainKey, alexaId, page, pageSize);
	}

	@Override
	public Collection<IAlexa> search(String domainKey, String query, int pageSize) throws StorageException {
		PolicyManager.checkReadAccess(domainKey);
		return impl.search(domainKey, query, pageSize);
	}

	@Override
	public void delete() throws StorageException {
		PolicyManager.checkAdminAccess();
		impl.delete();
	}

}
