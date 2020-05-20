package io.boodskap.iot.model.jpa;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import io.boodskap.iot.model.IAssetFile;
import io.boodskap.iot.model.IFileContent;

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
	public IFileContent createContent() {
		return new FileContent(getData(), getMediaType());
	}

	public String getDomainKey() {
		return id.getDomainKey();
	}

	public void setDomainKey(String domainKey) {
		id.setDomainKey(domainKey);
	}

	public String getAssetId() {
		return id.getAssetId();
	}

	public void setAssetId(String assetId) {
		id.setAssetId(assetId);
	}

	public String getFileId() {
		return id.getFileId();
	}

	public void setFileId(String fileId) {
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
