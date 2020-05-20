package io.boodskap.iot.model.jpa;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import io.boodskap.iot.model.IOutgoingSms;

@Entity
@Table(name="outgoingsms")
public class OutgoingSms extends AbstractNotification implements IOutgoingSms {
	
	private static final long serialVersionUID = 4834103119405543197L;
	
	@EmbeddedId
	private OutgoingSmsId id = new OutgoingSmsId();

	public OutgoingSms() {
	}

	public OutgoingSms(OutgoingSmsId id) {
		this.id = id;
	}

	public String getDomainKey() {
		return id.getDomainKey();
	}

	public void setDomainKey(String domainKey) {
		id.setDomainKey(domainKey);
	}


	public String getNotificationId() {
		return id.getNotificationId();
	}

	public void setNotificationId(String notificationId) {
		id.setNotificationId(notificationId);
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
		OutgoingSms other = (OutgoingSms) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
