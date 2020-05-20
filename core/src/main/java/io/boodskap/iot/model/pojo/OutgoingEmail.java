package io.boodskap.iot.model.pojo;


import io.boodskap.iot.model.IOutgoingEmail;

public class OutgoingEmail extends AbstractNotification implements IOutgoingEmail {
	
	private static final long serialVersionUID = -2330227229380125805L;

	private String subject;
	private String htmlContent;
	private String dsResolrver;
	
	public OutgoingEmail() {
	}

	public OutgoingEmail(String domainKey, String notificationId) {
		super(domainKey, notificationId);
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
		if (subject == null) {
			if (other.subject != null)
				return false;
		} else if (!subject.equals(other.subject))
			return false;
		return true;
	}

}
