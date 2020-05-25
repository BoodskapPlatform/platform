package io.boodskap.iot.model.pojo;

import java.util.Date;

import io.boodskap.iot.OTABatchState;
import io.boodskap.iot.model.IOTABatch;

public class OTABatch extends AbstractDomainObject implements IOTABatch {

	private static final long serialVersionUID = 4612047731177937664L;

	private String batchId;
	private OTABatchState state;
	private String firmwareModel;
	private String firmwareVersion;
	private Date expireAt;
	private Date finishedAt;

	public OTABatch() {
	}

	@Override
	public OTABatchState getState() {
		return state;
	}

	@Override
	public void setState(OTABatchState state) {
		this.state = state;
	}

	@Override
	public String getFirmwareModel() {
		return firmwareModel;
	}

	@Override
	public void setFirmwareModel(String firmwareModel) {
		this.firmwareModel = firmwareModel;
	}

	@Override
	public String getFirmwareVersion() {
		return firmwareVersion;
	}

	@Override
	public void setFirmwareVersion(String firmwareVersion) {
		this.firmwareVersion = firmwareVersion;
	}

	@Override
	public Date getExpireAt() {
		return expireAt;
	}

	@Override
	public void setExpireAt(Date expireAt) {
		this.expireAt = expireAt;
	}

	@Override
	public Date getFinishedAt() {
		return finishedAt;
	}

	@Override
	public void setFinishedAt(Date finishedAt) {
		this.finishedAt = finishedAt;
	}

	@Override
	public String getBatchId() {
		return batchId;
	}

	@Override
	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((batchId == null) ? 0 : batchId.hashCode());
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
		OTABatch other = (OTABatch) obj;
		if (batchId == null) {
			if (other.batchId != null)
				return false;
		} else if (!batchId.equals(other.batchId))
			return false;
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
