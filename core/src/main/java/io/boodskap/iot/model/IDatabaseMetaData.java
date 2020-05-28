/*******************************************************************************
 * Copyright (C) 2019 Boodskap Inc
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/
package io.boodskap.iot.model;

import java.util.Collection;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import io.boodskap.iot.dao.DatabaseMetaDataDAO;

@JsonSerialize(as=IDatabaseMetaData.class)
public interface IDatabaseMetaData extends IDomainObject{
	
	public static DatabaseMetaDataDAO<IDatabaseMetaData> dao(){
		return DatabaseMetaDataDAO.get();
	}
	
	public static IDatabaseMetaData create(String domainKey, String metaDataId) {
		return dao().create(domainKey, metaDataId);
	}

	public static IDatabaseMetaData find(String domainKey, String metaDataId) {
		return dao().get(domainKey, metaDataId);
	}

	public static Class<? extends IDatabaseMetaData> clazz() {
		return dao().clazz();
	}

	public default void save() {
		IDatabaseMetaData.dao().createOrUpdate(this);
	}
	
	@Override
	public default void copy(Object other) {
		
		IDatabaseMetaData o = (IDatabaseMetaData) other;
		
		setMetaDataId(o.getMetaDataId());
		setDatabaseProductName(o.getDatabaseProductName());
		setDatabaseProductVersion(o.getDatabaseProductVersion());
		setDatabaseMajorVersion(o.getDatabaseMajorVersion());
		setDatabaseMinorVersion(o.getDatabaseMinorVersion());
		setDriverVersion(o.getDriverVersion());
		setDriverName(o.getDriverName());
		setDriverMajorVersion(o.getDriverMajorVersion());
		setDriverMinorVersion(o.getDriverMinorVersion());
		setJdbcMajorVersion(o.getJdbcMajorVersion());
		setJdbcMinorVersion(o.getJdbcMinorVersion());
		setMaxBinaryLiteralLength(o.getMaxBinaryLiteralLength());
		setMaxCatalogNameLength(o.getMaxCatalogNameLength());
		setMaxCharLiteralLength(o.getMaxCharLiteralLength());
		setMaxColumnNameLength(o.getMaxColumnNameLength());
		setMaxColumnsInGroupBy(o.getMaxColumnsInGroupBy());
		setMaxColumnsInIndex(o.getMaxColumnsInIndex());
		setMaxColumnsInOrderBy(o.getMaxColumnsInOrderBy());
		setMaxColumnsInSelect(o.getMaxColumnsInSelect());
		setMaxColumnsInTable(o.getMaxColumnsInTable());
		setMaxConnections(o.getMaxConnections());
		setMaxCursorNameLength(o.getMaxCursorNameLength());
		setMaxIndexLength(o.getMaxIndexLength());
		setMaxLogicalLobSize(o.getMaxLogicalLobSize());
		setMaxProcedureNameLength(o.getMaxProcedureNameLength());
		setMaxRowSize(o.getMaxRowSize());
		setMaxSchemaNameLength(o.getMaxSchemaNameLength());
		setMaxStatementLength(o.getMaxStatementLength());
		setMaxStatements(o.getMaxStatements());
		setMaxTableNameLength(o.getMaxTableNameLength());
		setMaxUserNameLength(o.getMaxUserNameLength());
		setSqlKeywords(o.getSqlKeywords());
		setNumericFunctions(o.getNumericFunctions());
		setStringFunctions(o.getStringFunctions());
		setSystemFunctions(o.getSystemFunctions());
		setTimeDateFunctions(o.getTimeDateFunctions());
		setSchemas(o.getSchemas());
		setCatalogs(o.getCatalogs());
		setTables(o.getTables());
		setViews(o.getViews());
		setSystables(o.getSystables());
		setGbltempTables(o.getGbltempTables());
		setLcltempTables(o.getLcltempTables());
		setAliases(o.getAliases());
		setSynonyms(o.getSynonyms());
		
		IDomainObject.super.copy(other);
	}

	public String getMetaDataId();

	public void setMetaDataId(String metaDataId);

	public String getDatabaseProductName();

	public void setDatabaseProductName(String databaseProductName);

	public String getDatabaseProductVersion();

	public void setDatabaseProductVersion(String databaseProductVersion);

	public Integer getDatabaseMajorVersion();

	public void setDatabaseMajorVersion(Integer databaseMajorVersion);

	public Integer getDatabaseMinorVersion();

	public void setDatabaseMinorVersion(Integer databaseMinorVersion);

	public String getDriverVersion();

	public void setDriverVersion(String driverVersion);

	public String getDriverName();

	public void setDriverName(String driverName);

	public Integer getDriverMajorVersion();

	public void setDriverMajorVersion(Integer driverMajorVersion);

	public Integer getDriverMinorVersion();

	public void setDriverMinorVersion(Integer driverMinorVersion);

	public Integer getJdbcMajorVersion();

	public void setJdbcMajorVersion(Integer jdbcMajorVersion);

	public Integer getJdbcMinorVersion();

	public void setJdbcMinorVersion(Integer jdbcMinorVersion);

	public Integer getMaxBinaryLiteralLength();

	public void setMaxBinaryLiteralLength(Integer maxBinaryLiteralLength);

	public Integer getMaxCatalogNameLength();

	public void setMaxCatalogNameLength(Integer maxCatalogNameLength);

	public Integer getMaxCharLiteralLength();

	public void setMaxCharLiteralLength(Integer maxCharLiteralLength);

	public Integer getMaxColumnNameLength();

	public void setMaxColumnNameLength(Integer maxColumnNameLength);

	public Integer getMaxColumnsInGroupBy();

	public void setMaxColumnsInGroupBy(Integer maxColumnsInGroupBy);

	public Integer getMaxColumnsInIndex();

	public void setMaxColumnsInIndex(Integer maxColumnsInIndex);

	public Integer getMaxColumnsInOrderBy();

	public void setMaxColumnsInOrderBy(Integer maxColumnsInOrderBy);

	public Integer getMaxColumnsInSelect();

	public void setMaxColumnsInSelect(Integer maxColumnsInSelect);

	public Integer getMaxColumnsInTable();

	public void setMaxColumnsInTable(Integer maxColumnsInTable);

	public Integer getMaxConnections();

	public void setMaxConnections(Integer maxConnections);

	public Integer getMaxCursorNameLength();

	public void setMaxCursorNameLength(Integer maxCursorNameLength);

	public Integer getMaxIndexLength();

	public void setMaxIndexLength(Integer maxIndexLength);

	public Long getMaxLogicalLobSize();

	public void setMaxLogicalLobSize(Long maxLogicalLobSize);

	public Integer getMaxProcedureNameLength();

	public void setMaxProcedureNameLength(Integer maxProcedureNameLength);

	public Integer getMaxRowSize();

	public void setMaxRowSize(Integer maxRowSize);

	public Integer getMaxSchemaNameLength();

	public void setMaxSchemaNameLength(Integer maxSchemaNameLength);

	public Integer getMaxStatementLength();

	public void setMaxStatementLength(Integer maxStatementLength);

	public Integer getMaxStatements();

	public void setMaxStatements(Integer maxStatements);

	public Integer getMaxTableNameLength();

	public void setMaxTableNameLength(Integer maxTableNameLength);

	public Integer getMaxTablesInSelect();

	public void setMaxTablesInSelect(Integer maxTablesInSelect);

	public Integer getMaxUserNameLength();

	public void setMaxUserNameLength(Integer maxUserNameLength);

	public String getSqlKeywords();

	public void setSqlKeywords(String sqlKeywords);

	public String getNumericFunctions();

	public void setNumericFunctions(String numericFunctions);

	public String getStringFunctions();

	public void setStringFunctions(String stringFunctions);

	public String getSystemFunctions();

	public void setSystemFunctions(String systemFunctions);

	public String getTimeDateFunctions();

	public void setTimeDateFunctions(String timeDateFunctions);

	public Collection<String> getSchemas();

	public void setSchemas(Collection<String> schemas);

	public Collection<String> getCatalogs();

	public void setCatalogs(Collection<String> catalogs);

	public <T extends IDatabaseTable> Collection<T> getTables();

	public void setTables(Collection<? extends IDatabaseTable> tables);

	public <T extends IDatabaseTable> Collection<T> getViews();

	public void setViews(Collection<? extends IDatabaseTable> views);

	public <T extends IDatabaseTable> Collection<T> getSystables();

	public void setSystables(Collection<? extends IDatabaseTable> systables);

	public <T extends IDatabaseTable> Collection<T> getGbltempTables();

	public void setGbltempTables(Collection<? extends IDatabaseTable> gbltempTables);

	public <T extends IDatabaseTable> Collection<T> getLcltempTables();

	public void setLcltempTables(Collection<? extends IDatabaseTable> lcltempTables);

	public <T extends IDatabaseTable> Collection<T> getAliases();

	public void setAliases(Collection<? extends IDatabaseTable> aliases);

	public <T extends IDatabaseTable> Collection<T> getSynonyms();

	public void setSynonyms(Collection<? extends IDatabaseTable> synonyms);

}
