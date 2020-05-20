package io.boodskap.iot.model.jpa;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import io.boodskap.iot.model.IFileContent;
import io.boodskap.iot.model.IPublicFile;

@Entity
@Table(name="publicfile")
public class PublicFile extends AbstractFile implements IPublicFile {

	private static final long serialVersionUID = -8400532640153605579L;
	
	@EmbeddedId
	private PublicFileId id = new PublicFileId();
	
	public PublicFile() {
	}

	public PublicFile(PublicFileId id) {
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
		PublicFile other = (PublicFile) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
