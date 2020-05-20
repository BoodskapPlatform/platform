package io.boodskap.iot.model.pojo;

import java.util.Date;

import io.boodskap.iot.Access;
import io.boodskap.iot.model.IDomainAccess;

public class DomainAccess implements IDomainAccess{
	
	private static final long serialVersionUID = 2132595065163612936L;
	
	private String domainKey;
	private Access access;
	
	private Date grantedStamp;

	public DomainAccess() {
	}

	public String getDomainKey() {
		return domainKey;
	}

	public void setDomainKey(String domainKey) {
		this.domainKey = domainKey;
	}

	public Access getAccess() {
		return access;
	}

	public void setAccess(Access access) {
		this.access = access;
	}

	public Date getGrantedStamp() {
		return grantedStamp;
	}

	public void setGrantedStamp(Date grantedStamp) {
		this.grantedStamp = grantedStamp;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((access == null) ? 0 : access.hashCode());
		result = prime * result + ((domainKey == null) ? 0 : domainKey.hashCode());
		result = prime * result + ((grantedStamp == null) ? 0 : grantedStamp.hashCode());
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
		DomainAccess other = (DomainAccess) obj;
		if (access != other.access)
			return false;
		if (domainKey == null) {
			if (other.domainKey != null)
				return false;
		} else if (!domainKey.equals(other.domainKey))
			return false;
		if (grantedStamp == null) {
			if (other.grantedStamp != null)
				return false;
		} else if (!grantedStamp.equals(other.grantedStamp))
			return false;
		return true;
	}

}
