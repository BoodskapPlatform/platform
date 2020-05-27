package io.boodskap.iot.model.pojo;

import io.boodskap.iot.model.IAssetGroup;

public class AssetGroup extends AbstractGroup implements IAssetGroup{
	
	private static final long serialVersionUID = -3962807629074894312L;
	
	private String ownerAssetId;
	
	public AssetGroup() {
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
		AssetGroup other = (AssetGroup) obj;
		if (ownerAssetId == null) {
			if (other.ownerAssetId != null)
				return false;
		} else if (!ownerAssetId.equals(other.ownerAssetId))
			return false;
		return true;
	}

}
