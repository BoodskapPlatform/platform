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

import io.boodskap.iot.dao.DeviceGroupMemberDAO;

@JsonSerialize(as=IDeviceGroupMember.class)
public interface IDeviceGroupMember extends IGroupMember {

	public static DeviceGroupMemberDAO<IDeviceGroupMember> dao(){
		return DeviceGroupMemberDAO.get();
	}
	
	public static Class<? extends IDeviceGroupMember> clazz() {
		return dao().clazz();
	}
	
	public static IDeviceGroupMember create(String domainKey, String ownerDeviceId, String groupId, String memberId) {
		return dao().create(domainKey, ownerDeviceId, groupId, memberId);
	}

	public static IDeviceGroupMember find(String domainKey, String ownerDeviceId, String groupId, String memberId) {
		return dao().get(domainKey, ownerDeviceId, groupId, memberId);
	}

	public default void save() {
		IDeviceGroupMember.dao().createOrUpdate(this);
	}

	public String getOwnerDeviceId();

	public void setOwnerDeviceId(String ownerDeviceId);

}
