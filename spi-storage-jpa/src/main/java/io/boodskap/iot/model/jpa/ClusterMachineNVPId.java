package io.boodskap.iot.model.jpa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ClusterMachineNVPId implements Serializable{

	private static final long serialVersionUID = 250046363679438132L;
	
	@Column(name = "domainkey", length = 16)
	private String domainKey;

	@Column(name = "targetdomainkey", length = 16)
	private String targetDomainKey;

	@Column(name="clusterid", length=40)
	private String clusterId;
	
	@Column(name="machineid", length=40)
	private String machineId;
	
	@Column(name="name", length=80)
	private String name;
	
	public ClusterMachineNVPId() {
	}


	public ClusterMachineNVPId(String domainKey, String targetDomainKey, String clusterId, String machineId, String name) {
		super();
		this.domainKey = domainKey;
		this.targetDomainKey = targetDomainKey;
		this.clusterId = clusterId;
		this.machineId = machineId;
		this.name = name;
	}

	public String getClusterId() {
		return clusterId;
	}

	public void setClusterId(String clusterId) {
		this.clusterId = clusterId;
	}

	public String getMachineId() {
		return machineId;
	}

	public void setMachineId(String machineId) {
		this.machineId = machineId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((clusterId == null) ? 0 : clusterId.hashCode());
		result = prime * result + ((domainKey == null) ? 0 : domainKey.hashCode());
		result = prime * result + ((machineId == null) ? 0 : machineId.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((targetDomainKey == null) ? 0 : targetDomainKey.hashCode());
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
		ClusterMachineNVPId other = (ClusterMachineNVPId) obj;
		if (clusterId == null) {
			if (other.clusterId != null)
				return false;
		} else if (!clusterId.equals(other.clusterId))
			return false;
		if (domainKey == null) {
			if (other.domainKey != null)
				return false;
		} else if (!domainKey.equals(other.domainKey))
			return false;
		if (machineId == null) {
			if (other.machineId != null)
				return false;
		} else if (!machineId.equals(other.machineId))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (targetDomainKey == null) {
			if (other.targetDomainKey != null)
				return false;
		} else if (!targetDomainKey.equals(other.targetDomainKey))
			return false;
		return true;
	}

}
