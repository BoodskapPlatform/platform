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
import io.boodskap.iot.model.ICounter;

public interface CounterDAO<T extends ICounter> {
	
	public static <T extends ICounter> CounterDAO<T> get() {
		return BoodskapSystem.storage().getCounterDAO();
	}
	
	public T create();

	public Class<? extends T> clazz();
	
	public void init() throws StorageException;

	public T find() throws StorageException;

	public void incrementDomains() throws StorageException;

	public void incrementUsers() throws StorageException;

	public void incrementDevices() throws StorageException;

	public void incrementUdp() throws StorageException;

	public void incrementLoRa() throws StorageException;

	public void incrementMqtt() throws StorageException;

	public void incrementHttp() throws StorageException;

	public void incrementFcm() throws StorageException;

	public void incrementCoAP() throws StorageException;

	public void incrementTcp() throws StorageException;

	public void incrementCommands() throws StorageException;

	public void incrementRecords() throws StorageException;

}
