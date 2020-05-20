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

import io.boodskap.iot.dao.DomainEntityDAO;

@JsonSerialize(as=IDomainEntity.class)
public interface IDomainEntity extends IEntity {

	public static DomainEntityDAO<IDomainEntity> dao(){
		return DomainEntityDAO.get();
	}
	
	public static Class<? extends IDomainEntity> clazz() {
		return dao().clazz();
	}
	
	public static IDomainEntity create(String domainKey, String entityId) {
		return dao().create(domainKey, entityId);
	}

	public static IDomainEntity find(String domainKey, String entityId) {
		return dao().get(domainKey, entityId);
	}

	public default void save() {
		IDomainEntity.dao().createOrUpdate(this);
	}

	public String getEntityId();
	
	public void setEntityId(String entityId);
}
