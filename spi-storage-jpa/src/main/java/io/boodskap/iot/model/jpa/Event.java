package io.boodskap.iot.model.jpa;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import io.boodskap.iot.model.IEvent;

@Entity
@Table(name="event")
public class Event extends AbstractModel implements IEvent {

	private static final long serialVersionUID = -9017353632495955259L;

	@EmbeddedId
	private EventId id = new EventId();
	
	@Column(name="content", length=1024)
	private String content;
	
	@Column(name="subject", length=120)
	private String subject;
	
	@Column(name="ctemplate", length=40)
	private String contentTemplate;
	
	@Column(name="stemplate", length=40)
	private String subjectTemplate;
	
	public Event() {
	}

	public Event(EventId id) {
		this.id = id;
	}

	public String getDomainKey() {
		return id.getDomainKey();
	}

	public void setDomainKey(String domainKey) {
		id.setDomainKey(domainKey);
	}

	public String getEventId() {
		return id.getEventId();
	}

	public void setEventId(String eventId) {
		id.setEventId(eventId);
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContentTemplate() {
		return contentTemplate;
	}

	public void setContentTemplate(String contentTemplate) {
		this.contentTemplate = contentTemplate;
	}

	public String getSubjectTemplate() {
		return subjectTemplate;
	}

	public void setSubjectTemplate(String subjectTemplate) {
		this.subjectTemplate = subjectTemplate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((contentTemplate == null) ? 0 : contentTemplate.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((subject == null) ? 0 : subject.hashCode());
		result = prime * result + ((subjectTemplate == null) ? 0 : subjectTemplate.hashCode());
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
		Event other = (Event) obj;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (contentTemplate == null) {
			if (other.contentTemplate != null)
				return false;
		} else if (!contentTemplate.equals(other.contentTemplate))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (subject == null) {
			if (other.subject != null)
				return false;
		} else if (!subject.equals(other.subject))
			return false;
		if (subjectTemplate == null) {
			if (other.subjectTemplate != null)
				return false;
		} else if (!subjectTemplate.equals(other.subjectTemplate))
			return false;
		return true;
	}

}
