package io.boodskap.iot.model;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.DeviceMessageCounterDAO;

@JsonSerialize(as=IDeviceMessageCounter.class)
public interface IDeviceMessageCounter extends IDomainObject {
	
	public static DeviceMessageCounterDAO<IDeviceMessageCounter> dao(){
		return DeviceMessageCounterDAO.get();
	}
	
	public static void increment(String domainKey, String deviceId, String messageType, Date day) throws StorageException{
		IDeviceMessageCounter e = dao().get(domainKey, deviceId, messageType, day);
		if(null == e) {
			dao().create(domainKey, deviceId, messageType, day);
		}
		e.setCount( e.getCount() + 1);
		e.save();
	}
	
	public default long count() {
		return dao().count(getDomainKey(), getDeviceId());
	}

	public default long count(String messageType) {
		return dao().count(getDomainKey(), getDeviceId(), messageType);
	}

	public default long count(Date from, Date to) {
		return dao().count(getDomainKey(), getDeviceId(), from, to);
	}

	public default long count(String messageType, Date from, Date to) {
		return dao().count(getDomainKey(), getDeviceId(), messageType, from, to);
	}
	
	public default void save() {
		dao().createOrUpdate(this);
	}

	public IDeviceMessageCounter create(String domainKey, String deviceId, String messageType, Date day) throws StorageException;
	
	public String getDeviceId();
	
	public void setDeviceId(String deviceId);

	public String getMessageType();
	
	public void setMessageType(String messageType);
	
	public Date getDay();
	
	public void setDay(Date day);
	
	public long getCount();
	
	public void setCount(long count);
}
