package io.boodskap.iot.model.jpa;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Lob;
import javax.persistence.MappedSuperclass;

import io.boodskap.iot.SizeConstants;
import io.boodskap.iot.model.IFile;

@MappedSuperclass
public abstract class AbstractFile implements IFile {

	private static final long serialVersionUID = 814139036187247697L;

	@Column(name="description", length=SizeConstants.DESCRIPTION_SIZE)
	private String description;

	@Column(name="mediatype", length=40)
	private String mediaType;
	
	@Column(name="tags", length=200)
	private String tags;

	@Lob
	@Column(name="data", length=SizeConstants.FILE_SIZE)
	private byte[] data;
	
	@Column(name="createdstamp")
	private Date createdStamp;
	
	@Column(name="updatedstamp")
	private Date updatedStamp;
	
	public AbstractFile() {
	}
	
	public AbstractFile(String description, String mediaType, String tags, Date createdStamp, Date updatedStamp) {
		this.description = description;
		this.mediaType = mediaType;
		this.tags = tags;
		this.createdStamp = createdStamp;
		this.updatedStamp = updatedStamp;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public String getMediaType() {
		return mediaType;
	}

	public void setMediaType(String mediaType) {
		this.mediaType = mediaType;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createdStamp == null) ? 0 : createdStamp.hashCode());
		result = prime * result + Arrays.hashCode(data);
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((mediaType == null) ? 0 : mediaType.hashCode());
		result = prime * result + ((tags == null) ? 0 : tags.hashCode());
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
		AbstractFile other = (AbstractFile) obj;
		if (createdStamp == null) {
			if (other.createdStamp != null)
				return false;
		} else if (!createdStamp.equals(other.createdStamp))
			return false;
		if (!Arrays.equals(data, other.data))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (mediaType == null) {
			if (other.mediaType != null)
				return false;
		} else if (!mediaType.equals(other.mediaType))
			return false;
		if (tags == null) {
			if (other.tags != null)
				return false;
		} else if (!tags.equals(other.tags))
			return false;
		if (updatedStamp == null) {
			if (other.updatedStamp != null)
				return false;
		} else if (!updatedStamp.equals(other.updatedStamp))
			return false;
		return true;
	}

}
