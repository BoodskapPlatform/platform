package io.boodskap.iot.spi.storage.jpa.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.TypedQuery;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.dao.JarFileDAO;
import io.boodskap.iot.model.IJarFile;
import io.boodskap.iot.model.jpa.JarFile;
import io.boodskap.iot.model.jpa.JarFileId;
import io.boodskap.iot.spi.storage.jpa.UOW;
import io.boodskap.iot.spi.storage.jpa.dao.util.CommonDAO;
import io.boodskap.iot.spi.storage.jpa.dao.util.DBUtil;
import io.boodskap.iot.spi.storage.jpa.dao.util.EntityIteratorImpl;

public class JarFileDAOImpl implements JarFileDAO<JarFile> {
	
	private static final JarFileDAO<JarFile> instance = new JarFileDAOImpl();
	
	private JarFileDAOImpl() {
	}
	
	public static final JarFileDAO<JarFile> get(){
		return instance;
	}

	@Override
	public Class<JarFile> clazz() {
		return JarFile.class;
	}

	@Override
	public JarFile get(String loader, String fileName, boolean loadContent) throws StorageException {
		if(loadContent) {
			return new CommonDAO<>(JarFile.class).find(new JarFileId(loader, fileName));
		}else {
			String jql = String.format("SELECT NEW io.boodskap.iot.model.jpa.JarFile(v.id.loader, v.id.fileName) FROM %s v WHERE v.id.loader=:loader AND v.id.fileName=:fname", JarFile.class.getSimpleName());
			Map<String, Serializable> params = new HashMap<>();
			params.put("loader", loader);
			params.put("fname", fileName);
			return new CommonDAO<>(JarFile.class).select(jql, params);
		}
	}

	@Override
	public JarFile create(String loader, String fileName) {
		return new JarFile(new JarFileId(loader, fileName));
	}

	@Override
	public void createOrUpdate(JarFile e) throws StorageException {
		try {
			
			final IJarFile oe = get(e.getLoader(), e.getFileName(), false);
			IJarFile ne;
			
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
		return new CommonDAO<>(JarFile.class).count();
	}

	@Override
	public long count(String loader) throws StorageException {
		return new CommonDAO<>(JarFile.class).count("id.loader", loader);
	}

	@Override
	public void delete() throws StorageException {
		new CommonDAO<>(JarFile.class).delete();
	}

	@Override
	public void delete(String loader) throws StorageException {
		new CommonDAO<>(JarFile.class).delete("id.loader", loader);
	}

	@Override
	public void delete(String loader, String fileName) throws StorageException {
		new CommonDAO<>(JarFile.class).delete("id.loader", loader, "id.fileName", fileName);
	}

	@Override
	public EntityIterator<JarFile> load() throws StorageException {
		return new EntityIteratorImpl<>(JarFile.class, "id.loader");
	}

	@Override
	public EntityIterator<JarFile> load(String loader) throws StorageException {
		return new EntityIteratorImpl<>(JarFile.class, "loader", loader, "id.fileName");
	}

	@Override
	public Collection<JarFile> list(String loader, int page, int pageSize, boolean loadContent) throws StorageException {
		if(loadContent) {
			return new CommonDAO<>(JarFile.class).list("loader", loader, page, pageSize, "id.fileName");
		}else {
			
			String jql = String.format("SELECT NEW io.boodskap.iot.model.jpa.JarFile(v.id.loader, v.id.fileName) FROM %s v WHERE v.id.loader=:loader ORDER BY v.id.fileName", JarFile.class.getSimpleName());
			Map<String, Serializable> params = new HashMap<>();
			params.put("loader", loader);
			return new CommonDAO<>(JarFile.class).list(jql, params, page, pageSize);
		}
	}

	@Override
	public Collection<JarFile> listNext(String loader, String fileName, int page, int pageSize, boolean loadContent) throws StorageException {
		return list(loader, page, pageSize, loadContent);
	}

	@Override
	public Collection<JarFile> search(String query, int pageSize) throws StorageException {
		
		String jql = String.format("SELECT NEW io.boodskap.iot.model.jpa.JarFile(v.id.loader, v.id.fileName) FROM %s v WHERE %s", JarFile.class.getSimpleName(), DBUtil.searchToQuery(query));
		TypedQuery<JarFile> tquery = UOW.createQuery(jql, JarFile.class);
		
		tquery.setFirstResult(0);
		tquery.setMaxResults(pageSize);
		Collection<JarFile> list = tquery.getResultList();
		return list;

	}

}
