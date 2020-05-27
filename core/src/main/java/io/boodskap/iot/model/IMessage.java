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

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.exception.ExceptionUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import io.boodskap.iot.BoodskapSystem;
import io.boodskap.iot.DataChannel;
import io.boodskap.iot.StorageException;
import io.boodskap.iot.ThreadContext;
import io.boodskap.iot.dao.MessageDAO;

@JsonSerialize(as=IMessage.class)
public interface IMessage extends IDomainObject {

	public static enum State{
		PROCESSING,
		PROCESSED,
		SKIPPED,
		FAILED
	}
	
	public static MessageDAO<IMessage> dao(){
		return BoodskapSystem.dynamicStorage().getMessageDAO();
	}
	
	public static IMessage create(String domainKey, String specId, String messageId) {
		return dao().create(domainKey, specId, messageId);
	}
	
	public IDynamicMessageField createField(String name);

	public String getMessageId();

	public void setMessageId(String messageId);

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

	public String getIpAddress();

	public void setIpAddress(String ipAddress);
	
	public Integer getPort();
	
	public void setPort(Integer port);
	
	public DataChannel getDataChannel();
	
	public void setDataChannel(DataChannel dataChannel);

	public State getState();
	
	public void setState(State state);
	
	public String getTrace();
	
	public void setTrace(String trace);
	
	public default void setProcessing() throws StorageException {
		setState(State.PROCESSING);
		updateState();
	}

	public default void setProcessed() throws StorageException {
		setState(State.PROCESSED);
		updateState();
	}

	public default void setSkipped() throws StorageException {
		setState(State.SKIPPED);
		updateState();
	}

	public default void setFailed(Throwable trace) throws StorageException {
		setState(State.FAILED);
		setTrace(ExceptionUtils.getStackTrace(trace));
		updateState();
	}

	public default void updateState() throws StorageException {
		dao().updateState(this);
	}

	@JsonIgnore
	public <T extends IDynamicMessageField> Collection<T> getFields();

	public void setFields(Collection<? extends IDynamicMessageField> data);
	
	public default Map<String, Object> getData(){
		Map<String, Object> fields = new HashMap<String, Object>();
		Collection<IDynamicMessageField> data = getFields();
		if(null != data) {
			data.forEach(f -> {
				fields.put(f.getName(), f.getFieldValue());
			});
		}
		return fields;
	}
	
	public default void setData(JsonNode data) {
		
		
		Map<String, Object> fields = ThreadContext.toMap(data);
		
		for(Map.Entry<String, Object> me : fields.entrySet()) {
			
			IDynamicMessageField mf = createField(me.getKey());
			mf.setField(me.getKey(), (Serializable) me.getValue());
			getFields().add(mf);
		}
		
	}

	public default void save() {
		MessageDAO.get().createOrUpdate(this);
	}

}
