package io.boodskap.iot.model.jpa;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
public class MessageSpecification extends AbstractModel implements IMessageSpecification {

	private static final long serialVersionUID = -6916776981959917852L;

	@EmbeddedId
	private MessageSpecificationId id = new MessageSpecificationId();
	
	@ElementCollection(targetClass=MessageField.class)
	@OrderBy("name ASC")
	private List<MessageField> fields = new ArrayList<>();
	
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

	@SuppressWarnings("unchecked")
	@Override
	public <T extends IMessageField> Collection<T> getFields() {
		return (Collection<T>) fields;
	}

	public void setFields(Collection<? extends IMessageField> fields) {
		this.fields.clear();
		getFields().addAll(fields);
	}

}
