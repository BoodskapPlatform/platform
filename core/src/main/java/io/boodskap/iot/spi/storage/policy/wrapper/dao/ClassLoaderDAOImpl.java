package io.boodskap.iot.spi.storage.policy.wrapper.dao;

import java.util.Collection;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.ClassLoaderDAO;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.model.IClassLoader;

public class ClassLoaderDAOImpl implements ClassLoaderDAO<IClassLoader> {

	private final ClassLoaderDAO<IClassLoader> impl;

	public ClassLoaderDAOImpl(ClassLoaderDAO<IClassLoader> impl) {
		this.impl = impl;
	}

	public Class<? extends IClassLoader> clazz() {
		return impl.clazz();
	}

	public IClassLoader create(String loader) {
		return impl.create(loader);
	}

	public void createOrUpdate(IClassLoader e) throws StorageException {
		impl.createOrUpdate(e);
	}

	public EntityIterator<IClassLoader> load() throws StorageException {
		return impl.load();
	}

	public long count() throws StorageException {
		return impl.count();
	}

	public IClassLoader get(String loader) throws StorageException {
		return impl.get(loader);
	}

	public void delete() throws StorageException {
		impl.delete();
	}

	public void delete(String loader) throws StorageException {
		impl.delete(loader);
	}

	public Collection<IClassLoader> list() throws StorageException {
		return impl.list();
	}

	public Collection<IClassLoader> search(String query, int pageSize) throws StorageException {
		return impl.search(query, pageSize);
	}
	
}
