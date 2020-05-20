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

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import io.boodskap.iot.BoodskapSystem;
import io.boodskap.iot.EntityType;
import io.boodskap.iot.dao.LocationDAO;

@JsonSerialize(as=ILocation.class)
public interface ILocation extends IDomainObject {
	
	public static ILocation  create(String domainKey, EntityType entityType, String entityId) {
		return BoodskapSystem.storage().getLocationDAO().create(domainKey, entityType, entityId);
	}	

	public String getEntityId();

	public void setEntityId(String entityId);

	public EntityType getEntityType();

	public void setEntityType(EntityType locationType);

	public double getLatitude();
	
	public void setLatitude(double latitude);
	
	public double getLongitude();
	
	public void setLongitude(double longitude);

	public Date getCreatedStamp();
	
	public void setCreatedStamp(Date createdStamp);
	
	public Date getUpdatedStamp();
	
	public void setUpdatedStamp(Date updatedStamp);

	public default void save() {
		LocationDAO.get().createOrUpdate(this);
	}
}
