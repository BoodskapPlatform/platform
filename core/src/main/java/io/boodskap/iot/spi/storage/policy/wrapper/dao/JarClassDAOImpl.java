package io.boodskap.iot.spi.storage.policy.wrapper.dao;

import java.util.Collection;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.dao.JarClassDAO;
import io.boodskap.iot.model.IJarClass;

public class JarClassDAOImpl implements JarClassDAO<IJarClass> {

	private final JarClassDAO<IJarClass> impl;

	public JarClassDAOImpl(JarClassDAO<IJarClass> impl) {
		this.impl = impl;
	}

	public Class<? extends IJarClass> clazz() {
		return impl.clazz();
	}

	public IJarClass create(String loader, String fileName, String pkg, String name) {
		return impl.create(loader, fileName, pkg, name);
	}

	public void createOrUpdate(IJarClass e) throws StorageException {
		impl.createOrUpdate(e);
	}

	public long count() throws StorageException {
		return impl.count();
	}

	public long count(String loader) throws StorageException {
		return impl.count(loader);
	}

	public long count(String loader, String fileName) throws StorageException {
		return impl.count(loader, fileName);
	}

	public long count(String loader, String fileName, String pkg) throws StorageException {
		return impl.count(loader, fileName, pkg);
	}

	public void delete(String loader) throws StorageException {
		impl.delete(loader);
	}

	public void delete(String loader, String fileName) throws StorageException {
		impl.delete(loader, fileName);
	}

	public EntityIterator<IJarClass> load() throws StorageException {
		return impl.load();
	}

	public EntityIterator<IJarClass> load(String loader) throws StorageException {
		return impl.load(loader);
	}

	public Collection<IJarClass> listClasses(String loader, int page, int pageSize) throws StorageException {
		return impl.listClasses(loader, page, pageSize);
	}

	public Collection<IJarClass> listNextClasses(String loader, String fileName, String pkg, String name, int page,
			int pageSize) throws StorageException {
		return impl.listNextClasses(loader, fileName, pkg, name, page, pageSize);
	}

	public Collection<IJarClass> listPackageClasses(String loader, String pkg, int page, int pageSize)
			throws StorageException {
		return impl.listPackageClasses(loader, pkg, page, pageSize);
	}

	public Collection<IJarClass> listNextPackageClasses(String loader, String fileName, String pkg, String name,
			int page, int pageSize) throws StorageException {
		return impl.listNextPackageClasses(loader, fileName, pkg, name, page, pageSize);
	}

	public Collection<IJarClass> listArchiveClasses(String loader, String fileName, int page, int pageSize)
			throws StorageException {
		return impl.listArchiveClasses(loader, fileName, page, pageSize);
	}

	public Collection<IJarClass> listNextArchiveClasses(String loader, String fileName, String pkg, String name,
			int page, int pageSize) throws StorageException {
		return impl.listNextArchiveClasses(loader, fileName, pkg, name, page, pageSize);
	}

	public Collection<IJarClass> listArchivePackageClasses(String loader, String fileName, String pkg, int page,
			int pageSize) throws StorageException {
		return impl.listArchivePackageClasses(loader, fileName, pkg, page, pageSize);
	}

	public Collection<IJarClass> listNextArchivePackageClasses(String loader, String fileName, String pkg, String name,
			int page, int pageSize) throws StorageException {
		return impl.listNextArchivePackageClasses(loader, fileName, pkg, name, page, pageSize);
	}

	public Collection<String> listPackages(String loader, int page, int pageSize) throws StorageException {
		return impl.listPackages(loader, page, pageSize);
	}

	public Collection<String> listNextPackages(String loader, String fileName, String pkg, int page, int pageSize)
			throws StorageException {
		return impl.listNextPackages(loader, fileName, pkg, page, pageSize);
	}

	public Collection<String> listArchivePackages(String loader, String fileName, int page, int pageSize)
			throws StorageException {
		return impl.listArchivePackages(loader, fileName, page, pageSize);
	}

	public Collection<String> listNextArchivePackages(String loader, String fileName, String pkg, int page,
			int pageSize) throws StorageException {
		return impl.listNextArchivePackages(loader, fileName, pkg, page, pageSize);
	}

	public Collection<IJarClass> search(String query, int pageSize) throws StorageException {
		return impl.search(query, pageSize);
	}

	public void delete() throws StorageException {
		impl.delete();
	}

	public long countPackage(String loader, String pkg) throws StorageException {
		return impl.countPackage(loader, pkg);
	}
	
}
