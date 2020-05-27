package io.boodskap.iot.spi.storage.jpa.dao;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Query;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.dao.LinkedDomainDAO;
import io.boodskap.iot.model.ILinkedDomain;
import io.boodskap.iot.model.jpa.LinkedDomain;
import io.boodskap.iot.model.jpa.LinkedDomainId;
import io.boodskap.iot.spi.storage.jpa.UOW;
import io.boodskap.iot.spi.storage.jpa.dao.util.CommonDAO;
import io.boodskap.iot.spi.storage.jpa.dao.util.EntityIteratorImpl;

public class LinkedDomainDAOImpl implements LinkedDomainDAO<LinkedDomain> {
	
	private static final LinkedDomainDAO<LinkedDomain> dao = new LinkedDomainDAOImpl();
	
	protected LinkedDomainDAOImpl() {
	}
	
	public static final LinkedDomainDAO<LinkedDomain> get() {
		return dao;
	}

	@Override
	public LinkedDomain create(String domainKey, String linkedDomainKey, String linkedApiKey) {
		return new LinkedDomain(new LinkedDomainId(domainKey, linkedDomainKey, linkedApiKey));
	}

	@Override
	public Class<? extends LinkedDomain> clazz() {
		return LinkedDomain.class;
	}

	@Override
	public void createOrUpdate(LinkedDomain e) throws StorageException {
		
		try {
			
			final ILinkedDomain oe = get(e.getDomainKey(), e.getLinkedDomainKey(), e.getLinkedApiKey());
			ILinkedDomain ne;
			
			if(null == oe) {
				ne = new LinkedDomain(new LinkedDomainId(e.getDomainKey(), e.getLinkedDomainKey(), e.getLinkedApiKey()));
			}else {
				ne = oe;
			}
			
			UOW.begin();
			
			ne.setDisabled(e.isDisabled());
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
	public void setState(String domainKey, String linkedDomainKey, boolean state) throws StorageException {
		
		try {
			
			if(count(domainKey, linkedDomainKey) <= 0) {
				throw new StorageException(String.format("Domain %s.%s is not linked", domainKey, linkedDomainKey));
			}
			
			UOW.begin();

			Query query = UOW.createQuery("UPDATE LinkedDomain v SET v.disabled=:dis WHERE v.id.domainKey=:dkey AND v.id.linkedDomainKey=:ldkey");
			query.setParameter("dis", state);
			query.setParameter("dkey", domainKey);
			query.setParameter("ldkey", linkedDomainKey);
			
			query.executeUpdate();
			
			UOW.commit();
			
		}catch(Exception ex) {
			UOW.rollback();
			throw new StorageException(ex);
		}
	}

	@Override
	public void setState(String domainKey, String linkedDomainKey, String linkedApiKey, boolean state) throws StorageException {
		
		try {
			
			final ILinkedDomain oe = get(domainKey, linkedDomainKey, linkedApiKey);
			
			if(null == oe) {
				throw new StorageException(String.format("Domain %s.%s.%s is not linked", domainKey, linkedDomainKey, linkedApiKey));
			}

			UOW.begin();

			oe.setDisabled(state);
			
			UOW.commit();
			
		}catch(Exception ex) {
			UOW.rollback();
			throw new StorageException(ex);
		}
	}

	@Override
	public EntityIterator<LinkedDomain> load() throws StorageException {
		return new EntityIteratorImpl<>(LinkedDomain.class, "id.linkedDomainKey");
	}

	@Override
	public EntityIterator<LinkedDomain> load(String domainKey) throws StorageException {
		return new EntityIteratorImpl<>(LinkedDomain.class, domainKey, "id.linkedDomainKey");
	}

	@Override
	public long count() throws StorageException {
		return new CommonDAO<>(LinkedDomain.class).count();
	}

	@Override
	public long count(String domainKey) throws StorageException {
		return new CommonDAO<>(LinkedDomain.class).count(domainKey);
	}

	@Override
	public long count(String domainKey, String linkedDomainKey) throws StorageException {
		return new CommonDAO<>(LinkedDomain.class).count(domainKey, "linkedDomainKey", linkedDomainKey);
	}

	@Override
	public long countLinked(String linkedDomainKey) throws StorageException {
		return new CommonDAO<>(LinkedDomain.class).count("id.linkedDomainKey", linkedDomainKey);
	}

	@Override
	public LinkedDomain get(String domainKey, String linkedDomainKey, String linkedApiKey) throws StorageException {
		return new CommonDAO<>(LinkedDomain.class).find(new LinkedDomainId(domainKey, linkedDomainKey, linkedApiKey));
	}

	@Override
	public void delete(String domainKey) throws StorageException {
		new CommonDAO<>(LinkedDomain.class).delete(domainKey);
	}

	@Override
	public void delete(String domainKey, String linkedDomainKey) throws StorageException {
		new CommonDAO<>(LinkedDomain.class).delete(domainKey, "linkedDomainKey", linkedDomainKey);
	}

	@Override
	public void delete(String domainKey, String linkedDomainKey, String linkedApiKey) throws StorageException {
		new CommonDAO<>(LinkedDomain.class).delete(domainKey, "linkedDomainKey", linkedDomainKey, "linkedApiKey", linkedApiKey);
	}

	@Override
	public Collection<LinkedDomain> list(String linkedDomainKey, int page, int pageSize) throws StorageException {
		return new CommonDAO<>(LinkedDomain.class).list("linkedDomainKey", linkedDomainKey, page, pageSize, "id.linkedApiKey");
	}

	@Override
	public Collection<LinkedDomain> listNext(String linkedDomainKey, String domainKey, int page, int pageSize) throws StorageException {
		return list(linkedDomainKey, page, pageSize);
	}

	@Override
	public Collection<LinkedDomain> listLinked(String domainKey, int page, int pageSize) throws StorageException {
		return new CommonDAO<>(LinkedDomain.class).list(domainKey, page, pageSize, "id.linkedDomainKey");
	}

	@Override
	public Collection<LinkedDomain> listLinkedNext(String domainKey, String linkedDomainKey, int page, int pageSize) throws StorageException {
		return listLinked(linkedDomainKey, page, pageSize);
	}

	@Override
	public void delete() throws StorageException {
		new CommonDAO<>(LinkedDomain.class).delete();
	}

}
