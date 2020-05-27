package io.boodskap.iot.model.jpa;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;

import io.boodskap.iot.OTABatchState;
import io.boodskap.iot.model.IOTABatch;

@MappedSuperclass
public abstract class AbstractOTABatch extends AbstractModel implements IOTABatch {

	private static final long serialVersionUID = 4612047731177937664L;

	@Column(name="state", length=12)
	@Enumerated(EnumType.STRING)
	private OTABatchState state;
	
	@Column(name="fwmodel")
	private String firmwareModel;
	
	@Column(name="fwversion")
	private String firmwareVersion;
	
	@Column(name="expireat")
	private Date expireAt;
	
	@Column(name="finishedat")
	private Date finishedAt;

	public AbstractOTABatch() {
	}

	public OTABatchState getState() {
		return state;
	}

	public void setState(OTABatchState state) {
		this.state = state;
	}

	public String getFirmwareModel() {
		return firmwareModel;
	}

	public void setFirmwareModel(String firmwareModel) {
		this.firmwareModel = firmwareModel;
	}

	public String getFirmwareVersion() {
		return firmwareVersion;
	}

	public void setFirmwareVersion(String firmwareVersion) {
		this.firmwareVersion = firmwareVersion;
	}

	public Date getExpireAt() {
		return expireAt;
	}

	public void setExpireAt(Date expireAt) {
		this.expireAt = expireAt;
	}

	public Date getFinishedAt() {
		return finishedAt;
	}

	public void setFinishedAt(Date finishedAt) {
		this.finishedAt = finishedAt;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((expireAt == null) ? 0 : expireAt.hashCode());
		result = prime * result + ((finishedAt == null) ? 0 : finishedAt.hashCode());
		result = prime * result + ((firmwareModel == null) ? 0 : firmwareModel.hashCode());
		result = prime * result + ((firmwareVersion == null) ? 0 : firmwareVersion.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
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
		AbstractOTABatch other = (AbstractOTABatch) obj;
		if (expireAt == null) {
			if (other.expireAt != null)
				return false;
		} else if (!expireAt.equals(other.expireAt))
			return false;
		if (finishedAt == null) {
			if (other.finishedAt != null)
				return false;
		} else if (!finishedAt.equals(other.finishedAt))
			return false;
		if (firmwareModel == null) {
			if (other.firmwareModel != null)
				return false;
		} else if (!firmwareModel.equals(other.firmwareModel))
			return false;
		if (firmwareVersion == null) {
			if (other.firmwareVersion != null)
				return false;
		} else if (!firmwareVersion.equals(other.firmwareVersion))
			return false;
		if (state != other.state)
			return false;
		return true;
	}

}
