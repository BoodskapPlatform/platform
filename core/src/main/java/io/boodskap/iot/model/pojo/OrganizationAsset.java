package io.boodskap.iot.model.pojo;

import io.boodskap.iot.model.IOrganizationAsset;

public class OrganizationAsset extends Asset implements IOrganizationAsset{

	private static final long serialVersionUID = 3338851097866982254L;
	
	private String orgId;
	
	public OrganizationAsset() {
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
		OrganizationAsset other = (OrganizationAsset) obj;
		if (orgId == null) {
			if (other.orgId != null)
				return false;
		} else if (!orgId.equals(other.orgId))
			return false;
		return true;
	}

}
