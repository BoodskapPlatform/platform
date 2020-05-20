package io.boodskap.iot.model.jpa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class DeviceGroupId implements Serializable {
	
	private static final long serialVersionUID = -2253427326451191062L;

	@Column(name="domainkey", length=16)
	private String domainKey;

	@Column(name="ownerdeviceid", length=40)
	private String ownerDeviceId;

	@Column(name="groupid", length=40)
	private String groupId;

	public DeviceGroupId() {
	}

	public DeviceGroupId(String domainKey, String ownerDeviceId, String groupId) {
		this.domainKey = domainKey;
		this.ownerDeviceId = ownerDeviceId;
		this.groupId = groupId;
	}

	public String getDomainKey() {
		return domainKey;
	}

	public void setDomainKey(String domainKey) {
		this.domainKey = domainKey;
	}

	public String getOwnerDeviceId() {
		return ownerDeviceId;
	}

	public void setOwnerDeviceId(String ownerDeviceId) {
		this.ownerDeviceId = ownerDeviceId;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((domainKey == null) ? 0 : domainKey.hashCode());
		result = prime * result + ((groupId == null) ? 0 : groupId.hashCode());
		result = prime * result + ((ownerDeviceId == null) ? 0 : ownerDeviceId.hashCode());
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
		DeviceGroupId other = (DeviceGroupId) obj;
		if (domainKey == null) {
			if (other.domainKey != null)
				return false;
		} else if (!domainKey.equals(other.domainKey))
			return false;
		if (groupId == null) {
			if (other.groupId != null)
				return false;
		} else if (!groupId.equals(other.groupId))
			return false;
		if (ownerDeviceId == null) {
			if (other.ownerDeviceId != null)
				return false;
		} else if (!ownerDeviceId.equals(other.ownerDeviceId))
			return false;
		return true;
	}

}
