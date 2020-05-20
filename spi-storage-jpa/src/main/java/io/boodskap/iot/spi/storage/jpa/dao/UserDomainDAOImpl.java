package io.boodskap.iot.spi.storage.jpa.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.dao.UserDomainDAO;
import io.boodskap.iot.model.IUserDomain;
import io.boodskap.iot.model.jpa.UserDomain;
import io.boodskap.iot.model.jpa.UserDomainId;
import io.boodskap.iot.spi.storage.jpa.UOW;
import io.boodskap.iot.spi.storage.jpa.dao.util.CommonDAO;
import io.boodskap.iot.spi.storage.jpa.dao.util.EntityIteratorImpl;

public class UserDomainDAOImpl implements UserDomainDAO<UserDomain> {
	
	private static final UserDomainDAO<UserDomain> dao = new UserDomainDAOImpl();

	protected UserDomainDAOImpl() {
	}
	
	public static final UserDomainDAO<UserDomain> get() {
		return dao;
	}

	@Override
	public UserDomain create(String userId, String domainKey) {
		return new UserDomain(new UserDomainId(userId, domainKey));
	}

	@Override
	public Class<? extends UserDomain> clazz() {
		return UserDomain.class;
	}

	@Override
	public void createOrUpdate(UserDomain e) throws StorageException {
		
		try {
			
			final IUserDomain oe = get(e.getUserId(), e.getDomainKey());
			IUserDomain ne;
			
			if(null == oe) {
				ne = new UserDomain(new UserDomainId(e.getUserId(), e.getDomainKey()));
				ne.setCreatedStamp(new Date());
			}else {
				ne = oe;
			}
			
			UOW.begin();
			
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
	public EntityIterator<UserDomain> load() throws StorageException {
		return new EntityIteratorImpl<>(UserDomain.class, "id.userId");
	}

	@Override
	public EntityIterator<UserDomain> load(String domainKey) throws StorageException {
		return new EntityIteratorImpl<>(UserDomain.class, domainKey, "id.userId");
	}

	@Override
	public long count() throws StorageException {
		return new CommonDAO<>(UserDomain.class).count();
	}

	@Override
	public long count(String domainKey) throws StorageException {
		return new CommonDAO<>(UserDomain.class).count(domainKey);
	}

	@Override
	public long countDomains(String userId) throws StorageException {
		return new CommonDAO<>(UserDomain.class).count("id.userId", userId);
	}

	@Override
	public void delete(String domainKey) throws StorageException {
		new CommonDAO<>(UserDomain.class).delete(domainKey);
	}

	@Override
	public void deleteDomains(String userId) throws StorageException {
		new CommonDAO<>(UserDomain.class).delete("id.userId", userId);
	}

	@Override
	public void delete(String userId, String domainKey) throws StorageException {
		new CommonDAO<>(UserDomain.class).delete(domainKey, "userId", userId);
	}

	@Override
	public UserDomain get(String userId, String domainKey) throws StorageException {
		return new CommonDAO<>(UserDomain.class).find(new UserDomainId(userId, domainKey));
	}

	@Override
	public Collection<UserDomain> list(String userId) throws StorageException {
		Map<String, Serializable> params = new HashMap<>();
		params.put("uid", userId);
		return  new CommonDAO<>(UserDomain.class).list("SELECT v FROM UserDomain v WHERE v.id.userId=:uid", params);
	}

	@Override
	public void delete() throws StorageException {
		new CommonDAO<>(UserDomain.class).delete();
	}

}
