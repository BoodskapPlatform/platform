package io.boodskap.iot.model.pojo;

import io.boodskap.iot.model.IDomain;
import io.boodskap.iot.model.IDomainRole;

public class Domain extends AbstractContact implements IDomain {

	private static final long serialVersionUID = 6658928306824558407L;

	public Domain() {
	}
	
	public IDomainRole createRole(String name, String description) {
		return new DomainRole(getDomainKey(), name, description);
	}

}
