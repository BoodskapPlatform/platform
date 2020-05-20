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
package io.boodskap.iot;

import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;

public class ThreadContext {

	public static final ObjectMapper mapper = new ObjectMapper();
	public static final ObjectMapper mapperP = new ObjectMapper();
	public static final ObjectMapper ciMapper = new ObjectMapper();
	
	static {
		ciMapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
		ciMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		ciMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS"));
		ciMapper.configure(Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
		ciMapper.configure(Feature.ALLOW_MISSING_VALUES, true);
		
		SimpleModule module = new SimpleModule();
		
		mapper.registerModule(module);
		ciMapper.registerModule(module);
		
		mapperP.enable(SerializationFeature.INDENT_OUTPUT);
	}
	
	public static final TypeReference<Map<String, Object>> TR = new TypeReference<Map<String, Object>>() {
	};
	
	public static final ThreadLocal<AuthToken> AUTH = new ThreadLocal<AuthToken>() {
		@Override
		protected AuthToken initialValue() {
			return new AuthToken();
		}
	};
	
	public static final ThreadLocal<Calendar> CALENDAR = new ThreadLocal<Calendar>() {
		@Override
		protected Calendar initialValue() {
			return Calendar.getInstance();
		}
	};
	
	public static String toJSON(Object object) throws JsonProcessingException {
		return mapper.writeValueAsString(object);
	}
	
	public static String toJSONPretty(Object object) throws JsonProcessingException {
		return mapperP.writeValueAsString(object);
	}
	
	public static <T> T jsonToObject(JSONObject json, Class<T> c) throws JsonParseException, JsonMappingException, IOException{
		return jsonToObject(json.toString(), c);
	}

	public static <T> T jsonToObject(String dataJson, Class<T> c) throws JsonParseException, JsonMappingException, IOException{
		return jsonToObject(true, dataJson, c);
	}

	public static <T> T jsonToObject(boolean caseSensitive, String dataJson, Class<T> c) throws JsonParseException, JsonMappingException, IOException{
		
		dataJson = dataJson.trim();
		if (dataJson.startsWith("\"")) {
			dataJson = dataJson.replaceAll("\\\\", "");
			dataJson = dataJson.substring(1, dataJson.length() - 1);
		}
		
		ObjectMapper m = caseSensitive ? ThreadContext.mapper : ThreadContext.ciMapper;

		return m.readValue(dataJson, c);
	}

	public static Map<String, Serializable> jsonToMap(String dataJson) throws JsonParseException, JsonMappingException, IOException {
		
		dataJson = dataJson.trim();
		if (dataJson.startsWith("\"")) {
			dataJson = dataJson.replaceAll("\\\\", "");
			dataJson = dataJson.substring(1, dataJson.length() - 1);
		}

		Map<String, Serializable> props = ThreadContext.mapper.readValue(dataJson, TR);

		return props;
	}
	
	public static String mapToJson( Map<String, Object> props) throws JsonProcessingException {
		return mapToJson(true, props);
	}

	public static String mapToJson(boolean caseSensitive, Map<String, Object> props) throws JsonProcessingException {
		ObjectMapper m = caseSensitive ? ThreadContext.mapper : ThreadContext.ciMapper;
		return m.writeValueAsString(props);
	}

	@SuppressWarnings("unchecked")
	public static Map<String, Object> toMap(JSONObject object) throws JSONException {
	    Map<String, Object> map = new HashMap<String, Object>();
	 
	    Iterator<String> keysItr = object.keys();
	    while(keysItr.hasNext()) {
	        String key = keysItr.next();
	        Object value = object.get(key);
	 
	        if(value instanceof JSONArray) {
	            value = toList((JSONArray) value);
	        }
	 
	        else if(value instanceof JSONObject) {
	            value = toMap((JSONObject) value);
	        }
	        map.put(key, value);
	    }
	    return map;
	}
	 
	@SuppressWarnings("unchecked")
	public static Map<String, Object> toMap(JsonNode node) {
		return ThreadContext.mapper.convertValue(node, Map.class);
	}

	public static List<Object> toList(JSONArray array) throws JSONException {
		
	    List<Object> list = new ArrayList<Object>();
	    for(int i = 0; i < array.length(); i++) {
	        Object value = array.get(i);
	        if(value instanceof JSONArray) {
	            value = toList((JSONArray) value);
	        }
	 
	        else if(value instanceof JSONObject) {
	            value = toMap((JSONObject) value);
	        }
	        list.add(value);
	    }
	    return list;
	}
	
	public static long longHash(String string) {
		long h = 98764321261L;
		int l = string.length();
		char[] chars = string.toCharArray();

		for (int i = 0; i < l; i++) {
			h = 31 * h + chars[i];
		}
		return h;
	}
	
	public static String uniqueHash(String string) {
		return String.valueOf(longHash(string));
	}

}
