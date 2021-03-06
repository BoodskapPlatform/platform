package io.boodskap.iot.model.pojo;

import io.boodskap.iot.model.IDeviceFile;
import io.boodskap.iot.model.IFileContent;

public class DeviceFile extends AbstractFile implements IDeviceFile {

	private static final long serialVersionUID = 4313079619831731606L;
	
	private String deviceId;
	
	public DeviceFile() {
	}

	@Override
	public IFileContent createContent() {
		return new FileContent(getData(), getMediaType());
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((deviceId == null) ? 0 : deviceId.hashCode());
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
		DeviceFile other = (DeviceFile) obj;
		if (deviceId == null) {
			if (other.deviceId != null)
				return false;
		} else if (!deviceId.equals(other.deviceId))
			return false;
		return true;
	}

}
