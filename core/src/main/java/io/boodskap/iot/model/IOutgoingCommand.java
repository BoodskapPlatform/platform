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

import io.boodskap.iot.CommandStatus;
import io.boodskap.iot.CommandType;
import io.boodskap.iot.DataChannel;
import io.boodskap.iot.LoRaTarget;
import io.boodskap.iot.dao.OutgoingCommandDAO;

@JsonSerialize(as=IOutgoingCommand.class)
public interface IOutgoingCommand extends IDomainObject {
	
	public static OutgoingCommandDAO<IOutgoingCommand> dao() {
		return OutgoingCommandDAO.get();
	}
	
	public static Class<? extends IOutgoingCommand> clazz() {
		return dao().clazz();
	}
	
	public static IOutgoingCommand create(String domainKey, String requestId, String deviceId, long corrId) {
		return dao().create(domainKey, requestId, deviceId, corrId);
	}

	public static IOutgoingCommand find(String domainKey, String requestId, String deviceId, long corrId) {
		return dao().get(domainKey, requestId, deviceId, corrId);
	}

	public default void save() {
		IOutgoingCommand.dao().createOrUpdate(this);
	}

	public String getDeviceId();

	public void setDeviceId(String deviceId);

	public String getRequestId();

	public void setRequestId(String requestId);

	public long getCorrId();

	public void setCorrId(long corrId);

	public Date getCreatedStamp();

	public void setCreatedStamp(Date createdStamp);

	public Date getQueuedStamp();

	public void setQueuedStamp(Date queuedStamp);

	public Date getSentStamp();

	public void setSentStamp(Date sentStamp);

	public Date getAckedStamp();

	public void setAckedStamp(Date ackedStamp);

	public CommandStatus getStatus();

	public void setStatus(CommandStatus status);

	public CommandType getType();

	public void setType(CommandType type);

	public byte[] getData();

	public void setData(byte[] data);

	public DataChannel getChannel();

	public void setChannel(DataChannel channel);

	public String getNodeId();

	public void setNodeId(String nodeId);

	public String getNodeUid();

	public void setNodeUid(String nodeUid);

	public String getDescription();

	public void setDescription(String description);

	public String getReportedIp();

	public void setReportedIp(String reportedIp);

	public int getReportedPort();

	public void setReportedPort(int reportedPort);

	public int getNackCode();

	public void setNackCode(int nackCode);

	public LoRaTarget getLoraTarget();

	public void setLoraTarget(LoRaTarget loraTarget);

	public long getLoraBaseStationId();

	public void setLoraBaseStationId(long loraBaseStationId);

	public long getLoraTransmitterId();

	public void setLoraTransmitterId(long loraTransmitterId);

	public long getLoraReceiverId();

	public void setLoraReceiverId(long loraReceiverId);

	public long getLoraTransceiverId();

	public void setLoraTransceiverId(long loraTransceiverId);

	public long getLoraModemId();

	public void setLoraModemId(long loraModemId);
	
	public int getMqttQos();
	
	public void setMqttQos(int mqttQos);

}
