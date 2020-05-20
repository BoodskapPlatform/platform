package io.boodskap.iot.spi.storage.policy.wrapper.dao;

import java.util.Collection;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.DomainClassLoaderDAO;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.model.IDomainClassLoader;

public class DomainClassLoaderDAOImpl implements DomainClassLoaderDAO<IDomainClassLoader> {

	private final DomainClassLoaderDAO<IDomainClassLoader> impl;

	public DomainClassLoaderDAOImpl(DomainClassLoaderDAO<IDomainClassLoader> impl) {
		this.impl = impl;
	}

	public Class<? extends IDomainClassLoader> clazz() {
		return impl.clazz();
	}

	public void createOrUpdate(IDomainClassLoader e) throws StorageException {
		impl.createOrUpdate(e);
	}

	public EntityIterator<IDomainClassLoader> load() throws StorageException {
		return impl.load();
	}

	public EntityIterator<IDomainClassLoader> load(String domainKey) throws StorageException {
		return impl.load(domainKey);
	}

	public long count() throws StorageException {
		return impl.count();
	}

	public long count(String domainKey) throws StorageException {
		return impl.count(domainKey);
	}

	public IDomainClassLoader create(String domainKey, String loader) {
		return impl.create(domainKey, loader);
	}

	public void delete() throws StorageException {
		impl.delete();
	}

	public IDomainClassLoader get(String domainKey, String loader) throws StorageException {
		return impl.get(domainKey, loader);
	}

	public void delete(String domainKey) throws StorageException {
		impl.delete(domainKey);
	}

	public void delete(String domainKey, String loader) throws StorageException {
		impl.delete(domainKey, loader);
	}

	public Collection<IDomainClassLoader> list(String domainKey) throws StorageException {
		return impl.list(domainKey);
	}

	public Collection<IDomainClassLoader> search(String domainKey, String query, int pageSize) throws StorageException {
		return impl.search(domainKey, query, pageSize);
	}
	
}
