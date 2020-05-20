package io.boodskap.iot.model.jpa;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import io.boodskap.iot.model.IDatabaseMetaData;
import io.boodskap.iot.model.IDatabaseTable;

@Entity
@Table(name="databasemetadata")
public class DatabaseMetaData implements IDatabaseMetaData {
	
	private static final long serialVersionUID = 547209306501041052L;
	
	@EmbeddedId
	private DatabaseMetaDataId id = new DatabaseMetaDataId(); 
	@Column
	private Integer databaseMajorVersion;
	@Column
	private Integer databaseMinorVersion;
	@Column
	private Integer driverMajorVersion;
	@Column
	private Integer driverMinorVersion;
	@Column
	private Integer jdbcMajorVersion;
	@Column
	private Integer jdbcMinorVersion;
	@Column
	private Integer maxBinaryLiteralLength;
	@Column
	private Integer maxCatalogNameLength;
	@Column
	private Integer maxCharLiteralLength;
	@Column
	private Integer maxColumnNameLength;
	@Column
	private Integer maxColumnsInGroupBy;
	@Column
	private Integer maxColumnsInIndex;
	@Column
	private Integer maxColumnsInOrderBy;
	@Column
	private Integer maxColumnsInSelect;
	@Column
	private Integer maxColumnsInTable;
	@Column
	private Integer maxConnections;
	@Column
	private Integer maxCursorNameLength;
	@Column
	private Integer maxIndexLength;
	@Column
	private Integer maxProcedureNameLength;
	@Column
	private Integer maxRowSize;
	@Column
	private Integer maxSchemaNameLength;
	@Column
	private Integer maxStatementLength;
	@Column
	private Integer maxStatements;
	@Column
	private Integer maxTableNameLength;
	@Column
	private Integer maxTablesInSelect;
	@Column
	private Integer maxUserNameLength;
	@Column
	private Long maxLogicalLobSize;
	@Column
	private String databaseProductName;
	@Column
	private String databaseProductVersion;
	@Column
	private String driverVersion;
	@Column
	private String driverName;
	@Column
	private String sqlKeywords;
	@Column
	private String numericFunctions;
	@Column
	private String stringFunctions;
	@Column
	private String systemFunctions;
	@Column
	private String timeDateFunctions;

	@ElementCollection()
	private List<String> catalogs = new ArrayList<>();

	@ElementCollection()
	private List<String> schemas = new ArrayList<>();

	@OneToMany(cascade=CascadeType.ALL, targetEntity=DatabaseTable.class)
	private List<DatabaseTable> tables = new ArrayList<>();

	@OneToMany(cascade=CascadeType.ALL, targetEntity=DatabaseTable.class)
	private List<DatabaseTable> views = new ArrayList<>();

	@OneToMany(cascade=CascadeType.ALL, targetEntity=DatabaseTable.class)
	private List<DatabaseTable> systables = new ArrayList<>();

	@OneToMany(cascade=CascadeType.ALL, targetEntity=DatabaseTable.class)
	private List<DatabaseTable> gbltempTables = new ArrayList<>();

	@OneToMany(cascade=CascadeType.ALL, targetEntity=DatabaseTable.class)
	private List<DatabaseTable> lcltempTables = new ArrayList<>();

	@OneToMany(cascade=CascadeType.ALL, targetEntity=DatabaseTable.class)
	private List<DatabaseTable> aliases = new ArrayList<>();

	@OneToMany(cascade=CascadeType.ALL, targetEntity=DatabaseTable.class)
	private List<DatabaseTable> synonyms = new ArrayList<>();

	public DatabaseMetaData() {
	}
	
