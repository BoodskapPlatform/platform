package io.boodskap.iot.model.jpa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;


@MappedSuperclass
public abstract class AbstractGroupId implements Serializable {
	
	private static final long serialVersionUID = 8608642509767493580L;

	@Column(name="domainkey", length=16)
	private String domainKey;

	@Column(name="groupid", length=40)
	private String groupId;

	public AbstractGroupId() {
	}

	public AbstractGroupId(String domainKey, String groupId) {
		this.domainKey = domainKey;
		this.groupId = groupId;
	}

	public final String getDomainKey() {
		return domainKey;
	}

	public final void setDomainKey(String domainKey) {
		this.domainKey = domainKey;
	}

	public final String getGroupId() {
		return groupId;
	}

	public final void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((domainKey == null) ? 0 : domainKey.hashCode());
		result = prime * result + ((groupId == null) ? 0 : groupId.hashCode());
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
		AbstractGroupId other = (AbstractGroupId) obj;
		if (domainKey == null) {
			if (other.domainKey != null)
				return false;
		} else if (!domainKey.equals(other.domainKey))
			return false;
		if (groupId == null) {
			if (other.groupId != null)
				return false;
		} else if (!groupId.equals(other.groupId))
			return false;
		return true;
	}

}
