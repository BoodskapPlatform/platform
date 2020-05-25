package io.boodskap.iot.model.pojo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import io.boodskap.iot.model.IDatabaseTable;
import io.boodskap.iot.model.IDatabaseTableField;

public class DatabaseTable extends AbstractDomainObject implements IDatabaseTable {
	
	private static final long serialVersionUID = -4292175867114525776L;
	
	private String metaDataId;
	private String table;
	private String catalog;
	private String schema;
	private List<IDatabaseTableField> fields = new ArrayList<>();

	public DatabaseTable() {
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

	public List<IDatabaseTableField> getFields() {
		return fields;
	}

	public void setFields(Collection<? extends IDatabaseTableField> fields) {
		this.fields.clear();
		this.fields.addAll(fields);
	}

	@Override
	public IDatabaseTableField createField(String field) {
		DatabaseTableField f = new DatabaseTableField();
		f.setDomainKey(getDomainKey());
		f.setMetaDataId(metaDataId);
		f.setTable(field);
		f.setField(field);
		return f;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((catalog == null) ? 0 : catalog.hashCode());
		result = prime * result + ((fields == null) ? 0 : fields.hashCode());
		result = prime * result + ((metaDataId == null) ? 0 : metaDataId.hashCode());
		result = prime * result + ((schema == null) ? 0 : schema.hashCode());
		result = prime * result + ((table == null) ? 0 : table.hashCode());
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
		if (metaDataId == null) {
			if (other.metaDataId != null)
				return false;
		} else if (!metaDataId.equals(other.metaDataId))
			return false;
		if (schema == null) {
			if (other.schema != null)
				return false;
		} else if (!schema.equals(other.schema))
			return false;
		if (table == null) {
			if (other.table != null)
				return false;
		} else if (!table.equals(other.table))
			return false;
		return true;
	}

}
