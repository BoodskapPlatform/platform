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

import io.boodskap.iot.dao.OrganizationUserDAO;
import io.boodskap.iot.dao.OrganizationUserRoleDAO;

@JsonSerialize(as=IOrganizationUser.class)
public interface IOrganizationUser extends IDomainObject {
	
	public static IOrganizationUser create(String domainKey, String orgId, String userId) {
		return OrganizationUserDAO.get().create(domainKey, orgId, userId);
	}
	
	public static Class<? extends IOrganizationUser> clazz() {
		return OrganizationUserDAO.get().clazz();
	}
	
	public default void save() {
		OrganizationUserDAO.get().createOrUpdate(this);
	}

	public default void addRole(String name, String description) {
		IOrganizationUserRole e = createRole(name, description);
		OrganizationUserRoleDAO.get().createOrUpdate(e);
	}
	
	public default void removeRole(String name) {
		OrganizationUserRoleDAO.get().delete(getDomainKey(), getOrgId(), getUserId(), name);
	}

	public default boolean hasRole(String name) {
		return OrganizationUserRoleDAO.get().get(getDomainKey(), getOrgId(), getUserId(), name) != null;
	}

	public String getOrgId();
	
	public void setOrgId(String orgId);
	
	public String getUserId();
	
	public void setUserId(String userId);

	public Date getCreatedStamp();

	public void setCreatedStamp(Date createdStamp);

	public Date getUpdatedStamp();

	public void setUpdatedStamp(Date updatedStamp);
	
	public IOrganizationUserRole createRole(String name, String description);

}
