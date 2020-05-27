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
public class DeviceMessageCounter extends AbstractModel implements IDeviceMessageCounter {
	
	private static final long serialVersionUID = 5616127044122652367L;
	
	@EmbeddedId
	private DeviceMessageCounterId id = new DeviceMessageCounterId();

	@Column(name="occurance")
	private long count = 1L;

	public DeviceMessageCounter() {
	}

	public DeviceMessageCounter(DeviceMessageCounterId id) {
		this.id = id;
	}

	@Override
	public IDeviceMessageCounter create(String domainKey, String deviceId, String messageType, Date day) throws StorageException {
		return new DeviceMessageCounter(new DeviceMessageCounterId(domainKey, deviceId, messageType, day));
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

	@Override
	public Date getDay() {
		return id.getDay();
	}

	@Override
	public void setDay(Date day) {
		id.setDay(day);
	}

	@Override
	public long getCount() {
		return count;
	}

	@Override
	public void setCount(long count) {
		this.count = count;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (int) (count ^ (count >>> 32));
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		DeviceMessageCounter other = (DeviceMessageCounter) obj;
		if (count != other.count)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
