package io.boodskap.iot.spi.storage.jpa.dao;

import java.util.Collection;
import java.util.Date;

import io.boodskap.iot.DataType;
import io.boodskap.iot.PropertyTarget;
import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.dao.LookupDAO;
import io.boodskap.iot.model.ILookup;
import io.boodskap.iot.model.jpa.Lookup;
import io.boodskap.iot.model.jpa.LookupId;
import io.boodskap.iot.spi.storage.jpa.UOW;
import io.boodskap.iot.spi.storage.jpa.dao.util.CommonDAO;
import io.boodskap.iot.spi.storage.jpa.dao.util.EntityIteratorImpl;

public class LookupDAOImpl implements LookupDAO<Lookup> {
	
	private static final LookupDAO<Lookup> dao = new LookupDAOImpl();
	
	protected LookupDAOImpl() {
	}
	
	public static final LookupDAO<Lookup> get() {
		return dao;
	}

	@Override
	public Lookup create(String domainKey, PropertyTarget target, String targetId, String name) {
		return new Lookup(new LookupId(domainKey, target, targetId, name));
	}

	@Override
	public Class<? extends Lookup> clazz() {
		return Lookup.class;
	}

	@Override
	public void createOrUpdate(Lookup e) throws StorageException {
		
		try {
			
			final ILookup oe = get(e.getDomainKey(), e.getTarget(), e.getTargetId(), e.getName());
			ILookup ne;
			
			if(null == oe) {
				ne = new Lookup(new LookupId(e.getDomainKey(), e.getTarget(), e.getTargetId(), e.getName()));
			}else {
				ne = oe;
			}
			
			UOW.begin();
			
			ne.setType(e.getType());
			ne.setValue(e.getValue());
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
	public EntityIterator<Lookup> load() throws StorageException {
		return new EntityIteratorImpl<>(Lookup.class, "id.name");
	}

	@Override
	public EntityIterator<Lookup> load(String domainKey) throws StorageException {
		return new EntityIteratorImpl<>(Lookup.class, domainKey, "id.name");
	}

	@Override
	public long count() throws StorageException {
		return new CommonDAO<>(Lookup.class).count();
	}

	@Override
	public long count(String domainKey) throws StorageException {
		return new CommonDAO<>(Lookup.class).count(domainKey);
	}

	@Override
	public long count(String domainKey, PropertyTarget target) throws StorageException {
		return new CommonDAO<>(Lookup.class).count(domainKey, "target", target);
	}

	@Override
	public void delete(String domainKey) throws StorageException {
		new CommonDAO<>(Lookup.class).delete(domainKey);
	}

	@Override
	public void delete(String domainKey, PropertyTarget target) throws StorageException {
		new CommonDAO<>(Lookup.class).delete(domainKey, "target", target);
	}

	@Override
	public void delete(String domainKey, PropertyTarget target, String targetId) throws StorageException {
		new CommonDAO<>(Lookup.class).delete(domainKey, "target", target, "targetId", targetId);
	}

	@Override
	public void delete(String domainKey, PropertyTarget target, String targetId, String name) throws StorageException {
		new CommonDAO<>(Lookup.class).delete(domainKey, "target", target, "targetId", targetId, "name", name);
	}

	@Override
	public Lookup get(String domainKey, PropertyTarget target, String targetId, String name) throws StorageException {
		return new CommonDAO<>(Lookup.class).find(new LookupId(domainKey, target, targetId, name));
	}

	@Override
	public void set(String domainKey, PropertyTarget target, String targetId, DataType type, String name, String value) throws StorageException {
		Lookup e = new Lookup(new LookupId(domainKey, target, targetId, name));
		e.setType(type);
		e.setValue(value);
		createOrUpdate(e);
	}

	@Override
	public Collection<Lookup> list(String domainKey, PropertyTarget target, int page, int pageSize) throws StorageException {
		return new CommonDAO<>(Lookup.class).list(domainKey, "target", target, page, pageSize, "id.name");
	}

	@Override
	public Collection<Lookup> listNext(String domainKey, PropertyTarget target, String name, int page, int pageSize) throws StorageException {
		return list(domainKey, target, page, pageSize);
	}

	@Override
	public Collection<Lookup> search(String domainKey, PropertyTarget target, String query, int pageSize) throws StorageException {
		return new CommonDAO<>(Lookup.class).search(query, domainKey, "target", target, pageSize);
	}

	@Override
	public void delete() throws StorageException {
		new CommonDAO<>(Lookup.class).delete();
	}

}
