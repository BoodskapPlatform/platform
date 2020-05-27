package io.boodskap.iot.model.pojo;

import java.util.Date;

import io.boodskap.iot.model.IStorageObject;

public abstract class AbstractStorageObject implements IStorageObject {

	private static final long serialVersionUID = 5856280034568532293L;
	
	private Date registeredStamp;
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
	public final String toString() {
		return toJSONString();
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

}
