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
import io.boodskap.iot.dao.DomainGroovyClassDAO;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.model.IDomainGroovyClass;
import io.boodskap.iot.model.jpa.DomainGroovyClass;
import io.boodskap.iot.model.jpa.DomainGroovyClassId;
import io.boodskap.iot.spi.storage.jpa.UOW;
import io.boodskap.iot.spi.storage.jpa.dao.util.CommonDAO;
import io.boodskap.iot.spi.storage.jpa.dao.util.DBUtil;
import io.boodskap.iot.spi.storage.jpa.dao.util.EntityIteratorImpl;

public class DomainGroovyClassDAOImpl implements DomainGroovyClassDAO<DomainGroovyClass> {
	
	private static final DomainGroovyClassDAO<DomainGroovyClass> instance = new DomainGroovyClassDAOImpl();
	
	private static final Logger LOG = LoggerFactory.getLogger(DomainGroovyClassDAOImpl.class);

	private DomainGroovyClassDAOImpl() {
	}
	
	public static final DomainGroovyClassDAO<DomainGroovyClass> get(){
		return instance;
	}

	@Override
	public Class<DomainGroovyClass> clazz() {
		return DomainGroovyClass.class;
	}

	@Override
	public DomainGroovyClass create(String domainKey, String loader, String pkg, String name) {
		return new DomainGroovyClass(new DomainGroovyClassId(domainKey, loader, pkg, name));
	}

