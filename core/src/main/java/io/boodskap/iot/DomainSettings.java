package io.boodskap.iot;

import java.io.Serializable;

public class DomainSettings implements Serializable {

	private static final long serialVersionUID = -4710000257522379249L;
	
	private String domainKey;
	private boolean canUserRead = true;
	private boolean canUserWrite = false;
	private boolean canUserDelete = false;
	private boolean canDeveloperRead = true;
	private boolean canDeveloperWrite = true;
	private boolean canDeveloperDelete = false;
	private boolean canOrgUserRead = false;
	private boolean canOrgUserWrite = false;
	private boolean canOrgUserDelete = false;
	private boolean canOrgAdminRead = true;
	private boolean canOrgAdminWrite = false;
	private boolean canOrgAdminDelete = false;
	private boolean canDomainAdminRead = true;
	private boolean canDomainAdminWrite = true;
	private boolean canDomainAdminDelete = true;
	private boolean canAdminRead = true;
	private boolean canAdminWrite = true;
	private boolean canAdminDelete = true;

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

	public boolean isCanUserRead() {
		return canUserRead;
	}

	public void setCanUserRead(boolean canUserRead) {
		this.canUserRead = canUserRead;
	}

	public boolean isCanOrgUserRead() {
		return canOrgUserRead;
	}

	public void setCanOrgUserRead(boolean canOrgUserRead) {
		this.canOrgUserRead = canOrgUserRead;
	}

	public boolean isCanUserWrite() {
		return canUserWrite;
	}

	public void setCanUserWrite(boolean canUserWrite) {
		this.canUserWrite = canUserWrite;
	}

	public boolean isCanUserDelete() {
		return canUserDelete;
	}

	public void setCanUserDelete(boolean canUserDelete) {
		this.canUserDelete = canUserDelete;
	}

	public boolean isCanDomainAdminRead() {
		return canDomainAdminRead;
	}

	public void setCanDomainAdminRead(boolean canDomainAdminRead) {
		this.canDomainAdminRead = canDomainAdminRead;
	}

	public boolean isCanDomainAdminWrite() {
		return canDomainAdminWrite;
	}

	public void setCanDomainAdminWrite(boolean canDomainAdminWrite) {
		this.canDomainAdminWrite = canDomainAdminWrite;
	}

	public boolean isCanDomainAdminDelete() {
		return canDomainAdminDelete;
	}

	public void setCanDomainAdminDelete(boolean canDomainAdminDelete) {
		this.canDomainAdminDelete = canDomainAdminDelete;
	}

	public boolean isCanAdminRead() {
		return canAdminRead;
	}

	public void setCanAdminRead(boolean canAdminRead) {
		this.canAdminRead = canAdminRead;
	}

	public boolean isCanAdminWrite() {
		return canAdminWrite;
	}

	public void setCanAdminWrite(boolean canAdminWrite) {
		this.canAdminWrite = canAdminWrite;
	}

	public boolean isCanAdminDelete() {
		return canAdminDelete;
	}

	public void setCanAdminDelete(boolean canAdminDelete) {
		this.canAdminDelete = canAdminDelete;
	}

	public boolean isCanOrgAdminRead() {
		return canOrgAdminRead;
	}

	public void setCanOrgAdminRead(boolean canOrgAdminRead) {
		this.canOrgAdminRead = canOrgAdminRead;
	}

	public boolean isCanOrgAdminWrite() {
		return canOrgAdminWrite;
	}

	public void setCanOrgAdminWrite(boolean canOrgAdminWrite) {
		this.canOrgAdminWrite = canOrgAdminWrite;
	}

	public boolean isCanOrgAdminDelete() {
		return canOrgAdminDelete;
	}

	public void setCanOrgAdminDelete(boolean canOrgAdminDelete) {
		this.canOrgAdminDelete = canOrgAdminDelete;
	}

	public boolean isCanDeveloperRead() {
		return canDeveloperRead;
	}

	public void setCanDeveloperRead(boolean canDeveloperRead) {
		this.canDeveloperRead = canDeveloperRead;
	}

	public boolean isCanDeveloperWrite() {
		return canDeveloperWrite;
	}

	public void setCanDeveloperWrite(boolean canDeveloperWrite) {
		this.canDeveloperWrite = canDeveloperWrite;
	}

	public boolean isCanDeveloperDelete() {
		return canDeveloperDelete;
	}

	public void setCanDeveloperDelete(boolean canDeveloperDelete) {
		this.canDeveloperDelete = canDeveloperDelete;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (canAdminDelete ? 1231 : 1237);
		result = prime * result + (canAdminRead ? 1231 : 1237);
		result = prime * result + (canAdminWrite ? 1231 : 1237);
		result = prime * result + (canDeveloperDelete ? 1231 : 1237);
		result = prime * result + (canDeveloperRead ? 1231 : 1237);
		result = prime * result + (canDeveloperWrite ? 1231 : 1237);
		result = prime * result + (canDomainAdminDelete ? 1231 : 1237);
		result = prime * result + (canDomainAdminRead ? 1231 : 1237);
		result = prime * result + (canDomainAdminWrite ? 1231 : 1237);
		result = prime * result + (canOrgAdminDelete ? 1231 : 1237);
		result = prime * result + (canOrgAdminRead ? 1231 : 1237);
		result = prime * result + (canOrgAdminWrite ? 1231 : 1237);
		result = prime * result + (canOrgUserDelete ? 1231 : 1237);
		result = prime * result + (canOrgUserRead ? 1231 : 1237);
		result = prime * result + (canOrgUserWrite ? 1231 : 1237);
		result = prime * result + (canUserDelete ? 1231 : 1237);
		result = prime * result + (canUserRead ? 1231 : 1237);
		result = prime * result + (canUserWrite ? 1231 : 1237);
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
		if (canAdminDelete != other.canAdminDelete)
			return false;
		if (canAdminRead != other.canAdminRead)
			return false;
		if (canAdminWrite != other.canAdminWrite)
			return false;
		if (canDeveloperDelete != other.canDeveloperDelete)
			return false;
		if (canDeveloperRead != other.canDeveloperRead)
			return false;
		if (canDeveloperWrite != other.canDeveloperWrite)
			return false;
		if (canDomainAdminDelete != other.canDomainAdminDelete)
			return false;
		if (canDomainAdminRead != other.canDomainAdminRead)
			return false;
		if (canDomainAdminWrite != other.canDomainAdminWrite)
			return false;
		if (canOrgAdminDelete != other.canOrgAdminDelete)
			return false;
		if (canOrgAdminRead != other.canOrgAdminRead)
			return false;
		if (canOrgAdminWrite != other.canOrgAdminWrite)
			return false;
		if (canOrgUserDelete != other.canOrgUserDelete)
			return false;
		if (canOrgUserRead != other.canOrgUserRead)
			return false;
		if (canOrgUserWrite != other.canOrgUserWrite)
			return false;
		if (canUserDelete != other.canUserDelete)
			return false;
		if (canUserRead != other.canUserRead)
			return false;
		if (canUserWrite != other.canUserWrite)
			return false;
		if (domainKey == null) {
			if (other.domainKey != null)
				return false;
		} else if (!domainKey.equals(other.domainKey))
			return false;
		return true;
	}

}
