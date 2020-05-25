package io.boodskap.iot.model.pojo;

import java.util.Arrays;

import io.boodskap.iot.model.IDomainLicense;

public class DomainLicense extends AbstractDomainObject implements IDomainLicense {

	private static final long serialVersionUID = 3097274606119911139L;

	private byte[] license = null;
	
	public DomainLicense() {
	}

	public DomainLicense(String domainKey) {
		setDomainKey(domainKey);
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
		if (!Arrays.equals(license, other.license))
			return false;
		return true;
	}

}
