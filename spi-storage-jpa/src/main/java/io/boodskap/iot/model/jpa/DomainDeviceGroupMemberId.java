package io.boodskap.iot.model.jpa;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class DomainDeviceGroupMemberId extends AbstractGroupMemberId implements Serializable{

	private static final long serialVersionUID = -4753440057676809101L;

	public DomainDeviceGroupMemberId() {
	}

	public DomainDeviceGroupMemberId(String domainKey, String groupId, String memberId) {
		super(domainKey, groupId, memberId);
	}

}
