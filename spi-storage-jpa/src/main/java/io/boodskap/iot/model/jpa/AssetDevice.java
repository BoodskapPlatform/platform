package io.boodskap.iot.model.jpa;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import io.boodskap.iot.model.IAssetDevice;

@Entity
@Table(name="assetdevice")
public class AssetDevice implements IAssetDevice {

	private static final long serialVersionUID = -7991764374073919093L;

	@EmbeddedId
	private AssetDeviceId id = new AssetDeviceId();
	
	@Column(name="name", length=40)
	private String name = null;
	
	@Column(name="description", length=120)
	private String description = null;

	@Column(name="rstamp")
	private Date registeredStamp = new Date();
	
	@Column(name="ustamp")
	private Date updatedStamp = new Date();
	
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
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public Date getRegisteredStamp() {
		return registeredStamp;
	}

	@Override
	public void setRegisteredStamp(Date registeredStamp) {
		this.registeredStamp = registeredStamp;
	}

	@Override
	public Date getUpdatedStamp() {
		return updatedStamp;
	}

	@Override
	public void setUpdatedStamp(Date updatedStamp) {
		this.updatedStamp = updatedStamp;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((registeredStamp == null) ? 0 : registeredStamp.hashCode());
		result = prime * result + ((updatedStamp == null) ? 0 : updatedStamp.hashCode());
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
		AssetDevice other = (AssetDevice) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (registeredStamp == null) {
			if (other.registeredStamp != null)
				return false;
		} else if (!registeredStamp.equals(other.registeredStamp))
			return false;
		if (updatedStamp == null) {
			if (other.updatedStamp != null)
				return false;
		} else if (!updatedStamp.equals(other.updatedStamp))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return toJSONString();
	}

}
