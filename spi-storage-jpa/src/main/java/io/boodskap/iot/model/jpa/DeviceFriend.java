package io.boodskap.iot.model.jpa;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import io.boodskap.iot.model.IDeviceFriend;

@Entity
@Table(name="devicefriend")
public class DeviceFriend extends AbstractModel implements IDeviceFriend {

	private static final long serialVersionUID = -6786902035279097362L;
	
	@EmbeddedId
	private DeviceFriendId id = new DeviceFriendId();
	
	public DeviceFriend(){
	}

	public DeviceFriend(DeviceFriendId id) {
		this.id = id;
	}

	public String getDomainKey() {
		return id.getDomainKey();
	}

	public void setDomainKey(String domainKey) {
		id.setDomainKey(domainKey);
	}

	public String getDeviceId() {
		return id.getDeviceId();
	}

	public void setDeviceId(String deviceId) {
		id.setDeviceId(deviceId);
	}

	public String getFriendId() {
		return id.getFriendId();
	}

	public void setFriendId(String friendId) {
		id.setFriendId(friendId);
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
		DeviceFriend other = (DeviceFriend) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
