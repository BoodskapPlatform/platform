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

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import io.boodskap.iot.dao.AssetGroupDAO;

@JsonSerialize(as=IAssetGroup.class)
public interface IAssetGroup extends IGroup {

	public static AssetGroupDAO<IAssetGroup> dao(){
		return AssetGroupDAO.get();
	}
	
	public static Class<? extends IAssetGroup> clazz() {
		return dao().clazz();
	}
	
	public static IAssetGroup create(String domainKey, String ownerAssetId, String groupId) {
		return dao().create(domainKey, ownerAssetId, groupId);
	}

	public static IAssetGroup find(String domainKey, String ownerAssetId, String groupId) {
		return dao().get(domainKey, ownerAssetId, groupId);
	}

	public default void save() {
		IAssetGroup.dao().createOrUpdate(this);
	}

	public String getOwnerAssetId();

	public void setOwnerAssetId(String ownerAssetId);

}
