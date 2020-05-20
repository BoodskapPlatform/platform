package io.boodskap.iot.model.jpa;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import io.boodskap.iot.model.IOutgoingFCM;

@Entity
@Table(name="outgoingfcm")
public class OutgoingFCM extends AbstractNotification implements IOutgoingFCM {

	private static final long serialVersionUID = -3703003914352564498L;

	@EmbeddedId
	private OutgoingFCMId id = new OutgoingFCMId();

	@Column(name="fcmtoken", length=200)
	private String fcmToken;
	
	@Column(name="deviceid", length=40)
	private String deviceId;

	@Column(name="subject", length=120)
	private String subject;
	
	@Column(name="notification")
	private boolean notification;
	
	public OutgoingFCM() {
	}

	public OutgoingFCM(OutgoingFCMId id) {
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

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getFcmToken() {
		return fcmToken;
	}

	public void setFcmToken(String fcmToken) {
		this.fcmToken = fcmToken;
	}

	public boolean isNotification() {
		return notification;
	}

	public void setNotification(boolean notification) {
		this.notification = notification;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((deviceId == null) ? 0 : deviceId.hashCode());
		result = prime * result + ((fcmToken == null) ? 0 : fcmToken.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + (notification ? 1231 : 1237);
		result = prime * result + ((subject == null) ? 0 : subject.hashCode());
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
		OutgoingFCM other = (OutgoingFCM) obj;
		if (deviceId == null) {
			if (other.deviceId != null)
				return false;
		} else if (!deviceId.equals(other.deviceId))
			return false;
		if (fcmToken == null) {
			if (other.fcmToken != null)
				return false;
		} else if (!fcmToken.equals(other.fcmToken))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (notification != other.notification)
			return false;
		if (subject == null) {
			if (other.subject != null)
				return false;
		} else if (!subject.equals(other.subject))
			return false;
		return true;
	}

}
