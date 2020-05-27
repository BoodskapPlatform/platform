package io.boodskap.iot.model.jpa;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

import io.boodskap.iot.SizeConstants;
import io.boodskap.iot.model.IFirmware;

@Entity
@Table(name="firmware")
public class Firmware extends AbstractModel implements IFirmware{

	private static final long serialVersionUID = -567102980753132760L;

	@EmbeddedId
	private FirmwareId id = new FirmwareId();
	
	@Column(name="filename", length=120)
	private String fileName;
	
	@Lob
	@Column(name="data", length=SizeConstants.FILE_SIZE)
	private byte[] data;
	
	@Column(name="mediatype", length=80)
	private String mediaType;

	public Firmware() {
	}

	public Firmware(FirmwareId id) {
		this.id = id;
	}

	public String getDomainKey() {
		return id.getDomainKey();
	}

	public void setDomainKey(String domainKey) {
		id.setDomainKey(domainKey);
	}

	public String getDeviceModel() {
		return id.getDeviceModel();
	}

	public void setDeviceModel(String deviceModel) {
		id.setDeviceModel(deviceModel);
	}

	public String getVersion() {
		return id.getVersion();
	}

	public void setVersion(String version) {
		id.setVersion(version);
	}

	public String getFileName() {
		return fileName;
	}

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
