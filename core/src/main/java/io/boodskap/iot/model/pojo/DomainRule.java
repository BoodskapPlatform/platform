package io.boodskap.iot.model.pojo;


import io.boodskap.iot.model.IDomainRule;

public class DomainRule extends AbstractRule implements IDomainRule{

	private static final long serialVersionUID = 2264895947798620085L;

	public DomainRule() {
	}
	
	public DomainRule(String domainKey) {
		setDomainKey(domainKey);
	}

}
