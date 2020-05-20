package io.boodskap.iot.model.jpa;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

import io.boodskap.iot.model.IOfflineSnap;

@Entity
@Table(name="offlinesnap")
public class OfflineSnap implements IOfflineSnap {

	private static final long serialVersionUID = 1074590347354679901L;
	
	@EmbeddedId
	private OfflineSnapId id = new OfflineSnapId();
	
	@Column(name="mime", length=30)
	private String mime;
	
	@Column(name="data", length=4194304)
	@Lob
	private byte[] data;
	
	public OfflineSnap() {
	}

	public OfflineSnap(OfflineSnapId id) {
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

	public String getCamera() {
		return id.getCamera();
	}

	public void setCamera(String camera) {
		id.setCamera(camera);
	}

	public Date getStamp() {
		return id.getStamp();
	}

	public void setStamp(Date stamp) {
		id.setStamp(stamp);
	}

	public String getMime() {
		return mime;
	}

	public void setMime(String mime) {
		this.mime = mime;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(data);
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((mime == null) ? 0 : mime.hashCode());
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
		OfflineSnap other = (OfflineSnap) obj;
		if (!Arrays.equals(data, other.data))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (mime == null) {
			if (other.mime != null)
				return false;
		} else if (!mime.equals(other.mime))
			return false;
		return true;
	}

}
