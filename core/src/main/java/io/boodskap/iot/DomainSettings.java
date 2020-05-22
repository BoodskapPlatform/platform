package io.boodskap.iot;

import java.io.Serializable;

public class DomainSettings implements Serializable {

	private static final long serialVersionUID = -4710000257522379249L;
	
	private String domainKey;
	private boolean canOrgUserWrite = false;
	private boolean canOrgUserDelete = false;

	public DomainSettings() {
	}

	public String getDomainKey() {
		return domainKey;
	}

	public void setDomainKey(String domainKey) {
		this.domainKey = domainKey;
	}

	public boolean isCanOrgUserWrite() {
		return canOrgUserWrite;
	}

	public void setCanOrgUserWrite(boolean canOrgUserWrite) {
		this.canOrgUserWrite = canOrgUserWrite;
	}

	public boolean isCanOrgUserDelete() {
		return canOrgUserDelete;
	}

	public void setCanOrgUserDelete(boolean canOrgUserDelete) {
		this.canOrgUserDelete = canOrgUserDelete;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (canOrgUserDelete ? 1231 : 1237);
		result = prime * result + (canOrgUserWrite ? 1231 : 1237);
		result = prime * result + ((domainKey == null) ? 0 : domainKey.hashCode());
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
		DomainSettings other = (DomainSettings) obj;
		if (canOrgUserDelete != other.canOrgUserDelete)
			return false;
		if (canOrgUserWrite != other.canOrgUserWrite)
			return false;
		if (domainKey == null) {
			if (other.domainKey != null)
				return false;
		} else if (!domainKey.equals(other.domainKey))
			return false;
		return true;
	}

}
