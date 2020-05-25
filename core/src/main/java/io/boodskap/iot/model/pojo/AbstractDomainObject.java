package io.boodskap.iot.model.pojo;

import io.boodskap.iot.model.IDomainObject;

public abstract class AbstractDomainObject extends AbstractModel implements IDomainObject {

	private static final long serialVersionUID = -894502928008187137L;
	
	private String domainKey;
	
	public AbstractDomainObject() {
	}

	@Override
	public String getDomainKey() {
		return domainKey;
	}

	@Override
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
		AbstractDomainObject other = (AbstractDomainObject) obj;
		if (domainKey == null) {
			if (other.domainKey != null)
				return false;
		} else if (!domainKey.equals(other.domainKey))
			return false;
		return true;
	}

}
