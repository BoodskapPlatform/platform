package io.boodskap.iot.model.pojo;


import io.boodskap.iot.model.IOTAModelBatchMember;

public class OTAModelBatchMember extends OTADeviceBatchMember implements IOTAModelBatchMember{

	private static final long serialVersionUID = 7638112581095469565L;
	
	private String fromModel;

	public OTAModelBatchMember() {
		super();
	}

	public String getFromModel() {
		return fromModel;
	}

	public void setFromModel(String fromModel) {
		this.fromModel = fromModel;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((fromModel == null) ? 0 : fromModel.hashCode());
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
		if (fromModel == null) {
			if (other.fromModel != null)
				return false;
		} else if (!fromModel.equals(other.fromModel))
			return false;
		return true;
	}

}
