package io.boodskap.iot.model.jpa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class BillingScheduleId implements Serializable {
	
	private static final long serialVersionUID = 5336079635787227500L;

	@Column(name="domainkey", length=16)
	private String domainKey;

	@Column(name="targetDomain", length=16)
	private String targetDomain;

	@Column(name="scheduleid", length=40)
	private String scheduleId;

	public BillingScheduleId() {
	}

	public BillingScheduleId(String domainKey, String targetDomain, String scheduleId) {
		super();
		this.domainKey = domainKey;
		this.targetDomain = targetDomain;
		this.scheduleId = scheduleId;
	}

	public String getDomainKey() {
		return domainKey;
	}

	public void setDomainKey(String domainKey) {
		this.domainKey = domainKey;
	}

	public String getTargetDomain() {
		return targetDomain;
	}

	public void setTargetDomain(String targetDomain) {
		this.targetDomain = targetDomain;
	}

	public String getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(String scheduleId) {
		this.scheduleId = scheduleId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((domainKey == null) ? 0 : domainKey.hashCode());
		result = prime * result + ((scheduleId == null) ? 0 : scheduleId.hashCode());
		result = prime * result + ((targetDomain == null) ? 0 : targetDomain.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BillingScheduleId other = (BillingScheduleId) obj;
		if (domainKey == null) {
			if (other.domainKey != null)
				return false;
		} else if (!domainKey.equals(other.domainKey))
			return false;
		if (scheduleId == null) {
			if (other.scheduleId != null)
				return false;
		} else if (!scheduleId.equals(other.scheduleId))
			return false;
		if (targetDomain == null) {
			if (other.targetDomain != null)
				return false;
		} else if (!targetDomain.equals(other.targetDomain))
			return false;
		return true;
	}

}
