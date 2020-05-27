package io.boodskap.iot.model.jpa;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

import io.boodskap.iot.model.IOfflineStream;

@Entity
@Table(name="offlinestream")
public class OfflineStream extends AbstractModel implements IOfflineStream{
	
	private static final long serialVersionUID = 5693040931326424173L;

	@EmbeddedId
	private OfflineStreamId id = new OfflineStreamId();
	
	@Column(name="mime", length=30)
	private String mime;
	
	@Column(name="data", length=4194304)
	@Lob
	private byte[] data;
	
	@Column(name="stamp")
	private Date stamp;
	
	public OfflineStream() {
	}

	public OfflineStream(OfflineStreamId id) {
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

	public int getFrame() {
		return id.getFrame();
	}

	public void setFrame(int frame) {
		id.setFrame(frame);
	}

	public String getCamera() {
		return id.getCamera();
	}

	public void setCamera(String camera) {
		id.setCamera(camera);
	}

	public Date getStamp() {
		return stamp;
	}

	public void setStamp(Date stamp) {
		this.stamp = stamp;
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
		int result = super.hashCode();
		result = prime * result + Arrays.hashCode(data);
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((mime == null) ? 0 : mime.hashCode());
		result = prime * result + ((stamp == null) ? 0 : stamp.hashCode());
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
		OfflineStream other = (OfflineStream) obj;
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
		if (stamp == null) {
			if (other.stamp != null)
				return false;
		} else if (!stamp.equals(other.stamp))
			return false;
		return true;
	}

}
