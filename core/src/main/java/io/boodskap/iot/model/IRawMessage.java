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

import io.boodskap.iot.DataChannel;
import io.boodskap.iot.dao.RawMessageDAO;

@JsonSerialize(as=IRawMessage.class)
public interface IRawMessage extends IDomainObject{
	
	public static IRawMessage create(String domainKey, String rawId) {
		return RawMessageDAO.get().create(domainKey, rawId);
	}
	
	public String getRawId();

	public void setRawId(String rawId);

	public Date getReceivedStamp();

	public void setReceivedStamp(Date receivedStamp);

	public DataChannel getChannel();

	public void setChannel(DataChannel channel);

	public String getSpecId();

	public void setSpecId(String specId);

	public String getDeviceId();

	public void setDeviceId(String deviceId);

	public String getDeviceModel();

	public void setDeviceModel(String deviceModel);

	public String getFirmwareVersion();

	public void setFirmwareVersion(String firmwareVersion);

	public String getNodeId();

	public void setNodeId(String nodeId);

	public String getNodeUid();

	public void setNodeUid(String nodeUid);

	public int getPort();

	public void setPort(int port);

	public String getIpAddress();

	public void setIpAddress(String ipAddress);

	public String getHeader();

	public void setHeader(String header);

	public String getData();

	public void setData(String data);

	public default void save() {
		RawMessageDAO.get().createOrUpdate(this);
	}

}
