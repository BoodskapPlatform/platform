package io.boodskap.iot.spi.storage.jpa;

import javax.persistence.Query;

import io.boodskap.iot.StorageException;

public class NativeQueryBuilder {

	public NativeQueryBuilder() {
	}

	public static Query getCountEntityQuery(String entity, String variable) {
		
		switch(JPA.get().getDbType()) {
		case CASSANDRA:
			String query = String.format("select count(*) as total from %s", entity.toLowerCase()) ;
			return UOW.createNativeQuery(query);
		case MONGODB:
			throw new StorageException("DB Not yet supported");
		default:
			query = String.format("select count(%s) from %s %s", variable, entity, variable);
			return UOW.createQuery(query);
		}
		
	}
}
