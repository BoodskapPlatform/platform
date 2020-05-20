package io.boodskap.iot.model.jpa;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import io.boodskap.iot.model.IOTADeviceBatchMember;

@Entity
@Table(name="otadevicebatchmember")
public class OTADeviceBatchMember extends AbstractOTABatchMember implements IOTADeviceBatchMember {

	private static final long serialVersionUID = -2973293800293596264L;
	
	@EmbeddedId
	private OTADeviceBatchMemberId id = new OTADeviceBatchMemberId();
	
	public OTADeviceBatchMember() {
	}
	
	public OTADeviceBatchMember(OTADeviceBatchMemberId id) {
		this.id = id;
	}

	public String getDeviceId() {
		return id.getDeviceId();
	}

	public void setDeviceId(String deviceId) {
		id.setDeviceId(deviceId);
	}

	public String getDomainKey() {
		return id.getDomainKey();
	}

	public void setDomainKey(String domainKey) {
		id.setDomainKey(domainKey);
	}

	public String getBatchId() {
		return id.getBatchId();
	}

	public void setBatchId(String batchId) {
		id.setBatchId(batchId);
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
		OTADeviceBatchMember other = (OTADeviceBatchMember) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
