package io.boodskap.iot.model.jpa;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import io.boodskap.iot.model.IClusterLicense;

@Entity
@Table(name="clusterlicense")
public class ClusterLicense implements IClusterLicense {
	
	private static final long serialVersionUID = 9070428612984197936L;

	@EmbeddedId
	private ClusterLicenseId id = new ClusterLicenseId();

	@Column(name="licensetype", length = 20)
	@Enumerated(EnumType.STRING)
	private LicenseType licenseType;

	@Column(name="status", length = 20)
	@Enumerated(EnumType.STRING)
	private LicenseStatus status;

	@Column(name = "maxdomains")
	private int maxDomains;

	@Column(name = "maxmachines")
	private int maxMachines;

	@Column(name = "maxusers")
	private int maxUsers;

	@Column(name = "maxcores")
	private int maxCores;

	@Column(name = "maxmachinecores")
	private int maxMachineCores;

	@Column(name = "maxdevices")
	private int maxDevices;

	@Column(name = "maxmsgpermin")
	private int maxMessagesPerMinute;

	@Column(name = "maxdevmsgpermin")
	private int maxDeviceMessagesPerMinute;

	@Column(name = "maxorgs")
	private int maxOrganizations;

	@Column(name = "graceperiod")
	private int gracePeriod;

	@Column(name="rstamp")
	private Date registeredStamp = new Date();
	
	@Column(name="ustamp")
	private Date updatedStamp = new Date();
	
	@Column(name="validfrom")
	private Date validFrom;
	
	@Column(name="validTo")
	private Date validTo;
	
	public ClusterLicense() {
	}
	
	public ClusterLicense(ClusterLicenseId id) {
		this.id = id;
	}
	
	@Override
	public String getDomainKey() {
		return id.getDomainKey();
	}

	@Override
	public void setDomainKey(String domainKey) {
		id.setDomainKey(domainKey);
	}

	@Override
	public String getTargetDomainKey() {
		return id.getTargetDomainKey();
	}

	@Override
	public void setTargetDomainKey(String targetDomainKey) {
		id.setTargetDomainKey(targetDomainKey);
	}

	@Override
	public String getClusterId() {
		return id.getClusterId();
	}

	@Override
	public void setClusterId(String clusterId) {
		id.setClusterId(clusterId);
	}

	@Override
	public String getLicenseKey() {
		return id.getLicenseKey();
	}

	@Override
	public void setLicenseKey(String licenseKey) {
		id.setLicenseKey(licenseKey);
	}

	@Override
	public Date getRegisteredStamp() {
		return registeredStamp;
	}

	@Override
	public void setRegisteredStamp(Date registeredStamp) {
		this.registeredStamp = registeredStamp;
	}

	@Override
	public Date getUpdatedStamp() {
		return updatedStamp;
	}

	@Override
	public void setUpdatedStamp(Date updatedStamp) {
		this.updatedStamp = updatedStamp;
	}

	@Override
	public LicenseType getLicenseType() {
		return licenseType;
	}

	@Override
	public void setLicenseType(LicenseType licenseType) {
		this.licenseType = licenseType;
	}

	@Override
	public LicenseStatus getStatus() {
		return status;
	}

	@Override
	public void setStatus(LicenseStatus status) {
		this.status = status;
	}

	@Override
	public int getMaxDomains() {
		return maxDomains;
	}

	@Override
	public void setMaxDomains(int maxDomains) {
		this.maxDomains = maxDomains;
	}

	@Override
	public int getMaxMachines() {
		return this.maxMachines;
	}

	@Override
	public void setMaxMachines(int maxMachines) {
		this.maxMachines = maxMachines;
	}

	@Override
	public int getMaxUsers() {
		return maxUsers;
	}

	@Override
	public void setMaxUsers(int maxUsers) {
		this.maxUsers = maxUsers;
	}

	@Override
	public int getMaxCores() {
		return maxCores;
	}

