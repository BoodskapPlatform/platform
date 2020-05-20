package io.boodskap.iot.spi.storage.jpa.config;

import io.boodskap.iot.spi.storage.jpa.DBType;
import io.boodskap.iot.spi.storage.jpa.JPAConfig;

public class MySQLConfig extends JPAConfig {

	private static final long serialVersionUID = 3529774316935098002L;

	public MySQLConfig() {
	}

	@Override
	public void setDefaults() {
		
		super.setDefaults();

		setDbType(DBType.MYSQL);
		
		getProperties().put("hibernate.dialect", DBType.MYSQL.dialect());
		getProperties().put("hibernate.connection.driver_class", DBType.MYSQL.driver());
		getProperties().put("hibernate.connection.username", "root");
		getProperties().put("hibernate.connection.password", "secret");
		getProperties().put("hibernate.connection.url", "jdbc:mysql:///boodskapdb");
		
	}
}
