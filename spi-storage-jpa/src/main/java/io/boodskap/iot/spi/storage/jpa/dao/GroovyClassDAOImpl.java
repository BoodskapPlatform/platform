package io.boodskap.iot.spi.storage.jpa.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.dao.GroovyClassDAO;
import io.boodskap.iot.model.IGroovyClass;
import io.boodskap.iot.model.jpa.GroovyClass;
import io.boodskap.iot.model.jpa.GroovyClassId;
import io.boodskap.iot.spi.storage.jpa.UOW;
import io.boodskap.iot.spi.storage.jpa.dao.util.CommonDAO;
import io.boodskap.iot.spi.storage.jpa.dao.util.DBUtil;
import io.boodskap.iot.spi.storage.jpa.dao.util.EntityIteratorImpl;

public class GroovyClassDAOImpl implements GroovyClassDAO<GroovyClass>{
	
	private static final GroovyClassDAO<GroovyClass> instance = new GroovyClassDAOImpl();
	
	private static final Logger LOG = LoggerFactory.getLogger(GroovyClassDAOImpl.class);

	private GroovyClassDAOImpl() {
	}
	
	public static final GroovyClassDAO<GroovyClass> get(){
		return instance;
	}

	@Override
	public Class<GroovyClass> clazz() {
		return GroovyClass.class;
	}

	@Override
	public GroovyClass create(String loader, String pkg, String name) {
		return new GroovyClass(new GroovyClassId(loader, pkg, name));
	}

	@Override
	public GroovyClass get(String loader, String pkg, String name, boolean loadContent) throws StorageException {
		if(loadContent) {
			return new CommonDAO<>(GroovyClass.class).find(new GroovyClassId(loader, pkg, name));
		}else {
			String jql = String.format("SELECT NEW io.boodskap.iot.model.jpa.GroovyClass(v.id.loader, v.id.pkg, v.id.name, v.fileName) FROM %s v WHERE v.id.loader=:loader AND v.id.pkg=:pkg AND v.id.name=:cname", GroovyClass.class.getSimpleName());
			Map<String, Serializable> params = new HashMap<>();
			params.put("loader", loader);
			params.put("pkg", pkg);
			params.put("cname", name);
			return new CommonDAO<>(GroovyClass.class).select(jql, params);
		}
	}

	@Override
	public void createOrUpdate(GroovyClass e) throws StorageException {
		try {
			
			final IGroovyClass oe = get(e.getLoader(), e.getPkg(), e.getName(), false);
			IGroovyClass ne;
			
			if(null == oe) {
				ne = create(e.getLoader(), e.getPkg(), e.getName());
			}else {
				ne = oe;
			}
			
			UOW.begin();

			ne.setCode(e.getCode());
			ne.setFileName(e.getFileName());
			
			if(null == oe) {
				UOW.persist(ne);
			}

			UOW.commit();
			
		}catch(Exception ex) {
			UOW.rollback();
			throw new StorageException(ex);
		}
	}

	@Override
	public long count() throws StorageException {
		return new CommonDAO<>(GroovyClass.class).count();
	}

	@Override
	public long count(String loader) throws StorageException {
		return new CommonDAO<>(GroovyClass.class).count("loader", loader);
	}

	@Override
	public long count(String loader, String pkg) throws StorageException {
		return new CommonDAO<>(GroovyClass.class).count("loader", loader, "pkg", pkg);
	}

	@Override
	public void delete() throws StorageException {
		new CommonDAO<>(GroovyClass.class).delete();
	}

	@Override
	public void delete(String loader) throws StorageException {
		new CommonDAO<>(GroovyClass.class).delete("loader", loader);
	}

	@Override
	public void delete(String loader, String pkg) throws StorageException {
		new CommonDAO<>(GroovyClass.class).delete("loader", loader, "pkg", pkg);
	}

	@Override
	public void delete(String loader, String pkg, String name) throws StorageException {
		new CommonDAO<>(GroovyClass.class).delete("loader", loader, "pkg", pkg, "name", name);
	}

	@Override
	public void deleteArchive(String loader, String fileName) throws StorageException {
		try {
			Query query = UOW.createQuery(String.format("delete from %s v where v.id.loader=:loader and v.fileName=:fname", GroovyClass.class.getSimpleName()));
			query.setParameter("loader", loader);
			query.setParameter("fname", fileName);
			UOW.begin();
			int deleted = query.executeUpdate();
			UOW.commit();
			LOG.debug(String.format("deleted %d %ses", deleted, GroovyClass.class.getSimpleName().toLowerCase()));
		}catch(Exception ex) {
			throw new StorageException(ex);
		}
	}

	@Override
	public EntityIterator<GroovyClass> load() throws StorageException {
		return new EntityIteratorImpl<>(GroovyClass.class, "id.loader");
	}

	@Override
	public EntityIterator<GroovyClass> load(String loader) throws StorageException {
		return new EntityIteratorImpl<>("loader", loader, "id.pkg", GroovyClass.class);
	}

	@Override
	public Collection<GroovyClass> search(String query, int pageSize) throws StorageException {
		
		String jql = String.format("SELECT NEW io.boodskap.iot.model.jpa.GroovyClass(v.id.loader, v.id.pkg, v.id.name, v.fileName) FROM %s v WHERE %s", GroovyClass.class.getSimpleName(), DBUtil.searchToQuery(query));
		TypedQuery<GroovyClass> tquery = UOW.createQuery(jql, GroovyClass.class);
		
		tquery.setFirstResult(0);
		tquery.setMaxResults(pageSize);
		Collection<GroovyClass> list = tquery.getResultList();
		return list;
	}

