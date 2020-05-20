package io.boodskap.iot.model.jpa;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class OTAModelVersionBatchId extends OTABatchId {
	
	private static final long serialVersionUID = 4592669201793035004L;

	@Column(name="frommodel", length=40)
	private String fromModel;

	@Column(name="fromversion", length=40)
	private String fromVersion;

	public OTAModelVersionBatchId() {
	}

	public OTAModelVersionBatchId(String domainKey, String batchId, String fromModel, String fromVersion) {
		super(domainKey, batchId);
		this.fromModel = fromModel;
		this.fromVersion = fromVersion;
	}

	public String getFromModel() {
		return fromModel;
	}

	public void setFromModel(String fromModel) {
		this.fromModel = fromModel;
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
		result = prime * result + ((fromModel == null) ? 0 : fromModel.hashCode());
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
		OTAModelVersionBatchId other = (OTAModelVersionBatchId) obj;
		if (fromModel == null) {
			if (other.fromModel != null)
				return false;
		} else if (!fromModel.equals(other.fromModel))
			return false;
		if (fromVersion == null) {
			if (other.fromVersion != null)
				return false;
		} else if (!fromVersion.equals(other.fromVersion))
			return false;
		return true;
	}

}
