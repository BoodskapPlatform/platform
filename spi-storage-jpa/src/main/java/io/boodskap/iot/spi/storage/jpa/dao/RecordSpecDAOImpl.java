package io.boodskap.iot.spi.storage.jpa.dao;

import java.util.Collection;
import java.util.Date;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.dao.RecordSpecDAO;
import io.boodskap.iot.model.IRecordField;
import io.boodskap.iot.model.IRecordSpecification;
import io.boodskap.iot.model.jpa.RecordField;
import io.boodskap.iot.model.jpa.RecordSpecification;
import io.boodskap.iot.model.jpa.RecordSpecificationId;
import io.boodskap.iot.spi.storage.jpa.UOW;
import io.boodskap.iot.spi.storage.jpa.dao.util.CommonDAO;
import io.boodskap.iot.spi.storage.jpa.dao.util.EntityIteratorImpl;

public class RecordSpecDAOImpl implements RecordSpecDAO<RecordSpecification> {
	
	private static final RecordSpecDAO<RecordSpecification> dao = new RecordSpecDAOImpl();
	
	protected RecordSpecDAOImpl() {
	}
	
	public static final RecordSpecDAO<RecordSpecification> get() {
		return dao;
	}

	@Override
	public RecordSpecification create(String domainKey, String specId) {
		return new RecordSpecification(new RecordSpecificationId(domainKey, specId));
	}

	@Override
	public Class<? extends RecordSpecification> clazz() {
		return RecordSpecification.class;
	}

	@Override
	public void createOrUpdate(RecordSpecification e) throws StorageException {
		
		try {
			
			final IRecordSpecification oe = get(e.getDomainKey(), e.getSpecId());
			IRecordSpecification ne;
			
			if(null == oe) {
				ne = new RecordSpecification(new RecordSpecificationId(e.getDomainKey(), e.getSpecId()));
				ne.setCreatedStamp(new Date());
			}else {
				ne = oe;
			}
			
			UOW.begin();
			
			ne.setDescription(e.getDescription());
			ne.setFields(e.getFields());
			ne.setName(e.getName());
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
	public Class<? extends IRecordField> fieldClazz() {
		return RecordField.class;
	}

	@Override
	public boolean canAddField() {
		return true;
	}

	@Override
	public boolean canDropField() {
		return true;
	}

	@Override
	public boolean canModifyField() {
		return true;
	}

	@Override
	public EntityIterator<RecordSpecification> load() throws StorageException {
		return new EntityIteratorImpl<>(RecordSpecification.class, "id.specId");
	}

	@Override
	public EntityIterator<RecordSpecification> load(String domainKey) throws StorageException {
		return new EntityIteratorImpl<>(RecordSpecification.class, domainKey, "id.specId");
	}

	@Override
	public long count() throws StorageException {
		return new CommonDAO<>(RecordSpecification.class).count();
	}

	@Override
	public long count(String domainKey) throws StorageException {
		return new CommonDAO<>(RecordSpecification.class).count(domainKey);
	}

	@Override
	public RecordSpecification get(String domainKey, String specId) throws StorageException {
		return new CommonDAO<>(RecordSpecification.class).find(new RecordSpecificationId(domainKey, specId));
	}

	@Override
	public void delete(String domainKey) throws StorageException {
		new CommonDAO<>(RecordSpecification.class).delete(domainKey);
	}

	@Override
	public void delete(String domainKey, String specId) throws StorageException {
		new CommonDAO<>(RecordSpecification.class).delete(domainKey, "specId", specId);
	}

	@Override
	public Collection<RecordSpecification> list(String domainKey, int page, int pageSize) throws StorageException {
		return new CommonDAO<>(RecordSpecification.class).list(domainKey, page, pageSize, "id.specId");
	}

	@Override
	public Collection<RecordSpecification> listNext(String domainKey, String specId, int page, int pageSize) throws StorageException {
		return list(domainKey, page, pageSize);
	}

	@Override
	public Collection<RecordSpecification> search(String domainKey, String query, int pageSize) throws StorageException {
		return new CommonDAO<>(RecordSpecification.class).searchData(query, domainKey, pageSize);
	}

	@Override
	public void delete() throws StorageException {
		new CommonDAO<>(RecordSpecification.class).delete();
	}

}
