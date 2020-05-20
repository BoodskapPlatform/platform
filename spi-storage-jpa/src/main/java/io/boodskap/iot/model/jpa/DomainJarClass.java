package io.boodskap.iot.model.jpa;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import io.boodskap.iot.model.IDomainJarClass;

@Entity
@Table(name = "domainjarclass")
public class DomainJarClass implements IDomainJarClass {

	private static final long serialVersionUID = 3039514434471294683L;
	
	@EmbeddedId
	private DomainJarClassId id = new DomainJarClassId();

	public DomainJarClass() {
		super();
	}

	public DomainJarClass(String domainKey, String loader, String fileName, String pkg, String name) {
		this(new DomainJarClassId(domainKey, loader, fileName, pkg, name));
	}

	public DomainJarClass(DomainJarClassId id) {
		super();
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

	public String getPkg() {
		return id.getPkg();
	}

	public void setPkg(String pkg) {
		id.setPkg(pkg);
	}

	public String getName() {
		return id.getName();
	}

	public void setName(String name) {
		id.setName(name);
	}

	public String getFileName() {
		return id.getFileName();
	}

	public void setFileName(String fileName) {
		id.setFileName(fileName);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		DomainJarClass other = (DomainJarClass) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
