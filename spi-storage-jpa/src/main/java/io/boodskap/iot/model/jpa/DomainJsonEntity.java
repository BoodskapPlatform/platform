package io.boodskap.iot.model.jpa;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.MapKeyColumn;
import javax.persistence.Table;

import org.hibernate.annotations.BatchSize;

import io.boodskap.iot.model.IDomainJsonEntity;

@Entity
@Table(name="domainjsonentity")
public class DomainJsonEntity extends AbstractModel implements IDomainJsonEntity {
	
	private static final long serialVersionUID = 2882976847537967569L;

	@EmbeddedId
	private DomainJsonEntityId id = new DomainJsonEntityId();

	@Lob
	@Column(name="json", length=4096)
	private String json = null;

	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "domain_jsonentity_attrs", joinColumns = @JoinColumn(name = "id"))
	@MapKeyColumn(name = "attr_name", length = 40)
	@Column(name = "att_value", length = 1024)
	@BatchSize(size = 100)
	private Map<String, String> attributes = new HashMap<>();

	public DomainJsonEntity() {
	}

	public DomainJsonEntity(DomainJsonEntityId id) {
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
	public String getEntityId() {
		return id.getEntityId();
	}

	@Override
	public void setEntityId(String entityId) {
		id.setEntityId(entityId);
	}

	@Override
	public String getEntityType() {
		return id.getEntityType();
	}

	@Override
	public void setEntityType(String entityType) {
		id.setEntityType(entityType);
	}

	@Override
	public Map<String, String> getAttributes() {
		return attributes;
	}

	@Override
	public void setAttributes(Map<String, String> attributes) {
		this.attributes = attributes;
	}

	@Override
	public String getJson() {
		return json;
	}

	@Override
	public void setJson(String json) {
		this.json = json;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((attributes == null) ? 0 : attributes.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((json == null) ? 0 : json.hashCode());
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
		DomainJsonEntity other = (DomainJsonEntity) obj;
		if (attributes == null) {
			if (other.attributes != null)
				return false;
		} else if (!attributes.equals(other.attributes))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (json == null) {
			if (other.json != null)
				return false;
		} else if (!json.equals(other.json))
			return false;
		return true;
	}

}
