package io.boodskap.iot.model.jpa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class OutgoingCommandId implements Serializable {
	
	private static final long serialVersionUID = -2286547242203260653L;

	@Column(name="domainkey", length=16)
	private String domainKey;

	@Column(name="requestid", length=40)
	private String requestId;

	@Column(name="deviceid", length=40)
	private String deviceId;

	@Column(name="corrid")
	private long corrId;

	public OutgoingCommandId() {
	}

	public OutgoingCommandId(String domainKey, String requestId, String deviceId, long corrId) {
		this.domainKey = domainKey;
		this.requestId = requestId;
		this.deviceId = deviceId;
		this.corrId = corrId;
	}

	public String getDomainKey() {
		return domainKey;
	}

	public void setDomainKey(String domainKey) {
		this.domainKey = domainKey;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (corrId ^ (corrId >>> 32));
		result = prime * result + ((deviceId == null) ? 0 : deviceId.hashCode());
		result = prime * result + ((domainKey == null) ? 0 : domainKey.hashCode());
		result = prime * result + ((requestId == null) ? 0 : requestId.hashCode());
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
		OutgoingCommandId other = (OutgoingCommandId) obj;
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
		if (requestId == null) {
			if (other.requestId != null)
				return false;
		} else if (!requestId.equals(other.requestId))
			return false;
		return true;
	}

}
