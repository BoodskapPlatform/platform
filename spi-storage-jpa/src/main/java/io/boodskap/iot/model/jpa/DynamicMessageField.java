package io.boodskap.iot.model.jpa;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import io.boodskap.iot.model.IDynamicMessageField;

@Entity()
@Table(name="dyamicmessagefield")
public class DynamicMessageField extends AbstractDynamicField implements IDynamicMessageField {
	
	private static final long serialVersionUID = -5123999890746243650L;

	@EmbeddedId
    private DynamicMessageFieldId id = new DynamicMessageFieldId();
	
	public DynamicMessageField() {
	}

	public DynamicMessageField(DynamicMessageFieldId id) {
		this.id = id;
	}

	@Override
	public String getName() {
		return id.getName();
	}

	@Override
	public void setName(String name) {
		id.setName(name);
	}

	public String getDomainKey() {
		return id.getDomainKey();
	}

	public void setDomainKey(String domainKey) {
		id.setDomainKey(domainKey);
	}

	public String getSpecId() {
		return id.getSpecId();
	}

	public void setSpecId(String specId) {
		id.setSpecId(specId);
	}

	public String getMessageId() {
		return id.getMessageId();
	}

	public void setMessageId(String messageId) {
		id.setMessageId(messageId);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		DynamicMessageField other = (DynamicMessageField) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
