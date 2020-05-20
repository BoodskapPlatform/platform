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

import java.util.Map;
import java.util.UUID;

import io.boodskap.iot.DataType;
import io.boodskap.iot.PropertyTarget;
import io.boodskap.iot.model.ILookup;

public class LookupHelper {
	
	protected final String domainKey;
	protected final PropertyTarget target;
	protected final String targetId;
	
	public LookupHelper(String domainKey, PropertyTarget target, String targetId){
		this.domainKey = domainKey;
		this.target = target;
		this.targetId = targetId;
	}
	
	protected void put(PropertyTarget target, String targetId, DataType type, String name, String value) {
		LookupDAO.get().set(domainKey, target, targetId, type, name, value);
	}
	
	public void put(String name, boolean value){
		LookupDAO.get().set(domainKey, target, targetId, name, value);
	}
	
	public void put(String name, byte value){
		LookupDAO.get().set(domainKey, target, targetId, name, value);
	}
	
	public void put(String name, short value){
		LookupDAO.get().set(domainKey, target, targetId, name, value);
	}
	
	public void put(String name, int value){
		LookupDAO.get().set(domainKey, target, targetId, name, value);
	}
	
	public void put(String name, float value){
		LookupDAO.get().set(domainKey, target, targetId, name, value);
	}
	
	public void put(String name, double value){
		LookupDAO.get().set(domainKey, target, targetId, name, value);
	}
	
	public void put(String name, long value){
		LookupDAO.get().set(domainKey, target, targetId, name, value);
	}
	
	public void put(String name, String value){
		LookupDAO.get().set(domainKey, target, targetId, name, value);
	}
	
	public void put(String name, UUID value){
		LookupDAO.get().set(domainKey, target, targetId, name, value);
	}
	
	public void put(String name, byte[] value){
		LookupDAO.get().set(domainKey, target, targetId, name, value);
	}
	
	public void put(String name, Boolean value){
		LookupDAO.get().set(domainKey, target, targetId, name, value);
	}
	
	public void put(String name, Byte value){
		LookupDAO.get().set(domainKey, target, targetId, name, value);
	}
	
	public void put(String name, Short value){
		LookupDAO.get().set(domainKey, target, targetId, name, value);
	}
	
	public void put(String name, Integer value){
		LookupDAO.get().set(domainKey, target, targetId, name, value);
	}
	
	public void put(String name, Float value){
		LookupDAO.get().set(domainKey, target, targetId, name, value);
	}
	
	public void put(String name, Double value){
		LookupDAO.get().set(domainKey, target, targetId, name, value);
	}
	
	public void put(String name, Long value){
		LookupDAO.get().set(domainKey, target, targetId, name, value);
	}
	
	public void put(String name, Byte[] value){
		LookupDAO.get().set(domainKey, target, targetId, name, value);
	}
	
	public void put(String name, Map<String, Object> value){
		LookupDAO.get().set(domainKey, target, targetId, name, value);
	}
	
	public ILookup getValue(String name) {
		return LookupDAO.get().get(domainKey, target, targetId, name);
	}
	
	public void remove(String name) {
		LookupDAO.get().delete(name, target, targetId, name);
	}
	
	public boolean has(String name){
		return get(name) != null;
	}
	
	public Object get(String name){
		return LookupDAO.get().get(domainKey, target, targetId, name);
	}
	
}
