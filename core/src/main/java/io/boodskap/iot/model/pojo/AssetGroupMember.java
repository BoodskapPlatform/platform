package io.boodskap.iot.model.pojo;

import io.boodskap.iot.model.IAssetGroupMember;

public class AssetGroupMember extends AbstractGroupMember implements IAssetGroupMember {

	private static final long serialVersionUID = 5613603173448633330L;

	private String ownerAssetId;
	
	public AssetGroupMember(){
	}

	public String getOwnerAssetId() {
		return ownerAssetId;
	}

	public void setOwnerAssetId(String ownerAssetId) {
		this.ownerAssetId = ownerAssetId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
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
		AssetGroupMember other = (AssetGroupMember) obj;
		if (ownerAssetId == null) {
			if (other.ownerAssetId != null)
				return false;
		} else if (!ownerAssetId.equals(other.ownerAssetId))
			return false;
		return true;
	}

}
