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

import io.boodskap.iot.CommandType;

@JsonSerialize(as=IBaseCommand.class)
public interface IBaseCommand extends IDomainObject{

	@Override
	public default void copy(Object other) {
		
		IBaseCommand o = (IBaseCommand) other;

		setUid(o.getUid());
		setCommandType(o.getCommandType());
		setModels(o.getModels());
		setVersions(o.getVersions());
		setCommandId(o.getCommandId());
		setData(o.getData());
		setJsonData(o.getJsonData());
		
		IDomainObject.super.copy(other);
	}

	public long getUid();

	public void setUid(long uid);

	public CommandType getCommandType();

	public void setCommandType(CommandType commandType);

	public Collection<String> getModels() ;

	public void setModels(Collection<String> models);

	public Collection<String> getVersions() ;

	public void setVersions(Collection<String> versions);

	public int getCommandId();

	public void setCommandId(int commandId);

	public byte[] getData();

	public void setData(byte[] data);

	public String getJsonData() ;

	public void setJsonData(String jsonData);

}
