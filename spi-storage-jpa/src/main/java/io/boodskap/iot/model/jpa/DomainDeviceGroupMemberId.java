package io.boodskap.iot.model.jpa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class DomainDeviceGroupMemberId extends AbstractGroupMember implements Serializable{

	private static final long serialVersionUID = -4753440057676809101L;

	@Column(name="dummy")
	private Integer dummy;
	
	public DomainDeviceGroupMemberId() {
	}

	public DomainDeviceGroupMemberId(String domainKey, String groupId, String memberId) {
		super(domainKey, groupId, memberId);
	}

	public Integer getDummy() {
		return dummy;
	}

	public void setDummy(Integer dummy) {
		this.dummy = dummy;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((dummy == null) ? 0 : dummy.hashCode());
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
		DomainDeviceGroupMemberId other = (DomainDeviceGroupMemberId) obj;
		if (dummy == null) {
			if (other.dummy != null)
				return false;
		} else if (!dummy.equals(other.dummy))
			return false;
		return true;
	}

}
