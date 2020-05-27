package io.boodskap.iot.model.pojo;

import io.boodskap.iot.model.IDynamicRecordField;

public class DynamicRecordField extends AbstractDynamicField implements IDynamicRecordField {
	
	private static final long serialVersionUID = 8101500765559308203L;

	private String specId;
	private String recordId;
	
	public DynamicRecordField() {
	}

	public DynamicRecordField(String domainKey, String specId, String recordId, String name) {
		setDomainKey(domainKey);
		this.specId = specId;
		this.recordId = recordId;
		setName(name);
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
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((recordId == null) ? 0 : recordId.hashCode());
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
		DynamicRecordField other = (DynamicRecordField) obj;
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
