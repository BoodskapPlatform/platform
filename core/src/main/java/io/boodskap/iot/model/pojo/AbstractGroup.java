package io.boodskap.iot.model.pojo;

import io.boodskap.iot.model.IGroup;

public abstract class AbstractGroup extends AbstractDomainObject implements IGroup {

	private static final long serialVersionUID = -6339768473151871280L;

	private String groupId;
	private boolean individualBroadcast;
	private String groupEmail;
	private String groupPhone;
	
	public AbstractGroup(){
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((groupEmail == null) ? 0 : groupEmail.hashCode());
		result = prime * result + ((groupId == null) ? 0 : groupId.hashCode());
		result = prime * result + ((groupPhone == null) ? 0 : groupPhone.hashCode());
		result = prime * result + (individualBroadcast ? 1231 : 1237);
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
		AbstractGroup other = (AbstractGroup) obj;
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
		return true;
	}

}
