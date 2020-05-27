package io.boodskap.iot.model.pojo;

import io.boodskap.iot.DataType;
import io.boodskap.iot.model.IField;

public abstract class AbstractField extends AbstractStorageObject implements IField {

	private static final long serialVersionUID = -7398949474866288452L;
	
	private String domainKey;
	private String name;
	private String description;
	private DataType dataType;
	
	public AbstractField() {
	}

	public final String getDomainKey() {
		return domainKey;
	}

	public final void setDomainKey(String domainKey) {
		this.domainKey = domainKey;
	}

	@Override
	public final String getName() {
		return name;
	}

	@Override
	public final void setName(String name) {
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
	public final DataType getDataType() {
		return dataType;
	}

	@Override
	public final void setDataType(DataType type) {
		this.dataType = type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataType == null) ? 0 : dataType.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((domainKey == null) ? 0 : domainKey.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		AbstractField other = (AbstractField) obj;
		if (dataType != other.dataType)
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (domainKey == null) {
			if (other.domainKey != null)
				return false;
		} else if (!domainKey.equals(other.domainKey))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
