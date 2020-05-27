package io.boodskap.iot.model.jpa;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import io.boodskap.iot.model.ILinkedDomain;

@Entity
@Table(name="linkeddomain")
public class LinkedDomain extends AbstractModel implements ILinkedDomain {

	private static final long serialVersionUID = 1559779795904940641L;

	@EmbeddedId
	private LinkedDomainId id = new LinkedDomainId();
	
	@Column(name="disabled")
	private boolean disabled;

	public LinkedDomain() {
	}

	public LinkedDomain(LinkedDomainId id) {
		this.id = id;
	}

	public String getDomainKey() {
		return id.getDomainKey();
	}

	public void setDomainKey(String domainKey) {
		id.setDomainKey(domainKey);
	}

	public String getLinkedDomainKey() {
		return id.getLinkedDomainKey();
	}

	public void setLinkedDomainKey(String linkedDomainKey) {
		id.setLinkedDomainKey(linkedDomainKey);
	}

	public String getLinkedApiKey() {
		return id.getLinkedApiKey();
	}

	public void setLinkedApiKey(String linkedApiKey) {
		id.setLinkedApiKey(linkedApiKey);
	}

	public boolean isDisabled() {
		return disabled;
	}

	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (disabled ? 1231 : 1237);
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
		LinkedDomain other = (LinkedDomain) obj;
		if (disabled != other.disabled)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
