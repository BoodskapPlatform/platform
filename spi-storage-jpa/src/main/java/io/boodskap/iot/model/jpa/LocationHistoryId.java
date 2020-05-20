package io.boodskap.iot.model.jpa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import io.boodskap.iot.EntityType;

@Embeddable
public class LocationHistoryId extends LocationId implements Serializable {
	
	private static final long serialVersionUID = 8792483937404118872L;

	@Column(name="historyid", length=40)
	private String historyId;

	public LocationHistoryId() {
	}

	public LocationHistoryId(String domainKey, EntityType entityType, String entityId, String historyId) {
		super(domainKey, entityType, entityId);
		this.historyId = historyId;
	}

	public String getHistoryId() {
		return historyId;
	}

	public void setHistoryId(String historyId) {
		this.historyId = historyId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((historyId == null) ? 0 : historyId.hashCode());
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
		LocationHistoryId other = (LocationHistoryId) obj;
		if (historyId == null) {
			if (other.historyId != null)
				return false;
		} else if (!historyId.equals(other.historyId))
			return false;
		return true;
	}

}
