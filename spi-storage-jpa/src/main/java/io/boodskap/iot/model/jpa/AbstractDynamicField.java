package io.boodskap.iot.model.jpa;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import io.boodskap.iot.SizeConstants;
import io.boodskap.iot.model.IDynamicField;

@MappedSuperclass
public abstract class AbstractDynamicField extends AbstractField implements IDynamicField {
	
	private static final long serialVersionUID = 8521375450218976930L;

	@Column(name="tvalue", length=SizeConstants.MESSAGE_FIELD_VALUE_SIZE)
	private String value;
	
	@Column(name="dvalue")
	private Double nvalue;
	
	public AbstractDynamicField() {
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Double getNvalue() {
		return nvalue;
	}

	public void setNvalue(Double nvalue) {
		this.nvalue = nvalue;
	}

}
