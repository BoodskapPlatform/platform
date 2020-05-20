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
import io.boodskap.iot.dao.DeviceCounterDAO;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.model.IDeviceCounter;

public class DeviceCounterDAOImpl implements DeviceCounterDAO<IDeviceCounter> {

	private final DeviceCounterDAO<IDeviceCounter> impl;

	public DeviceCounterDAOImpl(final DeviceCounterDAO<IDeviceCounter> impl) {
		this.impl = impl;
	}


	public Class<? extends IDeviceCounter> clazz() {
		return impl.clazz();
	}


	public void createOrUpdate(IDeviceCounter e) throws StorageException {
		impl.createOrUpdate(e);
	}


	public EntityIterator<IDeviceCounter> load() throws StorageException {
		return impl.load();
	}


	public EntityIterator<IDeviceCounter> load(String domainKey) throws StorageException {
		return impl.load(domainKey);
	}

	public long count() throws StorageException {
		return impl.count();
	}

	public IDeviceCounter create(String domainKey, String deviceId) throws StorageException {
		return impl.create(domainKey, deviceId);
	}

	public long count(String domainKey) throws StorageException {
		return impl.count(domainKey);
	}

	public void delete(String domainKey) throws StorageException {
		impl.delete(domainKey);
	}

	public IDeviceCounter get(String domainKey, String deviceId) throws StorageException {
		return impl.get(domainKey, deviceId);
	}

	public long getNextCorrelationId(String domainKey, String deviceId) throws StorageException {
		return impl.getNextCorrelationId(domainKey, deviceId);
	}

	public void incrementUdp(String domainKey, String deviceId) throws StorageException {
		impl.incrementUdp(domainKey, deviceId);
	}

	public void incrementLoRa(String domainKey, String deviceId) throws StorageException {
		impl.incrementLoRa(domainKey, deviceId);
	}

	public void incrementMqtt(String domainKey, String deviceId) throws StorageException {
		impl.incrementMqtt(domainKey, deviceId);
	}

	public void incrementHttp(String domainKey, String deviceId) throws StorageException {
		impl.incrementHttp(domainKey, deviceId);
	}

	public void incrementFcm(String domainKey, String deviceId) throws StorageException {
		impl.incrementFcm(domainKey, deviceId);
	}

	public void incrementCoAP(String domainKey, String deviceId) throws StorageException {
		impl.incrementCoAP(domainKey, deviceId);
	}

	public void incrementTcp(String domainKey, String deviceId) throws StorageException {
		impl.incrementTcp(domainKey, deviceId);
	}

	public void incrementCommands(String domainKey, String deviceId) throws StorageException {
		impl.incrementCommands(domainKey, deviceId);
	}

	public long countUdp() throws StorageException {
		return impl.countUdp();
	}

	public long countLoRa() throws StorageException {
		return impl.countLoRa();
	}

	public long countMqtt() throws StorageException {
		return impl.countMqtt();
	}

	public long countHttp() throws StorageException {
		return impl.countHttp();
	}

	public long countFcm() throws StorageException {
		return impl.countFcm();
	}

	public long countCoAP() throws StorageException {
		return impl.countCoAP();
	}

	public long countTcp() throws StorageException {
		return impl.countTcp();
	}

	public long countCommands() throws StorageException {
		return impl.countCommands();
	}

	public long countUdp(String domainKey) throws StorageException {
		return impl.countUdp(domainKey);
	}

	public long countLoRa(String domainKey) throws StorageException {
		return impl.countLoRa(domainKey);
	}

	public long countMqtt(String domainKey) throws StorageException {
		return impl.countMqtt(domainKey);
	}

	public long countHttp(String domainKey) throws StorageException {
		return impl.countHttp(domainKey);
	}

	public long countFcm(String domainKey) throws StorageException {
		return impl.countFcm(domainKey);
	}

	public long countCoAP(String domainKey) throws StorageException {
		return impl.countCoAP(domainKey);
	}

	public long countTcp(String domainKey) throws StorageException {
		return impl.countTcp(domainKey);
	}

	public long countCommands(String domainKey) throws StorageException {
		return impl.countCommands(domainKey);
	}

	public long countUdp(String domainKey, String deviceId) throws StorageException {
		return impl.countUdp(domainKey, deviceId);
	}

	public long countLoRa(String domainKey, String deviceId) throws StorageException {
		return impl.countLoRa(domainKey, deviceId);
	}

	public long countMqtt(String domainKey, String deviceId) throws StorageException {
		return impl.countMqtt(domainKey, deviceId);
	}

	public long countHttp(String domainKey, String deviceId) throws StorageException {
		return impl.countHttp(domainKey, deviceId);
	}

	public long countFcm(String domainKey, String deviceId) throws StorageException {
		return impl.countFcm(domainKey, deviceId);
	}

	public long countCoAP(String domainKey, String deviceId) throws StorageException {
		return impl.countCoAP(domainKey, deviceId);
	}

	public long countTcp(String domainKey, String deviceId) throws StorageException {
		return impl.countTcp(domainKey, deviceId);
	}

	public long countCommands(String domainKey, String deviceId) throws StorageException {
		return impl.countCommands(domainKey, deviceId);
	}

	public void delete() throws StorageException {
		impl.delete();
	}

}
