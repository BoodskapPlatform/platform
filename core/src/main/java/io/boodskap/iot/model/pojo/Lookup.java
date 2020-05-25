package io.boodskap.iot.model.pojo;

import io.boodskap.iot.DataType;
import io.boodskap.iot.PropertyTarget;
import io.boodskap.iot.model.ILookup;

public class Lookup extends AbstractDomainObject implements ILookup{

	private static final long serialVersionUID = -5281376095868689212L;

	private PropertyTarget target;
	private String targetId;
	private String value;
	private DataType type;
	
	public Lookup(){
	}

	public Lookup(String domainKey, PropertyTarget target, String targetId, String name) {
		setDomainKey(domainKey);
		this.target = target;
		this.targetId = targetId;
		setName(name);
	}

	public PropertyTarget getTarget() {
		return target;
	}

	public void setTarget(PropertyTarget target) {
		this.target = target;
	}

	public String getTargetId() {
		return targetId;
	}

	public void setTargetId(String targetId) {
		this.targetId = targetId;
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
		result = prime * result + ((target == null) ? 0 : target.hashCode());
		result = prime * result + ((targetId == null) ? 0 : targetId.hashCode());
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
		if (target != other.target)
			return false;
		if (targetId == null) {
			if (other.targetId != null)
				return false;
		} else if (!targetId.equals(other.targetId))
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
