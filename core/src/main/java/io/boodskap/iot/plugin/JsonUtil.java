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
package io.boodskap.iot.plugin;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {

	public static final ObjectMapper mapper = new ObjectMapper();
	public static final ObjectMapper ciMapper = new ObjectMapper();
	public static final TypeReference<Map<String, Object>> TR = new TypeReference<Map<String, Object>>(){};
	
	static {
		ciMapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
		ciMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		ciMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS"));
		ciMapper.configure(Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
		ciMapper.configure(Feature.ALLOW_MISSING_VALUES, true);		
	}

	public static String toJSON(Object object) throws JsonProcessingException {
		return mapper.writeValueAsString(object);
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
		
		ObjectMapper m = caseSensitive ? mapper : ciMapper;

		return m.readValue(dataJson, c);
	}

	public static Map<String, Object> jsonToMap(String dataJson) throws JsonParseException, JsonMappingException, IOException {
		
		dataJson = dataJson.trim();
		if (dataJson.startsWith("\"")) {
			dataJson = dataJson.replaceAll("\\\\", "");
			dataJson = dataJson.substring(1, dataJson.length() - 1);
		}

		Map<String, Object> props = mapper.readValue(dataJson, TR);

		return props;
	}
	
	public static String mapToJson( Map<String, Object> props) throws JsonProcessingException {
		return mapToJson(true, props);
	}

	public static String mapToJson(boolean caseSensitive, Map<String, Object> props) throws JsonProcessingException {
		ObjectMapper m = caseSensitive ? mapper : ciMapper;
		return m.writeValueAsString(props);
	}

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
		return mapper.convertValue(node, Map.class);
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
	
}
