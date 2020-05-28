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

import io.boodskap.iot.DeviceCommandTarget;
import io.boodskap.iot.dao.DeviceCommandDAO;

@JsonSerialize(as=IDeviceCommand.class)
public interface IDeviceCommand extends IBaseCommand{

	public static DeviceCommandDAO<IDeviceCommand> dao(){
		return DeviceCommandDAO.get();
	}
	
	public static Class<? extends IDeviceCommand> clazz() {
		return dao().clazz();
	}
	
	public static IDeviceCommand create(String domainKey, String deviceId, long uid) {
		return dao().create(domainKey, deviceId, uid);
	}

	public static IDeviceCommand find(String domainKey, String deviceId, long uid) {
		return dao().get(domainKey, deviceId, uid);
	}

	public default void save() {
		IDeviceCommand.dao().createOrUpdate(this);
	}

	@Override
	public default void copy(Object other) {
		
		IDeviceCommand o = (IDeviceCommand) other;
		
		setTarget(o.getTarget());
		setIncludeMe(o.isIncludeMe());
		setDeviceId(o.getDeviceId());
		setGroups(o.getGroups());
		
		IBaseCommand.super.copy(other);
	}

	public DeviceCommandTarget getTarget();

	public void setTarget(DeviceCommandTarget target);

	public boolean isIncludeMe();

	public void setIncludeMe(boolean includeMe);

	public String getDeviceId();

	public void setDeviceId(String deviceId);

	public Collection<String> getGroups();

	public void setGroups(Collection<String> groups);

}
