package io.boodskap.iot.model.jpa;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class OTAModelVersionBatchMemberId extends OTAModelBatchMemberId {
	
	private static final long serialVersionUID = -4773257849915617929L;
	
	@Column(name="fromversion", length=40)
	private String fromVersion;

	public OTAModelVersionBatchMemberId() {
	}

	public OTAModelVersionBatchMemberId(String domainKey, String batchId, String fromModel, String fromVersion, String deviceId) {
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
		OTAModelVersionBatchMemberId other = (OTAModelVersionBatchMemberId) obj;
		if (fromVersion == null) {
			if (other.fromVersion != null)
				return false;
		} else if (!fromVersion.equals(other.fromVersion))
			return false;
		return true;
	}

}
