package io.boodskap.iot.model.jpa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class JarClassId implements Serializable {

	private static final long serialVersionUID = -7157001220587928948L;

	@Column(name = "loader", length = 40)
	private String loader;
	
	@Column(name = "filename", length = 256)
	private String fileName;
	
	@Column(name = "pkg", length = 512)
	private String pkg;
	
	@Column(name = "name", length = 256)
	private String name;
	
	public JarClassId() {
	}

	public JarClassId(String loader, String fileName, String pkg, String name) {
		super();
		this.loader = loader;
		this.fileName = fileName;
		this.pkg = pkg;
		this.name = name;
	}

	public String getLoader() {
		return loader;
	}

	public void setLoader(String loader) {
		this.loader = loader;
	}

	public String getPkg() {
		return pkg;
	}

	public void setPkg(String pkg) {
		this.pkg = pkg;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((pkg == null) ? 0 : pkg.hashCode());
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
		JarClassId other = (JarClassId) obj;
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
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (pkg == null) {
			if (other.pkg != null)
				return false;
		} else if (!pkg.equals(other.pkg))
			return false;
		return true;
	}

}
