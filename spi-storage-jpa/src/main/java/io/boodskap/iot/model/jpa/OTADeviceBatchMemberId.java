package io.boodskap.iot.model.jpa;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class OTADeviceBatchMemberId extends OTABatchId {
	
	private static final long serialVersionUID = -7441644528336779792L;
	
	@Column(name="deviceid", length=40)
	private String deviceId;

	public OTADeviceBatchMemberId() {
	}

	public OTADeviceBatchMemberId(String domainKey, String id, String deviceId) {
		super(domainKey, id);
		this.deviceId = deviceId;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((deviceId == null) ? 0 : deviceId.hashCode());
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
		OTADeviceBatchMemberId other = (OTADeviceBatchMemberId) obj;
		if (deviceId == null) {
			if (other.deviceId != null)
				return false;
		} else if (!deviceId.equals(other.deviceId))
			return false;
		return true;
	}

}
