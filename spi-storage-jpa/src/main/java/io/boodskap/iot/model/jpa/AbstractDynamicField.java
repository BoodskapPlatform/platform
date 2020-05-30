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

	public final String getValue() {
		return value;
	}

	public final void setValue(String value) {
		this.value = value;
	}

	public final Double getNvalue() {
		return nvalue;
	}

	public final void setNvalue(Double nvalue) {
		this.nvalue = nvalue;
	}

}