	@Override
	public void setMaxCores(int maxCores) {
		this.maxCores = maxCores;
	}

	@Override
	public int getMaxMachineCores() {
		return maxMachineCores;
	}

	@Override
	public void setMaxMachineCores(int maxMachineCores) {
		this.maxMachineCores = maxMachineCores;
	}

	@Override
	public int getMaxDevices() {
		return maxDevices;
	}

	@Override
	public void setMaxDevices(int maxDevices) {
		this.maxDevices = maxDevices;
	}

	@Override
	public int getMaxMessagesPerMinute() {
		return maxMessagesPerMinute;
	}

	@Override
	public void setMaxMessagesPerMinute(int maxMessagesPerMinute) {
		this.maxMessagesPerMinute = maxMessagesPerMinute;
	}

	@Override
	public int getMaxDeviceMessagesPerMinute() {
		return maxDeviceMessagesPerMinute;
	}

	@Override
	public void setMaxDeviceMessagesPerMinute(int maxDeviceMessagesPerMinute) {
		this.maxDeviceMessagesPerMinute = maxDeviceMessagesPerMinute;
	}

	@Override
	public int getMaxOrganizations() {
		return maxOrganizations;
	}

	@Override
	public void setMaxOrganizations(int organizations) {
		this.maxOrganizations = organizations;
	}

	@Override
	public int getGracePeriod() {
		return gracePeriod;
	}

	@Override
	public void setGracePeriod(int gracePeriod) {
		this.gracePeriod = gracePeriod;
	}

	@Override
	public Date getValidFrom() {
		return validFrom;
	}

	@Override
	public void setValidFrom(Date validFrom) {
		this.validFrom = validFrom;
	}

	@Override
	public Date getValidTo() {
		return validTo;
	}

	@Override
	public void setValidTo(Date validTo) {
		this.validTo = validTo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + gracePeriod;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((licenseType == null) ? 0 : licenseType.hashCode());
		result = prime * result + maxCores;
		result = prime * result + maxDeviceMessagesPerMinute;
		result = prime * result + maxDevices;
		result = prime * result + maxDomains;
		result = prime * result + maxMachineCores;
		result = prime * result + maxMachines;
		result = prime * result + maxMessagesPerMinute;
		result = prime * result + maxUsers;
		result = prime * result + ((registeredStamp == null) ? 0 : registeredStamp.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((updatedStamp == null) ? 0 : updatedStamp.hashCode());
		result = prime * result + ((validFrom == null) ? 0 : validFrom.hashCode());
		result = prime * result + ((validTo == null) ? 0 : validTo.hashCode());
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
		ClusterLicense other = (ClusterLicense) obj;
		if (gracePeriod != other.gracePeriod)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (licenseType != other.licenseType)
			return false;
		if (maxCores != other.maxCores)
			return false;
		if (maxDeviceMessagesPerMinute != other.maxDeviceMessagesPerMinute)
			return false;
		if (maxDevices != other.maxDevices)
			return false;
		if (maxDomains != other.maxDomains)
			return false;
		if (maxMachineCores != other.maxMachineCores)
			return false;
		if (maxMachines != other.maxMachines)
			return false;
		if (maxMessagesPerMinute != other.maxMessagesPerMinute)
			return false;
		if (maxUsers != other.maxUsers)
			return false;
		if (registeredStamp == null) {
			if (other.registeredStamp != null)
				return false;
		} else if (!registeredStamp.equals(other.registeredStamp))
			return false;
		if (status != other.status)
			return false;
		if (updatedStamp == null) {
			if (other.updatedStamp != null)
				return false;
		} else if (!updatedStamp.equals(other.updatedStamp))
			return false;
		if (validFrom == null) {
			if (other.validFrom != null)
				return false;
		} else if (!validFrom.equals(other.validFrom))
			return false;
		if (validTo == null) {
			if (other.validTo != null)
				return false;
		} else if (!validTo.equals(other.validTo))
			return false;
		return true;
	}

}
