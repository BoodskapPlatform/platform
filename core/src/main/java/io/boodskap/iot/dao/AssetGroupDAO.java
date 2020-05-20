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
import io.boodskap.iot.model.IAssetGroup;

public interface AssetGroupDAO<T extends IAssetGroup> extends DAO<T>{
	
	public static AssetGroupDAO<IAssetGroup> get() {
		return BoodskapSystem.storage().getAssetGroupDAO();
	}

	public IAssetGroup create(String domainKey, String ownerAssetId, String groupId);
	
	public T get(String domainKey, String ownerAssetId, String groupId) throws StorageException;

	public void delete(String domainKey, String ownerAssetId, String groupId) throws StorageException;

	public void delete(String domainKey, String ownerAssetId) throws StorageException;

	public long count(String domainKey, String ownerAssetId) throws StorageException;

	public Collection<T> list(String domainKey, String ownerAssetId, int page, int pageSize) throws StorageException;

	public Collection<T> listNext(String domainKey, String ownerAssetId, String groupId, int page, int pageSize) throws StorageException;

	public Collection<T> search(String domainKey, String query, int pageSize) throws StorageException;
}
