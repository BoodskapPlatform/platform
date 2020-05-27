package io.boodskap.iot.model.jpa;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import io.boodskap.iot.model.IStorageObject;

@MappedSuperclass
public abstract class AbstractStorageObject implements IStorageObject {

	private static final long serialVersionUID = -4455402574445941075L;

	@Column(name="registeredstamp")
	private Date registeredStamp;
	
	@Column(name="updatedstamp")
	private Date updatedStamp;
	
	public AbstractStorageObject() {
	}

	@Override
	public final Date getRegisteredStamp() {
		return registeredStamp;
	}

	@Override
	public final void setRegisteredStamp(Date registeredStamp) {
		this.registeredStamp = registeredStamp;
	}

	@Override
	public final Date getUpdatedStamp() {
		return updatedStamp;
	}

	@Override
	public final void setUpdatedStamp(Date updatedStamp) {
		this.updatedStamp = updatedStamp;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((registeredStamp == null) ? 0 : registeredStamp.hashCode());
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
		AbstractStorageObject other = (AbstractStorageObject) obj;
		if (registeredStamp == null) {
			if (other.registeredStamp != null)
				return false;
		} else if (!registeredStamp.equals(other.registeredStamp))
			return false;
		if (updatedStamp == null) {
			if (other.updatedStamp != null)
				return false;
		} else if (!updatedStamp.equals(other.updatedStamp))
			return false;
		return true;
	}

	@Override
	public final String toString() {
		return toJSONString();
	}
}
