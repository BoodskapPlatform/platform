package io.boodskap.iot.spi.storage.jpa.dao;

import java.util.Date;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.EmailGatewayDAO;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.model.IEmailGateway;
import io.boodskap.iot.model.jpa.EmailGateway;
import io.boodskap.iot.spi.storage.jpa.UOW;
import io.boodskap.iot.spi.storage.jpa.dao.util.CommonDAO;
import io.boodskap.iot.spi.storage.jpa.dao.util.EntityIteratorImpl;

public class EmailGatewayDAOImpl implements EmailGatewayDAO<EmailGateway> {
	
	private static final EmailGatewayDAO<EmailGateway> dao = new EmailGatewayDAOImpl();
	
	protected EmailGatewayDAOImpl() {
	}
	
	public static final EmailGatewayDAO<EmailGateway> get() {
		return dao;
	}

	@Override
	public EmailGateway create(String domainKey) {
		return new EmailGateway(domainKey);
	}

	@Override
	public Class<? extends EmailGateway> clazz() {
		return EmailGateway.class;
	}

	@Override
	public void createOrUpdate(EmailGateway e) throws StorageException {
		
		try {
			
			final IEmailGateway oe = get(e.getDomainKey());
			IEmailGateway ne;
			
			if(null == oe) {
				ne = new EmailGateway(e.getDomainKey());
				ne.setCreatedStamp(new Date());
			}else {
				ne = oe;
			}
			
			UOW.begin();
			
			ne.setBounceEmail(e.getBounceEmail());
			ne.setDebug(e.isDebug());
			ne.setHost(e.getHost());
			ne.setName(e.getName());
			ne.setPassword(e.getPassword());
			ne.setPort(e.getPort());
			ne.setPrimaryEmail(e.getPrimaryEmail());
			ne.setSsl(e.isSsl());
			ne.setTls(e.isTls());
			ne.setUser(e.getUser());
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
	public EntityIterator<EmailGateway> load() throws StorageException {
		return new EntityIteratorImpl<>(EmailGateway.class, "domainKey");
	}

	@Override
	public EntityIterator<EmailGateway> load(String domainKey) throws StorageException {
		return new EntityIteratorImpl<>("domainKey", domainKey, "domainKey", EmailGateway.class);
	}

	@Override
	public long count() throws StorageException {
		return new CommonDAO<>(EmailGateway.class).count();
	}

	@Override
	public long count(String domainKey) throws StorageException {
		return new CommonDAO<>(EmailGateway.class).count("domainKey", domainKey);
	}

	@Override
	public void delete(String domainKey) throws StorageException {
		new CommonDAO<>(EmailGateway.class).delete("domainKey", domainKey);
	}

	@Override
	public EmailGateway get(String domainKey) throws StorageException {
		return new CommonDAO<>(EmailGateway.class).find(domainKey);
	}

	@Override
	public void delete() throws StorageException {
		new CommonDAO<>(EmailGateway.class).delete();
	}

}
