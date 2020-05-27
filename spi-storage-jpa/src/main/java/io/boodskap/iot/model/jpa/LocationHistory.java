package io.boodskap.iot.model.jpa;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import io.boodskap.iot.EntityType;
import io.boodskap.iot.model.ILocationHistory;

@Entity
@Table(name="locationhistory")
public class LocationHistory extends AbstractModel implements ILocationHistory {

	private static final long serialVersionUID = 1968767691318484921L;

	@EmbeddedId
	private LocationHistoryId id = new LocationHistoryId();
	
	@Column(name="latitude")
	private double latitude;
	
	@Column(name="longitude")
	private double longitude;
	
	public LocationHistory() {
	}

	public LocationHistory(LocationHistoryId id) {
		this.id = id;
	}

	public String getDomainKey() {
		return id.getDomainKey();
	}

	public void setDomainKey(String domainKey) {
		id.setDomainKey(domainKey);
	}

	public String getEntityId() {
		return id.getEntityId();
	}

	public void setEntityId(String entityId) {
		id.setEntityId(entityId);
	}

	public String getHistoryId() {
		return id.getHistoryId();
	}

	public void setHistoryId(String historyId) {
		id.setHistoryId(historyId);
	}

	public EntityType getEntityType() {
		return id.getEntityType();
	}

	public void setEntityType(EntityType entityType) {
		id.setEntityType(entityType);
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		long temp;
		temp = Double.doubleToLongBits(latitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(longitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		LocationHistory other = (LocationHistory) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (Double.doubleToLongBits(latitude) != Double.doubleToLongBits(other.latitude))
			return false;
		if (Double.doubleToLongBits(longitude) != Double.doubleToLongBits(other.longitude))
			return false;
		return true;
	}

}
