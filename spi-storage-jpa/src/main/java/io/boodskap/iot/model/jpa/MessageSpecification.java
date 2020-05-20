package io.boodskap.iot.model.jpa;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import io.boodskap.iot.DataType;
import io.boodskap.iot.StorageException;
import io.boodskap.iot.model.IMessageField;
import io.boodskap.iot.model.IMessageSpecification;
import io.boodskap.iot.spi.storage.jpa.UOW;

@Entity
@Table(name="messagespecification")
public class MessageSpecification implements IMessageSpecification {

	private static final long serialVersionUID = -6916776981959917852L;

	@EmbeddedId
	private MessageSpecificationId id = new MessageSpecificationId();
	
	@Column(name="name", length=80)
	private String name;
	
	@Column(name="description", length=120)
	private String description;
	
	@ElementCollection(targetClass=MessageField.class)
	@OrderBy("name ASC")
	private List<MessageField> fields = new ArrayList<>();
	
	@Column(name="createdstamp")
	private Date createdStamp;
	
	@Column(name="updatedstamp")
	private Date updatedStamp;
	
	public MessageSpecification() {
	}
	
	public MessageSpecification(MessageSpecificationId id) {
		this.id = id;
	}
	
	@Override
	public IMessageField createField(String name, DataType dataType) {
		return new MessageField(name, dataType);
	}

	@Override
	public void addField(IMessageField field) {
		
		try {
			
			final IMessageSpecification oe = IMessageSpecification.find(getDomainKey(), getSpecId());
			
			UOW.begin();

			oe.getFields().add(field);
			
			UOW.commit();
			
		}catch(Exception ex) {
			UOW.rollback();
			throw new StorageException(ex);
		}
	}

	@Override
	public void modifyField(IMessageField field) {
		
		try {
			
			final IMessageSpecification oe = IMessageSpecification.find(getDomainKey(), getSpecId());
			
			UOW.begin();

			IMessageField found = null;
			
			for(IMessageField mf : oe.getFields()) {
				if(mf.getName().equals(field.getName())){
					found = mf;
					break;
				}
			}
			
			if(null == found) throw new StorageException(String.format("field:%s not found", field));
			
			oe.getFields().remove(found);
			
			oe.getFields().add(field);
			
			UOW.commit();
			
		}catch(Exception ex) {
			UOW.rollback();
			throw new StorageException(ex);
		}
	}

	@Override
	public void removeField(String name) {
		
		try {
			
			final IMessageSpecification oe = IMessageSpecification.find(getDomainKey(), getSpecId());
			
			UOW.begin();

			IMessageField found = null;
			
			for(IMessageField mf : oe.getFields()) {
				if(mf.getName().equals(name)){
					found = mf;
					break;
				}
			}
			
			if(null == found) throw new StorageException(String.format("field:%s not found", name));
			
			oe.getFields().remove(found);
			
			UOW.commit();
			
		}catch(Exception ex) {
			UOW.rollback();
			throw new StorageException(ex);
		}
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


	@SuppressWarnings("unchecked")
	@Override
	public <T extends IMessageField> Collection<T> getFields() {
		return (Collection<T>) fields;
	}

	public void setFields(Collection<? extends IMessageField> fields) {
		this.fields.clear();
		getFields().addAll(fields);
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createdStamp == null) ? 0 : createdStamp.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((fields == null) ? 0 : fields.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		if (fields == null) {
			if (other.fields != null)
				return false;
		} else if (!fields.equals(other.fields))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (updatedStamp == null) {
			if (other.updatedStamp != null)
				return false;
		} else if (!updatedStamp.equals(other.updatedStamp))
			return false;
		return true;
	}

}
