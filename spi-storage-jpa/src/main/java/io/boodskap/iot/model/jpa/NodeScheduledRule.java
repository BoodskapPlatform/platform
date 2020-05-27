package io.boodskap.iot.model.jpa;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import io.boodskap.iot.model.INodeScheduledRule;

@Entity
@Table(name="nodescheduledrule")
public class NodeScheduledRule extends AbstractModel implements INodeScheduledRule{

	private static final long serialVersionUID = 8376567957368711492L;
	
	@EmbeddedId
	private NodeScheduledRuleId id = new NodeScheduledRuleId();
	
	public NodeScheduledRule() {
	}

	public NodeScheduledRule(NodeScheduledRuleId id) {
		this.id = id;
	}

	public String getDomainKey() {
		return id.getDomainKey();
	}

	public void setDomainKey(String domainKey) {
		id.setDomainKey(domainKey);
	}

	public String getRuleId() {
		return id.getRuleId();
	}

	public void setRuleId(String ruleId) {
		id.setRuleId(ruleId);
	}

	public String getNodeId() {
		return id.getNodeId();
	}

	public void setNodeId(String nodeId) {
		id.setNodeId(nodeId);
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
		NodeScheduledRule other = (NodeScheduledRule) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
