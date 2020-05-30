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

import io.boodskap.iot.BoodskapSystem;
import io.boodskap.iot.dao.OrganizationAssetDAO;

@JsonSerialize(as=IOrganizationAsset.class)
public interface IOrganizationAsset extends IAsset{

	public static OrganizationAssetDAO<IOrganizationAsset> dao(){
		return OrganizationAssetDAO.get();
	}

	public static Class<? extends IOrganizationAsset> clazz() {
		return dao().clazz();
	}

	public static IOrganizationAsset find(String domainKey, String orgId, String assetId) {
		return dao().get(domainKey, orgId, assetId);
	}

	public static IOrganizationAsset create(String domainKey, String orgId, String assetId) {
		return BoodskapSystem.storage().getOrganizationAssetDAO().create(domainKey, orgId, assetId);
	}
	
	@Override
	public default void save() {
		dao().createOrUpdate(this);
	}

	@Override
	public default void copy(Object other) {
		
		IOrganizationAsset o = (IOrganizationAsset) other;
		
		setOrgId(o.getOrgId());
		
		IAsset.super.copy(other);
	}
	
	public String getOrgId();

	public void setOrgId(String orgId);

}
