package io.boodskap.iot.model.pojo;

import java.util.Arrays;

import io.boodskap.iot.model.IFile;
import io.boodskap.iot.model.IFileContent;

public abstract class AbstractFile extends AbstractModel implements IFile {

	private static final long serialVersionUID = 814139036187247697L;

	private String domainKey;
	private String fileId;
	private String mediaType;
	private String tags;
	private byte[] data;
	
	public AbstractFile() {
	}
	
	public AbstractFile(String domainKey, String fileId) {
		this.domainKey = domainKey;
		this.fileId = fileId;
	}
	
	@Override
	public IFileContent createContent() {
		return new FileContent(getData(), getMediaType());
	}

	@Override
	public final String getDomainKey() {
		return domainKey;
	}

	@Override
	public final void setDomainKey(String domainKey) {
		this.domainKey = domainKey;
	}

	public final String getFileId() {
		return fileId;
	}

	public final void setFileId(String fileId) {
		this.fileId = fileId;
	}

	public final byte[] getData() {
		return data;
	}

	public final void setData(byte[] data) {
		this.data = data;
	}

	public final String getMediaType() {
		return mediaType;
	}

	public final void setMediaType(String mediaType) {
		this.mediaType = mediaType;
	}

	public final String getTags() {
		return tags;
	}

	public final void setTags(String tags) {
		this.tags = tags;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Arrays.hashCode(data);
		result = prime * result + ((domainKey == null) ? 0 : domainKey.hashCode());
		result = prime * result + ((fileId == null) ? 0 : fileId.hashCode());
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
