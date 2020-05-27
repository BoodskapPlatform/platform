package io.boodskap.iot.model.jpa;

import java.io.Serializable;

import javax.persistence.Embeddable;


@Embeddable
public class DomainAssetGroupId extends AbstractGroupId implements Serializable {
	
	private static final long serialVersionUID = -413928620713810174L;

	public DomainAssetGroupId() {
	}

	public DomainAssetGroupId(String domainKey, String groupId) {
		super(domainKey, groupId);
	}

}
