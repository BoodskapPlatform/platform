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
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import io.boodskap.iot.BoodskapSystem;
import io.boodskap.iot.ThreadContext;
import io.boodskap.iot.dao.RecordDAO;

@JsonSerialize(as=IRecord.class)
public interface IRecord extends IDomainObject {
	
	public static RecordDAO<IRecord> dao() {
		return  BoodskapSystem.dynamicStorage().getRecordDAO();
	}
	
	public static IRecord create(String domainKey, String specId, String recordId) {
		return IRecord.dao().create(domainKey, specId, recordId);
	}

	public static IRecord find(String domainKey, String specId, String recordId) {
		return IRecord.dao().get(domainKey, specId, recordId);
	}

	public IDynamicRecordField createField(String name);

	public String getRecordId();

	public void setRecordId(String recordId);

	public String getSpecId();

	public void setSpecId(String specId);

	@JsonIgnore
	public <T extends IDynamicRecordField> Collection<T> getFields();

	public void setFields(Collection<? extends IDynamicRecordField> data);
	
	public default void clearData() {
		getFields().clear();
	}
	
	public default Map<String, Object> getData(){
		Map<String, Object> fields = new HashMap<String, Object>();
		Collection<IDynamicRecordField> data = getFields();
		if(null != data) {
			data.forEach(f -> {
				fields.put(f.getName(), f.getFieldValue());
			});
		}
		return fields;
	}

	public default void setData(JsonNode data) {
		Map<String, Object> fields = ThreadContext.toMap(data);
		setData(fields);
	}

	public default void setData(JSONObject data) throws JSONException {
		Map<String, Object> fields = ThreadContext.toMap(data);
		setData(fields);
	}

	public default void setData(org.json.JSONObject data) throws JSONException {
		Map<String, Object> fields = data.toMap();
		setData(fields);
	}

	@SuppressWarnings("unchecked")
	public default void setData(Object data) throws JSONException {
		
		if(data instanceof Map<?, ?>) {
			setData(((Map<String,Object>)data));
		}else {
			setData(new org.json.JSONObject(data));
		}
	}

	public default void setData(Map<String, Object> fields){
		
		for(Map.Entry<String, Object> me : fields.entrySet()) {
			IDynamicRecordField mf = createField(me.getKey());
			mf.setField(me.getKey(), (Serializable) me.getValue());
			getFields().add(mf);
		}
		
	}

	public default void save() {
		IRecord.dao().createOrUpdate(this);
	}

}
