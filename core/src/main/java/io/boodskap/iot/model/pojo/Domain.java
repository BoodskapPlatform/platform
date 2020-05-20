package io.boodskap.iot.model.pojo;

import io.boodskap.iot.model.IDomain;
import io.boodskap.iot.model.IDomainRole;

public class Domain extends AbstractEntity implements IDomain {

	private static final long serialVersionUID = 6658928306824558407L;

	private String domainKey = null;
	
	public Domain() {
	}
	
	public Domain(String domainKey) {
		this.domainKey = domainKey;
	}

	@Override
	public IDomainRole createRole(String name, String description) {
		return new DomainRole(getDomainKey(), name, description);
	}

	public String getDomainKey() {
		return domainKey;
	}

	public void setDomainKey(String domainKey) {
		this.domainKey = domainKey;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((domainKey == null) ? 0 : domainKey.hashCode());
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
		Domain other = (Domain) obj;
		if (domainKey == null) {
			if (other.domainKey != null)
				return false;
		} else if (!domainKey.equals(other.domainKey))
			return false;
		return true;
	}

}
