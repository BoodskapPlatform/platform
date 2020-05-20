package io.boodskap.iot.model.jpa;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import io.boodskap.iot.model.IDatabaseTableField;

@Entity
@Table(name="databasetablefield")
public class DatabaseTableField implements IDatabaseTableField {

	private static final long serialVersionUID = -8634256722528158807L;
	
	@EmbeddedId
	private DatabaseTableFieldId id = new DatabaseTableFieldId(); 

	@Column(name="type", length=40)
	private String type;
	
	@Column(name="size", length=40)
	private String size;

	public DatabaseTableField() {
	}

	public DatabaseTableField(DatabaseTableFieldId id) {
		this.id = id;
	}

	public String getDomainKey() {
		return id.getDomainKey();
	}

	public void setDomainKey(String domainKey) {
		id.setDomainKey(domainKey);
	}

	public String getMetaDataId() {
		return id.getMetaDataId();
	}

	public void setMetaDataId(String metaDataId) {
		id.setMetaDataId(metaDataId);
	}

	public String getTable() {
		return id.getTable();
	}

	public void setTable(String table) {
		id.setTable(table);
	}

	public String getField() {
		return id.getField();
	}

	public void setField(String field) {
		id.setField(field);
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((size == null) ? 0 : size.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		DatabaseTableField other = (DatabaseTableField) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (size == null) {
			if (other.size != null)
				return false;
		} else if (!size.equals(other.size))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

}
