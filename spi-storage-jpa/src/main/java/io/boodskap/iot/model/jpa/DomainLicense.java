package io.boodskap.iot.model.jpa;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import io.boodskap.iot.model.IDomainLicense;

@Entity
@Table(name="domainlicense")
public class DomainLicense implements IDomainLicense {

	private static final long serialVersionUID = 3097274606119911139L;

	@Id
	@Column(name="domainkey", length=16)
	private String domainKey = null;
	
	@Lob
	@Column(name="license", length=1024)
	private byte[] license = null;
	
	@Column(name="createdstamp")
	private Date createdStamp;
	
	@Column(name="updatedstamp")
	private Date updatedStamp;
	
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

	public Date getCreatedStamp() {
		return createdStamp;
	}

	public void setCreatedStamp(Date createdStamp) {
		this.createdStamp = createdStamp;
	}

	public Date getUpdatedStamp() {
		return updatedStamp;
	}

	public void setUpdatedStamp(Date updatedStamp) {
		this.updatedStamp = updatedStamp;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createdStamp == null) ? 0 : createdStamp.hashCode());
		result = prime * result + ((domainKey == null) ? 0 : domainKey.hashCode());
		result = prime * result + Arrays.hashCode(license);
		result = prime * result + ((updatedStamp == null) ? 0 : updatedStamp.hashCode());
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
		DomainLicense other = (DomainLicense) obj;
		if (createdStamp == null) {
			if (other.createdStamp != null)
				return false;
		} else if (!createdStamp.equals(other.createdStamp))
			return false;
		if (domainKey == null) {
			if (other.domainKey != null)
				return false;
		} else if (!domainKey.equals(other.domainKey))
			return false;
		if (!Arrays.equals(license, other.license))
			return false;
		if (updatedStamp == null) {
			if (other.updatedStamp != null)
				return false;
		} else if (!updatedStamp.equals(other.updatedStamp))
			return false;
		return true;
	}

}