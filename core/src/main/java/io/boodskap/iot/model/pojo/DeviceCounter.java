package io.boodskap.iot.model.pojo;

import java.io.Serializable;

public class DeviceCounter implements Serializable {
	
	private static final long serialVersionUID = -6250348313306135884L;

	private String domainKey;
	private String deviceId;
	private long corrId;

	public DeviceCounter() {
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

	public long getCorrId() {
		return corrId;
	}

	public void setCorrId(long corrId) {
		this.corrId = corrId;
	}

	public void increment() {
		++corrId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (corrId ^ (corrId >>> 32));
		result = prime * result + ((deviceId == null) ? 0 : deviceId.hashCode());
		result = prime * result + ((domainKey == null) ? 0 : domainKey.hashCode());
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
		DeviceCounter other = (DeviceCounter) obj;
		if (corrId != other.corrId)
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
		return true;
	}

}
