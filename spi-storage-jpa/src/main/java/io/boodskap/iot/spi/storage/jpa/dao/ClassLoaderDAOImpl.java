package io.boodskap.iot.spi.storage.jpa.dao;

import java.util.Collection;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.ClassLoaderDAO;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.model.IClassLoader;
import io.boodskap.iot.model.jpa.ClassLoader;
import io.boodskap.iot.spi.storage.jpa.UOW;
import io.boodskap.iot.spi.storage.jpa.dao.util.CommonDAO;
import io.boodskap.iot.spi.storage.jpa.dao.util.EntityIteratorImpl;

public class ClassLoaderDAOImpl implements ClassLoaderDAO<ClassLoader> {
		
	private static final ClassLoaderDAO<ClassLoader> instance = new ClassLoaderDAOImpl();
	
	private ClassLoaderDAOImpl() {
	}
	
	public static ClassLoaderDAO<ClassLoader> get(){
		return instance;
	}

	@Override
	public Class<ClassLoader> clazz() {
		return ClassLoader.class;
	}

	@Override
	public ClassLoader create(String loader) {
		return new ClassLoader(loader);
	}

	@Override
	public void createOrUpdate(ClassLoader e) throws StorageException {
		try {
			
			final IClassLoader oe = get(e.getLoader());
			IClassLoader ne;
			
			if(null == oe) {
				ne = create(e.getLoader());
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
	public ClassLoader get(String loader) throws StorageException {
		return new CommonDAO<>(ClassLoader.class).find(loader);
	}

	@Override
	public long count() throws StorageException {
		return new CommonDAO<>(ClassLoader.class).count();
	}

	@Override
	public void delete() throws StorageException {
		new CommonDAO<>(ClassLoader.class).delete();
	}

	@Override
	public void delete(String loader) throws StorageException {
		new CommonDAO<>(ClassLoader.class).delete("loader", loader);
	}

	@Override
	public EntityIterator<ClassLoader> load() throws StorageException {
		return new EntityIteratorImpl<>(ClassLoader.class, "dummy");
	}

	@Override
	public Collection<ClassLoader> list() throws StorageException {
		return new CommonDAO<>(ClassLoader.class).list("loader");
	}

	@Override
	public Collection<ClassLoader> search(String query, int pageSize) throws StorageException {
		return new CommonDAO<>(ClassLoader.class).search(query, pageSize);
	}

}
