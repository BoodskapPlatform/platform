package io.boodskap.iot.model.jpa;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Lob;

import io.boodskap.iot.SizeConstants;
import io.boodskap.iot.model.IFileContent;

@Embeddable
public class FileContent implements IFileContent {
	
	private static final long serialVersionUID = 2834539513803785961L;

	@Lob
	@Column(name="data", length=SizeConstants.FILE_SIZE)
	private byte[] data;
	
	@Column(name="mediatype", length=80)
	private String mediaType;

	public FileContent() {
	}

	public FileContent(byte[] data, String mediaType) {
		
		if(null != data) {
			this.data = new byte[data.length];
			System.arraycopy(data, 0, this.data, 0, data.length);
		}
		
		this.mediaType = mediaType;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(data);
		result = prime * result + ((mediaType == null) ? 0 : mediaType.hashCode());
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
		FileContent other = (FileContent) obj;
		if (!Arrays.equals(data, other.data))
			return false;
		if (mediaType == null) {
			if (other.mediaType != null)
				return false;
		} else if (!mediaType.equals(other.mediaType))
			return false;
		return true;
	}

}
