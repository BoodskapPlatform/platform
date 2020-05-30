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

import io.boodskap.iot.dao.OrganizationRoleDAO;

@JsonSerialize(as=IOrganizationRole.class)
public interface IOrganizationRole extends IDomainRole {
	
	public static OrganizationRoleDAO<IOrganizationRole> dao(){
		return OrganizationRoleDAO.get();
	}
	
	public static Class<? extends IOrganizationRole> clazz() {
		return dao().clazz();
	}
	
	public static IOrganizationRole create(String domainKey, String orgId, String name) {
		return dao().create(domainKey, orgId, name);
	}

	
	public static IOrganizationRole find(String domainKey, String orgId, String name) {
		return dao().get(domainKey, orgId, name);
	}
	
	@Override
	public default void save() {
		dao().createOrUpdate(this);
	}

	@Override
	public default void copy(Object other) {
		
		IOrganizationRole o = (IOrganizationRole) other;

		setOrgId(o.getOrgId());
		
		IDomainRole.super.copy(other);
	}
	
	public String getOrgId();
	
	public void setOrgId(String orgId);
}
