package io.boodskap.iot.model.jpa;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

import io.boodskap.iot.PropertyTarget;
import io.boodskap.iot.model.IProperty;

@Entity
@Table(name="property")
public class Property extends AbstractStorable implements IProperty {

	private static final long serialVersionUID = -9065643553441625893L;
	
	@EmbeddedId
	private PropertyId id = new PropertyId();
	
	@Lob
	@Column(name="value", length=131072)
	private String value = null;
	
	public Property() {
	}
	
	public Property(PropertyId id) {
		this.id = id;
	}

	public String getDomainKey() {
		return id.getDomainKey();
	}

	public void setDomainKey(String domainKey) {
		id.setDomainKey(domainKey);
	}

	public PropertyTarget getTarget() {
		return id.getTarget();
	}

	public void setTarget(PropertyTarget target) {
		id.setTarget(target);
	}

	public String getTargetId() {
		return id.getTargetId();
	}

	public void setTargetId(String targetId) {
		id.setTargetId(targetId);
	}

	public String getName() {
		return id.getName();
	}

	public void setName(String name) {
		id.setName(name);
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
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
		Property other = (Property) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

}
