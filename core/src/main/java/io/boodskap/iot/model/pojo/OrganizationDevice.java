package io.boodskap.iot.model.pojo;

import io.boodskap.iot.model.IOrganizationDevice;

public class OrganizationDevice extends Device implements IOrganizationDevice {
	
	private static final long serialVersionUID = 7312305459997876845L;
	
	private String orgId;

	public OrganizationDevice() {
		super();
	}

	public OrganizationDevice(String domainKey, String orgId, String deviceId) {
		super(domainKey, deviceId);
		setOrgId(orgId);
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
		OrganizationDevice other = (OrganizationDevice) obj;
		if (orgId == null) {
			if (other.orgId != null)
				return false;
		} else if (!orgId.equals(other.orgId))
			return false;
		return true;
	}
	
}
