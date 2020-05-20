package io.boodskap.iot.model.pojo;

import io.boodskap.iot.model.IAssetFile;
import io.boodskap.iot.model.IFileContent;

public class AssetFile extends AbstractFile implements IAssetFile {

	private static final long serialVersionUID = 5503608365308778463L;
	
	private String domainKey;
	private String assetId;
	private String fileId;
	
	public AssetFile() {
	}


	public AssetFile(String domainKey, String assetId, String fileId) {
		super();
		this.domainKey = domainKey;
		this.assetId = assetId;
		this.fileId = fileId;
	}


	@Override
	public IFileContent createContent() {
		return new FileContent(getData(), getMediaType());
	}

	public String getDomainKey() {
		return domainKey;
	}

	public void setDomainKey(String domainKey) {
		this.domainKey = domainKey;
	}

	public String getAssetId() {
		return assetId;
	}

	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}

	public String getFileId() {
		return fileId;
	}

	public void setFileId(String fileId) {
		this.fileId = fileId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((assetId == null) ? 0 : assetId.hashCode());
		result = prime * result + ((domainKey == null) ? 0 : domainKey.hashCode());
		result = prime * result + ((fileId == null) ? 0 : fileId.hashCode());
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
		if (assetId == null) {
			if (other.assetId != null)
				return false;
		} else if (!assetId.equals(other.assetId))
			return false;
		if (domainKey == null) {
			if (other.domainKey != null)
				return false;
		} else if (!domainKey.equals(other.domainKey))
			return false;
		if (fileId == null) {
			if (other.fileId != null)
				return false;
		} else if (!fileId.equals(other.fileId))
			return false;
		return true;
	}

}
