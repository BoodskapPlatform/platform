package io.boodskap.iot.model.jpa;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import io.boodskap.iot.model.IOTABatch;

@Entity
@Table(name="otabatch")
public class OTABatch extends AbstractOTABatch implements IOTABatch {

	private static final long serialVersionUID = 2232403252280696495L;

	@EmbeddedId
	private OTABatchId id = new OTABatchId();
	
	@Column(name="dummy")
	private Integer dummy;
	
	public OTABatch() {
	}

	public OTABatch(OTABatchId id) {
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

	public Integer getDummy() {
		return dummy;
	}

	public void setDummy(Integer dummy) {
		this.dummy = dummy;
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
		OTABatch other = (OTABatch) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
