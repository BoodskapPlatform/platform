package io.boodskap.iot.model.jpa;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import io.boodskap.iot.model.IDeviceModel;

@Entity
@Table(name="devicemodel")
public class DeviceModel extends AbstractModel implements IDeviceModel {

	private static final long serialVersionUID = -1271201656801970354L;
	
	@EmbeddedId
	private DeviceModelId id = new DeviceModelId();
	
	public DeviceModel() {
	}
	
	public DeviceModel(DeviceModelId id) {
		this.id = id;
	}

	public String getDomainKey() {
		return id.getDomainKey();
	}

	public void setDomainKey(String domainKey) {
		id.setDomainKey(domainKey);
	}

	public String getModelId() {
		return id.getModelId();
	}

	public void setModelId(String modelId) {
		id.setModelId(modelId);
	}

	public String getVersion() {
		return id.getVersion();
	}

	public void setVersion(String version) {
		id.setVersion(version);
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
		DeviceModel other = (DeviceModel) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
