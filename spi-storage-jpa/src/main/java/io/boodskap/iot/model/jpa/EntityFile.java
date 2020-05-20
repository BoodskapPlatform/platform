package io.boodskap.iot.model.jpa;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import io.boodskap.iot.model.IEntityFile;
import io.boodskap.iot.model.IFileContent;

@Entity
@Table(name="entityfile")
public class EntityFile extends AbstractFile implements IEntityFile {

	private static final long serialVersionUID = -6219447926450733949L;
	
	@EmbeddedId
	private EntityFileId id = new EntityFileId();
	
	public EntityFile() {
	}

	@Override
	public IFileContent createContent() {
		return new FileContent(getData(), getMediaType());
	}

	public EntityFile(EntityFileId id) {
		this.id = id;
	}

	public String getDomainKey() {
		return id.getDomainKey();
	}

	public void setDomainKey(String domainKey) {
		id.setDomainKey(domainKey);
	}

	public String getEntityId() {
		return id.getEntityId();
	}

	public void setEntityId(String entityId) {
		id.setEntityId(entityId);
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
		EntityFile other = (EntityFile) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
