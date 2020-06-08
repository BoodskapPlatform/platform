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
import io.boodskap.iot.dao.DomainDAO;
import io.boodskap.iot.dao.DomainRoleDAO;
import io.boodskap.iot.dao.EntityIterator;

@JsonSerialize(as=IDomain.class)
public interface IDomain extends IContact {

	//======================================
	// DAO Methods
	//======================================
	
	public static DomainDAO<IDomain> dao(){
		return DomainDAO.get();
	}
	
	public static Class<? extends IDomain> clazz() {
		return dao().clazz();
	}

	public static IDomain create(String domainKey) {
		return dao().create(domainKey);
	}

	public static IDomain get(String domainKey) {
		return dao().get(domainKey);
	}

	public static void delete() throws StorageException{
		dao().delete();
	}

	public static Collection<IDomain> list(int page, int pageSize) throws StorageException{
		return dao().list(page, pageSize);
	}
	
	public static Collection<IDomain> listNext(String domainKey, int page, int pageSize) throws StorageException{
		return dao().listNext(domainKey, page, pageSize);
	}
	
	public static Collection<IDomain> search(String query, int pageSize) throws StorageException{
		return dao().search(query, pageSize);
	}

	public static void createOrUpdate(IDomain e) throws StorageException{
		dao().createOrUpdate(e);
	}

	public static EntityIterator<IDomain> load() throws StorageException{
		return dao().load();
	}
	
	public static EntityIterator<IDomain> load(String domainKey) throws StorageException{
		return dao().load(domainKey);
	}
	
	public static long count() throws StorageException{
		return dao().count();
	}
	
	public static long count(String domainKey) throws StorageException{
		return dao().count(domainKey);
	}
	
	public static void delete(String domainKey) throws StorageException{
		dao().delete(domainKey);
	}

	//======================================
	// Default Methods
	//======================================
	
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
	
	//======================================
	// Methods
	//======================================
	
	public IDomainRole createRole(String name, String description);

}
