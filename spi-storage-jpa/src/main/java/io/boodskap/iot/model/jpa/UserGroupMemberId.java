package io.boodskap.iot.model.jpa;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class UserGroupMemberId extends AbstractGroupMember {

	private static final long serialVersionUID = -3847899451541535739L;
	
	@Column(name="owneruserid", length=40)
	private String ownerUserId;

	public UserGroupMemberId() {
	}

	public UserGroupMemberId(String domainKey, String ownerUserId, String groupId, String memberId) {
		super(domainKey, groupId, memberId);
		this.ownerUserId = ownerUserId;
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
		UserGroupMemberId other = (UserGroupMemberId) obj;
		if (ownerUserId == null) {
			if (other.ownerUserId != null)
				return false;
		} else if (!ownerUserId.equals(other.ownerUserId))
			return false;
		return true;
	}

}
