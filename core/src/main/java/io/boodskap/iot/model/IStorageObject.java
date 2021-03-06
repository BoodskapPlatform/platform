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

import java.io.Serializable;
import java.util.Date;

import org.json.JSONObject;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.ThreadContext;

@JsonSerialize(as=IStorageObject.class)
public interface IStorageObject extends Serializable{

	//======================================
	// Default Methods
	//======================================
	
	public default void copy(Object other) {
		
		IStorageObject o = (IStorageObject) other;
		
		setRegisteredStamp(o.getRegisteredStamp() == null ? new Date() : o.getRegisteredStamp());
		setUpdatedStamp(new Date()); //We always update the recent updated stamp
		
		
	}

	public default String toJSONString() {
		try {
			return ThreadContext.toJSON(this);
		} catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
	}

	public default String toJSONPrettyString() {
		try {
			return ThreadContext.toJSONPretty(this);
		} catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
	}

	public default JSONObject toJSON() {
		return new JSONObject(this);
	}

	//======================================
	// Methods
	//======================================
	
	public void save() throws StorageException;

	//======================================
	// Attributes
	//======================================
	
	public Date getRegisteredStamp();

	public void setRegisteredStamp(Date registeredStamp);

	public Date getUpdatedStamp();

	public void setUpdatedStamp(Date updatedStamp);
	
}
