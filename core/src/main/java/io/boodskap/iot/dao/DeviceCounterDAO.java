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
package io.boodskap.iot.dao;

import io.boodskap.iot.BoodskapSystem;
import io.boodskap.iot.StorageException;
import io.boodskap.iot.model.IDeviceCounter;

public interface DeviceCounterDAO<T extends IDeviceCounter> extends DAO<T>{
	
	public static <T extends IDeviceCounter> DeviceCounterDAO<T> get() {
		return BoodskapSystem.storage().getDeviceCounterDAO();
	}
	
	public T create(String domainKey, String deviceId) throws StorageException;
	
	public T get(String domainKey, String deviceId) throws StorageException;

	public long getNextCorrelationId(String domainKey, String deviceId) throws StorageException;

	public void incrementUdp(String domainKey, String deviceId) throws StorageException;

	public void incrementLoRa(String domainKey, String deviceId) throws StorageException;

	public void incrementMqtt(String domainKey, String deviceId) throws StorageException;

	public void incrementHttp(String domainKey, String deviceId) throws StorageException;

	public void incrementFcm(String domainKey, String deviceId) throws StorageException;

	public void incrementCoAP(String domainKey, String deviceId) throws StorageException;

	public void incrementTcp(String domainKey, String deviceId) throws StorageException;

	public void incrementCommands(String domainKey, String deviceId) throws StorageException;

	public long countUdp() throws StorageException;

	public long countLoRa() throws StorageException;

	public long countMqtt() throws StorageException;

	public long countHttp() throws StorageException;

	public long countFcm() throws StorageException;

	public long countCoAP() throws StorageException;

	public long countTcp() throws StorageException;

	public long countCommands() throws StorageException;
	
	public long countUdp(String domainKey) throws StorageException;

	public long countLoRa(String domainKey) throws StorageException;

	public long countMqtt(String domainKey) throws StorageException;

	public long countHttp(String domainKey) throws StorageException;

	public long countFcm(String domainKey) throws StorageException;

	public long countCoAP(String domainKey) throws StorageException;

	public long countTcp(String domainKey) throws StorageException;

	public long countCommands(String domainKey) throws StorageException;

	public long countUdp(String domainKey, String deviceId) throws StorageException;

	public long countLoRa(String domainKey, String deviceId) throws StorageException;

	public long countMqtt(String domainKey, String deviceId) throws StorageException;

	public long countHttp(String domainKey, String deviceId) throws StorageException;

	public long countFcm(String domainKey, String deviceId) throws StorageException;

	public long countCoAP(String domainKey, String deviceId) throws StorageException;

	public long countTcp(String domainKey, String deviceId) throws StorageException;

	public long countCommands(String domainKey, String deviceId) throws StorageException;
}
