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
import io.boodskap.iot.dao.OrganizationDAO;

@JsonSerialize(as=IOrganization.class)
public interface IOrganization extends IContact {
	
	//======================================
	// DAO Methods
	//======================================
	
	public static OrganizationDAO<IOrganization> dao(){
		return OrganizationDAO.get();
	}

	public static IOrganization create(String domainKey, String orgId) {
		return dao().create(domainKey, orgId);
	}
	
	public static IOrganization get(String domainKey, String orgId) throws StorageException{
		return dao().get(domainKey, orgId);
	}

	public static void delete(String domainKey, String orgId) throws StorageException{
		dao().delete(domainKey, orgId);
	}

	public static Collection<IOrganization> list(String domainKey, int page, int pageSize) throws StorageException{
		return dao().list(domainKey, page, pageSize);
	}

	public static Collection<IOrganization> listNext(String domainKey, String orgId, int page, int pageSize) throws StorageException{
		return dao().listNext(domainKey, orgId, page, pageSize);
	}

	public static Collection<IOrganization> search(String domainKey, String query, int pageSize) throws StorageException{
		return dao().search(domainKey, query, pageSize);
	}

	public static void createOrUpdate(IOrganization e) throws StorageException{
		dao().createOrUpdate(e);
	}

	public static EntityIterator<IOrganization> load() throws StorageException{
		return dao().load();
	}
	
	public static EntityIterator<IOrganization> load(String domainKey) throws StorageException{
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

	public static boolean has(String domainKey, String orgId) {
		return (null != dao().get(domainKey, orgId));
	}
	
	//======================================
	// Default Methods
	//======================================
	
	@Override
	public default void save() {
		OrganizationDAO.get().createOrUpdate(this);
	}

	@Override
	public default void copy(Object other) {
		
		IOrganization o = (IOrganization) other;

		setOrgId(o.getOrgId());
		
		IContact.super.copy(other);
	}
	
	//======================================
	// Attributes
	//======================================
	
	public String getOrgId();

	public void setOrgId(String orgId);

}
