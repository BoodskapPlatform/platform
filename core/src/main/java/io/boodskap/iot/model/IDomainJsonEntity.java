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

import org.json.JSONObject;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import io.boodskap.iot.dao.DomainJsonEntityDAO;

@JsonSerialize(as=IDomainJsonEntity.class)
public interface IDomainJsonEntity extends IDomainEntity {

	public static DomainJsonEntityDAO<IDomainJsonEntity> dao(){
		return DomainJsonEntityDAO.get();
	}
	
	public static Class<? extends IDomainJsonEntity> clazz() {
		return dao().clazz();
	}
	
	public static IDomainJsonEntity create(String domainKey, String entityType, String entityId) {
		return dao().create(domainKey, entityType, entityId);
	}

	public static IDomainJsonEntity find(String domainKey, String entityType, String entityId) {
		return dao().get(domainKey, entityType, entityId);
	}

	public default void save() {
		IDomainJsonEntity.dao().createOrUpdate(this);
	}
	
	public default JSONObject document() {
		return new JSONObject(getJson());
	}

	@Override
	public default void copy(Object other) {
		
		IDomainJsonEntity o = (IDomainJsonEntity) other;
		
		setJson(o.getJson());
		
		IDomainEntity.super.copy(other);
	}

	public String getJson();
	
	public void setJson(String json);
	
}
