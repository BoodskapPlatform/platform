package io.boodskap.iot.model.jpa;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import io.boodskap.iot.model.IAssetFile;

@Entity
@Table(name="assetfile")
public class AssetFile extends AbstractFile implements IAssetFile {

	private static final long serialVersionUID = 5503608365308778463L;
	
	@EmbeddedId
	private AssetFileId id = new AssetFileId();
	
	public AssetFile() {
	}

	public AssetFile(AssetFileId id) {
		this.id = id;
	}

	@Override
	public final String getDomainKey() {
		return id.getDomainKey();
	}

	@Override
	public final void setDomainKey(String domainKey) {
		id.setDomainKey(domainKey);
	}

	@Override
	public final String getAssetId() {
		return id.getAssetId();
	}

	@Override
	public final void setAssetId(String assetId) {
		id.setAssetId(assetId);
	}

	@Override
	public final String getFileId() {
		return id.getFileId();
	}

	@Override
	public final void setFileId(String fileId) {
		id.setFileId(fileId);
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
		AssetFile other = (AssetFile) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
