package io.boodskap.iot.model.pojo;

import java.util.Date;

import io.boodskap.iot.model.IProgress;

public class Progress implements IProgress {
	
	private static final long serialVersionUID = 2747446673053336905L;

	private Date stamp;
	private String content;

	public Progress() {
	}

	public Progress(String content) {
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
		Progress other = (Progress) obj;
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
