package io.boodskap.iot.model.jpa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class ClusterId implements Serializable {
	
	private static final long serialVersionUID = 7741997237565213298L;

	@Column(name="domainkey", length = 16)
	private String domainKey;

	@Column(name="targetdomainkey", length = 16)
	private String targetDomainKey;

	@Column(name="clusterid", length = 40)
	private String clusterId;
	
	public ClusterId() {
	}


	public ClusterId(String domainKey, String targetDomainKey, String clusterId) {
		super();
		this.domainKey = domainKey;
		this.targetDomainKey = targetDomainKey;
		this.clusterId = clusterId;
	}


	public String getDomainKey() {
		return domainKey;
	}


	public void setDomainKey(String domainKey) {
		this.domainKey = domainKey;
	}


	public String getClusterId() {
		return clusterId;
	}


	public void setClusterId(String clusterId) {
		this.clusterId = clusterId;
	}


	public String getTargetDomainKey() {
		return targetDomainKey;
	}


	public void setTargetDomainKey(String targetDomainKey) {
		this.targetDomainKey = targetDomainKey;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((clusterId == null) ? 0 : clusterId.hashCode());
		result = prime * result + ((domainKey == null) ? 0 : domainKey.hashCode());
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
		ClusterId other = (ClusterId) obj;
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
		if (targetDomainKey == null) {
			if (other.targetDomainKey != null)
				return false;
		} else if (!targetDomainKey.equals(other.targetDomainKey))
			return false;
		return true;
	}

}
