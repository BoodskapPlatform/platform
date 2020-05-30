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
import java.util.Map;
import java.util.UUID;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.ArrayUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import io.boodskap.iot.DataType;
import io.boodskap.iot.StorageException;
import io.boodskap.iot.ThreadContext;

@JsonSerialize(as=IDynamicField.class)
public interface IDynamicField extends IField {
	
	public default void setField(String name, Serializable value) throws StorageException {
		
		try {
			
			setName(name);
			
			if(null == value) {
				setDataType(DataType.STRING);
				return;
			}
			
			
			String converted = value.toString();
			DataType dataType = DataType.STRING;
			boolean primitive = value.getClass().isPrimitive();
			Double nvalue = null;
			
			if(value instanceof Byte) {
				dataType = primitive ? DataType._byte : DataType.BYTE;
				nvalue = ((Byte)value).doubleValue();
			}else if(value instanceof Boolean) {
				dataType = primitive ? DataType._boolean : DataType.BOOLEAN;
			}else if(value instanceof Short) {
				dataType = primitive ? DataType._short : DataType.SHORT;
				nvalue = ((Short)value).doubleValue();
			}else if(value instanceof Integer) {
				dataType = primitive ? DataType._int : DataType.INT;			
				nvalue = ((Integer)value).doubleValue();
			}else if(value instanceof Long) {
				dataType = primitive ? DataType._long : DataType.LONG;
				nvalue = ((Long)value).doubleValue();
			}else if(value instanceof Float) {
				dataType = primitive ? DataType._float : DataType.FLOAT;
				nvalue = ((Float)value).doubleValue();
			}else if(value instanceof Double) {
				dataType = primitive ? DataType._double : DataType.DOUBLE;
				nvalue = (Double)value;
			}else if(value instanceof Character) {
				dataType = primitive ? DataType._char : DataType.CHAR;
			}else if(value instanceof String) {
				dataType = DataType.STRING;
			}else if(value instanceof UUID) {
				dataType = DataType.UUID;
			}else if(value instanceof Byte[]) {
				dataType = DataType.BLOB;
				Byte[] barr = (Byte[]) value;
				converted = Base64.encodeBase64String(ArrayUtils.toPrimitive(barr));
			}else if(value instanceof byte[]) {
				dataType = DataType._blob;
				byte[] barr = (byte[]) value;
				converted = Base64.encodeBase64String(barr);
			}else if(value instanceof Map<?,?>){
				dataType = DataType.JSON;
				@SuppressWarnings("unchecked")
				Map<String,Object> json = (Map<String, Object>) value;
				converted = ThreadContext.mapToJson(json);
			}
			
			setDataType(dataType);
			
			setNvalue(nvalue);
			setValue(converted);
			
		}catch(Exception ex) {
			throw new StorageException(ex);
		}
		
	}

	
	@JsonIgnore
	public default Serializable getFieldValue() throws StorageException {
		
		try {
			
			final DataType dataType = getDataType();
			final String value = getValue();
			
			if(null == value) return null;
			
			switch(dataType) {
			case BLOB:
				return ArrayUtils.toObject(Base64.decodeBase64(value));
			case BOOLEAN:
				return Boolean.valueOf(value);
			case BYTE:
				return Byte.valueOf(value);
			case CHAR:
				return Character.valueOf(value.charAt(0));
			case DOUBLE:
				return Double.valueOf(value);
			case FLOAT:
				return Float.valueOf(value);
			case INT:
				return Integer.valueOf(value);
			case JSON:
				return (Serializable) ThreadContext.jsonToMap(value);
			case LONG:
				return Long.valueOf(value);
			case SHORT:
				return Short.valueOf(value);
			case STRING:
				return value;
			case UUID:
				return UUID.fromString(value);
			case _blob:
				return Base64.decodeBase64(value);
			case _boolean:
				return Boolean.valueOf(value).booleanValue();
			case _byte:
				return Byte.valueOf(value).byteValue();
			case _char:
				return value.charAt(0);
			case _double:
				return Double.valueOf(value).doubleValue();
			case _float:
				return Float.valueOf(value).floatValue();
			case _int:
				return Integer.valueOf(value).intValue();
			case _long:
				return Long.valueOf(value).longValue();
			case _short:
				return Short.valueOf(value).shortValue();
			}
			
			throw new StorageException(String.format("Unknown data type: %s", dataType));
			
		}catch(Exception ex) {
			throw new StorageException(ex);
		}
		
	}

	public String getValue();
	
	public void setValue(String value);

	public Double getNvalue();
	
	public void setNvalue(Double nvalue);

}
