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

import io.boodskap.iot.dao.DeviceGroupDAO;

@JsonSerialize(as=IDeviceGroup.class)
public interface IDeviceGroup extends IGroup {
	
	public static DeviceGroupDAO<IDeviceGroup> dao(){
		return DeviceGroupDAO.get();
	}
	
	public static Class<? extends IDeviceGroup> clazz() {
		return dao().clazz();
	}
	
	public static IDeviceGroup create(String domainKey, String ownerDeviceId, String groupId) {
		return dao().create(domainKey, ownerDeviceId, groupId);
	}

	public static IDeviceGroup find(String domainKey, String ownerDeviceId, String groupId) {
		return dao().get(domainKey, ownerDeviceId, groupId);
	}

	public default void save() {
		DeviceGroupDAO.get().createOrUpdate(this);
	}

	@Override
	public default void copy(Object other) {
		
		IDeviceGroup o = (IDeviceGroup) other;
		
		setOwnerDeviceId(o.getOwnerDeviceId());
		
		IGroup.super.copy(other);
	}

	public String getOwnerDeviceId();

	public void setOwnerDeviceId(String ownerDeviceId);

}
