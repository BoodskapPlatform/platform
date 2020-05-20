package io.boodskap.iot.model.jpa;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import io.boodskap.iot.NotificationChannel;
import io.boodskap.iot.model.IEventRegistration;

@Entity
@Table(name="eventregistration")
public class EventRegistration implements IEventRegistration {

	private static final long serialVersionUID = -5660582348900463445L;
	
	@EmbeddedId
	private EventRegistrationId id = new EventRegistrationId();

	@Column(name="createdstamp")
	private Date createdStamp;
	
	public EventRegistration() {
	}

	public EventRegistration(EventRegistrationId id) {
		this.id = id;
	}

	public String getDomainKey() {
		return id.getDomainKey();
	}

	public void setDomainKey(String domainKey) {
		id.setDomainKey(domainKey);
	}

	public NotificationChannel getChannel() {
		return id.getChannel();
	}

	public void setChannel(NotificationChannel channel) {
		id.setChannel(channel);
	}

	public String getEventId() {
		return id.getEventId();
	}

	public void setEventId(String eventId) {
		id.setEventId(eventId);
	}

	public String getToAddress() {
		return id.getToAddress();
	}

	public void setToAddress(String toAddress) {
		id.setToAddress(toAddress);
	}

	public Date getCreatedStamp() {
		return createdStamp;
	}

	public void setCreatedStamp(Date createdStamp) {
		this.createdStamp = createdStamp;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createdStamp == null) ? 0 : createdStamp.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		EventRegistration other = (EventRegistration) obj;
		if (createdStamp == null) {
			if (other.createdStamp != null)
				return false;
		} else if (!createdStamp.equals(other.createdStamp))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
