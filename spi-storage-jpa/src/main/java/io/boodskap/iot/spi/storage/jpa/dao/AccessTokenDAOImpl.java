package io.boodskap.iot.spi.storage.jpa.dao;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.AccessTokenDAO;
import io.boodskap.iot.model.jpa.AccessToken;
import io.boodskap.iot.model.jpa.Alexa;
import io.boodskap.iot.spi.storage.jpa.UOW;
import io.boodskap.iot.spi.storage.jpa.dao.util.CommonDAO;

public class AccessTokenDAOImpl implements AccessTokenDAO<AccessToken> {
	
	private static final AccessTokenDAO<AccessToken> instance = new AccessTokenDAOImpl();

	protected AccessTokenDAOImpl() {
	}
	
	public static AccessTokenDAO<AccessToken> get() {
		return instance;
	}

	@Override
	public AccessToken create(String token) {
		return new AccessToken(token);
	}

	@Override
	public void createOrUpdate(AccessToken e) throws StorageException {
		
		try {
			
			final AccessToken oe = get(e.getToken());
			final AccessToken ne;
			
			if(null == oe) {
				ne = new AccessToken(e.getToken());
			}else {
				ne = oe;
			}
			
			UOW.begin();
			
			ne.copy(e);
			
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
	public AccessToken get(String token) throws StorageException {
		return new CommonDAO<>(AccessToken.class).find(token);
	}

	public void delete(String token) throws StorageException {
		new CommonDAO<>(Alexa.class).delete("token", token);
	}

}
