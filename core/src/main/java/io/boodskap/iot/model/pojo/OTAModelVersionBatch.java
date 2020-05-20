package io.boodskap.iot.model.pojo;


import io.boodskap.iot.model.IOTAModelVersionBatch;

public class OTAModelVersionBatch extends OTAModelBatch implements IOTAModelVersionBatch{

	private static final long serialVersionUID = 2203720313357591826L;
	
	private String fromVersion;

	public OTAModelVersionBatch() {
		super();
	}

	public OTAModelVersionBatch(String domainKey, String batchId, String fromModel, String fromVersion) {
		super(domainKey, batchId, fromModel);
		this.fromVersion = fromVersion;
	}

	public String getFromVersion() {
		return fromVersion;
	}

	public void setFromVersion(String fromVersion) {
		this.fromVersion = fromVersion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((fromVersion == null) ? 0 : fromVersion.hashCode());
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
		OTAModelVersionBatch other = (OTAModelVersionBatch) obj;
		if (fromVersion == null) {
			if (other.fromVersion != null)
				return false;
		} else if (!fromVersion.equals(other.fromVersion))
			return false;
		return true;
	}
	
}
