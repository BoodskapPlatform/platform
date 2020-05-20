package io.boodskap.iot.model.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.boodskap.iot.model.IDomainRule;

@Entity
@Table(name="domainrule")
public class DomainRule extends AbstractRule implements IDomainRule{

	private static final long serialVersionUID = 2264895947798620085L;

	@Id
	@Column(name="domainkey", length=16)
	private String domainKey; 

	public DomainRule() {
	}
	
	public DomainRule(String domainKey) {
		this.domainKey = domainKey;
	}

	public String getDomainKey() {
		return domainKey;
	}

	public void setDomainKey(String domainKey) {
		this.domainKey = domainKey;
	}

}
