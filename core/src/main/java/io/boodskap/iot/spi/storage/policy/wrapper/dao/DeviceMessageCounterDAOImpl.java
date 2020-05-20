package io.boodskap.iot.spi.storage.policy.wrapper.dao;

import java.util.Collection;
import java.util.Date;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.DeviceMessageCounterDAO;
import io.boodskap.iot.model.IDeviceMessageCounter;

public class DeviceMessageCounterDAOImpl implements DeviceMessageCounterDAO<IDeviceMessageCounter>{

	private final DeviceMessageCounterDAO<IDeviceMessageCounter> impl;
	
	public DeviceMessageCounterDAOImpl(final DeviceMessageCounterDAO<IDeviceMessageCounter> impl) {
		this.impl = impl;
	}

	public Class<? extends IDeviceMessageCounter> clazz() {
		return impl.clazz();
	}

	public IDeviceMessageCounter create(String domainKey, String deviceId, String messageType, String messageId) throws StorageException {
		return impl.create(domainKey, deviceId, messageType, messageId);
	}

	public void createOrUpdate(IDeviceMessageCounter counter) throws StorageException {
		impl.createOrUpdate(counter);
	}

	public long count() {
		return impl.count();
	}

	public long count(String domainKey) {
		return impl.count(domainKey);
	}

	public long count(String domainKey, String deviceId) {
		return impl.count(domainKey, deviceId);
	}

	public long count(String domainKey, String deviceId, String messageType) {
		return impl.count(domainKey, deviceId, messageType);
	}

	public long count(Date from, Date to) {
		return impl.count(from, to);
	}

	public long count(String domainKey, Date from, Date to) {
		return impl.count(domainKey, from, to);
	}

	public long count(String domainKey, String deviceId, Date from, Date to) {
		return impl.count(domainKey, deviceId, from, to);
	}

	public long count(String domainKey, String deviceId, String messageType, Date from, Date to) {
		return impl.count(domainKey, deviceId, messageType, from, to);
	}

	public long countByQuery(String query) throws StorageException {
		return impl.countByQuery(query);
	}

	public long countByQuery(String domainKey, String query) throws StorageException {
		return impl.countByQuery(domainKey, query);
	}

	public Collection<IDeviceMessageCounter> search(String query, int pageSize) throws StorageException {
		return impl.search(query, pageSize);
	}

	public Collection<IDeviceMessageCounter> search(String domainKey, String query, int pageSize) throws StorageException {
		return impl.search(domainKey, query, pageSize);
	}

	public Collection<IDeviceMessageCounter> list(String domainKey, int page, int pageSize) throws StorageException {
		return impl.list(domainKey, page, pageSize);
	}

	public Collection<IDeviceMessageCounter> listNext(String domainKey, String deviceId, String messageType, Date day, int page, int pageSize) throws StorageException {
		return impl.listNext(domainKey, deviceId, messageType, day, page, pageSize);
	}

}
