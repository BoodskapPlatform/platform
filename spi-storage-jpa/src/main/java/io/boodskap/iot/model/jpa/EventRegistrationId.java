package io.boodskap.iot.model.jpa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import io.boodskap.iot.NotificationChannel;


@Embeddable
public class EventRegistrationId implements Serializable {
	
	private static final long serialVersionUID = -2958563263258858553L;

	@Column(name="domainkey", length=16)
	private String domainKey;

	@Column(name="eventid", length=40)
	private String eventId;

	@Column(name="channel", length=12)
	@Enumerated(EnumType.STRING)
	private NotificationChannel channel;

	@Column(name="toaddress", length=120)
	private String toAddress;
	
	public EventRegistrationId() {
	}

	public EventRegistrationId(String domainKey, String eventId, NotificationChannel channel, String toAddress) {
		this.domainKey = domainKey;
		this.eventId = eventId;
		this.channel = channel;
		this.toAddress = toAddress;
	}

	public String getDomainKey() {
		return domainKey;
	}

	public void setDomainKey(String domainKey) {
		this.domainKey = domainKey;
	}

	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public String getToAddress() {
		return toAddress;
	}

	public void setToAddress(String toAddress) {
		this.toAddress = toAddress;
	}

	public NotificationChannel getChannel() {
		return channel;
	}

	public void setChannel(NotificationChannel channel) {
		this.channel = channel;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((channel == null) ? 0 : channel.hashCode());
		result = prime * result + ((domainKey == null) ? 0 : domainKey.hashCode());
		result = prime * result + ((eventId == null) ? 0 : eventId.hashCode());
		result = prime * result + ((toAddress == null) ? 0 : toAddress.hashCode());
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
		EventRegistrationId other = (EventRegistrationId) obj;
		if (channel != other.channel)
			return false;
		if (domainKey == null) {
			if (other.domainKey != null)
				return false;
		} else if (!domainKey.equals(other.domainKey))
			return false;
		if (eventId == null) {
			if (other.eventId != null)
				return false;
		} else if (!eventId.equals(other.eventId))
			return false;
		if (toAddress == null) {
			if (other.toAddress != null)
				return false;
		} else if (!toAddress.equals(other.toAddress))
			return false;
		return true;
	}

}
