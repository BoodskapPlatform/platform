package io.boodskap.iot.spi.storage.jpa.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.dao.RecordDAO;
import io.boodskap.iot.model.IDynamicRecordField;
import io.boodskap.iot.model.IRecord;
import io.boodskap.iot.model.jpa.DynamicRecordField;
import io.boodskap.iot.model.jpa.Record;
import io.boodskap.iot.model.jpa.RecordId;
import io.boodskap.iot.spi.storage.jpa.UOW;
import io.boodskap.iot.spi.storage.jpa.dao.util.CommonDAO;
import io.boodskap.iot.spi.storage.jpa.dao.util.EntityIteratorImpl;

public class RecordDAOImpl implements RecordDAO<Record> {
	
	private static final RecordDAO<Record> dao = new RecordDAOImpl();

	protected RecordDAOImpl() {
	}
	
	public static final RecordDAO<Record> get() {
		return dao;
	}

	@Override
	public Record create(String domainKey, String specId, String recordId) {
		return new Record(new RecordId(domainKey, specId, recordId));
	}

	@Override
	public Class<? extends Record> clazz() {
		return Record.class;
	}

	@Override
	public void createOrUpdate(Record e) throws StorageException {
		
		try {
			
			final IRecord oe = get(e.getDomainKey(), e.getSpecId(), e.getRecordId());
			IRecord ne;
			
			if(null == oe) {
				ne = new Record(new RecordId(e.getDomainKey(), e.getSpecId(), e.getRecordId()));
			}else {
				ne = oe;
			}
			
			UOW.begin();

			if(null == oe) {
				UOW.persist(ne);
			}
			
			UOW.commit();
			
			UOW.begin();
			
			ne.setFields(e.getFields());
			
			ne.getFields().forEach(f -> {
				if(null == oe) {
					UOW.persist(f);
				}
			});
			
			UOW.commit();
			
		}catch(Exception ex) {
			UOW.rollback();
			throw new StorageException(ex);
		}
	}

	@Override
	public EntityIterator<Record> load() throws StorageException {
		return new EntityIteratorImpl<Record>(Record.class, "createdStamp");
	}

	@Override
	public EntityIterator<Record> load(String domainKey) throws StorageException {
		return new EntityIteratorImpl<Record>(Record.class, domainKey, "createdStamp");
	}

	@Override
	public long count() throws StorageException {
		return new CommonDAO<>(Record.class).count();
	}

	@Override
	public long count(String domainKey) throws StorageException {
		return new CommonDAO<>(Record.class).count(domainKey);
	}

	@Override
	public long count(String domainKey, String specId) throws StorageException {
		return new CommonDAO<>(Record.class).count(domainKey, "specId", specId);
	}

	@Override
	public Record get(String domainKey, String specId, String id) throws StorageException {
		return new CommonDAO<>(Record.class).find(new RecordId(domainKey, specId, id));
	}

	@Override
	public void delete(String domainKey) throws StorageException {
		new CommonDAO<>(Record.class).delete(domainKey);
	}

	@Override
	public void delete(String domainKey, String specId) throws StorageException {
		new CommonDAO<>(Record.class).delete(domainKey, "specId", specId);
	}

	@Override
	public void delete(String domainKey, String specId, String id) throws StorageException {
		new CommonDAO<>(Record.class).delete(domainKey, "specId", specId, "id.recordId", id);
	}

	@Override
	public Collection<Record> list(String domainKey, String specId, int page, int pageSize) throws StorageException {
		return new CommonDAO<Record>(Record.class).list(domainKey, "specId", specId, page, pageSize, "createdStamp");
	}

	@Override
	public Collection<Record> listNext(String domainKey, String specId, String id, int page, int pageSize)throws StorageException {
		return list(domainKey, specId, page, pageSize);
	}

	@Override
	public Collection<Record> search(String domainKey, String specId, String query, int pageSize)throws StorageException {
		Collection<DynamicRecordField> fields = new CommonDAO<DynamicRecordField>(DynamicRecordField.class).searchData(query, domainKey, "specId", specId, pageSize);
		Set<Record> records = new HashSet<>();
		fields.forEach(f -> {
			records.add(get(f.getDomainKey(), f.getSpecId(), f.getRecordId()));
		});
		return new ArrayList<>(records);
	}

	@Override
	public IDynamicRecordField createField() {
		return new DynamicRecordField();
	}

	@Override
	public void delete() throws StorageException {
		new CommonDAO<>(DynamicRecordField.class).delete();
	}

}
