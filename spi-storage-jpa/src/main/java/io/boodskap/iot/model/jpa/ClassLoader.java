package io.boodskap.iot.model.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.boodskap.iot.model.IClassLoader;

@Entity
@Table(name="classloader")
public class ClassLoader extends AbstractModel implements IClassLoader {
	
	private static final long serialVersionUID = 2991776579399759266L;
	
	@Id
	@Column(name="loader", length = 40)
	private String loader;
	
	@Column(name="globalloader", length = 40)
	private String globalLoader;
	
	
	public ClassLoader() {
	}

	public ClassLoader(String loader) {
		this.loader = loader;
	}

	@Override
	public String getLoader() {
		return loader;
	}

	@Override
	public void setLoader(String loader) {
		this.loader = loader;
	}

	public String getGlobalLoader() {
		return globalLoader;
	}

	public void setGlobalLoader(String globalLoader) {
		this.globalLoader = globalLoader;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((globalLoader == null) ? 0 : globalLoader.hashCode());
		result = prime * result + ((loader == null) ? 0 : loader.hashCode());
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
		ClassLoader other = (ClassLoader) obj;
		if (globalLoader == null) {
			if (other.globalLoader != null)
				return false;
		} else if (!globalLoader.equals(other.globalLoader))
			return false;
		if (loader == null) {
			if (other.loader != null)
				return false;
		} else if (!loader.equals(other.loader))
			return false;
		return true;
	}

}
