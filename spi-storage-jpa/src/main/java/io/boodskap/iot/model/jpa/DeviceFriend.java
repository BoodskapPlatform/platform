package io.boodskap.iot.model.jpa;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import io.boodskap.iot.model.IDeviceFriend;

@Entity
@Table(name="devicefriend")
public class DeviceFriend implements IDeviceFriend {

	private static final long serialVersionUID = -6786902035279097362L;
	
	@EmbeddedId
	private DeviceFriendId id = new DeviceFriendId();
	
	@Column(name="createdstamp")
	private Date createdStamp;
	
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

	public Date getCreatedStamp() {
		return createdStamp;
	}

	public void setCreatedStamp(Date createdStamp) {
		this.createdStamp = createdStamp;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createdStamp == null) ? 0 : createdStamp.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		DeviceFriend other = (DeviceFriend) obj;
		if (createdStamp == null) {
			if (other.createdStamp != null)
				return false;
		} else if (!createdStamp.equals(other.createdStamp))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
