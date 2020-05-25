package io.boodskap.iot.model;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import io.boodskap.iot.dao.ClusterLicenseDAO;

@JsonSerialize(as=IClusterLicense.class)
public interface IClusterLicense extends IDomainObject {
	
	public static enum LicenseType{
		INTERNAL,
		DEVELOPER,
		PERSONAL,
		CORE,
		CUSTOM,
		PERPETUAL,
		EDGE,
		EDUCATIONAL
	}
	
	public static enum LicenseStatus{
		ACTIVE,
		DISABLED,
		SUSPENDED,
		TERMINATED,
		UNACTIVATED,
	}
	
	public static ClusterLicenseDAO<IClusterLicense> dao(){
		return ClusterLicenseDAO.get();
	}
	
	public static IClusterLicense create(String domainKey, String targetDomainKey, String clusterId, String licenseKey) {
		return dao().create(domainKey, targetDomainKey, clusterId, licenseKey);
	}
	
	public static IClusterLicense find(String domainKey, String targetDomainKey, String clusterId, String licenseKey) {
		return dao().get(domainKey, targetDomainKey, clusterId, licenseKey);
	}
	
	public static Class<? extends IClusterLicense> clazz() {
		return dao().clazz();
	}

	public default void save() {
		IClusterLicense.dao().createOrUpdate(this);
	}
	
	public String getLicenseKey();
	
	public void setLicenseKey(String licenseKey);

	public String getClusterId();
	
	public void setClusterId(String clusterId);
	
	public String getTargetDomainKey();

	public void setTargetDomainKey(String targetDomainKey);

	public LicenseType getLicenseType();

	public void setLicenseType(LicenseType licenseType);

	public LicenseStatus getStatus();

	public void setStatus(LicenseStatus status);

	public int getMaxDomains();

	public void setMaxDomains(int maxDomains);

	public int getMaxMachines();

	public void setMaxMachines(int maxMachines);

	public int getMaxUsers();

	public void setMaxUsers(int maxUsers);

	public int getMaxCores();

	public void setMaxCores(int maxCores);

	public int getMaxMachineCores();

	public void setMaxMachineCores(int maxMachineCores);

	public int getMaxDevices();

	public void setMaxDevices(int maxDevices);

	public int getMaxMessagesPerMinute();

	public void setMaxMessagesPerMinute(int maxMessagesPerMinute);

	public int getMaxDeviceMessagesPerMinute();

	public void setMaxDeviceMessagesPerMinute(int maxDeviceMessagesPerMinute);

	public int getMaxOrganizations();

	public void setMaxOrganizations(int maxOrganizations);

	public Date getValidFrom();

	public void setValidFrom(Date validFrom);

	public Date getValidTo();

	public void setValidTo(Date validTo);

	public int getGracePeriod();
	
	public void setGracePeriod(int gracePeriod);
}
