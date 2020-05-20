package io.boodskap.iot.model.jpa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class LinkedDomainId implements Serializable {

	private static final long serialVersionUID = 8706851528406437320L;
	
	@Column(name="domainkey", length=16)
	private String domainKey;
	
	@Column(name="linkeddomainkey", length=16)
	private String linkedDomainKey;

	@Column(name="linkedapikey", length=40)
	private String linkedApiKey;
	
	public LinkedDomainId() {
	}

	public LinkedDomainId(String domainKey, String linkedDomainKey, String linkedApiKey) {
		this.domainKey = domainKey;
		this.linkedDomainKey = linkedDomainKey;
		this.linkedApiKey = linkedApiKey;
	}

	public String getDomainKey() {
		return domainKey;
	}

	public void setDomainKey(String domainKey) {
		this.domainKey = domainKey;
	}

	public String getLinkedDomainKey() {
		return linkedDomainKey;
	}

	public void setLinkedDomainKey(String linkedDomainKey) {
		this.linkedDomainKey = linkedDomainKey;
	}

	public String getLinkedApiKey() {
		return linkedApiKey;
	}

	public void setLinkedApiKey(String linkedApiKey) {
		this.linkedApiKey = linkedApiKey;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((domainKey == null) ? 0 : domainKey.hashCode());
		result = prime * result + ((linkedApiKey == null) ? 0 : linkedApiKey.hashCode());
		result = prime * result + ((linkedDomainKey == null) ? 0 : linkedDomainKey.hashCode());
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
		LinkedDomainId other = (LinkedDomainId) obj;
		if (domainKey == null) {
			if (other.domainKey != null)
				return false;
		} else if (!domainKey.equals(other.domainKey))
			return false;
		if (linkedApiKey == null) {
			if (other.linkedApiKey != null)
				return false;
		} else if (!linkedApiKey.equals(other.linkedApiKey))
			return false;
		if (linkedDomainKey == null) {
			if (other.linkedDomainKey != null)
				return false;
		} else if (!linkedDomainKey.equals(other.linkedDomainKey))
			return false;
		return true;
	}

}
