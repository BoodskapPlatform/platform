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

import io.boodskap.iot.dao.UserRoleDAO;

@JsonSerialize(as=IUserRole.class)
public interface IUserRole extends IDomainRole {
	
	public static UserRoleDAO<IUserRole> dao(){
		return UserRoleDAO.get();
	}
	
	public static Class<? extends IUserRole> clazz() {
		return dao().clazz();
	}
	
	public static IUserRole create(String domainKey, String userId, String name) {
		return dao().create(domainKey, userId, name);
	}
	
	public static IUserRole find(String domainKey, String userId, String name) {
		return dao().get(domainKey, userId, name);
	}
	
	public default void save() {
		IUserRole.dao().createOrUpdate(this);
	}

	public String getUserId();
	
	public void setUserId(String userId);
}
