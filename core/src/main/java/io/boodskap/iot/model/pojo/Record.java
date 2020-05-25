package io.boodskap.iot.model.pojo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import io.boodskap.iot.model.IDynamicRecordField;
import io.boodskap.iot.model.IRecord;

public class Record extends AbstractDomainObject implements IRecord {
	
	private static final long serialVersionUID = -8983111494193420302L;

	private String specId;
	private String recordId;
	private List<IDynamicRecordField> fields = new ArrayList<>();

	public Record() {
	}

	@Override
	public IDynamicRecordField createField(String name) {
		return new DynamicRecordField(getDomainKey(), specId, recordId, name);
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
	public List<IDynamicRecordField> getFields() {
		return fields;
	}

	@Override
	public void setFields(Collection<? extends IDynamicRecordField> data) {
		this.fields.clear();
		this.fields.addAll(data);
	}

}
