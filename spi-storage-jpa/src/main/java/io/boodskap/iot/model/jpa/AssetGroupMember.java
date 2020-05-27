package io.boodskap.iot.model.jpa;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import io.boodskap.iot.model.IAssetGroupMember;

@Entity
@Table(name="assetgroupmember")
public class AssetGroupMember extends AbstractModel implements IAssetGroupMember {

	private static final long serialVersionUID = 5613603173448633330L;

	@EmbeddedId
	private AssetGroupMemberId id = new AssetGroupMemberId();
	
	public AssetGroupMember(){
	}

	public AssetGroupMember(AssetGroupMemberId id){
		this.id = id;
	}

	@Override
	public String getGroupId() {
		return id.getGroupId();
	}

	@Override
	public void setGroupId(String groupId) {
		id.setGroupId(groupId);
	}

	@Override
	public String getMemberId() {
		return id.getMemberId();
	}

	@Override
	public void setMemberId(String memberId) {
		id.setMemberId(memberId);
	}

	@Override
	public String getDomainKey() {
		return id.getDomainKey();
	}

	@Override
	public void setDomainKey(String domainKey) {
		id.setDomainKey(domainKey);
	}

	@Override
	public String getOwnerAssetId() {
		return id.getOwnerAssetId();
	}

	@Override
	public void setOwnerAssetId(String ownerAssetId) {
		id.setOwnerAssetId(ownerAssetId);
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
		AssetGroupMember other = (AssetGroupMember) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
