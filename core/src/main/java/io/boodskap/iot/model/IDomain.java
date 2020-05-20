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

import io.boodskap.iot.dao.DomainDAO;
import io.boodskap.iot.dao.DomainRoleDAO;

@JsonSerialize(as=IDomain.class)
public interface IDomain extends IEntity {

	public static DomainDAO<IDomain> dao(){
		return DomainDAO.get();
	}
	
	public static Class<? extends IDomain> clazz() {
		return dao().clazz();
	}

	public static IDomain create(String domainKey) {
		return dao().create(domainKey);
	}

	public static IDomain find(String domainKey) {
		return dao().get(domainKey);
	}

	public default void save() {
		IDomain.dao().createOrUpdate(this);
	}

	public default void addRole(String name, String description) {		
		IDomainRole e = createRole(name, description);
		DomainRoleDAO.get().createOrUpdate(e);
	}
	
	public default void removeRole(String name) {
		DomainRoleDAO.get().delete(getDomainKey(), name);
	}

	public default boolean hasRole(String name) {
		return DomainRoleDAO.get().get(getDomainKey(), name) != null;
	}
	
	public IDomainRole createRole(String name, String description);

}
