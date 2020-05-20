package io.boodskap.iot.spi.storage.policy.wrapper.dao;

import java.util.Collection;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.BillingContactDAO;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.model.IBillingContact;

public class BillingContactDAOImpl implements BillingContactDAO<IBillingContact> {

	private final BillingContactDAO<IBillingContact> impl;

	public BillingContactDAOImpl(final BillingContactDAO<IBillingContact> impl) {
		this.impl = impl;
	}

	public IBillingContact create(String domainKey, String targetDomain, String contactId) {
		return impl.create(domainKey, targetDomain, contactId);
	}

	public Class<? extends IBillingContact> clazz() {
		return impl.clazz();
	}

	public void createOrUpdate(IBillingContact e) throws StorageException {
		impl.createOrUpdate(e);
	}

	public EntityIterator<IBillingContact> load() throws StorageException {
		return impl.load();
	}

	public EntityIterator<IBillingContact> load(String domainKey) throws StorageException {
		return impl.load(domainKey);
	}

	public long count() throws StorageException {
		return impl.count();
	}

	public long count(String domainKey) throws StorageException {
		return impl.count(domainKey);
	}

	public void delete(String domainKey, String contactId) throws StorageException {
		impl.delete(domainKey, contactId);
	}

	public void delete(String domainKey) throws StorageException {
		impl.delete(domainKey);
	}

	public Collection<IBillingContact> list(String domainKey, int page, int pageSize) throws StorageException {
		return impl.list(domainKey, page, pageSize);
	}

	public Collection<IBillingContact> search(String domainKey, String query, int pageSize) throws StorageException {
		return impl.search(domainKey, query, pageSize);
	}

	public IBillingContact get(String domainKey, String targetDomain, String contactId) throws StorageException {
		return impl.get(domainKey, targetDomain, contactId);
	}

	public void delete(String domainKey, String targetDomain, String contactId) throws StorageException {
		impl.delete(domainKey, targetDomain, contactId);
	}

	public Collection<IBillingContact> listNext(String domainKey, String targetDomain, String contactId, int page, int pageSize) throws StorageException {
		return impl.listNext(domainKey, targetDomain, contactId, page, pageSize);
	}

	public void delete() throws StorageException {
		impl.delete();
	}

}
