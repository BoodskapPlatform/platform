package io.boodskap.iot.model.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.boodskap.iot.model.ICounter;

@Entity
@Table(name="counter")
public class Counter implements ICounter {

	private static final long serialVersionUID = 9111854199806271176L;
	
	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="domains")
	private long domains;
	
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
	
	public Counter() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getUsers() {
		return users;
	}

	public void setUsers(long users) {
		this.users = users;
	}

	public long getDevices() {
		return devices;
	}

	public void setDevices(long devices) {
		this.devices = devices;
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

	public long getCommands() {
		return commands;
	}

	public void setCommands(long commands) {
		this.commands = commands;
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

	public long getDomains() {
		return domains;
	}

	public void setDomains(long domains) {
		this.domains = domains;
	}

	public long getLoraMessages() {
		return loraMessages;
	}

	public void setLoraMessages(long loraMessages) {
		this.loraMessages = loraMessages;
	}

	public long getRecords() {
		return records;
	}

	public void setRecords(long records) {
		this.records = records;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (coapMessages ^ (coapMessages >>> 32));
		result = prime * result + (int) (commands ^ (commands >>> 32));
		result = prime * result + (int) (devices ^ (devices >>> 32));
		result = prime * result + (int) (domains ^ (domains >>> 32));
		result = prime * result + (int) (fcmMessages ^ (fcmMessages >>> 32));
		result = prime * result + (int) (httpMessages ^ (httpMessages >>> 32));
		result = prime * result + id;
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
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Counter other = (Counter) obj;
		if (coapMessages != other.coapMessages)
			return false;
		if (commands != other.commands)
			return false;
		if (devices != other.devices)
			return false;
		if (domains != other.domains)
			return false;
		if (fcmMessages != other.fcmMessages)
			return false;
		if (httpMessages != other.httpMessages)
			return false;
		if (id != other.id)
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
