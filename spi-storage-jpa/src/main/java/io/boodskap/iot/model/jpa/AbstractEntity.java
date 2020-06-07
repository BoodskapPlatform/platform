package io.boodskap.iot.model.jpa;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import io.boodskap.iot.SizeConstants;
import io.boodskap.iot.model.IEntity;

@MappedSuperclass
public abstract class AbstractEntity extends AbstractStorageObject implements IEntity {

	private static final long serialVersionUID = 1356450075893904988L;
	
	@Column(name="description", length=SizeConstants.DESCRIPTION_SIZE)
	private String description;
	
	@Column(name="createdby", length=SizeConstants.EMAIL_ID_SIZE)
	private String createdBy;
	
	@Column(name="updatedby", length=SizeConstants.EMAIL_ID_SIZE)
	private String updatedBy;
	
	@Column(name="registeredstamp")
	private Date registeredStamp;
	
	@Column(name="updatedstamp")
	private Date updatedStamp;

	public AbstractEntity() {
	}

	@Override
	public final String getDescription() {
		return description;
	}

	@Override
	public final void setDescription(String description) {
		this.description = description;
	}

	@Override
	public final String getCreatedBy() {
		return createdBy;
	}

	@Override
	public final void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@Override
	public final String getUpdatedBy() {
		return updatedBy;
	}

	@Override
	public final void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((createdBy == null) ? 0 : createdBy.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((registeredStamp == null) ? 0 : registeredStamp.hashCode());
		result = prime * result + ((updatedBy == null) ? 0 : updatedBy.hashCode());
		result = prime * result + ((updatedStamp == null) ? 0 : updatedStamp.hashCode());
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
		AbstractEntity other = (AbstractEntity) obj;
		if (createdBy == null) {
			if (other.createdBy != null)
				return false;
		} else if (!createdBy.equals(other.createdBy))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (registeredStamp == null) {
			if (other.registeredStamp != null)
				return false;
		} else if (!registeredStamp.equals(other.registeredStamp))
			return false;
		if (updatedBy == null) {
			if (other.updatedBy != null)
				return false;
		} else if (!updatedBy.equals(other.updatedBy))
			return false;
		if (updatedStamp == null) {
			if (other.updatedStamp != null)
				return false;
		} else if (!updatedStamp.equals(other.updatedStamp))
			return false;
		return true;
	}

}
