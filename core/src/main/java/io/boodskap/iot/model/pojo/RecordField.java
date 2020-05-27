package io.boodskap.iot.model.pojo;


import io.boodskap.iot.DataType;
import io.boodskap.iot.model.IRecordField;

public class RecordField extends MessageField implements IRecordField {

	private static final long serialVersionUID = 2617723620254661858L;

	public RecordField(){
	}

	public RecordField(String field, DataType dataType) {
		setName(field);
		setDataType(dataType);
	}

}
