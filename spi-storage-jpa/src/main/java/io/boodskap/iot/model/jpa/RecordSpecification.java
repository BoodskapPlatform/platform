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
import io.boodskap.iot.model.IRecordField;
import io.boodskap.iot.model.IRecordSpecification;
import io.boodskap.iot.spi.storage.jpa.UOW;

@Entity()
@Table(name="recordspecification")
public class RecordSpecification extends AbstractModel implements IRecordSpecification {

	private static final long serialVersionUID = -9178896999115174213L;

	@EmbeddedId
	private RecordSpecificationId id = new RecordSpecificationId();
	
	@ElementCollection(targetClass=RecordField.class)
	@OrderBy("name ASC")
	private List<RecordField> fields = new ArrayList<>();
	
	public RecordSpecification() {
	}

	public RecordSpecification(RecordSpecificationId id) {
		this.id = id;
	}

	@Override
	public IRecordField createField(String field, DataType dataType) {
		RecordField f = new RecordField();
		f.setName(field);
		f.setDataType(dataType);
		return f;
	}

	@Override
	public void addField(IRecordField field) {
		
		try {
			
			final IRecordSpecification oe = IRecordSpecification.find(getDomainKey(), getSpecId());
			
			UOW.begin();

			oe.getFields().add(field);
			
			UOW.commit();
			
		}catch(Exception ex) {
			UOW.rollback();
			throw new StorageException(ex);
		}
	}

	@Override
	public void modifyField(IRecordField field) {
		
		try {
			
			final IRecordSpecification oe = IRecordSpecification.find(getDomainKey(), getSpecId());
			
			UOW.begin();

			IRecordField found = null;
			
			for(IRecordField mf : oe.getFields()) {
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
			
			final IRecordSpecification oe = IRecordSpecification.find(getDomainKey(), getSpecId());
			
			UOW.begin();

			IRecordField found = null;
			
			for(IRecordField mf : oe.getFields()) {
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
	public Collection<RecordField> getFields() {
		return fields;
	}

	public void setFields(Collection<? extends IRecordField> fields) {
		this.fields.clear();
		fields.forEach(r -> { this.fields.add((RecordField) r); });
	}

}
