package io.boodskap.iot.model.pojo;

import java.util.Date;


import io.boodskap.iot.model.ILinkedDomain;

public class LinkedDomain implements ILinkedDomain {

	private static final long serialVersionUID = 1559779795904940641L;

	private String domainKey;
	private String linkedDomainKey;
	private String linkedApiKey;
	private String label;
	private boolean disabled;
	private Date createdStamp;
	private Date updatedStamp;

	public LinkedDomain() {
	}

	public LinkedDomain(String domainKey, String linkedDomainKey, String linkedApiKey) {
		this.domainKey = domainKey;
		this.linkedDomainKey = linkedDomainKey;
		this.linkedApiKey = linkedApiKey;
	}

	public String getDomainKey() {
		return domainKey;
	}

	public void setDomainKey(String domainKey) {
		this.domainKey = domainKey;
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

	public Date getCreatedStamp() {
		return createdStamp;
	}

	public void setCreatedStamp(Date createdStamp) {
		this.createdStamp = createdStamp;
	}

	public Date getUpdatedStamp() {
		return updatedStamp;
	}

	public void setUpdatedStamp(Date updatedStamp) {
		this.updatedStamp = updatedStamp;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createdStamp == null) ? 0 : createdStamp.hashCode());
		result = prime * result + (disabled ? 1231 : 1237);
		result = prime * result + ((domainKey == null) ? 0 : domainKey.hashCode());
		result = prime * result + ((label == null) ? 0 : label.hashCode());
		result = prime * result + ((linkedApiKey == null) ? 0 : linkedApiKey.hashCode());
		result = prime * result + ((linkedDomainKey == null) ? 0 : linkedDomainKey.hashCode());
		result = prime * result + ((updatedStamp == null) ? 0 : updatedStamp.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LinkedDomain other = (LinkedDomain) obj;
		if (createdStamp == null) {
			if (other.createdStamp != null)
				return false;
		} else if (!createdStamp.equals(other.createdStamp))
			return false;
		if (disabled != other.disabled)
			return false;
		if (domainKey == null) {
			if (other.domainKey != null)
				return false;
		} else if (!domainKey.equals(other.domainKey))
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
		if (updatedStamp == null) {
			if (other.updatedStamp != null)
				return false;
		} else if (!updatedStamp.equals(other.updatedStamp))
			return false;
		return true;
	}
}
