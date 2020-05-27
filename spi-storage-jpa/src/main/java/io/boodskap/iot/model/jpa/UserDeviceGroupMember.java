package io.boodskap.iot.model.jpa;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import io.boodskap.iot.model.IUserDeviceGroupMember;

@Entity()
@Table(name="userdevicegroupmember")
public class UserDeviceGroupMember extends AbstractModel implements IUserDeviceGroupMember {

	private static final long serialVersionUID = 1362210842277045086L;
	
	@EmbeddedId
	private UserDeviceGroupMemberId id = new UserDeviceGroupMemberId();

	public UserDeviceGroupMember() {
	}

	public UserDeviceGroupMember(UserDeviceGroupMemberId id) {
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

	public String getMemberId() {
		return id.getMemberId();
	}

	public void setMemberId(String memberId) {
		id.setMemberId(memberId);
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
		UserDeviceGroupMember other = (UserDeviceGroupMember) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
