package io.boodskap.iot.model.pojo;


import io.boodskap.iot.model.ISentFCM;

public class SentFCM extends AbstractSentNotification implements ISentFCM {

	private static final long serialVersionUID = 9200540936799580385L;
	
	private String fcmToken;
	private String deviceId;
	private boolean notification;

	public SentFCM() {
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
