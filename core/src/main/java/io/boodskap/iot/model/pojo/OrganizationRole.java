package io.boodskap.iot.model.pojo;


import io.boodskap.iot.model.IOrganizationRole;

public class OrganizationRole implements IOrganizationRole {
	
	private static final long serialVersionUID = -1713165327685347649L;
	
	private String domainKey;
	private String orgId;
	private String name;
	private String description = null;
	
	public OrganizationRole() {
	}

	public OrganizationRole(String domainKey, String orgId, String name) {
		this.domainKey = domainKey;
		this.orgId = orgId;
		this.name = name;
	}

	public String getDomainKey() {
		return domainKey;
	}

	public void setDomainKey(String domainKey) {
		this.domainKey = domainKey;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
