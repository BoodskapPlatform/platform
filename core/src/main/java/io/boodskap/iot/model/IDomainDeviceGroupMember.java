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

import io.boodskap.iot.dao.DomainDeviceGroupMemberDAO;

@JsonSerialize(as=IDomainDeviceGroupMember.class)
public interface IDomainDeviceGroupMember extends IGroupMember {

	public static DomainDeviceGroupMemberDAO<IDomainDeviceGroupMember> dao(){
		return DomainDeviceGroupMemberDAO.get();
	}
	
	public static Class<? extends IDomainDeviceGroupMember> clazz() {
		return dao().clazz();
	}
	
	public static IDomainDeviceGroupMember create(String domainKey, String groupId, String deviceId) {
		return dao().create(domainKey, groupId, deviceId);
	}

	public static IDomainDeviceGroupMember find(String domainKey, String groupId, String deviceId) {
		return dao().get(domainKey, groupId, deviceId);
	}

	public default void save() {
		IDomainDeviceGroupMember.dao().createOrUpdate(this);
	}

}
