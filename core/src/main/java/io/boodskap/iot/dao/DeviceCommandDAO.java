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

import java.util.Collection;

import io.boodskap.iot.BoodskapSystem;
import io.boodskap.iot.StorageException;
import io.boodskap.iot.model.IDeviceCommand;

public interface DeviceCommandDAO<T extends IDeviceCommand> extends DAO<T> {
	
	public static <T extends IDeviceCommand> DeviceCommandDAO<T> get() {
		return BoodskapSystem.storage().getDeviceCommandDAO();
	}

	public T get(String domainKey, String deviceId, long uid) throws StorageException;
	
	public long count(String domainKey, String deviceId) throws StorageException;

	public Collection<T> list(String domainKey, String deviceId, int page, int pageSize) throws StorageException;

	public Collection<T> listNext(String domainKey, String deviceId, long uid, int page, int pageSize) throws StorageException;

	public IDeviceCommand create(String domainKey, String deviceId, long uid);

}
