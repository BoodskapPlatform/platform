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

import io.boodskap.iot.dao.AssetFileDAO;

@JsonSerialize(as=IAssetFile.class)
public interface IAssetFile extends IDomainFile {

	public static AssetFileDAO<IAssetFile> dao(){
		return AssetFileDAO.get();
	}
	
	public static Class<? extends IAssetFile> clazz() {
		return dao().clazz();
	}
	
	public static IAssetFile create(String domainKey, String assetId, String fileId) {
		return dao().create(domainKey, assetId, fileId);
	}

	public static IAssetFile find(String domainKey, String assetId, String fileId) {
		return dao().get(domainKey, assetId, fileId);
	}

	public default void save() {
		IAssetFile.dao().createOrUpdate(this);
	}

	public String getAssetId();
	
	public void setAssetId(String assetId);
}
