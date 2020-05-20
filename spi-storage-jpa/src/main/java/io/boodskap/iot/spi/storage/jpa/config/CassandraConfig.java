package io.boodskap.iot.spi.storage.jpa.config;

import io.boodskap.iot.spi.storage.jpa.DBType;
import io.boodskap.iot.spi.storage.jpa.JPANoSqlConfig;

public class CassandraConfig extends JPANoSqlConfig {

	private static final long serialVersionUID = 6936653870983759155L;

	public CassandraConfig() {
	}

	@Override
	public void setDefaults() {
		
		super.setDefaults();
		
		setDbType(DBType.CASSANDRA);
		
		getProperties().put("kundera.dialect", DBType.CASSANDRA.dialect());
		getProperties().put("kundera.client.lookup.class", DBType.CASSANDRA.driver());
		getProperties().put("kundera.username", "sa");
		getProperties().put("kundera.password", "");

		getProperties().put("kundera.nodes", "127.0.0.1");
		getProperties().put("kundera.port", "9042");
		getProperties().put("inverted.indexing.enabled", "true");
		getProperties().put("cql.version", "3.0.0");
	}
}
