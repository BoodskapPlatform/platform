package io.boodskap.iot.model.pojo;


import io.boodskap.iot.model.IMessageRule;

public class MessageRule extends AbstractRule implements IMessageRule {

	private static final long serialVersionUID = -7902178923184109778L;
	
	private String domainKey;
	private String specId;
	
	public MessageRule() {
	}

	public MessageRule(String domainKey, String specId) {
		this.domainKey = domainKey;
		this.specId = specId;
	}

	public String getDomainKey() {
		return domainKey;
	}

	public void setDomainKey(String domainKey) {
		this.domainKey = domainKey;
	}

	public String getSpecId() {
		return specId;
	}

	public void setSpecId(String specId) {
		this.specId = specId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((domainKey == null) ? 0 : domainKey.hashCode());
		result = prime * result + ((specId == null) ? 0 : specId.hashCode());
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
		MessageRule other = (MessageRule) obj;
		if (domainKey == null) {
			if (other.domainKey != null)
				return false;
		} else if (!domainKey.equals(other.domainKey))
			return false;
		if (specId == null) {
			if (other.specId != null)
				return false;
		} else if (!specId.equals(other.specId))
			return false;
		return true;
	}

}
