package io.boodskap.iot.model.jpa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class AssetGroupMemberId extends AbstractGroupMember implements Serializable{

	private static final long serialVersionUID = -1569282403049973098L;
	
	@Column(name="ownerassetid", length=40)
	private String ownerAssetId;
	
	public AssetGroupMemberId() {
	}

	public AssetGroupMemberId(String domainKey, String ownerAssetId, String groupId, String memberId) {
		super(domainKey, groupId, memberId);
		this.ownerAssetId = ownerAssetId;
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
		AssetGroupMemberId other = (AssetGroupMemberId) obj;
		if (ownerAssetId == null) {
			if (other.ownerAssetId != null)
				return false;
		} else if (!ownerAssetId.equals(other.ownerAssetId))
			return false;
		return true;
	}

}
