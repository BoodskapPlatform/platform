package io.boodskap.iot.spi.storage.jpa.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.DomainJarClassDAO;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.model.IDomainJarClass;
import io.boodskap.iot.model.jpa.DomainJarClass;
import io.boodskap.iot.model.jpa.DomainJarClassId;
import io.boodskap.iot.spi.storage.jpa.UOW;
import io.boodskap.iot.spi.storage.jpa.dao.util.CommonDAO;
import io.boodskap.iot.spi.storage.jpa.dao.util.EntityIteratorImpl;

public class DomainJarClassDAOImpl implements DomainJarClassDAO<DomainJarClass>{

	private static final DomainJarClassDAO<DomainJarClass> instance = new DomainJarClassDAOImpl();
	
	private DomainJarClassDAOImpl() {	
	}
	
	public static final DomainJarClassDAO<DomainJarClass> get(){
		return instance;
	}

	@Override
	public Class<DomainJarClass> clazz() {
		return DomainJarClass.class;
	}

	@Override
	public DomainJarClass create(String domainKey, String loader, String fileName, String pkg, String name) {
		return new DomainJarClass(new DomainJarClassId(domainKey, loader, fileName, pkg, name));
	}

	@Override
	public void createOrUpdate(DomainJarClass e) throws StorageException {
		try {
			
			final IDomainJarClass oe = new CommonDAO<>(DomainJarClass.class).find(new DomainJarClassId(e.getDomainKey(), e.getLoader(), e.getFileName(), e.getPkg(), e.getName()));
			IDomainJarClass ne;
			
			if(null == oe) {
				ne = new DomainJarClass(new DomainJarClassId(e.getDomainKey(), e.getLoader(), e.getFileName(), e.getPkg(), e.getName()));
			}else {
				ne = oe;
			}
			
			if(null == oe) {
				UOW.begin();
				UOW.persist(ne);
				UOW.commit();
			}
			
		}catch(Exception ex) {
			UOW.rollback();
			throw new StorageException(ex);
		}
	}

	@Override
	public EntityIterator<DomainJarClass> load() throws StorageException {
		return new EntityIteratorImpl<>(DomainJarClass.class, "id.domainKey");
	}

	@Override
	public EntityIterator<DomainJarClass> load(String domainKey) throws StorageException {
		return new EntityIteratorImpl<>(DomainJarClass.class, domainKey, "id.loader");
	}

	@Override
	public long count() throws StorageException {
		return new CommonDAO<>(DomainJarClass.class).count();
	}

	@Override
	public long count(String domainKey) throws StorageException {
		return new CommonDAO<>(DomainJarClass.class).count(domainKey);
	}

	@Override
	public long count(String domainKey, String loader) throws StorageException {
		return new CommonDAO<>(DomainJarClass.class).count(domainKey, "loader", loader);
	}

	@Override
	public long count(String domainKey, String loader, String fileName) throws StorageException {
		return new CommonDAO<>(DomainJarClass.class).count(domainKey, "loader", loader, "fileName", fileName);
	}

	@Override
	public long count(String domainKey, String loader, String fileName, String pkg) throws StorageException {
		return new CommonDAO<>(DomainJarClass.class).count(domainKey, "loader", loader, "fileName", fileName, "pkg", pkg);
	}

	@Override
	public long countPackage(String domainKey, String loader, String pkg) throws StorageException {
		return new CommonDAO<>(DomainJarClass.class).count(domainKey, "loader", loader, "pkg", pkg);
	}

	@Override
	public void delete() throws StorageException {
		new CommonDAO<>(DomainJarClass.class).delete();
	}

	@Override
	public void delete(String domainKey) throws StorageException {
		new CommonDAO<>(DomainJarClass.class).delete(domainKey);
	}

	@Override
	public void delete(String domainKey, String loader) throws StorageException {
		new CommonDAO<>(DomainJarClass.class).delete(domainKey, "loader", loader);
	}

	@Override
	public void delete(String domainKey, String loader, String fileName) throws StorageException {
		new CommonDAO<>(DomainJarClass.class).delete(domainKey, "loader", loader, "fileName", fileName);
	}

	@Override
	public Collection<DomainJarClass> search(String domainKey, String query, int pageSize) throws StorageException {
		return new CommonDAO<>(DomainJarClass.class).search(query, domainKey, pageSize);
	}

	@Override
	public Collection<DomainJarClass> listClasses(String domainKey, String loader, int page, int pageSize) throws StorageException {
		String jql = String.format("SELECT NEW io.boodskap.iot.model.jpa.DomainJarClass(v.id.domainKey, v.id.loader, v.id.fileName, v.id.pkg, v.id.name) FROM %s v WHERE v.id.domainKey=:dkey AND v.id.loader=:loader ORDER BY v.id.pkg, v.id.name", DomainJarClass.class.getSimpleName());
		Map<String, Serializable> params = new HashMap<>();
		params.put("dkey", domainKey);
		params.put("loader", loader);
		return new CommonDAO<>(DomainJarClass.class).list(jql, params, page, pageSize);
	}

