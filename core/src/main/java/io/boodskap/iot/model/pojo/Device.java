package io.boodskap.iot.model.pojo;

import io.boodskap.iot.DataChannel;
import io.boodskap.iot.model.IDevice;

public class Device extends AbstractDomainObject implements IDevice {

	private static final long serialVersionUID = -3890309949886257710L;

	private String deviceId;
	private String modelId = null;
	private String version = null;
	private String password = null;
	private String assetId = null;
	private String reportedIp = null;
	private String nodeId = null;
	private String nodeUid = null;
	private Integer reportedPort = null;
	private DataChannel channel = null;
	
	public Device() {
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
	public String getModelId() {
		return modelId;
	}

	@Override
	public void setModelId(String modelId) {
		this.modelId = modelId;
	}

	@Override
	public String getVersion() {
		return version;
	}

	@Override
	public void setVersion(String version) {
		this.version = version;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String getAssetId() {
		return assetId;
	}

	@Override
	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}

	@Override
	public String getReportedIp() {
		return reportedIp;
	}

	@Override
	public void setReportedIp(String reportedIp) {
		this.reportedIp = reportedIp;
	}

	@Override
	public Integer getReportedPort() {
		return reportedPort;
	}

	@Override
	public void setReportedPort(Integer reportedPort) {
		this.reportedPort = reportedPort;
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
	public DataChannel getChannel() {
		return channel;
	}

	@Override
	public void setChannel(DataChannel channel) {
		this.channel = channel;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((assetId == null) ? 0 : assetId.hashCode());
		result = prime * result + ((channel == null) ? 0 : channel.hashCode());
		result = prime * result + ((deviceId == null) ? 0 : deviceId.hashCode());
		result = prime * result + ((modelId == null) ? 0 : modelId.hashCode());
		result = prime * result + ((nodeId == null) ? 0 : nodeId.hashCode());
		result = prime * result + ((nodeUid == null) ? 0 : nodeUid.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((reportedIp == null) ? 0 : reportedIp.hashCode());
		result = prime * result + ((reportedPort == null) ? 0 : reportedPort.hashCode());
		result = prime * result + ((version == null) ? 0 : version.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Device other = (Device) obj;
		if (assetId == null) {
			if (other.assetId != null)
				return false;
		} else if (!assetId.equals(other.assetId))
			return false;
		if (channel != other.channel)
			return false;
		if (deviceId == null) {
			if (other.deviceId != null)
				return false;
		} else if (!deviceId.equals(other.deviceId))
			return false;
		if (modelId == null) {
			if (other.modelId != null)
				return false;
		} else if (!modelId.equals(other.modelId))
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
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (reportedIp == null) {
			if (other.reportedIp != null)
				return false;
		} else if (!reportedIp.equals(other.reportedIp))
			return false;
		if (reportedPort == null) {
			if (other.reportedPort != null)
				return false;
		} else if (!reportedPort.equals(other.reportedPort))
			return false;
		if (version == null) {
			if (other.version != null)
				return false;
		} else if (!version.equals(other.version))
			return false;
		return true;
	}

}
