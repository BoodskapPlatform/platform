package io.boodskap.iot.model;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import io.boodskap.iot.dao.ClusterDAO;

@JsonSerialize(as=ICluster.class)
public interface ICluster extends IDomainObject {
	
	public static enum ClusterStatus{
		ACTIVE,
		DISABLED,
		SUSPENDED,
		TERMINATED,
	}
	
	public static ClusterDAO<ICluster> dao(){
		return ClusterDAO.get();
	}
	
	public static ICluster create(String domainKey, String targetDomainKey, String clusterId) {
		return dao().create(domainKey, targetDomainKey, clusterId);
	}
	
	public static ICluster find(String domainKey, String targetDomainKey, String clusterId) {
		return dao().get(domainKey, targetDomainKey, clusterId);
	}
	
	public static Class<? extends ICluster> clazz() {
		return dao().clazz();
	}

	public default void save() {
		ICluster.dao().createOrUpdate(this);
	}
	
	public String getTargetDomainKey();

	public void setTargetDomainKey(String targetDomainKey);

	public String getClusterId();
	
	public void setClusterId(String clusterId);

	public ClusterStatus getStatus();

	public void setStatus(ClusterStatus status);

	public int getMachines();

	public void setMachines(int machines);

	public int getUsers();

	public void setUsers(int users);

	public int getCores();

	public void setCores(int cores);

	public int getDevices();

	public void setDevices(int devices);

	public int getOrganizations();

	public void setOrganizations(int organizations);

	public Date getRegisteredStamp();

	public void setRegisteredStamp(Date registeredStamp);

	public Date getUpdatedStamp();

	public void setUpdatedStamp(Date updatedStamp);
}
