package io.boodskap.iot.model.pojo;

import io.boodskap.iot.KeyGenerator;
import io.boodskap.iot.model.IDomainApiKey;

public class DomainApiKey extends AbstractDomainObject implements IDomainApiKey{

	private static final long serialVersionUID = -7862597406283328282L;
	
	private String apiKey;
	
	public DomainApiKey(){
		this(KeyGenerator.newDomainKey(), KeyGenerator.newApiKey());
	}

	public DomainApiKey(String domainKey, String apiKey) {
		setDomainKey(domainKey);
		this.apiKey = apiKey;
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
		int result = super.hashCode();
		result = prime * result + ((apiKey == null) ? 0 : apiKey.hashCode());
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
		DomainApiKey other = (DomainApiKey) obj;
		if (apiKey == null) {
			if (other.apiKey != null)
				return false;
		} else if (!apiKey.equals(other.apiKey))
			return false;
		return true;
	}

}
