package io.boodskap.iot.model.pojo;

import java.util.Date;

import io.boodskap.iot.model.IOfflineSnap;

public class OfflineSnap implements IOfflineSnap {

	private static final long serialVersionUID = 1074590347354679901L;
	
	private String domainKey;
	private String deviceId;
	private String camera;
	private Date stamp;
	private String mime;
	private byte[] data;
	
	public OfflineSnap() {
	}

	public OfflineSnap(String domainKey, String deviceId, String camera, Date stamp) {
		this.domainKey = domainKey;
		this.deviceId = deviceId;
		this.camera = camera;
		this.stamp = stamp;
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

	public String getCamera() {
		return camera;
	}

	public void setCamera(String camera) {
		this.camera = camera;
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

}
