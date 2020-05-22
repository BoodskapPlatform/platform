package io.boodskap.iot.spi.storage.jpa.config;

import java.io.File;

import io.boodskap.iot.BoodskapSystem;
import io.boodskap.iot.spi.storage.jpa.DBType;
import io.boodskap.iot.spi.storage.jpa.JPAConfig;

public class HSQLDBConfig extends JPAConfig {

	private static final long serialVersionUID = 3589800533000641655L;

	public HSQLDBConfig() {
		setDefaults();
	}

	@Override
	public void setDefaults() {
		
		super.setDefaults();

		setDbType(DBType.HSQLDB);
		
		File folder = new File(BoodskapSystem.get().getDataDir(), "hsqldb");
		folder.mkdirs();
		
		getProperties().put("hibernate.dialect", DBType.HSQLDB.dialect());
		getProperties().put("hibernate.connection.driver_class", DBType.HSQLDB.driver());
		getProperties().put("hibernate.connection.username", "sa");
		getProperties().put("hibernate.connection.password", "");
		getProperties().put("hibernate.connection.url", String.format("jdbc:hsqldb:file:%s/boodskapdb", folder.getAbsolutePath()));
		
	}
}
