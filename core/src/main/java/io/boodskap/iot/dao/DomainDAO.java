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
import io.boodskap.iot.model.IDomain;

public interface DomainDAO<T extends IDomain> extends DAO<T> {
	
	public static DomainDAO<IDomain> get() {
		return BoodskapSystem.storage().getDomainDAO();
	}

	public T create(String domainKey) throws StorageException;
	
	public T get(String domainKey) throws StorageException;
	
	public Collection<T> list(int page, int pageSize) throws StorageException;
	
	public Collection<T> listNext(String domainKey, int page, int pageSize) throws StorageException;
	
	public Collection<T> search(String query, int pageSize) throws StorageException;

}
