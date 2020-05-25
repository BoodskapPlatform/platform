package io.boodskap.iot.model.pojo;

import io.boodskap.iot.model.IAsset;

public class Asset extends AbstractDomainObject implements IAsset {

	private static final long serialVersionUID = -282367964514378742L;
	
	private String assetId;
	
	public Asset() {
	}
	
	@Override
	public String getAssetId() {
		return assetId;
	}

	@Override
	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}

}
