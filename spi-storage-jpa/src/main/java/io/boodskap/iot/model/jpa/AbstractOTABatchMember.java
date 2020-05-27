package io.boodskap.iot.model.jpa;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;

import io.boodskap.iot.OTAState;
import io.boodskap.iot.model.IOTABatchMember;

@MappedSuperclass
public abstract class AbstractOTABatchMember extends AbstractModel implements IOTABatchMember {

	private static final long serialVersionUID = -2659199477681084734L;

	@Column(name="state", length=12)
	@Enumerated(EnumType.STRING)
	private OTAState state;
	
	@Column(name="beginstamp")
	private Date beginStamp;
	
	@Column(name="endstamp")
	private Date endStamp;
	
	@Column(name="failurecount")
	private int failureCount;

	public AbstractOTABatchMember() {
	}

	public OTAState getState() {
		return state;
	}

	public void setState(OTAState state) {
		this.state = state;
	}

	public Date getBeginStamp() {
		return beginStamp;
	}

	public void setBeginStamp(Date beginStamp) {
		this.beginStamp = beginStamp;
	}

	public Date getEndStamp() {
		return endStamp;
	}

	public void setEndStamp(Date endStamp) {
		this.endStamp = endStamp;
	}

	public int getFailureCount() {
		return failureCount;
	}

	public void setFailureCount(int failureCount) {
		this.failureCount = failureCount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((beginStamp == null) ? 0 : beginStamp.hashCode());
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
		AbstractOTABatchMember other = (AbstractOTABatchMember) obj;
		if (beginStamp == null) {
			if (other.beginStamp != null)
				return false;
		} else if (!beginStamp.equals(other.beginStamp))
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
