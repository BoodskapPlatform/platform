package io.boodskap.iot.spi.storage.policy.wrapper.dao;

import java.util.Collection;
import java.util.Date;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.MessageCounterDAO;
import io.boodskap.iot.model.IMessageCounter;

public class MessageCounterDAOImpl implements MessageCounterDAO<IMessageCounter> {

	private final MessageCounterDAO<IMessageCounter> impl;
	
	public MessageCounterDAOImpl(final MessageCounterDAO<IMessageCounter> impl) {
		this.impl = impl;
	}

	public Class<? extends IMessageCounter> clazz() {
		return impl.clazz();
	}

	public void increment() throws StorageException {
		impl.increment();
	}

	public long countYearly() {
		return impl.countYearly();
	}

	public long countMonthly() {
		return impl.countMonthly();
	}

	public long countDaily() {
		return impl.countDaily();
	}

	public long countHourly() {
		return impl.countHourly();
	}

	public long countMinutely() {
		return impl.countMinutely();
	}

	public long countSecondly() {
		return impl.countSecondly();
	}

	public Collection<IMessageCounter> list(ListType type, int page, int pageSize) throws StorageException {
		return impl.list(type, page, pageSize);
	}

	public Collection<IMessageCounter> listNext(ListType type, Date id, int page, int pageSize)
			throws StorageException {
		return impl.listNext(type, id, page, pageSize);
	}

	public Collection<IMessageCounter> search(ListType type, String query, int pageSize) throws StorageException {
		return impl.search(type, query, pageSize);
	}

}
