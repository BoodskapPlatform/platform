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

import io.boodskap.iot.dao.SystemPropertyDAO;

@JsonSerialize(as=ISystemProperty.class)
public interface ISystemProperty extends IStorable {
	
	public static Class<? extends ISystemProperty> clazz(){
		return SystemPropertyDAO.get().clazz();
	}
	
	public static ISystemProperty create(String name) {
		return SystemPropertyDAO.get().create(name);
	}
	
	public static ISystemProperty find(String name) {
		return SystemPropertyDAO.get().get(name);
	}
	
	public default void save() {
		SystemPropertyDAO.get().createOrUpdate(this);
	}

	public String getName();

	public void setName(String name);

	public String getValue();

	public void setValue(String value);

	public Date getCreatedStamp();
	
	public void setCreatedStamp(Date createdStamp);
	
	public Date getUpdatedStamp();
	
	public void setUpdatedStamp(Date updatedStamp);
	
}
