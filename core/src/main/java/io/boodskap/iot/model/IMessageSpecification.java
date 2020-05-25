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

import io.boodskap.iot.BoodskapSystem;
import io.boodskap.iot.DataType;
import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.MessageSpecDAO;

@JsonSerialize(as=IMessageSpecification.class)
public interface IMessageSpecification extends IDomainObject {
	
	public static MessageSpecDAO<IMessageSpecification> dao() {
		return  BoodskapSystem.dynamicStorage().getMessageSpecDAO();
	}
	
	public static Class<? extends IMessageSpecification> clazz() {
		return dao().clazz();
	}
	
	public static Class<? extends IMessageField> fieldClazz() {
		return dao().fieldClazz();
	}
	
	public static IMessageSpecification create(String domainKey, String specId) {
		return dao().create(domainKey, specId);
	}

	public static IMessageSpecification find(String domainKey, String specId) {
		return dao().get(domainKey, specId);
	}

	public default void save() {
		IMessageSpecification.dao().createOrUpdate(this);
	}

	public IMessageField createField(String name, DataType dataType) throws StorageException;
	
	public void addField(IMessageField field) throws StorageException;
	
	public void modifyField(IMessageField field) throws StorageException;
	
	public void removeField(String name) throws StorageException;

	public String getSpecId();

	public void setSpecId(String specId);

	public <T extends IMessageField> Collection<T> getFields();
	
	public void setFields(Collection<? extends IMessageField> fields);
}
