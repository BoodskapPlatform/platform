package io.boodskap.iot.spi.storage.jpa.dao;

import java.util.Date;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.dao.TwilioGatewayDAO;
import io.boodskap.iot.model.ITwilioGateway;
import io.boodskap.iot.model.jpa.TwilioGateway;
import io.boodskap.iot.spi.storage.jpa.UOW;
import io.boodskap.iot.spi.storage.jpa.dao.util.CommonDAO;
import io.boodskap.iot.spi.storage.jpa.dao.util.EntityIteratorImpl;

public class TwilioGatewayDAOImpl implements TwilioGatewayDAO<TwilioGateway> {
	
	private static final TwilioGatewayDAO<TwilioGateway> dao =  new TwilioGatewayDAOImpl();
	
	protected TwilioGatewayDAOImpl() {
	}
	
	public static final TwilioGatewayDAO<TwilioGateway> get() {
		return dao;
	}

	@Override
	public TwilioGateway create(String domainKey) {
		return new TwilioGateway(domainKey);
	}

	@Override
	public Class<? extends TwilioGateway> clazz() {
		return TwilioGateway.class;
	}

	@Override
	public void createOrUpdate(TwilioGateway e) throws StorageException {
		
		try {
			
			final ITwilioGateway oe = get(e.getDomainKey());
			ITwilioGateway ne;
			
			if(null == oe) {
				ne = new TwilioGateway(e.getDomainKey());
				ne.setCreatedStamp(new Date());
			}else {
				ne = oe;
			}
			
			UOW.begin();
			
			ne.setAuthtoken(e.getAuthtoken());
			ne.setDebug(e.isDebug());
			ne.setPrimaryPhone(e.getPrimaryPhone());
			ne.setSid(e.getSid());
			ne.setToken(e.getToken());
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
	public EntityIterator<TwilioGateway> load() throws StorageException {
		return new EntityIteratorImpl<>(TwilioGateway.class, "domainKey");
	}

	@Override
	public EntityIterator<TwilioGateway> load(String domainKey) throws StorageException {
		return new EntityIteratorImpl<>("domainKey", domainKey, "domainKey", TwilioGateway.class);
	}

	@Override
	public long count() throws StorageException {
		return new CommonDAO<>(TwilioGateway.class).count();
	}

	@Override
	public long count(String domainKey) throws StorageException {
		return new CommonDAO<>(TwilioGateway.class).count("domainKey", domainKey);
	}

	@Override
	public void delete(String domainKey) throws StorageException {
		new CommonDAO<>(TwilioGateway.class).delete("domainKey", domainKey);
	}

	@Override
	public TwilioGateway get(String domainKey) throws StorageException {
		return new CommonDAO<>(TwilioGateway.class).find(domainKey);
	}

	@Override
	public void delete() throws StorageException {
		new CommonDAO<>(TwilioGateway.class).delete();
	}

}
