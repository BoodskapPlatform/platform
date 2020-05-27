package io.boodskap.iot.model.pojo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import io.boodskap.iot.NotificationStatus;
import io.boodskap.iot.model.IProgress;
import io.boodskap.iot.model.IResponse;
import io.boodskap.iot.model.ISentNotification;

public abstract class AbstractSentNotification extends AbstractDomainObject implements ISentNotification {

	private static final long serialVersionUID = 315874349873688242L;

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

	@Override
	public IProgress createProgress(String content) {
		return new Progress(content);
	}

	@Override
	public IResponse createResponse(String content) {
		Response r = new Response();
		r.setContent(content);
		return r;
	}

	@Override
	public final String getNotificationId() {
		return notificationId;
	}

	@Override
	public final void setNotificationId(String notificationId) {
		this.notificationId = notificationId;
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
	public final String getReceipent() {
		return receipent;
	}

	@Override
	public final void setReceipent(String receipent) {
		this.receipent = receipent;
	}

	@Override
	public final String getSubject() {
		return subject;
	}

	@Override
	public final void setSubject(String subject) {
		this.subject = subject;
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
	public final List<IResponse> getResponse() {
		return response;
	}

	@Override
	public final void setResponse(Collection<? extends IResponse> response) {
		this.response.clear();
		this.response.addAll(response);
	}

	@Override
	public final List<IProgress> getProgress() {
		return progress;
	}

	@Override
	public final void setProgress(Collection<? extends IProgress> progress) {
		this.progress.clear();
		this.progress.addAll(progress);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((content == null) ? 0 : content.hashCode());
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
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		AbstractSentNotification other = (AbstractSentNotification) obj;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
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
