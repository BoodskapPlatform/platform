package io.boodskap.iot.model.jpa;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import io.boodskap.iot.model.IUser;

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
