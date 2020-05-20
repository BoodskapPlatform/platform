package io.boodskap.iot.spi.storage.jpa.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.TypedQuery;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.DomainJarFileDAO;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.model.IDomainJarFile;
import io.boodskap.iot.model.jpa.DomainJarFile;
import io.boodskap.iot.model.jpa.DomainJarFileId;
import io.boodskap.iot.spi.storage.jpa.UOW;
import io.boodskap.iot.spi.storage.jpa.dao.util.CommonDAO;
import io.boodskap.iot.spi.storage.jpa.dao.util.DBUtil;
import io.boodskap.iot.spi.storage.jpa.dao.util.EntityIteratorImpl;

public class DomainJarFileDAOImpl implements DomainJarFileDAO<DomainJarFile>{
	
	private static final DomainJarFileDAO<DomainJarFile> instance =  new DomainJarFileDAOImpl();
	
	private DomainJarFileDAOImpl() {
	}
	
	public static final DomainJarFileDAO<DomainJarFile> get(){
		return instance;
	}

	@Override
	public Class<DomainJarFile> clazz() {
		return DomainJarFile.class;
	}

	@Override
	public DomainJarFile create(String domainKey, String loader, String fileName) {
		return new DomainJarFile(new DomainJarFileId(domainKey, loader, fileName));
	}

	@Override
	public DomainJarFile get(String domainKey, String loader, String fileName, boolean loadContent) throws StorageException {
		if(loadContent) {
			return new CommonDAO<>(DomainJarFile.class).find(new DomainJarFileId(domainKey, loader, fileName));
		}else {
			String jql = String.format("SELECT NEW io.boodskap.iot.model.jpa.DomainJarFile(v.id.domainKey, v.id.loader, v.id.fileName) FROM %s v WHERE v.id.domainKey=:dkey AND v.id.loader=:loader AND v.id.fileName=:fname", DomainJarFile.class.getSimpleName());
			Map<String, Serializable> params = new HashMap<>();
			params.put("dkey", domainKey);
			params.put("loader", loader);
			params.put("fname", fileName);
			return new CommonDAO<>(DomainJarFile.class).select(jql, params);
		}
	}

	@Override
	public void createOrUpdate(DomainJarFile e) throws StorageException {
		try {
			
			final IDomainJarFile oe = get(e.getDomainKey(), e.getLoader(), e.getFileName(), false);
			IDomainJarFile ne;
			
			if(null == oe) {
				ne = create(e.getDomainKey(), e.getLoader(), e.getFileName());
			}else {
				ne = oe;
			}
			
			UOW.begin();

			ne.setObjectCode(e.getObjectCode());
			
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
		return new CommonDAO<>(DomainJarFile.class).count();
	}

	@Override
	public long count(String domainKey) throws StorageException {
		return new CommonDAO<>(DomainJarFile.class).count(domainKey);
	}

	@Override
	public long count(String domainKey, String loader) throws StorageException {
		return new CommonDAO<>(DomainJarFile.class).count(domainKey, "loader", loader);
	}

	@Override
	public void delete() throws StorageException {
		new CommonDAO<>(DomainJarFile.class).delete();
	}

	@Override
	public void delete(String domainKey) throws StorageException {
		new CommonDAO<>(DomainJarFile.class).delete(domainKey);
	}

	@Override
	public void delete(String domainKey, String loader) throws StorageException {
		new CommonDAO<>(DomainJarFile.class).delete(domainKey, "loader", loader);
	}

	@Override
	public void delete(String domainKey, String loader, String fileName) throws StorageException {
		new CommonDAO<>(DomainJarFile.class).delete(domainKey, "loader", loader, "fileName", fileName);
	}

	@Override
	public EntityIterator<DomainJarFile> load() throws StorageException {
		return new EntityIteratorImpl<>(DomainJarFile.class, "id.domainKey");
	}

	@Override
	public EntityIterator<DomainJarFile> load(String domainKey) throws StorageException {
		return new EntityIteratorImpl<>(DomainJarFile.class, domainKey, "id.loader");
	}

	@Override
	public Collection<DomainJarFile> list(String domainKey, String loader, int page, int pageSize, boolean loadContent) throws StorageException {
		if(loadContent) {
			return new CommonDAO<>(DomainJarFile.class).list(domainKey, "loader", loader, page, pageSize, "id.fileName");
		}else {
			
			String jql = String.format("SELECT NEW io.boodskap.iot.model.jpa.DomainJarFile(v.id.domainKey, v.id.loader, v.id.fileName) FROM %s v WHERE v.id.domainKey=:dkey AND v.id.loader=:loader ORDER BY v.id.fileName", DomainJarFile.class.getSimpleName());
			Map<String, Serializable> params = new HashMap<>();
			params.put("dkey", domainKey);
			params.put("loader", loader);
			return new CommonDAO<>(DomainJarFile.class).list(jql, params, page, pageSize);
		}
	}

	@Override
	public Collection<DomainJarFile> listNext(String domainKey, String loader, String fileName, int page, int pageSize, boolean loadContent) throws StorageException {
		return list(domainKey, loader, page, pageSize, loadContent);
	}

	@Override
	public Collection<DomainJarFile> search(String domainKey, String query, int pageSize) throws StorageException {
		
		String jql = String.format("SELECT NEW io.boodskap.iot.model.jpa.DomainJarFile(v.id.domainKey, v.id.loader, v.id.fileName) FROM %s v WHERE %s", DomainJarFile.class.getSimpleName(), DBUtil.searchToQuery(query));
		TypedQuery<DomainJarFile> tquery = UOW.createQuery(jql, DomainJarFile.class);
		
		tquery.setFirstResult(0);
		tquery.setMaxResults(pageSize);
		Collection<DomainJarFile> list = tquery.getResultList();
		return list;

	}

	
}
