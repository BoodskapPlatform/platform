package io.boodskap.iot.model.pojo;

import io.boodskap.iot.model.IDomainEntity;

public class DomainEntity extends AbstractEntity implements IDomainEntity {
	
	private static final long serialVersionUID = 2882976847537967569L;

	private String domainKey;
	private String entityId;

	public DomainEntity() {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((domainKey == null) ? 0 : domainKey.hashCode());
		result = prime * result + ((entityId == null) ? 0 : entityId.hashCode());
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
		DomainEntity other = (DomainEntity) obj;
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
		return true;
	}

}
