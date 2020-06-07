package io.boodskap.iot.model.pojo;

import io.boodskap.iot.model.IEntity;

public abstract class AbstractEntity extends AbstractStorageObject implements IEntity {

	private static final long serialVersionUID = 2846999319144262673L;
	
	private String description;
	private String createdBy;
	private String updatedBy;
	
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

}
