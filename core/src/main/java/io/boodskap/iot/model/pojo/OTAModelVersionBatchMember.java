package io.boodskap.iot.model.pojo;


import io.boodskap.iot.model.IOTAModelVersionBatchMember;

public class OTAModelVersionBatchMember extends OTAModelBatchMember implements IOTAModelVersionBatchMember{

	private static final long serialVersionUID = -6575349718275027958L;

	private String fromVersion;

	public OTAModelVersionBatchMember() {
		super();
	}

	public OTAModelVersionBatchMember(String domainKey, String batchId, String fromModel, String fromVersion, String deviceId) {
		super(domainKey, batchId, fromModel, deviceId);
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
		OTAModelVersionBatchMember other = (OTAModelVersionBatchMember) obj;
		if (fromVersion == null) {
			if (other.fromVersion != null)
				return false;
		} else if (!fromVersion.equals(other.fromVersion))
			return false;
		return true;
	}
	
}
