package io.boodskap.iot.model.pojo;


import io.boodskap.iot.model.IOTABatch;

public class OTABatch extends AbstractOTABatch implements IOTABatch {

	private static final long serialVersionUID = 2232403252280696495L;
	
	private String domainKey;
	private String batchId;

	public OTABatch() {
	}

	public OTABatch(String domainKey, String batchId) {
		this.domainKey = domainKey;
		this.batchId = batchId;
	}

	public String getDomainKey() {
		return domainKey;
	}

	public void setDomainKey(String domainKey) {
		this.domainKey = domainKey;
	}

	public String getBatchId() {
		return batchId;
	}

	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((batchId == null) ? 0 : batchId.hashCode());
		result = prime * result + ((domainKey == null) ? 0 : domainKey.hashCode());
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
		if (batchId == null) {
			if (other.batchId != null)
				return false;
		} else if (!batchId.equals(other.batchId))
			return false;
		if (domainKey == null) {
			if (other.domainKey != null)
				return false;
		} else if (!domainKey.equals(other.domainKey))
			return false;
		return true;
	}

}
