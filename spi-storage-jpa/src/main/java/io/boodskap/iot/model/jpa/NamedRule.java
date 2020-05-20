package io.boodskap.iot.model.jpa;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import io.boodskap.iot.model.INamedRule;

@Entity
@Table(name="namedrule")
public class NamedRule extends AbstractRule implements INamedRule  {

	private static final long serialVersionUID = 7933521367071321137L;
	
	@EmbeddedId
	private NamedRuleId id = new NamedRuleId();
	
	public NamedRule() {
	}

	public NamedRule(NamedRuleId id) {
		this.id = id;
	}

	@Override
	public String getDomainKey() {
		return id.getDomainKey();
	}

	@Override
	public void setDomainKey(String domainKey) {
		id.setDomainKey(domainKey);
	}

	@Override
	public String getName() {
		return id.getName();
	}

	@Override
	public void setName(String name) {
		id.setName(name);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		NamedRule other = (NamedRule) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
