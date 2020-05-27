package io.boodskap.iot.model.jpa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class DeviceGroupMemberId extends AbstractGroupMemberId implements Serializable {
	
	private static final long serialVersionUID = -1058405677059747383L;

	@Column(name="ownerdeviceid", length=40)
	private String ownerDeviceId;

	public DeviceGroupMemberId() {
	}

	public DeviceGroupMemberId(String domainKey, String ownerDeviceId, String groupId, String memberId) {
		super(domainKey, groupId, memberId);
		this.ownerDeviceId = ownerDeviceId;
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
		DeviceGroupMemberId other = (DeviceGroupMemberId) obj;
		if (ownerDeviceId == null) {
			if (other.ownerDeviceId != null)
				return false;
		} else if (!ownerDeviceId.equals(other.ownerDeviceId))
			return false;
		return true;
	}

}
