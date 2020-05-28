package io.boodskap.iot.spi.storage.jpa.dao;

import io.boodskap.iot.BoodskapSystem;
import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.DomainCounterDAO;
import io.boodskap.iot.model.IDomainCounter;
import io.boodskap.iot.model.jpa.DomainCounter;
import io.boodskap.iot.spi.storage.jpa.UOW;
import io.boodskap.iot.spi.storage.jpa.dao.util.CommonDAO;

public class DomainCounterDAOImpl implements DomainCounterDAO<DomainCounter> {
	
	private static final DomainCounterDAO<DomainCounter> dao = new DomainCounterDAOImpl();
	
	protected DomainCounterDAOImpl() {
	}
	
	public static final DomainCounterDAO<DomainCounter> get() {
		return dao;
	}

	@Override
	public Class<? extends DomainCounter> clazz() {
		return DomainCounter.class;
	}

	@Override
	public DomainCounter create(String domainKey) {
		return new DomainCounter(domainKey);
	}

	@Override
	public void init() throws StorageException {
		
		IDomainCounter c = find(BoodskapSystem.license().getDomainKey());
		
		try {
			if(null == c) {
				c = new DomainCounter();
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
	public DomainCounter find(String domainKey) throws StorageException {
		return new CommonDAO<>(DomainCounter.class).find(domainKey);
	}

	@Override
	public void incrementUsers(String domainKey) throws StorageException {
		try {
			IDomainCounter c = find(domainKey);
			UOW.begin();
			c.incrementUsers(domainKey);
			UOW.persist(c);
			UOW.commit();
		}catch(Exception ex) {
			UOW.rollback();
			throw new StorageException(ex);
		}
	}

	@Override
	public void incrementDevices(String domainKey) throws StorageException {
		try {
			IDomainCounter c = find(domainKey);
			UOW.begin();
			c.incrementDevices(domainKey);
			UOW.persist(c);
			UOW.commit();
		}catch(Exception ex) {
			UOW.rollback();
			throw new StorageException(ex);
		}
	}

	@Override
	public void incrementUdp(String domainKey) throws StorageException {
		try {
			IDomainCounter c = find(domainKey);
			UOW.begin();
			c.incrementUdp(domainKey);
			UOW.persist(c);
			UOW.commit();
		}catch(Exception ex) {
			UOW.rollback();
			throw new StorageException(ex);
		}
	}

	@Override
	public void incrementLoRa(String domainKey) throws StorageException {
		try {
			IDomainCounter c = find(domainKey);
			UOW.begin();
			c.incrementLoRa(domainKey);
			UOW.persist(c);
			UOW.commit();
		}catch(Exception ex) {
			UOW.rollback();
			throw new StorageException(ex);
		}
	}

	@Override
	public void incrementMqtt(String domainKey) throws StorageException {
		try {
			IDomainCounter c = find(domainKey);
			UOW.begin();
			c.incrementMqtt(domainKey);
			UOW.persist(c);
			UOW.commit();
		}catch(Exception ex) {
			UOW.rollback();
			throw new StorageException(ex);
		}
	}

	@Override
	public void incrementHttp(String domainKey) throws StorageException {
		try {
			IDomainCounter c = find(domainKey);
			UOW.begin();
			c.incrementHttp(domainKey);
			UOW.persist(c);
			UOW.commit();
		}catch(Exception ex) {
			UOW.rollback();
			throw new StorageException(ex);
		}
	}

	@Override
	public void incrementFcm(String domainKey) throws StorageException {
		try {
			IDomainCounter c = find(domainKey);
			UOW.begin();
			c.incrementFcm(domainKey);
			UOW.persist(c);
			UOW.commit();
		}catch(Exception ex) {
			UOW.rollback();
			throw new StorageException(ex);
		}
	}

	@Override
	public void incrementCoAP(String domainKey) throws StorageException {
		try {
			IDomainCounter c = find(domainKey);
			UOW.begin();
			c.incrementCoAP(domainKey);
			UOW.persist(c);
			UOW.commit();
		}catch(Exception ex) {
			UOW.rollback();
			throw new StorageException(ex);
		}
	}

	@Override
	public void incrementTcp(String domainKey) throws StorageException {
		try {
			IDomainCounter c = find(domainKey);
			UOW.begin();
			c.incrementTcp(domainKey);
			UOW.persist(c);
			UOW.commit();
		}catch(Exception ex) {
			UOW.rollback();
			throw new StorageException(ex);
		}
	}

	@Override
	public void incrementCommands(String domainKey) throws StorageException {
		try {
			IDomainCounter c = find(domainKey);
			UOW.begin();
			c.incrementCommands(domainKey);
			UOW.persist(c);
			UOW.commit();
		}catch(Exception ex) {
			UOW.rollback();
			throw new StorageException(ex);
		}
	}

	@Override
	public void incrementRecords(String domainKey) throws StorageException {
		try {
			IDomainCounter c = find(domainKey);
			UOW.begin();
			c.incrementRecords(domainKey);
			UOW.persist(c);
			UOW.commit();
		}catch(Exception ex) {
			UOW.rollback();
			throw new StorageException(ex);
		}
	}

}
