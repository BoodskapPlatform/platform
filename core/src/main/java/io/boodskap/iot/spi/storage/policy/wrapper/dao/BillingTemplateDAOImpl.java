package io.boodskap.iot.spi.storage.policy.wrapper.dao;

import java.util.Collection;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.BillingTemplateDAO;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.model.IBillingTemplate;

public class BillingTemplateDAOImpl implements BillingTemplateDAO<IBillingTemplate> {

	private final BillingTemplateDAO<IBillingTemplate> impl;

	public BillingTemplateDAOImpl(BillingTemplateDAO<IBillingTemplate> impl) {
		this.impl = impl;
	}

	public Class<? extends IBillingTemplate> clazz() {
		return impl.clazz();
	}

	public IBillingTemplate create(String templatename, String itemname) {
		return impl.create(templatename, itemname);
	}

	public void createOrUpdate(IBillingTemplate e) throws StorageException {
		impl.createOrUpdate(e);
	}

	public EntityIterator<IBillingTemplate> load() throws StorageException {
		return impl.load();
	}

	public EntityIterator<IBillingTemplate> load(String templatename) throws StorageException {
		return impl.load(templatename);
	}

	public long count() throws StorageException {
		return impl.count();
	}

	public long count(String templatename) throws StorageException {
		return impl.count(templatename);
	}

	public IBillingTemplate get(String templateName, String itemname) throws StorageException {
		return impl.get(templateName, itemname);
	}

	public void delete() throws StorageException {
		impl.delete();
	}

	public void delete(String templatename) throws StorageException {
		impl.delete(templatename);
	}

	public void delete(String templateName, String itemname) throws StorageException {
		impl.delete(templateName, itemname);
	}

	public Collection<IBillingTemplate> list(int page, int pageSize) throws StorageException {
		return impl.list(page, pageSize);
	}

	public Collection<IBillingTemplate> listNext(String templateName, String itemName, int page, int pageSize)
			throws StorageException {
		return impl.listNext(templateName, itemName, page, pageSize);
	}

	public Collection<IBillingTemplate> search(String query, int pageSize) throws StorageException {
		return impl.search(query, pageSize);
	}

}
