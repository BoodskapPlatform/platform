package io.boodskap.iot.model.jpa;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class OTAModelBatchMemberId extends OTABatchId {
	
	private static final long serialVersionUID = -6044951106961229232L;
	
	@Column(name="frommodel", length=40)
	private String fromModel;

	@Column(name="deviceid", length=40)
	private String deviceId;

	public OTAModelBatchMemberId() {
	}

	public OTAModelBatchMemberId(String domainKey, String batchId, String fromModel, String deviceId) {
		super(domainKey, batchId);
		this.fromModel = fromModel;
		this.deviceId = deviceId;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
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
		result = prime * result + ((deviceId == null) ? 0 : deviceId.hashCode());
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
		OTAModelBatchMemberId other = (OTAModelBatchMemberId) obj;
		if (deviceId == null) {
			if (other.deviceId != null)
				return false;
		} else if (!deviceId.equals(other.deviceId))
			return false;
		if (fromModel == null) {
			if (other.fromModel != null)
				return false;
		} else if (!fromModel.equals(other.fromModel))
			return false;
		return true;
	}

}
