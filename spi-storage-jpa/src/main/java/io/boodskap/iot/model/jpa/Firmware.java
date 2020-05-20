package io.boodskap.iot.model.jpa;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

import io.boodskap.iot.SizeConstants;
import io.boodskap.iot.model.IFirmware;

@Entity
@Table(name="firmware")
public class Firmware implements IFirmware{

	private static final long serialVersionUID = -567102980753132760L;

	@EmbeddedId
	private FirmwareId id = new FirmwareId();
	
	@Column(name="description", length=SizeConstants.DESCRIPTION_SIZE)
	private String description;
	
	@Column(name="filename", length=120)
	private String fileName;
	
	@Column(name="contenttype", length=80)
	private String contentType;
	
	@Column(name="createdstamp")
	private Date createdStamp;
	
	@Column(name="updatedstamp")
	private Date updatedStamp;
	
	@Lob
	@Column(name="content", length=SizeConstants.FIRMWARE_SIZE)
	private byte[] content;

	public Firmware() {
	}

	public Firmware(FirmwareId id) {
		this.id = id;
	}

	public Firmware(String deviceModel, String version, String description, String fileName, String contentType, Date createdStamp, Date updatedStamp) {
		
		this.description = description;
		this.fileName = fileName;
		this.contentType = contentType;
		this.createdStamp = createdStamp;
		this.updatedStamp = updatedStamp;
		
		setDeviceModel(deviceModel);
		setVersion(version);
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

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public byte[] getContent() {
		return content;
	}

	public void setContent(byte[] content) {
		this.content = content;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(content);
		result = prime * result + ((contentType == null) ? 0 : contentType.hashCode());
		result = prime * result + ((createdStamp == null) ? 0 : createdStamp.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((fileName == null) ? 0 : fileName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((updatedStamp == null) ? 0 : updatedStamp.hashCode());
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
		Firmware other = (Firmware) obj;
		if (!Arrays.equals(content, other.content))
			return false;
		if (contentType == null) {
			if (other.contentType != null)
				return false;
		} else if (!contentType.equals(other.contentType))
			return false;
		if (createdStamp == null) {
			if (other.createdStamp != null)
				return false;
		} else if (!createdStamp.equals(other.createdStamp))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (fileName == null) {
			if (other.fileName != null)
				return false;
		} else if (!fileName.equals(other.fileName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (updatedStamp == null) {
			if (other.updatedStamp != null)
				return false;
		} else if (!updatedStamp.equals(other.updatedStamp))
			return false;
		return true;
	}

}
