package io.boodskap.iot.model.pojo;

import io.boodskap.iot.model.IDeviceFile;
import io.boodskap.iot.model.IFileContent;

public class DeviceFile extends AbstractFile implements IDeviceFile {

	private static final long serialVersionUID = 4313079619831731606L;
	
	private String domainKey;
	private String deviceId;
	private String fileId;
	
	public DeviceFile() {
	}

	public DeviceFile(String domainKey, String deviceId, String fileId) {
		super();
		this.domainKey = domainKey;
		this.deviceId = deviceId;
		this.fileId = fileId;
	}

	@Override
	public IFileContent createContent() {
		return new FileContent(getData(), getMediaType());
	}

	public String getDomainKey() {
		return domainKey;
	}

	public void setDomainKey(String domainKey) {
		this.domainKey = domainKey;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getFileId() {
		return fileId;
	}

	public void setFileId(String fileId) {
		this.fileId = fileId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((deviceId == null) ? 0 : deviceId.hashCode());
		result = prime * result + ((domainKey == null) ? 0 : domainKey.hashCode());
		result = prime * result + ((fileId == null) ? 0 : fileId.hashCode());
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
		if (domainKey == null) {
			if (other.domainKey != null)
				return false;
		} else if (!domainKey.equals(other.domainKey))
			return false;
		if (fileId == null) {
			if (other.fileId != null)
				return false;
		} else if (!fileId.equals(other.fileId))
			return false;
		return true;
	}

}