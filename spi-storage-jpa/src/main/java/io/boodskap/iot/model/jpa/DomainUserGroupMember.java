package io.boodskap.iot.model.jpa;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import io.boodskap.iot.model.IDomainUserGroupMember;

@Entity
@Table(name="domainusergroupmember")
public class DomainUserGroupMember implements IDomainUserGroupMember {
	
	private static final long serialVersionUID = 8104092501308743360L;
	
	@EmbeddedId
	private DomainUserGroupMemberId id = new DomainUserGroupMemberId();
	
	@Column(name="regstamp")
	private Date registeredStamp;
	
	public DomainUserGroupMember() {
	}

	public DomainUserGroupMember(DomainUserGroupMemberId id) {
		this.id = id;
	}

	@Override
	public String getGroupId() {
		return id.getGroupId();
	}

	@Override
	public void setGroupId(String groupId) {
		id.setGroupId(groupId);
	}

	@Override
	public String getMemberId() {
		return id.getMemberId();
	}

	@Override
	public void setMemberId(String memberId) {
		id.setMemberId(memberId);
	}

	@Override
	public String getDomainKey() {
		return id.getDomainKey();
	}

	@Override
	public void setDomainKey(String domainKey) {
		id.setDomainKey(domainKey);
	}

	public Date getRegisteredStamp() {
		return registeredStamp;
	}

	public void setRegisteredStamp(Date registeredStamp) {
		this.registeredStamp = registeredStamp;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((registeredStamp == null) ? 0 : registeredStamp.hashCode());
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
		DomainUserGroupMember other = (DomainUserGroupMember) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (registeredStamp == null) {
			if (other.registeredStamp != null)
				return false;
		} else if (!registeredStamp.equals(other.registeredStamp))
			return false;
		return true;
	}

}
