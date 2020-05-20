package io.boodskap.iot.spi.storage.jpa.dao;

import java.util.Collection;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.DomainClassLoaderDAO;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.model.IDomainClassLoader;
import io.boodskap.iot.model.jpa.DomainClassLoader;
import io.boodskap.iot.model.jpa.DomainClassLoaderId;
import io.boodskap.iot.spi.storage.jpa.UOW;
import io.boodskap.iot.spi.storage.jpa.dao.util.CommonDAO;
import io.boodskap.iot.spi.storage.jpa.dao.util.EntityIteratorImpl;

public class DomainClassLoaderDAOImpl implements DomainClassLoaderDAO<DomainClassLoader> {
	
	private static final DomainClassLoaderDAO<DomainClassLoader> instance = new DomainClassLoaderDAOImpl();
	
	public static final DomainClassLoaderDAO<DomainClassLoader> get(){
		return instance;
	}

	@Override
	public Class<? extends DomainClassLoader> clazz() {
		return DomainClassLoader.class;
	}

	@Override
	public DomainClassLoader create(String domainKey, String loader) {
		return new DomainClassLoader(new DomainClassLoaderId(domainKey, loader));
	}

	@Override
	public DomainClassLoader get(String domainKey, String loader) throws StorageException {
		return new CommonDAO<>(DomainClassLoader.class).find(new DomainClassLoaderId(domainKey, loader));
	}

	@Override
	public void createOrUpdate(DomainClassLoader e) throws StorageException {
		try {
			
			final IDomainClassLoader oe = new CommonDAO<>(DomainClassLoader.class).find(new DomainClassLoaderId(e.getDomainKey(), e.getLoader()));
			IDomainClassLoader ne;
			
			if(null == oe) {
				ne = create(e.getDomainKey(), e.getLoader());
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
		return new CommonDAO<>(DomainClassLoader.class).count();
	}

	@Override
	public long count(String domainKey) throws StorageException {
		return new CommonDAO<>(DomainClassLoader.class).count(domainKey);
	}

	@Override
	public void delete() throws StorageException {
		new CommonDAO<>(DomainClassLoader.class).delete();
	}

	@Override
	public void delete(String domainKey) throws StorageException {
		new CommonDAO<>(DomainClassLoader.class).delete(domainKey);
	}

	@Override
	public void delete(String domainKey, String loader) throws StorageException {
		new CommonDAO<>(DomainClassLoader.class).delete(domainKey, "loader", loader);
	}

	@Override
	public EntityIterator<DomainClassLoader> load() throws StorageException {
		return new EntityIteratorImpl<>(DomainClassLoader.class, "id.domainKey");
	}

	@Override
	public EntityIterator<DomainClassLoader> load(String domainKey) throws StorageException {
		return new EntityIteratorImpl<>(DomainClassLoader.class, domainKey, "id.loader");
	}

	@Override
	public Collection<DomainClassLoader> list(String domainKey) throws StorageException {
		return new CommonDAO<>(DomainClassLoader.class).list(domainKey, "id.loader");
	}

	@Override
	public Collection<DomainClassLoader> search(String domainKey, String query, int pageSize) throws StorageException {
		return new CommonDAO<>(DomainClassLoader.class).search(query, domainKey, pageSize);
	}

}
