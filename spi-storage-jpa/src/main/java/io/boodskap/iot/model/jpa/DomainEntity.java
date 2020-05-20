package io.boodskap.iot.model.jpa;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import io.boodskap.iot.model.IDomainEntity;

@Entity
@Table(name="domainentity")
public class DomainEntity extends AbstractEntity implements IDomainEntity {
	
	private static final long serialVersionUID = 2882976847537967569L;

	@EmbeddedId
	private DomainEntityId id = new DomainEntityId();

	public DomainEntity() {
	}

	public DomainEntity(DomainEntityId id) {
		this.id = id;
	}

	@Override
	public String getDomainKey() {
		return id.getDomainKey();
	}

	@Override
	public void setDomainKey(String domainKey) {
		id.setDomainKey(domainKey);
	}

	@Override
	public String getEntityId() {
		return id.getEntityId();
	}

	@Override
	public void setEntityId(String entityId) {
		id.setEntityId(entityId);
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
		DomainEntity other = (DomainEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
