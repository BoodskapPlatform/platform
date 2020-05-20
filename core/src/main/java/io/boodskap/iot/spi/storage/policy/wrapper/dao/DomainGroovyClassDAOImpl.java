package io.boodskap.iot.spi.storage.policy.wrapper.dao;

import java.util.Collection;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.DomainGroovyClassDAO;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.model.IDomainGroovyClass;

public class DomainGroovyClassDAOImpl implements DomainGroovyClassDAO<IDomainGroovyClass> {

	private final DomainGroovyClassDAO<IDomainGroovyClass> impl;
	
	public DomainGroovyClassDAOImpl(final DomainGroovyClassDAO<IDomainGroovyClass> impl) {
		this.impl = impl;
	}

	public Class<? extends IDomainGroovyClass> clazz() {
		return impl.clazz();
	}

	public void createOrUpdate(IDomainGroovyClass e) throws StorageException {
		impl.createOrUpdate(e);
	}

	public EntityIterator<IDomainGroovyClass> load() throws StorageException {
		return impl.load();
	}

	public EntityIterator<IDomainGroovyClass> load(String domainKey) throws StorageException {
		return impl.load(domainKey);
	}

	public long count() throws StorageException {
		return impl.count();
	}

	public long count(String domainKey) throws StorageException {
		return impl.count(domainKey);
	}

	public IDomainGroovyClass create(String domainKey, String loader, String pkg, String name) {
		return impl.create(domainKey, loader, pkg, name);
	}

	public void delete() throws StorageException {
		impl.delete();
	}

	public IDomainGroovyClass get(String domainKey, String loader, String pkg, String name, boolean loadContent) throws StorageException {
		return impl.get(domainKey, loader, pkg, name, loadContent);
	}

	public void delete(String domainKey) throws StorageException {
		impl.delete(domainKey);
	}

	public long count(String domainKey, String loader) throws StorageException {
		return impl.count(domainKey, loader);
	}

	public long count(String domainKey, String loader, String pkg) throws StorageException {
		return impl.count(domainKey, loader, pkg);
	}

	public void delete(String domainKey, String loader) throws StorageException {
		impl.delete(domainKey, loader);
	}

	public void delete(String domainKey, String loader, String pkg) throws StorageException {
		impl.delete(domainKey, loader, pkg);
	}

	public void delete(String domainKey, String loader, String pkg, String name) throws StorageException {
		impl.delete(domainKey, loader, pkg, name);
	}

	public long countArchive(String domainKey, String loader, String fileName) throws StorageException {
		return impl.countArchive(domainKey, loader, fileName);
	}

	public long countArchive(String domainKey, String loader, String fileName, String pkg) throws StorageException {
		return impl.countArchive(domainKey, loader, fileName, pkg);
	}

	public Collection<IDomainGroovyClass> listClasses(String domainKey, String loader, int page, int pageSize)
			throws StorageException {
		return impl.listClasses(domainKey, loader, page, pageSize);
	}

	public Collection<IDomainGroovyClass> listNextClasses(String domainKey, String loader, String pkg, String name,
			int page, int pageSize) throws StorageException {
		return impl.listNextClasses(domainKey, loader, pkg, name, page, pageSize);
	}

	public Collection<IDomainGroovyClass> listPackageClasses(String domainKey, String loader, String pkg, int page,
			int pageSize) throws StorageException {
		return impl.listPackageClasses(domainKey, loader, pkg, page, pageSize);
	}

	public Collection<IDomainGroovyClass> listNextPackageClasses(String domainKey, String loader, String pkg,
			String name, int page, int pageSize) throws StorageException {
		return impl.listNextPackageClasses(domainKey, loader, pkg, name, page, pageSize);
	}

	public Collection<IDomainGroovyClass> listArchiveClasses(String domainKey, String loader, String fileName, int page,
			int pageSize) throws StorageException {
		return impl.listArchiveClasses(domainKey, loader, fileName, page, pageSize);
	}

	public Collection<IDomainGroovyClass> listNextArchiveClasses(String domainKey, String loader, String fileName,
			String pkg, String name, int page, int pageSize) throws StorageException {
		return impl.listNextArchiveClasses(domainKey, loader, fileName, pkg, name, page, pageSize);
	}

	public Collection<IDomainGroovyClass> listArchivePackageClasses(String domainKey, String loader, String fileName,
			String pkg, int page, int pageSize) throws StorageException {
		return impl.listArchivePackageClasses(domainKey, loader, fileName, pkg, page, pageSize);
	}

	public Collection<IDomainGroovyClass> listNextArchivePackageClasses(String domainKey, String loader,
			String fileName, String pkg, String name, int page, int pageSize) throws StorageException {
		return impl.listNextArchivePackageClasses(domainKey, loader, fileName, pkg, name, page, pageSize);
	}

	public Collection<String> listPackages(String domainKey, String loader, int page, int pageSize)
			throws StorageException {
		return impl.listPackages(domainKey, loader, page, pageSize);
	}

	public Collection<String> listNextPackages(String domainKey, String loader, String pkg, int page, int pageSize)
			throws StorageException {
		return impl.listNextPackages(domainKey, loader, pkg, page, pageSize);
	}

	public Collection<String> listArchivePackages(String domainKey, String loader, String fileName, int page,
			int pageSize) throws StorageException {
		return impl.listArchivePackages(domainKey, loader, fileName, page, pageSize);
	}

	public Collection<String> listNextArchivePackages(String domainKey, String loader, String fileName, String pkg,
			int page, int pageSize) throws StorageException {
		return impl.listNextArchivePackages(domainKey, loader, fileName, pkg, page, pageSize);
	}

	public Collection<IDomainGroovyClass> search(String domainKey, String query, int pageSize) throws StorageException {
		return impl.search(domainKey, query, pageSize);
	}

	public void deleteArchive(String domainKey, String loader, String fileName) throws StorageException {
		impl.deleteArchive(domainKey, loader, fileName);
	}

}
