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
import io.boodskap.iot.dao.UserDAO;
import io.boodskap.iot.dao.UserRoleDAO;

@JsonSerialize(as=IUser.class)
public interface IUser extends IPerson {
	
	//======================================
	// DAO Methods
	//======================================
	
	public static UserDAO<IUser> dao() {
		return UserDAO.get();
	}
	
	public static Class<? extends IUser> clazz() {
		return dao().clazz();
	}
	
	public static IUser create(String domainKey, String userId) throws StorageException {
		return dao().create(domainKey, userId);
	}
	
	public static IUser get(String userId) {
		return dao().get(userId);
	}
	
	public static IUser get(String domainKey, String userId) throws StorageException {
		return dao().get(domainKey, userId);
	}

	public static void delete(String domainKey, String userId) throws StorageException{
		dao().delete(domainKey, userId);
	}
	
	public static Collection<IUser> list(String domainKey, int page, int pageSize) throws StorageException{
		return dao().list(domainKey, page, pageSize);
	}

	public static Collection<IUser> listNext(String domainKey, String userId, int page, int pageSize) throws StorageException{
		return dao().listNext(domainKey, userId, page, pageSize);
	}

	public static Collection<IUser> search(String domainKey, String query, int pageSize) throws StorageException{
		return dao().search(domainKey, query, pageSize);
	}
	
	public static void createOrUpdate(IUser e) throws StorageException{
		dao().createOrUpdate(e);
	}

	public static EntityIterator<IUser> load() throws StorageException{
		return dao().load();
	}
	
	public static EntityIterator<IUser> load(String domainKey) throws StorageException{
		return dao().load(domainKey);
	}
	
	public static long countUsers(String userId) throws StorageException{
		return dao().countUsers(userId);
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
		IUser.dao().createOrUpdate(this);
	}

	public default void addRole(String name, String description) {		
		IUserRole role = IUserRole.create(getDomainKey(), getUserId(), name);
		role.setDescription(description);
		UserRoleDAO.get().createOrUpdate(role);
	}
	
	public default void removeRole(String name) {
		UserRoleDAO.get().delete(getDomainKey(), getUserId(), name);
	}

	public default void setDeveloper() {
		addRole("developer", "Platform Developer");
	}

	public default void setUser() {
		addRole("user", "Domain User");
	}

	public default void setAdmin() {
		addRole("admin", "Platform Administrator");
	}

	public default void setDomainAdmin() {
		addRole("domainadmin", "Domain Administrator");
	}

	public default void setOrganizationAdmin() {
		addRole("orgadmin", "Organization Administrator");
	}

	public default void setOrganizationUser() {
		addRole("orguser", "Organization User");
	}

	public default boolean isUser() {
		return hasRole("user");
	}

	public default boolean isAdmin() {
		return hasRole("admin");
	}

	public default boolean isDomainAdmin() {
		return hasRole("domainadmin") || isAdmin();
	}

	public default boolean isOrganizationAdmin() {
		return hasRole("orgadmin") || isDomainAdmin();
	}

	public default boolean isOrganizationUser() {
		return hasRole("orguser") || isOrganizationAdmin();
	}

	public default boolean isDeveloper() {
		return hasRole("developer") || isOrganizationAdmin();
	}

	public default boolean hasRole(String name) {
		return UserRoleDAO.get().get(getDomainKey(), getUserId(), name) != null;
	}

	//======================================
	// Attributes
	//======================================
	
	public String getUserId();
	
	public void setUserId(String userId);
}
