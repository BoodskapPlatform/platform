package io.boodskap.iot.model.jpa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class BillingContactId implements Serializable {
	
	private static final long serialVersionUID = 7548483033858215448L;

	@Column(name="domainkey", length=16)
	private String domainKey;

	@Column(name="targetdomain", length=16)
	private String targetDomain;

	@Column(name="contactid", length=40)
	private String contactId;

	public BillingContactId() {
	}

	public BillingContactId(String domainKey, String targetDomain, String contactId) {
		super();
		this.domainKey = domainKey;
		this.targetDomain = targetDomain;
		this.contactId = contactId;
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

	public String getContactId() {
		return contactId;
	}

	public void setContactId(String contactId) {
		this.contactId = contactId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contactId == null) ? 0 : contactId.hashCode());
		result = prime * result + ((domainKey == null) ? 0 : domainKey.hashCode());
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
		BillingContactId other = (BillingContactId) obj;
		if (contactId == null) {
			if (other.contactId != null)
				return false;
		} else if (!contactId.equals(other.contactId))
			return false;
		if (domainKey == null) {
			if (other.domainKey != null)
				return false;
		} else if (!domainKey.equals(other.domainKey))
			return false;
		if (targetDomain == null) {
			if (other.targetDomain != null)
				return false;
		} else if (!targetDomain.equals(other.targetDomain))
			return false;
		return true;
	}

}
