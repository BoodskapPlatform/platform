package io.boodskap.iot.spi.storage.policy.wrapper.dao;

import java.util.Collection;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.BillingScheduleDAO;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.model.IBillingSchedule;

public class BillingScheduleDAOImpl implements BillingScheduleDAO<IBillingSchedule> {
	
	private final BillingScheduleDAO<IBillingSchedule> impl;
	
	public BillingScheduleDAOImpl(final BillingScheduleDAO<IBillingSchedule> impl) {
		this.impl = impl;
	}

	public IBillingSchedule create(String domainKey, String targetDomain, String scheduleId) {
		return impl.create(domainKey, targetDomain, scheduleId);
	}

	public Class<? extends IBillingSchedule> clazz() {
		return impl.clazz();
	}

	public void createOrUpdate(IBillingSchedule e) throws StorageException {
		impl.createOrUpdate(e);
	}

	public EntityIterator<IBillingSchedule> load() throws StorageException {
		return impl.load();
	}

	public EntityIterator<IBillingSchedule> load(String domainKey) throws StorageException {
		return impl.load(domainKey);
	}

	public long count() throws StorageException {
		return impl.count();
	}

	public IBillingSchedule get(String domainKey, String targetDomain, String scheduleId) throws StorageException {
		return impl.get(domainKey, targetDomain, scheduleId);
	}

	public long count(String domainKey) throws StorageException {
		return impl.count(domainKey);
	}

	public void delete(String domainKey) throws StorageException {
		impl.delete(domainKey);
	}

	public void delete(String domainKey, String targetDomain) throws StorageException {
		impl.delete(domainKey, targetDomain);
	}

	public void delete(String domainKey, String targetDomain, String scheduleId) throws StorageException {
		impl.delete(domainKey, targetDomain, scheduleId);
	}

	public Collection<IBillingSchedule> list(String domainKey, int page, int pageSize) throws StorageException {
		return impl.list(domainKey, page, pageSize);
	}

	public Collection<IBillingSchedule> listNext(String domainKey, String targetDomain, String scheduleId, int page, int pageSize) throws StorageException {
		return impl.listNext(domainKey, targetDomain, scheduleId, page, pageSize);
	}

	public Collection<IBillingSchedule> search(String domainKey, String query, int pageSize) throws StorageException {
		return impl.search(domainKey, query, pageSize);
	}

	public void delete() throws StorageException {
		impl.delete();
	}

}
