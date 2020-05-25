package io.boodskap.iot.model.pojo;


import io.boodskap.iot.model.IDomainRole;

public class DomainRole extends AbstractDomainObject implements IDomainRole {
	
	private static final long serialVersionUID = 2283422339170322884L;

	public DomainRole() {
	}

	public DomainRole(String domainKey, String name, String description) {
		setDomainKey(domainKey);
		setName(name);
		setDescription(description);
	}

}
