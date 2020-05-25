package io.boodskap.iot.model.pojo;

import java.util.Arrays;

import io.boodskap.iot.model.IOfflineStream;

public class OfflineStream extends AbstractDomainObject implements IOfflineStream{
	
	private static final long serialVersionUID = 5693040931326424173L;

	private String deviceId;
	private String camera;
	private String session;
	private int frame;
	private String mime;
	private byte[] data;
	
	public OfflineStream() {
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getCamera() {
		return camera;
	}

	public void setCamera(String camera) {
		this.camera = camera;
	}

	public String getSession() {
		return session;
	}

	public void setSession(String session) {
		this.session = session;
	}

	public int getFrame() {
		return frame;
	}

	public void setFrame(int frame) {
		this.frame = frame;
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
		result = prime * result + ((camera == null) ? 0 : camera.hashCode());
		result = prime * result + Arrays.hashCode(data);
		result = prime * result + ((deviceId == null) ? 0 : deviceId.hashCode());
		result = prime * result + frame;
		result = prime * result + ((mime == null) ? 0 : mime.hashCode());
		result = prime * result + ((session == null) ? 0 : session.hashCode());
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
		if (camera == null) {
			if (other.camera != null)
				return false;
		} else if (!camera.equals(other.camera))
			return false;
		if (!Arrays.equals(data, other.data))
			return false;
		if (deviceId == null) {
			if (other.deviceId != null)
				return false;
		} else if (!deviceId.equals(other.deviceId))
			return false;
		if (frame != other.frame)
			return false;
		if (mime == null) {
			if (other.mime != null)
				return false;
		} else if (!mime.equals(other.mime))
			return false;
		if (session == null) {
			if (other.session != null)
				return false;
		} else if (!session.equals(other.session))
			return false;
		return true;
	}

}
