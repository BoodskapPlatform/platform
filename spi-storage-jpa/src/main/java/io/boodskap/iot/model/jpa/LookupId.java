package io.boodskap.iot.model.jpa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import io.boodskap.iot.PropertyTarget;

@Embeddable
public class LookupId implements Serializable{

	private static final long serialVersionUID = -4095274971384742005L;
	
	@Column(name="domainkey", length=16)
	private String domainKey;
	
	@Column(name="target", length=25)
	@Enumerated(EnumType.STRING)
	private PropertyTarget target;
	
	@Column(name="targetid", length=40)
	private String targetId;

	@Column(name="name", length=80)
	private String name;
	
	public LookupId(){
	}

	public LookupId(String domainKey, PropertyTarget target, String targetId, String name) {
		this.domainKey = domainKey;
		this.target = target;
		this.targetId = targetId;
		this.name = name;
	}

	public String getDomainKey() {
		return domainKey;
	}

	public void setDomainKey(String domainKey) {
		this.domainKey = domainKey;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((domainKey == null) ? 0 : domainKey.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((target == null) ? 0 : target.hashCode());
		result = prime * result + ((targetId == null) ? 0 : targetId.hashCode());
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
		LookupId other = (LookupId) obj;
		if (domainKey == null) {
			if (other.domainKey != null)
				return false;
		} else if (!domainKey.equals(other.domainKey))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (target != other.target)
			return false;
		if (targetId == null) {
			if (other.targetId != null)
				return false;
		} else if (!targetId.equals(other.targetId))
			return false;
		return true;
	}

}
