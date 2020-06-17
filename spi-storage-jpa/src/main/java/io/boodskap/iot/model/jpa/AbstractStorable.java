package io.boodskap.iot.model.jpa;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;

import io.boodskap.iot.DataFormat;
import io.boodskap.iot.model.IStorable;

@MappedSuperclass
public abstract class AbstractStorable extends AbstractModel implements IStorable {

	private static final long serialVersionUID = -100247674973438772L;

	@Column(name="label", length=80)
	private String label = null;

	@Enumerated(EnumType.STRING)
	@Column(name="format", length=10)
	private DataFormat format = null;
	
	public AbstractStorable() {
	}

	public DataFormat getFormat() {
		return format;
	}

	public void setFormat(DataFormat format) {
		this.format = format;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((format == null) ? 0 : format.hashCode());
		result = prime * result + ((label == null) ? 0 : label.hashCode());
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
		AbstractStorable other = (AbstractStorable) obj;
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
