package io.boodskap.iot.spi.storage.jpa.dao;

import java.util.Collection;
import java.util.Date;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.AlexaDAO;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.model.IAlexa;
import io.boodskap.iot.model.jpa.Alexa;
import io.boodskap.iot.model.jpa.AlexaId;
import io.boodskap.iot.spi.storage.jpa.UOW;
import io.boodskap.iot.spi.storage.jpa.dao.util.CommonDAO;
import io.boodskap.iot.spi.storage.jpa.dao.util.EntityIteratorImpl;

public class AlexaDAOImpl implements AlexaDAO<Alexa> {
	
	private static final AlexaDAO<Alexa> instance = new AlexaDAOImpl();

	protected AlexaDAOImpl() {
	}
	
	public static final AlexaDAO<Alexa> get() {
		return instance;
	}

	@Override
	public Alexa create(String domainKey, String alexaId) {
		return new Alexa(new AlexaId(domainKey, alexaId));
	}

	@Override
	public Class<? extends Alexa> clazz() {
		return Alexa.class;
	}

	@Override
	public void createOrUpdate(Alexa e) throws StorageException {
		
		try {
			
			final IAlexa oe = get(e.getDomainKey(), e.getAlexaId());
			IAlexa ne;
			
			if(null == oe) {
				ne = new Alexa(new AlexaId(e.getDomainKey(), e.getAlexaId()));
				ne.setRegisteredStamp(new Date());
			}else {
				ne = oe;
			}
			
			UOW.begin();
			
			ne.setCreatedBy(e.getCreatedBy());
			ne.setErrorResponse(e.getErrorResponse());
			ne.setIntentName(e.getIntentName());
			ne.setRuleName(e.getRuleName());
			ne.setRuleType(ne.getRuleType());
			ne.setUpdatedStamp(new Date());
			
			if(null == oe) {
				UOW.persist(ne);
			}
			
			UOW.commit();
			
		}catch(Exception ex) {
			UOW.rollback();
			throw new StorageException(ex);
		}
		
	}

	@Override
	public Alexa get(String domainKey, String alexaId) throws StorageException {
		return new CommonDAO<>(Alexa.class).find(new AlexaId(domainKey, alexaId));
	}

	@Override
	public EntityIterator<Alexa> load() throws StorageException {
		try {
			return new EntityIteratorImpl<>(Alexa.class, "ruleName");
		}catch(Exception ex) {
			throw new StorageException(ex);
		}
	}

	@Override
	public EntityIterator<Alexa> load(String domainKey) throws StorageException {
		try {
			return new EntityIteratorImpl<>(Alexa.class, domainKey, "ruleName");
		}catch(Exception ex) {
			throw new StorageException(ex);
		}
	}

	@Override
	public long count() throws StorageException {
		return new CommonDAO<>(Alexa.class).count();
	}

	@Override
	public long count(String domainKey) throws StorageException {
		return new CommonDAO<>(Alexa.class).count(domainKey);
	}

	@Override
	public void delete(String domainKey) throws StorageException {
		new CommonDAO<>(Alexa.class).delete(domainKey);
	}

	@Override
	public void delete(String domainKey, String alexaId) throws StorageException {
		new CommonDAO<>(Alexa.class).delete(domainKey, "alexaId", alexaId);
	}

	@Override
	public Collection<Alexa> list(String domainKey, int page, int pageSize) throws StorageException {
		return new CommonDAO<>(Alexa.class).list(domainKey, page, pageSize, "ruleName");
	}

	@Override
	public Collection<Alexa> listNext(String domainKey, String assetId, int page, int pageSize) throws StorageException {
		return list(domainKey, page, pageSize);
	}

	@Override
	public Collection<Alexa> search(String domainKey, String query, int pageSize) throws StorageException {
		return new CommonDAO<>(Alexa.class).search(query, domainKey, pageSize);
	}

	@Override
	public void delete() throws StorageException {
		new CommonDAO<>(Alexa.class).delete();
	}

}
