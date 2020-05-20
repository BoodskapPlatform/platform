package io.boodskap.iot.spi.storage.jpa.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.TypedQuery;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.dao.GroovyArchiveFileDAO;
import io.boodskap.iot.model.IGroovyArchiveFile;
import io.boodskap.iot.model.jpa.GroovyArchiveFile;
import io.boodskap.iot.model.jpa.GroovyArchiveFileId;
import io.boodskap.iot.spi.storage.jpa.UOW;
import io.boodskap.iot.spi.storage.jpa.dao.util.CommonDAO;
import io.boodskap.iot.spi.storage.jpa.dao.util.DBUtil;
import io.boodskap.iot.spi.storage.jpa.dao.util.EntityIteratorImpl;

public class GroovyArchiveFileDAOImpl implements GroovyArchiveFileDAO<GroovyArchiveFile> {
	
	private static final GroovyArchiveFileDAO<GroovyArchiveFile> instance = new GroovyArchiveFileDAOImpl();
	
	private GroovyArchiveFileDAOImpl() {
	}
	
	public static final GroovyArchiveFileDAO<GroovyArchiveFile> get(){
		return instance;
	}

	@Override
	public Class<GroovyArchiveFile> clazz() {
		return GroovyArchiveFile.class;
	}

	@Override
	public GroovyArchiveFile get(String loader, String fileName, boolean loadContent) throws StorageException {
		if(loadContent) {
			return new CommonDAO<>(GroovyArchiveFile.class).find(new GroovyArchiveFileId(loader, fileName));
		}else {
			String jql = String.format("SELECT NEW io.boodskap.iot.model.jpa.GroovyArchiveFile(v.id.loader, v.id.fileName) FROM %s v WHERE v.id.loader=:loader AND v.id.fileName=:fname", GroovyArchiveFile.class.getSimpleName());
			Map<String, Serializable> params = new HashMap<>();
			params.put("loader", loader);
			params.put("fname", fileName);
			return new CommonDAO<>(GroovyArchiveFile.class).select(jql, params);
		}
	}

	@Override
	public GroovyArchiveFile create(String loader, String fileName) {
		return new GroovyArchiveFile(new GroovyArchiveFileId(loader, fileName));
	}

	@Override
	public void createOrUpdate(GroovyArchiveFile e) throws StorageException {
		try {
			
			final IGroovyArchiveFile oe = get(e.getLoader(), e.getFileName(), false);
			IGroovyArchiveFile ne;
			
			if(null == oe) {
				ne = create(e.getLoader(), e.getFileName());
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
		return new CommonDAO<>(GroovyArchiveFile.class).count();
	}

	@Override
	public long count(String loader) throws StorageException {
		return new CommonDAO<>(GroovyArchiveFile.class).count("id.loader", loader);
	}

	@Override
	public void delete() throws StorageException {
		new CommonDAO<>(GroovyArchiveFile.class).delete();
	}

	@Override
	public void delete(String loader) throws StorageException {
		new CommonDAO<>(GroovyArchiveFile.class).delete("id.loader", loader);
	}

	@Override
	public void delete(String loader, String fileName) throws StorageException {
		new CommonDAO<>(GroovyArchiveFile.class).delete("id.loader", loader, "id.fileName", fileName);
	}

	@Override
	public EntityIterator<GroovyArchiveFile> load() throws StorageException {
		return new EntityIteratorImpl<>(GroovyArchiveFile.class, "id.loader");
	}

	@Override
	public EntityIterator<GroovyArchiveFile> load(String loader) throws StorageException {
		return new EntityIteratorImpl<>(GroovyArchiveFile.class, "id.loader", loader, "id.fileName");
	}

	@Override
	public Collection<GroovyArchiveFile> list(String loader, int page, int pageSize, boolean loadContent) throws StorageException {
		if(loadContent) {
			return new CommonDAO<>(GroovyArchiveFile.class).list("id.loader", loader, page, pageSize, "id.fileName");
		}else {
			
			String jql = String.format("SELECT NEW io.boodskap.iot.model.jpa.GroovyArchiveFile(v.id.loader, v.id.fileName) FROM %s v WHERE v.id.loader=:loader ORDER BY v.id.fileName", GroovyArchiveFile.class.getSimpleName());
			Map<String, Serializable> params = new HashMap<>();
			params.put("loader", loader);
			return new CommonDAO<>(GroovyArchiveFile.class).list(jql, params, page, pageSize);
		}
	}

	@Override
	public Collection<GroovyArchiveFile> listNext(String loader, String fileName, int page, int pageSize, boolean loadContent) throws StorageException {
		return list(loader, page, pageSize, loadContent);
	}

	@Override
	public Collection<GroovyArchiveFile> search(String query, int pageSize) throws StorageException {
		
		String jql = String.format("SELECT NEW io.boodskap.iot.model.jpa.GroovyArchiveFile(v.id.loader, v.id.fileName) FROM %s v WHERE %s", GroovyArchiveFile.class.getSimpleName(), DBUtil.searchToQuery(query));
		TypedQuery<GroovyArchiveFile> tquery = UOW.createQuery(jql, GroovyArchiveFile.class);
		
		tquery.setFirstResult(0);
		tquery.setMaxResults(pageSize);
		Collection<GroovyArchiveFile> list = tquery.getResultList();
		return list;

	}

}
