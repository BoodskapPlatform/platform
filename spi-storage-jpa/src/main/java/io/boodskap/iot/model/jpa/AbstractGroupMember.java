package io.boodskap.iot.model.jpa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractGroupMember implements Serializable {

	private static final long serialVersionUID = 7540023549338386842L;

	@Column(name="domainkey", length=16)
	private String domainKey;
	
	@Column(name="groupid", length=40)
	private String groupId;

	@Column(name="memberid", length=40)
	private String memberId;
	
	public AbstractGroupMember(){
	}

	public AbstractGroupMember(String domainKey, String groupId, String memberId) {
		this.domainKey = domainKey;
		this.groupId = groupId;
		this.memberId = memberId;
	}

	public String getDomainKey() {
		return domainKey;
	}

	public void setDomainKey(String domainKey) {
		this.domainKey = domainKey;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((domainKey == null) ? 0 : domainKey.hashCode());
		result = prime * result + ((groupId == null) ? 0 : groupId.hashCode());
		result = prime * result + ((memberId == null) ? 0 : memberId.hashCode());
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
		AbstractGroupMember other = (AbstractGroupMember) obj;
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
		if (memberId == null) {
			if (other.memberId != null)
				return false;
		} else if (!memberId.equals(other.memberId))
			return false;
		return true;
	}

}
