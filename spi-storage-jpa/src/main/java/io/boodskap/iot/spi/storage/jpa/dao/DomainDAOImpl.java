package io.boodskap.iot.spi.storage.jpa.dao;

import java.util.Collection;
import java.util.Date;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.DomainDAO;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.model.IDomain;
import io.boodskap.iot.model.jpa.Domain;
import io.boodskap.iot.spi.storage.jpa.UOW;
import io.boodskap.iot.spi.storage.jpa.dao.util.CommonDAO;
import io.boodskap.iot.spi.storage.jpa.dao.util.EntityIteratorImpl;

public class DomainDAOImpl implements DomainDAO<Domain> {
	
	private static final DomainDAO<Domain> dao = new DomainDAOImpl();

	protected DomainDAOImpl() {
	}
	
	public static DomainDAO<Domain> get() {
		return dao;
	}

	@Override
	public Domain create(String domainKey) {
		return new Domain(domainKey);
	}

	@Override
	public Class<? extends Domain> clazz() {
		return Domain.class;
	}

	@Override
	public void createOrUpdate(Domain e) throws StorageException {
		
		try {
			
			final IDomain oe = get(e.getDomainKey());
			IDomain ne;
			
			if(null == oe) {
				ne = new Domain(e.getDomainKey());
				ne.setRegisteredStamp(new Date());
			}else {
				ne = oe;
			}
			
			UOW.begin();
			
			ne.setAddress(e.getAddress());
			ne.setCity(e.getCity());
			ne.setCountry(e.getCountry());
			ne.setDescription(e.getDescription());
			ne.setEmail(e.getEmail());
			ne.setLocale(e.getLocale());
			ne.setName(e.getName());
			ne.setPrimaryPhone(e.getPrimaryPhone());
			ne.setState(e.getState());
			ne.setTimeZone(e.getTimeZone());
			ne.setUpdatedStamp(new Date());
			ne.setZipcode(e.getZipcode());
			
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
	public EntityIterator<Domain> load() throws StorageException {
		return new EntityIteratorImpl<>(Domain.class, "domainKey");
	}

	@Override
	public EntityIterator<Domain> load(String domainKey) throws StorageException {
		return new EntityIteratorImpl<>("domainKey", domainKey, "domainKey", Domain.class);
	}

	@Override
	public long count() throws StorageException {
		return new CommonDAO<>(Domain.class).count();
	}

	@Override
	public long count(String domainKey) throws StorageException {
		return new CommonDAO<>(Domain.class).count("domainKey", domainKey);
	}

	@Override
	public void delete() throws StorageException {
		new CommonDAO<>(Domain.class).delete();
	}

	@Override
	public void delete(String domainKey) throws StorageException {
		new CommonDAO<>(Domain.class).delete("domainKey", domainKey);
	}

	@Override
	public Domain get(String domainKey) throws StorageException {
		return new CommonDAO<>(Domain.class).find(domainKey);
	}

	@Override
	public Collection<Domain> list(int page, int pageSize) throws StorageException {
		return new CommonDAO<>(Domain.class).list(page, pageSize, "domainKey");
	}

	@Override
	public Collection<Domain> listNext(String domainKey, int page, int pageSize) throws StorageException {
		return list(page, pageSize);
	}

	@Override
	public Collection<Domain> search(String query, int pageSize) throws StorageException {
		return new CommonDAO<>(Domain.class).search(query, pageSize);
	}

}
