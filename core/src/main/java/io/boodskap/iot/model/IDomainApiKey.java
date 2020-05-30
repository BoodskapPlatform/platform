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

import io.boodskap.iot.dao.DomainApiKeyDAO;

@JsonSerialize(as=IDomainApiKey.class)
public interface IDomainApiKey extends IDomainObject{
	
	public static DomainApiKeyDAO<IDomainApiKey> dao(){
		return DomainApiKeyDAO.get();
	}
	
	public static Class<? extends IDomainApiKey> clazz() {
		return dao().clazz();
	}

	public static IDomainApiKey create(String domainKey, String apiKey) {
		return dao().create(domainKey, apiKey);
	}

	public static IDomainApiKey find(String domainKey) {
		return dao().get(domainKey);
	}

	public static IDomainApiKey find(String domainKey, String apiKey) {
		return dao().get(domainKey, apiKey);
	}

	public default void save() {
		IDomainApiKey.dao().createOrUpdate(this);
	}

	@Override
	public default void copy(Object other) {
		
		IDomainApiKey o = (IDomainApiKey) other;
		
		setApiKey(o.getApiKey());
		
		IDomainObject.super.copy(other);
	}

	public String getApiKey();

	public void setApiKey(String apiKey);

}
