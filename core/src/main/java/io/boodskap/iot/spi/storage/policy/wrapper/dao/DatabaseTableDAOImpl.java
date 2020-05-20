package io.boodskap.iot.spi.storage.policy.wrapper.dao;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.DatabaseTableDAO;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.model.IDatabaseTable;
import io.boodskap.iot.model.IDatabaseTableField;

public class DatabaseTableDAOImpl implements DatabaseTableDAO<IDatabaseTable>{

	private final DatabaseTableDAO<IDatabaseTable> impl;
	
	public DatabaseTableDAOImpl(final DatabaseTableDAO<IDatabaseTable> impl) {
		this.impl = impl;
	}

	public Class<? extends IDatabaseTable> clazz() {
		return impl.clazz();
	}

	public IDatabaseTable create(String domainKey, String metaDataId, String table) {
		return impl.create(domainKey, metaDataId, table);
	}

	public void createOrUpdate(IDatabaseTable e) throws StorageException {
		impl.createOrUpdate(e);
	}

	public EntityIterator<IDatabaseTable> load() throws StorageException {
		return impl.load();
	}

	public EntityIterator<IDatabaseTable> load(String domainKey) throws StorageException {
		return impl.load(domainKey);
	}

	public long count() throws StorageException {
		return impl.count();
	}

	public Class<? extends IDatabaseTableField> fieldClazz() {
		return impl.fieldClazz();
	}

	public long count(String domainKey) throws StorageException {
		return impl.count(domainKey);
	}

	public void delete(String domainKey) throws StorageException {
		impl.delete(domainKey);
	}

	public IDatabaseTable get(String domainKey, String metaDataId, String table) {
		return impl.get(domainKey, metaDataId, table);
	}

	public void delete() {
		impl.delete();
	}

	public void delete(String domainKey, String metaDataId) {
		impl.delete(domainKey, metaDataId);
	}

	public void delete(String domainKey, String metaDataId, String table) {
		impl.delete(domainKey, metaDataId, table);
	}

}
