package io.boodskap.iot.model.jpa;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;

import io.boodskap.iot.DataFormat;
import io.boodskap.iot.SizeConstants;
import io.boodskap.iot.model.IStorable;

@MappedSuperclass
public abstract class AbstractStorable implements IStorable {

	private static final long serialVersionUID = -100247674973438772L;

	@Column(name="label", length=80)
	private String label = null;

	@Column(name="description", length=SizeConstants.DESCRIPTION_SIZE)
	private String description = null;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
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
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
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
