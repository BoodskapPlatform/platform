package io.boodskap.iot.model.jpa;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.model.IDeviceMessageCounter;

@Entity
@Table(name = "devicemessagecounter")
public class DeviceMessageCounter implements IDeviceMessageCounter {
	
	private static final long serialVersionUID = 5616127044122652367L;
	
	@EmbeddedId
	private DeviceMessageCounterId id = new DeviceMessageCounterId();

	@Column(name="day")
	private Date day;
	
	@Column(name="occurance")
	private long count = 1L;

	public DeviceMessageCounter() {
	}

	public DeviceMessageCounter(DeviceMessageCounterId id) {
		this.id = id;
	}

	@Override
	public IDeviceMessageCounter create(String domainKey, String deviceId, String messageType, String messageId) throws StorageException {
		return new DeviceMessageCounter(new DeviceMessageCounterId(domainKey, deviceId, messageType, messageId));
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

	public String getMessageType() {
		return id.getMessageType();
	}

	public void setMessageType(String messageType) {
		id.setMessageType(messageType);
	}

	public String getMessageId() {
		return id.getMessageId();
	}

	public void setMessageId(String messageId) {
		id.setMessageId(messageId);
	}

	@Override
	public Date getDay() {
		return day;
	}

	@Override
	public void setDay(Date day) {
		this.day = day;
	}

	@Override
	public long getCount() {
		return count;
	}

	@Override
	public void setCount(long count) {
		this.count = count;
	}

}
