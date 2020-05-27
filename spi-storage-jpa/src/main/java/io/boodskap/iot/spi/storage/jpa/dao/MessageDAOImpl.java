package io.boodskap.iot.spi.storage.jpa.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.dao.MessageDAO;
import io.boodskap.iot.model.IMessage;
import io.boodskap.iot.model.jpa.DynamicMessageField;
import io.boodskap.iot.model.jpa.Message;
import io.boodskap.iot.model.jpa.MessageId;
import io.boodskap.iot.spi.storage.jpa.UOW;
import io.boodskap.iot.spi.storage.jpa.dao.util.CommonDAO;
import io.boodskap.iot.spi.storage.jpa.dao.util.EntityIteratorImpl;

public class MessageDAOImpl implements MessageDAO<Message> {
	
	private static final MessageDAO<Message> dao = new MessageDAOImpl();

	protected MessageDAOImpl() {
	}
	
	public static final MessageDAO<Message> get() {
		return dao;
	}

	@Override
	public Message create(String domainKey, String specId, String messageId) {
		return new Message(new MessageId(domainKey, specId, messageId));
	}

	@Override
	public Class<? extends Message> clazz() {
		return Message.class;
	}

	@Override
	public void createOrUpdate(Message e) throws StorageException {
		
		try {
			
			final IMessage oe = get(e.getDomainKey(), e.getSpecId(), e.getMessageId());
			IMessage ne = oe;
			
			if(null == ne) {
				ne = new Message(new MessageId(e.getDomainKey(), e.getSpecId(), e.getMessageId()));
			}else {
				ne = oe;
			}
			
			UOW.begin();
			
			ne.setDataChannel(e.getDataChannel());
			ne.setDeviceId(e.getDeviceId());
			ne.setIpAddress(e.getIpAddress());
			ne.setNodeId(e.getNodeId());
			ne.setNodeUid(e.getNodeUid());
			ne.setPort(e.getPort());
			
			if(null == oe) {
				UOW.persist(ne);
			}
			
			UOW.commit();
			
			UOW.begin();
			
			ne.setFields(e.getFields());

			if(null == oe) {
				ne.getFields().forEach(f -> {
					
					UOW.persist(f);
				});
			}
			
			UOW.commit();
			
		}catch(Exception ex) {
			UOW.rollback();
			throw new StorageException(ex);
		}
	}

	@Override
	public void updateState(IMessage e) throws StorageException {
		
		try {
			
			final IMessage ne = get(e.getDomainKey(), e.getSpecId(), e.getMessageId());
			
			UOW.begin();
			
			ne.setState(e.getState());
			ne.setTrace(e.getTrace());
			
			UOW.commit();
			
		}catch(Exception ex) {
			UOW.rollback();
			throw new StorageException(ex);
		}
	}

	@Override
	public EntityIterator<Message> load() throws StorageException {
		return new EntityIteratorImpl<Message>(Message.class, "createdStamp");
	}

	@Override
	public EntityIterator<Message> load(String domainKey) throws StorageException {
		return new EntityIteratorImpl<Message>(Message.class, domainKey, "createdStamp");
	}

	@Override
	public long count() throws StorageException {
		return new CommonDAO<>(Message.class).count();
	}

	@Override
	public long count(String domainKey) throws StorageException {
		return new CommonDAO<>(Message.class).count(domainKey);
	}

	@Override
	public long count(String domainKey, String specId) throws StorageException {
		return new CommonDAO<>(Message.class).count(domainKey, "specId", specId);
	}

	@Override
	public Message get(String domainKey, String specId, String id) throws StorageException {
		return new CommonDAO<>(Message.class).find(new MessageId(domainKey, specId, id));
	}

	@Override
	public void delete(String domainKey) throws StorageException {
		new CommonDAO<>(Message.class).delete(domainKey);
	}

	@Override
	public void delete(String domainKey, String specId) throws StorageException {
		new CommonDAO<>(Message.class).delete(domainKey, "specId", specId);
	}

	@Override
	public void delete(String domainKey, String specId, String id) throws StorageException {
		new CommonDAO<>(Message.class).delete(domainKey, "specId", specId, "messageId", id);
	}

	@Override
	public Collection<Message> list(String domainKey, String specId, int page, int pageSize) throws StorageException {
		return new CommonDAO<Message>(Message.class).list(domainKey, "specId", specId, page, pageSize, "createdStamp");
	}

	@Override
	public Collection<Message> listNext(String domainKey, String specId, String id, int page, int pageSize)throws StorageException {
		return list(domainKey, specId, page, pageSize);
	}

	@Override
	public Collection<Message> search(String domainKey, String specId, String query, int pageSize)throws StorageException {
		Collection<DynamicMessageField> fields = new CommonDAO<DynamicMessageField>(DynamicMessageField.class).searchData(query, domainKey, pageSize);
		Set<Message> messages = new HashSet<>();
		fields.forEach(f -> {
			messages.add(get(f.getDomainKey(), f.getSpecId(), f.getMessageId()));
		});
		return new ArrayList<>(messages);
	}

	@Override
	public void delete() throws StorageException {
		new CommonDAO<>(Message.class).delete();
	}

}
