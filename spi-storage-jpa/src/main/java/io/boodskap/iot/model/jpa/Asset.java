package io.boodskap.iot.model.jpa;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import io.boodskap.iot.model.IAsset;

@Entity
@Table(name="asset")
public class Asset extends AbstractModel implements IAsset {

	private static final long serialVersionUID = -282367964514378742L;
	
	@EmbeddedId
	private AssetId id = new AssetId();
	
	public Asset() {
	}
	
	public Asset(String domainKey, String assetId) {
		this(new AssetId(domainKey, assetId));
	}

	public Asset(AssetId id) {
		this.id  = id;
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
	public String getAssetId() {
		return id.getAssetId();
	}

	@Override
	public void setAssetId(String assetId) {
		id.setAssetId(assetId);
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
		Asset other = (Asset) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
