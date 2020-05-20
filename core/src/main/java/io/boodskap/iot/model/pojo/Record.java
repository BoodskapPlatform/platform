package io.boodskap.iot.model.pojo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;


import io.boodskap.iot.model.IDynamicRecordField;
import io.boodskap.iot.model.IRecord;

public class Record implements IRecord {
	
	private static final long serialVersionUID = -8983111494193420302L;

	private String domainKey;
	private String specId;
	private String recordId;
	private Date createdStamp = new Date();
	private List<IDynamicRecordField> fields = new ArrayList<>();

	public Record() {
	}

	public Record(String domainKey, String specId, String recordId) {
		super();
		this.domainKey = domainKey;
		this.specId = specId;
		this.recordId = recordId;
	}

	@Override
	public IDynamicRecordField createField(String name) {
		return new DynamicRecordField(domainKey, specId, recordId, name);
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

	public String getRecordId() {
		return recordId;
	}

	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}

	@Override
	public Date getCreatedStamp() {
		return createdStamp;
	}

	@Override
	public void setCreatedStamp(Date createdStamp) {
		this.createdStamp = createdStamp;
	}

	@Override
	public List<IDynamicRecordField> getFields() {
		return fields;
	}

	@Override
	public void setFields(Collection<? extends IDynamicRecordField> data) {
		this.fields.clear();
		this.fields.addAll(data);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createdStamp == null) ? 0 : createdStamp.hashCode());
		result = prime * result + ((domainKey == null) ? 0 : domainKey.hashCode());
		result = prime * result + ((fields == null) ? 0 : fields.hashCode());
		result = prime * result + ((recordId == null) ? 0 : recordId.hashCode());
		result = prime * result + ((specId == null) ? 0 : specId.hashCode());
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
		Record other = (Record) obj;
		if (createdStamp == null) {
			if (other.createdStamp != null)
				return false;
		} else if (!createdStamp.equals(other.createdStamp))
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
		if (recordId == null) {
			if (other.recordId != null)
				return false;
		} else if (!recordId.equals(other.recordId))
			return false;
		if (specId == null) {
			if (other.specId != null)
				return false;
		} else if (!specId.equals(other.specId))
			return false;
		return true;
	}

}
