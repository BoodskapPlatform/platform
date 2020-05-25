package io.boodskap.iot.model.pojo;

import io.boodskap.iot.model.IDeviceCounter;

public class DeviceCounter extends AbstractDomainObject implements IDeviceCounter {
	
	private static final long serialVersionUID = -6250348313306135884L;

	private String deviceId;
	private long udpMessages;
	private long mqttMessages;
	private long httpMessages;
	private long fcmMessages;
	private long commands;
	private long coapMessages;
	private long tcpMessages;
	private long loraMessages;

	public DeviceCounter() {
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
	public long getUdpMessages() {
		return udpMessages;
	}

	@Override
	public void setUdpMessages(long udpMessages) {
		this.udpMessages = udpMessages;
	}

	@Override
	public long getMqttMessages() {
		return mqttMessages;
	}

	@Override
	public void setMqttMessages(long mqttMessages) {
		this.mqttMessages = mqttMessages;
	}

	@Override
	public long getHttpMessages() {
		return httpMessages;
	}

	@Override
	public void setHttpMessages(long httpMessages) {
		this.httpMessages = httpMessages;
	}

	@Override
	public long getFcmMessages() {
		return fcmMessages;
	}

	@Override
	public void setFcmMessages(long fcmMessages) {
		this.fcmMessages = fcmMessages;
	}

	@Override
	public long getCommands() {
		return commands;
	}

	@Override
	public void setCommands(long commands) {
		this.commands = commands;
	}

	@Override
	public long getCoapMessages() {
		return coapMessages;
	}

	@Override
	public void setCoapMessages(long coapMessages) {
		this.coapMessages = coapMessages;
	}

	@Override
	public long getTcpMessages() {
		return tcpMessages;
	}

	@Override
	public void setTcpMessages(long tcpMessages) {
		this.tcpMessages = tcpMessages;
	}

	@Override
	public long getLoraMessages() {
		return loraMessages;
	}

	@Override
	public void setLoraMessages(long loraMessages) {
		this.loraMessages = loraMessages;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (int) (coapMessages ^ (coapMessages >>> 32));
		result = prime * result + (int) (commands ^ (commands >>> 32));
		result = prime * result + ((deviceId == null) ? 0 : deviceId.hashCode());
		result = prime * result + (int) (fcmMessages ^ (fcmMessages >>> 32));
		result = prime * result + (int) (httpMessages ^ (httpMessages >>> 32));
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
		if (deviceId == null) {
			if (other.deviceId != null)
				return false;
		} else if (!deviceId.equals(other.deviceId))
			return false;
		if (fcmMessages != other.fcmMessages)
			return false;
		if (httpMessages != other.httpMessages)
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
