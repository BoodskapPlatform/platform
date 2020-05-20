package io.boodskap.iot.model.pojo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import io.boodskap.iot.NotificationStatus;
import io.boodskap.iot.model.IProgress;
import io.boodskap.iot.model.IResponse;
import io.boodskap.iot.model.ISentNotification;

public abstract class AbstractSentNotification implements ISentNotification {

	private static final long serialVersionUID = 315874349873688242L;

	private String domainKey;
	private String notificationId;
	private String content;
	private String subject;
	private String receipent;
	private Date queuedAt;
	private Date sentAt;
	private NotificationStatus status;
	private List<IResponse> response = new ArrayList<>();
	private List<IProgress> progress = new ArrayList<>();
	

	public AbstractSentNotification() {
	}

	public AbstractSentNotification(String domainKey, String notificationId) {
		super();
		this.domainKey = domainKey;
		this.notificationId = notificationId;
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
	public String getReceipent() {
		return receipent;
	}

	@Override
	public void setReceipent(String receipent) {
		this.receipent = receipent;
	}

	@Override
	public String getSubject() {
		return subject;
	}

	@Override
	public void setSubject(String subject) {
		this.subject = subject;
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
	public List<IResponse> getResponse() {
		return response;
	}

	@Override
	public void setResponse(Collection<? extends IResponse> response) {
		this.response.clear();
		this.response.addAll(response);
	}

	@Override
	public List<IProgress> getProgress() {
		return progress;
	}

	@Override
	public void setProgress(Collection<? extends IProgress> progress) {
		this.progress.clear();
		this.progress.addAll(progress);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((domainKey == null) ? 0 : domainKey.hashCode());
		result = prime * result + ((notificationId == null) ? 0 : notificationId.hashCode());
		result = prime * result + ((progress == null) ? 0 : progress.hashCode());
		result = prime * result + ((queuedAt == null) ? 0 : queuedAt.hashCode());
		result = prime * result + ((receipent == null) ? 0 : receipent.hashCode());
		result = prime * result + ((response == null) ? 0 : response.hashCode());
		result = prime * result + ((sentAt == null) ? 0 : sentAt.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((subject == null) ? 0 : subject.hashCode());
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
		AbstractSentNotification other = (AbstractSentNotification) obj;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (domainKey == null) {
			if (other.domainKey != null)
				return false;
		} else if (!domainKey.equals(other.domainKey))
			return false;
		if (notificationId == null) {
			if (other.notificationId != null)
				return false;
		} else if (!notificationId.equals(other.notificationId))
			return false;
		if (progress == null) {
			if (other.progress != null)
				return false;
		} else if (!progress.equals(other.progress))
			return false;
		if (queuedAt == null) {
			if (other.queuedAt != null)
				return false;
		} else if (!queuedAt.equals(other.queuedAt))
			return false;
		if (receipent == null) {
			if (other.receipent != null)
				return false;
		} else if (!receipent.equals(other.receipent))
			return false;
		if (response == null) {
			if (other.response != null)
				return false;
		} else if (!response.equals(other.response))
			return false;
		if (sentAt == null) {
			if (other.sentAt != null)
				return false;
		} else if (!sentAt.equals(other.sentAt))
			return false;
		if (status != other.status)
			return false;
		if (subject == null) {
			if (other.subject != null)
				return false;
		} else if (!subject.equals(other.subject))
			return false;
		return true;
	}

}
