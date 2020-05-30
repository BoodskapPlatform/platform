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

import io.boodskap.iot.dao.OrganizationUserRoleDAO;

@JsonSerialize(as=IOrganizationUserRole.class)
public interface IOrganizationUserRole extends IOrganizationRole{

	public static OrganizationUserRoleDAO<IOrganizationUserRole> dao(){
		return OrganizationUserRoleDAO.get();
	}
	
	public static Class<? extends IOrganizationUserRole> clazz() {
		return dao().clazz();
	}
	
	public static IOrganizationUserRole create(String domainKey, String orgId, String userId, String name) {
		return dao().create(domainKey, orgId, userId, name);
	}

	
	public static IOrganizationUserRole find(String domainKey, String orgId, String userId, String name) {
		return dao().get(domainKey, orgId, userId, name);
	}
	
	@Override
	public default void save() {
		dao().createOrUpdate(this);
	}

	@Override
	public default void copy(Object other) {
		
		IOrganizationUserRole o = (IOrganizationUserRole) other;
		
		setUserId(o.getUserId());
		
		IOrganizationRole.super.copy(other);
	}
		
	public String getUserId();
	
	public void setUserId(String userId);
}
