package io.boodskap.iot.model.jpa;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import io.boodskap.iot.model.IDeviceCounter;

@Entity
@Table(name="devicecounter")
public class DeviceCounter extends AbstractModel implements IDeviceCounter {
	
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (int) (coapMessages ^ (coapMessages >>> 32));
		result = prime * result + (int) (commands ^ (commands >>> 32));
		result = prime * result + (int) (corrId ^ (corrId >>> 32));
		result = prime * result + (int) (fcmMessages ^ (fcmMessages >>> 32));
		result = prime * result + (int) (httpMessages ^ (httpMessages >>> 32));
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + (int) (loraMessages ^ (loraMessages >>> 32));
		result = prime * result + (int) (mqttMessages ^ (mqttMessages >>> 32));
		result = prime * result + (int) (tcpMessages ^ (tcpMessages >>> 32));
		result = prime * result + (int) (udpMessages ^ (udpMessages >>> 32));
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
		DeviceCounter other = (DeviceCounter) obj;
		if (coapMessages != other.coapMessages)
			return false;
		if (commands != other.commands)
			return false;
		if (corrId != other.corrId)
			return false;
		if (fcmMessages != other.fcmMessages)
			return false;
		if (httpMessages != other.httpMessages)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (loraMessages != other.loraMessages)
			return false;
		if (mqttMessages != other.mqttMessages)
			return false;
		if (tcpMessages != other.tcpMessages)
			return false;
		if (udpMessages != other.udpMessages)
			return false;
		return true;
	}

}