	@Override
	public Collection<DomainJarClass> listNextClasses(String domainKey, String loader, String fileName, String pkg, String name, int page, int pageSize) throws StorageException {
		return listClasses(domainKey, loader, page, pageSize);
	}

	@Override
	public Collection<DomainJarClass> listPackageClasses(String domainKey, String loader, String pkg, int page, int pageSize) throws StorageException {
		String jql = String.format("SELECT NEW io.boodskap.iot.model.jpa.DomainJarClass(v.id.domainKey, v.id.loader, v.id.fileName, v.id.pkg, v.id.name) FROM %s v WHERE v.id.domainKey=:dkey AND v.id.loader=:loader AND v.id.pkg=:pkg ORDER BY v.id.name", DomainJarClass.class.getSimpleName());
		Map<String, Serializable> params = new HashMap<>();
		params.put("dkey", domainKey);
		params.put("loader", loader);
		params.put("pkg", pkg);
		return new CommonDAO<>(DomainJarClass.class).list(jql, params, page, pageSize);
	}

	@Override
	public Collection<DomainJarClass> listNextPackageClasses(String domainKey, String loader, String fileName, String pkg, String name, int page, int pageSize) throws StorageException {
		return listPackageClasses(domainKey, loader, pkg, page, pageSize);
	}

	@Override
	public Collection<DomainJarClass> listArchiveClasses(String domainKey, String loader, String fileName, int page, int pageSize) throws StorageException {
		String jql = String.format("SELECT NEW io.boodskap.iot.model.jpa.DomainJarClass(v.id.domainKey, v.id.loader, v.id.fileName, v.id.pkg, v.id.name) FROM %s v WHERE v.id.domainKey=:dkey AND v.id.loader=:loader AND v.id.fileName=:fname ORDER BY v.id.pkg, v.id.name", DomainJarClass.class.getSimpleName());
		Map<String, Serializable> params = new HashMap<>();
		params.put("dkey", domainKey);
		params.put("loader", loader);
		params.put("fname", fileName);
		return new CommonDAO<>(DomainJarClass.class).list(jql, params, page, pageSize);
	}

	@Override
	public Collection<DomainJarClass> listNextArchiveClasses(String domainKey, String loader, String fileName, String pkg, String name, int page, int pageSize) throws StorageException {
		return listArchiveClasses(domainKey, loader, fileName, page, pageSize);
	}

	@Override
	public Collection<DomainJarClass> listArchivePackageClasses(String domainKey, String loader, String fileName, String pkg, int page, int pageSize) throws StorageException {
		String jql = String.format("SELECT NEW io.boodskap.iot.model.jpa.DomainJarClass(v.id.domainKey, v.id.loader, v.id.fileName, v.id.pkg, v.id.name) FROM %s v WHERE v.id.domainKey=:dkey AND v.id.loader=:loader AND v.id.fileName=:fname AND v.id.pkg=:pkg ORDER BY v.id.name", DomainJarClass.class.getSimpleName());
		Map<String, Serializable> params = new HashMap<>();
		params.put("dkey", domainKey);
		params.put("loader", loader);
		params.put("fname", fileName);
		params.put("pkg", pkg);
		return new CommonDAO<>(DomainJarClass.class).list(jql, params, page, pageSize);
	}

	@Override
	public Collection<DomainJarClass> listNextArchivePackageClasses(String domainKey, String loader, String fileName, String pkg, String name, int page, int pageSize) throws StorageException {
		return listArchivePackageClasses(domainKey, loader, fileName, pkg, page, pageSize);
	}

	@Override
	public Collection<String> listPackages(String domainKey, String loader, int page, int pageSize) throws StorageException {
		String jql = String.format("SELECT DISTINCT(v.id.pkg) FROM %s v WHERE v.id.domainKey=:dkey AND v.id.loader=:loader ORDER BY v.id.pkg", DomainJarClass.class.getSimpleName());
		Map<String, Serializable> params = new HashMap<>();
		params.put("dkey", domainKey);
		params.put("loader", loader);
		return new CommonDAO<>(String.class).list(jql, params, page, pageSize);
	}

	@Override
	public Collection<String> listNextPackages(String domainKey, String loader, String fileName, String pkg, int page, int pageSize) throws StorageException {
		return listPackages(domainKey, loader, page, pageSize);
	}

	@Override
	public Collection<String> listArchivePackages(String domainKey, String loader, String fileName, int page, int pageSize) throws StorageException {
		String jql = String.format("SELECT DISTINCT(v.id.pkg) FROM %s v WHERE v.id.domainKey=:dkey AND v.id.loader=:loader AND v.id.fileName=:fname ORDER BY v.id.pkg", DomainJarClass.class.getSimpleName());
		Map<String, Serializable> params = new HashMap<>();
		params.put("dkey", domainKey);
		params.put("loader", loader);
		params.put("fname", fileName);
		return new CommonDAO<>(String.class).list(jql, params, page, pageSize);
	}

	@Override
	public Collection<String> listNextArchivePackages(String domainKey, String loader, String fileName, String pkg, int page, int pageSize) throws StorageException {
		return listArchivePackages(domainKey, loader, fileName, page, pageSize);
	}

}
