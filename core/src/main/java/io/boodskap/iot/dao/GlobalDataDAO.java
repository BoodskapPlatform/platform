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

import io.boodskap.iot.BoodskapSystem;
import io.boodskap.iot.StorageException;
import io.boodskap.iot.model.IGlobalData;

public interface GlobalDataDAO<T extends IGlobalData> extends DAO<T> {
	
	public static <T extends IGlobalData> GlobalDataDAO<T> get() {
		return BoodskapSystem.storage().getGlobalDataDAO();
	}

	public T create(String id, String domainKey) throws StorageException;

	public T get(String id) throws StorageException;

	public T get(String id, String domainKey) throws StorageException;

	public void delete(String id, String domainKey) throws StorageException;

}
