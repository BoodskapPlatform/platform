package io.boodskap.iot.model.jpa;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import io.boodskap.iot.model.IDomainLicense;

@Entity
@Table(name="domainlicense")
public class DomainLicense extends AbstractModel implements IDomainLicense {

	private static final long serialVersionUID = 3097274606119911139L;

	@Id
	@Column(name="domainkey", length=16)
	private String domainKey = null;
	
	@Lob
	@Column(name="license", length=1024)
	private byte[] license = null;
	
	public DomainLicense() {
	}

	public DomainLicense(String domainKey) {
		this.domainKey = domainKey;
	}

	public String getDomainKey() {
		return domainKey;
	}

	public void setDomainKey(String domainKey) {
		this.domainKey = domainKey;
	}

	public byte[] getLicense() {
		return license;
	}

	public void setLicense(byte[] license) {
		this.license = license;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((domainKey == null) ? 0 : domainKey.hashCode());
		result = prime * result + Arrays.hashCode(license);
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
		DomainLicense other = (DomainLicense) obj;
		if (domainKey == null) {
			if (other.domainKey != null)
				return false;
		} else if (!domainKey.equals(other.domainKey))
			return false;
		if (!Arrays.equals(license, other.license))
			return false;
		return true;
	}

}
