package io.boodskap.iot.model;

import java.util.Collection;
import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import io.boodskap.iot.dao.ClusterMachineDAO;

@JsonSerialize(as=IClusterMachine.class)
public interface IClusterMachine extends IDomainObject {
	
	public static enum MachineStatus{
		ACTIVE,
		DISABLED,
		SUSPENDED,
		TERMINATED,
	}
	
	public static ClusterMachineDAO<IClusterMachine> dao(){
		return ClusterMachineDAO.get();
	}
	
	public static IClusterMachine create(String domainKey, String targetDomainKey, String clusterId, String machineId) {
		return dao().create(domainKey, targetDomainKey, clusterId, machineId);
	}
	
	public static IClusterMachine find(String domainKey, String targetDomainKey, String clusterId, String machineId) {
		return dao().get(domainKey, targetDomainKey, clusterId, machineId);
	}
	
	public static Class<? extends IClusterMachine> clazz() {
		return dao().clazz();
	}

	public default void save() {
		IClusterMachine.dao().createOrUpdate(this);
	}
	
	public default boolean isActive() {
		return MachineStatus.ACTIVE == getStatus();
	}
	
	public INameValuePair createNameValuePair(String name, String value);
	
	public String getClusterId();
	
	public void setClusterId(String clusterId);

	public String getTargetDomainKey();

	public void setTargetDomainKey(String targetDomainKey);

	public String getMachineId();
	
	public void setMachineId(String machineId);

	public MachineStatus getStatus();

	public void setStatus(MachineStatus status);
	
	public int getCpuSlots();
	
	public void setCpuSlots(int cpuSlots);

	public int getCpuCores();
	
	public void setCpuCores(int cpuCores);

	public Date getRegisteredStamp();

	public void setRegisteredStamp(Date registeredStamp);

	public Date getUpdatedStamp();

	public void setUpdatedStamp(Date updatedStamp);

	public <T extends INameValuePair> Collection<T> getProperties();

	public void setProperties(Collection<? extends INameValuePair> properties);
	
}
