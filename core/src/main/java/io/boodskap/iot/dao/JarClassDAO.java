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
import io.boodskap.iot.model.IJarClass;

public interface JarClassDAO<T extends IJarClass>{
	
	public static JarClassDAO<IJarClass> get() {
		return BoodskapSystem.storage().getJarClassDAO();
	}

	public Class<? extends T> clazz();
	
	public T create(String loader, String fileName, String pkg, String name);
	
	public void createOrUpdate(T e) throws StorageException;

	public long count() throws StorageException;
	
	public long count(String loader) throws StorageException;
	
	public long count(String loader, String fileName) throws StorageException;
	
	public long count(String loader, String fileName, String pkg) throws StorageException;
	
	public long countPackage(String loader, String pkg) throws StorageException;
	
	public void delete() throws StorageException;

	public void delete(String loader) throws StorageException;

	public void delete(String loader, String fileName) throws StorageException;
	
	public EntityIterator<T> load() throws StorageException;
	
	public EntityIterator<T> load(String loader) throws StorageException;
	
	public Collection<T> listClasses(String loader, int page, int pageSize) throws StorageException;
	
	public Collection<T> listNextClasses(String loader, String fileName, String pkg, String name, int page, int pageSize) throws StorageException;
	
	public Collection<T> listPackageClasses(String loader, String pkg, int page, int pageSize) throws StorageException;
	
	public Collection<T> listNextPackageClasses(String loader, String fileName, String pkg, String name, int page, int pageSize) throws StorageException;
	
	public Collection<T> listArchiveClasses(String loader, String fileName, int page, int pageSize) throws StorageException;
	
	public Collection<T> listNextArchiveClasses(String loader, String fileName, String pkg, String name, int page, int pageSize) throws StorageException;
	
	public Collection<T> listArchivePackageClasses(String loader, String fileName, String pkg, int page, int pageSize) throws StorageException;
	
	public Collection<T> listNextArchivePackageClasses(String loader, String fileName, String pkg, String name, int page, int pageSize) throws StorageException;
	
	public Collection<String> listPackages(String loader, int page, int pageSize) throws StorageException;
	
	public Collection<String> listNextPackages(String loader, String fileName, String pkg, int page, int pageSize) throws StorageException;
	
	public Collection<String> listArchivePackages(String loader, String fileName, int page, int pageSize) throws StorageException;
	
	public Collection<String> listNextArchivePackages(String loader, String fileName, String pkg, int page, int pageSize) throws StorageException;
	
	public Collection<T> search(String query, int pageSize) throws StorageException;
}
