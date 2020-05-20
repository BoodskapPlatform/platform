package io.boodskap.iot.model.pojo;


import io.boodskap.iot.model.ISentVoice;

public class SentVoice extends AbstractSentNotification implements ISentVoice {

	private static final long serialVersionUID = -1559870996837697167L;

	private String sendor;
	private String sid;

	public SentVoice() {
	}

	public SentVoice(String domainKey, String notificationId) {
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
		SentVoice other = (SentVoice) obj;
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
