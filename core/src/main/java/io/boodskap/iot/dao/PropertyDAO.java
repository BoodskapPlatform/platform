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
import io.boodskap.iot.PropertyTarget;
import io.boodskap.iot.StorageException;
import io.boodskap.iot.model.IProperty;

public interface PropertyDAO<T extends IProperty> extends DAO<T> {
	
	public static PropertyDAO<IProperty> get() {
		return BoodskapSystem.storage().getPropertyDAO();
	}

	public T create(String domainKey, PropertyTarget target, String targetId, String name) throws StorageException;

	public T get(String domainKey, PropertyTarget target, String targetId, String name) throws StorageException;

	public long count(String domainKey, PropertyTarget target) throws StorageException;

	public long count(String domainKey, PropertyTarget target, String targetId) throws StorageException;

	public void delete(String domainKey, PropertyTarget target, String targetId) throws StorageException;

	public void delete(String domainKey, PropertyTarget target, String targetId, String name) throws StorageException;

	public Collection<T> list(String domainKey, PropertyTarget target, String targetId, int page, int pageSize) throws StorageException;

	public Collection<T> listNext(String domainKey, PropertyTarget target, String targetId, String name, int page, int pageSize) throws StorageException;

	public Collection<T> search(String domainKey, PropertyTarget target, String targetId, String query, int pageSize) throws StorageException;
}
