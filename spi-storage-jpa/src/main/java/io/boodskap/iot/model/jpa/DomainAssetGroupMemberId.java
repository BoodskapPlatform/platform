package io.boodskap.iot.model.jpa;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class DomainAssetGroupMemberId extends AbstractGroupMemberId implements Serializable{

	private static final long serialVersionUID = -1025774543446457403L;

	public DomainAssetGroupMemberId() {
	}

	public DomainAssetGroupMemberId(String domainKey, String groupId, String memberId) {
		super(domainKey, groupId, memberId);
	}

}
