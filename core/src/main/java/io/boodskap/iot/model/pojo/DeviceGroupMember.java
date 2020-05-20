package io.boodskap.iot.model.pojo;

import java.util.Date;

import io.boodskap.iot.model.IDeviceGroupMember;

public class DeviceGroupMember implements IDeviceGroupMember {

	private static final long serialVersionUID = 3145780633218160100L;
	
	private String domainKey;
	private String groupId;
	private String ownerDeviceId;
	private String memberId;
	private Date registeredStamp;
	
	public DeviceGroupMember(){
	}

	public String getDomainKey() {
		return domainKey;
	}

	public void setDomainKey(String domainKey) {
		this.domainKey = domainKey;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getOwnerDeviceId() {
		return ownerDeviceId;
	}

	public void setOwnerDeviceId(String ownerDeviceId) {
		this.ownerDeviceId = ownerDeviceId;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public Date getRegisteredStamp() {
		return registeredStamp;
	}

	public void setRegisteredStamp(Date registeredStamp) {
		this.registeredStamp = registeredStamp;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((domainKey == null) ? 0 : domainKey.hashCode());
		result = prime * result + ((groupId == null) ? 0 : groupId.hashCode());
		result = prime * result + ((memberId == null) ? 0 : memberId.hashCode());
		result = prime * result + ((ownerDeviceId == null) ? 0 : ownerDeviceId.hashCode());
		result = prime * result + ((registeredStamp == null) ? 0 : registeredStamp.hashCode());
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
		DeviceGroupMember other = (DeviceGroupMember) obj;
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
		if (memberId == null) {
			if (other.memberId != null)
				return false;
		} else if (!memberId.equals(other.memberId))
			return false;
		if (ownerDeviceId == null) {
			if (other.ownerDeviceId != null)
				return false;
		} else if (!ownerDeviceId.equals(other.ownerDeviceId))
			return false;
		if (registeredStamp == null) {
			if (other.registeredStamp != null)
				return false;
		} else if (!registeredStamp.equals(other.registeredStamp))
			return false;
		return true;
	}

}
