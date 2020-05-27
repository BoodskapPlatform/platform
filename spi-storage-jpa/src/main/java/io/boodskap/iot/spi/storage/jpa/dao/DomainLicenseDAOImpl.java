package io.boodskap.iot.spi.storage.jpa.dao;

import java.util.Date;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.DomainLicenseDAO;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.model.IDomainLicense;
import io.boodskap.iot.model.jpa.DomainLicense;
import io.boodskap.iot.spi.storage.jpa.UOW;
import io.boodskap.iot.spi.storage.jpa.dao.util.CommonDAO;
import io.boodskap.iot.spi.storage.jpa.dao.util.EntityIteratorImpl;

public class DomainLicenseDAOImpl implements DomainLicenseDAO<DomainLicense> {
	
	private static final DomainLicenseDAO<DomainLicense> dao = new DomainLicenseDAOImpl();
	
	protected DomainLicenseDAOImpl() {
	}
	
	public static final DomainLicenseDAO<DomainLicense> get() {
		return dao;
	}

	@Override
	public DomainLicense create(String domainKey) {
		return new DomainLicense(domainKey);
	}

	@Override
	public Class<? extends DomainLicense> clazz() {
		return DomainLicense.class;
	}

	@Override
	public void createOrUpdate(DomainLicense e) throws StorageException {
		
		try {
			
			final IDomainLicense oe = get(e.getDomainKey());
			IDomainLicense ne;
			
			if(null == oe) {
				ne = new DomainLicense(e.getDomainKey());
			}else {
				ne = oe;
			}
			
			UOW.begin();
			
			ne.setLicense(e.getLicense());
			ne.setUpdatedStamp(new Date());
			
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
	public EntityIterator<DomainLicense> load() throws StorageException {
		return new EntityIteratorImpl<>(DomainLicense.class, "domainKey");
	}

	@Override
	public EntityIterator<DomainLicense> load(String domainKey) throws StorageException {
		return new EntityIteratorImpl<>(DomainLicense.class, domainKey, "domainKey");
	}

	@Override
	public long count() throws StorageException {
		return new CommonDAO<>(DomainLicense.class).count();
	}

	@Override
	public long count(String domainKey) throws StorageException {
		return new CommonDAO<>(DomainLicense.class).count(domainKey);
	}

	@Override
	public void delete(String domainKey) throws StorageException {
		new CommonDAO<>(DomainLicense.class).delete(domainKey);
	}

	@Override
	public DomainLicense get(String domainKey) throws StorageException {
		return new CommonDAO<>(DomainLicense.class).find(domainKey);
	}

	@Override
	public void delete() throws StorageException {
		new CommonDAO<>(DomainLicense.class).delete();
	}

}
