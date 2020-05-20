package io.boodskap.iot.model.jpa;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import io.boodskap.iot.Access;
import io.boodskap.iot.model.IDomainAccess;

@Entity
@Table(name="domainaccess")
public class DomainAccess implements IDomainAccess{
	
	private static final long serialVersionUID = 2132595065163612936L;
	
	@EmbeddedId
	private DomainAccessId id = new DomainAccessId();
	
	@Column(name="grantedstamp")
	private Date grantedStamp;

	public DomainAccess() {
	}

	public DomainAccess(DomainAccessId id) {
		this.id = id;
	}

	public String getDomainKey() {
		return id.getDomainKey();
	}

	public void setDomainKey(String domainKey) {
		id.setDomainKey(domainKey);
	}

	public Access getAccess() {
		return id.getAccess();
	}

	public void setAccess(Access access) {
		id.setAccess(access);
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
		result = prime * result + ((grantedStamp == null) ? 0 : grantedStamp.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		if (grantedStamp == null) {
			if (other.grantedStamp != null)
				return false;
		} else if (!grantedStamp.equals(other.grantedStamp))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
