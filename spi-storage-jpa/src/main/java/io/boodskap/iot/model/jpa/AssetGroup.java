package io.boodskap.iot.model.jpa;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import io.boodskap.iot.model.IAssetGroup;

@Entity
@Table(name="assetgroup")
public class AssetGroup extends AbstractGroup implements IAssetGroup{
	
	private static final long serialVersionUID = -3962807629074894312L;
	
	@EmbeddedId
	private AssetGroupId id = new AssetGroupId();
	
	public AssetGroup() {
	}

	public AssetGroup(AssetGroupId id) {
		this.id = id;
	}

	public String getDomainKey() {
		return id.getDomainKey();
	}

	public void setDomainKey(String domainKey) {
		id.setDomainKey(domainKey);
	}

	public String getOwnerAssetId() {
		return id.getOwnerAssetId();
	}

	public void setOwnerAssetId(String ownerAssetId) {
		id.setOwnerAssetId(ownerAssetId);
	}
	
	public String getGroupId() {
		return id.getGroupId();
	}

	public void setGroupId(String groupId) {
		id.setGroupId(groupId);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
