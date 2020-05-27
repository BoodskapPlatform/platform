package io.boodskap.iot.model.pojo;

import io.boodskap.iot.model.IFirmware;

public class Firmware extends AbstractDomainObject implements IFirmware{

	private static final long serialVersionUID = 7075552397693223013L;
	
	private String deviceModel;
	private String version;
	private String fileName;
	private byte[] data;
	private String mediaType;
	
	public Firmware() {
	}

	@Override
	public String getDeviceModel() {
		return deviceModel;
	}

	@Override
	public void setDeviceModel(String deviceModel) {
		this.deviceModel = deviceModel;
	}

	@Override
	public String getVersion() {
		return version;
	}

	@Override
	public void setVersion(String version) {
		this.version = version;
	}

	@Override
	public String getFileName() {
		return fileName;
	}

	@Override
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public byte[] getData() {
		return data;
	}

	@Override
	public void setData(byte[] data) {
		this.data = data;
	}

	@Override
	public String getMediaType() {
		return mediaType;
	}

	@Override
	public void setMediaType(String mediaType) {
		this.mediaType = mediaType;
	}

}
