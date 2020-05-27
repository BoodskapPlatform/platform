package io.boodskap.iot.model.jpa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import io.boodskap.iot.SizeConstants;


@Embeddable
public class DomainApiKeyId implements Serializable {
	
	private static final long serialVersionUID = 3438730471808660999L;

	@Column(name="domainkey", length=SizeConstants.DOMAIN_SIZE)
	private String domainKey;

	@Column(name="apikey", length=SizeConstants.API_KEY_SIZE)
	private String apiKey;

	public DomainApiKeyId() {
	}

	public DomainApiKeyId(String domainKey, String apiKey) {
		this.domainKey = domainKey;
		this.apiKey = apiKey;
	}

	public String getDomainKey() {
		return domainKey;
	}

	public void setDomainKey(String domainKey) {
		this.domainKey = domainKey;
	}

	public String getApiKey() {
		return apiKey;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apiKey == null) ? 0 : apiKey.hashCode());
		result = prime * result + ((domainKey == null) ? 0 : domainKey.hashCode());
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
		DomainApiKeyId other = (DomainApiKeyId) obj;
		if (apiKey == null) {
			if (other.apiKey != null)
				return false;
		} else if (!apiKey.equals(other.apiKey))
			return false;
		if (domainKey == null) {
			if (other.domainKey != null)
				return false;
		} else if (!domainKey.equals(other.domainKey))
			return false;
		return true;
	}

}
