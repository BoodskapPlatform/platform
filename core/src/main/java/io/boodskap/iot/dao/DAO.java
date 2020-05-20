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

import io.boodskap.iot.StorageException;

public interface DAO<T> {
	
	public Class<? extends T> clazz();
	
	public void createOrUpdate(T e) throws StorageException;

	public EntityIterator<T> load() throws StorageException;
	
	public EntityIterator<T> load(String domainKey) throws StorageException;
	
	public long count() throws StorageException;
	
	public long count(String domainKey) throws StorageException;
	
	public void delete() throws StorageException;
	
	public void delete(String domainKey) throws StorageException;

}
