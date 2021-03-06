package io.boodskap.iot.model.jpa;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

import io.boodskap.iot.SizeConstants;
import io.boodskap.iot.model.IGroovyArchiveFile;

@Entity
@Table(name = "garchfile")
public class GroovyArchiveFile extends AbstractModel implements IGroovyArchiveFile {

	private static final long serialVersionUID = 6171708929613470512L;

	@EmbeddedId
	private GroovyArchiveFileId id = new GroovyArchiveFileId();

	@Lob
	@Column(name="objectcore", length=SizeConstants.JAR_FILE_SIZE)
	private byte[] objectCode;
	
	public GroovyArchiveFile() {
		super();
	}

	public GroovyArchiveFile(String loader, String fileName) {
		this(new GroovyArchiveFileId(loader, fileName));
	}

	public GroovyArchiveFile(GroovyArchiveFileId id) {
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
		int result = super.hashCode();
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + Arrays.hashCode(objectCode);
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
		GroovyArchiveFile other = (GroovyArchiveFile) obj;
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
