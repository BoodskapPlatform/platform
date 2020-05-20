package io.boodskap.iot.model.pojo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import io.boodskap.iot.NotificationStatus;
import io.boodskap.iot.model.INotification;
import io.boodskap.iot.model.IResponse;

public abstract class AbstractNotification implements INotification{

	private static final long serialVersionUID = -78399951798565586L;

	private String domainKey;
	private String notificationId;
	private String sendor;
	private String content;
	private NotificationStatus status;
	private Date queuedAt;
	private Date sentAt;
	private List<String> receipents = new ArrayList<>();
	private List<IResponse> response = new ArrayList<>();
	
	public AbstractNotification() {
	}

	public AbstractNotification(String domainKey, String notificationId) {
		this.domainKey = domainKey;
		this.notificationId = notificationId;
	}

	@Override
	public String getDomainKey() {
		return domainKey;
	}

	@Override
	public void setDomainKey(String domainKey) {
		this.domainKey = domainKey;
	}

	@Override
	public String getNotificationId() {
		return notificationId;
	}

	@Override
	public void setNotificationId(String notificationId) {
		this.notificationId = notificationId;
	}

	@Override
	public Date getQueuedAt() {
		return queuedAt;
	}

	@Override
	public void setQueuedAt(Date queuedAt) {
		this.queuedAt = queuedAt;
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
	public String getContent() {
		return content;
	}

	@Override
	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public NotificationStatus getStatus() {
		return status;
	}

	@Override
	public void setStatus(NotificationStatus status) {
		this.status = status;
	}

	@Override
	public Date getSentAt() {
		return sentAt;
	}

	@Override
	public void setSentAt(Date sentAt) {
		this.sentAt = sentAt;
	}

	@Override
	public List<String> getReceipents() {
		return receipents;
	}

	@Override
	public void setReceipents(Collection<String> receipents) {
		this.receipents.clear();
		this.receipents.addAll(receipents);
	}

	@Override
	public List<IResponse> getResponse() {
		return response;
	}

	@Override
	public void setResponse(Collection<? extends IResponse> response) {
		this.response.clear();
		this.response.addAll(response);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		if (obj == null)
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
