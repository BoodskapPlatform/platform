package io.boodskap.iot.model.jpa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class GroovyArchiveFileId implements Serializable {

	private static final long serialVersionUID = 3275498314576195099L;

	@Column(name = "loader", length = 40)
	private String loader;
	
	@Column(name = "filename", length = 256)
	private String fileName;
	
	public GroovyArchiveFileId() {
	}

	public GroovyArchiveFileId(String loader, String fileName) {
		super();
		this.loader = loader;
		this.fileName = fileName;
	}

	public String getLoader() {
		return loader;
	}

	public void setLoader(String loader) {
		this.loader = loader;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fileName == null) ? 0 : fileName.hashCode());
		result = prime * result + ((loader == null) ? 0 : loader.hashCode());
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
		GroovyArchiveFileId other = (GroovyArchiveFileId) obj;
		if (fileName == null) {
			if (other.fileName != null)
				return false;
		} else if (!fileName.equals(other.fileName))
			return false;
		if (loader == null) {
			if (other.loader != null)
				return false;
		} else if (!loader.equals(other.loader))
			return false;
		return true;
	}

}
