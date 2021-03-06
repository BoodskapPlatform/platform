package io.boodskap.iot.model.jpa;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Lob;
import javax.persistence.MappedSuperclass;

import io.boodskap.iot.SizeConstants;
import io.boodskap.iot.model.IFile;
import io.boodskap.iot.model.IFileContent;

@MappedSuperclass
public abstract class AbstractFile extends AbstractModel implements IFile {

	private static final long serialVersionUID = 814139036187247697L;

	@Column(name="mediatype", length=40)
	private String mediaType;
	
	@Column(name="tags", length=200)
	private String tags;

	@Lob
	@Column(name="data", length=SizeConstants.FILE_SIZE)
	private byte[] data;
	
	public AbstractFile() {
	}
	
	@Override
	public IFileContent createContent() {
		return new FileContent(getData(), getMediaType());
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Arrays.hashCode(data);
		result = prime * result + ((mediaType == null) ? 0 : mediaType.hashCode());
		result = prime * result + ((tags == null) ? 0 : tags.hashCode());
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
		AbstractFile other = (AbstractFile) obj;
		if (!Arrays.equals(data, other.data))
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
		return true;
	}

}
