package io.boodskap.iot.spi.storage.jpa.dao;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.TypedQuery;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.dao.UserDAO;
import io.boodskap.iot.model.IUser;
import io.boodskap.iot.model.jpa.User;
import io.boodskap.iot.model.jpa.UserId;
import io.boodskap.iot.spi.storage.jpa.UOW;
import io.boodskap.iot.spi.storage.jpa.dao.util.CommonDAO;
import io.boodskap.iot.spi.storage.jpa.dao.util.EntityIteratorImpl;

public class UserDAOImpl implements UserDAO<User> {
	
	private static final UserDAO<User> dao = new UserDAOImpl();

	protected UserDAOImpl() {
	}
	
	public static UserDAO<User> get() {
		return dao;
	}

	@Override
	public User create(String domainKey, String userId) {
		return new User(new UserId(domainKey, userId));
	}

	@Override
	public Class<? extends User> clazz() {
		return User.class;
	}

	@Override
	public void createOrUpdate(User e) throws StorageException {
		
		try {
			
			final IUser oe = get(e.getDomainKey(), e.getUserId());
			IUser ne;
			
			if(null == oe) {
				ne = new User(new UserId(e.getDomainKey(), e.getUserId()));
				ne.setRegisteredStamp(new Date());
			}else {
				ne = oe;
			}
			
			UOW.begin();
			
			ne.setAddress(e.getAddress());
			ne.setCity(e.getCity());
			ne.setCountry(e.getCountry());
			ne.setDescription(e.getDescription());
			ne.setEmail(e.getEmail());
			ne.setFirstName(e.getFirstName());
			ne.setLastName(e.getLastName());
			ne.setLocale(e.getLocale());
			ne.setName(e.getName());
			ne.setPassword(e.getPassword());
			ne.setPrimaryPhone(e.getPrimaryPhone());
			ne.setState(e.getState());
			ne.setTimeZone(e.getTimeZone());
			ne.setUpdatedStamp(new Date());
			ne.setWorkHourEnd(e.getWorkHourEnd());
			ne.setWorkHourStart(e.getWorkHourStart());
			ne.setZipcode(e.getZipcode());
			ne.setWorkDays(e.getWorkDays());
			
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
	public EntityIterator<User> load() throws StorageException {
		return new EntityIteratorImpl<User>(User.class, "registeredStamp");
	}

	@Override
	public EntityIterator<User> load(String domainKey) throws StorageException {
		return new EntityIteratorImpl<User>(User.class, domainKey, "registeredStamp");
	}

	@Override
	public long count() throws StorageException {
		return new CommonDAO<>(User.class).count();
	}

	@Override
	public long count(String domainKey) throws StorageException {
		return new CommonDAO<>(User.class).count(domainKey);
	}

	@Override
	public void delete(String domainKey) throws StorageException {
		new CommonDAO<>(User.class).delete(domainKey);
	}

	@Override
	public void delete(String domainKey, String userId) throws StorageException {
		new CommonDAO<>(User.class).delete(domainKey, "userId", userId);
	}

	@Override
	public User get(String userId) throws StorageException {
		TypedQuery<User> q = UOW.createQuery("select u from User u where u.id.userId=:uid", User.class);
		q.setParameter("uid", userId);
		q.setFirstResult(0);
		q.setMaxResults(1);
		List<User> list = q.getResultList();
		return list.isEmpty() ? null : list.get(0);
	}

	@Override
	public User get(String domainKey, String userId) throws StorageException {
		return new CommonDAO<User>(User.class).find(new UserId(domainKey, userId));
	}

	@Override
	public Collection<User> list(String domainKey, int page, int pageSize) throws StorageException {
		return new CommonDAO<User>(User.class).list(domainKey, page, pageSize, "registeredStamp");
	}

	@Override
	public Collection<User> listNext(String domainKey, String userId, int page, int pageSize)throws StorageException {
		return list(domainKey, page, pageSize);
	}

	@Override
	public Collection<User> search(String domainKey, String query, int pageSize) throws StorageException {
		return new CommonDAO<User>(User.class).search(query, domainKey, pageSize);
	}

	@Override
	public void delete() throws StorageException {
		new CommonDAO<>(User.class).delete();
	}

}
