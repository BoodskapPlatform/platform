package io.boodskap.iot.model.jpa;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class OTAModelBatchId extends OTABatchId {
	
	private static final long serialVersionUID = -9167304850347572075L;
	
	@Column(name="frommodel", length=40)
	private String fromModel;

	public OTAModelBatchId() {
	}

	public OTAModelBatchId(String domainKey, String batchId, String fromModel) {
		super(domainKey, batchId);
		this.fromModel = fromModel;
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
		OTAModelBatchId other = (OTAModelBatchId) obj;
		if (fromModel == null) {
			if (other.fromModel != null)
				return false;
		} else if (!fromModel.equals(other.fromModel))
			return false;
		return true;
	}

}
