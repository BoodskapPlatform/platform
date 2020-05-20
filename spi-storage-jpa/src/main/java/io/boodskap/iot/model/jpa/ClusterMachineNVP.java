package io.boodskap.iot.model.jpa;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import io.boodskap.iot.model.INameValuePair;

@Entity
@Table(name = "clustermachinenvp")
public class ClusterMachineNVP implements INameValuePair {

	private static final long serialVersionUID = 4977842791448573979L;
	
	@EmbeddedId
	private ClusterMachineNVPId id = new ClusterMachineNVPId();
	
	@Column(name="value", length = 255)
	private String value;

	@ManyToOne(fetch = FetchType.LAZY)
    private ClusterMachine parent;

	public ClusterMachineNVP() {
	}

	public ClusterMachineNVP(ClusterMachine parent, ClusterMachineNVPId id) {
		this.parent = parent;
		this.id = id;
	}

	public ClusterMachine getParent() {
		return parent;
	}

	public void setParent(ClusterMachine parent) {
		this.parent = parent;
	}

	public String getClusterId() {
		return id.getClusterId();
	}

	public void setClusterId(String clusterId) {
		id.setClusterId(clusterId);
	}

	public String getMachineId() {
		return id.getMachineId();
	}

	public void setMachineId(String machineId) {
		id.setMachineId(machineId);
	}

	public String getName() {
		return id.getName();
	}

	public void setName(String name) {
		id.setName(name);
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
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
		ClusterMachineNVP other = (ClusterMachineNVP) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}
}

