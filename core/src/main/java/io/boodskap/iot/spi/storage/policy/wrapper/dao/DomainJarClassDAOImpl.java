package io.boodskap.iot.spi.storage.policy.wrapper.dao;

import java.util.Collection;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.DomainJarClassDAO;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.model.IDomainJarClass;

public class DomainJarClassDAOImpl implements DomainJarClassDAO<IDomainJarClass> {

	private final DomainJarClassDAO<IDomainJarClass> impl;

	public DomainJarClassDAOImpl(final DomainJarClassDAO<IDomainJarClass> impl) {
		this.impl = impl;
	}

	public Class<? extends IDomainJarClass> clazz() {
		return impl.clazz();
	}

	public void createOrUpdate(IDomainJarClass e) throws StorageException {
		impl.createOrUpdate(e);
	}

	public EntityIterator<IDomainJarClass> load() throws StorageException {
		return impl.load();
	}

	public EntityIterator<IDomainJarClass> load(String domainKey) throws StorageException {
		return impl.load(domainKey);
	}

	public long count() throws StorageException {
		return impl.count();
	}

	public long count(String domainKey) throws StorageException {
		return impl.count(domainKey);
	}

	public IDomainJarClass create(String domainKey, String loader, String fileName, String pkg, String name) {
		return impl.create(domainKey, loader, fileName, pkg, name);
	}

	public void delete() throws StorageException {
		impl.delete();
	}

	public long count(String domainKey, String loader) throws StorageException {
		return impl.count(domainKey, loader);
	}

	public void delete(String domainKey) throws StorageException {
		impl.delete(domainKey);
	}

	public long count(String domainKey, String loader, String fileName) throws StorageException {
		return impl.count(domainKey, loader, fileName);
	}

	public long count(String domainKey, String loader, String fileName, String pkg) throws StorageException {
		return impl.count(domainKey, loader, fileName, pkg);
	}

	public void delete(String domainKey, String loader) throws StorageException {
		impl.delete(domainKey, loader);
	}

	public void delete(String domainKey, String loader, String fileName) throws StorageException {
		impl.delete(domainKey, loader, fileName);
	}

	public Collection<IDomainJarClass> listClasses(String domainKey, String loader, int page, int pageSize)
			throws StorageException {
		return impl.listClasses(domainKey, loader, page, pageSize);
	}

	public Collection<IDomainJarClass> listNextClasses(String domainKey, String loader, String fileName, String pkg,
			String name, int page, int pageSize) throws StorageException {
		return impl.listNextClasses(domainKey, loader, fileName, pkg, name, page, pageSize);
	}

	public Collection<IDomainJarClass> listPackageClasses(String domainKey, String loader, String pkg, int page,
			int pageSize) throws StorageException {
		return impl.listPackageClasses(domainKey, loader, pkg, page, pageSize);
	}

	public Collection<IDomainJarClass> listNextPackageClasses(String domainKey, String loader, String fileName,
			String pkg, String name, int page, int pageSize) throws StorageException {
		return impl.listNextPackageClasses(domainKey, loader, fileName, pkg, name, page, pageSize);
	}

	public Collection<IDomainJarClass> listArchiveClasses(String domainKey, String loader, String fileName, int page,
			int pageSize) throws StorageException {
		return impl.listArchiveClasses(domainKey, loader, fileName, page, pageSize);
	}

	public Collection<IDomainJarClass> listNextArchiveClasses(String domainKey, String loader, String fileName,
			String pkg, String name, int page, int pageSize) throws StorageException {
		return impl.listNextArchiveClasses(domainKey, loader, fileName, pkg, name, page, pageSize);
	}

	public Collection<IDomainJarClass> listArchivePackageClasses(String domainKey, String loader, String fileName,
			String pkg, int page, int pageSize) throws StorageException {
		return impl.listArchivePackageClasses(domainKey, loader, fileName, pkg, page, pageSize);
	}

	public Collection<IDomainJarClass> listNextArchivePackageClasses(String domainKey, String loader, String fileName,
			String pkg, String name, int page, int pageSize) throws StorageException {
		return impl.listNextArchivePackageClasses(domainKey, loader, fileName, pkg, name, page, pageSize);
	}

	public Collection<String> listPackages(String domainKey, String loader, int page, int pageSize)
			throws StorageException {
		return impl.listPackages(domainKey, loader, page, pageSize);
	}

	public Collection<String> listNextPackages(String domainKey, String loader, String fileName, String pkg, int page,
			int pageSize) throws StorageException {
		return impl.listNextPackages(domainKey, loader, fileName, pkg, page, pageSize);
	}

	public Collection<String> listArchivePackages(String domainKey, String loader, String fileName, int page,
			int pageSize) throws StorageException {
		return impl.listArchivePackages(domainKey, loader, fileName, page, pageSize);
	}

	public Collection<String> listNextArchivePackages(String domainKey, String loader, String fileName, String pkg,
			int page, int pageSize) throws StorageException {
		return impl.listNextArchivePackages(domainKey, loader, fileName, pkg, page, pageSize);
	}

	public Collection<IDomainJarClass> search(String domainKey, String query, int pageSize) throws StorageException {
		return impl.search(domainKey, query, pageSize);
	}

	public long countPackage(String domainKey, String loader, String pkg) throws StorageException {
		return impl.countPackage(domainKey, loader, pkg);
	}

}
