package io.boodskap.iot.model.jpa;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import io.boodskap.iot.DataType;
import io.boodskap.iot.model.IMessageField;

@Embeddable
public class MessageField implements IMessageField {

	private static final long serialVersionUID = -6373844951592507837L;

	@Column(name="name", length=40)
	private String name;

	@Column(name="datatype", length=12)
	@Enumerated(EnumType.STRING)
	private DataType dataType;

	@Column(name="description", length=120)
	private String description;

	@Column(name="indexed")
	private boolean indexed;

	@Column(name="fullindexed")
	private boolean fulltextIndexed;
	
	public MessageField(){
	}

	public MessageField(String name, DataType dataType) {
		super();
		this.name = name;
		this.dataType = dataType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public DataType getDataType() {
		return dataType;
	}

	public void setDataType(DataType dataType) {
		this.dataType = dataType;
	}

	public boolean isIndexed() {
		return indexed;
	}

	public void setIndexed(boolean indexed) {
		this.indexed = indexed;
	}

	public boolean isFulltextIndexed() {
		return fulltextIndexed;
	}

	public void setFulltextIndexed(boolean fulltextIndexed) {
		this.fulltextIndexed = fulltextIndexed;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataType == null) ? 0 : dataType.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + (fulltextIndexed ? 1231 : 1237);
		result = prime * result + (indexed ? 1231 : 1237);
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
		MessageField other = (MessageField) obj;
		if (dataType != other.dataType)
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (fulltextIndexed != other.fulltextIndexed)
			return false;
		if (indexed != other.indexed)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
