package io.boodskap.iot.model.jpa;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import io.boodskap.iot.model.IOTAModelBatchMember;

@Entity
@Table(name="otamodelbatchmember")
public class OTAModelBatchMember extends AbstractOTABatchMember implements IOTAModelBatchMember{

	private static final long serialVersionUID = 7638112581095469565L;
	
	@EmbeddedId
	private OTAModelBatchMemberId id = new OTAModelBatchMemberId();
	
	public OTAModelBatchMember() {
	}
	
	public OTAModelBatchMember(OTAModelBatchMemberId id) {
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

	public String getFromModel() {
		return id.getFromModel();
	}

	public void setFromModel(String fromModel) {
		id.setFromModel(fromModel);
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
		OTAModelBatchMember other = (OTAModelBatchMember) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
