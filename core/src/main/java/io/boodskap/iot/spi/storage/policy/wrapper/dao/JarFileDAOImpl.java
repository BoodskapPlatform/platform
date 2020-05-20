package io.boodskap.iot.spi.storage.policy.wrapper.dao;

import java.util.Collection;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.dao.JarFileDAO;
import io.boodskap.iot.model.IJarFile;

public class JarFileDAOImpl implements JarFileDAO<IJarFile> {

	private final JarFileDAO<IJarFile> impl;

	public JarFileDAOImpl(JarFileDAO<IJarFile> impl) {
		this.impl = impl;
	}

	public Class<? extends IJarFile> clazz() {
		return impl.clazz();
	}

	public IJarFile create(String loader, String fileName) {
		return impl.create(loader, fileName);
	}

	public void createOrUpdate(IJarFile e) throws StorageException {
		impl.createOrUpdate(e);
	}

	public IJarFile get(String loader, String fileName, boolean loadContent) throws StorageException {
		return impl.get(loader, fileName, loadContent);
	}

	public long count() throws StorageException {
		return impl.count();
	}

	public long count(String loader) throws StorageException {
		return impl.count(loader);
	}

	public void delete() throws StorageException {
		impl.delete();
	}

	public void delete(String loader) throws StorageException {
		impl.delete(loader);
	}

	public void delete(String loader, String fileName) throws StorageException {
		impl.delete(loader, fileName);
	}

	public EntityIterator<IJarFile> load() throws StorageException {
		return impl.load();
	}

	public EntityIterator<IJarFile> load(String loader) throws StorageException {
		return impl.load(loader);
	}

	public Collection<IJarFile> list(String loader, int page, int pageSize, boolean loadContent) throws StorageException {
		return impl.list(loader, page, pageSize, loadContent);
	}

	public Collection<IJarFile> listNext(String loader, String fileName, int page, int pageSize, boolean loadContent)
			throws StorageException {
		return impl.listNext(loader, fileName, page, pageSize, loadContent);
	}

	public Collection<IJarFile> search(String query, int pageSize) throws StorageException {
		return impl.search(query, pageSize);
	}
	
}
