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

@JsonSerialize(as=IDatabaseTableField.class)
public interface IDatabaseTableField extends IDomainObject {

	public static Class<? extends IDatabaseTableField> clazz() {
		return BoodskapSystem.storage().getDatabaseTableDAO().fieldClazz();
	}

	public default void save() {
		throw new UnsupportedOperationException();
	}
	
	public String getMetaDataId();
	
	public void setMetaDataId(String metaDataId);

	public String getTable();

	public void setTable(String table);

	public String getField();

	public void setField(String name);

	public String getType();

	public void setType(String type);

	public String getSize();

	public void setSize(String size);
}
