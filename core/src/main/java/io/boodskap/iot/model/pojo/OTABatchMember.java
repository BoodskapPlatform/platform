package io.boodskap.iot.model.pojo;

import java.util.Date;

import io.boodskap.iot.OTAState;
import io.boodskap.iot.model.IOTABatchMember;

public class OTABatchMember extends AbstractDomainObject implements IOTABatchMember {

	private static final long serialVersionUID = -2659199477681084734L;

	private String deviceId;
	private String batchId;
	private OTAState state;
	private Date beginStamp;
	private Date endStamp;
	private int failureCount;
	
	public OTABatchMember() {
	}

	public OTAState getState() {
		return state;
	}

	@Override
	public void setState(OTAState state) {
		this.state = state;
	}

	@Override
	public Date getBeginStamp() {
		return beginStamp;
	}

	@Override
	public void setBeginStamp(Date beginStamp) {
		this.beginStamp = beginStamp;
	}

	@Override
	public Date getEndStamp() {
		return endStamp;
	}

	@Override
	public void setEndStamp(Date endStamp) {
		this.endStamp = endStamp;
	}

	@Override
	public int getFailureCount() {
		return failureCount;
	}

	@Override
	public void setFailureCount(int failureCount) {
		this.failureCount = failureCount;
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
	public String getDeviceId() {
		return deviceId;
	}

	@Override
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((batchId == null) ? 0 : batchId.hashCode());
		result = prime * result + ((beginStamp == null) ? 0 : beginStamp.hashCode());
		result = prime * result + ((deviceId == null) ? 0 : deviceId.hashCode());
		result = prime * result + ((endStamp == null) ? 0 : endStamp.hashCode());
		result = prime * result + failureCount;
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
		OTABatchMember other = (OTABatchMember) obj;
		if (batchId == null) {
			if (other.batchId != null)
				return false;
		} else if (!batchId.equals(other.batchId))
			return false;
		if (beginStamp == null) {
			if (other.beginStamp != null)
				return false;
		} else if (!beginStamp.equals(other.beginStamp))
			return false;
		if (deviceId == null) {
			if (other.deviceId != null)
				return false;
		} else if (!deviceId.equals(other.deviceId))
			return false;
		if (endStamp == null) {
			if (other.endStamp != null)
				return false;
		} else if (!endStamp.equals(other.endStamp))
			return false;
		if (failureCount != other.failureCount)
			return false;
		if (state != other.state)
			return false;
		return true;
	}

}
