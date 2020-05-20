package io.boodskap.iot.model.jpa;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import io.boodskap.iot.model.IDomainClassLoader;

@Entity
@Table(name="domainclassloader")
public class DomainClassLoader implements IDomainClassLoader {

	private static final long serialVersionUID = -200466371784433311L;
	
	@EmbeddedId
	private DomainClassLoaderId id = new DomainClassLoaderId();
	
	@Column(name="globalloader", length = 40)
	private String globalLoader;
	
	public DomainClassLoader() {
	}

	public DomainClassLoader(DomainClassLoaderId id) {
		this.id = id;
	}

	public String getDomainKey() {
		return id.getDomainKey();
	}

	public void setDomainKey(String domainKey) {
		id.setDomainKey(domainKey);
	}

	public String getLoader() {
		return id.getLoader();
	}

	public void setLoader(String loader) {
		id.setLoader(loader);
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
		int result = 1;
		result = prime * result + ((globalLoader == null) ? 0 : globalLoader.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		DomainClassLoader other = (DomainClassLoader) obj;
		if (globalLoader == null) {
			if (other.globalLoader != null)
				return false;
		} else if (!globalLoader.equals(other.globalLoader))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
