package io.boodskap.iot.model.jpa;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import io.boodskap.iot.model.IOTABatchMember;

@Entity
@Table(name="otabatchmember")
public class OTABatchMember extends AbstractOTABatchMember implements IOTABatchMember {

	private static final long serialVersionUID = -2415965661903966697L;
	
	@EmbeddedId
	private OTABatchMemberId id = new OTABatchMemberId();
	
	public OTABatchMember() {
	}

	public OTABatchMember(OTABatchMemberId id) {
		this.id = id;
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

	public String getDeviceId() {
		return id.getDeviceId();
	}

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
		OTABatchMember other = (OTABatchMember) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
