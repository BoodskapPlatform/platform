package io.boodskap.iot.spi.storage.jpa.dao;

import java.util.Date;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.dao.FCMGatewayDAO;
import io.boodskap.iot.model.IFCMGateway;
import io.boodskap.iot.model.jpa.FCMGateway;
import io.boodskap.iot.spi.storage.jpa.UOW;
import io.boodskap.iot.spi.storage.jpa.dao.util.CommonDAO;
import io.boodskap.iot.spi.storage.jpa.dao.util.EntityIteratorImpl;

public class FCMGatewayDAOImpl implements FCMGatewayDAO<FCMGateway> {
	
	private static final FCMGatewayDAO<FCMGateway> dao = new FCMGatewayDAOImpl();
	
	protected FCMGatewayDAOImpl() {
	}
	
	public static final FCMGatewayDAO<FCMGateway> get() {
		return dao;
	}

	@Override
	public FCMGateway create(String domainKey) {
		return new FCMGateway(domainKey);
	}

	@Override
	public Class<? extends FCMGateway> clazz() {
		return FCMGateway.class;
	}

	@Override
	public void createOrUpdate(FCMGateway e) throws StorageException {
		
		try {
			
			final IFCMGateway oe = get(e.getDomainKey());
			IFCMGateway ne;
			
			if(null == oe) {
				ne = new FCMGateway(e.getDomainKey());
			}else {
				ne = oe;
			}
			
			UOW.begin();
			
			ne.setDebug(e.isDebug());
			ne.setFcmKey(e.getFcmKey());
			ne.setUrl(e.getUrl());
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
	public EntityIterator<FCMGateway> load() throws StorageException {
		return new EntityIteratorImpl<>(FCMGateway.class, "domainKey");
	}

	@Override
	public EntityIterator<FCMGateway> load(String domainKey) throws StorageException {
		return new EntityIteratorImpl<>("domainKey", domainKey, "domainKey", FCMGateway.class);
	}

	@Override
	public long count() throws StorageException {
		return new CommonDAO<>(FCMGateway.class).count();
	}

	@Override
	public long count(String domainKey) throws StorageException {
		return new CommonDAO<>(FCMGateway.class).count("domainKey", domainKey);
	}

	@Override
	public void delete(String domainKey) throws StorageException {
		new CommonDAO<>(FCMGateway.class).delete("domainKey", domainKey);
	}

	@Override
	public FCMGateway get(String domainKey) throws StorageException {
		return new CommonDAO<>(FCMGateway.class).find(domainKey);
	}

	@Override
	public void delete() throws StorageException {
		new CommonDAO<>(FCMGateway.class).delete();
	}

}
