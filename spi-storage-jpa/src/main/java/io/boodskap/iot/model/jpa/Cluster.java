package io.boodskap.iot.model.jpa;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import io.boodskap.iot.model.ICluster;

@Entity
@Table(name="cluster")
public class Cluster implements ICluster {
	
	private static final long serialVersionUID = 3614768552679942510L;

	@Id
	private ClusterId id = new ClusterId();

	@Column(name="status", length = 20)
	@Enumerated(EnumType.STRING)
	private ClusterStatus status;

	@Column(name="rstamp")
	private Date registeredStamp = new Date();
	
	@Column(name="ustamp")
	private Date updatedStamp = new Date();
	
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
		int result = 1;
		result = prime * result + cores;
		result = prime * result + devices;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + machines;
		result = prime * result + organizations;
		result = prime * result + ((registeredStamp == null) ? 0 : registeredStamp.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((updatedStamp == null) ? 0 : updatedStamp.hashCode());
		result = prime * result + users;
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
		if (users != other.users)
			return false;
		return true;
	}

}
