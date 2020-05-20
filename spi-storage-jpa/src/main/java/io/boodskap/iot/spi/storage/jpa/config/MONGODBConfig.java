package io.boodskap.iot.spi.storage.jpa.config;

import io.boodskap.iot.spi.storage.jpa.DBType;
import io.boodskap.iot.spi.storage.jpa.JPANoSqlConfig;

public class MONGODBConfig extends JPANoSqlConfig {

	private static final long serialVersionUID = -1256349062743577630L;

	public MONGODBConfig() {
	}

	@Override
	public void setDefaults() {
		
		super.setDefaults();

		setDbType(DBType.MONGODB);
		
		getProperties().put("kundera.dialect", DBType.MONGODB.dialect());
		getProperties().put("kundera.client.lookup.class", DBType.MONGODB.driver());
		
		getProperties().put("kundera.nodes", "127.0.0.1");
		getProperties().put("kundera.port", "27017");
		
	}
}
