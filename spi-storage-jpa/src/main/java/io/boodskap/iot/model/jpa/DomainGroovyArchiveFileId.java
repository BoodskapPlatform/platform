package io.boodskap.iot.model.jpa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class DomainGroovyArchiveFileId implements Serializable {

	private static final long serialVersionUID = 3015733939453647885L;

	@Column(name = "domainkey", length = 16)
	private String domainKey;

	@Column(name = "loader", length = 40)
	private String loader;
	
	@Column(name = "filename", length = 256)
	private String fileName;
	
	public DomainGroovyArchiveFileId() {
	}

	public DomainGroovyArchiveFileId(String domainKey, String loader, String fileName) {
		super();
		this.domainKey = domainKey;
		this.loader = loader;
		this.fileName = fileName;
	}

	public String getDomainKey() {
		return domainKey;
	}

	public void setDomainKey(String domainKey) {
		this.domainKey = domainKey;
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
		result = prime * result + ((domainKey == null) ? 0 : domainKey.hashCode());
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
		DomainGroovyArchiveFileId other = (DomainGroovyArchiveFileId) obj;
		if (domainKey == null) {
			if (other.domainKey != null)
				return false;
		} else if (!domainKey.equals(other.domainKey))
			return false;
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
