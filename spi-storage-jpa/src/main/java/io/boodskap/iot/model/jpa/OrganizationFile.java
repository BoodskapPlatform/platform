package io.boodskap.iot.model.jpa;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import io.boodskap.iot.model.IFileContent;
import io.boodskap.iot.model.IOrganizationFile;

@Entity
@Table(name="organizationfile")
public class OrganizationFile extends AbstractFile implements IOrganizationFile {

	private static final long serialVersionUID = -4764732675817632874L;
	
	@EmbeddedId
	private OrganizationFileId id = new OrganizationFileId();
	
	public OrganizationFile() {
	}

	public OrganizationFile(OrganizationFileId id) {
		this.id = id;
	}

	@Override
	public IFileContent createContent() {
		return new FileContent(getData(), getMediaType());
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

	public String getFileId() {
		return id.getFileId();
	}

	public void setFileId(String fileId) {
		id.setFileId(fileId);
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
		OrganizationFile other = (OrganizationFile) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
