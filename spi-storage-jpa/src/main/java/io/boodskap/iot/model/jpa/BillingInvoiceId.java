package io.boodskap.iot.model.jpa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class BillingInvoiceId implements Serializable {
	
	private static final long serialVersionUID = 969038864157569007L;

	@Column(name="domainkey", length=16)
	private String domainKey;

	@Column(name="targetDomain", length=16)
	private String targetDomain;

	@Column(name="invoiceid", length=40)
	private String invoiceId;

	public BillingInvoiceId() {
	}

	public BillingInvoiceId(String domainKey, String targetDomain, String invoiceId) {
		super();
		this.domainKey = domainKey;
		this.targetDomain = targetDomain;
		this.invoiceId = invoiceId;
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

	public String getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(String invoiceId) {
		this.invoiceId = invoiceId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((domainKey == null) ? 0 : domainKey.hashCode());
		result = prime * result + ((invoiceId == null) ? 0 : invoiceId.hashCode());
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
		BillingInvoiceId other = (BillingInvoiceId) obj;
		if (domainKey == null) {
			if (other.domainKey != null)
				return false;
		} else if (!domainKey.equals(other.domainKey))
			return false;
		if (invoiceId == null) {
			if (other.invoiceId != null)
				return false;
		} else if (!invoiceId.equals(other.invoiceId))
			return false;
		if (targetDomain == null) {
			if (other.targetDomain != null)
				return false;
		} else if (!targetDomain.equals(other.targetDomain))
			return false;
		return true;
	}

}
