package io.boodskap.iot.model.jpa;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import io.boodskap.iot.model.IUser;
import io.boodskap.iot.model.IUserRole;

@Entity()
@Table(name="user")
public class User extends AbstractPerson implements IUser {

	private static final long serialVersionUID = 7791702980774707258L;

	@EmbeddedId
	private UserId id = new UserId();

	public User(){
	}

	public User(UserId id){
		this.id = id;
	}

	@Override
	public IUserRole createRole(String name, String description) {
		UserRole role = new UserRole(new UserRoleId(getDomainKey(), getUserId(), name));
		role.setDescription(description);
		return role;
	}

	@Override
	public String getDomainKey() {
		return id.getDomainKey();
	}
	
	@Override
	public void setDomainKey(String domainKey) {
		id.setDomainKey(domainKey);
	}

	@Override
	public String getUserId() {
		return id.getUserId();
	}

	@Override
	public void setUserId(String userId) {
		id.setUserId(userId);
	}

}
