package io.boodskap.iot.model.jpa;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

import io.boodskap.iot.SizeConstants;
import io.boodskap.iot.model.IDomainJarFile;

@Entity
@Table(name = "domainjarfile")
public class DomainJarFile extends AbstractModel implements IDomainJarFile {

	private static final long serialVersionUID = 4582687181271369621L;

	@EmbeddedId
	private DomainJarFileId id = new DomainJarFileId();

	@Lob
	@Column(name="objectcore", length=SizeConstants.JAR_FILE_SIZE)
	private byte[] objectCode;
	
	public DomainJarFile() {
		super();
	}

	public DomainJarFile(String domainKey, String loader, String fileName) {
		this(new DomainJarFileId(domainKey, loader, fileName));
	}

	public DomainJarFile(DomainJarFileId id) {
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

}
