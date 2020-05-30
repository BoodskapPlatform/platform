package io.boodskap.iot.model.jpa;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;

import io.boodskap.iot.DataType;
import io.boodskap.iot.SizeConstants;
import io.boodskap.iot.model.IField;

@MappedSuperclass
public abstract class AbstractField extends AbstractStorageObject implements IField {

	private static final long serialVersionUID = -6421083893579742193L;
	
	@Column(name="name", length=SizeConstants.NAME_SIZE)
	private String name;

	@Column(name="description", length=SizeConstants.DESCRIPTION_SIZE)
	private String description;
	
	@Enumerated(EnumType.STRING)
	@Column(name="fdatatype")
	private DataType dataType;
	
	public AbstractField() {
	}
	
	public AbstractField(String name, DataType dataType) {
		this.name = name;
		this.dataType = dataType;
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
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
	public DataType getDataType() {
		return dataType;
	}

	@Override
	public void setDataType(DataType dataType) {
		this.dataType = dataType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((dataType == null) ? 0 : dataType.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		AbstractField other = (AbstractField) obj;
		if (dataType != other.dataType)
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
