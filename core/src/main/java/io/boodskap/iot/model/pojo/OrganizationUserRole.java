package io.boodskap.iot.model.pojo;


import io.boodskap.iot.model.IOrganizationUserRole;

public class OrganizationUserRole extends UserRole implements IOrganizationUserRole {

	private static final long serialVersionUID = -477775749934987676L;

	private String orgId;
	
	public OrganizationUserRole() {
	}

	public OrganizationUserRole(String domainKey, String orgId, String userId, String name, String description) {
		setDomainKey(domainKey);
		this.orgId = orgId;
		setUserId(userId);
		setName(name);
		setDescription(description);
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((orgId == null) ? 0 : orgId.hashCode());
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
		OrganizationUserRole other = (OrganizationUserRole) obj;
		if (orgId == null) {
			if (other.orgId != null)
				return false;
		} else if (!orgId.equals(other.orgId))
			return false;
		return true;
	}

}
