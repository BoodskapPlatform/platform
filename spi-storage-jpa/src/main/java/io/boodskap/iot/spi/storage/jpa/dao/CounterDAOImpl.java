package io.boodskap.iot.spi.storage.jpa.dao;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.CounterDAO;
import io.boodskap.iot.model.ICounter;
import io.boodskap.iot.model.jpa.Counter;
import io.boodskap.iot.spi.storage.jpa.UOW;
import io.boodskap.iot.spi.storage.jpa.dao.util.CommonDAO;

public class CounterDAOImpl implements CounterDAO<Counter> {
	
	private static final CounterDAO<Counter> dao = new CounterDAOImpl();
	
	protected CounterDAOImpl() {
	}
	
	public static final CounterDAO<Counter> get() {
		return dao;
	}

	@Override
	public Class<? extends Counter> clazz() {
		return Counter.class;
	}

	@Override
	public Counter create() {
		return new Counter();
	}

	@Override
	public void init() throws StorageException {
		
		ICounter c = find();
		
		try {
			if(null == c) {
				c = new Counter();
				UOW.begin();
				UOW.persist(c);
				UOW.commit();
			}
		}catch(Exception ex) {
			UOW.rollback();
			throw new StorageException(ex);
		}
	}

	@Override
	public Counter find() throws StorageException {
		return new CommonDAO<>(Counter.class).find(0);
	}

	@Override
	public void incrementDomains() throws StorageException {
		try {
			ICounter c = find();
			UOW.begin();
			c.incrementDomains();
			UOW.persist(c);
			UOW.commit();
		}catch(Exception ex) {
			UOW.rollback();
			throw new StorageException(ex);
		}
	}

	@Override
	public void incrementUsers() throws StorageException {
		try {
			ICounter c = find();
			UOW.begin();
			c.incrementUsers();
			UOW.persist(c);
			UOW.commit();
		}catch(Exception ex) {
			UOW.rollback();
			throw new StorageException(ex);
		}
	}

	@Override
	public void incrementDevices() throws StorageException {
		try {
			ICounter c = find();
			UOW.begin();
			c.incrementDevices();
			UOW.persist(c);
			UOW.commit();
		}catch(Exception ex) {
			UOW.rollback();
			throw new StorageException(ex);
		}
	}

	@Override
	public void incrementUdp() throws StorageException {
		try {
			ICounter c = find();
			UOW.begin();
			c.incrementUdp();
			UOW.persist(c);
			UOW.commit();
		}catch(Exception ex) {
			UOW.rollback();
			throw new StorageException(ex);
		}
	}

	@Override
	public void incrementLoRa() throws StorageException {
		try {
			ICounter c = find();
			UOW.begin();
			c.incrementLoRa();
			UOW.persist(c);
			UOW.commit();
		}catch(Exception ex) {
			UOW.rollback();
			throw new StorageException(ex);
		}
	}

	@Override
	public void incrementMqtt() throws StorageException {
		try {
			ICounter c = find();
			UOW.begin();
			c.incrementMqtt();
			UOW.persist(c);
			UOW.commit();
		}catch(Exception ex) {
			UOW.rollback();
			throw new StorageException(ex);
		}
	}

	@Override
	public void incrementHttp() throws StorageException {
		try {
			ICounter c = find();
			UOW.begin();
			c.incrementHttp();
			UOW.persist(c);
			UOW.commit();
		}catch(Exception ex) {
			UOW.rollback();
			throw new StorageException(ex);
		}
	}

	@Override
	public void incrementFcm() throws StorageException {
		try {
			ICounter c = find();
			UOW.begin();
			c.incrementFcm();
			UOW.persist(c);
			UOW.commit();
		}catch(Exception ex) {
			UOW.rollback();
			throw new StorageException(ex);
		}
	}

	@Override
	public void incrementCoAP() throws StorageException {
		try {
			ICounter c = find();
			UOW.begin();
			c.incrementCoAP();
			UOW.persist(c);
			UOW.commit();
		}catch(Exception ex) {
			UOW.rollback();
			throw new StorageException(ex);
		}
	}

	@Override
	public void incrementTcp() throws StorageException {
		try {
			ICounter c = find();
			UOW.begin();
			c.incrementTcp();
			UOW.persist(c);
			UOW.commit();
		}catch(Exception ex) {
			UOW.rollback();
			throw new StorageException(ex);
		}
	}

	@Override
	public void incrementCommands() throws StorageException {
		try {
			ICounter c = find();
			UOW.begin();
			c.incrementCommands();
			UOW.persist(c);
			UOW.commit();
		}catch(Exception ex) {
			UOW.rollback();
			throw new StorageException(ex);
		}
	}

	@Override
	public void incrementRecords() throws StorageException {
		try {
			ICounter c = find();
			UOW.begin();
			c.incrementRecords();
			UOW.persist(c);
			UOW.commit();
		}catch(Exception ex) {
			UOW.rollback();
			throw new StorageException(ex);
		}
	}

}
