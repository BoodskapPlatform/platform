package io.boodskap.iot.model.pojo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import io.boodskap.iot.DataType;
import io.boodskap.iot.model.IMessageField;
import io.boodskap.iot.model.IMessageSpecification;

public class MessageSpecification implements IMessageSpecification {

	private static final long serialVersionUID = -6916776981959917852L;

	private String domainKey;
	private String specId;
	private String name;
	private String description;
	private List<IMessageField> fields = new ArrayList<>();
	private Date createdStamp;
	private Date updatedStamp;
	
	public MessageSpecification() {
	}
	
	public MessageSpecification(String domainKey, String specId) {
		this.domainKey = domainKey;
		this.specId = specId;
	}

	public String getDomainKey() {
		return domainKey;
	}

	public void setDomainKey(String domainKey) {
		this.domainKey = domainKey;
	}

	public String getSpecId() {
		return specId;
	}

	public void setSpecId(String specId) {
		this.specId = specId;
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

	public Collection<IMessageField> getFields() {
		return fields;
	}

	public void setFields(Collection<? extends IMessageField> fields) {
		this.fields.clear();
		this.fields.addAll(fields);
	}

	public Date getCreatedStamp() {
		return createdStamp;
	}

	public void setCreatedStamp(Date createdStamp) {
		this.createdStamp = createdStamp;
	}

	public Date getUpdatedStamp() {
		return updatedStamp;
	}

	public void setUpdatedStamp(Date updatedStamp) {
		this.updatedStamp = updatedStamp;
	}

	@Override
	public IMessageField createField(String name, DataType dataType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addField(IMessageField field) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifyField(IMessageField field) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeField(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createdStamp == null) ? 0 : createdStamp.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((domainKey == null) ? 0 : domainKey.hashCode());
		result = prime * result + ((fields == null) ? 0 : fields.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((specId == null) ? 0 : specId.hashCode());
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
		MessageSpecification other = (MessageSpecification) obj;
		if (createdStamp == null) {
			if (other.createdStamp != null)
				return false;
		} else if (!createdStamp.equals(other.createdStamp))
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
		if (fields == null) {
			if (other.fields != null)
				return false;
		} else if (!fields.equals(other.fields))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (specId == null) {
			if (other.specId != null)
				return false;
		} else if (!specId.equals(other.specId))
			return false;
		if (updatedStamp == null) {
			if (other.updatedStamp != null)
				return false;
		} else if (!updatedStamp.equals(other.updatedStamp))
			return false;
		return true;
	}

}