	@Override
	public void createOrUpdate(DomainGroovyClass e) throws StorageException {
		try {
			
			final IDomainGroovyClass oe = get(e.getDomainKey(), e.getLoader(), e.getPkg(), e.getName(), false);
			IDomainGroovyClass ne;
			
			if(null == oe) {
				ne = new DomainGroovyClass(new DomainGroovyClassId(e.getDomainKey(), e.getLoader(), e.getPkg(), e.getName()));
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
	public EntityIterator<DomainGroovyClass> load() throws StorageException {
		return new EntityIteratorImpl<>(DomainGroovyClass.class, "id.domainKey");
	}

	@Override
	public EntityIterator<DomainGroovyClass> load(String domainKey) throws StorageException {
		return new EntityIteratorImpl<>(DomainGroovyClass.class, domainKey, "id.loader");
	}

	@Override
	public DomainGroovyClass get(String domainKey, String loader, String pkg, String name, boolean loadContent) throws StorageException {
		if(loadContent) {
			return new CommonDAO<>(DomainGroovyClass.class).find(new DomainGroovyClassId(domainKey, loader, pkg, name));
		}else {
			String jql = String.format("SELECT NEW io.boodskap.iot.model.jpa.DomainGroovyClass(v.id.domainKey, v.id.loader, v.id.pkg, v.id.name, v.fileName) FROM %s v WHERE v.id.domainKey=:dkey AND v.id.loader=:loader AND v.id.pkg=:pkg AND v.id.name=:cname", DomainGroovyClass.class.getSimpleName());
			Map<String, Serializable> params = new HashMap<>();
			params.put("dkey", domainKey);
			params.put("loader", loader);
			params.put("pkg", pkg);
			params.put("cname", name);
			return new CommonDAO<>(DomainGroovyClass.class).select(jql, params);
		}
	}

	@Override
	public long count() throws StorageException {
		return new CommonDAO<>(DomainGroovyClass.class).count();
	}

	@Override
	public long count(String domainKey) throws StorageException {
		return new CommonDAO<>(DomainGroovyClass.class).count(domainKey);
	}

	@Override
	public long count(String domainKey, String loader) throws StorageException {
		return new CommonDAO<>(DomainGroovyClass.class).count(domainKey, "loader", loader);
	}

	@Override
	public long count(String domainKey, String loader, String pkg) throws StorageException {
		return new CommonDAO<>(DomainGroovyClass.class).count(domainKey, "loader", loader, "pkg", pkg);
	}

	@Override
	public void delete() throws StorageException {
		new CommonDAO<>(DomainGroovyClass.class).delete();
	}

	@Override
	public void delete(String domainKey) throws StorageException {
		new CommonDAO<>(DomainGroovyClass.class).delete(domainKey);
	}

	@Override
	public void delete(String domainKey, String loader) throws StorageException {
		new CommonDAO<>(DomainGroovyClass.class).delete(domainKey, "loader", loader);
	}

	@Override
	public void delete(String domainKey, String loader, String pkg) throws StorageException {
		new CommonDAO<>(DomainGroovyClass.class).delete(domainKey, "loader", loader, "pkg", pkg);
	}

	@Override
	public void delete(String domainKey, String loader, String pkg, String name) throws StorageException {
		new CommonDAO<>(DomainGroovyClass.class).delete(domainKey, "loader", loader, "pkg", pkg, "name", name);
	}

	@Override
	public void deleteArchive(String domainKey, String loader, String fileName) throws StorageException {
		try {
			Query query = UOW.createQuery(String.format("delete from %s v where v.id.domainKey=:dkey and v.id.loader=:loader and v.fileName=:fname", DomainGroovyClass.class.getSimpleName()));
			query.setParameter("dkey", domainKey);
			query.setParameter("loader", loader);
			query.setParameter("fname", fileName);
			UOW.begin();
			int deleted = query.executeUpdate();
			UOW.commit();
			LOG.debug(String.format("deleted %d %ses", deleted, DomainGroovyClass.class.getSimpleName().toLowerCase()));
		}catch(Exception ex) {
			throw new StorageException(ex);
		}
	}

	@Override
	public Collection<DomainGroovyClass> search(String domainKey, String query, int pageSize) throws StorageException {
		
		String jql = String.format("SELECT NEW io.boodskap.iot.model.jpa.DomainGroovyClass(v.id.domainKey, v.id.loader, v.id.pkg, v.id.name, v.fileName) FROM %s v WHERE %s", DomainGroovyClass.class.getSimpleName(), DBUtil.searchToQuery(query));
		TypedQuery<DomainGroovyClass> tquery = UOW.createQuery(jql, DomainGroovyClass.class);
		
		tquery.setFirstResult(0);
		tquery.setMaxResults(pageSize);
		Collection<DomainGroovyClass> list = tquery.getResultList();
		return list;
	}

	@Override
	public long countArchive(String domainKey, String loader, String fileName) throws StorageException {
		try {
			Query query = UOW.createQuery(String.format("select count(v) from %s v where v.id.domainKey=:dkey and v.id.loader=:loader and v.fileName=:fname", DomainGroovyClass.class.getSimpleName()));
			query.setParameter("dkey", domainKey);
			query.setParameter("loader", loader);
			query.setParameter("fname", fileName);
			return DBUtil.toCount(query.getSingleResult());
		}catch(Exception ex) {
			throw new StorageException(ex);
		}
	}

	@Override
	public long countArchive(String domainKey, String loader, String fileName, String pkg) throws StorageException {
		try {
			Query query = UOW.createQuery(String.format("select count(v) from %s v where v.id.domainKey=:dkey and v.id.loader=:loader and v.id.pkg=:pkg and v.fileName=:fname", DomainGroovyClass.class.getSimpleName()));
			query.setParameter("dkey", domainKey);
			query.setParameter("loader", loader);
			query.setParameter("pkg", pkg);
			query.setParameter("fname", fileName);
			return DBUtil.toCount(query.getSingleResult());
		}catch(Exception ex) {
			throw new StorageException(ex);
		}
	}

	@Override
	public Collection<DomainGroovyClass> listClasses(String domainKey, String loader, int page, int pageSize) throws StorageException {
		String jql = String.format("SELECT NEW io.boodskap.iot.model.jpa.DomainGroovyClass(v.id.domainKey, v.id.loader, v.id.pkg, v.id.name, v.fileName) FROM %s v WHERE v.id.domainKey=:dkey AND v.id.loader=:loader ORDER BY v.id.pkg, v.id.name", DomainGroovyClass.class.getSimpleName());
		Map<String, Serializable> params = new HashMap<>();
		params.put("dkey", domainKey);
		params.put("loader", loader);
		return new CommonDAO<>(DomainGroovyClass.class).list(jql, params, page, pageSize);
	}

	@Override
	public Collection<DomainGroovyClass> listNextClasses(String domainKey, String loader, String pkg, String name, int page, int pageSize) throws StorageException {
		return listClasses(domainKey, loader, page, pageSize);
	}

	@Override
	public Collection<DomainGroovyClass> listPackageClasses(String domainKey, String loader, String pkg, int page, int pageSize) throws StorageException {
		String jql = String.format("SELECT NEW io.boodskap.iot.model.jpa.DomainGroovyClass(v.id.domainKey, v.id.loader, v.id.pkg, v.id.name, v.fileName) FROM %s v WHERE v.id.domainKey=:dkey AND v.id.loader=:loader AND v.id.pkg=:pkg ORDER BY v.id.pkg, v.id.name", DomainGroovyClass.class.getSimpleName());
		Map<String, Serializable> params = new HashMap<>();
		params.put("dkey", domainKey);
		params.put("loader", loader);
		params.put("pkg", pkg);
		return new CommonDAO<>(DomainGroovyClass.class).list(jql, params, page, pageSize);
	}

	@Override
	public Collection<DomainGroovyClass> listNextPackageClasses(String domainKey, String loader, String pkg, String name, int page, int pageSize) throws StorageException {
		return listPackageClasses(domainKey, loader, pkg, page, pageSize);
	}

	@Override
	public Collection<DomainGroovyClass> listArchiveClasses(String domainKey, String loader, String fileName, int page, int pageSize) throws StorageException {
		String jql = String.format("SELECT NEW io.boodskap.iot.model.jpa.DomainGroovyClass(v.id.domainKey, v.id.loader, v.id.pkg, v.id.name, v.fileName) FROM %s v WHERE v.id.domainKey=:dkey AND v.id.loader=:loader AND v.fileName=:fname ORDER BY v.id.pkg, v.id.name", DomainGroovyClass.class.getSimpleName());
		Map<String, Serializable> params = new HashMap<>();
		params.put("dkey", domainKey);
		params.put("loader", loader);
		params.put("fname", fileName);
		return new CommonDAO<>(DomainGroovyClass.class).list(jql, params, page, pageSize);
	}

	@Override
	public Collection<DomainGroovyClass> listNextArchiveClasses(String domainKey, String loader, String fileName, String pkg, String name, int page, int pageSize) throws StorageException {
		return listArchiveClasses(domainKey, loader, fileName, page, pageSize);
	}

	@Override
	public Collection<DomainGroovyClass> listArchivePackageClasses(String domainKey, String loader, String fileName, String pkg, int page, int pageSize) throws StorageException {
		String jql = String.format("SELECT NEW io.boodskap.iot.model.jpa.DomainGroovyClass(v.id.domainKey, v.id.loader, v.id.pkg, v.id.name, v.fileName) FROM %s v WHERE v.id.domainKey=:dkey AND v.id.loader=:loader AND v.id.pkg=:pkg AND v.fileName=:fname ORDER BY v.id.pkg, v.id.name", DomainGroovyClass.class.getSimpleName());
		Map<String, Serializable> params = new HashMap<>();
		params.put("dkey", domainKey);
		params.put("loader", loader);
		params.put("pkg", pkg);
		params.put("fname", fileName);
		return new CommonDAO<>(DomainGroovyClass.class).list(jql, params, page, pageSize);
	}

	@Override
	public Collection<DomainGroovyClass> listNextArchivePackageClasses(String domainKey, String loader, String fileName, String pkg, String name, int page, int pageSize) throws StorageException {
		return listArchivePackageClasses(domainKey, loader, fileName, pkg, page, pageSize);
	}

	@Override
	public Collection<String> listPackages(String domainKey, String loader, int page, int pageSize) throws StorageException {
		String jql = String.format("SELECT DISTINCT(v.id.pkg) FROM %s v WHERE v.id.domainKey=:dkey AND v.id.loader=:loader ORDER BY v.id.pkg", DomainGroovyClass.class.getSimpleName());
		Map<String, Serializable> params = new HashMap<>();
		params.put("dkey", domainKey);
		params.put("loader", loader);
		return new CommonDAO<>(String.class).list(jql, params, page, pageSize);
	}

	@Override
	public Collection<String> listNextPackages(String domainKey, String loader, String pkg, int page, int pageSize) throws StorageException {
		return listPackages(domainKey, loader, page, pageSize);
	}

	@Override
	public Collection<String> listArchivePackages(String domainKey, String loader, String fileName, int page, int pageSize) throws StorageException {
		String jql = String.format("SELECT DISTINCT(v.id.pkg) FROM %s v WHERE v.id.domainKey=:dkey AND v.id.loader=:loader AND v.fileName=:fname ORDER BY v.id.pkg", DomainGroovyClass.class.getSimpleName());
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
