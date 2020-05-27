package io.boodskap.iot.model.jpa;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.MappedSuperclass;
import javax.persistence.OrderBy;

import io.boodskap.iot.NotificationStatus;
import io.boodskap.iot.SizeConstants;
import io.boodskap.iot.model.INotification;
import io.boodskap.iot.model.IResponse;

@MappedSuperclass
public abstract class AbstractNotification extends AbstractModel implements INotification{

	private static final long serialVersionUID = -78399951798565586L;

	@Column(name="sendor", length=80)
	private String sendor;

	@Column(name="content", length=SizeConstants.NOTIFICATION_CONTENT_SIZE)
	private String content;

	@Column(name="status", length=18)
	private NotificationStatus status;

	@Column(name="queuedat")
	private Date queuedAt;

	@Column(name="sentat")
	private Date sentAt;

	@ElementCollection(targetClass=String.class)
	@Column(name="receipents", length=80)
	private List<String> receipents = new ArrayList<>();

	@ElementCollection(targetClass=Response.class)
	@OrderBy("stamp DESC")
	private List<Response> response = new ArrayList<>();
	
	public AbstractNotification() {
	}

	@Override
	public final Date getQueuedAt() {
		return queuedAt;
	}

	@Override
	public final void setQueuedAt(Date queuedAt) {
		this.queuedAt = queuedAt;
	}

	@Override
	public final String getSendor() {
		return sendor;
	}

	@Override
	public final void setSendor(String sendor) {
		this.sendor = sendor;
	}

	@Override
	public final String getContent() {
		return content;
	}

	@Override
	public final void setContent(String content) {
		this.content = content;
	}

	@Override
	public final NotificationStatus getStatus() {
		return status;
	}

	@Override
	public final void setStatus(NotificationStatus status) {
		this.status = status;
	}

	@Override
	public final Date getSentAt() {
		return sentAt;
	}

	@Override
	public final void setSentAt(Date sentAt) {
		this.sentAt = sentAt;
	}

	@Override
	public final List<String> getReceipents() {
		return receipents;
	}

	@Override
	public final void setReceipents(Collection<String> receipents) {
		this.receipents.clear();
		this.receipents.addAll(receipents);
	}

	@SuppressWarnings("unchecked")
	@Override
	public final Collection<Response> getResponse() {
		return response;
	}

	@Override
	public final void setResponse(Collection<? extends IResponse> response) {
		this.response.clear();
		response.forEach(r -> {this.response.add((Response) r);});
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((queuedAt == null) ? 0 : queuedAt.hashCode());
		result = prime * result + ((receipents == null) ? 0 : receipents.hashCode());
		result = prime * result + ((response == null) ? 0 : response.hashCode());
		result = prime * result + ((sendor == null) ? 0 : sendor.hashCode());
		result = prime * result + ((sentAt == null) ? 0 : sentAt.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		AbstractNotification other = (AbstractNotification) obj;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (queuedAt == null) {
			if (other.queuedAt != null)
				return false;
		} else if (!queuedAt.equals(other.queuedAt))
			return false;
		if (receipents == null) {
			if (other.receipents != null)
				return false;
		} else if (!receipents.equals(other.receipents))
			return false;
		if (response == null) {
			if (other.response != null)
				return false;
		} else if (!response.equals(other.response))
			return false;
		if (sendor == null) {
			if (other.sendor != null)
				return false;
		} else if (!sendor.equals(other.sendor))
			return false;
		if (sentAt == null) {
			if (other.sentAt != null)
				return false;
		} else if (!sentAt.equals(other.sentAt))
			return false;
		if (status != other.status)
			return false;
		return true;
	}

}
