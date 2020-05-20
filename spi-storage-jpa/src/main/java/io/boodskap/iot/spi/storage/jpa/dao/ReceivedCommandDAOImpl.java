package io.boodskap.iot.spi.storage.jpa.dao;

import java.util.Collection;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.dao.ReceivedCommandDAO;
import io.boodskap.iot.model.INameValuePair;
import io.boodskap.iot.model.jpa.ReceivedCommand;
import io.boodskap.iot.model.jpa.ReceivedCommandId;
import io.boodskap.iot.model.jpa.ReceivedCommandNVP;
import io.boodskap.iot.spi.storage.jpa.dao.util.CommonDAO;
import io.boodskap.iot.spi.storage.jpa.dao.util.EntityIteratorImpl;

public class ReceivedCommandDAOImpl implements ReceivedCommandDAO<ReceivedCommand> {
	
	private static final ReceivedCommandDAO<ReceivedCommand> instance = new ReceivedCommandDAOImpl();
	
	private ReceivedCommandDAOImpl() {
	}

	public static final ReceivedCommandDAO<ReceivedCommand> get(){
		return instance;
	}

	@Override
	public Class<ReceivedCommand> clazz() {
		return ReceivedCommand.class;
	}

	@Override
	public Class<? extends INameValuePair> nvPairClazz() {
		return ReceivedCommandNVP.class;
	}

	@Override
	public ReceivedCommand create(String domainKey, String requestId) {
		return new ReceivedCommand(new ReceivedCommandId(domainKey, requestId));
	}

	@Override
	public void createOrUpdate(ReceivedCommand e) throws StorageException {
	}

	@Override
	public EntityIterator<ReceivedCommand> load() throws StorageException {
		return new EntityIteratorImpl<>(ReceivedCommand.class, "id.domainKey");
	}

	@Override
	public EntityIterator<ReceivedCommand> load(String domainKey) throws StorageException {
		return new EntityIteratorImpl<>(ReceivedCommand.class, domainKey, "id.requestId");
	}

	@Override
	public long count() throws StorageException {
		return new CommonDAO<>(ReceivedCommand.class).count();
	}

	@Override
	public long count(String domainKey) throws StorageException {
		return new CommonDAO<>(ReceivedCommand.class).count(domainKey);
	}

	@Override
	public ReceivedCommand get(String domainKey, String requestId) throws StorageException {
		return new CommonDAO<>(ReceivedCommand.class).find(new ReceivedCommandId(domainKey, requestId));
	}

	@Override
	public void delete(String domainKey) throws StorageException {
		new CommonDAO<>(ReceivedCommand.class).delete(domainKey);
	}

	@Override
	public void delete(String domainKey, String requestId) throws StorageException {
		new CommonDAO<>(ReceivedCommand.class).delete(domainKey, "requestId", requestId);
	}

	@Override
	public Collection<ReceivedCommand> list(String domainKey, int page, int pageSize) throws StorageException {
		return new CommonDAO<>(ReceivedCommand.class).list(domainKey, page, pageSize, "queuedStamp desc");
	}

	@Override
	public Collection<ReceivedCommand> listNext(String domainKey, String requestId, int page, int pageSize) throws StorageException {
		return list(domainKey, page, pageSize);
	}

	@Override
	public void delete() throws StorageException {
		new CommonDAO<>(ReceivedCommand.class).delete();
	}

}
