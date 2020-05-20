package io.boodskap.iot.model.jpa;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import io.boodskap.iot.model.IBinaryRule;

@Entity
@Table(name="binaryrule")
public class BinaryRule extends AbstractRule implements IBinaryRule{
	
	private static final long serialVersionUID = -5294325836044591996L;
	
	@EmbeddedId
	private BinaryRuleId id = new BinaryRuleId();
	
	public BinaryRule() {
	}

	public BinaryRule(BinaryRuleId id) {
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
	public String getType() {
		return id.getType();
	}

	@Override
	public void setType(String type) {
		id.setType(type);
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
		BinaryRule other = (BinaryRule) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
