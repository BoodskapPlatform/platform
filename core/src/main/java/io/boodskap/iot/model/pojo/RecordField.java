package io.boodskap.iot.model.pojo;


import io.boodskap.iot.DataType;
import io.boodskap.iot.model.IRecordField;

public class RecordField extends AbstractDomainObject implements IRecordField {

	private static final long serialVersionUID = 2617723620254661858L;

	private DataType dataType;
	private boolean indexed;
	private boolean fulltextIndexed;
	
	public RecordField(){
	}

	public RecordField(String field, DataType dataType) {
		setName(field);
		setDataType(dataType);
	}

	public DataType getDataType() {
		return dataType;
	}

	public void setDataType(DataType dataType) {
		this.dataType = dataType;
	}

	public boolean isIndexed() {
		return indexed;
	}

	public void setIndexed(boolean indexed) {
		this.indexed = indexed;
	}

	public boolean isFulltextIndexed() {
		return fulltextIndexed;
	}

	public void setFulltextIndexed(boolean fulltextIndexed) {
		this.fulltextIndexed = fulltextIndexed;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((dataType == null) ? 0 : dataType.hashCode());
		result = prime * result + (fulltextIndexed ? 1231 : 1237);
		result = prime * result + (indexed ? 1231 : 1237);
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
		RecordField other = (RecordField) obj;
		if (dataType != other.dataType)
			return false;
		if (fulltextIndexed != other.fulltextIndexed)
			return false;
		if (indexed != other.indexed)
			return false;
		return true;
	}

}
