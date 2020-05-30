package io.boodskap.iot.model.jpa;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import io.boodskap.iot.model.IOrganizationUser;

@Entity
@Table(name="organizationuser")
public class OrganizationUser extends AbstractPerson implements IOrganizationUser {
	
	private static final long serialVersionUID = -2018718809063224007L;
	
	@EmbeddedId
	private OrganizationUserId id = new OrganizationUserId();

	public OrganizationUser() {
	}

	public OrganizationUser(OrganizationUserId id) {
		this.id = id;
	}

	public String getDomainKey() {
		return id.getDomainKey();
	}

	public void setDomainKey(String domainKey) {
		id.setDomainKey(domainKey);
	}

	public String getOrgId() {
		return id.getOrgId();
	}

	public void setOrgId(String orgId) {
		id.setOrgId(orgId);
	}

	public String getUserId() {
		return id.getUserId();
	}

	public void setUserId(String userId) {
		id.setUserId(userId);
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
		OrganizationUser other = (OrganizationUser) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
