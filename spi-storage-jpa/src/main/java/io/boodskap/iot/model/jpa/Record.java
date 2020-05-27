package io.boodskap.iot.model.jpa;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import io.boodskap.iot.model.IDynamicRecordField;
import io.boodskap.iot.model.IRecord;

@Entity()
@Table(name="record")
public class Record extends AbstractModel implements IRecord {
	
	private static final long serialVersionUID = -8983111494193420302L;

	@EmbeddedId
	private RecordId id = new RecordId();
	
	@OneToMany(
			targetEntity=DynamicRecordField.class,
	        cascade = CascadeType.ALL,
	        orphanRemoval = true
	 )
	 private List<DynamicRecordField> fields = new ArrayList<>();

	public Record() {
	}

	public Record(RecordId id) {
		this.id = id;
	}

	@Override
	public IDynamicRecordField createField(String name) {
		return new DynamicRecordField(new DynamicRecordFieldId(id.getDomainKey(), id.getSpecId(), id.getRecordId(), name));
	}

	@Override
	public String getDomainKey() {
		return id.getDomainKey();
	}

	@Override
	public void setDomainKey(String domainKey) {
		id.setDomainKey(domainKey);
	}

	@Override
	public String getRecordId() {
		return id.getRecordId();
	}

	@Override
	public void setRecordId(String recordId) {
		id.setRecordId(recordId);
	}

	@Override
	public String getSpecId() {
		return id.getSpecId();
	}

	@Override
	public void setSpecId(String specId) {
		id.setSpecId(specId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<DynamicRecordField> getFields() {
		return fields;
	}

	@Override
	public void setFields(Collection<? extends IDynamicRecordField> data) {
		this.fields.clear();
		data.forEach(d ->{
			DynamicRecordField f = (DynamicRecordField)d;
			this.fields.add(f);
		});
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((fields == null) ? 0 : fields.hashCode());
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
		Record other = (Record) obj;
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
		return true;
	}

}
