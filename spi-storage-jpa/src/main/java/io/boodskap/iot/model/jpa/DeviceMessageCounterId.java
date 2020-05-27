package io.boodskap.iot.model.jpa;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import io.boodskap.iot.SizeConstants;

@Embeddable
public class DeviceMessageCounterId implements Serializable{

	private static final long serialVersionUID = 4652182033348790106L;

	@Column(name="domainkey", length=SizeConstants.DOMAIN_SIZE)
	private String domainKey;

	@Column(name="deviceid", length=SizeConstants.DEVICE_ID_SIZE)
	private String deviceId;

	@Column(name="messagetype", length=40)
	String messageType;

	@Column(name="day")
	private Date day;
	
	public DeviceMessageCounterId() {
	}

	public DeviceMessageCounterId(String domainKey, String deviceId, String messageType, Date day) {
		super();
		this.domainKey = domainKey;
		this.deviceId = deviceId;
		this.messageType = messageType;
		this.day = day;
	}

	public String getDomainKey() {
		return domainKey;
	}

	public void setDomainKey(String domainKey) {
		this.domainKey = domainKey;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getMessageType() {
		return messageType;
	}

	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}

	public Date getDay() {
		return day;
	}

	public void setDay(Date day) {
		this.day = day;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((day == null) ? 0 : day.hashCode());
		result = prime * result + ((deviceId == null) ? 0 : deviceId.hashCode());
		result = prime * result + ((domainKey == null) ? 0 : domainKey.hashCode());
		result = prime * result + ((messageType == null) ? 0 : messageType.hashCode());
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
		DeviceMessageCounterId other = (DeviceMessageCounterId) obj;
		if (day == null) {
			if (other.day != null)
				return false;
		} else if (!day.equals(other.day))
			return false;
		if (deviceId == null) {
			if (other.deviceId != null)
				return false;
		} else if (!deviceId.equals(other.deviceId))
			return false;
		if (domainKey == null) {
			if (other.domainKey != null)
				return false;
		} else if (!domainKey.equals(other.domainKey))
			return false;
		if (messageType == null) {
			if (other.messageType != null)
				return false;
		} else if (!messageType.equals(other.messageType))
			return false;
		return true;
	}

}
