package io.boodskap.iot.model.jpa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class AssetGroupId implements Serializable{

	private static final long serialVersionUID = -1569282403049973098L;
	
	@Column(name="domainkey", length=16)
	private String domainKey;
	
	@Column(name="ownerassetid", length=40)
	private String ownerAssetId;
	
	@Column(name="groupid", length=40)
	private String groupId;

	public AssetGroupId() {
	}

	public AssetGroupId(String domainKey, String ownerAssetId, String groupId) {
		this.domainKey = domainKey;
		this.ownerAssetId = ownerAssetId;
		this.groupId = groupId;
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
		int result = 1;
		result = prime * result + ((domainKey == null) ? 0 : domainKey.hashCode());
		result = prime * result + ((groupId == null) ? 0 : groupId.hashCode());
		result = prime * result + ((ownerAssetId == null) ? 0 : ownerAssetId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AssetGroupId other = (AssetGroupId) obj;
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
