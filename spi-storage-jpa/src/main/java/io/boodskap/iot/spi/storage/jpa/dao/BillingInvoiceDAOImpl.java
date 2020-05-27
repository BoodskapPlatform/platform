package io.boodskap.iot.spi.storage.jpa.dao;

import java.util.Collection;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.BillingInvoiceDAO;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.model.IBillingInvoice;
import io.boodskap.iot.model.jpa.BillingInvoice;
import io.boodskap.iot.model.jpa.BillingInvoiceId;
import io.boodskap.iot.spi.storage.jpa.UOW;
import io.boodskap.iot.spi.storage.jpa.dao.util.CommonDAO;
import io.boodskap.iot.spi.storage.jpa.dao.util.EntityIteratorImpl;

public class BillingInvoiceDAOImpl implements BillingInvoiceDAO<BillingInvoice> {
	
	private static final BillingInvoiceDAO<BillingInvoice> instance = new BillingInvoiceDAOImpl();
	
	protected BillingInvoiceDAOImpl() {
	}
	
	public static final BillingInvoiceDAO<BillingInvoice> get(){
		return instance;
	}

	@Override
	public BillingInvoice create(String domainKey, String targetDomain, String invoiceId) {
		return new BillingInvoice(new BillingInvoiceId(domainKey, targetDomain, invoiceId));
	}

	@Override
	public Class<? extends BillingInvoice> clazz() {
		return BillingInvoice.class;
	}

	@Override
	public void createOrUpdate(BillingInvoice e) throws StorageException {
		
		try {
			
			final IBillingInvoice oe = get(e.getDomainKey(), e.getTargetDomain(), e.getInvoiceId());
			IBillingInvoice ne;
			
			if(null == oe) {
				ne = new BillingInvoice(new BillingInvoiceId(e.getDomainKey(), e.getTargetDomain(), e.getInvoiceId()));
			}else {
				ne = oe;
			}
			
			UOW.begin();
			
			ne.setEnddate(e.getEnddate());
			
			
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
	public EntityIterator<BillingInvoice> load() throws StorageException {
		try {
			return new EntityIteratorImpl<BillingInvoice>(BillingInvoice.class, "id.domainKey");
		}catch(Exception ex) {
			throw new StorageException(ex);
		}
	}

	@Override
	public EntityIterator<BillingInvoice> load(String domainKey) throws StorageException {
		try {
			return new EntityIteratorImpl<BillingInvoice>(BillingInvoice.class, domainKey, "id.targetDomain");
		}catch(Exception ex) {
			throw new StorageException(ex);
		}
	}

	@Override
	public long count() throws StorageException {
		return new CommonDAO<>(BillingInvoice.class).count();
	}

	@Override
	public long count(String domainKey) throws StorageException {
		return new CommonDAO<>(BillingInvoice.class).count(domainKey);
	}

	@Override
	public void delete(String domainKey) throws StorageException {
		new CommonDAO<>(BillingInvoice.class).delete(domainKey);
	}

	@Override
	public void delete(String domainKey, String targetDomain) throws StorageException {
		new CommonDAO<>(BillingInvoice.class).delete(domainKey, "targetDomain", targetDomain);
	}

	@Override
	public void delete(String domainKey, String targetDomain, String invoiceId) throws StorageException {
		new CommonDAO<>(BillingInvoice.class).delete(domainKey, "targetDomain", targetDomain, "contactid", invoiceId);
	}

	@Override
	public BillingInvoice get(String domainKey, String targetDomain, String invoiceId) throws StorageException {
		return new CommonDAO<>(BillingInvoice.class).find(new BillingInvoiceId(domainKey, targetDomain, invoiceId));
	}

	@Override
	public Collection<BillingInvoice> list(String domainKey, int page, int pageSize) throws StorageException {
		return new CommonDAO<BillingInvoice>(BillingInvoice.class).list(domainKey, page, pageSize, "id.targetDomain");
	}

	@Override
	public Collection<BillingInvoice> listNext(String domainKey, String targetDomain, String invoiceId, int page, int pageSize) throws StorageException {
		return list(domainKey, page, pageSize);
	}

	@Override
	public Collection<BillingInvoice> search(String domainKey, String query, int pageSize) throws StorageException {
		return new CommonDAO<BillingInvoice>(BillingInvoice.class).search(query, domainKey, pageSize);
	}

	@Override
	public void delete() throws StorageException {
		new CommonDAO<>(BillingInvoice.class).delete();
	}

}
