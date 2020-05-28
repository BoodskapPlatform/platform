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

import io.boodskap.iot.dao.DeviceFriendDAO;

@JsonSerialize(as=IDeviceFriend.class)
public interface IDeviceFriend extends IDomainObject {
	
	public static DeviceFriendDAO<IDeviceFriend> dao(){
		return DeviceFriendDAO.get();
	}
	
	public static Class<? extends IDeviceFriend> clazz() {
		return dao().clazz();
	}
	
	public static IDeviceFriend create(String domainKey, String deviceId, String friendId) {
		return dao().create(domainKey, deviceId, friendId);
	}

	public static IDeviceFriend find(String domainKey, String deviceId, String friendId) {
		return dao().get(domainKey, deviceId, friendId);
	}

	public default void save() {
		IDeviceFriend.dao().createOrUpdate(this);
	}

	@Override
	public default void copy(Object other) {
		
		IDeviceFriend o = (IDeviceFriend) other;
		
		setDeviceId(o.getDeviceId());
		setFriendId(o.getFriendId());
		
		IDomainObject.super.copy(other);
	}

	public String getDeviceId();

	public void setDeviceId(String deviceId);

	public String getFriendId();

	public void setFriendId(String friendId);
	
}
