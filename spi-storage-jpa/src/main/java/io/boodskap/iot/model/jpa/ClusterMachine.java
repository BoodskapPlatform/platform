package io.boodskap.iot.model.jpa;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import io.boodskap.iot.model.IClusterMachine;
import io.boodskap.iot.model.INameValuePair;

@Entity
@Table(name = "clustermachine")
public class ClusterMachine extends AbstractModel implements IClusterMachine {

	private static final long serialVersionUID = 7271804394768823312L;

	@EmbeddedId
	private ClusterMachineId id = new ClusterMachineId();

	@Column(name="status", length = 20)
	@Enumerated(EnumType.STRING)
	private MachineStatus status;
	
	@Column(name="cpuslots")
	private int cpuSlots;
	
	@Column(name="cpucores")
	private int cpuCores;

	@OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ClusterMachineNVP> properties = new ArrayList<>();

	public ClusterMachine() {
	}

	public ClusterMachine(ClusterMachineId id) {
		this.id = id;
	}

	@Override
	public INameValuePair createNameValuePair(String name, String value) {
		ClusterMachineNVP nv = new ClusterMachineNVP(this, new ClusterMachineNVPId(getDomainKey(), getTargetDomainKey(), getClusterId(), getMachineId(), name));
		nv.setValue(value);
		return nv;
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
	public String getMachineId() {
		return id.getMachineId();
	}

	@Override
	public void setMachineId(String machineId) {
		id.setMachineId(machineId);
	}

	@Override
	public int getCpuSlots() {
		return cpuSlots;
	}

	@Override
	public void setCpuSlots(int cpuSlots) {
		this.cpuSlots = cpuSlots;
	}

	@Override
	public int getCpuCores() {
		return cpuCores;
	}

	@Override
	public void setCpuCores(int cpuCores) {
		this.cpuCores = cpuCores;
	}

	@SuppressWarnings("unchecked")
	public Collection<? extends ClusterMachineNVP> getProperties() {
		return properties;
	}

	public void setProperties(Collection<? extends INameValuePair> properties) {
		
		this.properties.clear();
		
		properties.forEach(p->{
			this.properties.add((ClusterMachineNVP)p);
		});
	}

	@Override
	public MachineStatus getStatus() {
		return status;
	}

	@Override
	public void setStatus(MachineStatus status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + cpuCores;
		result = prime * result + cpuSlots;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((properties == null) ? 0 : properties.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		ClusterMachine other = (ClusterMachine) obj;
		if (cpuCores != other.cpuCores)
			return false;
		if (cpuSlots != other.cpuSlots)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (properties == null) {
			if (other.properties != null)
				return false;
		} else if (!properties.equals(other.properties))
			return false;
		if (status != other.status)
			return false;
		return true;
	}

}
