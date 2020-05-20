package io.boodskap.iot.model.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import io.boodskap.iot.model.IProgress;
import io.boodskap.iot.model.IResponse;
import io.boodskap.iot.model.ISentFCM;

@Entity()
@Table(name="sentfcm")
public class SentFCM extends AbstractSentNotification implements ISentFCM {

	private static final long serialVersionUID = 9200540936799580385L;
	
	@Column(name="fcmtoken", length=200)
	private String fcmToken;
	
	@Column(name="deviceid", length=40)
	private String deviceId;

	@Column(name="notification")
	private boolean notification;

	public SentFCM() {
	}

	public SentFCM(SentNotificationId id) {
		super(id);
	}

	@Override
	public IProgress createProgress(String content) {
		return new Progress(content);
	}

	@Override
	public IResponse createResponse(String content) {
		return new Response(content);
	}

@Override
	public String getDeviceId() {
		return deviceId;
	}

	@Override
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	@Override
	public String getFcmToken() {
		return fcmToken;
	}

	@Override
	public void setFcmToken(String fcmToken) {
		this.fcmToken = fcmToken;
	}

	@Override
	public boolean isNotification() {
		return notification;
	}

	@Override
	public void setNotification(boolean notification) {
		this.notification = notification;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((deviceId == null) ? 0 : deviceId.hashCode());
		result = prime * result + ((fcmToken == null) ? 0 : fcmToken.hashCode());
		result = prime * result + (notification ? 1231 : 1237);
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
		SentFCM other = (SentFCM) obj;
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
		if (notification != other.notification)
			return false;
		return true;
	}

}
