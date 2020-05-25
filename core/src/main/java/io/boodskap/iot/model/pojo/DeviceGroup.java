package io.boodskap.iot.model.pojo;

import io.boodskap.iot.model.IDeviceGroup;

public class DeviceGroup extends AbstractGroup implements IDeviceGroup {

	private static final long serialVersionUID = 4221527566389446642L;
	
	private String ownerDeviceId;
	private String groupId;
	
	public DeviceGroup() {
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
		int result = super.hashCode();
		result = prime * result + ((groupId == null) ? 0 : groupId.hashCode());
		result = prime * result + ((ownerDeviceId == null) ? 0 : ownerDeviceId.hashCode());
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
		DeviceGroup other = (DeviceGroup) obj;
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
