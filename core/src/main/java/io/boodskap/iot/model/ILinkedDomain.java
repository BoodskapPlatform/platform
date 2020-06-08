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
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.dao.LinkedDomainDAO;

@JsonSerialize(as=ILinkedDomain.class)
public interface ILinkedDomain extends IDomainObject {

	//======================================
	// DAO Methods
	//======================================
	
	public static LinkedDomainDAO<ILinkedDomain> dao(){
		return LinkedDomainDAO.get(); 
	}
	
	public static ILinkedDomain create(String domainKey, String linkedDomainKey, String linkedApiKey) {
		return dao().create(domainKey, linkedDomainKey, linkedApiKey);
	}	

	public static ILinkedDomain get(String domainKey, String linkedDomainKey, String linkedApiKey) throws StorageException{
		return dao().get(domainKey, linkedDomainKey, linkedApiKey);
	}
	
	public static long count(String domainKey, String linkedDomainKey) throws StorageException{
		return dao().count(domainKey, linkedDomainKey);
	}
	
	public static long countLinked(String linkedDomainKey) throws StorageException{
		return dao().countLinked(linkedDomainKey);
	}

	public static void setState(String domainKey, String linkedDomainKey, boolean state) throws StorageException{
		dao().setState(domainKey, linkedDomainKey, state);
	}

	public static void setState(String domainKey, String linkedDomainKey, String linkedApiKey, boolean state) throws StorageException{
		dao().setState(domainKey, linkedDomainKey, linkedApiKey, state);
	}

	public static void delete(String domainKey, String linkedDomainKey) throws StorageException{
		dao().delete(domainKey, linkedDomainKey);
	}

	public static void delete(String domainKey, String linkedDomainKey, String linkedApiKey) throws StorageException{
		dao().delete(domainKey, linkedDomainKey, linkedApiKey);
	}

	public static Collection<ILinkedDomain> list(String linkedDomainKey, int page, int pageSize) throws StorageException{
		return dao().list(linkedDomainKey, page, pageSize);
	}

	public static Collection<ILinkedDomain> listNext(String linkedDomainKey, String domainKey, int page, int pageSize) throws StorageException{
		return dao().listNext(linkedDomainKey, domainKey, page, pageSize);
	}

	public static Collection<ILinkedDomain> listLinked(String domainKey, int page, int pageSize) throws StorageException{
		return dao().listLinked(domainKey, page, pageSize);
	}

	public static Collection<ILinkedDomain> listLinkedNext(String domainKey, String linkedDomainKey, int page, int pageSize) throws StorageException{
		return dao().listLinkedNext(domainKey, linkedDomainKey, page, pageSize);
	}

	public static void createOrUpdate(ILinkedDomain e) throws StorageException{
		dao().createOrUpdate(e);
	}

	public static EntityIterator<ILinkedDomain> load() throws StorageException{
		return dao().load();
	}
	
	public static EntityIterator<ILinkedDomain> load(String domainKey) throws StorageException{
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
		LinkedDomainDAO.get().createOrUpdate(this);
	}

	@Override
	public default void copy(Object other) {
		
		ILinkedDomain o = (ILinkedDomain) other;
		
		setLinkedDomainKey(o.getLinkedDomainKey());
		setLinkedApiKey(o.getLinkedApiKey());
		setDisabled(o.isDisabled());
		
		IDomainObject.super.copy(other);
	}
	
	//======================================
	// Attributes
	//======================================
	
	public String getLinkedDomainKey();

	public void setLinkedDomainKey(String linkedDomainKey);

	public String getLinkedApiKey();

	public void setLinkedApiKey(String linkedApiKey);

	public boolean isDisabled();
	
	public void setDisabled(boolean disabled);
}
