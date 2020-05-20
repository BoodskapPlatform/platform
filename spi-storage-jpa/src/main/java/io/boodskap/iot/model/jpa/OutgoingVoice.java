package io.boodskap.iot.model.jpa;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import io.boodskap.iot.model.IOutgoingVoice;

@Entity
@Table(name="outgoingvoice")
public class OutgoingVoice extends AbstractNotification implements IOutgoingVoice {

	private static final long serialVersionUID = 6192727903980944149L;
	
	@EmbeddedId
	private OutgoingVoiceId id = new OutgoingVoiceId();

	public OutgoingVoice() {
	}

	public OutgoingVoice(OutgoingVoiceId id) {
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
		OutgoingVoice other = (OutgoingVoice) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