	@Override
	public long countArchive(String loader, String fileName) throws StorageException {
		try {
			Query query = UOW.createQuery(String.format("select count(v) from %s v where v.id.loader=:loader and v.fileName=:fname", GroovyClass.class.getSimpleName()));
			query.setParameter("loader", loader);
			query.setParameter("fname", fileName);
			return DBUtil.toCount(query.getSingleResult());
		}catch(Exception ex) {
			throw new StorageException(ex);
		}
	}

	@Override
	public long countArchive(String loader, String fileName, String pkg) throws StorageException {
		try {
			Query query = UOW.createQuery(String.format("select count(v) from %s v where v.id.loader=:loader and v.id.pkg=:pkg and v.fileName=:fname", GroovyClass.class.getSimpleName()));
			query.setParameter("loader", loader);
			query.setParameter("pkg", pkg);
			query.setParameter("fname", fileName);
			return DBUtil.toCount(query.getSingleResult());
		}catch(Exception ex) {
			throw new StorageException(ex);
		}
	}

	@Override
	public Collection<GroovyClass> listClasses(String loader, int page, int pageSize) throws StorageException {
		String jql = String.format("SELECT NEW io.boodskap.iot.model.jpa.GroovyClass(v.id.loader, v.id.pkg, v.id.name, v.fileName) FROM %s v WHERE v.id.loader=:loader ORDER BY v.id.pkg, v.id.name", GroovyClass.class.getSimpleName());
		Map<String, Serializable> params = new HashMap<>();
		params.put("loader", loader);
		return new CommonDAO<>(GroovyClass.class).list(jql, params, page, pageSize);
	}

	@Override
	public Collection<GroovyClass> listNextClasses(String loader, String pkg, String name, int page, int pageSize) throws StorageException {
		return listClasses(loader, page, pageSize);
	}

	@Override
	public Collection<GroovyClass> listPackageClasses(String loader, String pkg, int page, int pageSize) throws StorageException {
		String jql = String.format("SELECT NEW io.boodskap.iot.model.jpa.GroovyClass(v.id.loader, v.id.pkg, v.id.name, v.fileName) FROM %s v WHERE v.id.loader=:loader AND v.id.pkg=:pkg ORDER BY v.id.pkg, v.id.name", GroovyClass.class.getSimpleName());
		Map<String, Serializable> params = new HashMap<>();
		params.put("loader", loader);
		params.put("pkg", pkg);
		return new CommonDAO<>(GroovyClass.class).list(jql, params, page, pageSize);
	}

	@Override
	public Collection<GroovyClass> listNextPackageClasses(String loader, String pkg, String name, int page, int pageSize) throws StorageException {
		return listPackageClasses(loader, pkg, page, pageSize);
	}

	@Override
	public Collection<GroovyClass> listArchiveClasses(String loader, String fileName, int page, int pageSize) throws StorageException {
		String jql = String.format("SELECT NEW io.boodskap.iot.model.jpa.GroovyClass(v.id.loader, v.id.pkg, v.id.name, v.fileName) FROM %s v WHERE v.id.loader=:loader AND v.fileName=:fname ORDER BY v.id.pkg, v.id.name", GroovyClass.class.getSimpleName());
		Map<String, Serializable> params = new HashMap<>();
		params.put("loader", loader);
		params.put("fname", fileName);
		return new CommonDAO<>(GroovyClass.class).list(jql, params, page, pageSize);
	}

	@Override
	public Collection<GroovyClass> listNextArchiveClasses(String loader, String fileName, String pkg, String name, int page, int pageSize) throws StorageException {
		return listArchiveClasses(loader, fileName, page, pageSize);
	}

	@Override
	public Collection<GroovyClass> listArchivePackageClasses(String loader, String fileName, String pkg, int page, int pageSize) throws StorageException {
		String jql = String.format("SELECT NEW io.boodskap.iot.model.jpa.GroovyClass(v.id.loader, v.id.pkg, v.id.name, v.fileName) FROM %s v WHERE v.id.loader=:loader AND v.id.pkg=:pkg AND v.fileName=:fname ORDER BY v.id.pkg, v.id.name", GroovyClass.class.getSimpleName());
		Map<String, Serializable> params = new HashMap<>();
		params.put("loader", loader);
		params.put("pkg", pkg);
		params.put("fname", fileName);
		return new CommonDAO<>(GroovyClass.class).list(jql, params, page, pageSize);
	}

	@Override
	public Collection<GroovyClass> listNextArchivePackageClasses(String loader, String fileName, String pkg, String name, int page, int pageSize) throws StorageException {
		return listArchivePackageClasses(loader, fileName, pkg, page, pageSize);
	}

	@Override
	public Collection<String> listPackages(String loader, int page, int pageSize) throws StorageException {
		String jql = String.format("SELECT DISTINCT(v.id.pkg) FROM %s v WHERE v.id.loader=:loader ORDER BY v.id.pkg", GroovyClass.class.getSimpleName());
		Map<String, Serializable> params = new HashMap<>();
		params.put("loader", loader);
		return new CommonDAO<>(String.class).list(jql, params, page, pageSize);
	}

	@Override
	public Collection<String> listNextPackages(String loader, String pkg, int page, int pageSize) throws StorageException {
		return listPackages(loader, page, pageSize);
	}

	@Override
	public Collection<String> listArchivePackages(String loader, String fileName, int page, int pageSize) throws StorageException {
		String jql = String.format("SELECT DISTINCT(v.id.pkg) FROM %s v WHERE v.id.loader=:loader AND v.fileName=:fname ORDER BY v.id.pkg", GroovyClass.class.getSimpleName());
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
