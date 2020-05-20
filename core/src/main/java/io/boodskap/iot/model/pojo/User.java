package io.boodskap.iot.model.pojo;


import io.boodskap.iot.model.IUser;
import io.boodskap.iot.model.IUserRole;

public class User extends AbstractPerson implements IUser {

	private static final long serialVersionUID = 7791702980774707258L;
	
	private String domainKey;
	private String userId;

	public User(){
	}

	public User(String domainKey, String userId) {
		super();
		this.domainKey = domainKey;
		this.userId = userId;
	}

	@Override
	public IUserRole createRole(String name, String description) {
		return new UserRole(getDomainKey(), getUserId(), name, description);
	}

	public String getDomainKey() {
		return domainKey;
	}

	public void setDomainKey(String domainKey) {
		this.domainKey = domainKey;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((domainKey == null) ? 0 : domainKey.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
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
		User other = (User) obj;
		if (domainKey == null) {
			if (other.domainKey != null)
				return false;
		} else if (!domainKey.equals(other.domainKey))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

}
