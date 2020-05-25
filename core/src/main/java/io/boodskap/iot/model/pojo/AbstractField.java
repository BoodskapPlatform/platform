package io.boodskap.iot.model.pojo;

import io.boodskap.iot.DataType;
import io.boodskap.iot.model.IField;

public abstract class AbstractField extends AbstractModel implements IField {

	private static final long serialVersionUID = -7398949474866288452L;
	
	private DataType type;
	
	public AbstractField() {
	}

	@Override
	public DataType getDataType() {
		return type;
	}

	@Override
	public void setDataType(DataType type) {
		this.type = type;
	}

}
