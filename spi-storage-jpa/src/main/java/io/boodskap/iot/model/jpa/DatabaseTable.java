package io.boodskap.iot.model.jpa;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import io.boodskap.iot.model.IDatabaseTable;
import io.boodskap.iot.model.IDatabaseTableField;

@Entity
@Table(name="databasetable")
public class DatabaseTable implements IDatabaseTable {
	
	private static final long serialVersionUID = -4292175867114525776L;
	
	@EmbeddedId
	private DatabaseTableId id = new DatabaseTableId(); 

	@Column(name="catalog", length=120)
	private String catalog;
	
	@Column(name="schema", length=120)
	private String schema;
	
	@OneToMany(cascade=CascadeType.ALL, targetEntity=DatabaseTableField.class)
	private List<DatabaseTableField> fields = new ArrayList<>();

	public DatabaseTable() {
	}

	public DatabaseTable(DatabaseTableId id) {
		this.id = id;
	}

	@Override
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

	public String getCatalog() {
		return catalog;
	}

	public void setCatalog(String catalog) {
		this.catalog = catalog;
	}

	public String getSchema() {
		return schema;
	}

	public void setSchema(String schema) {
		this.schema = schema;
	}

	@SuppressWarnings("unchecked")
	public Collection<DatabaseTableField> getFields() {
		return fields;
	}

	public void setFields(Collection<? extends IDatabaseTableField> fields) {
		this.fields.clear();
		fields.forEach(r -> { this.fields.add((DatabaseTableField) r); });
	}

	@Override
	public IDatabaseTableField createField(String field) {
		return new DatabaseTableField(new DatabaseTableFieldId(getDomainKey(), getMetaDataId(), getTable(), field));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((catalog == null) ? 0 : catalog.hashCode());
		result = prime * result + ((fields == null) ? 0 : fields.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((schema == null) ? 0 : schema.hashCode());
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
		DatabaseTable other = (DatabaseTable) obj;
		if (catalog == null) {
			if (other.catalog != null)
				return false;
		} else if (!catalog.equals(other.catalog))
			return false;
		if (fields == null) {
			if (other.fields != null)
				return false;
		} else if (!fields.equals(other.fields))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (schema == null) {
			if (other.schema != null)
				return false;
		} else if (!schema.equals(other.schema))
			return false;
		return true;
	}

}
