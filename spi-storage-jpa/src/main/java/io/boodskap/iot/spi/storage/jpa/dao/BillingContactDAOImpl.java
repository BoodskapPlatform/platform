package io.boodskap.iot.spi.storage.jpa.dao;

import java.util.Collection;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.BillingContactDAO;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.model.IBillingContact;
import io.boodskap.iot.model.jpa.BillingContact;
import io.boodskap.iot.model.jpa.BillingContactId;
import io.boodskap.iot.spi.storage.jpa.UOW;
import io.boodskap.iot.spi.storage.jpa.dao.util.CommonDAO;
import io.boodskap.iot.spi.storage.jpa.dao.util.EntityIteratorImpl;

public class BillingContactDAOImpl implements BillingContactDAO<BillingContact> {
	
	private static final BillingContactDAO<BillingContact> instance = new BillingContactDAOImpl();
	
	protected BillingContactDAOImpl() {
	}
	
	public static final BillingContactDAO<BillingContact> get(){
		return instance;
	}

	@Override
	public BillingContact create(String domainKey, String targetDomain, String contactId) {
		return new BillingContact(new BillingContactId(domainKey, targetDomain, contactId));
	}

	@Override
	public Class<? extends BillingContact> clazz() {
		return BillingContact.class;
	}

	@Override
	public void createOrUpdate(BillingContact e) throws StorageException {
		
		try {
			
			final IBillingContact oe = get(e.getDomainKey(), e.getTargetDomain(), e.getContactId());
			IBillingContact ne;
			
			if(null == oe) {
				ne = new BillingContact(new BillingContactId(e.getDomainKey(), e.getTargetDomain(), e.getContactId()));
			}else {
				ne = oe;
			}
			
			UOW.begin();
			
			ne.setAddress(e.getAddress());
			ne.setCity(e.getCity());
			ne.setCountry(e.getCountry());
			ne.setEmail(e.getEmail());
			ne.setLogo(e.getLogo());
			ne.setName(e.getName());
			ne.setObj(e.getObj());
			ne.setState(e.getState());
			ne.setType(e.getType());
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
	public EntityIterator<BillingContact> load() throws StorageException {
		try {
			return new EntityIteratorImpl<BillingContact>(BillingContact.class, "id.domainKey");
		}catch(Exception ex) {
			throw new StorageException(ex);
		}
	}

	@Override
	public EntityIterator<BillingContact> load(String domainKey) throws StorageException {
		try {
			return new EntityIteratorImpl<BillingContact>(BillingContact.class, domainKey, "id.targetDomain");
		}catch(Exception ex) {
			throw new StorageException(ex);
		}
	}

	@Override
	public long count() throws StorageException {
		return new CommonDAO<>(BillingContact.class).count();
	}

	@Override
	public long count(String domainKey) throws StorageException {
		return new CommonDAO<>(BillingContact.class).count(domainKey);
	}

	@Override
	public void delete(String domainKey) throws StorageException {
		new CommonDAO<>(BillingContact.class).delete(domainKey);
	}

	@Override
	public void delete(String domainKey, String targetDomain) throws StorageException {
		new CommonDAO<>(BillingContact.class).delete(domainKey, "targetDomain", targetDomain);
	}

	@Override
	public void delete(String domainKey, String targetDomain, String contactId) throws StorageException {
		new CommonDAO<>(BillingContact.class).delete(domainKey, "targetDomain", targetDomain, "contactid", contactId);
	}

	@Override
	public BillingContact get(String domainKey, String targetDomain, String contactId) throws StorageException {
		return new CommonDAO<>(BillingContact.class).find(new BillingContactId(domainKey, targetDomain, contactId));
	}

	@Override
	public Collection<BillingContact> list(String domainKey, int page, int pageSize) throws StorageException {
		return new CommonDAO<BillingContact>(BillingContact.class).list(domainKey, page, pageSize, "id.targetDomain");
	}

	@Override
	public Collection<BillingContact> listNext(String domainKey, String targetDomain, String contactId, int page, int pageSize) throws StorageException {
		return list(domainKey, page, pageSize);
	}

	@Override
	public Collection<BillingContact> search(String domainKey, String query, int pageSize) throws StorageException {
		return new CommonDAO<BillingContact>(BillingContact.class).search(query, domainKey, pageSize);
	}

	@Override
	public void delete() throws StorageException {
		new CommonDAO<>(BillingContact.class).delete();
	}

}
