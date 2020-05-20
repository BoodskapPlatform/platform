package io.boodskap.iot.model.jpa;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import io.boodskap.iot.model.IDomainAssetGroupMember;

@Entity
@Table(name="domainassetgroupmember")
public class DomainAssetGroupMember implements IDomainAssetGroupMember{
	
	private static final long serialVersionUID = -4347644491268639376L;
	
	@EmbeddedId
	private DomainAssetGroupMemberId id = new DomainAssetGroupMemberId();

	@Column(name="regstamp")
	private Date registeredStamp;
	
	public DomainAssetGroupMember(){
	}

	public DomainAssetGroupMember(String domainKey, String groupId, String memberId){
		this(new DomainAssetGroupMemberId(domainKey, groupId, memberId));
	}

	public DomainAssetGroupMember(DomainAssetGroupMemberId id){
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
		DomainAssetGroupMember other = (DomainAssetGroupMember) obj;
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
