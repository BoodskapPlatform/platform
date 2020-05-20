package io.boodskap.iot.model.pojo;

import io.boodskap.iot.KeyGenerator;
import io.boodskap.iot.model.IDomainApiKey;

public class DomainApiKey implements IDomainApiKey{

	private static final long serialVersionUID = -7862597406283328282L;
	
	private String domainKey;
	private String apiKey;
	
	public DomainApiKey(){
		this(KeyGenerator.newDomainKey(), KeyGenerator.newApiKey());
	}

	public DomainApiKey(String domainKey, String apiKey) {
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
		DomainApiKey other = (DomainApiKey) obj;
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
