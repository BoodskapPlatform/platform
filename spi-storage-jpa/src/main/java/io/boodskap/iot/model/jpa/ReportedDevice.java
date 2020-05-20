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
public class ReportedDevice implements IReportedDevice {

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

}
