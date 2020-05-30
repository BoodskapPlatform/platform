package io.boodskap.iot.model;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.MessageCounterDAO;

@JsonSerialize(as=ICounter.class)
public interface IMessageCounter extends IStorageObject {
	
	public static MessageCounterDAO<IMessageCounter> dao() {
		return MessageCounterDAO.get();
	}
	
	public default void save() throws StorageException {
		dao().increment();
	}

	@Override
	public default void copy(Object other) {
		
		IMessageCounter o = (IMessageCounter) other;

		setId(o.getId());
		setCount(o.getCount());
		
		IStorageObject.super.copy(other);
	}
	
	public Date getId();
	
	public void setId(Date id);
	
	public long getCount();
	
	public void setCount(long count);
}
