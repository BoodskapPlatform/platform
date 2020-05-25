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

import io.boodskap.iot.Access;
import io.boodskap.iot.dao.DomainAccessDAO;

@JsonSerialize(as=IDomainAccess.class)
public interface IDomainAccess extends IDomainObject{
	
	public static DomainAccessDAO<IDomainAccess> dao(){
		return DomainAccessDAO.get();
	}
	
	public static Class<? extends IDomainAccess> clazz() {
		return dao().clazz();
	}
	
	public static IDomainAccess create(String domainKey, Access access) {
		return dao().create(domainKey, access);
	}

	public static IDomainAccess find(String domainKey, Access access) {
		return dao().get(domainKey, access);
	}

	public default void save() {
		IDomainAccess.dao().createOrUpdate(this);
	}
	
	public Access getAccess();

	public void setAccess(Access access);
	
}
