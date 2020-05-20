package io.boodskap.iot.model.jpa;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import io.boodskap.iot.model.IDeviceCounter;

@Entity
@Table(name="devicecounter")
public class DeviceCounter implements IDeviceCounter {
	
	private static final long serialVersionUID = -6250348313306135884L;

	@EmbeddedId
	private DeviceCounterId id = new DeviceCounterId();
	
	@Column(name="corrid")
	private long corrId;

	@Column(name="udpmessages")
	private long udpMessages;
	
	@Column(name="mqttmessages")
	private long mqttMessages;
	
	@Column(name="httpmessages")
	private long httpMessages;
	
	@Column(name="fcmmessages")
	private long fcmMessages;
	
	@Column(name="coapmessages")
	private long coapMessages;
	
	@Column(name="tcpmessages")
	private long tcpMessages;
	
	@Column(name="commands")
	private long commands;
	
	@Column(name="loarmessages")
	private long loraMessages;

	public DeviceCounter() {
	}

	public DeviceCounter(DeviceCounterId id) {
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

	public long getCorrId() {
		return corrId;
	}

	public void setCorrId(long corrId) {
		this.corrId = corrId;
	}

	public void increment() {
		++corrId;
	}

	public long getUdpMessages() {
		return udpMessages;
	}

	public void setUdpMessages(long udpMessages) {
		this.udpMessages = udpMessages;
	}

	public long getMqttMessages() {
		return mqttMessages;
	}

	public void setMqttMessages(long mqttMessages) {
		this.mqttMessages = mqttMessages;
	}

	public long getHttpMessages() {
		return httpMessages;
	}

	public void setHttpMessages(long httpMessages) {
		this.httpMessages = httpMessages;
	}

	public long getFcmMessages() {
		return fcmMessages;
	}

	public void setFcmMessages(long fcmMessages) {
		this.fcmMessages = fcmMessages;
	}

	public long getCoapMessages() {
		return coapMessages;
	}

	public void setCoapMessages(long coapMessages) {
		this.coapMessages = coapMessages;
	}

	public long getTcpMessages() {
		return tcpMessages;
	}

	public void setTcpMessages(long tcpMessages) {
		this.tcpMessages = tcpMessages;
	}

	public long getCommands() {
		return commands;
	}

	public void setCommands(long commands) {
		this.commands = commands;
	}

	public long getLoraMessages() {
		return loraMessages;
	}

	public void setLoraMessages(long loraMessages) {
		this.loraMessages = loraMessages;
	}

}
