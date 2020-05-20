package io.boodskap.iot.model.jpa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class RawMessageId implements Serializable {
	
	private static final long serialVersionUID = 4033569971177247423L;

	@Column(name="domainkey", length=16)
	private String domainKey;

	@Column(name="rawid", length=40)
	private String rawId;

	public RawMessageId() {
	}

	public RawMessageId(String domainKey, String rawId) {
		this.domainKey = domainKey;
		this.rawId = rawId;
	}

	public String getDomainKey() {
		return domainKey;
	}

	public void setDomainKey(String domainKey) {
		this.domainKey = domainKey;
	}

	public String getRawId() {
		return rawId;
	}

	public void setRawId(String rawId) {
		this.rawId = rawId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((domainKey == null) ? 0 : domainKey.hashCode());
		result = prime * result + ((rawId == null) ? 0 : rawId.hashCode());
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
		RawMessageId other = (RawMessageId) obj;
		if (domainKey == null) {
			if (other.domainKey != null)
				return false;
		} else if (!domainKey.equals(other.domainKey))
			return false;
		if (rawId == null) {
			if (other.rawId != null)
				return false;
		} else if (!rawId.equals(other.rawId))
			return false;
		return true;
	}

}
