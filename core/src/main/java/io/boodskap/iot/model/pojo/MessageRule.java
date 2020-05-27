package io.boodskap.iot.model.pojo;


import io.boodskap.iot.model.IMessageRule;

public class MessageRule extends AbstractRule implements IMessageRule {

	private static final long serialVersionUID = -7902178923184109778L;
	
	private String specId;
	
	public MessageRule() {
	}

	public MessageRule(String domainKey, String specId) {
		super(domainKey);
		this.specId = specId;
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
		if (specId == null) {
			if (other.specId != null)
				return false;
		} else if (!specId.equals(other.specId))
			return false;
		return true;
	}

}
