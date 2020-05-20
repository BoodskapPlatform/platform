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
package io.boodskap.iot.util;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.jtwig.JtwigModel;
import org.jtwig.JtwigTemplate;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import io.boodskap.iot.ThreadContext;

public class JtwigUtil {
	
	public static String merge(String template, String jsonContent) throws JsonParseException, JsonMappingException, IOException {
		JtwigTemplate t = JtwigTemplate.inlineTemplate(template);
		Map<String, Object> props = ThreadContext.mapper.readValue(jsonContent, ThreadContext.TR);
		return merge(t, props);
	}
	
	public static String merge(String template, Map<String, Object> props) throws JsonParseException, JsonMappingException, IOException {
		JtwigTemplate t = JtwigTemplate.inlineTemplate(template);
		return merge(t, props);
	}
	
	public static String mergeClasspathTemplate(String template, String jsonContent) throws JsonParseException, JsonMappingException, IOException {
		JtwigTemplate t = JtwigTemplate.classpathTemplate(template);
		Map<String, Object> props = ThreadContext.mapper.readValue(jsonContent, ThreadContext.TR);
		return merge(t, props);
	}
	
	public static String mergeClasspathTemplate(String template, Map<String, Object> props) throws JsonParseException, JsonMappingException, IOException {
		JtwigTemplate t = JtwigTemplate.classpathTemplate(template);
		return merge(t, props);
	}
	
	public static String mergeNamedTemplate(String name, Map<String, Object> props) throws JsonParseException, JsonMappingException, IOException {
		String location = String.format("/templates/%s.twig", name);
		JtwigTemplate t = JtwigTemplate.classpathTemplate(location);
		return merge(t, props);
	}
	
	public static String merge(JtwigTemplate t, Map<String, Object> props) {

		JtwigModel m = JtwigModel.newModel();
		
		for(Map.Entry<String, Object> me : props.entrySet()) {
			m.with(me.getKey(), me.getValue());
		}
		
		return t.render(m);
	}
	
	public static String merge(File template, Map<String, Object> props) throws JsonParseException, JsonMappingException, IOException {
		JtwigTemplate t = JtwigTemplate.fileTemplate(template);
		return merge(t, props);
	}
	
}
