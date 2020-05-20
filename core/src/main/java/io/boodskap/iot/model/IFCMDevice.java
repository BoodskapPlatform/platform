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

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import io.boodskap.iot.BoodskapSystem;
import io.boodskap.iot.dao.FCMDeviceDAO;

@JsonSerialize(as=IFCMDevice.class)
public interface IFCMDevice extends IDomainObject{

	public static IFCMDevice create(String domainKey, String deviceId) {
		return BoodskapSystem.storage().getFCMDeviceDAO().create(domainKey, deviceId);
	}	

	public String getDeviceId();

	public void setDeviceId(String deviceId);

	public String getFcmToken();

	public void setFcmToken(String fcmToken);

	public Date getCreatedStamp();
	
	public void setCreatedStamp(Date createdStamp);
	
	public Date getUpdatedStamp();
	
	public void setUpdatedStamp(Date updatedStamp);

	public default void save() {
		FCMDeviceDAO.get().createOrUpdate(this);
	}
	
}
