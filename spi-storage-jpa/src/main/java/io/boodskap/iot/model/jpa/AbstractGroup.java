package io.boodskap.iot.model.jpa;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import io.boodskap.iot.model.IGroup;

@MappedSuperclass
public abstract class AbstractGroup extends AbstractModel implements IGroup {

	private static final long serialVersionUID = -6339768473151871280L;

	@Column(name="ibroadcast")
	private boolean individualBroadcast;
	
	@Column(name="groupemail", length=120)
	private String groupEmail;
	
	@Column(name="groupphone", length=20)
	private String groupPhone;

	public AbstractGroup(){
	}

	@Override
	public final void setIndividualBroadcast(boolean individualBroadcast) {
		this.individualBroadcast = individualBroadcast;
	}

	@Override
	public final boolean isIndividualBroadcast() {
		return individualBroadcast;
	}

	@Override
	public final String getGroupEmail() {
		return groupEmail;
	}

	@Override
	public final void setGroupEmail(String groupEmail) {
		this.groupEmail = groupEmail;
	}

	@Override
	public final String getGroupPhone() {
		return groupPhone;
	}

	@Override
	public final void setGroupPhone(String groupPhone) {
		this.groupPhone = groupPhone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((groupEmail == null) ? 0 : groupEmail.hashCode());
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
