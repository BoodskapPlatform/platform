package io.boodskap.iot.model.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.boodskap.iot.SizeConstants;
import io.boodskap.iot.model.IDomain;
import io.boodskap.iot.model.IDomainRole;

@Entity
@Table(name="domain")
public class Domain extends AbstractContact implements IDomain {

	private static final long serialVersionUID = 6658928306824558407L;

	@Id
	@Column(name="domainkey", length=SizeConstants.DOMAIN_SIZE)
	private String domainKey = null;
	
	public Domain() {
	}
	
	public Domain(String domainKey) {
		this.domainKey = domainKey;
	}

	@Override
	public IDomainRole createRole(String name, String description) {
		DomainRole role = new DomainRole(new DomainRoleId(getDomainKey(), name));
		role.setDescription(description);
		return role;
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
