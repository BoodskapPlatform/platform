package io.boodskap.iot.spi.storage.jpa;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.MessageDAO;
import io.boodskap.iot.dao.MessageSpecDAO;
import io.boodskap.iot.dao.RecordDAO;
import io.boodskap.iot.dao.RecordSpecDAO;
import io.boodskap.iot.model.jpa.Message;
import io.boodskap.iot.model.jpa.MessageSpecification;
import io.boodskap.iot.model.jpa.Record;
import io.boodskap.iot.model.jpa.RecordSpecification;
import io.boodskap.iot.spi.storage.IDynamicStorage;
import io.boodskap.iot.spi.storage.jpa.dao.MessageDAOImpl;
import io.boodskap.iot.spi.storage.jpa.dao.MessageSpecDAOImpl;
import io.boodskap.iot.spi.storage.jpa.dao.RecordDAOImpl;
import io.boodskap.iot.spi.storage.jpa.dao.RecordSpecDAOImpl;

public class JPADynamicStorage implements IDynamicStorage {

	protected JPADynamicStorage() {
	}

	@Override
	public boolean isPaginationSupported() {
		return true;
	}

	@Override
	public boolean isSearchSupported() {
		return true;
	}

	@Override
	public String getVendorInfo() {
		return "JPA (Java Persistence Architecture)";
	}

	@Override
	public String getVersion() {
		return "2.1.1";
	}

	@SuppressWarnings("unchecked")
	@Override
	public MessageSpecDAO<MessageSpecification> getMessageSpecDAO() {
		return MessageSpecDAOImpl.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public RecordSpecDAO<RecordSpecification> getRecordSpecDAO() {
		return RecordSpecDAOImpl.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public MessageDAO<Message> getMessageDAO() throws StorageException {
		return MessageDAOImpl.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public RecordDAO<Record> getRecordDAO() throws StorageException {
		return RecordDAOImpl.get();
	}

}
