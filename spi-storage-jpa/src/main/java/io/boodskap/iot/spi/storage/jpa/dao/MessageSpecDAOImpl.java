package io.boodskap.iot.spi.storage.jpa.dao;

import java.util.Collection;
import java.util.Date;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.dao.MessageSpecDAO;
import io.boodskap.iot.model.IMessageField;
import io.boodskap.iot.model.IMessageSpecification;
import io.boodskap.iot.model.jpa.MessageField;
import io.boodskap.iot.model.jpa.MessageSpecification;
import io.boodskap.iot.model.jpa.MessageSpecificationId;
import io.boodskap.iot.spi.storage.jpa.UOW;
import io.boodskap.iot.spi.storage.jpa.dao.util.CommonDAO;
import io.boodskap.iot.spi.storage.jpa.dao.util.EntityIteratorImpl;

public class MessageSpecDAOImpl implements MessageSpecDAO<MessageSpecification> {
	
	private static final MessageSpecDAO<MessageSpecification> dao = new MessageSpecDAOImpl();

	protected MessageSpecDAOImpl() {
	}
	
	public static final MessageSpecDAO<MessageSpecification> get() {
		return dao;
	}

	@Override
	public MessageSpecification create(String domainKey, String specId) {
		return new MessageSpecification(new MessageSpecificationId(domainKey, specId));
	}

	@Override
	public Class<? extends MessageSpecification> clazz() {
		return MessageSpecification.class;
	}

	@Override
	public Class<? extends IMessageField> fieldClazz() {
		return MessageField.class;
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
	public void createOrUpdate(MessageSpecification e) throws StorageException {
		
		try {
			
			final IMessageSpecification oe = get(e.getDomainKey(), e.getSpecId());
			IMessageSpecification ne;
			
			if(null == oe) {
				ne = new MessageSpecification(new MessageSpecificationId(e.getDomainKey(), e.getSpecId()));
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
	public EntityIterator<MessageSpecification> load() throws StorageException {
		return new EntityIteratorImpl<MessageSpecification>(MessageSpecification.class, "id.specId");
	}

	@Override
	public EntityIterator<MessageSpecification> load(String domainKey) throws StorageException {
		return new EntityIteratorImpl<MessageSpecification>(MessageSpecification.class, domainKey, "id.specId");
	}

	@Override
	public long count() throws StorageException {
		return new CommonDAO<>(MessageSpecification.class).count();
	}

	@Override
	public long count(String domainKey) throws StorageException {
		return new CommonDAO<>(MessageSpecification.class).count(domainKey);
	}

	@Override
	public void delete(String domainKey) throws StorageException {
		new CommonDAO<>(MessageSpecification.class).delete(domainKey);
	}

	@Override
	public void delete(String domainKey, String specId) throws StorageException {
		new CommonDAO<>(MessageSpecification.class).delete(domainKey, "specId", specId);
	}

	@Override
	public MessageSpecification get(String domainKey, String specId) throws StorageException {
		return new CommonDAO<>(MessageSpecification.class).find(new MessageSpecificationId(domainKey, specId));
	}

	@Override
	public Collection<MessageSpecification> list(String domainKey, int page, int pageSize) throws StorageException {
		return new CommonDAO<MessageSpecification>(MessageSpecification.class).list(domainKey, page, pageSize, "id.specId");
	}

	@Override
	public Collection<MessageSpecification> listNext(String domainKey, String messageId, int page, int pageSize) throws StorageException {
		return list(domainKey, page, pageSize);
	}

	@Override
	public Collection<MessageSpecification> search(String domainKey, String query, int pageSize) throws StorageException {
		return new CommonDAO<MessageSpecification>(MessageSpecification.class).search(query, domainKey, pageSize);
	}

	@Override
	public void delete() throws StorageException {
		new CommonDAO<>(MessageSpecification.class).delete();
	}

}
