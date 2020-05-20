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
package io.boodskap.iot.dao;

import java.util.Collection;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.ArrayUtils;

import io.boodskap.iot.BoodskapSystem;
import io.boodskap.iot.DataType;
import io.boodskap.iot.PropertyTarget;
import io.boodskap.iot.StorageException;
import io.boodskap.iot.ThreadContext;
import io.boodskap.iot.model.ILookup;

public interface LookupDAO<T extends ILookup> extends DAO<T> {
	
	public static <T extends ILookup> LookupDAO<T> get() {
		return BoodskapSystem.storage().getLookupDAO();
	}

	public T create(String domainKey, PropertyTarget target, String targetId, String name) throws StorageException;
	
	public T get(String domainKey, PropertyTarget target, String targetId, String name) throws StorageException;
	
	public long count(String domainKey, PropertyTarget target) throws StorageException;

	public void set(String domainKey, PropertyTarget target, String targetId, DataType type, String name, String value) throws StorageException;

	public void delete(String domainKey, PropertyTarget target) throws StorageException;

	public void delete(String domainKey, PropertyTarget target, String targetId) throws StorageException;

	public void delete(String domainKey, PropertyTarget target, String targetId, String name) throws StorageException;

	public Collection<T> list(String domainKey, PropertyTarget target, int page, int pageSize) throws StorageException;

	public Collection<T> listNext(String domainKey, PropertyTarget target, String name, int page, int pageSize) throws StorageException;

	public Collection<T> search(String domainKey, PropertyTarget target, String query, int pageSize) throws StorageException;

	public default void set(String domainKey, PropertyTarget target, String targetId, String name, Map<String, Object> value) throws StorageException{
		try {
			set(domainKey, target, targetId, DataType.JSON, name, ThreadContext.mapToJson(value));
		} catch (Exception e) {
			throw new StorageException(e);
		}
	}
	
	public default void set(String domainKey, PropertyTarget target, String targetId, String name, UUID value) throws StorageException{
		set(domainKey, target, targetId, DataType.UUID, name, value.toString());
	}
	
	public default void set(String domainKey, PropertyTarget target, String targetId, String name, String value) throws StorageException{
		set(domainKey, target, targetId, DataType.STRING, name, value);
	}
	
	public default void set(String domainKey, PropertyTarget target, String targetId, String name, Byte[] value) throws StorageException{
		set(domainKey, target, targetId, DataType.BLOB, name, Base64.encodeBase64String(ArrayUtils.toPrimitive(value)));
	}
	
	public default void set(String domainKey, PropertyTarget target, String targetId, String name, byte[] value) throws StorageException{
		set(domainKey, target, targetId, DataType._blob, name, Base64.encodeBase64String(value));
	}
	
	public default void set(String domainKey, PropertyTarget target, String targetId, String name, Byte value) throws StorageException{
		set(domainKey, target, targetId, DataType.BYTE, name, value.toString());
	}
	
	public default void set(String domainKey, PropertyTarget target, String targetId, String name, byte value) throws StorageException{
		set(domainKey, target, targetId, DataType._byte, name, String.valueOf(value));
	}
	
	public default void set(String domainKey, PropertyTarget target, String targetId, String name, Short value) throws StorageException{
		set(domainKey, target, targetId, DataType.SHORT, name, value.toString());
	}
	
	public default void set(String domainKey, PropertyTarget target, String targetId, String name, short value) throws StorageException{
		set(domainKey, target, targetId, DataType._short, name, String.valueOf(value));
	}
	
	public default void set(String domainKey, PropertyTarget target, String targetId, String name, Integer value) throws StorageException{
		set(domainKey, target, targetId, DataType.INT, name, value.toString());
	}
	
	public default void set(String domainKey, PropertyTarget target, String targetId, String name, int value) throws StorageException{
		set(domainKey, target, targetId, DataType._int, name, String.valueOf(value));
	}
	
	public default void set(String domainKey, PropertyTarget target, String targetId, String name, Long value) throws StorageException{
		set(domainKey, target, targetId, DataType.LONG, name, value.toString());
	}
	
	public default void set(String domainKey, PropertyTarget target, String targetId, String name, long value) throws StorageException{
		set(domainKey, target, targetId, DataType._long, name, String.valueOf(value));
	}
	
	public default void set(String domainKey, PropertyTarget target, String targetId, String name, Float value) throws StorageException{
		set(domainKey, target, targetId, DataType.FLOAT, name, value.toString());
	}
	
	public default void set(String domainKey, PropertyTarget target, String targetId, String name, float value) throws StorageException{
		set(domainKey, target, targetId, DataType._float, name, String.valueOf(value));
	}
	
	public default void set(String domainKey, PropertyTarget target, String targetId, String name, Double value) throws StorageException{
		set(domainKey, target, targetId, DataType.DOUBLE, name, value.toString());
	}
	
	public default void set(String domainKey, PropertyTarget target, String targetId, String name, double value) throws StorageException{
		set(domainKey, target, targetId, DataType._double, name, String.valueOf(value));
	}
	
	public default void set(String domainKey, PropertyTarget target, String targetId, String name, Boolean value) throws StorageException{
		set(domainKey, target, targetId, DataType.BOOLEAN, name, value.toString());
	}
	
	public default void set(String domainKey, PropertyTarget target, String targetId, String name, boolean value) throws StorageException{
		set(domainKey, target, targetId, DataType._boolean, name, String.valueOf(value));
	}
	
	public default void set(String domainKey, PropertyTarget target, String targetId, String name, Character value) throws StorageException{
		set(domainKey, target, targetId, DataType.CHAR, name, value.toString());
	}
	
	public default void set(String domainKey, PropertyTarget target, String targetId, String name, char value) throws StorageException{
		set(domainKey, target, targetId, DataType._char, name, String.valueOf(value));
	}
	
	public default Object getValue(String domainKey, PropertyTarget target, String targetId, String name) throws StorageException {
		
		ILookup val = get(domainKey, target, targetId, name);
		
		if(null != val) {
			return val.get();
		}
		
		return null;
		
	}
}
