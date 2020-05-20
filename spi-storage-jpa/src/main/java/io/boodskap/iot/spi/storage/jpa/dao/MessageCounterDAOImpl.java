package io.boodskap.iot.spi.storage.jpa.dao;

import java.util.Collection;
import java.util.Date;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.MessageCounterDAO;
import io.boodskap.iot.model.jpa.MessageCounter;

public class MessageCounterDAOImpl implements MessageCounterDAO<MessageCounter> {
	
	private static final MessageCounterDAO<MessageCounter> instance = new MessageCounterDAOImpl();

	private MessageCounterDAOImpl() {
	}

	public static final MessageCounterDAO<MessageCounter> get(){
		return instance;
	}

	@Override
	public Class<? extends MessageCounter> clazz() {
		return MessageCounter.class;
	}

	@Override
	public void increment() throws StorageException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public long countYearly() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long countMonthly() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long countDaily() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long countHourly() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long countMinutely() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long countSecondly() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Collection<MessageCounter> list(ListType type, int page, int pageSize) throws StorageException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<MessageCounter> listNext(ListType type, Date id, int page, int pageSize) throws StorageException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<MessageCounter> search(ListType type, String query, int pageSize) throws StorageException {
		// TODO Auto-generated method stub
		return null;
	}

}
