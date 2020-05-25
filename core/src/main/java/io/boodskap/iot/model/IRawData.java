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

import io.boodskap.iot.BoodskapSystem;
import io.boodskap.iot.DataChannel;
import io.boodskap.iot.RawDataType;
import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.RawDataDAO;

@JsonSerialize(as=IRawData.class)
public interface IRawData extends IDomainData {
	
	public static enum State{
		QUEUED,
		REQUEUED,
		PROCESSING,
		PROCESSED,
		SKIPPED,
		FAILED
	}
	
	public static IRawData create(String id) {
		return BoodskapSystem.rawStorage().getRawDataDAO().create(id);
	}
	
	public static IRawData find(String id) {
		return BoodskapSystem.rawStorage().getRawDataDAO().get(id);
	}
	
	public default void update() throws StorageException {
		BoodskapSystem.rawStorage().getRawDataDAO().update(this);
	}
	
	public default void updateContent() throws StorageException {
		BoodskapSystem.rawStorage().getRawDataDAO().createOrUpdate(this);
	}
	
	public default void setProcessing() throws StorageException {
		updateState(State.PROCESSING);
	}

	public default void setProcessed() throws StorageException {
		updateState(State.PROCESSED);
	}

	public default void setSkipped() throws StorageException {
		updateState(State.SKIPPED);
	}

	public default void setFailed() throws StorageException {
		updateState(State.FAILED);
	}

	public default void updateState(State state) throws StorageException {
		setState(state);
		BoodskapSystem.rawStorage().getRawDataDAO().updateState(this);
	}

	public default void delete() throws StorageException {
		BoodskapSystem.rawStorage().getRawDataDAO().delete(getId());
	}

	public String getId();

	public void setId(String id);

	public String getNodeId();

	public void setNodeId(String nodeId);

	public String getNodeUid();

	public void setNodeUid(String nodeUid);

	public String getIpAddress();

	public void setIpAddress(String ipAddress);

	public byte[] getData();

	public void setData(byte[] data);
	
	public int getSize();

	public void setSize(int size);

	public DataChannel getChannel();

	public void setChannel(DataChannel channel);

	public Integer getPort();

	public void setPort(Integer port);

	public String getMqttServerId();

	public void setMqttServerId(String mqttServerId);

	public String getMqttTopic();

	public void setMqttTopic(String mqttTopic);

	public String getDeviceId();

	public void setDeviceId(String deviceId);

	public String getDeviceModel();

	public void setDeviceModel(String deviceModel);

	public String getFirmwareVersion();

	public void setFirmwareVersion(String firmwareVersion);

	public RawDataType getRawDataType();

	public void setRawDataType(RawDataType rawDataType);

	public String getProperties();

	public void setProperties(String properties);

	public String getContentType();

	public void setContentType(String contentType);

	public State getState();
	
	public void setState(State state);
	
	public String getType();
	
	public void setType(String type);
	
	public void setFileName(String fileName);
	
	public String getFileName();

	public default void save() {
		RawDataDAO.get().createOrUpdate(this);
	}
}
