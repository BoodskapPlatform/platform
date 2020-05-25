package io.boodskap.iot.model.pojo;


import io.boodskap.iot.model.IOTAModelVersionBatchMember;

public class OTAModelVersionBatchMember extends OTADeviceBatchMember implements IOTAModelVersionBatchMember{

	private static final long serialVersionUID = -6575349718275027958L;
	
	private String fromModel;
	private String fromVersion;

	public OTAModelVersionBatchMember() {
		super();
	}

	@Override
	public String getFromModel() {
		return fromModel;
	}

	@Override
	public void setFromModel(String fromModel) {
		this.fromModel = fromModel;
	}

	@Override
	public String getFromVersion() {
		return fromVersion;
	}

	@Override
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
		OTAModelVersionBatchMember other = (OTAModelVersionBatchMember) obj;
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
