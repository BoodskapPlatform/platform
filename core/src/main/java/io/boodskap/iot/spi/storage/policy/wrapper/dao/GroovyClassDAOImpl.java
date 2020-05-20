package io.boodskap.iot.spi.storage.policy.wrapper.dao;

import java.util.Collection;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.dao.GroovyClassDAO;
import io.boodskap.iot.model.IGroovyClass;

public class GroovyClassDAOImpl implements GroovyClassDAO<IGroovyClass> {

	private final GroovyClassDAO<IGroovyClass> impl;

	public GroovyClassDAOImpl(GroovyClassDAO<IGroovyClass> impl) {
		this.impl = impl;
	}

	public Class<? extends IGroovyClass> clazz() {
		return impl.clazz();
	}

	public IGroovyClass create(String loader, String pkg, String name) {
		return impl.create(loader, pkg, name);
	}

	public void createOrUpdate(IGroovyClass e) throws StorageException {
		impl.createOrUpdate(e);
	}

	public IGroovyClass get(String loader, String pkg, String name, boolean loadContent) throws StorageException {
		return impl.get(loader, pkg, name, loadContent);
	}

	public long count() throws StorageException {
		return impl.count();
	}

	public long count(String loader) throws StorageException {
		return impl.count(loader);
	}

	public long count(String loader, String pkg) throws StorageException {
		return impl.count(loader, pkg);
	}

	public void delete() throws StorageException {
		impl.delete();
	}

	public void delete(String loader) throws StorageException {
		impl.delete(loader);
	}

	public void delete(String loader, String pkg) throws StorageException {
		impl.delete(loader, pkg);
	}

	public void delete(String loader, String pkg, String name) throws StorageException {
		impl.delete(loader, pkg, name);
	}

	public EntityIterator<IGroovyClass> load() throws StorageException {
		return impl.load();
	}

	public EntityIterator<IGroovyClass> load(String loader) throws StorageException {
		return impl.load(loader);
	}


	public long countArchive(String loader, String fileName) throws StorageException {
		return impl.countArchive(loader, fileName);
	}

	public long countArchive(String loader, String fileName, String pkg) throws StorageException {
		return impl.countArchive(loader, fileName, pkg);
	}

	public Collection<IGroovyClass> listClasses(String loader, int page, int pageSize) throws StorageException {
		return impl.listClasses(loader, page, pageSize);
	}

	public Collection<IGroovyClass> listNextClasses(String loader, String pkg, String name, int page, int pageSize)
			throws StorageException {
		return impl.listNextClasses(loader, pkg, name, page, pageSize);
	}

	public Collection<IGroovyClass> listPackageClasses(String loader, String pkg, int page, int pageSize)
			throws StorageException {
		return impl.listPackageClasses(loader, pkg, page, pageSize);
	}

	public Collection<IGroovyClass> listNextPackageClasses(String loader, String pkg, String name, int page,
			int pageSize) throws StorageException {
		return impl.listNextPackageClasses(loader, pkg, name, page, pageSize);
	}

	public Collection<IGroovyClass> listArchiveClasses(String loader, String fileName, int page, int pageSize)
			throws StorageException {
		return impl.listArchiveClasses(loader, fileName, page, pageSize);
	}

	public Collection<IGroovyClass> listNextArchiveClasses(String loader, String fileName, String pkg, String name,
			int page, int pageSize) throws StorageException {
		return impl.listNextArchiveClasses(loader, fileName, pkg, name, page, pageSize);
	}

	public Collection<IGroovyClass> listArchivePackageClasses(String loader, String fileName, String pkg, int page,
			int pageSize) throws StorageException {
		return impl.listArchivePackageClasses(loader, fileName, pkg, page, pageSize);
	}

	public Collection<IGroovyClass> listNextArchivePackageClasses(String loader, String fileName, String pkg,
			String name, int page, int pageSize) throws StorageException {
		return impl.listNextArchivePackageClasses(loader, fileName, pkg, name, page, pageSize);
	}

	public Collection<String> listPackages(String loader, int page, int pageSize) throws StorageException {
		return impl.listPackages(loader, page, pageSize);
	}

	public Collection<String> listNextPackages(String loader, String pkg, int page, int pageSize)
			throws StorageException {
		return impl.listNextPackages(loader, pkg, page, pageSize);
	}

	public Collection<String> listArchivePackages(String loader, String fileName, int page, int pageSize)
			throws StorageException {
		return impl.listArchivePackages(loader, fileName, page, pageSize);
	}

	public Collection<String> listNextArchivePackages(String loader, String fileName, String pkg, int page,
			int pageSize) throws StorageException {
		return impl.listNextArchivePackages(loader, fileName, pkg, page, pageSize);
	}

	public Collection<IGroovyClass> search(String query, int pageSize) throws StorageException {
		return impl.search(query, pageSize);
	}

	public void deleteArchive(String loader, String fileName) throws StorageException {
		impl.deleteArchive(loader, fileName);
	}
	
}
