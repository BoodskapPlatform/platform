package io.boodskap.iot.model.jpa;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import io.boodskap.iot.KeyGenerator;
import io.boodskap.iot.model.IDomainApiKey;

@Entity
@Table(name="domainapikey")
public class DomainApiKey extends AbstractModel implements IDomainApiKey{

	private static final long serialVersionUID = -7862597406283328282L;
	
	@EmbeddedId
	private DomainApiKeyId id = new DomainApiKeyId();
	
	public DomainApiKey(){
		this(new DomainApiKeyId(KeyGenerator.newDomainKey(), KeyGenerator.newApiKey()));
	}

	public DomainApiKey(DomainApiKeyId id) {
		this.id = id;
	}

	public String getDomainKey() {
		return id.getDomainKey();
	}

	public void setDomainKey(String domainKey) {
		id.setDomainKey(domainKey);
	}

	public String getApiKey() {
		return id.getApiKey();
	}

	public void setApiKey(String apiKey) {
		id.setApiKey(apiKey);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
