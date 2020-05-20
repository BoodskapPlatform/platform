package io.boodskap.iot.model.pojo;

import java.util.Date;


import io.boodskap.iot.DataChannel;
import io.boodskap.iot.model.IReportedDevice;

public class ReportedDevice implements IReportedDevice {

	private static final long serialVersionUID = 5079998294707936313L;

	private String domainKey;
	private String deviceId;
	private String address;
	private String mqttServerId;
	private String nodeId;
	private String nodeUid;
	private Date lastReported = new Date();
	private Integer port;
	private DataChannel channel;

	public ReportedDevice() {
	}

	public ReportedDevice(String domainKey, String deviceId) {
		super();
		this.domainKey = domainKey;
		this.deviceId = deviceId;
	}

	public String getDomainKey() {
		return domainKey;
	}

	public void setDomainKey(String domainKey) {
		this.domainKey = domainKey;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getMqttServerId() {
		return mqttServerId;
	}

	public void setMqttServerId(String mqttServerId) {
		this.mqttServerId = mqttServerId;
	}

	public Date getLastReported() {
		return lastReported;
	}

	public void setLastReported(Date lastReported) {
		this.lastReported = lastReported;
	}

	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public DataChannel getChannel() {
		return channel;
	}

	public void setChannel(DataChannel channel) {
		this.channel = channel;
	}

	public String getNodeId() {
		return nodeId;
	}

	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}

	public String getNodeUid() {
		return nodeUid;
	}

	public void setNodeUid(String nodeUid) {
		this.nodeUid = nodeUid;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((channel == null) ? 0 : channel.hashCode());
		result = prime * result + ((deviceId == null) ? 0 : deviceId.hashCode());
		result = prime * result + ((domainKey == null) ? 0 : domainKey.hashCode());
		result = prime * result + ((lastReported == null) ? 0 : lastReported.hashCode());
		result = prime * result + ((nodeId == null) ? 0 : nodeId.hashCode());
		result = prime * result + ((nodeUid == null) ? 0 : nodeUid.hashCode());
		result = prime * result + ((port == null) ? 0 : port.hashCode());
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
		ReportedDevice other = (ReportedDevice) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (channel != other.channel)
			return false;
		if (deviceId == null) {
			if (other.deviceId != null)
				return false;
		} else if (!deviceId.equals(other.deviceId))
			return false;
		if (domainKey == null) {
			if (other.domainKey != null)
				return false;
		} else if (!domainKey.equals(other.domainKey))
			return false;
		if (lastReported == null) {
			if (other.lastReported != null)
				return false;
		} else if (!lastReported.equals(other.lastReported))
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
		return true;
	}

}
