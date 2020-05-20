package io.boodskap.iot.model.pojo;

import io.boodskap.iot.model.IFileContent;
import io.boodskap.iot.model.IOrganizationFile;

public class OrganizationFile extends AbstractFile implements IOrganizationFile {

	private static final long serialVersionUID = -4764732675817632874L;

	private String domainKey;
	private String orgId;
	private String fileId;
	
	public OrganizationFile() {
	}

	public OrganizationFile(String domainKey, String orgId, String fileId) {
		this.domainKey = domainKey;
		this.orgId = orgId;
		this.fileId = fileId;
	}

	@Override
	public IFileContent createContent() {
		return new FileContent(getData(), getMediaType());
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

	public String getFileId() {
		return fileId;
	}

	public void setFileId(String fileId) {
		this.fileId = fileId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((domainKey == null) ? 0 : domainKey.hashCode());
		result = prime * result + ((fileId == null) ? 0 : fileId.hashCode());
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
		OrganizationFile other = (OrganizationFile) obj;
		if (domainKey == null) {
			if (other.domainKey != null)
				return false;
		} else if (!domainKey.equals(other.domainKey))
			return false;
		if (fileId == null) {
			if (other.fileId != null)
				return false;
		} else if (!fileId.equals(other.fileId))
			return false;
		if (orgId == null) {
			if (other.orgId != null)
				return false;
		} else if (!orgId.equals(other.orgId))
			return false;
		return true;
	}

}
