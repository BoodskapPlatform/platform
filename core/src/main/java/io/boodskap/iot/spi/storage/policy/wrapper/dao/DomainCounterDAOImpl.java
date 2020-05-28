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
import io.boodskap.iot.dao.DomainCounterDAO;
import io.boodskap.iot.model.IDomainCounter;

public class DomainCounterDAOImpl implements DomainCounterDAO<IDomainCounter> {

	private final DomainCounterDAO<IDomainCounter> impl;

	public DomainCounterDAOImpl(final DomainCounterDAO<IDomainCounter> impl) {
		this.impl = impl;
	}

	public Class<? extends IDomainCounter> clazz() {
		return impl.clazz();
	}

	public IDomainCounter create(String domainKey) {
		return impl.create(domainKey);
	}

	public void init() throws StorageException {
		impl.init();
	}

	public IDomainCounter find(String domainKey) throws StorageException {
		return impl.find(domainKey);
	}

	public void incrementUsers(String domainKey) throws StorageException {
		impl.incrementUsers(domainKey);
	}

	public void incrementDevices(String domainKey) throws StorageException {
		impl.incrementDevices(domainKey);
	}

	public void incrementUdp(String domainKey) throws StorageException {
		impl.incrementUdp(domainKey);
	}

	public void incrementLoRa(String domainKey) throws StorageException {
		impl.incrementLoRa(domainKey);
	}

	public void incrementMqtt(String domainKey) throws StorageException {
		impl.incrementMqtt(domainKey);
	}

	public void incrementHttp(String domainKey) throws StorageException {
		impl.incrementHttp(domainKey);
	}

	public void incrementFcm(String domainKey) throws StorageException {
		impl.incrementFcm(domainKey);
	}

	public void incrementCoAP(String domainKey) throws StorageException {
		impl.incrementCoAP(domainKey);
	}

	public void incrementTcp(String domainKey) throws StorageException {
		impl.incrementTcp(domainKey);
	}

	public void incrementCommands(String domainKey) throws StorageException {
		impl.incrementCommands(domainKey);
	}

	public void incrementRecords(String domainKey) throws StorageException {
		impl.incrementRecords(domainKey);
	}

}
