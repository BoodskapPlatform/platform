package io.boodskap.iot.model.pojo;


import io.boodskap.iot.model.IUserRole;

public class UserRole extends DomainRole implements IUserRole {
	
	private static final long serialVersionUID = -1713165327685347649L;
	
	private String userId;
	
	public UserRole() {
	}

	public UserRole(String domainKey, String userId, String name, String description) {
		setDomainKey(domainKey);
		this.userId = userId;
		setName(name);
		setDescription(description);
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
		UserRole other = (UserRole) obj;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

}
