package io.boodskap.iot.model.pojo;

import io.boodskap.iot.model.IDomainAssetGroup;

public class DomainAssetGroup extends AbstractGroup implements IDomainAssetGroup {
	
	private static final long serialVersionUID = -5654927223503778304L;

	private String groupId;

	public DomainAssetGroup() {
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((groupId == null) ? 0 : groupId.hashCode());
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
		DomainAssetGroup other = (DomainAssetGroup) obj;
		if (groupId == null) {
			if (other.groupId != null)
				return false;
		} else if (!groupId.equals(other.groupId))
			return false;
		return true;
	}

}
