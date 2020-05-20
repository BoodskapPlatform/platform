package io.boodskap.iot.model.pojo;

import io.boodskap.iot.model.IEntityFile;
import io.boodskap.iot.model.IFileContent;

public class EntityFile extends AbstractFile implements IEntityFile {

	private static final long serialVersionUID = -6219447926450733949L;
	
	private String domainKey;
	private String entityId;
	private String fileId;
	
	public EntityFile() {
	}
	
	public EntityFile(String domainKey, String entityId, String fileId) {
		super();
		this.domainKey = domainKey;
		this.entityId = entityId;
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

	public String getEntityId() {
		return entityId;
	}

	public void setEntityId(String entityId) {
		this.entityId = entityId;
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
		result = prime * result + ((entityId == null) ? 0 : entityId.hashCode());
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
		EntityFile other = (EntityFile) obj;
		if (domainKey == null) {
			if (other.domainKey != null)
				return false;
		} else if (!domainKey.equals(other.domainKey))
			return false;
		if (entityId == null) {
			if (other.entityId != null)
				return false;
		} else if (!entityId.equals(other.entityId))
			return false;
		if (fileId == null) {
			if (other.fileId != null)
				return false;
		} else if (!fileId.equals(other.fileId))
			return false;
		return true;
	}

}
