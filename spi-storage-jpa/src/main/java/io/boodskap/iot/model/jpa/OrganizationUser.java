package io.boodskap.iot.model.jpa;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import io.boodskap.iot.model.IOrganizationUser;
import io.boodskap.iot.model.IOrganizationUserRole;

@Entity
@Table(name="organizationuser")
public class OrganizationUser implements IOrganizationUser {
	
	private static final long serialVersionUID = -2018718809063224007L;
	
	@EmbeddedId
	private OrganizationUserId id = new OrganizationUserId();

	@Column(name="createdstamp")
	private Date createdStamp;
	
	@Column(name="updatedstamp")
	private Date updatedStamp;
	
	public OrganizationUser() {
	}

	public OrganizationUser(OrganizationUserId id) {
		this.id = id;
	}

	@Override
	public IOrganizationUserRole createRole(String name, String description) {
		OrganizationUserRole role = new OrganizationUserRole(new OrganizationUserRoleId(getDomainKey(), getOrgId(), getUserId(), name));
		role.setDescription(description);
		return null;
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

	public Date getCreatedStamp() {
		return createdStamp;
	}

	public void setCreatedStamp(Date createdStamp) {
		this.createdStamp = createdStamp;
	}

	public Date getUpdatedStamp() {
		return updatedStamp;
	}

	public void setUpdatedStamp(Date updatedStamp) {
		this.updatedStamp = updatedStamp;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createdStamp == null) ? 0 : createdStamp.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((updatedStamp == null) ? 0 : updatedStamp.hashCode());
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
		OrganizationUser other = (OrganizationUser) obj;
		if (createdStamp == null) {
			if (other.createdStamp != null)
				return false;
		} else if (!createdStamp.equals(other.createdStamp))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (updatedStamp == null) {
			if (other.updatedStamp != null)
				return false;
		} else if (!updatedStamp.equals(other.updatedStamp))
			return false;
		return true;
	}

}