	public DatabaseMetaData(DatabaseMetaDataId id) {
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

	public String getDatabaseProductName() {
		return databaseProductName;
	}

	public void setDatabaseProductName(String databaseProductName) {
		this.databaseProductName = databaseProductName;
	}

	public String getDatabaseProductVersion() {
		return databaseProductVersion;
	}

	public void setDatabaseProductVersion(String databaseProductVersion) {
		this.databaseProductVersion = databaseProductVersion;
	}

	public Integer getDatabaseMajorVersion() {
		return databaseMajorVersion;
	}

	public void setDatabaseMajorVersion(Integer databaseMajorVersion) {
		this.databaseMajorVersion = databaseMajorVersion;
	}

	public Integer getDatabaseMinorVersion() {
		return databaseMinorVersion;
	}

	public void setDatabaseMinorVersion(Integer databaseMinorVersion) {
		this.databaseMinorVersion = databaseMinorVersion;
	}

	public String getDriverVersion() {
		return driverVersion;
	}

	public void setDriverVersion(String driverVersion) {
		this.driverVersion = driverVersion;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public Integer getDriverMajorVersion() {
		return driverMajorVersion;
	}

	public void setDriverMajorVersion(Integer driverMajorVersion) {
		this.driverMajorVersion = driverMajorVersion;
	}

	public Integer getDriverMinorVersion() {
		return driverMinorVersion;
	}

	public void setDriverMinorVersion(Integer driverMinorVersion) {
		this.driverMinorVersion = driverMinorVersion;
	}

	public Integer getJdbcMajorVersion() {
		return jdbcMajorVersion;
	}

	public void setJdbcMajorVersion(Integer jdbcMajorVersion) {
		this.jdbcMajorVersion = jdbcMajorVersion;
	}

	public Integer getJdbcMinorVersion() {
		return jdbcMinorVersion;
	}

	public void setJdbcMinorVersion(Integer jdbcMinorVersion) {
		this.jdbcMinorVersion = jdbcMinorVersion;
	}

	public Integer getMaxBinaryLiteralLength() {
		return maxBinaryLiteralLength;
	}

	public void setMaxBinaryLiteralLength(Integer maxBinaryLiteralLength) {
		this.maxBinaryLiteralLength = maxBinaryLiteralLength;
	}

	public Integer getMaxCatalogNameLength() {
		return maxCatalogNameLength;
	}

	public void setMaxCatalogNameLength(Integer maxCatalogNameLength) {
		this.maxCatalogNameLength = maxCatalogNameLength;
	}

	public Integer getMaxCharLiteralLength() {
		return maxCharLiteralLength;
	}

	public void setMaxCharLiteralLength(Integer maxCharLiteralLength) {
		this.maxCharLiteralLength = maxCharLiteralLength;
	}

	public Integer getMaxColumnNameLength() {
		return maxColumnNameLength;
	}

	public void setMaxColumnNameLength(Integer maxColumnNameLength) {
		this.maxColumnNameLength = maxColumnNameLength;
	}

	public Integer getMaxColumnsInGroupBy() {
		return maxColumnsInGroupBy;
	}

	public void setMaxColumnsInGroupBy(Integer maxColumnsInGroupBy) {
		this.maxColumnsInGroupBy = maxColumnsInGroupBy;
	}

	public Integer getMaxColumnsInIndex() {
		return maxColumnsInIndex;
	}

	public void setMaxColumnsInIndex(Integer maxColumnsInIndex) {
		this.maxColumnsInIndex = maxColumnsInIndex;
	}

	public Integer getMaxColumnsInOrderBy() {
		return maxColumnsInOrderBy;
	}

	public void setMaxColumnsInOrderBy(Integer maxColumnsInOrderBy) {
		this.maxColumnsInOrderBy = maxColumnsInOrderBy;
	}

	public Integer getMaxColumnsInSelect() {
		return maxColumnsInSelect;
	}

	public void setMaxColumnsInSelect(Integer maxColumnsInSelect) {
		this.maxColumnsInSelect = maxColumnsInSelect;
	}

	public Integer getMaxColumnsInTable() {
		return maxColumnsInTable;
	}

	public void setMaxColumnsInTable(Integer maxColumnsInTable) {
		this.maxColumnsInTable = maxColumnsInTable;
	}

	public Integer getMaxConnections() {
		return maxConnections;
	}

	public void setMaxConnections(Integer maxConnections) {
		this.maxConnections = maxConnections;
	}

	public Integer getMaxCursorNameLength() {
		return maxCursorNameLength;
	}

	public void setMaxCursorNameLength(Integer maxCursorNameLength) {
		this.maxCursorNameLength = maxCursorNameLength;
	}

	public Integer getMaxIndexLength() {
		return maxIndexLength;
	}

	public void setMaxIndexLength(Integer maxIndexLength) {
		this.maxIndexLength = maxIndexLength;
	}

	public Long getMaxLogicalLobSize() {
		return maxLogicalLobSize;
	}

	public void setMaxLogicalLobSize(Long maxLogicalLobSize) {
		this.maxLogicalLobSize = maxLogicalLobSize;
	}

	public Integer getMaxProcedureNameLength() {
		return maxProcedureNameLength;
	}

	public void setMaxProcedureNameLength(Integer maxProcedureNameLength) {
		this.maxProcedureNameLength = maxProcedureNameLength;
	}

	public Integer getMaxRowSize() {
		return maxRowSize;
	}

	public void setMaxRowSize(Integer maxRowSize) {
		this.maxRowSize = maxRowSize;
	}

	public Integer getMaxSchemaNameLength() {
		return maxSchemaNameLength;
	}

	public void setMaxSchemaNameLength(Integer maxSchemaNameLength) {
		this.maxSchemaNameLength = maxSchemaNameLength;
	}

	public Integer getMaxStatementLength() {
		return maxStatementLength;
	}

	public void setMaxStatementLength(Integer maxStatementLength) {
		this.maxStatementLength = maxStatementLength;
	}

	public Integer getMaxStatements() {
		return maxStatements;
	}

	public void setMaxStatements(Integer maxStatements) {
		this.maxStatements = maxStatements;
	}

	public Integer getMaxTableNameLength() {
		return maxTableNameLength;
	}

	public void setMaxTableNameLength(Integer maxTableNameLength) {
		this.maxTableNameLength = maxTableNameLength;
	}

	public Integer getMaxTablesInSelect() {
		return maxTablesInSelect;
	}

	public void setMaxTablesInSelect(Integer maxTablesInSelect) {
		this.maxTablesInSelect = maxTablesInSelect;
	}

	public Integer getMaxUserNameLength() {
		return maxUserNameLength;
	}

	public void setMaxUserNameLength(Integer maxUserNameLength) {
		this.maxUserNameLength = maxUserNameLength;
	}

	public String getSqlKeywords() {
		return sqlKeywords;
	}

	public void setSqlKeywords(String sqlKeywords) {
		this.sqlKeywords = sqlKeywords;
	}

	public String getNumericFunctions() {
		return numericFunctions;
	}

	public void setNumericFunctions(String numericFunctions) {
		this.numericFunctions = numericFunctions;
	}

	public String getStringFunctions() {
		return stringFunctions;
	}

	public void setStringFunctions(String stringFunctions) {
		this.stringFunctions = stringFunctions;
	}

	public String getSystemFunctions() {
		return systemFunctions;
	}

	public void setSystemFunctions(String systemFunctions) {
		this.systemFunctions = systemFunctions;
	}

	public String getTimeDateFunctions() {
		return timeDateFunctions;
	}

	public void setTimeDateFunctions(String timeDateFunctions) {
		this.timeDateFunctions = timeDateFunctions;
	}

	public Collection<String> getSchemas() {
		return schemas;
	}

	public void setSchemas(Collection<String> schemas) {
		this.schemas.clear();
		this.schemas.addAll(schemas);
	}

	public Collection<String> getCatalogs() {
		return catalogs;
	}

	public void setCatalogs(Collection<String> catalogs) {
		this.catalogs.clear();
		this.catalogs.addAll(catalogs);
	}

	@SuppressWarnings("unchecked")
	public Collection<DatabaseTable> getTables() {
		return tables;
	}

	public void setTables(Collection<? extends IDatabaseTable> tables) {
		this.tables.clear();
		tables.forEach(r -> {this.tables.add((DatabaseTable) r);});
	}

	@SuppressWarnings("unchecked")
	public Collection<DatabaseTable> getViews() {
		return views;
	}

	public void setViews(Collection<? extends IDatabaseTable> views) {
		this.views.clear();
		views.forEach(r -> {this.views.add((DatabaseTable) r);});
	}

	@SuppressWarnings("unchecked")
	public Collection<DatabaseTable> getSystables() {
		return systables;
	}

	public void setSystables(Collection<? extends IDatabaseTable> systables) {
		this.systables.clear();
		systables.forEach(r -> {this.systables.add((DatabaseTable) r);});
	}

	@SuppressWarnings("unchecked")
	public Collection<DatabaseTable> getGbltempTables() {
		return gbltempTables;
	}

	public void setGbltempTables(Collection<? extends IDatabaseTable> gbltempTables) {
		this.gbltempTables.clear();
		gbltempTables.forEach(r -> {this.gbltempTables.add((DatabaseTable) r);});
	}

	@SuppressWarnings("unchecked")
	public Collection<DatabaseTable> getLcltempTables() {
		return lcltempTables;
	}

	public void setLcltempTables(Collection<? extends IDatabaseTable> lcltempTables) {
		this.lcltempTables.clear();
		lcltempTables.forEach(r -> {this.lcltempTables.add((DatabaseTable) r);});
	}

	@SuppressWarnings("unchecked")
	public Collection<DatabaseTable> getAliases() {
		return aliases;
	}

	public void setAliases(Collection<? extends IDatabaseTable> aliases) {
		this.aliases.clear();
		aliases.forEach(r -> {this.aliases.add((DatabaseTable) r);});
	}

	@SuppressWarnings("unchecked")
	public Collection<DatabaseTable> getSynonyms() {
		return synonyms;
	}

	public void setSynonyms(Collection<? extends IDatabaseTable> synonyms) {
		this.synonyms.clear();
		synonyms.forEach(r -> {this.synonyms.add((DatabaseTable) r);});
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aliases == null) ? 0 : aliases.hashCode());
		result = prime * result + ((catalogs == null) ? 0 : catalogs.hashCode());
		result = prime * result + ((databaseMajorVersion == null) ? 0 : databaseMajorVersion.hashCode());
		result = prime * result + ((databaseMinorVersion == null) ? 0 : databaseMinorVersion.hashCode());
		result = prime * result + ((databaseProductName == null) ? 0 : databaseProductName.hashCode());
		result = prime * result + ((databaseProductVersion == null) ? 0 : databaseProductVersion.hashCode());
		result = prime * result + ((driverMajorVersion == null) ? 0 : driverMajorVersion.hashCode());
		result = prime * result + ((driverMinorVersion == null) ? 0 : driverMinorVersion.hashCode());
		result = prime * result + ((driverName == null) ? 0 : driverName.hashCode());
		result = prime * result + ((driverVersion == null) ? 0 : driverVersion.hashCode());
		result = prime * result + ((gbltempTables == null) ? 0 : gbltempTables.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((jdbcMajorVersion == null) ? 0 : jdbcMajorVersion.hashCode());
		result = prime * result + ((jdbcMinorVersion == null) ? 0 : jdbcMinorVersion.hashCode());
		result = prime * result + ((lcltempTables == null) ? 0 : lcltempTables.hashCode());
		result = prime * result + ((maxBinaryLiteralLength == null) ? 0 : maxBinaryLiteralLength.hashCode());
		result = prime * result + ((maxCatalogNameLength == null) ? 0 : maxCatalogNameLength.hashCode());
		result = prime * result + ((maxCharLiteralLength == null) ? 0 : maxCharLiteralLength.hashCode());
		result = prime * result + ((maxColumnNameLength == null) ? 0 : maxColumnNameLength.hashCode());
		result = prime * result + ((maxColumnsInGroupBy == null) ? 0 : maxColumnsInGroupBy.hashCode());
		result = prime * result + ((maxColumnsInIndex == null) ? 0 : maxColumnsInIndex.hashCode());
		result = prime * result + ((maxColumnsInOrderBy == null) ? 0 : maxColumnsInOrderBy.hashCode());
		result = prime * result + ((maxColumnsInSelect == null) ? 0 : maxColumnsInSelect.hashCode());
		result = prime * result + ((maxColumnsInTable == null) ? 0 : maxColumnsInTable.hashCode());
		result = prime * result + ((maxConnections == null) ? 0 : maxConnections.hashCode());
		result = prime * result + ((maxCursorNameLength == null) ? 0 : maxCursorNameLength.hashCode());
		result = prime * result + ((maxIndexLength == null) ? 0 : maxIndexLength.hashCode());
		result = prime * result + ((maxLogicalLobSize == null) ? 0 : maxLogicalLobSize.hashCode());
		result = prime * result + ((maxProcedureNameLength == null) ? 0 : maxProcedureNameLength.hashCode());
		result = prime * result + ((maxRowSize == null) ? 0 : maxRowSize.hashCode());
		result = prime * result + ((maxSchemaNameLength == null) ? 0 : maxSchemaNameLength.hashCode());
		result = prime * result + ((maxStatementLength == null) ? 0 : maxStatementLength.hashCode());
		result = prime * result + ((maxStatements == null) ? 0 : maxStatements.hashCode());
		result = prime * result + ((maxTableNameLength == null) ? 0 : maxTableNameLength.hashCode());
		result = prime * result + ((maxTablesInSelect == null) ? 0 : maxTablesInSelect.hashCode());
		result = prime * result + ((maxUserNameLength == null) ? 0 : maxUserNameLength.hashCode());
		result = prime * result + ((numericFunctions == null) ? 0 : numericFunctions.hashCode());
		result = prime * result + ((schemas == null) ? 0 : schemas.hashCode());
		result = prime * result + ((sqlKeywords == null) ? 0 : sqlKeywords.hashCode());
		result = prime * result + ((stringFunctions == null) ? 0 : stringFunctions.hashCode());
		result = prime * result + ((synonyms == null) ? 0 : synonyms.hashCode());
		result = prime * result + ((systables == null) ? 0 : systables.hashCode());
		result = prime * result + ((systemFunctions == null) ? 0 : systemFunctions.hashCode());
		result = prime * result + ((tables == null) ? 0 : tables.hashCode());
		result = prime * result + ((timeDateFunctions == null) ? 0 : timeDateFunctions.hashCode());
		result = prime * result + ((views == null) ? 0 : views.hashCode());
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
		DatabaseMetaData other = (DatabaseMetaData) obj;
		if (aliases == null) {
			if (other.aliases != null)
				return false;
		} else if (!aliases.equals(other.aliases))
			return false;
		if (catalogs == null) {
			if (other.catalogs != null)
				return false;
		} else if (!catalogs.equals(other.catalogs))
			return false;
		if (databaseMajorVersion == null) {
			if (other.databaseMajorVersion != null)
				return false;
		} else if (!databaseMajorVersion.equals(other.databaseMajorVersion))
			return false;
		if (databaseMinorVersion == null) {
			if (other.databaseMinorVersion != null)
				return false;
		} else if (!databaseMinorVersion.equals(other.databaseMinorVersion))
			return false;
		if (databaseProductName == null) {
			if (other.databaseProductName != null)
				return false;
		} else if (!databaseProductName.equals(other.databaseProductName))
			return false;
		if (databaseProductVersion == null) {
			if (other.databaseProductVersion != null)
				return false;
		} else if (!databaseProductVersion.equals(other.databaseProductVersion))
			return false;
		if (driverMajorVersion == null) {
			if (other.driverMajorVersion != null)
				return false;
		} else if (!driverMajorVersion.equals(other.driverMajorVersion))
			return false;
		if (driverMinorVersion == null) {
			if (other.driverMinorVersion != null)
				return false;
		} else if (!driverMinorVersion.equals(other.driverMinorVersion))
			return false;
		if (driverName == null) {
			if (other.driverName != null)
				return false;
		} else if (!driverName.equals(other.driverName))
			return false;
		if (driverVersion == null) {
			if (other.driverVersion != null)
				return false;
		} else if (!driverVersion.equals(other.driverVersion))
			return false;
		if (gbltempTables == null) {
			if (other.gbltempTables != null)
				return false;
		} else if (!gbltempTables.equals(other.gbltempTables))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (jdbcMajorVersion == null) {
			if (other.jdbcMajorVersion != null)
				return false;
		} else if (!jdbcMajorVersion.equals(other.jdbcMajorVersion))
			return false;
		if (jdbcMinorVersion == null) {
			if (other.jdbcMinorVersion != null)
				return false;
		} else if (!jdbcMinorVersion.equals(other.jdbcMinorVersion))
			return false;
		if (lcltempTables == null) {
			if (other.lcltempTables != null)
				return false;
		} else if (!lcltempTables.equals(other.lcltempTables))
			return false;
		if (maxBinaryLiteralLength == null) {
			if (other.maxBinaryLiteralLength != null)
				return false;
		} else if (!maxBinaryLiteralLength.equals(other.maxBinaryLiteralLength))
			return false;
		if (maxCatalogNameLength == null) {
			if (other.maxCatalogNameLength != null)
				return false;
		} else if (!maxCatalogNameLength.equals(other.maxCatalogNameLength))
			return false;
		if (maxCharLiteralLength == null) {
			if (other.maxCharLiteralLength != null)
				return false;
		} else if (!maxCharLiteralLength.equals(other.maxCharLiteralLength))
			return false;
		if (maxColumnNameLength == null) {
			if (other.maxColumnNameLength != null)
				return false;
		} else if (!maxColumnNameLength.equals(other.maxColumnNameLength))
			return false;
		if (maxColumnsInGroupBy == null) {
			if (other.maxColumnsInGroupBy != null)
				return false;
		} else if (!maxColumnsInGroupBy.equals(other.maxColumnsInGroupBy))
			return false;
		if (maxColumnsInIndex == null) {
			if (other.maxColumnsInIndex != null)
				return false;
		} else if (!maxColumnsInIndex.equals(other.maxColumnsInIndex))
			return false;
		if (maxColumnsInOrderBy == null) {
			if (other.maxColumnsInOrderBy != null)
				return false;
		} else if (!maxColumnsInOrderBy.equals(other.maxColumnsInOrderBy))
			return false;
		if (maxColumnsInSelect == null) {
			if (other.maxColumnsInSelect != null)
				return false;
		} else if (!maxColumnsInSelect.equals(other.maxColumnsInSelect))
			return false;
		if (maxColumnsInTable == null) {
			if (other.maxColumnsInTable != null)
				return false;
		} else if (!maxColumnsInTable.equals(other.maxColumnsInTable))
			return false;
		if (maxConnections == null) {
			if (other.maxConnections != null)
				return false;
		} else if (!maxConnections.equals(other.maxConnections))
			return false;
		if (maxCursorNameLength == null) {
			if (other.maxCursorNameLength != null)
				return false;
		} else if (!maxCursorNameLength.equals(other.maxCursorNameLength))
			return false;
		if (maxIndexLength == null) {
			if (other.maxIndexLength != null)
				return false;
		} else if (!maxIndexLength.equals(other.maxIndexLength))
			return false;
		if (maxLogicalLobSize == null) {
			if (other.maxLogicalLobSize != null)
				return false;
		} else if (!maxLogicalLobSize.equals(other.maxLogicalLobSize))
			return false;
		if (maxProcedureNameLength == null) {
			if (other.maxProcedureNameLength != null)
				return false;
		} else if (!maxProcedureNameLength.equals(other.maxProcedureNameLength))
			return false;
		if (maxRowSize == null) {
			if (other.maxRowSize != null)
				return false;
		} else if (!maxRowSize.equals(other.maxRowSize))
			return false;
		if (maxSchemaNameLength == null) {
			if (other.maxSchemaNameLength != null)
				return false;
		} else if (!maxSchemaNameLength.equals(other.maxSchemaNameLength))
			return false;
		if (maxStatementLength == null) {
			if (other.maxStatementLength != null)
				return false;
		} else if (!maxStatementLength.equals(other.maxStatementLength))
			return false;
		if (maxStatements == null) {
			if (other.maxStatements != null)
				return false;
		} else if (!maxStatements.equals(other.maxStatements))
			return false;
		if (maxTableNameLength == null) {
			if (other.maxTableNameLength != null)
				return false;
		} else if (!maxTableNameLength.equals(other.maxTableNameLength))
			return false;
		if (maxTablesInSelect == null) {
			if (other.maxTablesInSelect != null)
				return false;
		} else if (!maxTablesInSelect.equals(other.maxTablesInSelect))
			return false;
		if (maxUserNameLength == null) {
			if (other.maxUserNameLength != null)
				return false;
		} else if (!maxUserNameLength.equals(other.maxUserNameLength))
			return false;
		if (numericFunctions == null) {
			if (other.numericFunctions != null)
				return false;
		} else if (!numericFunctions.equals(other.numericFunctions))
			return false;
		if (schemas == null) {
			if (other.schemas != null)
				return false;
		} else if (!schemas.equals(other.schemas))
			return false;
		if (sqlKeywords == null) {
			if (other.sqlKeywords != null)
				return false;
		} else if (!sqlKeywords.equals(other.sqlKeywords))
			return false;
		if (stringFunctions == null) {
			if (other.stringFunctions != null)
				return false;
		} else if (!stringFunctions.equals(other.stringFunctions))
			return false;
		if (synonyms == null) {
			if (other.synonyms != null)
				return false;
		} else if (!synonyms.equals(other.synonyms))
			return false;
		if (systables == null) {
			if (other.systables != null)
				return false;
		} else if (!systables.equals(other.systables))
			return false;
		if (systemFunctions == null) {
			if (other.systemFunctions != null)
				return false;
		} else if (!systemFunctions.equals(other.systemFunctions))
			return false;
		if (tables == null) {
			if (other.tables != null)
				return false;
		} else if (!tables.equals(other.tables))
			return false;
		if (timeDateFunctions == null) {
			if (other.timeDateFunctions != null)
				return false;
		} else if (!timeDateFunctions.equals(other.timeDateFunctions))
			return false;
		if (views == null) {
			if (other.views != null)
				return false;
		} else if (!views.equals(other.views))
			return false;
		return true;
	}

}
