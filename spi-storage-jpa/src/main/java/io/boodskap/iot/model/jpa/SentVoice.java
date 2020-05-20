package io.boodskap.iot.model.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import io.boodskap.iot.model.IProgress;
import io.boodskap.iot.model.IResponse;
import io.boodskap.iot.model.ISentVoice;

@Entity()
@Table(name="sentvoice")
public class SentVoice extends AbstractSentNotification implements ISentVoice {

	private static final long serialVersionUID = -1559870996837697167L;

	@Column(name="sendor", length=20)
	private String sendor;
	
	@Column(name="sid", length=80)
	private String sid;

	public SentVoice() {
	}

	public SentVoice(SentNotificationId id) {
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
