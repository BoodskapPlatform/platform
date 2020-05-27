package io.boodskap.iot.model.pojo;

import io.boodskap.iot.model.IGroupMember;

public abstract class AbstractGroupMember extends AbstractDomainObject implements IGroupMember {

	private static final long serialVersionUID = 7540023549338386842L;

	private String groupId;
	private String memberId;
	
	public AbstractGroupMember(){
	}

	@Override
	public final String getGroupId() {
		return groupId;
	}

	@Override
	public final void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	@Override
	public final String getMemberId() {
		return memberId;
	}

	@Override
	public final void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((groupId == null) ? 0 : groupId.hashCode());
		result = prime * result + ((memberId == null) ? 0 : memberId.hashCode());
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
		AbstractGroupMember other = (AbstractGroupMember) obj;
		if (groupId == null) {
			if (other.groupId != null)
				return false;
		} else if (!groupId.equals(other.groupId))
			return false;
		if (memberId == null) {
			if (other.memberId != null)
				return false;
		} else if (!memberId.equals(other.memberId))
			return false;
		return true;
	}

}
