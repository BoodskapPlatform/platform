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
package io.boodskap.iot.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import io.boodskap.iot.dao.DeviceFileDAO;

@JsonSerialize(as=IDeviceFile.class)
public interface IDeviceFile extends IDomainFile {
	
	public static DeviceFileDAO<IDeviceFile> dao(){
		return DeviceFileDAO.get();
	}
	
	public static Class<? extends IDeviceFile> clazz() {
		return dao().clazz();
	}
	
	public static IDeviceFile create(String domainKey, String deviceId, String fileId) {
		return dao().create(domainKey, deviceId, fileId);
	}

	public static IDeviceFile find(String domainKey, String deviceId, String fileId) {
		return dao().get(domainKey, deviceId, fileId);
	}

	public default void save() {
		IDeviceFile.dao().createOrUpdate(this);
	}

	@Override
	public default void copy(Object other) {
		
		IDeviceFile o = (IDeviceFile) other;
		
		setDeviceId(o.getDeviceId());
		
		IDomainFile.super.copy(other);
	}

	public String getDeviceId();
	
	public void setDeviceId(String deviceId);
}
