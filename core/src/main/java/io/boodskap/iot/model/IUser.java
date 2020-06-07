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

import io.boodskap.iot.dao.UserDAO;
import io.boodskap.iot.dao.UserRoleDAO;

@JsonSerialize(as=IUser.class)
public interface IUser extends IPerson {
	
	public static UserDAO<IUser> dao() {
		return UserDAO.get();
	}
	
	public static Class<? extends IUser> clazz() {
		return dao().clazz();
	}
	
	public static IUser create(String domainKey, String userId) {
		return dao().create(domainKey, userId);
	}
	
	public static IUser find(String userId) {
		return dao().get(userId);
	}
	
	public static IUser find(String domainKey, String userId) {
		return dao().get(domainKey, userId);
	}
	
	public default void save() {
		IUser.dao().createOrUpdate(this);
	}

	public default void addRole(String name, String description) {		
		IUserRole role = IUserRole.create(getDomainKey(), getUserId(), name);
		role.setDescription(description);
		UserRoleDAO.get().createOrUpdate(role);
	}
	
	public default void removeRole(String name) {
		UserRoleDAO.get().delete(getDomainKey(), getUserId(), name);
	}

	public default void setAdmin() {
		addRole("admin", "Platform Administrator");
	}

	public default void setDomainAdmin() {
		addRole("domainadmin", "Domain Administrator");
	}

	public default void setOrganizationAdmin() {
		addRole("orgadmin", "Organization Administrator");
	}

	public default boolean isAdmin() {
		return hasRole("admin");
	}

	public default boolean isDomainAdmin() {
		return hasRole("domainadmin") || isAdmin();
	}

	public default boolean isOrganizationAdmin() {
		return hasRole("orgadmin") || isDomainAdmin();
	}

	public default boolean hasRole(String name) {
		return UserRoleDAO.get().get(getDomainKey(), getUserId(), name) != null;
	}

	public String getUserId();
	
	public void setUserId(String userId);
}
