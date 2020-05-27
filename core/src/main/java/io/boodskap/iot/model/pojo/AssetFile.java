package io.boodskap.iot.model.pojo;

import io.boodskap.iot.model.IAssetFile;
import io.boodskap.iot.model.IFileContent;

public class AssetFile extends AbstractFile implements IAssetFile {

	private static final long serialVersionUID = 5503608365308778463L;
	
	private String assetId;
	
	public AssetFile() {
	}


	public AssetFile(String domainKey, String assetId, String fileId) {
		super(domainKey, fileId);
		this.assetId = assetId;
	}


	@Override
	public IFileContent createContent() {
		return new FileContent(getData(), getMediaType());
	}

	public String getAssetId() {
		return assetId;
	}

	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((assetId == null) ? 0 : assetId.hashCode());
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
		return true;
	}

}
