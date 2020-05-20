package io.boodskap.iot.model.jpa;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import io.boodskap.iot.model.IUserDeviceGroup;

@Entity()
@Table(name="userdevicegroup")
public class UserDeviceGroup extends AbstractGroup implements IUserDeviceGroup {

	private static final long serialVersionUID = -7327983619432286369L;
	
	@EmbeddedId
	private UserDeviceGroupId id = new UserDeviceGroupId();
	
	public UserDeviceGroup() {
	}
	
	public UserDeviceGroup(UserDeviceGroupId id) {
		this.id = id;
	}

	public String getDomainKey() {
		return id.getDomainKey();
	}

	public void setDomainKey(String domainKey) {
		id.setDomainKey(domainKey);
	}

	public String getOwnerUserId() {
		return id.getOwnerUserId();
	}

	public void setOwnerUserId(String ownerUserId) {
		id.setOwnerUserId(ownerUserId);
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
		UserDeviceGroup other = (UserDeviceGroup) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
