package io.boodskap.iot.spi.storage.jpa.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.dao.JarClassDAO;
import io.boodskap.iot.model.IJarClass;
import io.boodskap.iot.model.jpa.JarClass;
import io.boodskap.iot.model.jpa.JarClassId;
import io.boodskap.iot.spi.storage.jpa.UOW;
import io.boodskap.iot.spi.storage.jpa.dao.util.CommonDAO;
import io.boodskap.iot.spi.storage.jpa.dao.util.EntityIteratorImpl;

public class JarClassDAOImpl implements JarClassDAO<JarClass>{
	
	private static final JarClassDAO<JarClass> instance = new JarClassDAOImpl();
	
	private JarClassDAOImpl() {
	}
	
	public static final JarClassDAO<JarClass> get(){
		return instance;
	}

	@Override
	public Class<JarClass> clazz() {
		return JarClass.class;
	}

	@Override
	public JarClass create(String loader, String fileName, String pkg, String name) {
		return new JarClass(new JarClassId(loader, fileName, pkg, name));
	}

	@Override
	public void createOrUpdate(JarClass e) throws StorageException {
		try {
			
			final IJarClass oe = new CommonDAO<>(JarClass.class).find(new JarClassId(e.getLoader(), e.getFileName(), e.getPkg(), e.getName()));
			IJarClass ne;
			
			if(null == oe) {
				ne = create(e.getLoader(), e.getFileName(), e.getPkg(), e.getName());
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
	public long count() throws StorageException {
		return new CommonDAO<>(JarClass.class).count();
	}

	@Override
	public long count(String loader) throws StorageException {
		return new CommonDAO<>(JarClass.class).count("id.loader", loader);
	}

	@Override
	public long count(String loader, String fileName) throws StorageException {
		return new CommonDAO<>(JarClass.class).count("id.loader", loader, "id.fileName", fileName);
	}

	@Override
	public long count(String loader, String fileName, String pkg) throws StorageException {
		return new CommonDAO<>(JarClass.class).count("id.loader", loader, "id.fileName", fileName, "id.pkg", pkg);
	}

	@Override
	public long countPackage(String loader, String pkg) throws StorageException {
		return new CommonDAO<>(JarClass.class).count("id.loader", loader, "id.pkg", pkg);
	}

	@Override
	public void delete() throws StorageException {
		new CommonDAO<>(JarClass.class).delete();
	}

	@Override
	public void delete(String loader) throws StorageException {
		new CommonDAO<>(JarClass.class).delete("id.loader", loader);
	}

	@Override
	public void delete(String loader, String fileName) throws StorageException {
		new CommonDAO<>(JarClass.class).delete("id.loader", loader, "id.fileName", fileName);
	}

	@Override
	public EntityIterator<JarClass> load() throws StorageException {
		return new EntityIteratorImpl<>(JarClass.class, "id.loader");
	}

	@Override
	public EntityIterator<JarClass> load(String loader) throws StorageException {
		return new EntityIteratorImpl<>("id.loader", loader, "id.fileName", JarClass.class);
	}

	@Override
	public Collection<JarClass> search(String query, int pageSize) throws StorageException {
		return new CommonDAO<>(JarClass.class).search(query, pageSize);
	}

	@Override
	public Collection<JarClass> listClasses(String loader, int page, int pageSize) throws StorageException {
		String jql = String.format("SELECT NEW io.boodskap.iot.model.jpa.JarClass(v.id.loader, v.id.fileName, v.id.pkg, v.id.name) FROM %s v WHERE v.id.loader=:loader ORDER BY v.id.pkg, v.id.name", JarClass.class.getSimpleName());
		Map<String, Serializable> params = new HashMap<>();
		params.put("loader", loader);
		return new CommonDAO<>(JarClass.class).list(jql, params, page, pageSize);
	}

	@Override
	public Collection<JarClass> listNextClasses(String loader, String fileName, String pkg, String name, int page, int pageSize) throws StorageException {
		return listClasses(loader, page, pageSize);
	}

	@Override
	public Collection<JarClass> listPackageClasses(String loader, String pkg, int page, int pageSize) throws StorageException {
		String jql = String.format("SELECT NEW io.boodskap.iot.model.jpa.JarClass(v.id.loader, v.id.fileName, v.id.pkg, v.id.name) FROM %s v WHERE v.id.loader=:loader AND v.id.pkg=:pkg ORDER BY v.id.name", JarClass.class.getSimpleName());
		Map<String, Serializable> params = new HashMap<>();
		params.put("loader", loader);
		params.put("pkg", pkg);
		return new CommonDAO<>(JarClass.class).list(jql, params, page, pageSize);
	}

	@Override
	public Collection<JarClass> listNextPackageClasses(String loader, String fileName, String pkg, String name, int page, int pageSize) throws StorageException {
		return listPackageClasses(loader, pkg, page, pageSize);
	}

	@Override
	public Collection<JarClass> listArchiveClasses(String loader, String fileName, int page, int pageSize) throws StorageException {
		String jql = String.format("SELECT NEW io.boodskap.iot.model.jpa.JarClass(v.id.loader, v.id.fileName, v.id.pkg, v.id.name) FROM %s v WHERE v.id.loader=:loader AND v.id.fileName=:fname ORDER BY v.id.pkg, v.id.name", JarClass.class.getSimpleName());
		Map<String, Serializable> params = new HashMap<>();
		params.put("loader", loader);
		params.put("fname", fileName);
		return new CommonDAO<>(JarClass.class).list(jql, params, page, pageSize);
	}

	@Override
	public Collection<JarClass> listNextArchiveClasses(String loader, String fileName, String pkg, String name, int page, int pageSize) throws StorageException {
		return listArchiveClasses(loader, fileName, page, pageSize);
	}

	@Override
	public Collection<JarClass> listArchivePackageClasses(String loader, String fileName, String pkg, int page, int pageSize) throws StorageException {
		String jql = String.format("SELECT NEW io.boodskap.iot.model.jpa.JarClass(v.id.loader, v.id.fileName, v.id.pkg, v.id.name) FROM %s v WHERE v.id.loader=:loader AND v.id.fileName=:fname AND v.id.pkg=:pkg ORDER BY v.id.name", JarClass.class.getSimpleName());
		Map<String, Serializable> params = new HashMap<>();
		params.put("loader", loader);
		params.put("fname", fileName);
		params.put("pkg", pkg);
		return new CommonDAO<>(JarClass.class).list(jql, params, page, pageSize);
	}

	@Override
	public Collection<JarClass> listNextArchivePackageClasses(String loader, String fileName, String pkg, String name, int page, int pageSize) throws StorageException {
		return listArchivePackageClasses(loader, fileName, pkg, page, pageSize);
	}

	@Override
	public Collection<String> listPackages(String loader, int page, int pageSize) throws StorageException {
		String jql = String.format("SELECT DISTINCT(v.id.pkg) FROM %s v WHERE v.id.loader=:loader ORDER BY v.id.pkg", JarClass.class.getSimpleName());
		Map<String, Serializable> params = new HashMap<>();
		params.put("loader", loader);
		return new CommonDAO<>(String.class).list(jql, params, page, pageSize);
	}

	@Override
	public Collection<String> listNextPackages(String loader, String fileName, String pkg, int page, int pageSize) throws StorageException {
		return listPackages(loader, page, pageSize);
	}

	@Override
	public Collection<String> listArchivePackages(String loader, String fileName, int page, int pageSize) throws StorageException {
		String jql = String.format("SELECT DISTINCT(v.id.pkg) FROM %s v WHERE v.id.loader=:loader AND v.id.fileName=:fname ORDER BY v.id.pkg", JarClass.class.getSimpleName());
		Map<String, Serializable> params = new HashMap<>();
		params.put("loader", loader);
		params.put("fname", fileName);
		return new CommonDAO<>(String.class).list(jql, params, page, pageSize);
	}

	@Override
	public Collection<String> listNextArchivePackages(String loader, String fileName, String pkg, int page, int pageSize) throws StorageException {
		return listArchivePackages(loader, fileName, page, pageSize);
	}
}
