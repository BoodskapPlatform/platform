package io.boodskap.iot.model.jpa;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import io.boodskap.iot.model.IOTAModelBatch;

@Entity
@Table(name="otamodelbatch")
public class OTAModelBatch extends AbstractOTABatch implements IOTAModelBatch{

	private static final long serialVersionUID = 2203720313357591826L;
	
	@EmbeddedId
	private OTAModelBatchId id = new OTAModelBatchId();
	
	public OTAModelBatch() {
	}

	public OTAModelBatch(OTAModelBatchId id) {
		this.id = id;
	}

	public String getFromModel() {
		return id.getFromModel();
	}

	public void setFromModel(String fromModel) {
		id.setFromModel(fromModel);
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
		OTAModelBatch other = (OTAModelBatch) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
