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

import java.util.Map;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import io.boodskap.iot.dao.DomainEntityDAO;

@JsonSerialize(as=IDomainEntity.class)
public interface IDomainEntity extends IDomainObject {

	public static DomainEntityDAO<IDomainEntity> dao(){
		return DomainEntityDAO.get();
	}
	
	public static Class<? extends IDomainEntity> clazz() {
		return dao().clazz();
	}
	
	public static IDomainEntity create(String domainKey, String entityType, String entityId) {
		return dao().create(domainKey, entityType, entityId);
	}

	public static IDomainEntity find(String domainKey, String entityType, String entityId) {
		return dao().get(domainKey, entityType, entityId);
	}

	public default void save() {
		IDomainEntity.dao().createOrUpdate(this);
	}

	@Override
	public default void copy(Object other) {
		
		IDomainEntity o = (IDomainEntity) other;
		
		setEntityId(o.getEntityType());
		setEntityId(o.getEntityId());
		setAttributes(o.getAttributes());
		
		IDomainObject.super.copy(other);
	}

	public String getEntityType();
	
	public void setEntityType(String entityType);
	
	public String getEntityId();
	
	public void setEntityId(String entityId);
	
	public Map<String, String> getAttributes();
	
	public void setAttributes(Map<String, String> attributes);
}
