package io.boodskap.iot.model.pojo;

import io.boodskap.iot.model.IDomainFile;
import io.boodskap.iot.model.IFileContent;

public class DomainFile extends AbstractFile implements IDomainFile {

	private static final long serialVersionUID = 2870135106880529907L;
	
	private String domainKey;
	private String fileId;

	public DomainFile() {
	}

	public DomainFile(String domainKey, String fileId) {
		super();
		this.domainKey = domainKey;
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
		DomainFile other = (DomainFile) obj;
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
		return true;
	}

}
