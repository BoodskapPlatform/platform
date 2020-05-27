package io.boodskap.iot.model.jpa;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import io.boodskap.iot.DataChannel;
import io.boodskap.iot.model.IReportedDevice;

@Entity()
@Table(name="reporteddevice")
public class ReportedDevice extends AbstractModel implements IReportedDevice {

	private static final long serialVersionUID = 5079998294707936313L;
	
	@EmbeddedId
	private ReportedDeviceId id = new ReportedDeviceId();
		
	@Column(name="address", length=20)
	private String address;
	
	@Column(name="mqttserverid", length=40)
	private String mqttServerId;

	@Column(name="nodeid", length=40)
	private String nodeId;

	@Column(name="nodeuid", length=40)
	private String nodeUid;

	@Column(name="lastreported")
	private Date lastReported = new Date();

	@Column(name="port")
	private Integer port;

	@Enumerated(EnumType.STRING)
	@Column(name="channel", length=12)
	private DataChannel channel;

	public ReportedDevice() {
	}

	public ReportedDevice(ReportedDeviceId id) {
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
		int result = super.hashCode();
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((channel == null) ? 0 : channel.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lastReported == null) ? 0 : lastReported.hashCode());
		result = prime * result + ((mqttServerId == null) ? 0 : mqttServerId.hashCode());
		result = prime * result + ((nodeId == null) ? 0 : nodeId.hashCode());
		result = prime * result + ((nodeUid == null) ? 0 : nodeUid.hashCode());
		result = prime * result + ((port == null) ? 0 : port.hashCode());
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
		ReportedDevice other = (ReportedDevice) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (channel != other.channel)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lastReported == null) {
			if (other.lastReported != null)
				return false;
		} else if (!lastReported.equals(other.lastReported))
			return false;
		if (mqttServerId == null) {
			if (other.mqttServerId != null)
				return false;
		} else if (!mqttServerId.equals(other.mqttServerId))
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
