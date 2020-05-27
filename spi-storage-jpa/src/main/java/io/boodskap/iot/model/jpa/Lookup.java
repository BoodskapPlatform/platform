package io.boodskap.iot.model.jpa;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Lob;
import javax.persistence.Table;

import io.boodskap.iot.DataType;
import io.boodskap.iot.PropertyTarget;
import io.boodskap.iot.model.ILookup;

@Entity
@Table(name="lookup")
public class Lookup extends AbstractModel implements ILookup{

	private static final long serialVersionUID = -5281376095868689212L;

	@EmbeddedId
	private LookupId id = new LookupId();

	@Lob
	@Column(name="value", length=256)
	private String value;

	@Column(name="type", length=12)
	@Enumerated(EnumType.STRING)
	private DataType type;
	
	public Lookup(){
	}

	public Lookup(LookupId id){
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

	public DataType getType() {
		return type;
	}

	public void setType(DataType type) {
		this.type = type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Lookup other = (Lookup) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (type != other.type)
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

}
