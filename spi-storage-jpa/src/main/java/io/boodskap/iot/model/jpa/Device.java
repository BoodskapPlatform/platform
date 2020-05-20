package io.boodskap.iot.model.jpa;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import io.boodskap.iot.DataChannel;
import io.boodskap.iot.model.IDevice;

@Entity
@Table(name="device")
public class Device implements IDevice {

	private static final long serialVersionUID = -3890309949886257710L;

	@EmbeddedId
	private DeviceId id = new DeviceId();
	
	@Column(name="name", length=40)
	private String name = null;
	
	@Column(name="description", length=120)
	private String description = null;
	
	@Column(name="modelid", length=40)
	private String modelId = null;
	
	@Column(name="version", length=40)
	private String version = null;
	
	@Column(name="password", length=40)
	private String password = null;
	
	@Column(name="assetid", length=40)
	private String assetId = null;
	
	@Column(name="reportedip", length=20)
	private String reportedIp = null;
	
	@Column(name="nodeid", length=40)
	private String nodeId = null;
	
	@Column(name="nodeuid", length=40)
	private String nodeUid = null;
	
	@Column(name="reportedport")
	private Integer reportedPort = null;
	
	@Column(name="channel", length=12)
	@Enumerated(EnumType.STRING)
	private DataChannel channel = null;
	
	@Column(name="registeredstamp")
	private Date registeredStamp;
	
	@Column(name="reportedstamp")
	private Date reportedStamp = null;
	
	public Device() {
	}
	
	public Device(DeviceId id) {
		this.id = id;
	}
	
	public String getDomainKey() {
		return id.getDomainKey();
	}

	public void setDomainKey(String domainKey) {
		id.setDomainKey(domainKey);
	}


	public String getDeviceId() {
		return id.getDeviceId();
	}

	public void setDeviceId(String deviceId) {
		id.setDeviceId(deviceId);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getModelId() {
		return modelId;
	}

	public void setModelId(String modelId) {
		this.modelId = modelId;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getRegisteredStamp() {
		return registeredStamp;
	}

	public void setRegisteredStamp(Date registeredStamp) {
		this.registeredStamp = registeredStamp;
	}

	public String getAssetId() {
		return assetId;
	}

	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}

	public Date getReportedStamp() {
		return reportedStamp;
	}

	public void setReportedStamp(Date reportedStamp) {
		this.reportedStamp = reportedStamp;
	}

	public String getReportedIp() {
		return reportedIp;
	}

	public void setReportedIp(String reportedIp) {
		this.reportedIp = reportedIp;
	}

	public Integer getReportedPort() {
		return reportedPort;
	}

	public void setReportedPort(Integer reportedPort) {
		this.reportedPort = reportedPort;
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

	public DataChannel getChannel() {
		return channel;
	}

	public void setChannel(DataChannel channel) {
		this.channel = channel;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((assetId == null) ? 0 : assetId.hashCode());
		result = prime * result + ((channel == null) ? 0 : channel.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((modelId == null) ? 0 : modelId.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((nodeId == null) ? 0 : nodeId.hashCode());
		result = prime * result + ((nodeUid == null) ? 0 : nodeUid.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((registeredStamp == null) ? 0 : registeredStamp.hashCode());
		result = prime * result + ((reportedIp == null) ? 0 : reportedIp.hashCode());
		result = prime * result + ((reportedPort == null) ? 0 : reportedPort.hashCode());
		result = prime * result + ((reportedStamp == null) ? 0 : reportedStamp.hashCode());
		result = prime * result + ((version == null) ? 0 : version.hashCode());
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
		Device other = (Device) obj;
		if (assetId == null) {
			if (other.assetId != null)
				return false;
		} else if (!assetId.equals(other.assetId))
			return false;
		if (channel != other.channel)
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (modelId == null) {
			if (other.modelId != null)
				return false;
		} else if (!modelId.equals(other.modelId))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
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
		if (registeredStamp == null) {
			if (other.registeredStamp != null)
				return false;
		} else if (!registeredStamp.equals(other.registeredStamp))
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
		if (reportedStamp == null) {
			if (other.reportedStamp != null)
				return false;
		} else if (!reportedStamp.equals(other.reportedStamp))
			return false;
		if (version == null) {
			if (other.version != null)
				return false;
		} else if (!version.equals(other.version))
			return false;
		return true;
	}

}
