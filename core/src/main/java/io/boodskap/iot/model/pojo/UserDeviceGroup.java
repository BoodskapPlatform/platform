package io.boodskap.iot.model.pojo;


import io.boodskap.iot.model.IUserDeviceGroup;

public class UserDeviceGroup extends AbstractGroup implements IUserDeviceGroup {

	private static final long serialVersionUID = -7327983619432286369L;
	
	private String ownerUserId;

	public UserDeviceGroup() {
	}

	public String getOwnerUserId() {
		return ownerUserId;
	}

	public void setOwnerUserId(String ownerUserId) {
		this.ownerUserId = ownerUserId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((ownerUserId == null) ? 0 : ownerUserId.hashCode());
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
		UserDeviceGroup other = (UserDeviceGroup) obj;
		if (ownerUserId == null) {
			if (other.ownerUserId != null)
				return false;
		} else if (!ownerUserId.equals(other.ownerUserId))
			return false;
		return true;
	}
	
}
