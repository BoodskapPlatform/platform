package io.boodskap.iot.model.jpa;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import io.boodskap.iot.model.IDomainGroovyClass;

@Entity
@Table(name = "domaingroovyclass")
public class DomainGroovyClass extends AbstractModel implements IDomainGroovyClass {

	private static final long serialVersionUID = 4578909004576300500L;
	
	@EmbeddedId
	private DomainGroovyClassId id = new DomainGroovyClassId();

	@Column(name = "filename", length = 256)
	private String fileName;

	@Column(name="code", length=8192)
	private String code;

	public DomainGroovyClass() {
		super();
	}

	public DomainGroovyClass(String domainKey, String loader, String pkg, String name, String fileName) {
		this(new DomainGroovyClassId(domainKey, loader, pkg, name));
		setFileName(fileName);
	}

	public DomainGroovyClass(DomainGroovyClassId id) {
		super();
		this.id = id;
	}

	@Override
	public String getDomainKey() {
		return id.getDomainKey();
	}

	@Override
	public void setDomainKey(String domainKey) {
		id.setDomainKey(domainKey);
	}

	@Override
	public String getLoader() {
		return id.getLoader();
	}

	@Override
	public void setLoader(String loader) {
		id.setLoader(loader);
	}

	@Override
	public String getPkg() {
		return id.getPkg();
	}

	@Override
	public void setPkg(String pkg) {
		id.setPkg(pkg);
	}

	@Override
	public String getFileName() {
		return fileName;
	}

	@Override
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public String getName() {
		return id.getName();
	}

	@Override
	public void setName(String name) {
		id.setName(name);
	}

	@Override
	public String getCode() {
		return code;
	}

	@Override
	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((fileName == null) ? 0 : fileName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		DomainGroovyClass other = (DomainGroovyClass) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (fileName == null) {
			if (other.fileName != null)
				return false;
		} else if (!fileName.equals(other.fileName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
