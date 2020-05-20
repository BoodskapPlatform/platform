package io.boodskap.iot.spi.storage.policy.wrapper.dao;

import java.util.Collection;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.DomainJarFileDAO;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.model.IDomainJarFile;

public class DomainJarFileDAOImpl implements DomainJarFileDAO<IDomainJarFile>{

	private final DomainJarFileDAO<IDomainJarFile> impl;

	public DomainJarFileDAOImpl(DomainJarFileDAO<IDomainJarFile> impl) {
		this.impl = impl;
	}

	public Class<? extends IDomainJarFile> clazz() {
		return impl.clazz();
	}

	public void createOrUpdate(IDomainJarFile e) throws StorageException {
		impl.createOrUpdate(e);
	}

	public EntityIterator<IDomainJarFile> load() throws StorageException {
		return impl.load();
	}

	public EntityIterator<IDomainJarFile> load(String domainKey) throws StorageException {
		return impl.load(domainKey);
	}

	public long count() throws StorageException {
		return impl.count();
	}

	public long count(String domainKey) throws StorageException {
		return impl.count(domainKey);
	}

	public IDomainJarFile create(String domainKey, String loader, String fileName) {
		return impl.create(domainKey, loader, fileName);
	}

	public void delete() throws StorageException {
		impl.delete();
	}

	public IDomainJarFile get(String domainKey, String loader, String fileName, boolean loadContent) throws StorageException {
		return impl.get(domainKey, loader, fileName, loadContent);
	}

	public void delete(String domainKey) throws StorageException {
		impl.delete(domainKey);
	}

	public long count(String domainKey, String loader) throws StorageException {
		return impl.count(domainKey, loader);
	}

	public void delete(String domainKey, String loader) throws StorageException {
		impl.delete(domainKey, loader);
	}

	public void delete(String domainKey, String loader, String fileName) throws StorageException {
		impl.delete(domainKey, loader, fileName);
	}

	public Collection<IDomainJarFile> list(String domainKey, String loader, int page, int pageSize, boolean loadContent)
			throws StorageException {
		return impl.list(domainKey, loader, page, pageSize, loadContent);
	}

	public Collection<IDomainJarFile> listNext(String domainKey, String loader, String fileName, int page, int pageSize, boolean loadContent)
			throws StorageException {
		return impl.listNext(domainKey, loader, fileName, page, pageSize, loadContent);
	}

	public Collection<IDomainJarFile> search(String domainKey, String query, int pageSize) throws StorageException {
		return impl.search(domainKey, query, pageSize);
	}
	
}
