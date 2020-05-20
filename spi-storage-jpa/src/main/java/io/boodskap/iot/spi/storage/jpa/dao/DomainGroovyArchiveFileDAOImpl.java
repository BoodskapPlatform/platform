package io.boodskap.iot.spi.storage.jpa.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.TypedQuery;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.DomainGroovyArchiveFileDAO;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.model.IDomainGroovyArchiveFile;
import io.boodskap.iot.model.jpa.DomainGroovyArchiveFile;
import io.boodskap.iot.model.jpa.DomainGroovyArchiveFileId;
import io.boodskap.iot.spi.storage.jpa.UOW;
import io.boodskap.iot.spi.storage.jpa.dao.util.CommonDAO;
import io.boodskap.iot.spi.storage.jpa.dao.util.DBUtil;
import io.boodskap.iot.spi.storage.jpa.dao.util.EntityIteratorImpl;

public class DomainGroovyArchiveFileDAOImpl implements DomainGroovyArchiveFileDAO<DomainGroovyArchiveFile>{
	
	private static final DomainGroovyArchiveFileDAO<DomainGroovyArchiveFile> instance =  new DomainGroovyArchiveFileDAOImpl();
	
	private DomainGroovyArchiveFileDAOImpl() {
	}
	
	public static final DomainGroovyArchiveFileDAO<DomainGroovyArchiveFile> get(){
		return instance;
	}

	@Override
	public Class<DomainGroovyArchiveFile> clazz() {
		return DomainGroovyArchiveFile.class;
	}

	@Override
	public DomainGroovyArchiveFile create(String domainKey, String loader, String fileName) {
		return new DomainGroovyArchiveFile(new DomainGroovyArchiveFileId(domainKey, loader, fileName));
	}

	@Override
	public DomainGroovyArchiveFile get(String domainKey, String loader, String fileName, boolean loadContent) throws StorageException {
		if(loadContent) {
			return new CommonDAO<>(DomainGroovyArchiveFile.class).find(new DomainGroovyArchiveFileId(domainKey, loader, fileName));
		}else {
			String jql = String.format("SELECT NEW io.boodskap.iot.model.jpa.DomainGroovyArchiveFile(v.id.domainKey, v.id.loader, v.id.fileName) FROM %s v WHERE v.id.domainKey=:dkey AND v.id.loader=:loader AND v.id.fileName=:fname", DomainGroovyArchiveFile.class.getSimpleName());
			Map<String, Serializable> params = new HashMap<>();
			params.put("dkey", domainKey);
			params.put("loader", loader);
			params.put("fname", fileName);
			return new CommonDAO<>(DomainGroovyArchiveFile.class).select(jql, params);
		}
	}

	@Override
	public void createOrUpdate(DomainGroovyArchiveFile e) throws StorageException {
		try {
			
			final IDomainGroovyArchiveFile oe = get(e.getDomainKey(), e.getLoader(), e.getFileName(), false);
			IDomainGroovyArchiveFile ne;
			
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
		return new CommonDAO<>(DomainGroovyArchiveFile.class).count();
	}

	@Override
	public long count(String domainKey) throws StorageException {
		return new CommonDAO<>(DomainGroovyArchiveFile.class).count(domainKey);
	}

	@Override
	public long count(String domainKey, String loader) throws StorageException {
		return new CommonDAO<>(DomainGroovyArchiveFile.class).count(domainKey, "loader", loader);
	}

	@Override
	public void delete() throws StorageException {
		new CommonDAO<>(DomainGroovyArchiveFile.class).delete();
	}

	@Override
	public void delete(String domainKey) throws StorageException {
		new CommonDAO<>(DomainGroovyArchiveFile.class).delete(domainKey);
	}

	@Override
	public void delete(String domainKey, String loader) throws StorageException {
		new CommonDAO<>(DomainGroovyArchiveFile.class).delete(domainKey, "loader", loader);
	}

	@Override
	public void delete(String domainKey, String loader, String fileName) throws StorageException {
		new CommonDAO<>(DomainGroovyArchiveFile.class).delete(domainKey, "loader", loader, "fileName", fileName);
	}

	@Override
	public EntityIterator<DomainGroovyArchiveFile> load() throws StorageException {
		return new EntityIteratorImpl<>(DomainGroovyArchiveFile.class, "id.domainKey");
	}

	@Override
	public EntityIterator<DomainGroovyArchiveFile> load(String domainKey) throws StorageException {
		return new EntityIteratorImpl<>(DomainGroovyArchiveFile.class, domainKey, "id.loader");
	}

	@Override
	public Collection<DomainGroovyArchiveFile> list(String domainKey, String loader, int page, int pageSize, boolean loadContent) throws StorageException {
		if(loadContent) {
			return new CommonDAO<>(DomainGroovyArchiveFile.class).list(domainKey, "loader", loader, page, pageSize, "id.fileName");
		}else {
			
			String jql = String.format("SELECT NEW io.boodskap.iot.model.jpa.DomainGroovyArchiveFile(v.id.domainKey, v.id.loader, v.id.fileName) FROM %s v WHERE v.id.domainKey=:dkey AND v.id.loader=:loader ORDER BY v.id.fileName", DomainGroovyArchiveFile.class.getSimpleName());
			Map<String, Serializable> params = new HashMap<>();
			params.put("dkey", domainKey);
			params.put("loader", loader);
			return new CommonDAO<>(DomainGroovyArchiveFile.class).list(jql, params, page, pageSize);
		}
	}

	@Override
	public Collection<DomainGroovyArchiveFile> listNext(String domainKey, String loader, String fileName, int page, int pageSize, boolean loadContent) throws StorageException {
		return list(domainKey, loader, page, pageSize, loadContent);
	}

	@Override
	public Collection<DomainGroovyArchiveFile> search(String domainKey, String query, int pageSize) throws StorageException {
		
		String jql = String.format("SELECT NEW io.boodskap.iot.model.jpa.DomainGroovyArchiveFile(v.id.domainKey, v.id.loader, v.id.fileName) FROM %s v WHERE %s", DomainGroovyArchiveFile.class.getSimpleName(), DBUtil.searchToQuery(query));
		TypedQuery<DomainGroovyArchiveFile> tquery = UOW.createQuery(jql, DomainGroovyArchiveFile.class);
		
		tquery.setFirstResult(0);
		tquery.setMaxResults(pageSize);
		Collection<DomainGroovyArchiveFile> list = tquery.getResultList();
		return list;

	}

	
}
