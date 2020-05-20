package io.boodskap.iot.model.pojo;

import io.boodskap.iot.model.IUserAssetGroupMember;

public class UserAssetGroupMember extends AbstractGroupMember implements IUserAssetGroupMember {

	private static final long serialVersionUID = 1529160164544233968L;
	
	private String ownerUserId;
	
	public UserAssetGroupMember() {
	}

	public UserAssetGroupMember(String domainKey, String ownerUserId, String groupId, String memberId) {
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
		UserAssetGroupMember other = (UserAssetGroupMember) obj;
		if (ownerUserId == null) {
			if (other.ownerUserId != null)
				return false;
		} else if (!ownerUserId.equals(other.ownerUserId))
			return false;
		return true;
	}

}
