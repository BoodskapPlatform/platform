package io.boodskap.iot.spi.storage.jpa.dao;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.DatabaseTableDAO;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.model.IDatabaseTable;
import io.boodskap.iot.model.IDatabaseTableField;
import io.boodskap.iot.model.jpa.DatabaseTable;
import io.boodskap.iot.model.jpa.DatabaseTableField;
import io.boodskap.iot.model.jpa.DatabaseTableId;
import io.boodskap.iot.spi.storage.jpa.UOW;
import io.boodskap.iot.spi.storage.jpa.dao.util.CommonDAO;
import io.boodskap.iot.spi.storage.jpa.dao.util.EntityIteratorImpl;

public class DatabaseTableDAOImpl implements DatabaseTableDAO<DatabaseTable> {

	private static final DatabaseTableDAO<DatabaseTable> instance = new DatabaseTableDAOImpl();
	
	public static final DatabaseTableDAO<DatabaseTable> get(){
		return instance;
	}

	@Override
	public Class<? extends DatabaseTable> clazz() {
		return DatabaseTable.class;
	}

	@Override
	public Class<? extends IDatabaseTableField> fieldClazz() {
		return DatabaseTableField.class;
	}

	@Override
	public IDatabaseTable create(String domainKey, String metaDataId, String table) {
		return new DatabaseTable(new DatabaseTableId(domainKey, metaDataId, table));
	}

	@Override
	public void createOrUpdate(DatabaseTable e) throws StorageException {
		
		try {
			
			final IDatabaseTable oe = get(e.getDomainKey(), e.getMetaDataId(), e.getTable());
			IDatabaseTable ne;
			
			if(null == oe) {
				ne = new DatabaseTable(new DatabaseTableId(e.getDomainKey(), e.getMetaDataId(), e.getTable()));
			}else {
				ne = oe;
			}
			
			UOW.begin();

			ne.setCatalog(e.getCatalog());
			ne.setFields(e.getFields());
			ne.setSchema(e.getSchema());
			
			if(null == oe) {
				UOW.persist(ne);
			}
			
			UOW.commit();
			
		}catch(Exception ex) {
			UOW.rollback();
			throw new StorageException(ex);
		}
		
	}

	@Override
	public EntityIterator<DatabaseTable> load() throws StorageException {
		try {
			return new EntityIteratorImpl<>(DatabaseTable.class, "id.domainKey");
		}catch(Exception ex) {
			throw new StorageException(ex);
		}
	}

	@Override
	public EntityIterator<DatabaseTable> load(String domainKey) throws StorageException {
		try {
			return new EntityIteratorImpl<>(DatabaseTable.class, domainKey, "id.metaDataId");
		}catch(Exception ex) {
			throw new StorageException(ex);
		}
	}

	@Override
	public long count() throws StorageException {
		return new CommonDAO<>(DatabaseTable.class).count();
	}

	@Override
	public long count(String domainKey) throws StorageException {
		return new CommonDAO<>(DatabaseTable.class).count(domainKey);
	}

	@Override
	public DatabaseTable get(String domainKey, String metaDataId, String table) {
		return new CommonDAO<>(DatabaseTable.class).find(new DatabaseTableId(domainKey, metaDataId, table));
	}

	@Override
	public void delete() {
		new CommonDAO<>(DatabaseTable.class).delete();
	}

	@Override
	public void delete(String domainKey) throws StorageException {
		new CommonDAO<>(DatabaseTable.class).delete(domainKey);
	}

	@Override
	public void delete(String domainKey, String metaDataId) {
		new CommonDAO<>(DatabaseTable.class).delete(domainKey, "metaDataId", metaDataId);
	}

	@Override
	public void delete(String domainKey, String metaDataId, String table) {
		new CommonDAO<>(DatabaseTable.class).delete(domainKey, "metaDataId", metaDataId, "table", table);
	}

}
