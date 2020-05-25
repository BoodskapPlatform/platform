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

import io.boodskap.iot.dao.AssetDeviceDAO;

@JsonSerialize(as=IAssetDevice.class)
public interface IAssetDevice extends IDomainObject {
	
	public static AssetDeviceDAO<IAssetDevice> dao(){
		return AssetDeviceDAO.get();
	}
	
	public static Class<? extends IAssetDevice> clazz() {
		return dao().clazz();
	}

	public static IAssetDevice create(String domainKey, String assetId, String deviceId) {
		return dao().create(domainKey, assetId, deviceId);
	}
	
	public static IAssetDevice find(String domainKey, String assetId, String deviceId) {
		return dao().get(domainKey, assetId, deviceId);
	}
	
	public default void save() {
		IAssetDevice.dao().createOrUpdate(this);
	}

	public String getAssetId();

	public void setAssetId(String assetId);

	public String getDeviceId();

	public void setDeviceId(String deviceId);

}
