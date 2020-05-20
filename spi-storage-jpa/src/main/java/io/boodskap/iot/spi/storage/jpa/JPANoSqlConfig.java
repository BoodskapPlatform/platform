package io.boodskap.iot.spi.storage.jpa;

import java.util.HashMap;
import java.util.Map;

public abstract class JPANoSqlConfig extends JPAConfig {
	
	private static final long serialVersionUID = 3031713250229088356L;
	
	private String persistenceUnit = "boodskap_pu";
	private DBType dbType;
	private Map<String, String> properties = new HashMap<>();

	public JPANoSqlConfig() {
	}

	@Override
	public void setDefaults() {

		getProperties().put("kundera.keyspace", "boodskapdb");
		getProperties().put("kundera.ddl.auto.prepare", "update");
		getProperties().put("kundera.show.query", "true");
		getProperties().put("testonborrow", "true");
		getProperties().put("testonconnect", "true");
		getProperties().put("testwhileidle", "false");
		getProperties().put("testonretrun", "false");
		getProperties().put("kundera.pool.size.max.active", "50");
		getProperties().put("kundera.pool.size.max.idle", "50");
		getProperties().put("kundera.pool.size.max.total", "100");
		
	}

	public String getPersistenceUnit() {
		return persistenceUnit;
	}

	public void setPersistenceUnit(String persistenceUnit) {
		this.persistenceUnit = persistenceUnit;
	}

	public DBType getDbType() {
		return dbType;
	}

	public void setDbType(DBType dbType) {
		this.dbType = dbType;
	}

	public Map<String, String> getProperties() {
		return properties;
	}

	public void setProperties(Map<String, String> properties) {
		this.properties = properties;
	}

}
