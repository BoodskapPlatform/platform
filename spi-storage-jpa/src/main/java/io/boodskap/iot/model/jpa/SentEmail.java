package io.boodskap.iot.model.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

import io.boodskap.iot.SizeConstants;
import io.boodskap.iot.model.IProgress;
import io.boodskap.iot.model.IResponse;
import io.boodskap.iot.model.ISentEmail;

@Entity()
@Table(name="sentemail")
public class SentEmail extends AbstractSentNotification implements ISentEmail {
	
	private static final long serialVersionUID = -7639602103472259608L;
	
	@Column(name="sendor", length=SizeConstants.EMAIL_ID_SIZE)
	private String sendor;

	@Lob
	@Column(name="htmlcontent", length=SizeConstants.NOTIFICATION_HTML_CONTENT_SIZE)
	private String htmlContent;

	@Column(name="dsresolrver", length=256)
	private String dsResolrver;
	
	public SentEmail() {
	}

	public SentEmail(SentNotificationId id) {
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
	public String getHtmlContent() {
		return htmlContent;
	}

	@Override
	public void setHtmlContent(String htmlContent) {
		this.htmlContent = htmlContent;
	}

	@Override
	public String getDsResolrver() {
		return dsResolrver;
	}

	@Override
	public void setDsResolrver(String dsResolrver) {
		this.dsResolrver = dsResolrver;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((dsResolrver == null) ? 0 : dsResolrver.hashCode());
		result = prime * result + ((htmlContent == null) ? 0 : htmlContent.hashCode());
		result = prime * result + ((sendor == null) ? 0 : sendor.hashCode());
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
		SentEmail other = (SentEmail) obj;
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
		if (sendor == null) {
			if (other.sendor != null)
				return false;
		} else if (!sendor.equals(other.sendor))
			return false;
		return true;
	}
	
}
