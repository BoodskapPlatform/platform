package io.boodskap.iot.model.jpa;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import io.boodskap.iot.model.IDynamicRecordField;

@Entity()
@Table(name="dynamicrecordfield")
public class DynamicRecordField extends AbstractDynamicField implements IDynamicRecordField {
	
	private static final long serialVersionUID = 8101500765559308203L;

	@EmbeddedId
    private DynamicRecordFieldId id = new DynamicRecordFieldId();
	
	public DynamicRecordField() {
	}

	public DynamicRecordField(DynamicRecordFieldId id) {
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

	public String getRecordId() {
		return id.getRecordId();
	}

	public void setRecordId(String recordId) {
		id.setRecordId(recordId);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		DynamicRecordField other = (DynamicRecordField) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
