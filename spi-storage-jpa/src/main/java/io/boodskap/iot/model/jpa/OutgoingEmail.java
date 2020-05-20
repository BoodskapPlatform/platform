package io.boodskap.iot.model.jpa;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import io.boodskap.iot.model.IOutgoingEmail;

@Entity
@Table(name="outgoingemail")
public class OutgoingEmail extends AbstractNotification implements IOutgoingEmail {
	
	private static final long serialVersionUID = -2330227229380125805L;

	@EmbeddedId
	private OutgoingEmailId id = new OutgoingEmailId();
	
	@Column(name="subject", length=120)
	private String subject;
	
	@Column(name="htmlcontent", length=4096)
	private String htmlContent;
	
	@Column(name="dsresolver", length=240)
	private String dsResolrver;
	
	public OutgoingEmail() {
	}

	public OutgoingEmail(OutgoingEmailId id) {
		this.id = id;
	}

	public String getDomainKey() {
		return id.getDomainKey();
	}

	public void setDomainKey(String domainKey) {
		id.setDomainKey(domainKey);
	}

	public String getNotificationId() {
		return id.getNotificationId();
	}

	public void setNotificationId(String notificationId) {
		id.setNotificationId(notificationId);
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getHtmlContent() {
		return htmlContent;
	}

	public void setHtmlContent(String htmlContent) {
		this.htmlContent = htmlContent;
	}

	public String getDsResolrver() {
		return dsResolrver;
	}

	public void setDsResolrver(String dsResolrver) {
		this.dsResolrver = dsResolrver;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((dsResolrver == null) ? 0 : dsResolrver.hashCode());
		result = prime * result + ((htmlContent == null) ? 0 : htmlContent.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		OutgoingEmail other = (OutgoingEmail) obj;
		if (dsResolrver == null) {
			if (other.dsResolrver != null)
				return false;
		} else if (!dsResolrver.equals(other.dsResolrver))
			return false;
		if (htmlContent == null) {
			if (other.htmlContent != null)
				return false;
		} else if (!htmlContent.equals(other.htmlContent))
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
		return true;
	}

}
