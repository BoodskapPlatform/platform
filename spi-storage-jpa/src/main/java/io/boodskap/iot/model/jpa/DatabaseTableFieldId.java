package io.boodskap.iot.model.jpa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class DatabaseTableFieldId implements Serializable {
	
	private static final long serialVersionUID = -3108025555685308655L;

	@Column(name="domainkey", length=16)
	private String domainKey;

	@Column(name="metadataid", length=40)
	private String metaDataId;

	@Column(name="tablename", length=120)
	private String table;
	
	@Column(name="fieldname", length=120)
	private String field;
	
	public DatabaseTableFieldId() {
	}

	public DatabaseTableFieldId(String domainKey, String metaDataId, String table, String field) {
		this.domainKey = domainKey;
		this.metaDataId = metaDataId;
		this.table = table;
		this.field = field;
	}

	public String getDomainKey() {
		return domainKey;
	}

	public void setDomainKey(String domainKey) {
		this.domainKey = domainKey;
	}

	public String getMetaDataId() {
		return metaDataId;
	}

	public void setMetaDataId(String metaDataId) {
		this.metaDataId = metaDataId;
	}

	public String getTable() {
		return table;
	}

	public void setTable(String table) {
		this.table = table;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((domainKey == null) ? 0 : domainKey.hashCode());
		result = prime * result + ((field == null) ? 0 : field.hashCode());
		result = prime * result + ((metaDataId == null) ? 0 : metaDataId.hashCode());
		result = prime * result + ((table == null) ? 0 : table.hashCode());
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
		DatabaseTableFieldId other = (DatabaseTableFieldId) obj;
		if (domainKey == null) {
			if (other.domainKey != null)
				return false;
		} else if (!domainKey.equals(other.domainKey))
			return false;
		if (field == null) {
			if (other.field != null)
				return false;
		} else if (!field.equals(other.field))
			return false;
		if (metaDataId == null) {
			if (other.metaDataId != null)
				return false;
		} else if (!metaDataId.equals(other.metaDataId))
			return false;
		if (table == null) {
			if (other.table != null)
				return false;
		} else if (!table.equals(other.table))
			return false;
		return true;
	}

}
