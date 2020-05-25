package io.boodskap.iot.model.pojo;


import io.boodskap.iot.model.IUser;
import io.boodskap.iot.model.IUserRole;

public class User extends AbstractPerson implements IUser {

	private static final long serialVersionUID = 7791702980774707258L;
	
	private String userId;

	public User(){
	}

	@Override
	public IUserRole createRole(String name, String description) {
		return new UserRole(getDomainKey(), getUserId(), name, description);
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
