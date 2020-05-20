package io.boodskap.iot.model.jpa;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import io.boodskap.iot.SizeConstants;
import io.boodskap.iot.model.IRole;

@Entity
@Table(name="domainentityrole")
public class DomainEntityRole implements IRole {
	
	private static final long serialVersionUID = 138150327606130924L;

	@EmbeddedId
	private DomainEntityRoleId id = new DomainEntityRoleId();

	@Column(name="roledesc", length=SizeConstants.DESCRIPTION_SIZE)
	private String description = null;
	
	public DomainEntityRole() {
	}

	public DomainEntityRole(DomainEntityRoleId id) {
		super();
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

	public String getName() {
		return id.getName();
	}

	public void setName(String name) {
		id.setName(name);
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		DomainEntityRole other = (DomainEntityRole) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
