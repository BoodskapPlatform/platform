package io.boodskap.iot.model.jpa;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import io.boodskap.iot.model.IOfflineStreamSession;

@Entity
@Table(name="offlinestreamsession")
public class OfflineStreamSession extends AbstractModel implements IOfflineStreamSession{
	
	private static final long serialVersionUID = 7582376599201681814L;

	@EmbeddedId
	private OfflineStreamSessionId id = new OfflineStreamSessionId();
	
	public OfflineStreamSession() {
	}

	public OfflineStreamSession(OfflineStreamSessionId id) {
		this.id = id;
	}

	public String getDomainKey() {
		return id.getDomainKey();
	}

	public void setDomainKey(String domainKey) {
		id.setDomainKey(domainKey);
	}

	public String getDeviceId() {
		return id.getDeviceId();
	}

	public void setDeviceId(String deviceId) {
		id.setDeviceId(deviceId);
	}

	public String getSession() {
		return id.getSession();
	}

	public void setSession(String session) {
		id.setSession(session);
	}

	public String getCamera() {
		return id.getCamera();
	}

	public void setCamera(String camera) {
		id.setCamera(camera);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		OfflineStreamSession other = (OfflineStreamSession) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
