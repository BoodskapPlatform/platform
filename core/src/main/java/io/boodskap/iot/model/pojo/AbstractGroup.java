package io.boodskap.iot.model.pojo;

import java.util.Date;

import io.boodskap.iot.model.IGroup;

public abstract class AbstractGroup implements IGroup {

	private static final long serialVersionUID = -6339768473151871280L;

	private String domainKey;
	private String groupId;
	private String name;
	private String description;
	private boolean individualBroadcast;
	private String groupEmail;
	private String groupPhone;
	private Date createdStamp;
	private Date updatedStamp;
	
	public AbstractGroup(){
	}

	public AbstractGroup(String domainKey, String groupId) {
		super();
		this.domainKey = domainKey;
		this.groupId = groupId;
	}

	public String getDomainKey() {
		return domainKey;
	}

	public void setDomainKey(String domainKey) {
		this.domainKey = domainKey;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public void setIndividualBroadcast(boolean individualBroadcast) {
		this.individualBroadcast = individualBroadcast;
	}

	@Override
	public boolean isIndividualBroadcast() {
		return individualBroadcast;
	}

	@Override
	public String getGroupEmail() {
		return groupEmail;
	}

	@Override
	public void setGroupEmail(String groupEmail) {
		this.groupEmail = groupEmail;
	}

	@Override
	public String getGroupPhone() {
		return groupPhone;
	}

	@Override
	public void setGroupPhone(String groupPhone) {
		this.groupPhone = groupPhone;
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
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((domainKey == null) ? 0 : domainKey.hashCode());
		result = prime * result + ((groupEmail == null) ? 0 : groupEmail.hashCode());
		result = prime * result + ((groupId == null) ? 0 : groupId.hashCode());
		result = prime * result + ((groupPhone == null) ? 0 : groupPhone.hashCode());
		result = prime * result + (individualBroadcast ? 1231 : 1237);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		AbstractGroup other = (AbstractGroup) obj;
		if (createdStamp == null) {
			if (other.createdStamp != null)
				return false;
		} else if (!createdStamp.equals(other.createdStamp))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (domainKey == null) {
			if (other.domainKey != null)
				return false;
		} else if (!domainKey.equals(other.domainKey))
			return false;
		if (groupEmail == null) {
			if (other.groupEmail != null)
				return false;
		} else if (!groupEmail.equals(other.groupEmail))
			return false;
		if (groupId == null) {
			if (other.groupId != null)
				return false;
		} else if (!groupId.equals(other.groupId))
			return false;
		if (groupPhone == null) {
			if (other.groupPhone != null)
				return false;
		} else if (!groupPhone.equals(other.groupPhone))
			return false;
		if (individualBroadcast != other.individualBroadcast)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (updatedStamp == null) {
			if (other.updatedStamp != null)
				return false;
		} else if (!updatedStamp.equals(other.updatedStamp))
			return false;
		return true;
	}

}
