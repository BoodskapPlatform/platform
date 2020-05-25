package io.boodskap.iot.model.pojo;

import io.boodskap.iot.model.IDeviceGroupMember;

public class DeviceGroupMember extends AbstractGroupMember implements IDeviceGroupMember {

	private static final long serialVersionUID = 3145780633218160100L;
	
	private String ownerDeviceId;
	
	public DeviceGroupMember(){
	}

	public String getOwnerDeviceId() {
		return ownerDeviceId;
	}

	public void setOwnerDeviceId(String ownerDeviceId) {
		this.ownerDeviceId = ownerDeviceId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
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
		DeviceGroupMember other = (DeviceGroupMember) obj;
		if (ownerDeviceId == null) {
			if (other.ownerDeviceId != null)
				return false;
		} else if (!ownerDeviceId.equals(other.ownerDeviceId))
			return false;
		return true;
	}

}
