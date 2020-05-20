package io.boodskap.iot.model.jpa;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.EmbeddedId;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;
import javax.persistence.OrderBy;

import io.boodskap.iot.NotificationStatus;
import io.boodskap.iot.SizeConstants;
import io.boodskap.iot.model.IProgress;
import io.boodskap.iot.model.IResponse;
import io.boodskap.iot.model.ISentNotification;

@MappedSuperclass
public abstract class AbstractSentNotification implements ISentNotification {

	private static final long serialVersionUID = 315874349873688242L;

	@EmbeddedId
	private SentNotificationId id = new SentNotificationId();
	
	@Column(name="content", length=SizeConstants.NOTIFICATION_CONTENT_SIZE)
	private String content;
	
	@Column(name="subject", length=120)
	private String subject;
	
	@Column(name="receipent", length=SizeConstants.EMAIL_ID_SIZE)
	private String receipent;
	
	@Column(name="queuedat")
	private Date queuedAt;
	
	@Column(name="sentat")
	private Date sentAt;
	
	@Enumerated(EnumType.STRING)
	@Column(name="status", length=20)
	private NotificationStatus status;

	@ElementCollection(targetClass=Response.class)
	@OrderBy("stamp DESC")
	private List<Response> response = new ArrayList<>();
	
	@ElementCollection(targetClass=Progress.class)
	@OrderBy("stamp DESC")
	private List<Progress> progress = new ArrayList<>();
	

	public AbstractSentNotification() {
	}

	public AbstractSentNotification(SentNotificationId id) {
		this.id = id;
	}

	@Override
	public String getDomainKey() {
		return id.getDomainKey();
	}

	@Override
	public void setDomainKey(String domainKey) {
		id.setDomainKey(domainKey);
	}

	@Override
	public String getNotificationId() {
		return id.getNotificationId();
	}

	@Override
	public void setNotificationId(String notificationId) {
		id.setNotificationId(notificationId);
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

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Response> getResponse() {
		return response;
	}

	@Override
	public void setResponse(Collection<? extends IResponse> response) {
		this.response.clear();
		response.forEach(r ->{this.response.add((Response) r);});
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Progress> getProgress() {
		return progress;
	}

	@Override
	public void setProgress(Collection<? extends IProgress> progress) {
		this.progress.clear();
		progress.forEach(p ->{this.progress.add((Progress) p);});
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
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
