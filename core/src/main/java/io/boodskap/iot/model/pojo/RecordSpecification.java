package io.boodskap.iot.model.pojo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import io.boodskap.iot.DataType;
import io.boodskap.iot.model.IRecordField;
import io.boodskap.iot.model.IRecordSpecification;

public class RecordSpecification extends AbstractDomainObject implements IRecordSpecification {

	private static final long serialVersionUID = -9178896999115174213L;

	private String specId;
	private List<IRecordField> fields = new ArrayList<>();
	
	public RecordSpecification() {
	}

	@Override
	public IRecordField createField(String field, DataType dataType) {
		return new RecordField(field, dataType);
	}

	public String getSpecId() {
		return specId;
	}

	public void setSpecId(String specId) {
		this.specId = specId;
	}

	public List<IRecordField> getFields() {
		return fields;
	}

	public void setFields(Collection<? extends IRecordField> fields) {
		this.fields.clear();
		this.fields.addAll(fields);
	}

	@Override
	public void addField(IRecordField field) {
		fields.add(field);
	}

	@Override
	public void modifyField(IRecordField field) {
		
		int ridx = -1;
		
		for(int i=0;i<fields.size();i++) {
			if(fields.get(i).getName().equals(field.getName())) {
				ridx = i;
			}
		}
		
		if(ridx != -1) {
			fields.remove(ridx);
		}
		
		fields.add(field);
	}

	@Override
	public void removeField(String name) {
		
		int ridx = -1;
		
		for(int i=0;i<fields.size();i++) {
			if(fields.get(i).getName().equals(name)) {
				ridx = i;
			}
		}
		
		if(ridx != -1) {
			fields.remove(ridx);
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((fields == null) ? 0 : fields.hashCode());
		result = prime * result + ((specId == null) ? 0 : specId.hashCode());
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
		RecordSpecification other = (RecordSpecification) obj;
		if (fields == null) {
			if (other.fields != null)
				return false;
		} else if (!fields.equals(other.fields))
			return false;
		if (specId == null) {
			if (other.specId != null)
				return false;
		} else if (!specId.equals(other.specId))
			return false;
		return true;
	}

}
