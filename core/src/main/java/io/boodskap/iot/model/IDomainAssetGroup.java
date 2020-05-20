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

import io.boodskap.iot.dao.DomainAssetGroupDAO;

@JsonSerialize(as=IDomainAssetGroup.class)
public interface IDomainAssetGroup extends IGroup {

	public static DomainAssetGroupDAO<IDomainAssetGroup> dao(){
		return DomainAssetGroupDAO.get();
	}
	
	public static Class<? extends IDomainAssetGroup> clazz() {
		return dao().clazz();
	}
	
	public static IDomainAssetGroup create(String domainKey, String groupId) {
		return dao().create(domainKey, groupId);
	}

	public static IDomainAssetGroup find(String domainKey, String groupId) {
		return dao().get(domainKey, groupId);
	}

	public default void save() {
		IDomainAssetGroup.dao().createOrUpdate(this);
	}

}
