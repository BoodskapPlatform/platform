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
package io.boodskap.iot.dao;

import java.util.Collection;

import io.boodskap.iot.BoodskapSystem;
import io.boodskap.iot.StorageException;
import io.boodskap.iot.model.IDomainJarClass;

public interface DomainJarClassDAO<T extends IDomainJarClass> extends DAO<T> {
	
	public static DomainJarClassDAO<IDomainJarClass> get() {
		return BoodskapSystem.storage().getDomainJarClassDAO();
	}

	public T create(String domainKey, String loader, String fileName, String pkg, String name);
	
	public long count(String domainKey, String loader) throws StorageException;
	
	public long count(String domainKey, String loader, String fileName) throws StorageException;
	
	public long count(String domainKey, String loader, String fileName, String pkg) throws StorageException;
	
	public long countPackage(String domainKey, String loader, String pkg) throws StorageException;
	
	public void delete(String domainKey, String loader) throws StorageException;
	
	public void delete(String domainKey, String loader, String fileName) throws StorageException;
	
	public Collection<T> listClasses(String domainKey, String loader, int page, int pageSize) throws StorageException;
	
	public Collection<T> listNextClasses(String domainKey, String loader, String fileName, String pkg, String name, int page, int pageSize) throws StorageException;
	
	public Collection<T> listPackageClasses(String domainKey, String loader, String pkg, int page, int pageSize) throws StorageException;
	
	public Collection<T> listNextPackageClasses(String domainKey, String loader, String fileName, String pkg, String name, int page, int pageSize) throws StorageException;
	
	public Collection<T> listArchiveClasses(String domainKey, String loader, String fileName, int page, int pageSize) throws StorageException;
	
	public Collection<T> listNextArchiveClasses(String domainKey, String loader, String fileName, String pkg, String name, int page, int pageSize) throws StorageException;
	
	public Collection<T> listArchivePackageClasses(String domainKey, String loader, String fileName, String pkg, int page, int pageSize) throws StorageException;
	
	public Collection<T> listNextArchivePackageClasses(String domainKey, String loader, String fileName, String pkg, String name, int page, int pageSize) throws StorageException;
	
	public Collection<String> listPackages(String domainKey, String loader, int page, int pageSize) throws StorageException;
	
	public Collection<String> listNextPackages(String domainKey, String loader, String fileName, String pkg, int page, int pageSize) throws StorageException;
	
	public Collection<String> listArchivePackages(String domainKey, String loader, String fileName, int page, int pageSize) throws StorageException;
	
	public Collection<String> listNextArchivePackages(String domainKey, String loader, String fileName, String pkg, int page, int pageSize) throws StorageException;
	
	public Collection<T> search(String domainKey, String query, int pageSize) throws StorageException;
}
