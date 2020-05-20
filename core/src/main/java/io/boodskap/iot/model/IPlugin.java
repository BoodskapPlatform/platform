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

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import io.boodskap.iot.dao.PluginDAO;
import io.boodskap.iot.plugin.PluginType;

@JsonSerialize(as=IPlugin.class)
public interface IPlugin extends IModel {
	
	public static IPlugin create(String pluginId, String version) {
		return PluginDAO.get().create(pluginId, version);
	}

	public String getPluginId();
	
	public void setPluginId(String pluginId);
	
	public String getVersion();
	
	public void setVersion(String version);
	
	public String getContextId();
	
	public void setContextId(String contextId);
	
	public String getSystemId();
	
	public void setSystemId(String systemId);
	
	public PluginType getType();
	
	public void setType(PluginType type);

	public String getDesc();
	
	public void setDesc(String desc);
	
	public String getAuthor();
	
	public void setAuthor(String author);
	
	public String getClazz();
	
	public void setClazz(String clazz);
	
	public String getCrc();
	
	public void setCrc(String crc);
	
	public String getReadme();
	
	public void setReadme(String readme);
	
	public String getJsonContent();
	
	public void setJsonContent(String jsonContent);
	
	public default void save() {
		PluginDAO.get().createOrUpdate(this);
	}
}
