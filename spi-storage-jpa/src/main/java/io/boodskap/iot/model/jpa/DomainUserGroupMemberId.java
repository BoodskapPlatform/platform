package io.boodskap.iot.model.jpa;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class DomainUserGroupMemberId extends AbstractGroupMemberId implements Serializable{

	private static final long serialVersionUID = -4375322312258983733L;

	public DomainUserGroupMemberId() {
	}

	public DomainUserGroupMemberId(String domainKey, String groupId, String memberId) {
		super(domainKey, groupId, memberId);
	}

}
