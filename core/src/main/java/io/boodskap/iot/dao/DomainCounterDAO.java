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
import io.boodskap.iot.model.IDomainCounter;

public interface DomainCounterDAO<T extends IDomainCounter> {
	
	public static <T extends IDomainCounter> DomainCounterDAO<T> get() {
		return BoodskapSystem.storage().getDomainCounterDAO();
	}
	
	public T create(String domainKey);

	public Class<? extends T> clazz();
	
	public void init() throws StorageException;

	public T find(String domainKey) throws StorageException;

	public void incrementUsers(String domainKey) throws StorageException;

	public void incrementDevices(String domainKey) throws StorageException;

	public void incrementUdp(String domainKey) throws StorageException;

	public void incrementLoRa(String domainKey) throws StorageException;

	public void incrementMqtt(String domainKey) throws StorageException;

	public void incrementHttp(String domainKey) throws StorageException;

	public void incrementFcm(String domainKey) throws StorageException;

	public void incrementCoAP(String domainKey) throws StorageException;

	public void incrementTcp(String domainKey) throws StorageException;

	public void incrementCommands(String domainKey) throws StorageException;

	public void incrementRecords(String domainKey) throws StorageException;

}
