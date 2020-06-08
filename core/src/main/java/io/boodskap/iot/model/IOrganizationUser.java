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
import io.boodskap.iot.dao.OrganizationUserDAO;
import io.boodskap.iot.dao.OrganizationUserRoleDAO;

@JsonSerialize(as=IOrganizationUser.class)
public interface IOrganizationUser extends IUser {
	
	//======================================
	// DAO Methods
	//======================================
	
	public static OrganizationUserDAO<IOrganizationUser> dao(){
		return OrganizationUserDAO.get();
	}
	
	public static IOrganizationUser create(String domainKey, String orgId, String userId) {
		return dao().create(domainKey, orgId, userId);
	}
	
	public static IOrganizationUser get(String domainKey, String orgId, String userId) throws StorageException{
		return dao().get(domainKey, orgId, userId);
	}

	public static void delete(String domainKey, String orgId) throws StorageException{
		dao().delete(domainKey, orgId);
	}

	public static void delete(String domainKey, String orgId, String userId) throws StorageException{
		dao().delete(domainKey, orgId, userId);
	}

	public static Collection<IOrganizationUser> list(String domainKey, String orgId, int page, int pageSize) throws StorageException{
		return dao().list(domainKey, orgId, page, pageSize);
	}

	public static Collection<IOrganizationUser> listNext(String domainKey, String orgId, String userId, int page, int pageSize) throws StorageException{
		return dao().listNext(domainKey, orgId, userId, page, pageSize);
	}

	public static Collection<IOrganizationUser> search(String domainKey, String orgId, String query, int pageSize) throws StorageException{
		return dao().search(domainKey, orgId, query, pageSize);
	}

	public static Class<? extends IOrganizationUser> clazz() {
		return dao().clazz();
	}
	
	public static void createOrUpdate(IOrganizationUser e) throws StorageException{
		dao().createOrUpdate(e);
	}

	public static EntityIterator<IOrganizationUser> load() throws StorageException{
		return dao().load();
	}
	
	public static EntityIterator<IOrganizationUser> load(String domainKey) throws StorageException{
		return dao().load(domainKey);
	}
	
	public static long count() throws StorageException{
		return dao().count();
	}
	
	public static long count(String domainKey) throws StorageException{
		return dao().count(domainKey);
	}
	
	public static long count(String domainKey, String orgId) throws StorageException{
		return dao().count(domainKey, orgId);
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
		OrganizationUserDAO.get().createOrUpdate(this);
	}

	public default void addRole(String name, String description) {
		IOrganizationUserRole e = IOrganizationUserRole.create(getDomainKey(), getOrgId(), getUserId(), name);
		e.setDescription(description);
		OrganizationUserRoleDAO.get().createOrUpdate(e);
	}
	
	public default void removeRole(String name) {
		OrganizationUserRoleDAO.get().delete(getDomainKey(), getOrgId(), getUserId(), name);
	}

	public default boolean hasRole(String name) {
		return OrganizationUserRoleDAO.get().get(getDomainKey(), getOrgId(), getUserId(), name) != null;
	}

	@Override
	public default void copy(Object other) {
		
		IOrganizationUser o = (IOrganizationUser) other;
		
		setOrgId(o.getOrgId());
		
		IUser.super.copy(other);
	}
	
	//======================================
	// Attributes
	//======================================
	
	public String getOrgId();
	
	public void setOrgId(String orgId);
	
}
