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

import java.util.Collection;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.DomainApiKeyDAO;
import io.boodskap.iot.dao.EntityIterator;

@JsonSerialize(as=IDomainApiKey.class)
public interface IDomainApiKey extends IDomainObject{
	
	//======================================
	// DAO Methods
	//======================================
	
	public static DomainApiKeyDAO<IDomainApiKey> dao(){
		return DomainApiKeyDAO.get();
	}
	
	public static Class<? extends IDomainApiKey> clazz() {
		return dao().clazz();
	}

	public static IDomainApiKey create(String domainKey, String apiKey) {
		return dao().create(domainKey, apiKey);
	}

	public static IDomainApiKey get(String domainKey) {
		return dao().get(domainKey);
	}

	public static IDomainApiKey get(String domainKey, String apiKey) {
		return dao().get(domainKey, apiKey);
	}

	public static Collection<IDomainApiKey> list(String domainKey, int page, int pageSize) throws StorageException{
		return dao().list(domainKey, page, pageSize);
	}

	public static Collection<IDomainApiKey> listNext(String domainKey, String apiKey, int page, int pageSize) throws StorageException{
		return dao().listNext(domainKey, apiKey, page, pageSize);
	}
	
	public static void createOrUpdate(IDomainApiKey e) throws StorageException{
		dao().createOrUpdate(e);
	}

	public static EntityIterator<IDomainApiKey> load() throws StorageException{
		return dao().load();
	}
	
	public static EntityIterator<IDomainApiKey> load(String domainKey) throws StorageException{
		return dao().load(domainKey);
	}
	
	public static long count() throws StorageException{
		return dao().count();
	}
	
	public static long count(String domainKey) throws StorageException{
		return dao().count(domainKey);
	}
	
	public static void delete() throws StorageException{
		dao().delete();
	}
	
	public static void delete(String domainKey) throws StorageException{
		dao().delete(domainKey);
	}


	//======================================
	// Default Methods
	//======================================
	
	public default void save() {
		dao().createOrUpdate(this);
	}

	@Override
	public default void copy(Object other) {
		
		IDomainApiKey o = (IDomainApiKey) other;
		
		setApiKey(o.getApiKey());
		
		IDomainObject.super.copy(other);
	}

	//======================================
	// Attributes
	//======================================
	
	public String getApiKey();

	public void setApiKey(String apiKey);

}
