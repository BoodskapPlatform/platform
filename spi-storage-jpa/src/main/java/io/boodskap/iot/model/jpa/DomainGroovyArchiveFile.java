package io.boodskap.iot.model.jpa;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

import io.boodskap.iot.SizeConstants;
import io.boodskap.iot.model.IDomainGroovyArchiveFile;

@Entity
@Table(name = "domaingarchfile")
public class DomainGroovyArchiveFile extends AbstractModel implements IDomainGroovyArchiveFile {

	private static final long serialVersionUID = -6433581376660773352L;

	@EmbeddedId
	private DomainGroovyArchiveFileId id = new DomainGroovyArchiveFileId();

	@Lob
	@Column(name="objectcore", length=SizeConstants.JAR_FILE_SIZE)
	private byte[] objectCode;
	
	public DomainGroovyArchiveFile() {
		super();
	}

	public DomainGroovyArchiveFile(String domainKey, String loader, String fileName) {
		this(new DomainGroovyArchiveFileId(domainKey, loader, fileName));
	}

	public DomainGroovyArchiveFile(DomainGroovyArchiveFileId id) {
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
		DomainGroovyArchiveFile other = (DomainGroovyArchiveFile) obj;
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
