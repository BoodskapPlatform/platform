package io.boodskap.iot.model.pojo;

import io.boodskap.iot.model.ILinkedDomain;

public class LinkedDomain extends AbstractDomainObject implements ILinkedDomain {

	private static final long serialVersionUID = 1559779795904940641L;

	private String linkedDomainKey;
	private String linkedApiKey;
	private String label;
	private boolean disabled;

	public LinkedDomain() {
	}

	public String getLinkedDomainKey() {
		return linkedDomainKey;
	}

	public void setLinkedDomainKey(String linkedDomainKey) {
		this.linkedDomainKey = linkedDomainKey;
	}

	public String getLinkedApiKey() {
		return linkedApiKey;
	}

	public void setLinkedApiKey(String linkedApiKey) {
		this.linkedApiKey = linkedApiKey;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public boolean isDisabled() {
		return disabled;
	}

	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (disabled ? 1231 : 1237);
		result = prime * result + ((label == null) ? 0 : label.hashCode());
		result = prime * result + ((linkedApiKey == null) ? 0 : linkedApiKey.hashCode());
		result = prime * result + ((linkedDomainKey == null) ? 0 : linkedDomainKey.hashCode());
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
		LinkedDomain other = (LinkedDomain) obj;
		if (disabled != other.disabled)
			return false;
		if (label == null) {
			if (other.label != null)
				return false;
		} else if (!label.equals(other.label))
			return false;
		if (linkedApiKey == null) {
			if (other.linkedApiKey != null)
				return false;
		} else if (!linkedApiKey.equals(other.linkedApiKey))
			return false;
		if (linkedDomainKey == null) {
			if (other.linkedDomainKey != null)
				return false;
		} else if (!linkedDomainKey.equals(other.linkedDomainKey))
			return false;
		return true;
	}

}
