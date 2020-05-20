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

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import io.boodskap.iot.BoodskapSystem;
import io.boodskap.iot.DataChannel;
import io.boodskap.iot.dao.ReportedDeviceDAO;

@JsonSerialize(as=IReportedDevice.class)
public interface IReportedDevice extends IDomainObject {
	
	public static IReportedDevice create(String domainKey, String deviceId) {
		return BoodskapSystem.storage().getReportedDeviceDAO().create(domainKey, deviceId);
	}

	public String getDeviceId();

	public void setDeviceId(String deviceId);

	public Integer getPort();

	public void setPort(Integer port);

	public String getAddress();

	public void setAddress(String address);

	public DataChannel getChannel();

	public void setChannel(DataChannel channel);

	public String getNodeId();

	public void setNodeId(String nodeId);

	public String getNodeUid();
	
	public void setNodeUid(String nodeUid);
	
	public Date getLastReported();

	public void setLastReported(Date lastReported);
	
	public String getMqttServerId();
	
	public void setMqttServerId(String mqttServerId);

	public default void save() {
		ReportedDeviceDAO.get().createOrUpdate(this);
	}

}
