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

import io.boodskap.iot.DataChannel;
import io.boodskap.iot.dao.DeviceDAO;

@JsonSerialize(as=IDevice.class)
public interface IDevice extends IDomainObject {

	public static DeviceDAO<IDevice> dao(){
		return DeviceDAO.get();
	}
	
	public static Class<? extends IDevice> clazz() {
		return dao().clazz();
	}
	
	public static IDevice create(String domainKey, String deviceId) {
		return dao().create(domainKey, deviceId);
	}

	public static IDevice find(String domainKey, String deviceId) {
		return dao().get(domainKey, deviceId);
	}

	public default void save() {
		IDevice.dao().createOrUpdate(this);
	}
	
	public String getDeviceId() ;

	public void setDeviceId(String deviceId);

	public String getModelId();

	public void setModelId(String modelId);

	public String getVersion();

	public void setVersion(String version);

	public String getPassword();

	public void setPassword(String password);

	public String getAssetId();

	public void setAssetId(String assetId);

	public String getReportedIp();

	public void setReportedIp(String reportedIp);

	public Integer getReportedPort();

	public void setReportedPort(Integer reportedPort);

	public String getNodeId();

	public void setNodeId(String nodeId);

	public String getNodeUid();

	public void setNodeUid(String nodeUid);

	public DataChannel getChannel();

	public void setChannel(DataChannel channel);

}
