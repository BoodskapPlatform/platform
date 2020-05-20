package io.boodskap.iot.model.pojo;

import io.boodskap.iot.model.IAssetGroup;

public class AssetGroup extends AbstractGroup implements IAssetGroup{
	
	private static final long serialVersionUID = -3962807629074894312L;
	
	private String domainKey;
	private String ownerAssetId;
	private String groupId;
	
	public AssetGroup() {
	}

	public String getDomainKey() {
		return domainKey;
	}

	public void setDomainKey(String domainKey) {
		this.domainKey = domainKey;
	}

	public String getOwnerAssetId() {
		return ownerAssetId;
	}

	public void setOwnerAssetId(String ownerAssetId) {
		this.ownerAssetId = ownerAssetId;
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
		result = prime * result + ((domainKey == null) ? 0 : domainKey.hashCode());
		result = prime * result + ((groupId == null) ? 0 : groupId.hashCode());
		result = prime * result + ((ownerAssetId == null) ? 0 : ownerAssetId.hashCode());
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
		AssetGroup other = (AssetGroup) obj;
		if (domainKey == null) {
			if (other.domainKey != null)
				return false;
		} else if (!domainKey.equals(other.domainKey))
			return false;
		if (groupId == null) {
			if (other.groupId != null)
				return false;
		} else if (!groupId.equals(other.groupId))
			return false;
		if (ownerAssetId == null) {
			if (other.ownerAssetId != null)
				return false;
		} else if (!ownerAssetId.equals(other.ownerAssetId))
			return false;
		return true;
	}

}
