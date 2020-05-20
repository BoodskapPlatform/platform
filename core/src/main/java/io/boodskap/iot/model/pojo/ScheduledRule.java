package io.boodskap.iot.model.pojo;


import io.boodskap.iot.model.IScheduledRule;

public class ScheduledRule extends AbstractRule implements IScheduledRule {
	
	private static final long serialVersionUID = -7983737035807344846L;

	private String domainKey;
	private String ruleId;
	private String pattern;
	
	public ScheduledRule() {
	}

	public ScheduledRule(String domainKey, String ruleId) {
		super();
		this.domainKey = domainKey;
		this.ruleId = ruleId;
	}

	public String getDomainKey() {
		return domainKey;
	}

	public void setDomainKey(String domainKey) {
		this.domainKey = domainKey;
	}

	public String getRuleId() {
		return ruleId;
	}

	public void setRuleId(String ruleId) {
		this.ruleId = ruleId;
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
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((domainKey == null) ? 0 : domainKey.hashCode());
		result = prime * result + ((pattern == null) ? 0 : pattern.hashCode());
		result = prime * result + ((ruleId == null) ? 0 : ruleId.hashCode());
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
		if (domainKey == null) {
			if (other.domainKey != null)
				return false;
		} else if (!domainKey.equals(other.domainKey))
			return false;
		if (pattern == null) {
			if (other.pattern != null)
				return false;
		} else if (!pattern.equals(other.pattern))
			return false;
		if (ruleId == null) {
			if (other.ruleId != null)
				return false;
		} else if (!ruleId.equals(other.ruleId))
			return false;
		return true;
	}

}
