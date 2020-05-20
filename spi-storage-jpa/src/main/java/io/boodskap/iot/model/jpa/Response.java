package io.boodskap.iot.model.jpa;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Lob;

import io.boodskap.iot.model.IResponse;

@Embeddable
public class Response implements IResponse {
	
	private static final long serialVersionUID = 5905446293522785788L;
	
	@Column(name="stamp")
	private Date stamp;
	
	@Lob
	@Column(name="content", length=4096)
	private String content;

	public Response() {
	}

	public Response(String content) {
		this.content = content;
		this.stamp = new Date();
	}

	@Override
	public Date getStamp() {
		return stamp;
	}

	@Override
	public void setStamp(Date stamp) {
		this.stamp = stamp;
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((stamp == null) ? 0 : stamp.hashCode());
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
		Response other = (Response) obj;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (stamp == null) {
			if (other.stamp != null)
				return false;
		} else if (!stamp.equals(other.stamp))
			return false;
		return true;
	}

}
