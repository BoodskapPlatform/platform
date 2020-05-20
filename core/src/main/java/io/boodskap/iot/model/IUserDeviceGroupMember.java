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

import io.boodskap.iot.dao.UserDeviceGroupMemberDAO;

@JsonSerialize(as=IUserDeviceGroupMember.class)
public interface IUserDeviceGroupMember extends IGroupMember {
	
	public static IUserDeviceGroupMember create(String domainKey, String ownerUserId, String groupId, String memberDeviceId) {
		return UserDeviceGroupMemberDAO.get().create(domainKey, ownerUserId, groupId, memberDeviceId);
	}

	public default void save() {
		UserDeviceGroupMemberDAO.get().createOrUpdate(this);
	}

	public String getOwnerUserId();

	public void setOwnerUserId(String ownerUserId);

}
