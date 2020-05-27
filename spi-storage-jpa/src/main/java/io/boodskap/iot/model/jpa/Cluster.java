package io.boodskap.iot.model.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import io.boodskap.iot.model.ICluster;

@Entity
@Table(name="cluster")
public class Cluster extends AbstractModel implements ICluster {
	
	private static final long serialVersionUID = 3614768552679942510L;

	@Id
	private ClusterId id = new ClusterId();

	@Column(name="status", length = 20)
	@Enumerated(EnumType.STRING)
	private ClusterStatus status;

	@Column(name="machines")
	private int machines;
	
	@Column(name="devices")
	private int devices;
	
	@Column(name="cores")
	private int cores;
	
	@Column(name="users")
	private int users;
	
	@Column(name="orgs")
	private int organizations;
	
	public Cluster() {
	}
	
	public Cluster(ClusterId id) {
		super();
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
	public String getClusterId() {
		return id.getClusterId();
	}

	@Override
	public void setClusterId(String clusterId) {
		id.setClusterId(clusterId);
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
	public ClusterStatus getStatus() {
		return status;
	}

	@Override
	public void setStatus(ClusterStatus status) {
		this.status = status;
	}

	@Override
	public int getMachines() {
		return machines;
	}

	@Override
	public void setMachines(int machines) {
		this.machines = machines;
	}

	@Override
	public int getDevices() {
		return devices;
	}

	@Override
	public void setDevices(int devices) {
		this.devices = devices;
	}

	@Override
	public int getCores() {
		return cores;
	}

	@Override
	public void setCores(int cores) {
		this.cores = cores;
	}

	@Override
	public int getUsers() {
		return users;
	}

	@Override
	public void setUsers(int users) {
		this.users = users;
	}

	@Override
	public int getOrganizations() {
		return organizations;
	}

	@Override
	public void setOrganizations(int organizations) {
		this.organizations = organizations;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + cores;
		result = prime * result + devices;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + machines;
		result = prime * result + organizations;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + users;
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
		Cluster other = (Cluster) obj;
		if (cores != other.cores)
			return false;
		if (devices != other.devices)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (machines != other.machines)
			return false;
		if (organizations != other.organizations)
			return false;
		if (status != other.status)
			return false;
		if (users != other.users)
			return false;
		return true;
	}

}
