package io.boodskap.iot.model.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.boodskap.iot.SizeConstants;
import io.boodskap.iot.model.ISystemFile;

@Entity
@Table(name="systemfile")
public class SystemFile extends AbstractFile implements ISystemFile {

	private static final long serialVersionUID = -1066915123589525661L;

	@Id
	@Column(name="fileid", length=SizeConstants.ID_SIZE)
	private String fileId;

	@Column(name="domainkey", length=SizeConstants.DOMAIN_SIZE)
	private String domainKey;

	public SystemFile() {
	}
	
	public SystemFile(String fileId) {
		super();
		this.fileId = fileId;
	}

	@Override
	public final String getFileId() {
		return fileId;
	}

	@Override
	public final void setFileId(String fileId) {
		this.fileId = fileId;
	}

	@Override
	public final String getDomainKey() {
		return domainKey;
	}

	@Override
	public final void setDomainKey(String domainKey) {
		this.domainKey = domainKey;
	}

}
