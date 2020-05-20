package io.boodskap.iot.model.jpa;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import io.boodskap.iot.model.IDeviceGroup;

@Entity
@Table(name="devicegroup")
public class DeviceGroup extends AbstractGroup implements IDeviceGroup {

	private static final long serialVersionUID = 4221527566389446642L;
	
	@EmbeddedId
	private DeviceGroupId id = new DeviceGroupId();
	
	public DeviceGroup() {
	}

	public DeviceGroup(DeviceGroupId id) {
		this.id = id;
	}

	public String getOwnerDeviceId() {
		return id.getOwnerDeviceId();
	}

	public void setOwnerDeviceId(String ownerDeviceId) {
		id.setOwnerDeviceId(ownerDeviceId);
	}

	public String getDomainKey() {
		return id.getDomainKey();
	}

	public void setDomainKey(String domainKey) {
		id.setDomainKey(domainKey);
	}

	public String getGroupId() {
		return id.getGroupId();
	}

	public void setGroupId(String groupId) {
		id.setGroupId(groupId);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
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
		DeviceGroup other = (DeviceGroup) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
