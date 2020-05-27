package io.boodskap.iot.model.jpa;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import io.boodskap.iot.model.IOrganizationAsset;

@Entity
@Table(name="organizationasset")
public class OrganizationAsset extends AbstractModel implements IOrganizationAsset{

	private static final long serialVersionUID = 3338851097866982254L;
	
	@EmbeddedId
	private OrganizationAssetId id = new OrganizationAssetId();

	public OrganizationAsset() {
	}

	public OrganizationAsset(OrganizationAssetId id) {
		this.id = id;
	}

	public String getDomainKey() {
		return id.getDomainKey();
	}

	public void setDomainKey(String domainKey) {
		id.setDomainKey(domainKey);
	}

	public String getOrgId() {
		return id.getOrgId();
	}

	public void setOrgId(String orgId) {
		id.setOrgId(orgId);
	}

	public String getAssetId() {
		return id.getAssetId();
	}

	public void setAssetId(String assetId) {
		id.setAssetId(assetId);
	}

}
