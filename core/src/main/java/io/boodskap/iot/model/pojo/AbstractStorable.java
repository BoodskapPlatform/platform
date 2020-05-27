package io.boodskap.iot.model.pojo;

import io.boodskap.iot.DataFormat;
import io.boodskap.iot.DataType;
import io.boodskap.iot.model.IStorable;

public abstract class AbstractStorable extends AbstractDomainObject implements IStorable {

	private static final long serialVersionUID = -100247674973438772L;

	private String label = null;
	private DataType dataType = null;
	private DataFormat format = null;
	
	public AbstractStorable() {
	}

	public final DataType getDataType() {
		return dataType;
	}

	public final void setDataType(DataType dataType) {
		this.dataType = dataType;
	}

	public final DataFormat getFormat() {
		return format;
	}

	public final void setFormat(DataFormat format) {
		this.format = format;
	}

	public final String getLabel() {
		return label;
	}

	public final void setLabel(String label) {
		this.label = label;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataType == null) ? 0 : dataType.hashCode());
		result = prime * result + ((format == null) ? 0 : format.hashCode());
		result = prime * result + ((label == null) ? 0 : label.hashCode());
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
		AbstractStorable other = (AbstractStorable) obj;
		if (dataType != other.dataType)
			return false;
		if (format != other.format)
			return false;
		if (label == null) {
			if (other.label != null)
				return false;
		} else if (!label.equals(other.label))
			return false;
		return true;
	}

}
