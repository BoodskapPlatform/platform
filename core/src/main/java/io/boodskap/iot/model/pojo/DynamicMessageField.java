package io.boodskap.iot.model.pojo;

import io.boodskap.iot.model.IDynamicMessageField;

public class DynamicMessageField extends DynamicField implements IDynamicMessageField {
	
	private static final long serialVersionUID = -5123999890746243650L;
	
	private String domainKey;
	private String specId;
	private String messageId;
	private String name;

	public DynamicMessageField() {
	}

	public DynamicMessageField(String domainKey, String specId, String messageId, String name) {
		this.domainKey = domainKey;
		this.specId = specId;
		this.messageId = messageId;
		this.name = name;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((domainKey == null) ? 0 : domainKey.hashCode());
		result = prime * result + ((messageId == null) ? 0 : messageId.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		DynamicMessageField other = (DynamicMessageField) obj;
		if (domainKey == null) {
			if (other.domainKey != null)
				return false;
		} else if (!domainKey.equals(other.domainKey))
			return false;
		if (messageId == null) {
			if (other.messageId != null)
				return false;
		} else if (!messageId.equals(other.messageId))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (specId == null) {
			if (other.specId != null)
				return false;
		} else if (!specId.equals(other.specId))
			return false;
		return true;
	}

}
