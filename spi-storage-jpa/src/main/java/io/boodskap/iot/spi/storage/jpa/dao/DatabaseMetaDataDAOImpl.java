package io.boodskap.iot.spi.storage.jpa.dao;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.DatabaseMetaDataDAO;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.model.jpa.DatabaseMetaData;
import io.boodskap.iot.model.jpa.DatabaseMetaDataId;
import io.boodskap.iot.spi.storage.jpa.dao.util.CommonDAO;

public class DatabaseMetaDataDAOImpl implements DatabaseMetaDataDAO<DatabaseMetaData> {
	
	private static final DatabaseMetaDataDAO<DatabaseMetaData> instance = new DatabaseMetaDataDAOImpl();

	protected DatabaseMetaDataDAOImpl() {
	}
	
	public static final DatabaseMetaDataDAO<DatabaseMetaData> get() {
		return instance;
	}

	@Override
	public DatabaseMetaData create(String domainKey, String metaDataId) {
		return new DatabaseMetaData(new DatabaseMetaDataId(domainKey, metaDataId));
	}

	@Override
	public Class<? extends DatabaseMetaData> clazz() {
		return DatabaseMetaData.class;
	}

	@Override
	public void createOrUpdate(DatabaseMetaData e) {
		// TODO Auto-generated method stub
	}

	@Override
	public DatabaseMetaData get(String domainKey, String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EntityIterator<DatabaseMetaData> load() throws StorageException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EntityIterator<DatabaseMetaData> load(String domainKey) throws StorageException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() throws StorageException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long count(String domainKey) throws StorageException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(String domainKey) throws StorageException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete() throws StorageException {
		new CommonDAO<>(DatabaseMetaData.class).delete();
	}

}
