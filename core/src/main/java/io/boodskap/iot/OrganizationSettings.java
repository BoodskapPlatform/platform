package io.boodskap.iot;

public class OrganizationSettings extends DomainSettings {

	private static final long serialVersionUID = 8943798256639438922L;
	
	private String organizationId;
	
	public OrganizationSettings() {
	}

	public String getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(String organizationId) {
		this.organizationId = organizationId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((organizationId == null) ? 0 : organizationId.hashCode());
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
		OrganizationSettings other = (OrganizationSettings) obj;
		if (organizationId == null) {
			if (other.organizationId != null)
				return false;
		} else if (!organizationId.equals(other.organizationId))
			return false;
		return true;
	}

}
