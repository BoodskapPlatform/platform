package io.boodskap.iot.spi.storage.policy.wrapper.dao;

import java.util.Collection;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.BillingInvoiceDAO;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.model.IBillingInvoice;

public class BillingInvoiceDAOImpl implements  BillingInvoiceDAO<IBillingInvoice> {

	private final BillingInvoiceDAO<IBillingInvoice> impl;
	
	public BillingInvoiceDAOImpl(final BillingInvoiceDAO<IBillingInvoice> impl) {
		this.impl = impl;
	}

	public IBillingInvoice create(String domainKey, String targetDomain, String invoiceId) {
		return impl.create(domainKey, targetDomain, invoiceId);
	}

	public Class<? extends IBillingInvoice> clazz() {
		return impl.clazz();
	}

	public void createOrUpdate(IBillingInvoice e) throws StorageException {
		impl.createOrUpdate(e);
	}

	public EntityIterator<IBillingInvoice> load() throws StorageException {
		return impl.load();
	}

	public EntityIterator<IBillingInvoice> load(String domainKey) throws StorageException {
		return impl.load(domainKey);
	}

	public long count() throws StorageException {
		return impl.count();
	}

	public IBillingInvoice get(String domainKey, String targetDomain, String invoiceId) throws StorageException {
		return impl.get(domainKey, targetDomain, invoiceId);
	}

	public long count(String domainKey) throws StorageException {
		return impl.count(domainKey);
	}

	public void delete(String domainKey, String targetDomain) throws StorageException {
		impl.delete(domainKey, targetDomain);
	}

	public void delete(String domainKey, String targetDomain, String invoiceId) throws StorageException {
		impl.delete(domainKey, targetDomain, invoiceId);
	}

	public void delete(String domainKey) throws StorageException {
		impl.delete(domainKey);
	}

	public Collection<IBillingInvoice> list(String domainKey, int page, int pageSize) throws StorageException {
		return impl.list(domainKey, page, pageSize);
	}

	public Collection<IBillingInvoice> listNext(String domainKey, String targetDomain, String invoiceId, int page, int pageSize) throws StorageException {
		return impl.listNext(domainKey, targetDomain, invoiceId, page, pageSize);
	}

	public Collection<IBillingInvoice> search(String domainKey, String query, int pageSize) throws StorageException {
		return impl.search(domainKey, query, pageSize);
	}

	public void delete() throws StorageException {
		impl.delete();
	}

}
