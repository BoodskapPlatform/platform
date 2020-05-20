package io.boodskap.iot.model.jpa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class AlexaId implements Serializable {
	
	private static final long serialVersionUID = -4718642536107892651L;

	@Column(name="domainkey", length=16)
	private String domainKey;

	@Column(name="alexaid", length=40)
	private String alexaId;

	public AlexaId() {
	}

	public AlexaId(String domainKey, String alexaId) {
		super();
		this.domainKey = domainKey;
		this.alexaId = alexaId;
	}

	public String getDomainKey() {
		return domainKey;
	}

	public void setDomainKey(String domainKey) {
		this.domainKey = domainKey;
	}

	public String getAlexaId() {
		return alexaId;
	}

	public void setAlexaId(String alexaId) {
		this.alexaId = alexaId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alexaId == null) ? 0 : alexaId.hashCode());
		result = prime * result + ((domainKey == null) ? 0 : domainKey.hashCode());
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
		AlexaId other = (AlexaId) obj;
		if (alexaId == null) {
			if (other.alexaId != null)
				return false;
		} else if (!alexaId.equals(other.alexaId))
			return false;
		if (domainKey == null) {
			if (other.domainKey != null)
				return false;
		} else if (!domainKey.equals(other.domainKey))
			return false;
		return true;
	}

}
