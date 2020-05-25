package io.boodskap.iot.model.pojo;


import io.boodskap.iot.model.IOTAModelBatch;

public class OTAModelBatch extends OTABatch implements IOTAModelBatch{

	private static final long serialVersionUID = 2203720313357591826L;

	private String fromModel;

	public OTAModelBatch() {
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
		OTAModelBatch other = (OTAModelBatch) obj;
		if (fromModel == null) {
			if (other.fromModel != null)
				return false;
		} else if (!fromModel.equals(other.fromModel))
			return false;
		return true;
	}

}
