package io.boodskap.iot.model.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.boodskap.iot.model.IDomainCounter;

@Entity
@Table(name="domaincounter")
public class DomainCounter extends AbstractModel implements IDomainCounter {

	private static final long serialVersionUID = 9111854199806271176L;
	
	@Id
	@Column(name="dkey")
	private String domainKey;
	
	@Column(name="records")
	private long records;
	
	@Column(name="users")
	private long users;
	
	@Column(name="devices")
	private long devices;
	
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
	
	public DomainCounter() {
	}

	public DomainCounter(String domainkey) {
		this.domainKey = domainkey;
	}

	@Override
	public String getDomainKey() {
		return domainKey;
	}

	@Override
	public void setDomainKey(String domainKey) {
		this.domainKey = domainKey;
	}

	@Override
	public long getUsers() {
		return users;
	}

	@Override
	public void setUsers(long users) {
		this.users = users;
	}

	@Override
	public long getDevices() {
		return devices;
	}

	@Override
	public void setDevices(long devices) {
		this.devices = devices;
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
	public long getRecords() {
		return records;
	}

	@Override
	public void setRecords(long records) {
		this.records = records;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (int) (coapMessages ^ (coapMessages >>> 32));
		result = prime * result + (int) (commands ^ (commands >>> 32));
		result = prime * result + (int) (devices ^ (devices >>> 32));
		result = prime * result + ((domainKey == null) ? 0 : domainKey.hashCode());
		result = prime * result + (int) (fcmMessages ^ (fcmMessages >>> 32));
		result = prime * result + (int) (httpMessages ^ (httpMessages >>> 32));
		result = prime * result + (int) (loraMessages ^ (loraMessages >>> 32));
		result = prime * result + (int) (mqttMessages ^ (mqttMessages >>> 32));
		result = prime * result + (int) (records ^ (records >>> 32));
		result = prime * result + (int) (tcpMessages ^ (tcpMessages >>> 32));
		result = prime * result + (int) (udpMessages ^ (udpMessages >>> 32));
		result = prime * result + (int) (users ^ (users >>> 32));
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
		DomainCounter other = (DomainCounter) obj;
		if (coapMessages != other.coapMessages)
			return false;
		if (commands != other.commands)
			return false;
		if (devices != other.devices)
			return false;
		if (domainKey == null) {
			if (other.domainKey != null)
				return false;
		} else if (!domainKey.equals(other.domainKey))
			return false;
		if (fcmMessages != other.fcmMessages)
			return false;
		if (httpMessages != other.httpMessages)
			return false;
		if (loraMessages != other.loraMessages)
			return false;
		if (mqttMessages != other.mqttMessages)
			return false;
		if (records != other.records)
			return false;
		if (tcpMessages != other.tcpMessages)
			return false;
		if (udpMessages != other.udpMessages)
			return false;
		if (users != other.users)
			return false;
		return true;
	}

}
