package io.boodskap.iot.model.pojo;

import io.boodskap.iot.model.IOrganizationUser;

public class OrganizationUser extends User implements IOrganizationUser {
	
	private static final long serialVersionUID = -2018718809063224007L;
	
	private String orgId;
	
	public OrganizationUser() {
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

}
