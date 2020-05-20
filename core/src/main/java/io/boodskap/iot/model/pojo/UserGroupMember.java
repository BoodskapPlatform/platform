package io.boodskap.iot.model.pojo;

import io.boodskap.iot.model.IUserGroupMember;

public class UserGroupMember extends AbstractGroupMember implements IUserGroupMember {

	private static final long serialVersionUID = -3187547251745117912L;
	
	private String ownerUserId;

	public UserGroupMember(){
	}

	public UserGroupMember(String domainKey, String ownerUserId, String groupId, String memberId) {
		super(domainKey, groupId, memberId);
		this.ownerUserId = ownerUserId;
	}

	public String getOwnerUserId() {
		return ownerUserId;
	}

	public void setOwnerUserId(String ownerUserId) {
		this.ownerUserId = ownerUserId;
	}

}
