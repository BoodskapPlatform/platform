package io.boodskap.iot.model.jpa;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import io.boodskap.iot.model.IJarClass;

@Entity
@Table(name = "jarclass")
public class JarClass extends AbstractEntity implements IJarClass {

	private static final long serialVersionUID = -4137682579219019646L;
	
	@EmbeddedId
	private JarClassId id = new JarClassId();

	public JarClass() {
		super();
	}

	public JarClass(String loader, String fileName, String pkg, String name) {
		this(new JarClassId(loader, fileName, pkg, name));
	}

	public JarClass(JarClassId id) {
		super();
		this.id = id;
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
		int result = super.hashCode();
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
		JarClass other = (JarClass) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
