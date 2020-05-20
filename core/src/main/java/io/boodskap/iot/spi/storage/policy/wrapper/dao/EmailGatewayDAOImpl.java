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
import io.boodskap.iot.dao.EmailGatewayDAO;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.model.IEmailGateway;

public class EmailGatewayDAOImpl implements EmailGatewayDAO<IEmailGateway> {

	private final EmailGatewayDAO<IEmailGateway> impl;

	public EmailGatewayDAOImpl(final EmailGatewayDAO<IEmailGateway> impl) {
		this.impl = impl;
	}

	public IEmailGateway create(String domainKey) throws StorageException {
		return impl.create(domainKey);
	}

	public Class<? extends IEmailGateway> clazz() {
		return impl.clazz();
	}

	public void createOrUpdate(IEmailGateway e) throws StorageException {
		impl.createOrUpdate(e);
	}

	public EntityIterator<IEmailGateway> load() throws StorageException {
		return impl.load();
	}

	public EntityIterator<IEmailGateway> load(String domainKey) throws StorageException {
		return impl.load(domainKey);
	}

	public long count() throws StorageException {
		return impl.count();
	}

	public IEmailGateway get(String domainKey) throws StorageException {
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
