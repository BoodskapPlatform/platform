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

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.dao.FCMGatewayDAO;
import io.boodskap.iot.model.IFCMGateway;

public class FCMGatewayDAOImpl implements FCMGatewayDAO<IFCMGateway> {

	private final FCMGatewayDAO<IFCMGateway> impl;

	public FCMGatewayDAOImpl(final FCMGatewayDAO<IFCMGateway> impl) {
		this.impl = impl;
	}

	public IFCMGateway create(String domainKey) throws StorageException {
		return impl.create(domainKey);
	}

	public Class<? extends IFCMGateway> clazz() {
		return impl.clazz();
	}

	public void createOrUpdate(IFCMGateway e) throws StorageException {
		impl.createOrUpdate(e);
	}

	public EntityIterator<IFCMGateway> load() throws StorageException {
		return impl.load();
	}

	public EntityIterator<IFCMGateway> load(String domainKey) throws StorageException {
		return impl.load(domainKey);
	}

	public long count() throws StorageException {
		return impl.count();
	}

	public IFCMGateway get(String domainKey) throws StorageException {
		return impl.get(domainKey);
	}

	public long count(String domainKey) throws StorageException {
		return impl.count(domainKey);
	}

	public void delete(String domainKey) throws StorageException {
		impl.delete(domainKey);
	}

	public void delete() throws StorageException {
		impl.delete();
	}

}
