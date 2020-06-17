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

import java.util.Collection;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
import org.json.JSONObject;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.dao.SystemPropertyDAO;

@JsonSerialize(as=ISystemProperty.class)
public interface ISystemProperty extends IStorable, IModel {
	
	//======================================
	// DAO Methods
	//======================================
	
	@JsonIgnore
	public static SystemPropertyDAO<ISystemProperty> dao() {
		return SystemPropertyDAO.get();
	}
	
	@JsonIgnore
	public static Class<? extends ISystemProperty> clazz(){
		return dao().clazz();
	}
	
	@JsonIgnore
	public static ISystemProperty create(String name)  throws StorageException{
		return dao().create(name);
	}
	
	@JsonIgnore
	public static void createOrUpdate(ISystemProperty e)  throws StorageException{
		dao().createOrUpdate(e);
	}

	@JsonIgnore
	public static EntityIterator<ISystemProperty> load() throws StorageException{
		return dao().load();
	}
	
	@JsonIgnore
	public static long count() throws StorageException{
		return dao().count();
	}
	
	@JsonIgnore
	public static void delete() throws StorageException{
		dao().delete();
	}

	@JsonIgnore
	public static void delete(String name) throws StorageException{
		dao().delete(name);
	}

	@JsonIgnore
	public static ISystemProperty get(String name) throws StorageException{
		return dao().get(name);
	}

	@JsonIgnore
	public static Collection<ISystemProperty> list(int page, int pageSize) throws StorageException{
		return dao().list(page, pageSize);
	}

	@JsonIgnore
	public static Collection<ISystemProperty> listNext(String name, int page, int pageSize) throws StorageException{
		return dao().listNext(name, page, pageSize);
	}

	@JsonIgnore
	public static Collection<ISystemProperty> search(String query, int pageSize) throws StorageException{
		return dao().search(query, pageSize);
	}
	
	//======================================
	// Default Methods
	//======================================
	
	@JsonIgnore
	public default void save() {
		dao().createOrUpdate(this);
	}
	
	@JsonIgnore
	public default Object value(){
		
		try {

			String value = getValue();
			
			switch(getFormat()) {
			case BASE64:
				return Base64.decodeBase64(value);
			case HEX:
				return Hex.decodeHex(value);
			case JSON:
				return new JSONObject(value);
			default:
			case AS_IS:
				return value;
			}
			
		}catch(Exception ex) {
			throw new StorageException(ex);
		}
		
	}

	//======================================
	// Attributes
	//======================================
	
	public String getValue();

	public void setValue(String value);

}
