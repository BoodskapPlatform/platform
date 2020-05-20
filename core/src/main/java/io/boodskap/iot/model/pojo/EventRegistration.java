package io.boodskap.iot.model.pojo;

import java.util.Date;


import io.boodskap.iot.NotificationChannel;
import io.boodskap.iot.model.IEventRegistration;

public class EventRegistration implements IEventRegistration {

	private static final long serialVersionUID = -5660582348900463445L;
	
	private String domainKey;
	private NotificationChannel channel;
	private String eventId;
	private String toAddress;
	private Date createdStamp;
	
	public EventRegistration() {
	}

	public EventRegistration(String domainKey, NotificationChannel channel, String eventId, String toAddress) {
		this.domainKey = domainKey;
		this.channel = channel;
		this.eventId = eventId;
		this.toAddress = toAddress;
	}

	public String getDomainKey() {
		return domainKey;
	}

	public void setDomainKey(String domainKey) {
		this.domainKey = domainKey;
	}

	public NotificationChannel getChannel() {
		return channel;
	}

	public void setChannel(NotificationChannel channel) {
		this.channel = channel;
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

	public Date getCreatedStamp() {
		return createdStamp;
	}

	public void setCreatedStamp(Date createdStamp) {
		this.createdStamp = createdStamp;
	}

}
