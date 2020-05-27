package io.boodskap.iot.model.jpa;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import io.boodskap.iot.model.IAssetDevice;

@Entity
@Table(name="assetdevice")
public class AssetDevice extends AbstractModel implements IAssetDevice {

	private static final long serialVersionUID = -7991764374073919093L;

	@EmbeddedId
	private AssetDeviceId id = new AssetDeviceId();
	
	public AssetDevice() {
	}
	
	public AssetDevice(AssetDeviceId id) {
		this.id = id;
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
	public String getDeviceId() {
		return id.getDeviceId();
	}

	@Override
	public void setDeviceId(String deviceId) {
		id.setDeviceId(deviceId);
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
		AssetDevice other = (AssetDevice) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
