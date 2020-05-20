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
import io.boodskap.iot.dao.CounterDAO;
import io.boodskap.iot.model.ICounter;

public class CounterDAOImpl implements CounterDAO<ICounter> {

	private final CounterDAO<ICounter> impl;

	public CounterDAOImpl(final CounterDAO<ICounter> impl) {
		this.impl = impl;
	}

	public Class<? extends ICounter> clazz() {
		return impl.clazz();
	}

	public ICounter create() {
		return impl.create();
	}

	public void init() throws StorageException {
		impl.init();
	}

	public ICounter find() throws StorageException {
		return impl.find();
	}

	public void incrementDomains() throws StorageException {
		impl.incrementDomains();
	}

	public void incrementUsers() throws StorageException {
		impl.incrementUsers();
	}

	public void incrementDevices() throws StorageException {
		impl.incrementDevices();
	}

	public void incrementUdp() throws StorageException {
		impl.incrementUdp();
	}

	public void incrementLoRa() throws StorageException {
		impl.incrementLoRa();
	}

	public void incrementMqtt() throws StorageException {
		impl.incrementMqtt();
	}

	public void incrementHttp() throws StorageException {
		impl.incrementHttp();
	}

	public void incrementFcm() throws StorageException {
		impl.incrementFcm();
	}

	public void incrementCoAP() throws StorageException {
		impl.incrementCoAP();
	}

	public void incrementTcp() throws StorageException {
		impl.incrementTcp();
	}

	public void incrementCommands() throws StorageException {
		impl.incrementCommands();
	}

	public void incrementRecords() throws StorageException {
		impl.incrementRecords();
	}

}
