package io.boodskap.iot.model.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import io.boodskap.iot.DataFormat;
import io.boodskap.iot.model.ISystemProperty;

@Entity
@Table(name="systemproperty")
public class SystemProperty extends AbstractEntity implements ISystemProperty {

	private static final long serialVersionUID = -3731879336825133100L;

	@Id
	@Column(name="name", length=80)
	private String name;
	
	@Lob
	@Column(name="value", length=131072)
	private String value = null;
	
	@Column(name="format", length=8)
	@Enumerated(EnumType.STRING)
	private DataFormat format;

	public SystemProperty() {
	}
	
	public SystemProperty(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getValue() {
		return value;
	}

	@Override
	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public DataFormat getFormat() {
		return format;
	}

	@Override
	public void setFormat(DataFormat format) {
		this.format = format;
	}

}
