package io.boodskap.iot.model.jpa;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import io.boodskap.iot.DataType;
import io.boodskap.iot.SizeConstants;
import io.boodskap.iot.model.IDynamicMessageField;

@Entity()
@Table(name="dyamicmessagefield")
public class DynamicMessageField extends AbstractStorageObject implements IDynamicMessageField {
	
	private static final long serialVersionUID = -5123999890746243650L;

	@EmbeddedId
    private DynamicMessageFieldId id = new DynamicMessageFieldId();
	
	@Enumerated(EnumType.STRING)
	@Column(name="fdatatype")
	private DataType dataType;
	
	@Column(name="description", length=SizeConstants.DESCRIPTION_SIZE)
	private String description;
	
	@Column(name="tvalue", length=SizeConstants.MESSAGE_FIELD_VALUE_SIZE)
	private String value;
	
	@Column(name="dvalue")
	private Double nvalue;
	
	public DynamicMessageField() {
	}

	public DynamicMessageField(DynamicMessageFieldId id) {
		this.id = id;
	}

	@Override
	public String getName() {
		return id.getName();
	}

	@Override
	public void setName(String name) {
		id.setName(name);
	}

	public String getDomainKey() {
		return id.getDomainKey();
	}

	public void setDomainKey(String domainKey) {
		id.setDomainKey(domainKey);
	}

	public String getSpecId() {
		return id.getSpecId();
	}

	public void setSpecId(String specId) {
		id.setSpecId(specId);
	}

	public String getMessageId() {
		return id.getMessageId();
	}

	public void setMessageId(String messageId) {
		id.setMessageId(messageId);
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
	public String getDescription() {
		return description;
	}

	@Override
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String getValue() {
		return value;
	}

	@Override
	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public Double getNvalue() {
		return nvalue;
	}

	@Override
	public void setNvalue(Double nvalue) {
		this.nvalue = nvalue;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((dataType == null) ? 0 : dataType.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nvalue == null) ? 0 : nvalue.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
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
		DynamicMessageField other = (DynamicMessageField) obj;
		if (dataType != other.dataType)
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nvalue == null) {
			if (other.nvalue != null)
				return false;
		} else if (!nvalue.equals(other.nvalue))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

}
