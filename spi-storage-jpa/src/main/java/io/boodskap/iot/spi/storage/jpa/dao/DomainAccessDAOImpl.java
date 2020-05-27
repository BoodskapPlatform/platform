package io.boodskap.iot.spi.storage.jpa.dao;

import java.util.Collection;

import io.boodskap.iot.Access;
import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.DomainAccessDAO;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.model.IDomainAccess;
import io.boodskap.iot.model.jpa.DomainAccess;
import io.boodskap.iot.model.jpa.DomainAccessId;
import io.boodskap.iot.spi.storage.jpa.UOW;
import io.boodskap.iot.spi.storage.jpa.dao.util.CommonDAO;
import io.boodskap.iot.spi.storage.jpa.dao.util.EntityIteratorImpl;

public class DomainAccessDAOImpl implements DomainAccessDAO<DomainAccess> {
	
	private static final DomainAccessDAO<DomainAccess> dao = new DomainAccessDAOImpl();
	
	protected DomainAccessDAOImpl() {
	}
	
	public static final DomainAccessDAO<DomainAccess> get() {
		return dao;
	}

	@Override
	public DomainAccess create(String domainKey, Access access) {
		return new DomainAccess(new DomainAccessId(domainKey, access));
	}

	@Override
	public Class<? extends DomainAccess> clazz() {
		return DomainAccess.class;
	}

	@Override
	public void createOrUpdate(DomainAccess e) throws StorageException {
		
		try {
			
			final IDomainAccess oe = get(e.getDomainKey(), e.getAccess());
			IDomainAccess ne;
			
			if(null == oe) {
				ne = new DomainAccess(new DomainAccessId(e.getDomainKey(), e.getAccess()));
			}else {
				ne = oe;
			}
			
			UOW.begin();
			
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
	public EntityIterator<DomainAccess> load() throws StorageException {
		return new EntityIteratorImpl<>(DomainAccess.class, "id.domainKey");
	}

	@Override
	public EntityIterator<DomainAccess> load(String domainKey) throws StorageException {
		return new EntityIteratorImpl<>(DomainAccess.class, domainKey, "id.access");
	}

	@Override
	public long count() throws StorageException {
		return new CommonDAO<>(DomainAccess.class).count();
	}

	@Override
	public long count(String domainKey) throws StorageException {
		return new CommonDAO<>(DomainAccess.class).count(domainKey);
	}

	@Override
	public boolean has(String domainKey, Access access) throws StorageException {
		return get(domainKey, access) != null;
	}

	@Override
	public DomainAccess get(String domainKey, Access access) throws StorageException {
		return new CommonDAO<>(DomainAccess.class).find(new DomainAccessId(domainKey, access));
	}

	@Override
	public void delete(String domainKey) throws StorageException {
		new CommonDAO<>(DomainAccess.class).delete(domainKey);
	}

	@Override
	public void delete(String domainKey, Access access) throws StorageException {
		new CommonDAO<>(DomainAccess.class).delete(domainKey, "access", access);
	}

	@Override
	public Collection<DomainAccess> list(String domainKey, int page, int pageSize) throws StorageException {
		return new CommonDAO<>(DomainAccess.class).list(domainKey, page, pageSize, "id.access");
	}

	@Override
	public Collection<DomainAccess> listNext(String domainKey, Access access, int page, int pageSize) throws StorageException {
		return list(domainKey, page, pageSize);
	}

	@Override
	public void delete() throws StorageException {
		new CommonDAO<>(DomainAccess.class).delete();
	}

}
