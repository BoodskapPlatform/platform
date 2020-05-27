package io.boodskap.iot.model.jpa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import io.boodskap.iot.SizeConstants;


@Embeddable
public class EntityFileId implements Serializable {
	
	private static final long serialVersionUID = -5360716309551563563L;

	@Column(name="domainkey", length=SizeConstants.DOMAIN_SIZE)
	private String domainKey;
	
	@Column(name="entitytype", length=SizeConstants.ID_SIZE)
	private String entityType;

	@Column(name="entityid", length=SizeConstants.ID_SIZE)
	private String entityId;

	@Column(name="fileid", length=SizeConstants.ID_SIZE)
	private String fileId;

	public EntityFileId() {
	}

	public EntityFileId(String domainKey, String entityType, String entityId, String fileId) {
		this.domainKey = domainKey;
		this.entityType = entityType;
		this.entityId = entityId;
		this.fileId = fileId;
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

	public String getEntityType() {
		return entityType;
	}

	public void setEntityType(String entityType) {
		this.entityType = entityType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((domainKey == null) ? 0 : domainKey.hashCode());
		result = prime * result + ((entityId == null) ? 0 : entityId.hashCode());
		result = prime * result + ((entityType == null) ? 0 : entityType.hashCode());
		result = prime * result + ((fileId == null) ? 0 : fileId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EntityFileId other = (EntityFileId) obj;
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
		if (entityType == null) {
			if (other.entityType != null)
				return false;
		} else if (!entityType.equals(other.entityType))
			return false;
		if (fileId == null) {
			if (other.fileId != null)
				return false;
		} else if (!fileId.equals(other.fileId))
			return false;
		return true;
	}

}
