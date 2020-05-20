package io.boodskap.iot.model.jpa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import io.boodskap.iot.Access;


@Embeddable
public class DomainAccessId implements Serializable {
	
	private static final long serialVersionUID = 7696058500989319009L;

	@Column(name="domainkey", length=16)
	private String domainKey;

	@Column(name="access", length=12)
	@Enumerated(EnumType.STRING)
	private Access access;

	public DomainAccessId() {
	}

	public DomainAccessId(String domainKey, Access access) {
		this.domainKey = domainKey;
		this.access = access;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((access == null) ? 0 : access.hashCode());
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
		DomainAccessId other = (DomainAccessId) obj;
		if (access != other.access)
			return false;
		if (domainKey == null) {
			if (other.domainKey != null)
				return false;
		} else if (!domainKey.equals(other.domainKey))
			return false;
		return true;
	}

}
