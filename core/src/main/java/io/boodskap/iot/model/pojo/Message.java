package io.boodskap.iot.model.pojo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;


import io.boodskap.iot.DataChannel;
import io.boodskap.iot.model.IDynamicMessageField;
import io.boodskap.iot.model.IMessage;

public class Message implements IMessage {
	
	private static final long serialVersionUID = -1928207596119374413L;

	private String domainKey;
	private String specId;
	private String messageId;
	private Date createdStamp = new Date();
	private DataChannel dataChannel;
	private Integer port;
	private String ipAddress;
	private String nodeUid;
	private String nodeId;
	private String deviceId;
	private String deviceModel;
	private String firmwareVersion;
	private Date receivedStamp;
	private State state;
	private String trace;
	private List<IDynamicMessageField> fields = new ArrayList<>();

	public Message() {
	}

	public Message(String domainKey, String specId, String messageId) {
		super();
		this.domainKey = domainKey;
		this.specId = specId;
		this.messageId = messageId;
	}

	@Override
	public IDynamicMessageField createField(String name) {
		return new DynamicMessageField(domainKey, specId, messageId, name);
	}

	public String getDomainKey() {
		return domainKey;
	}

	public void setDomainKey(String domainKey) {
		this.domainKey = domainKey;
	}

	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	public String getSpecId() {
		return specId;
	}

	public void setSpecId(String specId) {
		this.specId = specId;
	}

	@Override
	public Date getCreatedStamp() {
		return createdStamp;
	}

	@Override
	public void setCreatedStamp(Date createdStamp) {
		this.createdStamp = createdStamp;
	}

	@Override
	public List<IDynamicMessageField> getFields() {
		return fields;
	}

	@Override
	public void setFields(Collection<? extends IDynamicMessageField> fields) {
		this.fields.clear();
		this.fields.addAll(fields);
	}

	@Override
	public Date getReceivedStamp() {
		return receivedStamp;
	}

	@Override
	public void setReceivedStamp(Date receivedStamp) {
		this.receivedStamp = receivedStamp;
	}

	@Override
	public String getDeviceId() {
		return deviceId;
	}

	@Override
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	@Override
	public String getDeviceModel() {
		return deviceModel;
	}

	@Override
	public void setDeviceModel(String deviceModel) {
		this.deviceModel = deviceModel;
	}

	@Override
	public String getFirmwareVersion() {
		return firmwareVersion;
	}

	@Override
	public void setFirmwareVersion(String firmwareVersion) {
		this.firmwareVersion = firmwareVersion;
	}

	@Override
	public String getNodeId() {
		return nodeId;
	}

	@Override
	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}

	@Override
	public String getNodeUid() {
		return nodeUid;
	}

	@Override
	public void setNodeUid(String nodeUid) {
		this.nodeUid = nodeUid;
	}

	@Override
	public String getIpAddress() {
		return ipAddress;
	}

	@Override
	public void setIpAddress(String ipAddress) {
		this.ipAddress  = ipAddress;
	}

	@Override
	public Integer getPort() {
		return this.port;
	}

	@Override
	public void setPort(Integer port) {
		this.port = port;
	}

	@Override
	public DataChannel getDataChannel() {
		return dataChannel;
	}

	@Override
	public void setDataChannel(DataChannel dataChannel) {
		this.dataChannel = dataChannel;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public String getTrace() {
		return trace;
	}

	public void setTrace(String trace) {
		this.trace = trace;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createdStamp == null) ? 0 : createdStamp.hashCode());
		result = prime * result + ((dataChannel == null) ? 0 : dataChannel.hashCode());
		result = prime * result + ((deviceId == null) ? 0 : deviceId.hashCode());
		result = prime * result + ((deviceModel == null) ? 0 : deviceModel.hashCode());
		result = prime * result + ((domainKey == null) ? 0 : domainKey.hashCode());
		result = prime * result + ((fields == null) ? 0 : fields.hashCode());
		result = prime * result + ((firmwareVersion == null) ? 0 : firmwareVersion.hashCode());
		result = prime * result + ((ipAddress == null) ? 0 : ipAddress.hashCode());
		result = prime * result + ((messageId == null) ? 0 : messageId.hashCode());
		result = prime * result + ((nodeId == null) ? 0 : nodeId.hashCode());
		result = prime * result + ((nodeUid == null) ? 0 : nodeUid.hashCode());
		result = prime * result + ((port == null) ? 0 : port.hashCode());
		result = prime * result + ((receivedStamp == null) ? 0 : receivedStamp.hashCode());
		result = prime * result + ((specId == null) ? 0 : specId.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((trace == null) ? 0 : trace.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Message other = (Message) obj;
		if (createdStamp == null) {
			if (other.createdStamp != null)
				return false;
		} else if (!createdStamp.equals(other.createdStamp))
			return false;
		if (dataChannel != other.dataChannel)
			return false;
		if (deviceId == null) {
			if (other.deviceId != null)
				return false;
		} else if (!deviceId.equals(other.deviceId))
			return false;
		if (deviceModel == null) {
			if (other.deviceModel != null)
				return false;
		} else if (!deviceModel.equals(other.deviceModel))
			return false;
		if (domainKey == null) {
			if (other.domainKey != null)
				return false;
		} else if (!domainKey.equals(other.domainKey))
			return false;
		if (fields == null) {
			if (other.fields != null)
				return false;
		} else if (!fields.equals(other.fields))
			return false;
		if (firmwareVersion == null) {
			if (other.firmwareVersion != null)
				return false;
		} else if (!firmwareVersion.equals(other.firmwareVersion))
			return false;
		if (ipAddress == null) {
			if (other.ipAddress != null)
				return false;
		} else if (!ipAddress.equals(other.ipAddress))
			return false;
		if (messageId == null) {
			if (other.messageId != null)
				return false;
		} else if (!messageId.equals(other.messageId))
			return false;
		if (nodeId == null) {
			if (other.nodeId != null)
				return false;
		} else if (!nodeId.equals(other.nodeId))
			return false;
		if (nodeUid == null) {
			if (other.nodeUid != null)
				return false;
		} else if (!nodeUid.equals(other.nodeUid))
			return false;
		if (port == null) {
			if (other.port != null)
				return false;
		} else if (!port.equals(other.port))
			return false;
		if (receivedStamp == null) {
			if (other.receivedStamp != null)
				return false;
		} else if (!receivedStamp.equals(other.receivedStamp))
			return false;
		if (specId == null) {
			if (other.specId != null)
				return false;
		} else if (!specId.equals(other.specId))
			return false;
		if (state != other.state)
			return false;
		if (trace == null) {
			if (other.trace != null)
				return false;
		} else if (!trace.equals(other.trace))
			return false;
		return true;
	}

}