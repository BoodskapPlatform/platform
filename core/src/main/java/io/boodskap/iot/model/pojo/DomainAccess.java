package io.boodskap.iot.model.pojo;

import io.boodskap.iot.Access;
import io.boodskap.iot.model.IDomainAccess;

public class DomainAccess extends AbstractDomainObject implements IDomainAccess{
	
	private static final long serialVersionUID = 2132595065163612936L;
	
	private Access access;
	
	public DomainAccess() {
	}

	public Access getAccess() {
		return access;
	}

	public void setAccess(Access access) {
		this.access = access;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((access == null) ? 0 : access.hashCode());
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
		DomainAccess other = (DomainAccess) obj;
		if (access != other.access)
			return false;
		return true;
	}

}
