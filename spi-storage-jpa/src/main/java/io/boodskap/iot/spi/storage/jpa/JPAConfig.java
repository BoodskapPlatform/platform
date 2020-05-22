package io.boodskap.iot.spi.storage.jpa;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.boodskap.iot.IConfig;

/**
 * https://github.com/hibernate/hibernate-orm/blob/master/etc/hibernate.properties.template
 * 
 * @author jegan
 *
 */
public abstract class JPAConfig implements IConfig {
	
	private static final long serialVersionUID = 3031713250229088356L;
	
	private String persistenceUnit = "boodskap_pu";
	private DBType dbType = DBType.HSQLDB;
	private Map<String, String> properties = new HashMap<>();

	public JPAConfig() {
		setDefaults();
	}

	@Override
	@JsonIgnore
	public int getStartPriority() {
		return 1;
	}

	@Override
	public void setDefaults() {

		getProperties().put("hibernate.archive.autodetection", "class");
		getProperties().put("hibernate.show_sql", "false");
		getProperties().put("hibernate.format_sql", "false");
		getProperties().put("hibernate.hbm2ddl.auto", "update");
		getProperties().put("hibernate.connection.initial_pool_size", "3");
		getProperties().put("hibernate.connection.min_pool_size", "3");
		getProperties().put("hibernate.connection.pool_size", "50");
		getProperties().put("hibernate.connection.pool_validation_interval", "30");
		
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
