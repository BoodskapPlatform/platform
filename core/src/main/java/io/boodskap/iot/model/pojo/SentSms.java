package io.boodskap.iot.model.pojo;


import io.boodskap.iot.model.ISentSms;

public class SentSms extends AbstractSentNotification implements ISentSms {
	
	private static final long serialVersionUID = 8636999403237422067L;
	
	private String sendor;
	private String sid;

	public SentSms() {
	}

	public SentSms(String domainKey, String notificationId) {
		super(domainKey, notificationId);
	}

	@Override
	public String getSendor() {
		return sendor;
	}

	@Override
	public void setSendor(String sendor) {
		this.sendor = sendor;
	}

	@Override
	public String getSid() {
		return sid;
	}

	@Override
	public void setSid(String sid) {
		this.sid = sid;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((sendor == null) ? 0 : sendor.hashCode());
		result = prime * result + ((sid == null) ? 0 : sid.hashCode());
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
		SentSms other = (SentSms) obj;
		if (sendor == null) {
			if (other.sendor != null)
				return false;
		} else if (!sendor.equals(other.sendor))
			return false;
		if (sid == null) {
			if (other.sid != null)
				return false;
		} else if (!sid.equals(other.sid))
			return false;
		return true;
	}
	
}
