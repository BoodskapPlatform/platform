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

	public Date getId();
	
	public void setId(Date id);
	
	public long getCount();
	
	public void setCount(long count);
	
	public default void save() throws StorageException {
		dao().increment();
	}
}
