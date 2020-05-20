package io.boodskap.iot.model.pojo;

import java.util.Date;

import io.boodskap.iot.EntityType;
import io.boodskap.iot.model.ILocationHistory;

public class LocationHistory  implements ILocationHistory {

	private static final long serialVersionUID = 1968767691318484921L;

	private String domainKey;
	private String entityId;
	private String historyId;
	private EntityType entityType;
	private double latitude;
	private double longitude;
	private Date createdStamp;
	private Date updatedStamp;
	
	public LocationHistory() {
	}

	public LocationHistory(String domainKey, String entityId, String historyId, EntityType entityType) {
		this.domainKey = domainKey;
		this.entityId = entityId;
		this.historyId = historyId;
		this.entityType = entityType;
	}

	public String getDomainKey() {
		return domainKey;
	}

	public void setDomainKey(String domainKey) {
		this.domainKey = domainKey;
	}

	public String getEntityId() {
		return entityId;
	}

	public void setEntityId(String entityId) {
		this.entityId = entityId;
	}

	public String getHistoryId() {
		return historyId;
	}

	public void setHistoryId(String historyId) {
		this.historyId = historyId;
	}

	public EntityType getEntityType() {
		return entityType;
	}

	public void setEntityType(EntityType entityType) {
		this.entityType = entityType;
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

	public Date getCreatedStamp() {
		return createdStamp;
	}

	public void setCreatedStamp(Date createdStamp) {
		this.createdStamp = createdStamp;
	}

	public Date getUpdatedStamp() {
		return updatedStamp;
	}

	public void setUpdatedStamp(Date updatedStamp) {
		this.updatedStamp = updatedStamp;
	}

}
