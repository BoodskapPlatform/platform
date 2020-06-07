package io.boodskap.iot.model.jpa;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import io.boodskap.iot.SizeConstants;
import io.boodskap.iot.model.IModel;

@MappedSuperclass
public abstract class AbstractModel extends AbstractEntity implements IModel {

	private static final long serialVersionUID = 1356450075893904988L;
	
	@Column(name="name", length=SizeConstants.NAME_SIZE)
	private String name;

	public AbstractModel() {
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
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		AbstractModel other = (AbstractModel) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
