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
import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import io.boodskap.iot.BoodskapSystem;
import io.boodskap.iot.DataType;
import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.RecordSpecDAO;

@JsonSerialize(as=IRecordSpecification.class)
public interface IRecordSpecification extends IDomainObject {

	public static RecordSpecDAO<IRecordSpecification> dao() {
		return  BoodskapSystem.dynamicStorage().getRecordSpecDAO();
	}
	
	public static Class<? extends IRecordSpecification> clazz() {
		return dao().clazz();
	}
	
	public static Class<? extends IRecordField> fieldClazz() {
		return dao().fieldClazz();
	}
	
	public static IRecordSpecification create(String domainKey, String specId) {
		return dao().create(domainKey, specId);
	}

	public static IRecordSpecification find(String domainKey, String specId) {
		return dao().get(domainKey, specId);
	}

	public default void save() {
		IRecordSpecification.dao().createOrUpdate(this);
	}

	public IRecordField createField(String name, DataType dataType) throws StorageException;
	
	public void addField(IRecordField field) throws StorageException;
	
	public void modifyField(IRecordField field) throws StorageException;
	
	public void removeField(String name) throws StorageException;

	public String getSpecId();

	public void setSpecId(String specId);

	public String getName();

	public void setName(String name);

	public String getDescription();

	public void setDescription(String description);

	public <T extends IRecordField> Collection<T> getFields();
	
	public void setFields(Collection<? extends IRecordField> fields);

	public Date getCreatedStamp();
	
	public void setCreatedStamp(Date createdStamp);
	
	public Date getUpdatedStamp();
	
	public void setUpdatedStamp(Date updatedStamp);
}
