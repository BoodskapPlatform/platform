package io.boodskap.iot.model.jpa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;

import io.boodskap.iot.EntityType;

@Embeddable
@MappedSuperclass
public class LocationId implements Serializable {
	
	private static final long serialVersionUID = 8792483937404118872L;

	@Column(name="domainkey", length=16)
	private String domainKey;
	
	@Enumerated(EnumType.STRING)
	@Column(name="entitytype", length=10)
	private EntityType entityType = EntityType.UNKNOWN;
	
	@Column(name="entityid", length=40)
	private String entityId;

	public LocationId() {
	}

	public LocationId(String domainKey, EntityType entityType, String entityId) {
		this.domainKey = domainKey;
		this.entityType = entityType;
		this.entityId = entityId;
	}

	public String getDomainKey() {
		return domainKey;
	}

	public void setDomainKey(String domainKey) {
		this.domainKey = domainKey;
	}

	public EntityType getEntityType() {
		return entityType;
	}

	public void setEntityType(EntityType entityType) {
		this.entityType = entityType;
	}

	public String getEntityId() {
		return entityId;
	}

	public void setEntityId(String entityId) {
		this.entityId = entityId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((domainKey == null) ? 0 : domainKey.hashCode());
		result = prime * result + ((entityId == null) ? 0 : entityId.hashCode());
		result = prime * result + ((entityType == null) ? 0 : entityType.hashCode());
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
		LocationId other = (LocationId) obj;
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
		if (entityType != other.entityType)
			return false;
		return true;
	}

}
