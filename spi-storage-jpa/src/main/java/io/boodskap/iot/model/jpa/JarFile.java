package io.boodskap.iot.model.jpa;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

import io.boodskap.iot.SizeConstants;
import io.boodskap.iot.model.IJarFile;

@Entity
@Table(name = "jarfile")
public class JarFile implements IJarFile {

	private static final long serialVersionUID = 7121987420542615054L;

	@EmbeddedId
	private JarFileId id = new JarFileId();

	@Lob
	@Column(name="objectcore", length=SizeConstants.JAR_FILE_SIZE)
	private byte[] objectCode;
	
	public JarFile() {
		super();
	}

	public JarFile(String loader, String fileName) {
		this(new JarFileId(loader, fileName));
	}

	public JarFile(JarFileId id) {
		super();
		this.id = id;
	}

	public String getLoader() {
		return id.getLoader();
	}

	public void setLoader(String loader) {
		id.setLoader(loader);
	}

	public String getFileName() {
		return id.getFileName();
	}

	public void setFileName(String fileName) {
		id.setFileName(fileName);
	}

	public byte[] getObjectCode() {
		return objectCode;
	}

	public void setObjectCode(byte[] objectCode) {
		this.objectCode = objectCode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + Arrays.hashCode(objectCode);
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
		JarFile other = (JarFile) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (!Arrays.equals(objectCode, other.objectCode))
			return false;
		return true;
	}

}
