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

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import io.boodskap.iot.dao.DatabaseTableDAO;

@JsonSerialize(as=IDatabaseTable.class)
public interface IDatabaseTable extends IModel{
	
	public static DatabaseTableDAO<IDatabaseTable> dao(){
		return DatabaseTableDAO.get();
	}
	
	public static IDatabaseTable create(String domainKey, String metaDataId, String name) {
		return dao().create(domainKey, metaDataId, name);
	}

	public static IDatabaseTable find(String domainKey, String metaDataId, String name) {
		return dao().get(domainKey, metaDataId, name);
	}

	public static Class<? extends IDatabaseTable> clazz() {
		return dao().clazz();
	}
	
	public default void save() {
		IDatabaseTable.dao().createOrUpdate(this);
	}
	
	public IDatabaseTableField createField(String field);

	public String getDomainKey();

	public void setDomainKey(String domainKey);

	public String getMetaDataId();
	
	public void setMetaDataId(String metaDataId);

	public String getTable();

	public void setTable(String table);

	public String getCatalog();

	public void setCatalog(String catalog);

	public String getSchema();

	public void setSchema(String schema);

	public <T extends IDatabaseTableField> Collection<T> getFields();

	public void setFields(Collection<? extends IDatabaseTableField> fields);
}
