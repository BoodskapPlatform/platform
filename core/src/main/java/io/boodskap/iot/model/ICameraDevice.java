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

import io.boodskap.iot.dao.CameraDeviceDAO;

@JsonSerialize(as=ICameraDevice.class)
public interface ICameraDevice extends IDomainObject{

	public static CameraDeviceDAO<ICameraDevice> dao(){
		return CameraDeviceDAO.get();
	}
	
	public static Class<? extends ICameraDevice> clazz() {
		return dao().clazz();
	}
	
	public static ICameraDevice create(String domainKey, String deviceId, String camera) {
		return dao().create(domainKey, deviceId, camera);
	}	

	public static ICameraDevice find(String domainKey, String deviceId, String camera) {
		return dao().get(domainKey, deviceId, camera);
	}	

	public default void save() {
		ICameraDevice.dao().createOrUpdate(this);
	}

	@Override
	public default void copy(Object other) {
		
		ICameraDevice o = (ICameraDevice) other;
		
		setDeviceId(o.getDeviceId());
		setCamera(o.getCamera());
		
		IDomainObject.super.copy(other);
	}
	public String getDeviceId();

	public void setDeviceId(String deviceId);
	
	public String getCamera();
	
	public void setCamera(String camera);

}
