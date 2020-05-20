package io.boodskap.iot.model.jpa;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import io.boodskap.iot.SizeConstants;
import io.boodskap.iot.model.IOrganizationRole;

@Entity
@Table(name="organizationrole")
public class OrganizationRole implements IOrganizationRole {
	
	private static final long serialVersionUID = -1713165327685347649L;
	
	@EmbeddedId
	private OrganizationRoleId id = new OrganizationRoleId();

	@Column(name="description", length=SizeConstants.DESCRIPTION_SIZE)
	private String description = null;
	
	public OrganizationRole() {
	}

	public OrganizationRole(OrganizationRoleId id) {
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

	public String getName() {
		return id.getName();
	}

	public void setName(String name) {
		id.setName(name);
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
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
		OrganizationRole other = (OrganizationRole) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
