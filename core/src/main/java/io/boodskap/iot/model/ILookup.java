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

import java.util.UUID;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.ArrayUtils;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import io.boodskap.iot.BoodskapSystem;
import io.boodskap.iot.DataType;
import io.boodskap.iot.PropertyTarget;
import io.boodskap.iot.StorageException;
import io.boodskap.iot.ThreadContext;
import io.boodskap.iot.dao.LookupDAO;

@JsonSerialize(as=ILookup.class)
public interface ILookup extends IDomainObject{

	public static ILookup create(String domainKey, PropertyTarget target, String targetId, String name) {
		return BoodskapSystem.storage().getLookupDAO().create(domainKey, target, targetId, name);
	}	

	@Override
	public default void save() {
		LookupDAO.get().createOrUpdate(this);
	}
	
	public default Object get() {
		
		try {
			
			switch(getType()) {
			case BOOLEAN:
				return Boolean.valueOf(getValue());
			case _boolean:
				return Boolean.valueOf(getValue()).booleanValue();
			case BYTE:
				return Byte.valueOf(getValue());
			case _byte:
				return Byte.valueOf(getValue()).byteValue();
			case CHAR:
				return Character.valueOf(getValue().charAt(0));
			case _char:
				return Character.valueOf(getValue().charAt(0)).charValue();
			case DOUBLE:
				return Double.valueOf(getValue());
			case _double:
				return Double.valueOf(getValue()).doubleValue();
			case FLOAT:
				return Float.valueOf(getValue());
			case _float:
				return Float.valueOf(getValue()).floatValue();
			case INT:
				return Double.valueOf(getValue());
			case _int:
				return Double.valueOf(getValue()).intValue();
			case LONG:
				return Long.valueOf(getValue());
			case _long:
				return Long.valueOf(getValue()).longValue();
			case SHORT:
				return Short.valueOf(getValue());
			case _short:
				return Short.valueOf(getValue()).shortValue();
			case BLOB:
				return ArrayUtils.toObject(Base64.decodeBase64(getValue()));
			case _blob:
				return Base64.decodeBase64(getValue());
			case UUID:
				return UUID.fromString(getValue());
			case JSON:
				return ThreadContext.jsonToMap(getValue());
			default:
			case STRING:
				return getValue();
			}
		}catch(Exception ex) {
			throw new StorageException(ex);
		}
		
	}

	@Override
	public default void copy(Object other) {
		
		ILookup o = (ILookup) other;
		
		setTarget(o.getTarget());
		setTargetId(o.getTargetId());
		setValue(o.getValue());
		setType(o.getType());
		
		IDomainObject.super.copy(other);
	}
	
	public PropertyTarget getTarget();

	public void setTarget(PropertyTarget target);

	public String getTargetId();

	public void setTargetId(String targetId);

	public String getValue();

	public void setValue(String value);

	public DataType getType();

	public void setType(DataType type);
	
}
