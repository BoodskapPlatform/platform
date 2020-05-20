package io.boodskap.iot.spi.storage.policy.wrapper.dao;

import java.util.Collection;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.dao.ReceivedCommandDAO;
import io.boodskap.iot.model.INameValuePair;
import io.boodskap.iot.model.IReceivedCommand;

public class ReceivedCommandDAOImpl implements ReceivedCommandDAO<IReceivedCommand>{

	private final ReceivedCommandDAO<IReceivedCommand> impl;
	
	public ReceivedCommandDAOImpl(ReceivedCommandDAO<IReceivedCommand> impl) {
		this.impl = impl;
	}

	public Class<? extends IReceivedCommand> clazz() {
		return impl.clazz();
	}

	public Class<? extends INameValuePair> nvPairClazz() {
		return impl.nvPairClazz();
	}

	public void createOrUpdate(IReceivedCommand e) throws StorageException {
		impl.createOrUpdate(e);
	}

	public EntityIterator<IReceivedCommand> load() throws StorageException {
		return impl.load();
	}

	public EntityIterator<IReceivedCommand> load(String domainKey) throws StorageException {
		return impl.load(domainKey);
	}

	public long count() throws StorageException {
		return impl.count();
	}

	public long count(String domainKey) throws StorageException {
		return impl.count(domainKey);
	}

	public IReceivedCommand create(String domainKey, String requestId) {
		return impl.create(domainKey, requestId);
	}

	public void delete(String domainKey) throws StorageException {
		impl.delete(domainKey);
	}

	public IReceivedCommand get(String domainKey, String requestId) throws StorageException {
		return impl.get(domainKey, requestId);
	}

	public void delete(String domainKey, String requestId) throws StorageException {
		impl.delete(domainKey, requestId);
	}

	public Collection<IReceivedCommand> list(String domainKey, int page, int pageSize) throws StorageException {
		return impl.list(domainKey, page, pageSize);
	}

	public Collection<IReceivedCommand> listNext(String domainKey, String requestId, int page, int pageSize)
			throws StorageException {
		return impl.listNext(domainKey, requestId, page, pageSize);
	}

	public void delete() throws StorageException {
		impl.delete();
	}

}
