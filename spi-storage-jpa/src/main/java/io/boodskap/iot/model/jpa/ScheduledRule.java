package io.boodskap.iot.model.jpa;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import io.boodskap.iot.SizeConstants;
import io.boodskap.iot.model.IScheduledRule;

@Entity()
@Table(name="scheduledrule")
public class ScheduledRule extends AbstractRule implements IScheduledRule {
	
	private static final long serialVersionUID = -7983737035807344846L;

	@EmbeddedId
	private ScheduledRuleId id = new ScheduledRuleId();
	
	@Column(name="pattern", length=120)
	private String pattern;
	
	@Column(name="name", length=SizeConstants.NAME_SIZE)
	private String name;

	public ScheduledRule() {
	}

	public ScheduledRule(ScheduledRuleId id) {
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
	public String getRuleId() {
		return id.getRuleId();
	}

	@Override
	public void setRuleId(String ruleId) {
		id.setRuleId(ruleId);
	}

	@Override
	public String getPattern() {
		return pattern;
	}

	@Override
	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((pattern == null) ? 0 : pattern.hashCode());
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
		ScheduledRule other = (ScheduledRule) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (pattern == null) {
			if (other.pattern != null)
				return false;
		} else if (!pattern.equals(other.pattern))
			return false;
		return true;
	}

}
